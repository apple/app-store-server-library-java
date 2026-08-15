// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import com.apple.itunes.storekit.model.AppReceipt;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.InAppPurchaseReceipt;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OperatorCreationException;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A verifier and decoder class for legacy PKCS#7 App Store receipts (the app
 * receipt used with the deprecated {@code verifyReceipt} endpoint).
 *
 * <p>This is the validating counterpart to
 * {@link com.apple.itunes.storekit.migration.ReceiptUtility}, which extracts
 * without validation. The receipt's certificate chain is validated with the
 * same {@link ChainVerifier} used for JWS signed data, against the same
 * caller-supplied Apple root certificates, and evaluated at the receipt's
 * creation date so old receipts survive certificate rotations unless online
 * checks are enabled.</p>
 */
public class AppReceiptVerifier {

    private static final int ATTR_RECEIPT_TYPE = 0;
    private static final int ATTR_BUNDLE_ID = 2;
    private static final int ATTR_APP_VERSION = 3;
    private static final int ATTR_OPAQUE_VALUE = 4;
    private static final int ATTR_SHA1_HASH = 5;
    private static final int ATTR_CREATION_DATE = 12;
    private static final int ATTR_IN_APP = 17;
    private static final int ATTR_ORIGINAL_PURCHASE_DATE = 18;
    private static final int ATTR_ORIGINAL_APP_VERSION = 19;
    private static final int ATTR_EXPIRATION_DATE = 21;

    private static final int IAP_QUANTITY = 1701;
    private static final int IAP_PRODUCT_ID = 1702;
    private static final int IAP_TRANSACTION_ID = 1703;
    private static final int IAP_PURCHASE_DATE = 1704;
    private static final int IAP_ORIGINAL_TRANSACTION_ID = 1705;
    private static final int IAP_ORIGINAL_PURCHASE_DATE = 1706;
    private static final int IAP_EXPIRES_DATE = 1708;
    private static final int IAP_WEB_ORDER_LINE_ITEM_ID = 1711;
    private static final int IAP_CANCELLATION_DATE = 1712;
    private static final int IAP_IS_IN_INTRO_OFFER_PERIOD = 1719;

    private static final String SHA1_OID = "1.3.14.3.2.26";
    private static final String SHA256_OID = "2.16.840.1.101.3.4.2.1";

    private final String bundleId;
    private final Environment environment;
    private final ChainVerifier chainVerifier;
    private final boolean enableOnlineChecks;
    private final BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();

    /**
     * @param rootCertificates The set of Apple Root certificate authority certificates, as found on <a href="https://www.apple.com/certificateauthority/">Apple PKI</a>
     * @param bundleId The bundle identifier of the app
     * @param environment The server environment, either sandbox or production
     * @param enableOnlineChecks Whether to enable revocation checking and check expiration using the current date
     */
    public AppReceiptVerifier(Set<InputStream> rootCertificates, String bundleId, Environment environment, boolean enableOnlineChecks) {
        this.bundleId = bundleId;
        this.environment = environment;
        this.chainVerifier = Environment.XCODE.equals(environment) || Environment.LOCAL_TESTING.equals(environment) ? null : new ChainVerifier(rootCertificates);
        this.enableOnlineChecks = enableOnlineChecks;
    }

