// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class AppStoreServerAPIModelsTest {

    private final ObjectMapper objectMapper = createObjectMapper();

    private static ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return objectMapper;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> serialize(Object value) throws JsonProcessingException {
        return objectMapper.readValue(objectMapper.writeValueAsString(value), Map.class);
    }

    @Test
    public void testConsumptionRequestRefundPreferenceIsOptional() throws JsonProcessingException {
        ConsumptionRequest request = new ConsumptionRequest(true, DeliveryStatus.DELIVERED, false)
                .refundPreference(RefundPreference.GRANT_FULL);

        request.setRefundPreference(null);
        Assertions.assertNull(request.getRefundPreference());
        Assertions.assertNull(request.getRawRefundPreference());
        Assertions.assertFalse(serialize(request).containsKey("refundPreference"));

        request.setRawRefundPreference("GRANT_FULL");
        Assertions.assertEquals(RefundPreference.GRANT_FULL, request.getRefundPreference());

        request.setRawRefundPreference(null);
        Assertions.assertNull(request.getRefundPreference());
        Assertions.assertNull(request.getRawRefundPreference());

        request.setRefundPreference(RefundPreference.DECLINE);
        Assertions.assertEquals("DECLINE", request.getRawRefundPreference());
        Assertions.assertEquals("DECLINE", serialize(request).get("refundPreference"));
    }

    @Test
    public void testExtendRenewalDateRequestExtendReasonCode() throws JsonProcessingException {
        ExtendRenewalDateRequest request = new ExtendRenewalDateRequest(45, ExtendReasonCode.CUSTOMER_SATISFACTION, "fdf964a4-233b-486c-aac1-97d8d52688ac");

        Assertions.assertEquals(ExtendReasonCode.CUSTOMER_SATISFACTION, request.getExtendReasonCode());
        Assertions.assertEquals(1, request.getRawExtendReasonCode());
        Map<String, Object> root = serialize(request);
        Assertions.assertEquals(1, ((Number) root.get("extendReasonCode")).intValue());

        request.setRawExtendReasonCode(99);
        Assertions.assertNull(request.getExtendReasonCode());
        Assertions.assertEquals(99, request.getRawExtendReasonCode());
        root = serialize(request);
        Assertions.assertEquals(99, ((Number) root.get("extendReasonCode")).intValue());

        Assertions.assertThrows(NullPointerException.class, () -> request.setExtendReasonCode(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setRawExtendReasonCode(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.extendReasonCode(null));
        Assertions.assertEquals(99, request.getRawExtendReasonCode());

        request.setExtendReasonCode(ExtendReasonCode.SERVICE_ISSUE_OR_OUTAGE);
        ExtendRenewalDateRequest rawRequest = new ExtendRenewalDateRequest(45, 3, "fdf964a4-233b-486c-aac1-97d8d52688ac");
        Assertions.assertEquals(request, rawRequest);
        Assertions.assertEquals(request.hashCode(), rawRequest.hashCode());
    }

    @Test
    public void testMassExtendRenewalDateRequestExtendReasonCode() throws JsonProcessingException {
        MassExtendRenewalDateRequest request = new MassExtendRenewalDateRequest("fdf964a4-233b-486c-aac1-97d8d52688ac", 45, ExtendReasonCode.OTHER, "com.example.productId");

        Assertions.assertEquals(ExtendReasonCode.OTHER, request.getExtendReasonCode());
        Assertions.assertEquals(2, request.getRawExtendReasonCode());
        Map<String, Object> root = serialize(request);
        Assertions.assertEquals(2, ((Number) root.get("extendReasonCode")).intValue());

        request.setRawExtendReasonCode(99);
        Assertions.assertNull(request.getExtendReasonCode());
        Assertions.assertEquals(99, request.getRawExtendReasonCode());
        root = serialize(request);
        Assertions.assertEquals(99, ((Number) root.get("extendReasonCode")).intValue());

        Assertions.assertThrows(NullPointerException.class, () -> request.setExtendReasonCode(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setRawExtendReasonCode(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.extendReasonCode(null));
        Assertions.assertEquals(99, request.getRawExtendReasonCode());

        MassExtendRenewalDateRequest rawRequest = new MassExtendRenewalDateRequest("fdf964a4-233b-486c-aac1-97d8d52688ac", 45, 99, "com.example.productId");
        Assertions.assertEquals(request, rawRequest);
        Assertions.assertEquals(request.hashCode(), rawRequest.hashCode());
    }

    @Test
    public void testNotificationHistoryRequestRawNotificationTypes() throws JsonProcessingException {
        NotificationHistoryRequest request = new NotificationHistoryRequest(1698148900000L, 1698148950000L)
                .notificationType(NotificationTypeV2.SUBSCRIBED)
                .notificationSubtype(Subtype.INITIAL_BUY);

        Assertions.assertEquals(NotificationTypeV2.SUBSCRIBED, request.getNotificationType());
        Assertions.assertEquals("SUBSCRIBED", request.getRawNotificationType());
        Assertions.assertEquals(Subtype.INITIAL_BUY, request.getNotificationSubtype());
        Assertions.assertEquals("INITIAL_BUY", request.getRawNotificationSubtype());
        Map<String, Object> root = serialize(request);
        Assertions.assertEquals("SUBSCRIBED", root.get("notificationType"));
        Assertions.assertEquals("INITIAL_BUY", root.get("notificationSubtype"));

        request.setRawNotificationType("NEW_NOTIFICATION_TYPE");
        request.setRawNotificationSubtype("NEW_SUBTYPE");
        Assertions.assertNull(request.getNotificationType());
        Assertions.assertEquals("NEW_NOTIFICATION_TYPE", request.getRawNotificationType());
        Assertions.assertNull(request.getNotificationSubtype());
        Assertions.assertEquals("NEW_SUBTYPE", request.getRawNotificationSubtype());
        root = serialize(request);
        Assertions.assertEquals("NEW_NOTIFICATION_TYPE", root.get("notificationType"));
        Assertions.assertEquals("NEW_SUBTYPE", root.get("notificationSubtype"));

        request.setNotificationType(null);
        request.setNotificationSubtype(null);
        Assertions.assertNull(request.getRawNotificationType());
        Assertions.assertNull(request.getRawNotificationSubtype());
        root = serialize(request);
        Assertions.assertFalse(root.containsKey("notificationType"));
        Assertions.assertFalse(root.containsKey("notificationSubtype"));
    }

    @Test
    public void testTransactionHistoryRequestRawInAppOwnershipType() {
        TransactionHistoryRequest request = new TransactionHistoryRequest()
                .inAppOwnershipType(InAppOwnershipType.FAMILY_SHARED);

        Assertions.assertEquals(InAppOwnershipType.FAMILY_SHARED, request.getInAppOwnershipType());
        Assertions.assertEquals("FAMILY_SHARED", request.getRawInAppOwnershipType());

        request.setRawInAppOwnershipType("NEW_OWNERSHIP_TYPE");
        Assertions.assertNull(request.getInAppOwnershipType());
        Assertions.assertEquals("NEW_OWNERSHIP_TYPE", request.getRawInAppOwnershipType());

        request.setInAppOwnershipType(InAppOwnershipType.PURCHASED);
        Assertions.assertEquals(InAppOwnershipType.PURCHASED, request.getInAppOwnershipType());
        Assertions.assertEquals("PURCHASED", request.getRawInAppOwnershipType());

        request.setInAppOwnershipType(null);
        Assertions.assertNull(request.getInAppOwnershipType());
        Assertions.assertNull(request.getRawInAppOwnershipType());
    }

    @Test
    public void testTransactionHistoryRequestEquality() {
        TransactionHistoryRequest request = new TransactionHistoryRequest()
                .startDate(123455L)
                .endDate(123456L)
                .productIds(List.of("com.example.1", "com.example.2"))
                .productTypes(List.of(TransactionHistoryRequest.ProductType.CONSUMABLE, TransactionHistoryRequest.ProductType.AUTO_RENEWABLE))
                .sort(TransactionHistoryRequest.Order.ASCENDING)
                .subscriptionGroupIdentifiers(List.of("sub_group_id"))
                .inAppOwnershipType(InAppOwnershipType.FAMILY_SHARED)
                .revoked(false);
        TransactionHistoryRequest otherRequest = new TransactionHistoryRequest()
                .startDate(123455L)
                .endDate(123456L)
                .productIds(List.of("com.example.1", "com.example.2"))
                .productTypes(List.of(TransactionHistoryRequest.ProductType.CONSUMABLE, TransactionHistoryRequest.ProductType.AUTO_RENEWABLE))
                .sort(TransactionHistoryRequest.Order.ASCENDING)
                .subscriptionGroupIdentifiers(List.of("sub_group_id"))
                .revoked(false);
        otherRequest.setRawInAppOwnershipType("FAMILY_SHARED");

        Assertions.assertEquals(request, otherRequest);
        Assertions.assertEquals(request.hashCode(), otherRequest.hashCode());

        otherRequest.setRevoked(true);
        Assertions.assertNotEquals(request, otherRequest);

        otherRequest.setRevoked(false);
        otherRequest.setInAppOwnershipType(InAppOwnershipType.PURCHASED);
        Assertions.assertNotEquals(request, otherRequest);

        Assertions.assertEquals(new TransactionHistoryRequest(), new TransactionHistoryRequest());
        Assertions.assertEquals(new TransactionHistoryRequest().hashCode(), new TransactionHistoryRequest().hashCode());
        Assertions.assertNotEquals(new TransactionHistoryRequest(), null);
    }

    @Test
    public void testAccountTenureToString() {
        Assertions.assertEquals("0", AccountTenure.UNDECLARED.toString());
        Assertions.assertEquals("7", AccountTenure.GREATER_THAN_THREE_HUNDRED_SIXTY_FIVE_DAYS.toString());
        for (AccountTenure accountTenure : AccountTenure.values()) {
            Assertions.assertEquals(String.valueOf(accountTenure.getValue()), accountTenure.toString());
        }
    }

    @Test
    public void testExtendRenewalDateRequestLimits() {
        String identifier128 = "a".repeat(128);
        String identifier129 = "a".repeat(129);
        for (int days : new int[]{1, 90}) {
            ExtendRenewalDateRequest request = new ExtendRenewalDateRequest(days, ExtendReasonCode.CUSTOMER_SATISFACTION, identifier128);
            Assertions.assertEquals(days, request.getExtendByDays());
            Assertions.assertEquals(days, new ExtendRenewalDateRequest(days, 99, identifier128).getExtendByDays());
            Assertions.assertEquals(days, new ExtendRenewalDateRequest(45, 99, "id").extendByDays(days).getExtendByDays());
            request.setExtendByDays(days);
            Assertions.assertEquals(days, request.getExtendByDays());
            MassExtendRenewalDateRequest massRequest = new MassExtendRenewalDateRequest(identifier128, days, ExtendReasonCode.CUSTOMER_SATISFACTION, "com.example.productId");
            Assertions.assertEquals(days, massRequest.getExtendByDays());
            Assertions.assertEquals(days, new MassExtendRenewalDateRequest(identifier128, days, 99, "com.example.productId").getExtendByDays());
            Assertions.assertEquals(days, new MassExtendRenewalDateRequest("id", 45, 99, "com.example.productId").extendByDays(days).getExtendByDays());
            massRequest.setExtendByDays(days);
            Assertions.assertEquals(days, massRequest.getExtendByDays());
        }
        ExtendRenewalDateRequest request = new ExtendRenewalDateRequest(45, ExtendReasonCode.CUSTOMER_SATISFACTION, "id");
        MassExtendRenewalDateRequest massRequest = new MassExtendRenewalDateRequest("id", 45, ExtendReasonCode.CUSTOMER_SATISFACTION, "com.example.productId");
        for (int days : new int[]{0, 91}) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtendRenewalDateRequest(days, ExtendReasonCode.CUSTOMER_SATISFACTION, "id"));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtendRenewalDateRequest(days, 99, "id"));
            Assertions.assertThrows(IllegalArgumentException.class, () -> request.extendByDays(days));
            Assertions.assertThrows(IllegalArgumentException.class, () -> request.setExtendByDays(days));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new MassExtendRenewalDateRequest("id", days, ExtendReasonCode.CUSTOMER_SATISFACTION, "com.example.productId"));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new MassExtendRenewalDateRequest("id", days, 99, "com.example.productId"));
            Assertions.assertThrows(IllegalArgumentException.class, () -> massRequest.extendByDays(days));
            Assertions.assertThrows(IllegalArgumentException.class, () -> massRequest.setExtendByDays(days));
        }
        Assertions.assertEquals(45, request.getExtendByDays());
        Assertions.assertEquals(45, massRequest.getExtendByDays());

        Assertions.assertEquals(identifier128, request.requestIdentifier(identifier128).getRequestIdentifier());
        Assertions.assertEquals(identifier128, massRequest.requestIdentifier(identifier128).getRequestIdentifier());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtendRenewalDateRequest(45, ExtendReasonCode.CUSTOMER_SATISFACTION, identifier129));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ExtendRenewalDateRequest(45, 99, identifier129));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.requestIdentifier(identifier129));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.setRequestIdentifier(identifier129));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MassExtendRenewalDateRequest(identifier129, 45, ExtendReasonCode.CUSTOMER_SATISFACTION, "com.example.productId"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MassExtendRenewalDateRequest(identifier129, 45, 99, "com.example.productId"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> massRequest.requestIdentifier(identifier129));
        Assertions.assertThrows(IllegalArgumentException.class, () -> massRequest.setRequestIdentifier(identifier129));
        Assertions.assertEquals(identifier128, request.getRequestIdentifier());
        Assertions.assertEquals(identifier128, massRequest.getRequestIdentifier());
    }

    @Test
    public void testMassExtendRenewalDateRequestStorefrontCountryCodeLimits() {
        MassExtendRenewalDateRequest request = new MassExtendRenewalDateRequest("id", 45, ExtendReasonCode.CUSTOMER_SATISFACTION, "com.example.productId");
        Assertions.assertEquals(List.of("USA", "CA"), request.storefrontCountryCodes(List.of("USA", "CA")).getStorefrontCountryCodes());
        request.setStorefrontCountryCodes(null);
        Assertions.assertNull(request.getStorefrontCountryCodes());
        request.addStorefrontCountryCode("USA");
        Assertions.assertEquals(List.of("USA"), request.getStorefrontCountryCodes());
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.addStorefrontCountryCode("ABCD"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.storefrontCountryCodes(List.of("USA", "ABCD")));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.setStorefrontCountryCodes(List.of("ABCD")));
        Assertions.assertEquals(List.of("USA"), request.getStorefrontCountryCodes());
    }

    @Test
    public void testConsumptionRequestConsumptionPercentageLimits() {
        ConsumptionRequest request = new ConsumptionRequest(true, DeliveryStatus.DELIVERED, false);
        for (int percentage : new int[]{0, 100000}) {
            Assertions.assertEquals(percentage, request.consumptionPercentage(percentage).getConsumptionPercentage());
            request.setConsumptionPercentage(null);
            request.setConsumptionPercentage(percentage);
            Assertions.assertEquals(percentage, request.getConsumptionPercentage());
        }
        for (int percentage : new int[]{-1, 100001}) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> request.consumptionPercentage(percentage));
            Assertions.assertThrows(IllegalArgumentException.class, () -> request.setConsumptionPercentage(percentage));
        }
        Assertions.assertEquals(100000, request.getConsumptionPercentage());
        Assertions.assertNull(request.consumptionPercentage(null).getConsumptionPercentage());
    }
}
