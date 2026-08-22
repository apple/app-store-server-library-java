// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.util;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.Time;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.DefaultSignedAttributeTableGenerator;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Generates a throwaway "Apple-like" RSA PKI (root, WWDR intermediate, receipt
 * signing leaf) and CMS-signs synthetic legacy app receipts with it, so
 * {@link com.apple.itunes.storekit.verification.AppReceiptVerifier} can be
 * exercised without any real Apple key material or a checked-in receipt.
 */
public class ReceiptCreator {

    private static final String WWDR_INTERMEDIATE_OID = "1.2.840.113635.100.6.2.1";
    private static final String RECEIPT_SIGNER_OID = "1.2.840.113635.100.6.11.1";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final long DAY_IN_MILLIS = 86_400_000L;
    private static final AtomicLong SERIAL = new AtomicLong(1);
    private static final BouncyCastleProvider BOUNCY_CASTLE_PROVIDER = new BouncyCastleProvider();

    /** Leaf first, then intermediate, then root; a self-signed creator holds one entry. */
    private final List<X509Certificate> chain;
    private final PrivateKey signingKey;

    private ReceiptCreator(List<X509Certificate> chain, PrivateKey signingKey) {
        this.chain = chain;
        this.signingKey = signingKey;
    }

    /**
     * A chain carrying both Apple marker OIDs, with a validity window wide
     * enough to cover any plausible receipt creation date — the chain of a
     * receipt is evaluated at the date the receipt was created, not now.
     */
    public static ReceiptCreator createReceiptCreator() throws Exception {
        return createReceiptCreator(true, true, tenYearsAgo(), inOneYear());
    }

    /**
     * @param receiptSignerOid Whether the leaf carries the receipt-signing marker OID
     * @param wwdrIntermediateOid Whether the intermediate carries the WWDR marker OID
     * @param notBefore The start of the validity window of every certificate in the chain
     * @param notAfter The end of the validity window of every certificate in the chain
     */
    public static ReceiptCreator createReceiptCreator(boolean receiptSignerOid, boolean wwdrIntermediateOid, Date notBefore, Date notAfter) throws Exception {
        KeyPair rootKeyPair = rsaKeyPair();
        KeyPair intermediateKeyPair = rsaKeyPair();
        KeyPair leafKeyPair = rsaKeyPair();
        X509Certificate root = certificate("CN=Test App Store Root CA", rootKeyPair.getPublic(), "CN=Test App Store Root CA", rootKeyPair.getPrivate(), true, null, notBefore, notAfter);
        X509Certificate intermediate = certificate("CN=Test WWDR CA", intermediateKeyPair.getPublic(), "CN=Test App Store Root CA", rootKeyPair.getPrivate(), true, wwdrIntermediateOid ? WWDR_INTERMEDIATE_OID : null, notBefore, notAfter);
        X509Certificate leaf = certificate("CN=Test Receipt Signing", leafKeyPair.getPublic(), "CN=Test WWDR CA", intermediateKeyPair.getPrivate(), false, receiptSignerOid ? RECEIPT_SIGNER_OID : null, notBefore, notAfter);
        return new ReceiptCreator(List.of(leaf, intermediate, root), leafKeyPair.getPrivate());
    }

    /**
     * A single self-signed certificate, as an Xcode-generated receipt carries;
     * such a receipt is never chain verified.
     */
    public static ReceiptCreator createSelfSignedReceiptCreator() throws Exception {
        KeyPair keyPair = rsaKeyPair();
        X509Certificate certificate = certificate("CN=Test Xcode Receipt Signing", keyPair.getPublic(), "CN=Test Xcode Receipt Signing", keyPair.getPrivate(), false, RECEIPT_SIGNER_OID, tenYearsAgo(), inOneYear());
        return new ReceiptCreator(List.of(certificate), keyPair.getPrivate());
    }

    /** The root of this chain, in the form the verifier's constructor accepts. */
    public InputStream getRootCertificate() throws CertificateEncodingException {
        return new ByteArrayInputStream(chain.get(chain.size() - 1).getEncoded());
    }

    /** CMS-signs {@code payload} as encapsulated content, embedding the whole chain. */
    public byte[] signReceipt(byte[] payload) throws Exception {
        return signReceipt(payload, chain.size(), new Date());
    }

    /**
     * @param embeddedCertificates How many certificates of the chain, starting at
     *                             the leaf, to embed in the container
     */
    public byte[] signReceipt(byte[] payload, int embeddedCertificates) throws Exception {
        return signReceipt(payload, embeddedCertificates, new Date());
    }

    /**
     * @param signingTime The CMS signing time attribute, which must fall inside
     *                    the signer certificate's validity window for the
     *                    signature to verify — an old receipt signed by a since
     *                    expired certificate needs its original signing time
     */
    public byte[] signReceipt(byte[] payload, Date signingTime) throws Exception {
        return signReceipt(payload, chain.size(), signingTime);
    }

    /**
     * @param signatureAlgorithm The algorithm the signer signs with and names in
     *                           the signer info, e.g. a digest Apple does not use
     */
    public byte[] signReceipt(byte[] payload, String signatureAlgorithm) throws Exception {
        return signReceipt(payload, chain, new Date(), signatureAlgorithm);
    }

