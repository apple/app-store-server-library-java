// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class RealtimeResponseBodyTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testRealtimeResponseBodyWithMessage() throws Exception {
        // Create a RealtimeResponseBody with a Message
        UUID messageId = UUID.fromString("a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890");
        Message message = new Message().messageIdentifier(messageId);
        RealtimeResponseBody responseBody = new RealtimeResponseBody().message(message);

        // Serialize to JSON
        String json = objectMapper.writeValueAsString(responseBody);

        // Validate JSON structure
        JsonNode jsonNode = objectMapper.readTree(json);
        Assertions.assertTrue(jsonNode.has("message"), "JSON should have 'message' field");
        Assertions.assertTrue(jsonNode.get("message").has("messageIdentifier"), "Message should have 'messageIdentifier' field");
        Assertions.assertEquals("a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890", jsonNode.get("message").get("messageIdentifier").asText());
        Assertions.assertFalse(jsonNode.has("alternateProduct"), "JSON should not have 'alternateProduct' field");
        Assertions.assertFalse(jsonNode.has("promotionalOffer"), "JSON should not have 'promotionalOffer' field");

        // Deserialize back
        RealtimeResponseBody deserialized = objectMapper.readValue(json, RealtimeResponseBody.class);

        // Verify
        Assertions.assertNotNull(deserialized.getMessage());
        Assertions.assertEquals(messageId, deserialized.getMessage().getMessageIdentifier());
        Assertions.assertNull(deserialized.getAlternateProduct());
        Assertions.assertNull(deserialized.getPromotionalOffer());
    }

    @Test
    public void testRealtimeResponseBodyWithAlternateProduct() throws Exception {
        // Create a RealtimeResponseBody with an AlternateProduct
        UUID messageId = UUID.fromString("b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901");
        String productId = "com.example.alternate.product";
        AlternateProduct alternateProduct = new AlternateProduct()
                .messageIdentifier(messageId)
                .productId(productId);
        RealtimeResponseBody responseBody = new RealtimeResponseBody().alternateProduct(alternateProduct);

        // Serialize to JSON
        String json = objectMapper.writeValueAsString(responseBody);

        // Validate JSON structure
        JsonNode jsonNode = objectMapper.readTree(json);
        Assertions.assertTrue(jsonNode.has("alternateProduct"), "JSON should have 'alternateProduct' field");
        Assertions.assertTrue(jsonNode.get("alternateProduct").has("messageIdentifier"), "AlternateProduct should have 'messageIdentifier' field");
        Assertions.assertTrue(jsonNode.get("alternateProduct").has("productId"), "AlternateProduct should have 'productId' field");
        Assertions.assertEquals("b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901", jsonNode.get("alternateProduct").get("messageIdentifier").asText());
        Assertions.assertEquals("com.example.alternate.product", jsonNode.get("alternateProduct").get("productId").asText());
        Assertions.assertFalse(jsonNode.has("message"), "JSON should not have 'message' field");
        Assertions.assertFalse(jsonNode.has("promotionalOffer"), "JSON should not have 'promotionalOffer' field");

        // Deserialize back
        RealtimeResponseBody deserialized = objectMapper.readValue(json, RealtimeResponseBody.class);

        // Verify
        Assertions.assertNull(deserialized.getMessage());
        Assertions.assertNotNull(deserialized.getAlternateProduct());
        Assertions.assertEquals(messageId, deserialized.getAlternateProduct().getMessageIdentifier());
        Assertions.assertEquals(productId, deserialized.getAlternateProduct().getProductId());
        Assertions.assertNull(deserialized.getPromotionalOffer());
    }

    @Test
    public void testRealtimeResponseBodyWithPromotionalOfferV2() throws Exception {
        // Create a RealtimeResponseBody with a PromotionalOffer (V2 signature)
        UUID messageId = UUID.fromString("c3d4e5f6-a789-0123-c3d4-e5f6a7890123");
        String signatureV2 = "signature2";
        PromotionalOffer promotionalOffer = new PromotionalOffer()
                .messageIdentifier(messageId)
                .promotionalOfferSignatureV2(signatureV2);
        RealtimeResponseBody responseBody = new RealtimeResponseBody().promotionalOffer(promotionalOffer);

        // Serialize to JSON
        String json = objectMapper.writeValueAsString(responseBody);

        // Validate JSON structure
        JsonNode jsonNode = objectMapper.readTree(json);
        Assertions.assertTrue(jsonNode.has("promotionalOffer"), "JSON should have 'promotionalOffer' field");
        Assertions.assertTrue(jsonNode.get("promotionalOffer").has("messageIdentifier"), "PromotionalOffer should have 'messageIdentifier' field");
        Assertions.assertTrue(jsonNode.get("promotionalOffer").has("promotionalOfferSignatureV2"), "PromotionalOffer should have 'promotionalOfferSignatureV2' field");
        Assertions.assertEquals("c3d4e5f6-a789-0123-c3d4-e5f6a7890123", jsonNode.get("promotionalOffer").get("messageIdentifier").asText());
        Assertions.assertEquals("signature2", jsonNode.get("promotionalOffer").get("promotionalOfferSignatureV2").asText());
        Assertions.assertFalse(jsonNode.get("promotionalOffer").has("promotionalOfferSignatureV1"), "PromotionalOffer should not have 'promotionalOfferSignatureV1' field");
        Assertions.assertFalse(jsonNode.has("message"), "JSON should not have 'message' field");
        Assertions.assertFalse(jsonNode.has("alternateProduct"), "JSON should not have 'alternateProduct' field");

        // Deserialize back
        RealtimeResponseBody deserialized = objectMapper.readValue(json, RealtimeResponseBody.class);

        // Verify
        Assertions.assertNull(deserialized.getMessage());
        Assertions.assertNull(deserialized.getAlternateProduct());
        Assertions.assertNotNull(deserialized.getPromotionalOffer());
        Assertions.assertEquals(messageId, deserialized.getPromotionalOffer().getMessageIdentifier());
        Assertions.assertEquals(signatureV2, deserialized.getPromotionalOffer().getPromotionalOfferSignatureV2());
        Assertions.assertNull(deserialized.getPromotionalOffer().getPromotionalOfferSignatureV1());
    }

    @Test
    public void testRealtimeResponseBodyWithPromotionalOfferV1() throws Exception {
        // Create a RealtimeResponseBody with a PromotionalOffer (V1 signature)
        UUID messageId = UUID.fromString("d4e5f6a7-8901-2345-d4e5-f6a789012345");
        UUID nonce = UUID.fromString("e5f6a789-0123-4567-e5f6-a78901234567");
        UUID appAccountToken = UUID.fromString("f6a78901-2345-6789-f6a7-890123456789");
        PromotionalOfferSignatureV1 signatureV1 = new PromotionalOfferSignatureV1(
                "base64encodedSignature",
                "com.example.product",
                nonce,
                1698148900000L,
                "keyId123",
                "offer123"
        ).appAccountToken(appAccountToken);

        PromotionalOffer promotionalOffer = new PromotionalOffer()
                .messageIdentifier(messageId)
                .promotionalOfferSignatureV1(signatureV1);
        RealtimeResponseBody responseBody = new RealtimeResponseBody().promotionalOffer(promotionalOffer);

        // Serialize to JSON
        String json = objectMapper.writeValueAsString(responseBody);

        // Validate JSON structure
        JsonNode jsonNode = objectMapper.readTree(json);
        Assertions.assertTrue(jsonNode.has("promotionalOffer"), "JSON should have 'promotionalOffer' field");
        Assertions.assertTrue(jsonNode.get("promotionalOffer").has("messageIdentifier"), "PromotionalOffer should have 'messageIdentifier' field");
        Assertions.assertTrue(jsonNode.get("promotionalOffer").has("promotionalOfferSignatureV1"), "PromotionalOffer should have 'promotionalOfferSignatureV1' field");
        Assertions.assertEquals("d4e5f6a7-8901-2345-d4e5-f6a789012345", jsonNode.get("promotionalOffer").get("messageIdentifier").asText());

        JsonNode v1Node = jsonNode.get("promotionalOffer").get("promotionalOfferSignatureV1");
        Assertions.assertTrue(v1Node.has("encodedSignature"), "V1 signature should have 'encodedSignature' field");
        Assertions.assertTrue(v1Node.has("productId"), "V1 signature should have 'productId' field");
        Assertions.assertTrue(v1Node.has("nonce"), "V1 signature should have 'nonce' field");
        Assertions.assertTrue(v1Node.has("timestamp"), "V1 signature should have 'timestamp' field");
        Assertions.assertTrue(v1Node.has("keyId"), "V1 signature should have 'keyId' field");
        Assertions.assertTrue(v1Node.has("offerIdentifier"), "V1 signature should have 'offerIdentifier' field");
        Assertions.assertTrue(v1Node.has("appAccountToken"), "V1 signature should have 'appAccountToken' field");
        Assertions.assertEquals("base64encodedSignature", v1Node.get("encodedSignature").asText());
        Assertions.assertEquals("com.example.product", v1Node.get("productId").asText());
        Assertions.assertEquals("e5f6a789-0123-4567-e5f6-a78901234567", v1Node.get("nonce").asText());
        Assertions.assertEquals(1698148900000L, v1Node.get("timestamp").asLong());
        Assertions.assertEquals("keyId123", v1Node.get("keyId").asText());
        Assertions.assertEquals("offer123", v1Node.get("offerIdentifier").asText());
        Assertions.assertEquals("f6a78901-2345-6789-f6a7-890123456789", v1Node.get("appAccountToken").asText());

        Assertions.assertFalse(jsonNode.get("promotionalOffer").has("promotionalOfferSignatureV2"), "PromotionalOffer should not have 'promotionalOfferSignatureV2' field");
        Assertions.assertFalse(jsonNode.has("message"), "JSON should not have 'message' field");
        Assertions.assertFalse(jsonNode.has("alternateProduct"), "JSON should not have 'alternateProduct' field");

        // Deserialize back
        RealtimeResponseBody deserialized = objectMapper.readValue(json, RealtimeResponseBody.class);

        // Verify
        Assertions.assertNull(deserialized.getMessage());
        Assertions.assertNull(deserialized.getAlternateProduct());
        Assertions.assertNotNull(deserialized.getPromotionalOffer());
        Assertions.assertEquals(messageId, deserialized.getPromotionalOffer().getMessageIdentifier());
        Assertions.assertNull(deserialized.getPromotionalOffer().getPromotionalOfferSignatureV2());
        Assertions.assertNotNull(deserialized.getPromotionalOffer().getPromotionalOfferSignatureV1());

        PromotionalOfferSignatureV1 deserializedV1 = deserialized.getPromotionalOffer().getPromotionalOfferSignatureV1();
        Assertions.assertEquals("com.example.product", deserializedV1.getProductId());
        Assertions.assertEquals("offer123", deserializedV1.getOfferIdentifier());
        Assertions.assertEquals(nonce, deserializedV1.getNonce());
        Assertions.assertEquals(1698148900000L, deserializedV1.getTimestamp());
        Assertions.assertEquals("keyId123", deserializedV1.getKeyId());
        Assertions.assertEquals(appAccountToken, deserializedV1.getAppAccountToken());
        Assertions.assertEquals("base64encodedSignature", deserializedV1.getEncodedSignature());
    }

    @Test
    public void testRealtimeResponseBodySerialization() throws Exception {
        // Test that JSON serialization uses correct field names
        UUID messageId = UUID.fromString("12345678-1234-1234-1234-123456789012");
        Message message = new Message().messageIdentifier(messageId);
        RealtimeResponseBody responseBody = new RealtimeResponseBody().message(message);

        String json = objectMapper.writeValueAsString(responseBody);

        // Verify JSON contains correct field names
        Assertions.assertTrue(json.contains("\"message\""));
        Assertions.assertTrue(json.contains("\"messageIdentifier\""));
        Assertions.assertTrue(json.contains("\"12345678-1234-1234-1234-123456789012\""));
    }
}
