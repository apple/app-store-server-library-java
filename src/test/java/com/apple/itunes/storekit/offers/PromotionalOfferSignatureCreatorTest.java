// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import com.apple.itunes.storekit.util.TestSigningUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Signature;
import java.util.Base64;
import java.util.UUID;

class PromotionalOfferSignatureCreatorTest {

    private static final String NONCE = "20fba8a0-2b80-4a7d-a17f-85c1854727f8";
    private static final long TIMESTAMP = 1698148900000L;

    @Test
    void testSignatureCreator() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
            String signature = signatureCreator.createSignature("productId", "offerId", "appAccountToken", UUID.fromString(NONCE), TIMESTAMP);
            Assertions.assertNotNull(signature);
            Assertions.assertTrue(verifySignature(signature, "bundleId", "keyId", "productId", "offerId", "appaccounttoken", NONCE, String.valueOf(TIMESTAMP)));
            Assertions.assertFalse(verifySignature(signature, "bundleId", "keyId", "productId", "offerId", "appAccountToken", NONCE, String.valueOf(TIMESTAMP)));
        }
    }

    @Test
    void testAppAccountTokenMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
            String signature = signatureCreator.createSignature("productId", "offerId", null, UUID.fromString(NONCE), TIMESTAMP);
            Assertions.assertTrue(verifySignature(signature, "bundleId", "keyId", "productId", "offerId", "", NONCE, String.valueOf(TIMESTAMP)));
        }
    }

    @Test
    void testProductIdentifierMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(null, "offerId", "appAccountToken", UUID.fromString(NONCE), TIMESTAMP));
        }
    }

    @Test
    void testSubscriptionOfferIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature("productId", null, "appAccountToken", UUID.fromString(NONCE), TIMESTAMP));
        }
    }

    @Test
    void testNonceMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature("productId", "offerId", "appAccountToken", null, TIMESTAMP));
        }
    }

    @Test
    void testKeyIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            String signingKey = new String(key.readAllBytes());
            Assertions.assertThrows(IllegalArgumentException.class, () -> new PromotionalOfferSignatureCreator(signingKey, null, "bundleId"));
        }
    }

    @Test
    void testBundleIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            String signingKey = new String(key.readAllBytes());
            Assertions.assertThrows(IllegalArgumentException.class, () -> new PromotionalOfferSignatureCreator(signingKey, "keyId", null));
        }
    }

    private static boolean verifySignature(String signature, String... payloadParts) throws Exception {
        String payload = String.join("\u2063", payloadParts);
        Signature verifier = Signature.getInstance("SHA256withECDSA");
        verifier.initVerify(TestSigningUtility.getTestSigningPublicKey());
        verifier.update(payload.getBytes(StandardCharsets.UTF_8));
        return verifier.verify(Base64.getDecoder().decode(signature));
    }
}
