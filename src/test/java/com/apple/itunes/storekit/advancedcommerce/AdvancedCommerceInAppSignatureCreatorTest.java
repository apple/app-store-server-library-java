// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.advancedcommerce;

import com.apple.itunes.storekit.model.AdvancedCommerceInAppRequest;
import com.apple.itunes.storekit.model.AdvancedCommerceOneTimeChargeCreateRequest;
import com.apple.itunes.storekit.model.AdvancedCommerceOneTimeChargeItem;
import com.apple.itunes.storekit.model.AdvancedCommerceRequestInfo;
import com.apple.itunes.storekit.model.AdvancedCommerceSubscriptionModifyInAppRequest;
import com.apple.itunes.storekit.util.TestSigningUtility;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

class AdvancedCommerceInAppSignatureCreatorTest {

    private static final String KEY_ID = "keyId";
    private static final String ISSUER_ID = "issuerId";
    private static final String BUNDLE_ID = "bundleId";
    private static final String TEST_VALUE = "testValue";
    private static final UUID REQUEST_REFERENCE_ID = UUID.fromString("3db5c98d-8acf-4e29-831e-8e1f82f9f6e9");

    @Test
    void testSignatureCreator() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            AdvancedCommerceInAppSignatureCreator signatureCreator = new AdvancedCommerceInAppSignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            TestInAppRequest request = new TestInAppRequest(TEST_VALUE);
            String signature = signatureCreator.createSignature(request);
            Assertions.assertNotNull(signature);
            DecodedJWT decodedJWT = JWT.require(Algorithm.ECDSA256(TestSigningUtility.getTestSigningPublicKey(), null)).build().verify(signature);
            // Header
            Assertions.assertEquals("JWT", decodedJWT.getType());
            Assertions.assertEquals("ES256", decodedJWT.getAlgorithm());
            Assertions.assertEquals(KEY_ID, decodedJWT.getKeyId());
            //Payload
            Assertions.assertEquals(ISSUER_ID, decodedJWT.getIssuer());
            Assertions.assertNotNull(decodedJWT.getIssuedAt());
            Assertions.assertNull(decodedJWT.getExpiresAt());
            Assertions.assertEquals(1, decodedJWT.getAudience().size());
            Assertions.assertEquals("advanced-commerce-api", decodedJWT.getAudience().get(0));
            Assertions.assertEquals(BUNDLE_ID, decodedJWT.getClaim("bid").asString());
            Assertions.assertNotNull(UUID.fromString(decodedJWT.getClaim("nonce").asString()));
            String encodedRequestValue = decodedJWT.getClaim("request").asString();
            Assertions.assertNotNull(encodedRequestValue);
            String jsonValue = new String(Base64.getDecoder().decode(encodedRequestValue), StandardCharsets.UTF_8);
            TestInAppRequest parsedRequest = new ObjectMapper().readValue(jsonValue, TestInAppRequest.class);
            Assertions.assertEquals(TEST_VALUE, parsedRequest.getTestValue());
        }
    }

    @Test
    void testOneTimeChargeCreateRequestOmitsUnsetFields() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            AdvancedCommerceInAppSignatureCreator signatureCreator = new AdvancedCommerceInAppSignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            AdvancedCommerceOneTimeChargeCreateRequest request = new AdvancedCommerceOneTimeChargeCreateRequest(
                    new AdvancedCommerceRequestInfo(REQUEST_REFERENCE_ID),
                    "USD",
                    new AdvancedCommerceOneTimeChargeItem("description", "displayName", "sku", 15990L),
                    "C003-00-2"
            );
            String signature = signatureCreator.createSignature(request);
            String expectedJson = "{\"requestInfo\":{\"requestReferenceId\":\"3db5c98d-8acf-4e29-831e-8e1f82f9f6e9\"},\"operation\":\"CREATE_ONE_TIME_CHARGE\",\"version\":\"1\",\"currency\":\"USD\",\"item\":{\"SKU\":\"sku\",\"description\":\"description\",\"displayName\":\"displayName\",\"price\":15990},\"taxCode\":\"C003-00-2\"}";
            Assertions.assertEquals(new ObjectMapper().readTree(expectedJson), new ObjectMapper().readTree(getDecodedRequest(signature)));
        }
    }

    @Test
    void testSubscriptionModifyInAppRequestOmitsUnsetFields() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            AdvancedCommerceInAppSignatureCreator signatureCreator = new AdvancedCommerceInAppSignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            AdvancedCommerceSubscriptionModifyInAppRequest request = new AdvancedCommerceSubscriptionModifyInAppRequest(
                    new AdvancedCommerceRequestInfo(REQUEST_REFERENCE_ID),
                    true,
                    "123"
            );
            String signature = signatureCreator.createSignature(request);
            String expectedJson = "{\"requestInfo\":{\"requestReferenceId\":\"3db5c98d-8acf-4e29-831e-8e1f82f9f6e9\"},\"operation\":\"MODIFY_SUBSCRIPTION\",\"version\":\"1\",\"retainBillingCycle\":true,\"transactionId\":\"123\"}";
            Assertions.assertEquals(new ObjectMapper().readTree(expectedJson), new ObjectMapper().readTree(getDecodedRequest(signature)));
        }
    }

    @Test
    void testRequestMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            AdvancedCommerceInAppSignatureCreator signatureCreator = new AdvancedCommerceInAppSignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(null));
        }
    }

    private static String getDecodedRequest(String signature) throws Exception {
        DecodedJWT decodedJWT = JWT.require(Algorithm.ECDSA256(TestSigningUtility.getTestSigningPublicKey(), null)).build().verify(signature);
        return new String(Base64.getDecoder().decode(decodedJWT.getClaim("request").asString()), StandardCharsets.UTF_8);
    }

    private static class TestInAppRequest implements AdvancedCommerceInAppRequest {

        @JsonProperty("testValue")
        private String testValue;

        public TestInAppRequest() {}

        public TestInAppRequest(String testValue) {
            this.testValue = testValue;
        }

        public String getTestValue() {
            return testValue;
        }

        public void setTestValue(String testValue) {
            this.testValue = testValue;
        }
    }
}