    /**
     * A receipt embedding unrelated certificates on top of the chain, as one
     * bloated to make chain assembly expensive carries.
     */
    public byte[] signReceiptWithPadding(byte[] payload, int paddingCertificates) throws Exception {
        List<X509Certificate> embedded = new ArrayList<>(chain);
        for (int i = 0; i < paddingCertificates; i++) {
            KeyPair keyPair = rsaKeyPair();
            embedded.add(certificate("CN=Padding " + i, keyPair.getPublic(), "CN=Test WWDR CA", keyPair.getPrivate(), false, null, tenYearsAgo(), inOneYear()));
        }
        return signReceipt(payload, embedded, new Date(), SIGNATURE_ALGORITHM);
    }

    /** A receipt signed by the leaf but embedding only the certificates above it. */
    public byte[] signReceiptWithoutSignerCertificate(byte[] payload) throws Exception {
        return signReceipt(payload, chain.subList(1, chain.size()), new Date(), SIGNATURE_ALGORITHM);
    }

    private byte[] signReceipt(byte[] payload, int embeddedCertificates, Date signingTime) throws Exception {
        return signReceipt(payload, chain.subList(0, embeddedCertificates), signingTime, SIGNATURE_ALGORITHM);
    }

    private byte[] signReceipt(byte[] payload, List<X509Certificate> embedded, Date signingTime, String signatureAlgorithm) throws Exception {
        ASN1EncodableVector signedAttributes = new ASN1EncodableVector();
        signedAttributes.add(new Attribute(CMSAttributes.signingTime, new DERSet(new Time(signingTime))));
        CMSSignedDataGenerator generator = new CMSSignedDataGenerator();
        ContentSigner contentSigner = new JcaContentSignerBuilder(signatureAlgorithm).build(signingKey);
        generator.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(new JcaDigestCalculatorProviderBuilder().setProvider(BOUNCY_CASTLE_PROVIDER).build())
                .setSignedAttributeGenerator(new DefaultSignedAttributeTableGenerator(new AttributeTable(signedAttributes)))
                .build(contentSigner, chain.get(0)));
        generator.addCertificates(new JcaCertStore(embedded));
        return generator.generate(new CMSProcessableByteArray(payload), true).getEncoded();
    }

    public static AttributeSet attributeSet() {
        return new AttributeSet();
    }

    /** The extra OCTET STRING wrapper Xcode-generated receipts put around the payload. */
    public static byte[] doubleWrap(byte[] payload) throws IOException {
        return new DEROctetString(payload).getEncoded();
    }

    /**
     * Builds a receipt attribute SET, the shape both the receipt payload and the
     * value of an in-app purchase attribute take. Each attribute is
     * {@code SEQUENCE { type INTEGER, version INTEGER, value OCTET STRING }}.
     */
    public static class AttributeSet {
        private final ASN1EncodableVector attributes = new ASN1EncodableVector();

        private AttributeSet() {
        }

        /** An attribute whose value is a DER UTF8String, e.g. the bundle identifier. */
        public AttributeSet string(int type, String value) throws IOException {
            return raw(type, new DERUTF8String(value).getEncoded());
        }

        /** An attribute whose value is a DER IA5String holding an RFC 3339 date. */
        public AttributeSet date(int type, String value) throws IOException {
            return raw(type, new DERIA5String(value).getEncoded());
        }

        /** An attribute whose value is a DER INTEGER, e.g. a purchase quantity. */
        public AttributeSet integer(int type, long value) throws IOException {
            return raw(type, new ASN1Integer(value).getEncoded());
        }

        /** An attribute whose value bytes are used as-is, e.g. an opaque value or a nested SET. */
        public AttributeSet raw(int type, byte[] value) {
            attributes.add(new DERSequence(new ASN1Encodable[]{new ASN1Integer(type), new ASN1Integer(1), new DEROctetString(value)}));
            return this;
        }

        public byte[] build() throws IOException {
            return new DERSet(attributes).getEncoded();
        }
    }

    private static Date tenYearsAgo() {
        return new Date(System.currentTimeMillis() - 3650 * DAY_IN_MILLIS);
    }

    private static Date inOneYear() {
        return new Date(System.currentTimeMillis() + 365 * DAY_IN_MILLIS);
    }

    private static KeyPair rsaKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static X509Certificate certificate(String subject, PublicKey subjectKey, String issuer, PrivateKey issuerKey, boolean certificateAuthority, String markerOid, Date notBefore, Date notAfter) throws Exception {
        JcaX509v3CertificateBuilder builder = new JcaX509v3CertificateBuilder(new X500Name(issuer), BigInteger.valueOf(SERIAL.getAndIncrement()), notBefore, notAfter, new X500Name(subject), subjectKey);
        builder.addExtension(Extension.basicConstraints, true, new BasicConstraints(certificateAuthority));
        if (markerOid != null) {
            // The Apple marker extensions are non-critical and carry no value
            builder.addExtension(new ASN1ObjectIdentifier(markerOid), false, DERNull.INSTANCE);
        }
        ContentSigner contentSigner = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM).build(issuerKey);
        return new JcaX509CertificateConverter().getCertificate(builder.build(contentSigner));
    }
}
