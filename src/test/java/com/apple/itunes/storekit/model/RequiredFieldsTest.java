// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import com.apple.itunes.storekit.verification.SignedDataVerifier;
import com.apple.itunes.storekit.verification.VerificationException;
import com.apple.itunes.storekit.verification.VerificationStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RequiredFieldsTest {

    private static final String REQUEST_IDENTIFIER = "fdf964a4-233b-486c-aac1-97d8d52688ac";
    private static final UUID MESSAGE_IDENTIFIER = UUID.fromString("b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901");

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

    static Stream<Class<?>> modelsWithRequiredFields() {
        return Stream.of(
                AlternateProduct.class,
                ConsumptionRequestV1.class,
                DefaultConfigurationRequest.class,
                ExtendRenewalDateRequest.class,
                MassExtendRenewalDateRequest.class,
                NotificationHistoryRequest.class,
                AdvancedCommerceSubscriptionPriceChangeRequest.class,
                DecodedRealtimeRequestBody.class,
                DefaultConfigurationResponse.class,
                ExternalPurchaseToken.class,
                PerformanceTestConfig.class,
                PerformanceTestResponse.class,
                PerformanceTestResponseTimes.class,
                PerformanceTestResultResponse.class,
                RealtimeUrlResponse.class,
                AdvancedCommerceRequestRefundResponse.class,
                AdvancedCommerceSubscriptionCancelResponse.class,
                AdvancedCommerceSubscriptionChangeMetadataResponse.class,
                AdvancedCommerceSubscriptionMigrateResponse.class,
                AdvancedCommerceSubscriptionPriceChangeResponse.class,
                AdvancedCommerceSubscriptionRevokeResponse.class);
    }

    @ParameterizedTest
    @MethodSource("modelsWithRequiredFields")
    public void testNoPublicNoArgumentConstructor(Class<?> modelClass) {
        for (Constructor<?> constructor : modelClass.getDeclaredConstructors()) {
            if (constructor.getParameterCount() == 0) {
                Assertions.assertFalse(Modifier.isPublic(constructor.getModifiers()));
            }
        }
    }

    @Test
    public void testConsumptionRequestV1RequiredFields() throws JsonProcessingException {
        Function<Object[], ConsumptionRequestV1> typed = args -> new ConsumptionRequestV1((AccountTenure) args[6], (UUID) args[5], (ConsumptionStatus) args[1], (Boolean) args[0], (DeliveryStatusV1) args[4], (LifetimeDollarsPurchased) args[9], (LifetimeDollarsRefunded) args[8], (Platform) args[2], (PlayTime) args[7], (Boolean) args[3], (UserStatus) args[10]);
        Object[] typedArguments = {true, ConsumptionStatus.NOT_CONSUMED, Platform.NON_APPLE, false, DeliveryStatusV1.DID_NOT_DELIVER_DUE_TO_SERVER_OUTAGE, UUID.fromString("7389a31a-fb6d-4569-a2a6-db7d85d84813"), AccountTenure.THIRTY_DAYS_TO_NINETY_DAYS, PlayTime.ONE_DAY_TO_FOUR_DAYS, LifetimeDollarsRefunded.ZERO_DOLLARS, LifetimeDollarsPurchased.TWO_THOUSAND_DOLLARS_OR_GREATER, UserStatus.LIMITED_ACCESS};
        Function<Object[], ConsumptionRequestV1> raw = args -> new ConsumptionRequestV1((Integer) args[6], (UUID) args[5], (Integer) args[1], (Boolean) args[0], (Integer) args[4], (Integer) args[9], (Integer) args[8], (Integer) args[2], (Integer) args[7], (Boolean) args[3], (Integer) args[10]);
        Object[] rawArguments = {true, 1, 2, false, 3, UUID.fromString("7389a31a-fb6d-4569-a2a6-db7d85d84813"), 4, 5, 1, 7, 4};
        assertEachArgumentRequired(typed, typedArguments, 5);
        assertEachArgumentRequired(raw, rawArguments, 5);

        ConsumptionRequestV1 request = typed.apply(typedArguments);
        Assertions.assertEquals(raw.apply(rawArguments), request);
        Assertions.assertEquals(Set.of("customerConsented", "consumptionStatus", "platform", "sampleContentProvided", "deliveryStatus", "appAccountToken", "accountTenure", "playTime", "lifetimeDollarsRefunded", "lifetimeDollarsPurchased", "userStatus"), serialize(request).keySet());

        Object[] withoutAppAccountToken = typedArguments.clone();
        withoutAppAccountToken[5] = null;
        Assertions.assertEquals("", serialize(typed.apply(withoutAppAccountToken)).get("appAccountToken"));

        Assertions.assertThrows(NullPointerException.class, () -> request.customerConsented(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.platform(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setPlayTime(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setRawUserStatus(null));
        Assertions.assertEquals(UserStatus.LIMITED_ACCESS, request.getUserStatus());
    }

    @Test
    public void testExtendRenewalDateRequestRequiredFields() throws JsonProcessingException {
        assertEachArgumentRequired(args -> new ExtendRenewalDateRequest((Integer) args[0], (ExtendReasonCode) args[1], (String) args[2]),
                new Object[]{45, ExtendReasonCode.CUSTOMER_SATISFACTION, REQUEST_IDENTIFIER});
        assertEachArgumentRequired(args -> new ExtendRenewalDateRequest((Integer) args[0], (Integer) args[1], (String) args[2]),
                new Object[]{45, 1, REQUEST_IDENTIFIER});

        ExtendRenewalDateRequest request = new ExtendRenewalDateRequest(45, ExtendReasonCode.CUSTOMER_SATISFACTION, REQUEST_IDENTIFIER);
        Assertions.assertEquals(Map.of("extendByDays", 45, "extendReasonCode", 1, "requestIdentifier", REQUEST_IDENTIFIER), serialize(request));
        Assertions.assertThrows(NullPointerException.class, () -> request.extendByDays(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setRequestIdentifier(null));
        Assertions.assertEquals(45, request.getExtendByDays());
        Assertions.assertEquals(REQUEST_IDENTIFIER, request.getRequestIdentifier());
    }

    @Test
    public void testMassExtendRenewalDateRequestRequiredFields() throws JsonProcessingException {
        assertEachArgumentRequired(args -> new MassExtendRenewalDateRequest((String) args[2], (Integer) args[0], (ExtendReasonCode) args[1], (String) args[3]),
                new Object[]{45, ExtendReasonCode.OTHER, REQUEST_IDENTIFIER, "com.example.productId"});
        assertEachArgumentRequired(args -> new MassExtendRenewalDateRequest((String) args[2], (Integer) args[0], (Integer) args[1], (String) args[3]),
                new Object[]{45, 2, REQUEST_IDENTIFIER, "com.example.productId"});

        MassExtendRenewalDateRequest request = new MassExtendRenewalDateRequest(REQUEST_IDENTIFIER, 45, ExtendReasonCode.OTHER, "com.example.productId");
        Assertions.assertEquals(Map.of("extendByDays", 45, "extendReasonCode", 2, "requestIdentifier", REQUEST_IDENTIFIER, "productId", "com.example.productId"), serialize(request));
        Assertions.assertThrows(NullPointerException.class, () -> request.productId(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setExtendByDays(null));
        Assertions.assertEquals("com.example.productId", request.getProductId());
    }

    @Test
    public void testNotificationHistoryRequestRequiredFields() throws JsonProcessingException {
        assertEachArgumentRequired(args -> new NotificationHistoryRequest((Long) args[0], (Long) args[1]),
                new Object[]{1698148900000L, 1698148950000L});

        NotificationHistoryRequest request = new NotificationHistoryRequest(1698148900000L, 1698148950000L);
        Assertions.assertEquals(Map.of("startDate", 1698148900000L, "endDate", 1698148950000L), serialize(request));
        Assertions.assertThrows(NullPointerException.class, () -> request.startDate(null));
        Assertions.assertThrows(NullPointerException.class, () -> request.setEndDate(null));
        Assertions.assertEquals(1698148950000L, request.getEndDate());
    }

    @Test
    public void testAlternateProductRequiredFields() throws JsonProcessingException {
        assertEachArgumentRequired(args -> new AlternateProduct((UUID) args[0], (String) args[1]),
                new Object[]{MESSAGE_IDENTIFIER, "com.example.product"});

        AlternateProduct alternateProduct = new AlternateProduct(MESSAGE_IDENTIFIER, "com.example.product");
        Assertions.assertEquals(Map.of("messageIdentifier", MESSAGE_IDENTIFIER.toString(), "productId", "com.example.product"), serialize(alternateProduct));
        Assertions.assertThrows(NullPointerException.class, () -> alternateProduct.messageIdentifier(null));
        Assertions.assertThrows(NullPointerException.class, () -> alternateProduct.setProductId(null));
        Assertions.assertEquals("com.example.product", alternateProduct.getProductId());
    }

    @Test
    public void testDecodedModelConstructorsRequireFields() {
        PerformanceTestConfig config = new PerformanceTestConfig(10L, 500L, 95, 60000L, 100L);
        PerformanceTestResponseTimes responseTimes = new PerformanceTestResponseTimes(120L, 100L, 200L, 250L, 400L);

        assertEachArgumentRequired(args -> new ExternalPurchaseToken((String) args[3], (Long) args[2], (Long) args[0], (String) args[1]),
                new Object[]{55555L, "com.example", 1698148950000L, "b2158121-7af9-49d4-9561-1f588205523e"});
        assertEachArgumentRequired(args -> new PerformanceTestConfig((Long) args[0], (Long) args[3], (Integer) args[4], (Long) args[2], (Long) args[1]),
                new Object[]{10L, 100L, 60000L, 500L, 95});
        assertEachArgumentRequired(args -> new PerformanceTestResponseTimes((Long) args[0], (Long) args[1], (Long) args[2], (Long) args[3], (Long) args[4]),
                new Object[]{120L, 100L, 200L, 250L, 400L});
        assertEachArgumentRequired(args -> new PerformanceTestResponse((PerformanceTestConfig) args[0], (UUID) args[1]),
                new Object[]{config, UUID.fromString("c4b87a1d-2e3f-4a5b-9c6d-7e8f9a0b1c2d")});
        assertEachArgumentRequired(args -> new PerformanceTestResultResponse((PerformanceTestConfig) args[0], castFailures(args[6]), (Integer) args[4], (PerformanceTestResponseTimes) args[5], (PerformanceTestStatus) args[2], (Integer) args[3], (String) args[1]),
                new Object[]{config, "https://example.com/retention", PerformanceTestStatus.PASS, 98, 0, responseTimes, Map.of(SendAttemptResult.TIMED_OUT, 1)});
        assertEachArgumentRequired(args -> new PerformanceTestResultResponse((PerformanceTestConfig) args[0], castRawFailures(args[6]), (Integer) args[4], (PerformanceTestResponseTimes) args[5], (String) args[2], (Integer) args[3], (String) args[1]),
                new Object[]{config, "https://example.com/retention", "PASS", 98, 0, responseTimes, Map.of("TIMED_OUT", 1)});

        PerformanceTestResultResponse result = new PerformanceTestResultResponse(config, Map.of(SendAttemptResult.TIMED_OUT, 1), 0, responseTimes, PerformanceTestStatus.PASS, 98, "https://example.com/retention");
        Assertions.assertEquals(Map.of("TIMED_OUT", 1), result.getRawFailures());
        Assertions.assertThrows(NullPointerException.class, () -> result.setResult(null));
        Assertions.assertThrows(NullPointerException.class, () -> result.failures(null));
        Assertions.assertThrows(NullPointerException.class, () -> responseTimes.setP99(null));
        Assertions.assertThrows(NullPointerException.class, () -> config.totalRequests(null));
    }

    static Stream<Arguments> requiredResponseKeys() {
        return Stream.of(
                required("models/getDefaultMessageResponse.json", DefaultConfigurationResponse.class, "messageIdentifier"),
                required("models/getRealtimeUrlResponse.json", RealtimeUrlResponse.class, "realtimeURL"),
                required("models/performanceTestResponse.json", PerformanceTestResponse.class, "config", "requestId",
                        "config.maxConcurrentRequests", "config.totalRequests", "config.totalDuration", "config.responseTimeThreshold", "config.successRateThreshold"),
                required("models/performanceTestResultResponse.json", PerformanceTestResultResponse.class, "config", "target", "result", "successRate", "numPending", "responseTimes", "failures",
                        "responseTimes.average", "responseTimes.p50", "responseTimes.p90", "responseTimes.p95", "responseTimes.p99"),
                required("models/decodedRealtimeRequest.json", DecodedRealtimeRequestBody.class, "originalTransactionId", "appAppleId", "productId", "userLocale", "requestIdentifier", "signedDate", "environment"),
                required("models/signedExternalPurchaseTokenNotification.json", ResponseBodyV2DecodedPayload.class,
                        "externalPurchaseToken.externalPurchaseId", "externalPurchaseToken.tokenCreationDate", "externalPurchaseToken.appAppleId", "externalPurchaseToken.bundleId"),
                required("models/advancedCommerceOffer.json", AdvancedCommerceOffer.class, "price", "period", "periodCount", "reason"),
                required("models/advancedCommerceDescriptors.json", AdvancedCommerceDescriptors.class, "displayName", "description"),
                required("models/advancedCommerceRequestRefundResponse.json", AdvancedCommerceRequestRefundResponse.class, "signedTransactionInfo"),
                required("models/advancedCommerceSubscriptionCancelResponse.json", AdvancedCommerceSubscriptionCancelResponse.class, "signedRenewalInfo", "signedTransactionInfo"),
                required("models/advancedCommerceSubscriptionChangeMetadataResponse.json", AdvancedCommerceSubscriptionChangeMetadataResponse.class, "signedRenewalInfo", "signedTransactionInfo"),
                required("models/advancedCommerceSubscriptionMigrateResponse.json", AdvancedCommerceSubscriptionMigrateResponse.class, "signedRenewalInfo", "signedTransactionInfo"),
                required("models/advancedCommerceSubscriptionPriceChangeResponse.json", AdvancedCommerceSubscriptionPriceChangeResponse.class, "signedRenewalInfo", "signedTransactionInfo"),
                required("models/advancedCommerceSubscriptionRevokeResponse.json", AdvancedCommerceSubscriptionRevokeResponse.class, "signedRenewalInfo", "signedTransactionInfo")
        ).flatMap(arguments -> arguments);
    }

    @ParameterizedTest
    @MethodSource("requiredResponseKeys")
    public void testDecodingFailsWhenRequiredKeyIsMissing(String resource, Class<?> type, String key) throws IOException {
        String json = TestingUtility.readFile(resource);
        Assertions.assertDoesNotThrow(() -> objectMapper.readValue(json, type));

        MismatchedInputException e = Assertions.assertThrows(MismatchedInputException.class, () -> objectMapper.readValue(withoutKey(json, key), type));
        Assertions.assertTrue(e.getMessage().contains("'" + lastSegment(key) + "'"), e.getMessage());
    }

    @ParameterizedTest
    @MethodSource("requiredResponseKeys")
    public void testDecodingFailsWhenRequiredKeyIsNull(String resource, Class<?> type, String key) throws IOException {
        String json = TestingUtility.readFile(resource);

        Assertions.assertThrows(JsonMappingException.class, () -> objectMapper.readValue(withNullValue(json, key), type));
    }

    @Test
    public void testVerifyAndDecodeNotificationFailsWhenRequiredKeyIsMissing() throws Exception {
        String json = withoutKey(TestingUtility.readFile("models/signedExternalPurchaseTokenNotification.json"), "externalPurchaseToken.bundleId");
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        String signedNotification = SignedDataCreator.createSignedData(json);

        VerificationException e = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(signedNotification));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, e.getStatus());
        Assertions.assertInstanceOf(MismatchedInputException.class, e.getCause());
    }

    @Test
    public void testVerifyAndDecodeRealtimeRequestFailsWhenRequiredKeyIsMissing() throws Exception {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        String json = TestingUtility.readFile("models/decodedRealtimeRequest.json");
        Assertions.assertNotNull(verifier.verifyAndDecodeRealtimeRequest(SignedDataCreator.createSignedData(json)));
        String signedRequest = SignedDataCreator.createSignedData(withoutKey(json, "requestIdentifier"));

        VerificationException e = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeRealtimeRequest(signedRequest));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, e.getStatus());
        Assertions.assertInstanceOf(MismatchedInputException.class, e.getCause());
    }

    @Test
    public void testMergedAdvancedCommerceTypesAreRequiredToBuild() {
        assertEachArgumentRequired(args -> new AdvancedCommerceOffer((AdvancedCommerceOfferPeriod) args[1], (Integer) args[2], (Long) args[0], (AdvancedCommerceOfferReason) args[3]),
                new Object[]{1000L, AdvancedCommerceOfferPeriod.P1M, 1, AdvancedCommerceOfferReason.ACQUISITION});
        assertEachArgumentRequired(args -> new AdvancedCommerceOffer((String) args[1], (Integer) args[2], (Long) args[0], (String) args[3]),
                new Object[]{1000L, "P1M", 1, "ACQUISITION"});
        assertEachArgumentRequired(args -> new AdvancedCommerceDescriptors((String) args[0], (String) args[1]),
                new Object[]{"description", "display name"});

        AdvancedCommerceOffer offer = new AdvancedCommerceOffer(AdvancedCommerceOfferPeriod.P1M, 1, 1000L, AdvancedCommerceOfferReason.ACQUISITION);
        Assertions.assertThrows(NullPointerException.class, () -> offer.price(null));
        Assertions.assertThrows(NullPointerException.class, () -> offer.setRawReason(null));
        AdvancedCommerceDescriptors descriptors = new AdvancedCommerceDescriptors("description", "display name");
        Assertions.assertThrows(NullPointerException.class, () -> descriptors.displayName(null));
        Assertions.assertThrows(NullPointerException.class, () -> descriptors.setDescription(null));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new AdvancedCommerceOffer(AdvancedCommerceOfferPeriod.P1M, 13, 1000L, AdvancedCommerceOfferReason.ACQUISITION));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AdvancedCommerceDescriptors("description", "A".repeat(31)));
    }

    static Stream<Arguments> advancedCommerceSignedKeys() {
        return Stream.of("models/signedTransaction.json", "models/signedRenewalInfo.json").flatMap(resource -> Stream.of(
                Arguments.of(resource, "descriptors.displayName"), Arguments.of(resource, "descriptors.description"),
                Arguments.of(resource, "offer.price"), Arguments.of(resource, "offer.period"),
                Arguments.of(resource, "offer.periodCount"), Arguments.of(resource, "offer.reason")));
    }

    @ParameterizedTest
    @MethodSource("advancedCommerceSignedKeys")
    public void testMergedAdvancedCommerceTypesWithoutARequiredKeyFailToDecodeInSignedData(String resource, String key) throws Exception {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        ObjectNode payload = advancedCommercePayload(resource);
        Assertions.assertDoesNotThrow(() -> verifyAndDecode(verifier, resource, payload));

        ObjectNode missing = payload.deepCopy();
        advancedCommerceObject(missing, key).remove(lastSegment(key));
        VerificationException e = Assertions.assertThrows(VerificationException.class, () -> verifyAndDecode(verifier, resource, missing));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, e.getStatus());
        Assertions.assertInstanceOf(MismatchedInputException.class, e.getCause());

        ObjectNode withNull = payload.deepCopy();
        advancedCommerceObject(withNull, key).putNull(lastSegment(key));
        e = Assertions.assertThrows(VerificationException.class, () -> verifyAndDecode(verifier, resource, withNull));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, e.getStatus());
    }

    static Stream<Arguments> advancedCommerceSignedValuesOutsideTheLimits() {
        return Stream.of("models/signedTransaction.json", "models/signedRenewalInfo.json").flatMap(resource -> Stream.of(
                Arguments.of(resource, "offer.periodCount", 13), Arguments.of(resource, "offer.periodCount", 0),
                Arguments.of(resource, "descriptors.displayName", "A".repeat(31)),
                Arguments.of(resource, "descriptors.description", "A".repeat(46))));
    }

    @ParameterizedTest
    @MethodSource("advancedCommerceSignedValuesOutsideTheLimits")
    public void testMergedAdvancedCommerceTypesOutsideTheRequestLimitsFailToDecodeInSignedData(String resource, String key, Object value) throws Exception {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        ObjectNode payload = advancedCommercePayload(resource);
        Assertions.assertDoesNotThrow(() -> verifyAndDecode(verifier, resource, payload));

        ObjectNode outside = payload.deepCopy();
        advancedCommerceObject(outside, key).putPOJO(lastSegment(key), value);
        VerificationException e = Assertions.assertThrows(VerificationException.class, () -> verifyAndDecode(verifier, resource, outside));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, e.getStatus());
        Assertions.assertInstanceOf(ValueInstantiationException.class, e.getCause());
        Assertions.assertInstanceOf(IllegalArgumentException.class, e.getCause().getCause());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("signedAdvancedCommerceResources")
    public void testMergedAdvancedCommerceTypesAtTheRequestLimitsDecodeInSignedData(String resource) throws Exception {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        for (int periodCount : new int[]{1, 12}) {
            ObjectNode payload = advancedCommercePayload(resource);
            ((ObjectNode) payload.get("advancedCommerceInfo").get("descriptors")).put("displayName", "A".repeat(30)).put("description", "B".repeat(45));
            advancedCommerceObject(payload, "offer.periodCount").put("periodCount", periodCount);

            Object decoded = verifyAndDecode(verifier, resource, payload);
            AdvancedCommerceDescriptors descriptors;
            AdvancedCommerceOffer offer;
            if (decoded instanceof JWSRenewalInfoDecodedPayload) {
                AdvancedCommerceRenewalInfo info = ((JWSRenewalInfoDecodedPayload) decoded).getAdvancedCommerceInfo();
                descriptors = info.getDescriptors();
                offer = info.getItems().get(0).getOffer();
            } else {
                AdvancedCommerceTransactionInfo info = ((JWSTransactionDecodedPayload) decoded).getAdvancedCommerceInfo();
                descriptors = info.getDescriptors();
                offer = info.getItems().get(0).getOffer();
            }
            Assertions.assertEquals("A".repeat(30), descriptors.getDisplayName());
            Assertions.assertEquals("B".repeat(45), descriptors.getDescription());
            Assertions.assertEquals(5000L, offer.getPrice());
            Assertions.assertEquals(AdvancedCommerceOfferPeriod.P1M, offer.getPeriod());
            Assertions.assertEquals(periodCount, offer.getPeriodCount());
            Assertions.assertEquals(AdvancedCommerceOfferReason.ACQUISITION, offer.getReason());
        }
    }

    static Stream<String> signedAdvancedCommerceResources() {
        return Stream.of("models/signedTransaction.json", "models/signedRenewalInfo.json");
    }

    @Test
    public void testAdvancedCommerceTransactionWithoutDescriptorsAndOfferDecodes() throws Exception {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        ObjectNode transactionJson = (ObjectNode) objectMapper.readTree(TestingUtility.readFile("models/signedTransaction.json"));
        ObjectNode transactionInfo = (ObjectNode) transactionJson.get("advancedCommerceInfo");
        transactionInfo.remove(List.of("descriptors", "period"));
        Assertions.assertFalse(transactionInfo.get("items").get(0).has("offer"));

        JWSTransactionDecodedPayload transaction = verifier.verifyAndDecodeTransaction(SignedDataCreator.createSignedData(objectMapper.writeValueAsString(transactionJson)));
        AdvancedCommerceTransactionInfo info = transaction.getAdvancedCommerceInfo();
        Assertions.assertNull(info.getDescriptors());
        Assertions.assertNull(info.getPeriod());
        Assertions.assertNull(info.getItems().get(0).getOffer());
        Assertions.assertEquals("com.example.sku.premium", info.getItems().get(0).getSku());
    }

    private static ObjectNode advancedCommercePayload(String resource) throws IOException {
        ObjectNode payload = (ObjectNode) objectMapper.readTree(TestingUtility.readFile(resource));
        ((ObjectNode) payload.get("advancedCommerceInfo").get("items").get(0)).putObject("offer")
                .put("price", 5000).put("period", "P1M").put("periodCount", 3).put("reason", "ACQUISITION");
        return payload;
    }

    private static ObjectNode advancedCommerceObject(ObjectNode payload, String key) {
        ObjectNode info = (ObjectNode) payload.get("advancedCommerceInfo");
        return (ObjectNode) (key.startsWith("descriptors.") ? info.get("descriptors") : info.get("items").get(0).get("offer"));
    }

    private static Object verifyAndDecode(SignedDataVerifier verifier, String resource, ObjectNode payload) throws Exception {
        String signed = SignedDataCreator.createSignedData(objectMapper.writeValueAsString(payload));
        return resource.contains("RenewalInfo") ? verifier.verifyAndDecodeRenewalInfo(signed) : verifier.verifyAndDecodeTransaction(signed);
    }

    private static Stream<Arguments> required(String resource, Class<?> type, String... keys) {
        return Arrays.stream(keys).map(key -> Arguments.of(resource, type, key));
    }

    private static void assertEachArgumentRequired(Function<Object[], ?> constructor, Object[] arguments, int... nullableArguments) {
        Assertions.assertNotNull(constructor.apply(arguments.clone()));
        Set<Integer> nullable = IntStream.of(nullableArguments).boxed().collect(Collectors.toSet());
        for (int i = 0; i < arguments.length; i++) {
            Object[] withNull = arguments.clone();
            withNull[i] = null;
            if (nullable.contains(i)) {
                Assertions.assertDoesNotThrow(() -> constructor.apply(withNull));
            } else {
                Assertions.assertThrows(NullPointerException.class, () -> constructor.apply(withNull));
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<SendAttemptResult, Integer> castFailures(Object failures) {
        return (Map<SendAttemptResult, Integer>) failures;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Integer> castRawFailures(Object failures) {
        return (Map<String, Integer>) failures;
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> serialize(Object value) throws JsonProcessingException {
        return objectMapper.readValue(objectMapper.writeValueAsString(value), Map.class);
    }

    private static String withoutKey(String json, String path) throws JsonProcessingException {
        ObjectNode root = (ObjectNode) objectMapper.readTree(json);
        parentOf(root, path).remove(lastSegment(path));
        return objectMapper.writeValueAsString(root);
    }

    private static String withNullValue(String json, String path) throws JsonProcessingException {
        ObjectNode root = (ObjectNode) objectMapper.readTree(json);
        parentOf(root, path).putNull(lastSegment(path));
        return objectMapper.writeValueAsString(root);
    }

    private static ObjectNode parentOf(ObjectNode root, String path) {
        String[] segments = path.split("\\.");
        ObjectNode node = root;
        for (int i = 0; i < segments.length - 1; i++) {
            node = (ObjectNode) node.get(segments[i]);
        }
        Assertions.assertTrue(node.has(lastSegment(path)));
        return node;
    }

    private static String lastSegment(String path) {
        return path.substring(path.lastIndexOf('.') + 1);
    }
}
