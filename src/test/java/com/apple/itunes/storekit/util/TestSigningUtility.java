// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSigningUtility {

    private static final String TEST_SIGNING_PUBLIC_KEY_BASE64_ENCODED = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAErPJyxEu2/oKCrJaaTVTrq39DKJ2XcN6W+k8UvGf+Y/lDWNbFitQocabsDUvSN0edHH3UKP5QPTz4cOlyIPMrXQ==";

    public static ECPublicKey getTestSigningPublicKey() throws GeneralSecurityException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(TEST_SIGNING_PUBLIC_KEY_BASE64_ENCODED));
        return (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(keySpec);
    }

    public static String createSignedDataWithTestCertificateChain(String payload) throws IOException, GeneralSecurityException {
        return createSignedDataWithTestCertificateChain(payload, Algorithm.ECDSA256(getTestLeafPrivateKey()));
    }

    public static String createSignedDataWithTestCertificateChain(String payload, Algorithm algorithm) throws IOException {
        List<String> x5c = List.of(readCertificate("certs/testLeaf.pem"), readCertificate("certs/testIntermediate.pem"), readCertificate("certs/testCA.pem"));
        return JWT.create()
                .withHeader(Map.of("x5c", x5c))
                .withPayload(payload)
                .sign(algorithm);
    }

    private static ECPrivateKey getTestLeafPrivateKey() throws IOException, GeneralSecurityException {
        org.bouncycastle.asn1.sec.ECPrivateKey sec1Key = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(decodePem("certs/testLeaf.key"));
        PrivateKeyInfo privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, sec1Key.getParametersObject()), sec1Key);
        return (ECPrivateKey) KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded()));
    }

    private static String readCertificate(String path) throws IOException {
        return Base64.getEncoder().encodeToString(decodePem(path));
    }

    private static byte[] decodePem(String path) throws IOException {
        Matcher matcher = Pattern.compile("-----BEGIN [A-Z ]+-----([^-]+)-----END [A-Z ]+-----").matcher(TestingUtility.readFile(path));
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        return Base64.getDecoder().decode(matcher.group(1).replaceAll("\\s", ""));
    }
}
