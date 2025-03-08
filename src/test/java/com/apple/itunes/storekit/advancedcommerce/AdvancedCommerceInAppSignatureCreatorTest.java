// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.advancedcommerce;

import com.apple.itunes.storekit.model.AdvancedCommerceInAppRequest;
import com.auth0.jwt.JWT;
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

    @Test
    void testSignatureCreator() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            AdvancedCommerceInAppSignatureCreator signatureCreator = new AdvancedCommerceInAppSignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            TestInAppRequest request = new TestInAppRequest(TEST_VALUE);
            String signature = signatureCreator.createSignature(request);
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
    void testRequestMissing() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            AdvancedCommerceInAppSignatureCreator signatureCreator = new AdvancedCommerceInAppSignatureCreator(new String(key.readAllBytes()), KEY_ID, ISSUER_ID, BUNDLE_ID);
            Assertions.assertThrows(IllegalArgumentException.class, () -> signatureCreator.createSignature(null));
        }
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
