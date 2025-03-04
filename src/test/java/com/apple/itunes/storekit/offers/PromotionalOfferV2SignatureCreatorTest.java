// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.impl.JWTParser;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.UUID;

class PromotionalOfferV2SignatureCreatorTest {

    private static final String KEY_ID = "keyId";
    private static final String ISSUER_ID = "issuerId";
    private static final String TRANSACTION_ID = "transactionId";
    private static final String PRODUCT_ID = "productId";
    private static final String OFFER_IDENTIFIER = "offerIdentifier";
    private static final String BUNDLE_ID = "bundleId";

    @Test
    void testSignatureCreator() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferV2SignatureCreator signatureCreator = new PromotionalOfferV2SignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            String signature = signatureCreator.createSignature(PRODUCT_ID, OFFER_IDENTIFIER, TRANSACTION_ID);
            Assertions.assertNotNull(signature);
            DecodedJWT decodedJWT = JWT.decode(signature);
            // Header
            Assertions.assertEquals("JWT", decodedJWT.getType());
            Assertions.assertEquals("ES256", decodedJWT.getAlgorithm());
            Assertions.assertEquals(KEY_ID, decodedJWT.getKeyId());
            //Payload
            Assertions.assertEquals(ISSUER_ID, decodedJWT.getIssuer());
            Assertions.assertNotNull(decodedJWT.getIssuedAt());
            Assertions.assertNull(decodedJWT.getExpiresAt());
            Assertions.assertEquals(1, decodedJWT.getAudience().size());
            Assertions.assertEquals("promotional-offer", decodedJWT.getAudience().get(0));
            Assertions.assertEquals(BUNDLE_ID, decodedJWT.getClaim("bid").asString());
            Assertions.assertNotNull(UUID.fromString(decodedJWT.getClaim("nonce").asString()));
            Assertions.assertEquals(PRODUCT_ID, decodedJWT.getClaim("productId").asString());
            Assertions.assertEquals(OFFER_IDENTIFIER, decodedJWT.getClaim("offerIdentifier").asString());
            Assertions.assertEquals(TRANSACTION_ID, decodedJWT.getClaim("transactionId").asString());
        }
    }

    @Test
    void testTransactionIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferV2SignatureCreator signatureCreator = new PromotionalOfferV2SignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            String signature = signatureCreator.createSignature(PRODUCT_ID, OFFER_IDENTIFIER, null);
            DecodedJWT decodedJWT = JWT.decode(signature);
            Assertions.assertTrue(decodedJWT.getClaim("transactionId").isMissing());
        }
    }

    @Test
    void testOfferIdentifierMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferV2SignatureCreator signatureCreator = new PromotionalOfferV2SignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(PRODUCT_ID, null, TRANSACTION_ID));
        }
    }

    @Test
    void testProductIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferV2SignatureCreator signatureCreator = new PromotionalOfferV2SignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(null, OFFER_IDENTIFIER, TRANSACTION_ID));
        }
    }
}
