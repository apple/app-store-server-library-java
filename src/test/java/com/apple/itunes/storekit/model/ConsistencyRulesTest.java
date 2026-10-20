// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

public class ConsistencyRulesTest {

    private static final AdvancedCommerceRequestInfo REQUEST_INFO =
            new AdvancedCommerceRequestInfo(UUID.fromString("932c6903-0ab8-4469-9f21-015f6fab013c"));

    private static final ObjectMapper objectMapper = createObjectMapper();

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
    private static Map<String, Object> serialize(Object value) throws Exception {
        return objectMapper.readValue(objectMapper.writeValueAsString(value), Map.class);
    }

    private static <T> T newInstance(Class<T> type) throws Exception {
        Constructor<T> constructor = type.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    private static void assertEqualObjects(Object a, Object b) {
        Assertions.assertEquals(a, b);
        Assertions.assertEquals(b, a);
        Assertions.assertEquals(a.hashCode(), b.hashCode());
    }

    private static void assertNotEqualObjects(Object a, Object b) {
        Assertions.assertNotEquals(a, b);
        Assertions.assertNotEquals(b, a);
    }

    @Test
    public void testRevokeRequestRefundTypeIsTypedWithRawStorage() throws Exception {
        AdvancedCommerceSubscriptionRevokeRequest typed = new AdvancedCommerceSubscriptionRevokeRequest(
                REQUEST_INFO, AdvancedCommerceRefundReason.LEGAL, true, AdvancedCommerceRefundType.PRORATED);
        AdvancedCommerceSubscriptionRevokeRequest raw = new AdvancedCommerceSubscriptionRevokeRequest(
                REQUEST_INFO, "LEGAL", true, "PRORATED");
        assertEqualObjects(typed, raw);
        Assertions.assertEquals(AdvancedCommerceRefundType.PRORATED, raw.getRefundType());
        Assertions.assertEquals("PRORATED", raw.getRawRefundType());
        Assertions.assertEquals(Map.of("requestInfo", Map.of("requestReferenceId", "932c6903-0ab8-4469-9f21-015f6fab013c"),
                "refundReason", "LEGAL", "refundType", "PRORATED", "refundRiskingPreference", true), serialize(typed));

        AdvancedCommerceSubscriptionRevokeRequest unknown = new AdvancedCommerceSubscriptionRevokeRequest(
                REQUEST_INFO, "LEGAL", true, "PARTIAL");
        Assertions.assertNull(unknown.getRefundType());
        Assertions.assertEquals("PARTIAL", unknown.getRawRefundType());
        Assertions.assertEquals("PARTIAL", serialize(unknown).get("refundType"));
        AdvancedCommerceSubscriptionRevokeRequest decoded = objectMapper.readValue(
                objectMapper.writeValueAsString(unknown), AdvancedCommerceSubscriptionRevokeRequest.class);
        Assertions.assertEquals(unknown, decoded);
        Assertions.assertEquals("PARTIAL", decoded.getRawRefundType());

        Assertions.assertSame(typed, typed.refundType(AdvancedCommerceRefundType.FULL));
        Assertions.assertEquals("FULL", typed.getRawRefundType());
        Assertions.assertThrows(NullPointerException.class, () -> typed.refundType(null));
        Assertions.assertThrows(NullPointerException.class, () -> typed.setRefundType(null));
        Assertions.assertThrows(NullPointerException.class, () -> typed.setRawRefundType(null));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionRevokeRequest(
                REQUEST_INFO, AdvancedCommerceRefundReason.LEGAL, true, (AdvancedCommerceRefundType) null));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionRevokeRequest(
                REQUEST_INFO, "LEGAL", true, (String) null));
    }

    @Test
    public void testRevokeRequestHasNoStringTypedRefundTypeAccessors() throws Exception {
        Class<AdvancedCommerceSubscriptionRevokeRequest> type = AdvancedCommerceSubscriptionRevokeRequest.class;
        Assertions.assertEquals(AdvancedCommerceRefundType.class, type.getMethod("getRefundType").getReturnType());
        Assertions.assertThrows(NoSuchMethodException.class, () -> type.getMethod("refundType", String.class));
        Assertions.assertThrows(NoSuchMethodException.class, () -> type.getMethod("setRefundType", String.class));
        Assertions.assertThrows(NoSuchMethodException.class, () -> type.getConstructor(
                AdvancedCommerceRequestInfo.class, Boolean.class, AdvancedCommerceRefundReason.class, String.class));
    }

    @Test
    public void testAdvancedCommerceResponsesCompareInheritedMembers() throws Exception {
        List<List<Object>> pairs = List.of(
                List.of(new AdvancedCommerceSubscriptionCancelResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionCancelResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionCancelResponse("renewal", "other")),
                List.of(new AdvancedCommerceSubscriptionChangeMetadataResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionChangeMetadataResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionChangeMetadataResponse("other", "transaction")),
                List.of(new AdvancedCommerceSubscriptionPriceChangeResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionPriceChangeResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionPriceChangeResponse("renewal", "other")),
                List.of(new AdvancedCommerceSubscriptionRevokeResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionRevokeResponse("renewal", "transaction"),
                        new AdvancedCommerceSubscriptionRevokeResponse("other", "transaction")));
        for (List<Object> pair : pairs) {
            Object a = pair.get(0);
            Assertions.assertEquals(a.getClass(), a.getClass().getDeclaredMethod("equals", Object.class).getDeclaringClass());
            Assertions.assertEquals(a.getClass(), a.getClass().getDeclaredMethod("hashCode").getDeclaringClass());
            assertEqualObjects(a, pair.get(1));
            assertNotEqualObjects(a, pair.get(2));
            ((AbstractAdvancedCommerceResponse) pair.get(1)).unknownFields(Map.of("newKey", "value"));
            assertNotEqualObjects(a, pair.get(1));
        }
        assertNotEqualObjects(new AdvancedCommerceSubscriptionCancelResponse("renewal", "transaction"),
                new AdvancedCommerceSubscriptionRevokeResponse("renewal", "transaction"));
    }

    @Test
    public void testAdvancedCommerceItemsCompareInheritedMembers() throws Exception {
        AdvancedCommerceSubscriptionMigrateItem migrateItem = new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "name");
        assertEqualObjects(migrateItem, new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "name"));
        assertNotEqualObjects(migrateItem, new AdvancedCommerceSubscriptionMigrateItem("sku2", "description", "name"));
        assertNotEqualObjects(migrateItem, new AdvancedCommerceSubscriptionMigrateItem("sku", "description2", "name"));
        assertNotEqualObjects(migrateItem, new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "name2"));
        assertNotEqualObjects(migrateItem, new AdvancedCommerceSubscriptionMigrateRenewalItem("sku", "description", "name"));

        AdvancedCommerceSubscriptionModifyRemoveItem removeItem = new AdvancedCommerceSubscriptionModifyRemoveItem("sku");
        assertEqualObjects(removeItem, new AdvancedCommerceSubscriptionModifyRemoveItem("sku"));
        assertNotEqualObjects(removeItem, new AdvancedCommerceSubscriptionModifyRemoveItem("sku2"));
        AdvancedCommerceSubscriptionReactivateItem reactivateItem = new AdvancedCommerceSubscriptionReactivateItem("sku");
        assertEqualObjects(reactivateItem, new AdvancedCommerceSubscriptionReactivateItem("sku"));
        assertNotEqualObjects(reactivateItem, new AdvancedCommerceSubscriptionReactivateItem("sku2"));
        assertNotEqualObjects(removeItem, reactivateItem);

        for (Class<?> type : List.of(AdvancedCommerceSubscriptionMigrateItem.class, AdvancedCommerceSubscriptionModifyRemoveItem.class,
                AdvancedCommerceSubscriptionReactivateItem.class)) {
            Assertions.assertEquals(type, type.getDeclaredMethod("equals", Object.class).getDeclaringClass());
            Assertions.assertEquals(type, type.getDeclaredMethod("hashCode").getDeclaringClass());
        }
    }

    @Test
    public void testRequestRefundItemEqualsComparesSkuThroughTheBaseClass() {
        AdvancedCommerceRequestRefundItem item = new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL,
                AdvancedCommerceRefundType.CUSTOM, true).refundAmount(1500L);
        AdvancedCommerceRequestRefundItem same = new AdvancedCommerceRequestRefundItem("sku", "LEGAL", "CUSTOM", true).refundAmount(1500L);
        assertEqualObjects(item, same);
        assertNotEqualObjects(item, new AdvancedCommerceRequestRefundItem("sku2", "LEGAL", "CUSTOM", true).refundAmount(1500L));
        assertNotEqualObjects(item, new AdvancedCommerceRequestRefundItem("sku", "LEGAL", "CUSTOM", true).refundAmount(1000L));
        Assertions.assertEquals(Objects.hash(item.getSku(), item.getRefundAmount(), item.getRawRefundReason(), item.getRawRefundType(),
                item.getRevoke()), item.hashCode());
    }

    @Test
    public void testUpdateAppAccountTokenRequestEqualsUsesTheExactClass() {
        UUID token = UUID.fromString("7389a31a-fb6d-4569-a2a6-db7d85d84813");
        UpdateAppAccountTokenRequest request = new UpdateAppAccountTokenRequest(token);
        assertEqualObjects(request, new UpdateAppAccountTokenRequest(token));
        assertNotEqualObjects(request, new UpdateAppAccountTokenRequest(UUID.fromString("00000000-0000-0000-0000-000000000000")));
        Assertions.assertNotEquals(request, null);
        Assertions.assertEquals(Objects.hash(token), request.hashCode());
        UpdateAppAccountTokenRequest subclass = new UpdateAppAccountTokenRequest(token) {
        };
        assertNotEqualObjects(request, subclass);
    }

    @Test
    public void testRawConstructorsOfAdvancedCommerceRequestTypes() {
        assertEqualObjects(new AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective.IMMEDIATELY),
                new AdvancedCommerceSubscriptionChangeMetadataDescriptors("IMMEDIATELY"));
        AdvancedCommerceSubscriptionChangeMetadataDescriptors changeMetadataDescriptors =
                new AdvancedCommerceSubscriptionChangeMetadataDescriptors("LATER");
        Assertions.assertNull(changeMetadataDescriptors.getEffective());
        Assertions.assertEquals("LATER", changeMetadataDescriptors.getRawEffective());
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionChangeMetadataDescriptors((String) null));

        assertEqualObjects(new AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective.NEXT_BILL_CYCLE),
                new AdvancedCommerceSubscriptionModifyDescriptors("NEXT_BILL_CYCLE"));
        AdvancedCommerceSubscriptionModifyDescriptors modifyDescriptors = new AdvancedCommerceSubscriptionModifyDescriptors("LATER");
        Assertions.assertNull(modifyDescriptors.getEffective());
        Assertions.assertEquals("LATER", modifyDescriptors.getRawEffective());
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyDescriptors((String) null));

        assertEqualObjects(new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", AdvancedCommerceEffective.IMMEDIATELY),
                new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", "IMMEDIATELY"));
        AdvancedCommerceSubscriptionChangeMetadataItem changeMetadataItem = new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", "LATER");
        Assertions.assertNull(changeMetadataItem.getEffective());
        Assertions.assertEquals("LATER", changeMetadataItem.getRawEffective());
        Assertions.assertEquals("currentSku", changeMetadataItem.getCurrentSku());
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", (String) null));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionChangeMetadataItem(null, "LATER"));

        assertEqualObjects(new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "name",
                        "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE),
                new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "name", "currentSku", "IMMEDIATELY", 1000L, "UPGRADE"));
        AdvancedCommerceSubscriptionModifyChangeItem modifyChangeItem = new AdvancedCommerceSubscriptionModifyChangeItem(
                "sku", "description", "name", "currentSku", "LATER", 1000L, "SIDEGRADE");
        Assertions.assertNull(modifyChangeItem.getEffective());
        Assertions.assertEquals("LATER", modifyChangeItem.getRawEffective());
        Assertions.assertNull(modifyChangeItem.getReason());
        Assertions.assertEquals("SIDEGRADE", modifyChangeItem.getRawReason());
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyChangeItem(
                "sku", "description", "name", "currentSku", null, 1000L, "UPGRADE"));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyChangeItem(
                "sku", "description", "name", "currentSku", "IMMEDIATELY", 1000L, null));

        List<AdvancedCommerceSubscriptionCreateItem> items = List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "name", 1000L));
        AdvancedCommerceDescriptors descriptors = new AdvancedCommerceDescriptors("description", "name");
        assertEqualObjects(new AdvancedCommerceSubscriptionCreateRequest(REQUEST_INFO, "USD", descriptors, items, AdvancedCommercePeriod.P1M, "taxCode"),
                new AdvancedCommerceSubscriptionCreateRequest(REQUEST_INFO, "USD", descriptors, items, "P1M", "taxCode"));
        AdvancedCommerceSubscriptionCreateRequest createRequest = new AdvancedCommerceSubscriptionCreateRequest(
                REQUEST_INFO, "USD", descriptors, items, "P2W", "taxCode");
        Assertions.assertNull(createRequest.getPeriod());
        Assertions.assertEquals("P2W", createRequest.getRawPeriod());
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionCreateRequest(
                REQUEST_INFO, "USD", descriptors, items, (String) null, "taxCode"));
    }

    @Test
    public void testModifyAddItemPriceIsBoxedAndRequired() throws Exception {
        Assertions.assertNotNull(AdvancedCommerceSubscriptionModifyAddItem.class.getConstructor(String.class, String.class, String.class, Long.class));
        Assertions.assertNotNull(AdvancedCommerceSubscriptionModifyAddItem.class.getMethod("price", Long.class));
        Assertions.assertThrows(NoSuchMethodException.class,
                () -> AdvancedCommerceSubscriptionModifyAddItem.class.getConstructor(String.class, String.class, String.class, long.class));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyAddItem("sku", "description", "name", null));
        AdvancedCommerceSubscriptionModifyAddItem item = new AdvancedCommerceSubscriptionModifyAddItem("sku", "description", "name", 1000L);
        Assertions.assertEquals(Long.valueOf(1000L), item.getPrice());
        Assertions.assertThrows(NullPointerException.class, () -> item.price(null));
        Assertions.assertThrows(NullPointerException.class, () -> item.setPrice(null));
    }

    @Test
    public void testConsumptionRequestBooleansAreBoxedAndRequired() throws Exception {
        ConsumptionRequest request = new ConsumptionRequest(false, DeliveryStatus.DELIVERED, false);
        Assertions.assertEquals(Boolean.FALSE, request.getCustomerConsented());
        Assertions.assertEquals(Boolean.FALSE, request.getSampleContentProvided());
        Assertions.assertEquals(Boolean.class, ConsumptionRequest.class.getMethod("getCustomerConsented").getReturnType());
        Assertions.assertEquals(Boolean.class, ConsumptionRequest.class.getMethod("getSampleContentProvided").getReturnType());
        Assertions.assertEquals(Map.of("customerConsented", false, "sampleContentProvided", false, "deliveryStatus", "DELIVERED"), serialize(request));
        assertEqualObjects(request, new ConsumptionRequest(false, "DELIVERED", false));
        assertNotEqualObjects(request, new ConsumptionRequest(true, DeliveryStatus.DELIVERED, false));

        Assertions.assertThrows(NullPointerException.class, () -> new ConsumptionRequest(null, DeliveryStatus.DELIVERED, true));
        Assertions.assertThrows(NullPointerException.class, () -> new ConsumptionRequest(true, DeliveryStatus.DELIVERED, null));
        Assertions.assertThrows(NullPointerException.class, () -> new ConsumptionRequest(null, "DELIVERED", true));
        Assertions.assertThrows(NullPointerException.class, () -> new ConsumptionRequest(true, "DELIVERED", null));
        Assertions.assertThrows(NullPointerException.class, () -> request.customerConsented(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setCustomerConsented(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.sampleContentProvided(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setSampleContentProvided(null));
    }

    private static final Set<String> EXPECTED_ADDERS = Set.of(
            "AdvancedCommercePriceIncreaseInfo.addDependentSKU",
            "AdvancedCommerceRenewalInfo.addItem",
            "AdvancedCommerceRequestRefundRequest.addItem",
            "AdvancedCommerceSubscriptionChangeMetadataRequest.addItem",
            "AdvancedCommerceSubscriptionCreateRequest.addItem",
            "AdvancedCommerceSubscriptionMigrateRequest.addItem",
            "AdvancedCommerceSubscriptionMigrateRequest.addRenewalItem",
            "AdvancedCommerceSubscriptionModifyInAppRequest.addAddItem",
            "AdvancedCommerceSubscriptionModifyInAppRequest.addChangeItem",
            "AdvancedCommerceSubscriptionModifyInAppRequest.addRemoveItem",
            "AdvancedCommerceSubscriptionPriceChangeItem.addDependentSKU",
            "AdvancedCommerceSubscriptionPriceChangeRequest.addItem",
            "AdvancedCommerceSubscriptionReactivateInAppRequest.addItem",
            "AdvancedCommerceTransactionInfo.addItem",
            "AdvancedCommerceTransactionItem.addRefund",
            "CheckTestNotificationResponse.addSendAttempt",
            "GetCustomerGroupsResponse.addGroup",
            "GetGroupMembersResponse.addMember",
            "GetImageListResponse.addImageIdentifier",
            "GetMessageListResponse.addMessageIdentifier",
            "GroupEntry.addRole",
            "HistoryResponse.addSignedTransaction",
            "JWSRenewalInfoDecodedPayload.addEligibleWinBackOfferId",
            "MassExtendRenewalDateRequest.addStorefrontCountryCode",
            "NotificationHistoryResponse.addNotificationHistory",
            "NotificationHistoryResponseItem.addSendAttempt",
            "OrderLookupResponse.addSignedTransaction",
            "RefundHistoryResponse.addSignedTransaction",
            "StatusResponse.addData",
            "SubscriptionGroupIdentifierItem.addLastTransaction",
            "Summary.addStorefrontCountryCode",
            "UploadMessageRequestBody.addBulletPoint");

    private static List<Class<?>> modelClasses() throws Exception {
        String pkg = AppTransaction.class.getPackageName();
        URL root = AppTransaction.class.getProtectionDomain().getCodeSource().getLocation();
        List<Class<?>> classes = new ArrayList<>();
        String[] names = new File(new File(root.toURI()), pkg.replace('.', File.separatorChar)).list();
        Assertions.assertNotNull(names);
        Arrays.sort(names);
        for (String fileName : names) {
            if (fileName.endsWith(".class") && !fileName.contains("$")) {
                classes.add(Class.forName(pkg + "." + fileName.substring(0, fileName.length() - ".class".length())));
            }
        }
        return classes;
    }

    private static Object sampleElement(Class<?> type) throws Exception {
        return type == String.class ? "abc" : newInstance(type);
    }

    private static String upperFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    @Test
    public void testEveryListFieldHasANullRejectingAdderNamedAfterTheSingularJsonKey() throws Exception {
        Set<String> found = new TreeSet<>();
        for (Class<?> type : modelClasses()) {
            if (type.isEnum() || type.isInterface() || Modifier.isAbstract(type.getModifiers())) {
                continue;
            }
            for (Field field : type.getDeclaredFields()) {
                JsonProperty property = field.getAnnotation(JsonProperty.class);
                if (property == null || field.getType() != List.class) {
                    continue;
                }
                String key = property.value();
                String adderName = "add" + upperFirst(key.endsWith("s") ? key.substring(0, key.length() - 1) : key);
                Class<?> elementType = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                Method adder = type.getMethod(adderName, elementType);
                Assertions.assertEquals(type, adder.getReturnType(), adderName);
                Assertions.assertFalse(adder.isAnnotationPresent(Deprecated.class), adderName);
                found.add(type.getSimpleName() + "." + adderName);

                Object instance = newInstance(type);
                if (property.required()) {
                    field.setAccessible(true);
                    field.set(instance, new ArrayList<>());
                }
                InvocationTargetException e = Assertions.assertThrows(InvocationTargetException.class, () -> adder.invoke(instance, (Object) null));
                Assertions.assertInstanceOf(NullPointerException.class, e.getCause(), type.getSimpleName() + "." + adderName);
                Object element = sampleElement(elementType);
                Assertions.assertSame(instance, adder.invoke(instance, element));
                Assertions.assertSame(instance, adder.invoke(instance, element));
                Method getter = type.getMethod("get" + upperFirst(field.getName()));
                Assertions.assertEquals(List.of(element, element), getter.invoke(instance));
            }
        }
        Assertions.assertEquals(new TreeSet<>(EXPECTED_ADDERS), found);
    }

    @Test
    public void testPreviousAdderNamesWereRemoved() {
        List<List<Object>> removed = List.of(
                List.of(GetCustomerGroupsResponse.class, "addGroupsItem"),
                List.of(GetGroupMembersResponse.class, "addMembersItem"),
                List.of(GroupEntry.class, "addRolesItem"),
                List.of(HistoryResponse.class, "addSignedTransactionsItem"),
                List.of(MassExtendRenewalDateRequest.class, "addStorefrontCountryCodesItem"),
                List.of(NotificationHistoryResponse.class, "addNotificationHistoryItem"),
                List.of(OrderLookupResponse.class, "addSignedTransactionsItem"),
                List.of(RefundHistoryResponse.class, "addSignedTransactionsItem"),
                List.of(StatusResponse.class, "addDataItem"),
                List.of(SubscriptionGroupIdentifierItem.class, "addLastTransactionsItem"),
                List.of(Summary.class, "addStorefrontCountryCodesItem"));
        for (List<Object> r : removed) {
            Class<?> type = (Class<?>) r.get(0);
            Assertions.assertTrue(Arrays.stream(type.getMethods()).noneMatch(m -> m.getName().equals(r.get(1))),
                    type.getSimpleName() + "." + r.get(1));
        }
    }

    @Test
    public void testModelsHaveNoDeprecatedMembers() throws Exception {
        Set<String> deprecatedTypes = new TreeSet<>();
        for (Class<?> type : modelClasses()) {
            if (type.isAnnotationPresent(Deprecated.class)) {
                deprecatedTypes.add(type.getSimpleName());
            }
            for (Method method : type.getDeclaredMethods()) {
                Assertions.assertFalse(method.isAnnotationPresent(Deprecated.class), type.getSimpleName() + "." + method.getName());
            }
            for (Constructor<?> constructor : type.getDeclaredConstructors()) {
                Assertions.assertFalse(constructor.isAnnotationPresent(Deprecated.class), constructor.toString());
            }
            for (Field field : type.getDeclaredFields()) {
                Assertions.assertFalse(field.isAnnotationPresent(Deprecated.class), type.getSimpleName() + "." + field.getName());
            }
        }
        Assertions.assertEquals(new TreeSet<>(List.of("ConsumptionRequestV1", "DeliveryStatusV1", "RefundPreferenceV1")), deprecatedTypes);
        Assertions.assertThrows(NoSuchMethodException.class, () -> AdvancedCommerceRequestInfo.class.getMethod("consistencyToken"));
        Assertions.assertThrows(NoSuchMethodException.class,
                () -> UploadMessageRequestBody.class.getConstructor(String.class, String.class, UploadMessageImage.class));
    }

    @Test
    public void testBulletPointAdderKeepsTheMaximumCount() {
        UploadMessageRequestBody body = new UploadMessageRequestBody("header", "body");
        for (int i = 0; i < 5; i++) {
            body.addBulletPoint(new BulletPoint("text " + i, UUID.randomUUID(), "alt text"));
        }
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> body.addBulletPoint(new BulletPoint("text 5", UUID.randomUUID(), "alt text")));
        Assertions.assertEquals(5, body.getBulletPoints().size());
    }

    @Test
    public void testAdvancedCommerceRequestAddersStillRejectNull() {
        AdvancedCommerceSubscriptionPriceChangeItem item = new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L);
        Assertions.assertThrows(NullPointerException.class, () -> item.addDependentSKU(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> item.addDependentSKU("x".repeat(129)));
        Assertions.assertEquals(List.of("dependent"), item.addDependentSKU("dependent").getDependentSKUs());
    }

    @Test
    public void testSkuMemberNames() throws Exception {
        AdvancedCommerceSubscriptionModifyChangeItem modifyChangeItem = new AdvancedCommerceSubscriptionModifyChangeItem(
                "sku", "description", "name", "current", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE);
        Assertions.assertEquals("current", modifyChangeItem.getCurrentSku());
        Assertions.assertEquals("sku", modifyChangeItem.getSku());
        Assertions.assertEquals(String.class, AdvancedCommerceSubscriptionModifyChangeItem.class.getDeclaredField("currentSku").getType());
        Assertions.assertEquals(String.class, AdvancedCommerceSubscriptionChangeMetadataItem.class.getDeclaredField("currentSku").getType());
        Assertions.assertEquals(String.class, AdvancedCommerceRenewalItem.class.getDeclaredField("sku").getType());
        Assertions.assertEquals(String.class, AdvancedCommerceTransactionItem.class.getDeclaredField("sku").getType());
        Assertions.assertEquals(String.class, AdvancedCommerceSubscriptionChangeMetadataItem.class.getDeclaredField("sku").getType());
        Assertions.assertNotNull(AdvancedCommerceRenewalItem.class.getMethod("getSku"));
        Assertions.assertNotNull(AdvancedCommerceTransactionItem.class.getMethod("getSku"));
        Assertions.assertNotNull(AdvancedCommerceSubscriptionChangeMetadataItem.class.getMethod("getCurrentSku"));

        for (String alias : List.of("currentSKU", "getCurrentSKU", "setCurrentSKU")) {
            Assertions.assertTrue(Arrays.stream(AdvancedCommerceSubscriptionModifyChangeItem.class.getMethods())
                    .noneMatch(m -> m.getName().equals(alias)), alias);
        }
        modifyChangeItem.setCurrentSku("current2");
        Map<String, Object> json = serialize(modifyChangeItem);
        Assertions.assertEquals("current2", json.get("currentSKU"));
        Assertions.assertEquals("sku", json.get("SKU"));
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        Map<?, ?> defaultJson = defaultObjectMapper.readValue(defaultObjectMapper.writeValueAsString(modifyChangeItem), Map.class);
        Assertions.assertEquals("current2", defaultJson.get("currentSKU"));
        Assertions.assertFalse(defaultJson.containsKey("currentSku"));
        Assertions.assertEquals("decoded", defaultObjectMapper.readValue(
                "{\"currentSKU\": \"decoded\"}", AdvancedCommerceSubscriptionModifyChangeItem.class).getCurrentSku());
    }

    @Test
    public void testDescriptorsFieldsArePrivate() throws Exception {
        for (String name : List.of("description", "displayName", "unknownFields")) {
            Assertions.assertTrue(Modifier.isPrivate(AdvancedCommerceDescriptors.class.getDeclaredField(name).getModifiers()), name);
        }
        AdvancedCommerceSubscriptionMigrateDescriptors descriptors = new AdvancedCommerceSubscriptionMigrateDescriptors("description", "name");
        Assertions.assertEquals("description", descriptors.getDescription());
        Assertions.assertEquals("name", descriptors.getDisplayName());
        Assertions.assertEquals(Map.of("description", "description", "displayName", "name"), serialize(descriptors));
        assertEqualObjects(descriptors, new AdvancedCommerceSubscriptionMigrateDescriptors("description", "name"));
        assertNotEqualObjects(descriptors, new AdvancedCommerceSubscriptionMigrateDescriptors("description", "name2"));
        assertNotEqualObjects(descriptors, new AdvancedCommerceDescriptors("description", "name"));
    }

    @Test
    public void testDecodedRetentionMessagingResponsesSerializeNullValues() throws Exception {
        Assertions.assertNull(DefaultConfigurationResponse.class.getAnnotation(JsonInclude.class));
        Assertions.assertNull(RealtimeUrlResponse.class.getAnnotation(JsonInclude.class));
        Assertions.assertNotNull(DefaultConfigurationRequest.class.getAnnotation(JsonInclude.class));
        Assertions.assertNotNull(RealtimeUrlRequest.class.getAnnotation(JsonInclude.class));

        Assertions.assertEquals("{\"realtimeURL\":null}", objectMapper.writeValueAsString(newInstance(RealtimeUrlResponse.class)));
        Assertions.assertEquals("{\"messageIdentifier\":null}", objectMapper.writeValueAsString(newInstance(DefaultConfigurationResponse.class)));
        RealtimeUrlResponse decoded = objectMapper.readValue("{\"realtimeURL\": \"https://example.com/realtime\"}", RealtimeUrlResponse.class);
        Assertions.assertEquals("{\"realtimeURL\":\"https://example.com/realtime\"}", objectMapper.writeValueAsString(decoded));
    }

    @Test
    public void testAppTransactionHasAPublicNoArgConstructor() throws Exception {
        Assertions.assertTrue(Modifier.isPublic(AppTransaction.class.getConstructor().getModifiers()));
        Assertions.assertEquals(1, AppTransaction.class.getDeclaredConstructors().length);
        Assertions.assertEquals(new AppTransaction(), new AppTransaction());
    }

    @Test
    public void testSummaryRequestIdentifierIsAUuid() throws Exception {
        Summary summary = objectMapper.readValue("{\"requestIdentifier\": \"EFB27071-45A4-4ACA-9854-2A1E9146F265\"}", Summary.class);
        Assertions.assertEquals(UUID.fromString("efb27071-45a4-4aca-9854-2a1e9146f265"), summary.getRequestIdentifier());
        Assertions.assertEquals(UUID.class, Summary.class.getMethod("getRequestIdentifier").getReturnType());
        Assertions.assertThrows(JsonMappingException.class,
                () -> objectMapper.readValue("{\"requestIdentifier\": \"not-a-uuid\"}", Summary.class));
    }

    @Test
    public void testDecodedModelsCheckTheirDocumentedLimits() throws Exception {
        Assertions.assertEquals(12, objectMapper.readValue("{\"billingPeriodNumber\": 12}", TransactionCommitmentInfo.class).getBillingPeriodNumber());
        Assertions.assertEquals(100000, objectMapper.readValue("{\"revocationPercentage\": 100000}", JWSTransactionDecodedPayload.class).getRevocationPercentage());
        Assertions.assertEquals(List.of("USA"), objectMapper.readValue("{\"storefrontCountryCodes\": [\"USA\"]}", Summary.class).getStorefrontCountryCodes());
        String requestIdentifier = "a".repeat(128);
        Assertions.assertEquals(requestIdentifier, objectMapper.readValue("{\"requestIdentifier\": \"" + requestIdentifier + "\"}", MassExtendRenewalDateResponse.class).getRequestIdentifier());
        Assertions.assertEquals(requestIdentifier, objectMapper.readValue("{\"requestIdentifier\": \"" + requestIdentifier + "\"}", MassExtendRenewalDateStatusResponse.class).getRequestIdentifier());
        String realtimeURL = "a".repeat(256);
        Assertions.assertEquals(realtimeURL, objectMapper.readValue("{\"realtimeURL\": \"" + realtimeURL + "\"}", RealtimeUrlResponse.class).getRealtimeURL());

        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"billingPeriodNumber\": 0}", TransactionCommitmentInfo.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"billingPeriodNumber\": 13}", TransactionCommitmentInfo.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"revocationPercentage\": -1}", JWSTransactionDecodedPayload.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"revocationPercentage\": 100001}", JWSTransactionDecodedPayload.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"storefrontCountryCodes\": [\"USAA\"]}", Summary.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"requestIdentifier\": \"" + requestIdentifier + "a\"}", MassExtendRenewalDateResponse.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"requestIdentifier\": \"" + requestIdentifier + "a\"}", MassExtendRenewalDateStatusResponse.class));
        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue("{\"realtimeURL\": \"" + realtimeURL + "a\"}", RealtimeUrlResponse.class));
    }

    @Test
    public void testEnumConstantsFollowTheDocumentationOrder() {
        Assertions.assertEquals(List.of(TokenType.ACQUISITION, TokenType.SERVICES, TokenType.CORE_TECHNOLOGY), List.of(TokenType.values()));
        Assertions.assertEquals(List.of(PurchasePlatform.MAC_OS, PurchasePlatform.IOS, PurchasePlatform.TV_OS, PurchasePlatform.VISION_OS),
                List.of(PurchasePlatform.values()));
        List<Subtype> subtypes = List.of(Subtype.values());
        Assertions.assertEquals(List.of(Subtype.UNREPORTED, Subtype.CREATED, Subtype.ACTIVE_TOKEN_REMINDER), subtypes.subList(subtypes.size() - 3, subtypes.size()));
        List<NotificationTypeV2> types = List.of(NotificationTypeV2.values());
        Assertions.assertEquals(List.of(NotificationTypeV2.ONE_TIME_CHARGE, NotificationTypeV2.PRICE_CHANGE, NotificationTypeV2.METADATA_UPDATE,
                NotificationTypeV2.MIGRATION, NotificationTypeV2.RESCIND_CONSENT), types.subList(types.size() - 5, types.size()));
    }

    @Test
    public void testConstructorsTakeBaseMembersThenRequiredFieldsInDocumentationOrder() {
        AdvancedCommerceOffer offer = new AdvancedCommerceOffer(AdvancedCommerceOfferPeriod.P1M, 2, 500L, AdvancedCommerceOfferReason.ACQUISITION);
        Assertions.assertEquals(500L, offer.getPrice());
        Assertions.assertEquals(AdvancedCommerceOfferPeriod.P1M, offer.getPeriod());
        Assertions.assertEquals(2, offer.getPeriodCount());
        Assertions.assertEquals(AdvancedCommerceOfferReason.ACQUISITION, offer.getReason());
        assertEqualObjects(offer, new AdvancedCommerceOffer("P1M", 2, 500L, "ACQUISITION"));

        AdvancedCommerceOneTimeChargeItem item = new AdvancedCommerceOneTimeChargeItem("description", "display name", "sku", 1000L);
        AdvancedCommerceOneTimeChargeCreateRequest oneTimeChargeCreateRequest = new AdvancedCommerceOneTimeChargeCreateRequest(REQUEST_INFO, "USD", item, "taxCode");
        Assertions.assertEquals(REQUEST_INFO, oneTimeChargeCreateRequest.getRequestInfo());
        Assertions.assertEquals("USD", oneTimeChargeCreateRequest.getCurrency());
        Assertions.assertEquals("taxCode", oneTimeChargeCreateRequest.getTaxCode());
        Assertions.assertEquals(item, oneTimeChargeCreateRequest.getItem());

        AdvancedCommerceRequestRefundItem refundItem = new AdvancedCommerceRequestRefundItem("sku", "LEGAL", "FULL", true);
        Assertions.assertEquals("sku", refundItem.getSku());
        Assertions.assertEquals("FULL", refundItem.getRawRefundType());
        Assertions.assertEquals(true, refundItem.getRevoke());
        Assertions.assertEquals("LEGAL", refundItem.getRawRefundReason());
        assertEqualObjects(refundItem, new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, true));
        AdvancedCommerceRequestRefundRequest refundRequest = new AdvancedCommerceRequestRefundRequest(REQUEST_INFO, List.of(refundItem), false);
        Assertions.assertEquals(REQUEST_INFO, refundRequest.getRequestInfo());
        Assertions.assertEquals(List.of(refundItem), refundRequest.getItems());
        Assertions.assertEquals(false, refundRequest.getRefundRiskingPreference());

        AdvancedCommerceSubscriptionChangeMetadataItem changeMetadataItem = new AdvancedCommerceSubscriptionChangeMetadataItem("current", "LATER");
        Assertions.assertEquals("LATER", changeMetadataItem.getRawEffective());
        Assertions.assertEquals("current", changeMetadataItem.getCurrentSku());

        AdvancedCommerceDescriptors descriptors = new AdvancedCommerceDescriptors("description", "display name");
        List<AdvancedCommerceSubscriptionCreateItem> createItems = List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L));
        AdvancedCommerceSubscriptionCreateRequest createRequest = new AdvancedCommerceSubscriptionCreateRequest(REQUEST_INFO, "USD", descriptors, createItems, "P1M", "taxCode");
        Assertions.assertEquals("USD", createRequest.getCurrency());
        Assertions.assertEquals("taxCode", createRequest.getTaxCode());
        Assertions.assertEquals(AdvancedCommercePeriod.P1M, createRequest.getPeriod());
        Assertions.assertEquals(descriptors, createRequest.getDescriptors());
        Assertions.assertEquals(createItems, createRequest.getItems());

        AdvancedCommerceSubscriptionMigrateDescriptors migrateDescriptors = new AdvancedCommerceSubscriptionMigrateDescriptors("description", "display name");
        List<AdvancedCommerceSubscriptionMigrateItem> migrateItems = List.of(new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "display name"));
        AdvancedCommerceSubscriptionMigrateRequest migrateRequest = new AdvancedCommerceSubscriptionMigrateRequest(REQUEST_INFO, migrateDescriptors, migrateItems, "targetProductId", "taxCode");
        Assertions.assertEquals("targetProductId", migrateRequest.getTargetProductId());
        Assertions.assertEquals(migrateDescriptors, migrateRequest.getDescriptors());
        Assertions.assertEquals("taxCode", migrateRequest.getTaxCode());
        Assertions.assertEquals(migrateItems, migrateRequest.getItems());

        AdvancedCommerceSubscriptionRevokeRequest revokeRequest = new AdvancedCommerceSubscriptionRevokeRequest(REQUEST_INFO, "LEGAL", true, "FULL");
        Assertions.assertEquals("LEGAL", revokeRequest.getRawRefundReason());
        Assertions.assertEquals("FULL", revokeRequest.getRawRefundType());
        Assertions.assertEquals(true, revokeRequest.getRefundRiskingPreference());

        ConsumptionRequest consumptionRequest = new ConsumptionRequest(true, DeliveryStatus.DELIVERED, false);
        Assertions.assertEquals(true, consumptionRequest.getCustomerConsented());
        Assertions.assertEquals(false, consumptionRequest.getSampleContentProvided());
        Assertions.assertEquals(DeliveryStatus.DELIVERED, consumptionRequest.getDeliveryStatus());

        ExternalPurchaseToken token = new ExternalPurchaseToken("b2158121-7af9-49d4-9561-1f588205523e", 1698148950000L, 55555L, "com.example");
        Assertions.assertEquals(55555L, token.getAppAppleId());
        Assertions.assertEquals("com.example", token.getBundleId());
        Assertions.assertEquals(1698148950000L, token.getTokenCreationDate());
        Assertions.assertEquals("b2158121-7af9-49d4-9561-1f588205523e", token.getExternalPurchaseId());

        AdvancedCommerceDescriptors ruleDescriptors = new AdvancedCommerceDescriptors("description", "display name");
        Assertions.assertEquals("description", ruleDescriptors.getDescription());
        Assertions.assertEquals("display name", ruleDescriptors.getDisplayName());
        AdvancedCommerceSubscriptionMigrateDescriptors ruleMigrateDescriptors = new AdvancedCommerceSubscriptionMigrateDescriptors("description", "display name");
        Assertions.assertEquals("description", ruleMigrateDescriptors.getDescription());
        Assertions.assertEquals("display name", ruleMigrateDescriptors.getDisplayName());
        for (AdvancedCommerceSubscriptionModifyPeriodChange periodChange : List.of(
                new AdvancedCommerceSubscriptionModifyPeriodChange(AdvancedCommerceEffective.IMMEDIATELY, AdvancedCommercePeriod.P1M),
                new AdvancedCommerceSubscriptionModifyPeriodChange("IMMEDIATELY", "P1M"))) {
            Assertions.assertEquals("IMMEDIATELY", periodChange.getRawEffective());
            Assertions.assertEquals("P1M", periodChange.getRawPeriod());
        }

        AdvancedCommerceSubscriptionModifyChangeItem changeItem = new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name",
                "current", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE);
        AdvancedCommerceSubscriptionModifyChangeItem rawChangeItem = new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name",
                "current", "IMMEDIATELY", 1000L, "UPGRADE");
        for (AdvancedCommerceSubscriptionModifyChangeItem i : List.of(changeItem, rawChangeItem)) {
            Assertions.assertEquals("current", i.getCurrentSku());
            Assertions.assertEquals("description", i.getDescription());
            Assertions.assertEquals("display name", i.getDisplayName());
            Assertions.assertEquals("IMMEDIATELY", i.getRawEffective());
            Assertions.assertEquals(1000L, i.getPrice());
            Assertions.assertEquals("UPGRADE", i.getRawReason());
            Assertions.assertEquals("sku", i.getSku());
        }
    }

    @Test
    public void testSilentOrderConstructorsKeepTheirV520Order() {
        AdvancedCommerceOneTimeChargeItem oneTimeChargeItem = new AdvancedCommerceOneTimeChargeItem("description", "display name", "sku", 1000L);
        Assertions.assertEquals("description", oneTimeChargeItem.getDescription());
        Assertions.assertEquals("display name", oneTimeChargeItem.getDisplayName());
        Assertions.assertEquals("sku", oneTimeChargeItem.getSku());
        Assertions.assertEquals(1000L, oneTimeChargeItem.getPrice());

        BulletPoint bulletPoint = new BulletPoint("text", UUID.fromString("b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901"), "alt text");
        Assertions.assertEquals("text", bulletPoint.getText());
        Assertions.assertEquals(UUID.fromString("b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901"), bulletPoint.getImageIdentifier());
        Assertions.assertEquals("alt text", bulletPoint.getAltText());
    }
}
