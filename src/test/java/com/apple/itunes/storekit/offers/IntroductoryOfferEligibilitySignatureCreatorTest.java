// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.UUID;

class IntroductoryOfferEligibilitySignatureCreatorTest {

    private static final String KEY_ID = "keyId";
    private static final String ISSUER_ID = "issuerId";
    private static final String TRANSACTION_ID = "transactionId";
    private static final String PRODUCT_ID = "productId";
    private static final boolean ALLOW_INTRODUCTORY_OFFER = true;
    private static final String BUNDLE_ID = "bundleId";

    @Test
    void testSignatureCreator() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            IntroductoryOfferEligibilitySignatureCreator signatureCreator = new IntroductoryOfferEligibilitySignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            String signature = signatureCreator.createSignature(PRODUCT_ID, ALLOW_INTRODUCTORY_OFFER, TRANSACTION_ID);
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
            Assertions.assertEquals("introductory-offer-eligibility", decodedJWT.getAudience().get(0));
            Assertions.assertEquals(BUNDLE_ID, decodedJWT.getClaim("bid").asString());
            Assertions.assertNotNull(UUID.fromString(decodedJWT.getClaim("nonce").asString()));
            Assertions.assertEquals(PRODUCT_ID, decodedJWT.getClaim("productId").asString());
            Assertions.assertEquals(ALLOW_INTRODUCTORY_OFFER, decodedJWT.getClaim("allowIntroductoryOffer").asBoolean());
            Assertions.assertEquals(TRANSACTION_ID, decodedJWT.getClaim("transactionId").asString());
        }
    }

    @Test
    void testTransactionIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            IntroductoryOfferEligibilitySignatureCreator signatureCreator = new IntroductoryOfferEligibilitySignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(PRODUCT_ID, ALLOW_INTRODUCTORY_OFFER, null));
        }
    }

    @Test
    void testProductIdMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            IntroductoryOfferEligibilitySignatureCreator signatureCreator = new IntroductoryOfferEligibilitySignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(null, ALLOW_INTRODUCTORY_OFFER, TRANSACTION_ID));
        }
    }
}
