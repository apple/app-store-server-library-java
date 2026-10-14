// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.TestingUtility;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RetentionMessagingModelsTest {

    private static final UUID MESSAGE_IDENTIFIER = UUID.fromString("a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890");
    private static final UUID IMAGE_IDENTIFIER = UUID.fromString("b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901");

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final ObjectMapper clientObjectMapper = createClientObjectMapper();

    private static ObjectMapper createClientObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return mapper;
    }

    @Test
    public void testDefaultConfigurationResponseWithUnknownFields() throws Exception {
        String json = TestingUtility.readFile("models/getDefaultMessageResponseWithUnknownFields.json");

        for (ObjectMapper mapper : List.of(clientObjectMapper, objectMapper)) {
            DefaultConfigurationResponse response = mapper.readValue(json, DefaultConfigurationResponse.class);

            Assertions.assertEquals(MESSAGE_IDENTIFIER, response.getMessageIdentifier());
            Assertions.assertEquals(Map.of("unknownField", "unknown_value"), response.getUnknownFields());
        }
    }

    @Test
    public void testRealtimeUrlResponseWithUnknownFields() throws Exception {
        String json = TestingUtility.readFile("models/getRealtimeUrlResponseWithUnknownFields.json");

        for (ObjectMapper mapper : List.of(clientObjectMapper, objectMapper)) {
            RealtimeUrlResponse response = mapper.readValue(json, RealtimeUrlResponse.class);

            Assertions.assertEquals("https://example.com/realtime", response.getRealtimeURL());
            Assertions.assertEquals(Map.of("unknownField", "unknown_value"), response.getUnknownFields());
        }
    }

    @Test
    public void testRealtimeUrlResponseValidation() {
        String maxUrl = "https://example.com/" + "a".repeat(256 - "https://example.com/".length());
        RealtimeUrlResponse response = new RealtimeUrlResponse(maxUrl);
        Assertions.assertEquals(maxUrl, response.getRealtimeURL());
        Assertions.assertEquals(maxUrl, response.realtimeURL(maxUrl).getRealtimeURL());

        Assertions.assertThrows(IllegalArgumentException.class, () -> new RealtimeUrlResponse(maxUrl + "a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> response.realtimeURL(maxUrl + "a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> response.setRealtimeURL(maxUrl + "a"));

        Assertions.assertThrows(NullPointerException.class, () -> new RealtimeUrlResponse(null));
        Assertions.assertThrows(NullPointerException.class, () -> response.realtimeURL(null));
        Assertions.assertThrows(NullPointerException.class, () -> response.setRealtimeURL(null));
    }

    @Test
    public void testRealtimeUrlRequestValidation() {
        String maximumLengthUrl = "https://example.com/" + "a".repeat(256 - "https://example.com/".length());
        RealtimeUrlRequest request = new RealtimeUrlRequest(maximumLengthUrl);
        Assertions.assertEquals(maximumLengthUrl, request.getRealtimeURL());

        Assertions.assertThrows(IllegalArgumentException.class, () -> new RealtimeUrlRequest(maximumLengthUrl + "a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.realtimeURL(maximumLengthUrl + "a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.setRealtimeURL(maximumLengthUrl + "a"));
        Assertions.assertThrows(NullPointerException.class, () -> new RealtimeUrlRequest(null));
    }

    @Test
    public void testDefaultConfigurationRequestRequiresMessageIdentifier() throws Exception {
        DefaultConfigurationRequest request = new DefaultConfigurationRequest(MESSAGE_IDENTIFIER);
        Assertions.assertEquals("{\"messageIdentifier\":\"a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890\"}", clientObjectMapper.writeValueAsString(request));

        Assertions.assertThrows(NullPointerException.class, () -> new DefaultConfigurationRequest(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.messageIdentifier(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setMessageIdentifier(null));
        Assertions.assertEquals(MESSAGE_IDENTIFIER, request.getMessageIdentifier());
    }

    @Test
    public void testBulletPointRequiresImageIdentifier() throws Exception {
        BulletPoint bulletPoint = new BulletPoint("Text", IMAGE_IDENTIFIER, "Alt text");

        Assertions.assertThrows(NullPointerException.class, () -> new BulletPoint("Text", null, "Alt text"));
        Assertions.assertThrows(NullPointerException.class, () -> bulletPoint.imageIdentifier(null));
        Assertions.assertThrows(NullPointerException.class, () -> bulletPoint.setImageIdentifier(null));
        Assertions.assertEquals(IMAGE_IDENTIFIER, bulletPoint.getImageIdentifier());
        Assertions.assertEquals("{\"altText\":\"Alt text\",\"imageIdentifier\":\"b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901\",\"text\":\"Text\"}", clientObjectMapper.writeValueAsString(bulletPoint));
    }

    @Test
    public void testUploadMessageImageRequiresImageIdentifier() throws Exception {
        UploadMessageImage image = new UploadMessageImage(IMAGE_IDENTIFIER, "Alt text");

        Assertions.assertThrows(NullPointerException.class, () -> new UploadMessageImage(null, "Alt text"));
        Assertions.assertThrows(NullPointerException.class, () -> image.imageIdentifier(null));
        Assertions.assertThrows(NullPointerException.class, () -> image.setImageIdentifier(null));
        Assertions.assertEquals(IMAGE_IDENTIFIER, image.getImageIdentifier());
        Assertions.assertEquals("{\"imageIdentifier\":\"b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901\",\"altText\":\"Alt text\"}", clientObjectMapper.writeValueAsString(image));
    }

    @Test
    public void testUploadMessageRequestBodyBulletPointsValidation() {
        BulletPoint bulletPoint = new BulletPoint("Text", IMAGE_IDENTIFIER, "Alt text");
        UploadMessageRequestBody body = new UploadMessageRequestBody("Header", "Body");

        List<BulletPoint> maximumBulletPoints = List.of(bulletPoint, bulletPoint, bulletPoint, bulletPoint, bulletPoint);
        Assertions.assertEquals(maximumBulletPoints, body.bulletPoints(maximumBulletPoints).getBulletPoints());
        body.setBulletPoints(null);
        Assertions.assertNull(body.getBulletPoints());

        List<BulletPoint> tooManyBulletPoints = new ArrayList<>(maximumBulletPoints);
        tooManyBulletPoints.add(bulletPoint);
        Assertions.assertThrows(IllegalArgumentException.class, () -> body.bulletPoints(tooManyBulletPoints));
        Assertions.assertThrows(IllegalArgumentException.class, () -> body.setBulletPoints(tooManyBulletPoints));

        List<BulletPoint> bulletPointsWithNull = Arrays.asList(bulletPoint, null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> body.bulletPoints(bulletPointsWithNull));
        Assertions.assertThrows(IllegalArgumentException.class, () -> body.setBulletPoints(bulletPointsWithNull));
        Assertions.assertNull(body.getBulletPoints());
    }

    @Test
    public void testPromotionalOfferSignatureV1NoArgConstructorIsProtected() throws Exception {
        Assertions.assertTrue(Modifier.isProtected(PromotionalOfferSignatureV1.class.getDeclaredConstructor().getModifiers()));
    }
}