    /**
     * Verifies and decodes an app receipt, as obtained from a device.
     * @see <a href="https://developer.apple.com/documentation/appstorereceipts">App Store Receipts</a>
     *
     * @param encodedReceipt The base64-encoded app receipt
     * @return The decoded receipt after verification
     * @throws VerificationException Thrown if the receipt could not be verified
     */
    public AppReceipt verifyAndDecodeAppReceipt(String encodedReceipt) throws VerificationException {
        byte[] receiptDer;
        try {
            // The MIME decoder tolerates the line breaks base64 receipts
            // commonly pick up in transit.
            receiptDer = Base64.getMimeDecoder().decode(encodedReceipt);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt is not valid base64");
        }
        CMSSignedData signedData;
        try {
            // fromByteArray throws when parsing does not exhaust the input,
            // rejecting trailing bytes after the CMS blob.
            ASN1Primitive.fromByteArray(receiptDer);
            signedData = new CMSSignedData(receiptDer);
        } catch (IOException | CMSException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt is not a PKCS#7 container");
        }
        if (signedData.getSignedContent() == null || !(signedData.getSignedContent().getContent() instanceof byte[])) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt has no encapsulated payload");
        }
        // Parsed before signature verification only to learn the creation
        // date (chain validity is anchored at signing time); nothing from it
        // is trusted until the chain and signature checks pass.
        AppReceipt receipt = parseReceiptPayload((byte[]) signedData.getSignedContent().getContent());
        if (!Environment.XCODE.equals(this.environment) && !Environment.LOCAL_TESTING.equals(this.environment)) {
            Date effectiveDate = this.enableOnlineChecks || receipt.getReceiptCreationDate() == null ? new Date() : new Date(receipt.getReceiptCreationDate());
            X509Certificate signerCertificate = verifyChain(signedData, effectiveDate);
            verifySignature(signedData, signerCertificate);
        }
        // In the Xcode and LocalTesting environments the data is not signed by
        // the App Store and signature verification is skipped, but the bundle
        // id and environment are still validated.
        validateBundleId(receipt.getBundleId());
        validateEnvironment(environmentForReceiptType(receipt.getReceiptType()));
        return receipt;
    }

    /**
     * Verifies an app receipt and extracts a transaction id from its in-app
     * purchases — the validated counterpart of
     * {@link com.apple.itunes.storekit.migration.ReceiptUtility#extractTransactionIdFromAppReceipt(String)},
     * with the same output contract: a transaction id from the array of
     * in-app purchases, or null if the receipt contains none.
     *
     * @param encodedReceipt The base64-encoded app receipt
     * @return A transaction id from the receipt's in-app purchases, null if the receipt contains no in-app purchases
     * @throws VerificationException Thrown if the receipt could not be verified
     */
    public String verifyAndExtractTransactionId(String encodedReceipt) throws VerificationException {
        AppReceipt receipt = verifyAndDecodeAppReceipt(encodedReceipt);
        for (InAppPurchaseReceipt purchase : receipt.getInAppPurchases()) {
            if (purchase.getTransactionId() != null) {
                return purchase.getTransactionId();
            }
            if (purchase.getOriginalTransactionId() != null) {
                return purchase.getOriginalTransactionId();
            }
        }
        return null;
    }

    /**
     * Orders the receipt's embedded certificates as leaf, intermediate, root
     * and hands them to the shared {@link ChainVerifier}, which enforces the
     * chain length, the WWDR intermediate OID and the receipt-signing leaf
     * OID, and validates to the caller-supplied Apple roots.
     */
    private X509Certificate verifyChain(CMSSignedData signedData, Date effectiveDate) throws VerificationException {
        SignerInformation signer = firstSigner(signedData);
        JcaX509CertificateConverter converter = new JcaX509CertificateConverter();
        try {
            List<X509Certificate> embedded = new ArrayList<>();
            X509Certificate leaf = null;
            for (X509CertificateHolder holder : signedData.getCertificates().getMatches(null)) {
                X509Certificate certificate = converter.getCertificate(holder);
                embedded.add(certificate);
                if (leaf == null && signer.getSID().match(holder)) {
                    leaf = certificate;
                }
            }
            if (leaf == null) {
                throw new VerificationException(VerificationStatus.INVALID_CHAIN, "Signer certificate is not embedded in the receipt");
            }
            List<X509Certificate> ordered = new ArrayList<>();
            ordered.add(leaf);
            X509Certificate current = leaf;
            while (ordered.size() < embedded.size()) {
                X509Certificate issuer = findIssuer(current, embedded, ordered);
                if (issuer == null) {
                    break;
                }
                ordered.add(issuer);
                current = issuer;
            }
            String[] encodedChain = new String[ordered.size()];
            for (int i = 0; i < ordered.size(); i++) {
                encodedChain[i] = Base64.getEncoder().encodeToString(ordered.get(i).getEncoded());
            }
            chainVerifier.verifyChain(encodedChain, enableOnlineChecks, effectiveDate);
            return leaf;
        } catch (CertificateException e) {
            throw new VerificationException(VerificationStatus.INVALID_CERTIFICATE, e);
        }
    }

    private static X509Certificate findIssuer(X509Certificate cert, List<X509Certificate> candidates, List<X509Certificate> exclude) {
        for (X509Certificate candidate : candidates) {
            if (!exclude.contains(candidate) && candidate.getSubjectX500Principal().equals(cert.getIssuerX500Principal())) {
                return candidate;
            }
        }
        return null;
    }

    private void verifySignature(CMSSignedData signedData, X509Certificate signerCertificate) throws VerificationException {
        if (!(signerCertificate.getPublicKey() instanceof RSAPublicKey)) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt signer key is not RSA");
        }
        SignerInformation signer = firstSigner(signedData);
        String digestOid = signer.getDigestAlgOID();
        if (!SHA1_OID.equals(digestOid) && !SHA256_OID.equals(digestOid)) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Unrecognized receipt digest algorithm " + digestOid);
        }
        try {
            if (!signer.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider(bouncyCastleProvider).build(signerCertificate))) {
                throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt signature does not verify");
            }
        } catch (CMSException | OperatorCreationException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, e);
        }
    }

    private static SignerInformation firstSigner(CMSSignedData signedData) throws VerificationException {
        for (SignerInformation signer : signedData.getSignerInfos().getSigners()) {
            return signer;
        }
        throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt has no signer info");
    }

    protected void validateBundleId(String bundleId) throws VerificationException {
        if (!this.bundleId.equals(bundleId)) {
            throw new VerificationException(VerificationStatus.INVALID_APP_IDENTIFIER);
        }
    }

    protected void validateEnvironment(Environment environment) throws VerificationException {
        if (!this.environment.equals(environment)) {
            throw new VerificationException(VerificationStatus.INVALID_ENVIRONMENT);
        }
    }

    /**
     * Maps the receipt-type attribute to a server environment. Only explicit
     * production values map to {@link Environment#PRODUCTION}; unknown or
     * missing values map to null and fail environment validation.
     */
    private static Environment environmentForReceiptType(String receiptType) {
        if (receiptType == null) {
            return null;
        }
        switch (receiptType) {
            case "Production":
            case "ProductionVPP":
                return Environment.PRODUCTION;
            case "ProductionSandbox":
            case "ProductionVPPSandbox":
                return Environment.SANDBOX;
            case "Xcode":
                return Environment.XCODE;
            case "LocalTesting":
                return Environment.LOCAL_TESTING;
            default:
                return null;
        }
    }


    private static AppReceipt parseReceiptPayload(byte[] payload) throws VerificationException {
        AppReceipt receipt = new AppReceipt();
        List<InAppPurchaseReceipt> inAppPurchases = new ArrayList<>();
        Map<Integer, List<byte[]>> unknownAttributes = new LinkedHashMap<>();
        for (ASN1Encodable element : parseAttributeSet(payload, "Receipt payload")) {
            ReceiptAttribute attribute = ReceiptAttribute.of(element);
            switch (attribute.type) {
                case ATTR_RECEIPT_TYPE:
                    receipt.setReceiptType(decodeString(attribute.value));
                    break;
                case ATTR_BUNDLE_ID:
                    receipt.setBundleId(decodeString(attribute.value));
                    receipt.setBundleIdBytes(attribute.value);
                    break;
                case ATTR_APP_VERSION:
                    receipt.setApplicationVersion(decodeString(attribute.value));
                    break;
                case ATTR_OPAQUE_VALUE:
                    receipt.setOpaqueValue(attribute.value);
                    break;
                case ATTR_SHA1_HASH:
                    receipt.setSha1Hash(attribute.value);
                    break;
                case ATTR_CREATION_DATE:
                    receipt.setReceiptCreationDate(decodeDate(attribute.value));
                    break;
                case ATTR_IN_APP:
                    inAppPurchases.add(parseInAppPurchase(attribute.value));
                    break;
                case ATTR_ORIGINAL_PURCHASE_DATE:
                    receipt.setOriginalPurchaseDate(decodeDate(attribute.value));
                    break;
                case ATTR_ORIGINAL_APP_VERSION:
                    receipt.setOriginalApplicationVersion(decodeString(attribute.value));
                    break;
                case ATTR_EXPIRATION_DATE:
                    receipt.setExpirationDate(decodeDate(attribute.value));
                    break;
                default:
                    recordUnknown(unknownAttributes, attribute);
                    break;
            }
        }
        receipt.setInAppPurchases(inAppPurchases);
        receipt.setUnknownAttributes(unknownAttributes);
        return receipt;
    }

    private static InAppPurchaseReceipt parseInAppPurchase(byte[] inAppSet) throws VerificationException {
        InAppPurchaseReceipt purchase = new InAppPurchaseReceipt();
        Map<Integer, List<byte[]>> unknownAttributes = new LinkedHashMap<>();
        for (ASN1Encodable element : parseAttributeSet(inAppSet, "In-app purchase attribute")) {
            ReceiptAttribute attribute = ReceiptAttribute.of(element);
            switch (attribute.type) {
                case IAP_QUANTITY:
                    purchase.setQuantity(decodeInteger(attribute.value));
                    break;
                case IAP_PRODUCT_ID:
                    purchase.setProductId(decodeString(attribute.value));
                    break;
                case IAP_TRANSACTION_ID:
                    purchase.setTransactionId(decodeString(attribute.value));
                    break;
                case IAP_PURCHASE_DATE:
                    purchase.setPurchaseDate(decodeDate(attribute.value));
                    break;
                case IAP_ORIGINAL_TRANSACTION_ID:
                    purchase.setOriginalTransactionId(decodeString(attribute.value));
                    break;
                case IAP_ORIGINAL_PURCHASE_DATE:
                    purchase.setOriginalPurchaseDate(decodeDate(attribute.value));
                    break;
                case IAP_EXPIRES_DATE:
                    purchase.setExpiresDate(decodeDate(attribute.value));
                    break;
                case IAP_WEB_ORDER_LINE_ITEM_ID:
                    purchase.setWebOrderLineItemId(decodeInteger(attribute.value));
                    break;
                case IAP_CANCELLATION_DATE:
                    purchase.setCancellationDate(decodeDate(attribute.value));
                    break;
                case IAP_IS_IN_INTRO_OFFER_PERIOD:
                    Long flag = decodeInteger(attribute.value);
                    purchase.setIsInIntroOfferPeriod(flag != null && flag != 0);
                    break;
                default:
                    recordUnknown(unknownAttributes, attribute);
                    break;
            }
        }
        purchase.setUnknownAttributes(unknownAttributes);
        return purchase;
    }

    private static void recordUnknown(Map<Integer, List<byte[]>> unknownAttributes, ReceiptAttribute attribute) {
        unknownAttributes.computeIfAbsent(attribute.type, k -> new ArrayList<>()).add(attribute.value);
    }

    private static ASN1Set parseAttributeSet(byte[] der, String what) throws VerificationException {
        ASN1Primitive parsed;
        try {
            parsed = ASN1Primitive.fromByteArray(der);
            if (parsed instanceof ASN1OctetString) {
                // Xcode receipts double-wrap the payload in an extra OCTET
                // STRING; ReceiptUtility handles the same shape.
                parsed = ASN1Primitive.fromByteArray(((ASN1OctetString) parsed).getOctets());
            }
        } catch (IOException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, what + " is not valid ASN.1");
        }
        if (!(parsed instanceof ASN1Set)) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, what + " is not an ASN.1 SET");
        }
        return (ASN1Set) parsed;
    }

    /** {@code ReceiptAttribute ::= SEQUENCE { type INTEGER, version INTEGER, value OCTET STRING }} */
    private static final class ReceiptAttribute {
        final int type;
        final byte[] value;

        private ReceiptAttribute(int type, byte[] value) {
            this.type = type;
            this.value = value;
        }

        static ReceiptAttribute of(ASN1Encodable element) throws VerificationException {
            try {
                ASN1Sequence sequence = ASN1Sequence.getInstance(element);
                if (sequence.size() < 3) {
                    throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt attribute has " + sequence.size() + " fields, expected 3");
                }
                long type = boundedLong(ASN1Integer.getInstance(sequence.getObjectAt(0)).getValue());
                byte[] value = ASN1OctetString.getInstance(sequence.getObjectAt(2)).getOctets();
                // A type beyond int range matches no known attribute; -1 routes
                // it to unknownAttributes instead of aliasing via a truncating cast.
                int typeInt = type >= 0 && type <= Integer.MAX_VALUE ? (int) type : -1;
                return new ReceiptAttribute(typeInt, value);
            } catch (IllegalArgumentException e) {
                throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Malformed receipt attribute");
            }
        }
    }

    /** Non-negative and within long range — real receipts carry 7-byte integers. */
    private static long boundedLong(BigInteger value) throws VerificationException {
        if (value.signum() < 0 || value.bitLength() > 63) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Receipt integer out of range");
        }
        return value.longValue();
    }

    private static String decodeString(byte[] der) throws VerificationException {
        try {
            ASN1Primitive parsed = ASN1Primitive.fromByteArray(der);
            if (!(parsed instanceof ASN1String)) {
                throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Attribute value is not an ASN.1 string");
            }
            return ((ASN1String) parsed).getString();
        } catch (IOException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Attribute value is not valid ASN.1");
        }
    }

    private static Long decodeInteger(byte[] der) throws VerificationException {
        try {
            ASN1Primitive parsed = ASN1Primitive.fromByteArray(der);
            if (!(parsed instanceof ASN1Integer)) {
                throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Attribute value is not an ASN.1 integer");
            }
            return boundedLong(((ASN1Integer) parsed).getValue());
        } catch (IOException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Attribute value is not valid ASN.1");
        }
    }

    /** RFC 3339 date in an IA5String, in milliseconds; empty means absent (real receipts do this). */
    private static Long decodeDate(byte[] der) throws VerificationException {
        String text = decodeString(der);
        if (text.isEmpty()) {
            return null;
        }
        try {
            return Instant.parse(text).toEpochMilli();
        } catch (DateTimeParseException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Unparseable receipt date: " + text);
        }
    }
}
