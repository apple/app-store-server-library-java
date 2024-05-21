// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import com.apple.itunes.storekit.model.AccountTenure;
import com.apple.itunes.storekit.model.CheckTestNotificationResponse;
import com.apple.itunes.storekit.model.ConsumptionRequest;
import com.apple.itunes.storekit.model.ConsumptionStatus;
import com.apple.itunes.storekit.model.DeliveryStatus;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.ExtendReasonCode;
import com.apple.itunes.storekit.model.ExtendRenewalDateRequest;
import com.apple.itunes.storekit.model.ExtendRenewalDateResponse;
import com.apple.itunes.storekit.model.HistoryResponse;
import com.apple.itunes.storekit.model.InAppOwnershipType;
import com.apple.itunes.storekit.model.LastTransactionsItem;
import com.apple.itunes.storekit.model.LifetimeDollarsPurchased;
import com.apple.itunes.storekit.model.LifetimeDollarsRefunded;
import com.apple.itunes.storekit.model.MassExtendRenewalDateRequest;
import com.apple.itunes.storekit.model.MassExtendRenewalDateResponse;
import com.apple.itunes.storekit.model.MassExtendRenewalDateStatusResponse;
import com.apple.itunes.storekit.model.NotificationHistoryRequest;
import com.apple.itunes.storekit.model.NotificationHistoryResponse;
import com.apple.itunes.storekit.model.NotificationHistoryResponseItem;
import com.apple.itunes.storekit.model.NotificationTypeV2;
import com.apple.itunes.storekit.model.OrderLookupResponse;
import com.apple.itunes.storekit.model.OrderLookupStatus;
import com.apple.itunes.storekit.model.Platform;
import com.apple.itunes.storekit.model.PlayTime;
import com.apple.itunes.storekit.model.RefundHistoryResponse;
import com.apple.itunes.storekit.model.RefundPreference;
import com.apple.itunes.storekit.model.SendAttemptItem;
import com.apple.itunes.storekit.model.SendAttemptResult;
import com.apple.itunes.storekit.model.SendTestNotificationResponse;
import com.apple.itunes.storekit.model.Status;
import com.apple.itunes.storekit.model.StatusResponse;
import com.apple.itunes.storekit.model.SubscriptionGroupIdentifierItem;
import com.apple.itunes.storekit.model.Subtype;
import com.apple.itunes.storekit.model.TransactionHistoryRequest;
import com.apple.itunes.storekit.model.TransactionInfoResponse;
import com.apple.itunes.storekit.model.UserStatus;
import com.apple.itunes.storekit.util.TestingUtility;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class AppStoreServerAPIClientTest {

    private final MediaType expectedMediaType = MediaType.parse("application/json; charset=utf-8");

    @Test
    public void testExtendRenewalDateForAllActiveSubscribers() throws IOException, APIException {
        AppStoreServerAPIClient client = getClientWithBody("models/extendRenewalDateForAllActiveSubscribersResponse.json", request -> {
            Assertions.assertEquals("POST", request.method());
            Assertions.assertEquals("/inApps/v1/subscriptions/extend/mass", request.url().encodedPath());
            RequestBody body = request.body();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(expectedMediaType, body.contentType());
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Map<String, Object> root;
            try {
                root = new ObjectMapper().readValue(buffer.readUtf8(), Map.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertEquals(45, ((Number) root.get("extendByDays")).intValue());
            Assertions.assertEquals(1, ((Number) root.get("extendReasonCode")).intValue());
            Assertions.assertEquals("fdf964a4-233b-486c-aac1-97d8d52688ac", root.get("requestIdentifier"));
            Assertions.assertEquals(List.of("USA", "MEX"), root.get("storefrontCountryCodes"));
            Assertions.assertEquals("com.example.productId", root.get("productId"));
        });

        MassExtendRenewalDateRequest extendRenewalDateRequest = new MassExtendRenewalDateRequest()
                .extendByDays(45)
                .extendReasonCode(ExtendReasonCode.CUSTOMER_SATISFACTION)
                .requestIdentifier("fdf964a4-233b-486c-aac1-97d8d52688ac")
                .storefrontCountryCodes(List.of("USA", "MEX"))
                .productId("com.example.productId");

        MassExtendRenewalDateResponse massExtendRenewalDateResponse = client.extendRenewalDateForAllActiveSubscribers(extendRenewalDateRequest);

        Assertions.assertNotNull(massExtendRenewalDateResponse);
        Assertions.assertEquals("758883e8-151b-47b7-abd0-60c4d804c2f5", massExtendRenewalDateResponse.getRequestIdentifier());
    }

    @Test
    public void testExtendSubscriptionRenewalDate() throws IOException, APIException {
        AppStoreServerAPIClient client = getClientWithBody("models/extendSubscriptionRenewalDateResponse.json", request -> {
            Assertions.assertEquals("PUT", request.method());
            Assertions.assertEquals("/inApps/v1/subscriptions/extend/4124214", request.url().encodedPath());
            RequestBody body = request.body();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(expectedMediaType, body.contentType());
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Map<String, Object> root;
            try {
                root = new ObjectMapper().readValue(buffer.readUtf8(), Map.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertEquals(45, ((Number) root.get("extendByDays")).intValue());
            Assertions.assertEquals(1, ((Number) root.get("extendReasonCode")).intValue());
            Assertions.assertEquals("fdf964a4-233b-486c-aac1-97d8d52688ac", root.get("requestIdentifier"));
        });

        ExtendRenewalDateRequest extendRenewalDateRequest = new ExtendRenewalDateRequest()
                .extendByDays(45)
                .extendReasonCode(ExtendReasonCode.CUSTOMER_SATISFACTION)
                .requestIdentifier("fdf964a4-233b-486c-aac1-97d8d52688ac");

        ExtendRenewalDateResponse extendRenewalDateResponse = client.extendSubscriptionRenewalDate("4124214", extendRenewalDateRequest);

        Assertions.assertNotNull(extendRenewalDateResponse);
        Assertions.assertEquals("2312412", extendRenewalDateResponse.getOriginalTransactionId());
        Assertions.assertEquals("9993", extendRenewalDateResponse.getWebOrderLineItemId());
        Assertions.assertTrue(extendRenewalDateResponse.getSuccess());
        Assertions.assertEquals(1698148900000L, extendRenewalDateResponse.getEffectiveDate());
    }

    @Test
    public void testGetAllSubscriptionStatuses() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/getAllSubscriptionStatusesResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v1/subscriptions/4321", request.url().encodedPath());
            Assertions.assertEquals(List.of("2", "1"), request.url().queryParameterValues("status"));
            Assertions.assertNull(request.body());
        });

        StatusResponse statusResponse = client.getAllSubscriptionStatuses("4321", new Status[] {Status.EXPIRED, Status.ACTIVE});

        Assertions.assertNotNull(statusResponse);
        Assertions.assertEquals(Environment.LOCAL_TESTING, statusResponse.getEnvironment());
        Assertions.assertEquals("LocalTesting", statusResponse.getRawEnvironment());
        Assertions.assertEquals("com.example", statusResponse.getBundleId());
        Assertions.assertEquals(5454545L, statusResponse.getAppAppleId());

        SubscriptionGroupIdentifierItem item = new SubscriptionGroupIdentifierItem()
                .subscriptionGroupIdentifier("sub_group_one")
                .lastTransactions(List.of(
                        new LastTransactionsItem()
                                .status(Status.ACTIVE)
                                .originalTransactionId("3749183")
                                .signedTransactionInfo("signed_transaction_one")
                                .signedRenewalInfo("signed_renewal_one"),
                        new LastTransactionsItem()
                                .status(Status.REVOKED)
                                .originalTransactionId("5314314134")
                                .signedTransactionInfo("signed_transaction_two")
                                .signedRenewalInfo("signed_renewal_two")
                ));
        SubscriptionGroupIdentifierItem secondItem = new SubscriptionGroupIdentifierItem()
                .subscriptionGroupIdentifier("sub_group_two")
                .lastTransactions(List.of(
                        new LastTransactionsItem()
                                .status(Status.EXPIRED)
                                .originalTransactionId("3413453")
                                .signedTransactionInfo("signed_transaction_three")
                                .signedRenewalInfo("signed_renewal_three")
                ));
        Assertions.assertEquals(List.of(item, secondItem), statusResponse.getData());
    }

    @Test
    public void testGetRefundHistory() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/getRefundHistoryResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v2/refund/lookup/555555", request.url().encodedPath());
            Assertions.assertEquals("revision_input", request.url().queryParameter("revision"));
            Assertions.assertNull(request.body());
        });

        RefundHistoryResponse refundHistoryResponse = client.getRefundHistory("555555", "revision_input");

        Assertions.assertNotNull(refundHistoryResponse);
        Assertions.assertEquals(List.of("signed_transaction_one", "signed_transaction_two"), refundHistoryResponse.getSignedTransactions());
        Assertions.assertEquals("revision_output", refundHistoryResponse.getRevision());
        Assertions.assertTrue(refundHistoryResponse.getHasMore());
    }

    @Test
    public void testGetStatusOfSubscriptionRenewalDateExtensions() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/getStatusOfSubscriptionRenewalDateExtensionsResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v1/subscriptions/extend/mass/20fba8a0-2b80-4a7d-a17f-85c1854727f8/com.example.product", request.url().encodedPath());
            Assertions.assertNull(request.body());
        });

        MassExtendRenewalDateStatusResponse massExtendRenewalDateStatusResponse = client.getStatusOfSubscriptionRenewalDateExtensions("com.example.product", "20fba8a0-2b80-4a7d-a17f-85c1854727f8");

        Assertions.assertNotNull(massExtendRenewalDateStatusResponse);
        Assertions.assertEquals("20fba8a0-2b80-4a7d-a17f-85c1854727f8", massExtendRenewalDateStatusResponse.getRequestIdentifier());
        Assertions.assertTrue(massExtendRenewalDateStatusResponse.getComplete());
        Assertions.assertEquals(1698148900000L, massExtendRenewalDateStatusResponse.getCompleteDate());
        Assertions.assertEquals(30, massExtendRenewalDateStatusResponse.getSucceededCount());
        Assertions.assertEquals(2, massExtendRenewalDateStatusResponse.getFailedCount());
    }

    @Test
    public void testGetTestNotificationStatus() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/getTestNotificationStatusResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v1/notifications/test/8cd2974c-f905-492a-bf9a-b2f47c791d19", request.url().encodedPath());
            Assertions.assertNull(request.body());
        });

        CheckTestNotificationResponse checkTestNotificationResponse = client.getTestNotificationStatus("8cd2974c-f905-492a-bf9a-b2f47c791d19");

        Assertions.assertNotNull(checkTestNotificationResponse);
        Assertions.assertEquals("signed_payload", checkTestNotificationResponse.getSignedPayload());
        List<SendAttemptItem> sendAttemptItems = List.of(
                new SendAttemptItem()
                        .attemptDate(1698148900000L)
                        .sendAttemptResult(SendAttemptResult.NO_RESPONSE),
                new SendAttemptItem()
                        .attemptDate(1698148950000L)
                        .sendAttemptResult(SendAttemptResult.SUCCESS)
        );
        Assertions.assertEquals(sendAttemptItems, checkTestNotificationResponse.getSendAttempts());
    }

    @Test
    public void testGetNotificationHistory() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/getNotificationHistoryResponse.json", request -> {
            Assertions.assertEquals("POST", request.method());
            Assertions.assertEquals("/inApps/v1/notifications/history", request.url().encodedPath());
            Assertions.assertEquals("a036bc0e-52b8-4bee-82fc-8c24cb6715d6", request.url().queryParameter("paginationToken"));
            RequestBody body = request.body();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(expectedMediaType, body.contentType());
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Map<String, Object> root;
            try {
                root = new ObjectMapper().readValue(buffer.readUtf8(), Map.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertEquals(1698148900000L, ((Number) root.get("startDate")).longValue());
            Assertions.assertEquals(1698148950000L, ((Number) root.get("endDate")).longValue());
            Assertions.assertEquals("SUBSCRIBED", root.get("notificationType"));
            Assertions.assertEquals("INITIAL_BUY", root.get("notificationSubtype"));
            Assertions.assertEquals("999733843", root.get("transactionId"));
            Assertions.assertTrue((Boolean) root.get("onlyFailures"));
        });

        NotificationHistoryRequest notificationHistoryRequest = new NotificationHistoryRequest()
                .startDate(1698148900000L)
                .endDate(1698148950000L)
                .notificationType(NotificationTypeV2.SUBSCRIBED)
                .notificationSubtype(Subtype.INITIAL_BUY)
                .transactionId("999733843")
                .onlyFailures(true);

        NotificationHistoryResponse notificationHistoryResponse = client.getNotificationHistory("a036bc0e-52b8-4bee-82fc-8c24cb6715d6", notificationHistoryRequest);

        Assertions.assertNotNull(notificationHistoryResponse);
        Assertions.assertEquals("57715481-805a-4283-8499-1c19b5d6b20a", notificationHistoryResponse.getPaginationToken());
        Assertions.assertTrue(notificationHistoryResponse.getHasMore());
        List<NotificationHistoryResponseItem> expectedNotificationHistory = List.of(
                new NotificationHistoryResponseItem()
                        .sendAttempts(List.of(
                                new SendAttemptItem()
                                        .attemptDate(1698148900000L)
                                        .sendAttemptResult(SendAttemptResult.NO_RESPONSE),
                                new SendAttemptItem()
                                        .attemptDate(1698148950000L)
                                        .sendAttemptResult(SendAttemptResult.SUCCESS)
                        ))
                        .signedPayload("signed_payload_one"),
                new NotificationHistoryResponseItem()
                        .sendAttempts(List.of(
                                new SendAttemptItem()
                                        .attemptDate(1698148800000L)
                                        .sendAttemptResult(SendAttemptResult.CIRCULAR_REDIRECT)
                        ))
                        .signedPayload("signed_payload_two")
        );
        Assertions.assertEquals(expectedNotificationHistory, notificationHistoryResponse.getNotificationHistory());
    }

    @Test
    public void testGetTransactionHistory() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/transactionHistoryResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v1/history/1234", request.url().encodedPath());
            Assertions.assertEquals("revision_input", request.url().queryParameter("revision"));
            Assertions.assertEquals("123455", request.url().queryParameter("startDate"));
            Assertions.assertEquals("123456", request.url().queryParameter("endDate"));
            Assertions.assertEquals(List.of("com.example.1", "com.example.2"), request.url().queryParameterValues("productId"));
            Assertions.assertEquals(List.of("CONSUMABLE", "AUTO_RENEWABLE"), request.url().queryParameterValues("productType"));
            Assertions.assertEquals("ASCENDING", request.url().queryParameter("sort"));
            Assertions.assertEquals(List.of("sub_group_id", "sub_group_id_2"), request.url().queryParameterValues("subscriptionGroupIdentifier"));
            Assertions.assertEquals("FAMILY_SHARED", request.url().queryParameter("inAppOwnershipType"));
            Assertions.assertEquals("false", request.url().queryParameter("revoked"));
            Assertions.assertNull(request.body());
        });

        TransactionHistoryRequest request = new TransactionHistoryRequest()
                .sort(TransactionHistoryRequest.Order.ASCENDING)
                .productTypes(List.of(TransactionHistoryRequest.ProductType.CONSUMABLE, TransactionHistoryRequest.ProductType.AUTO_RENEWABLE))
                .endDate(123456L)
                .startDate(123455L)
                .revoked(false)
                .inAppOwnershipType(InAppOwnershipType.FAMILY_SHARED)
                .productIds(List.of("com.example.1", "com.example.2"))
                .subscriptionGroupIdentifiers(List.of("sub_group_id", "sub_group_id_2"));

        HistoryResponse historyResponse = client.getTransactionHistory("1234", "revision_input", request);

        Assertions.assertNotNull(historyResponse);
        Assertions.assertEquals("revision_output", historyResponse.getRevision());
        Assertions.assertTrue(historyResponse.getHasMore());
        Assertions.assertEquals("com.example", historyResponse.getBundleId());
        Assertions.assertEquals(323232L, historyResponse.getAppAppleId());
        Assertions.assertEquals(Environment.LOCAL_TESTING, historyResponse.getEnvironment());
        Assertions.assertEquals("LocalTesting", historyResponse.getRawEnvironment());
        Assertions.assertEquals(List.of("signed_transaction_value", "signed_transaction_value2"), historyResponse.getSignedTransactions());
    }

    @Test
    public void testGetTransactionInfo() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/transactionInfoResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v1/transactions/1234", request.url().encodedPath());
            Assertions.assertNull(request.body());
        });

        TransactionInfoResponse transactionInfoResponse = client.getTransactionInfo("1234");

        Assertions.assertNotNull(transactionInfoResponse);
        Assertions.assertEquals("signed_transaction_info_value", transactionInfoResponse.getSignedTransactionInfo());
    }

    @Test
    public void testLookUpOrderId() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/lookupOrderIdResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v1/lookup/W002182", request.url().encodedPath());
            Assertions.assertNull(request.body());
        });

        OrderLookupResponse orderLookupResponse = client.lookUpOrderId("W002182");

        Assertions.assertNotNull(orderLookupResponse);
        Assertions.assertEquals(OrderLookupStatus.INVALID, orderLookupResponse.getStatus());
        Assertions.assertEquals(1, orderLookupResponse.getRawStatus());
        Assertions.assertEquals(List.of("signed_transaction_one", "signed_transaction_two"), orderLookupResponse.getSignedTransactions());
    }

    @Test
    public void testRequestTestNotification() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/requestTestNotificationResponse.json", request -> {
            Assertions.assertEquals("POST", request.method());
            Assertions.assertEquals("/inApps/v1/notifications/test", request.url().encodedPath());
            RequestBody body = request.body();
            Assertions.assertNotNull(body);
            Assertions.assertNull(body.contentType());
            try {
                Assertions.assertEquals(0, body.contentLength());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        SendTestNotificationResponse sendTestNotificationResponse = client.requestTestNotification();

        Assertions.assertNotNull(sendTestNotificationResponse);
        Assertions.assertEquals("ce3af791-365e-4c60-841b-1674b43c1609", sendTestNotificationResponse.getTestNotificationToken());
    }

    @Test
    public void testSendConsumptionData() throws APIException, IOException {
        AppStoreServerAPIClient client = getAppStoreServerAPIClient("", request -> {
            Assertions.assertEquals("PUT", request.method());
            Assertions.assertEquals("/inApps/v1/transactions/consumption/49571273", request.url().encodedPath());
            RequestBody body = request.body();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(expectedMediaType, body.contentType());
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Map<String, Object> root;
            try {
                root = new ObjectMapper().readValue(buffer.readUtf8(), Map.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertTrue((Boolean) root.get("customerConsented"));
            Assertions.assertEquals(1, ((Number) root.get("consumptionStatus")).intValue());
            Assertions.assertEquals(2, ((Number) root.get("platform")).intValue());
            Assertions.assertFalse((Boolean) root.get("sampleContentProvided"));
            Assertions.assertEquals(3, ((Number) root.get("deliveryStatus")).intValue());
            Assertions.assertEquals("7389a31a-fb6d-4569-a2a6-db7d85d84813", root.get("appAccountToken"));
            Assertions.assertEquals(4, ((Number) root.get("accountTenure")).intValue());
            Assertions.assertEquals(5, ((Number) root.get("playTime")).intValue());
            Assertions.assertEquals(6, ((Number) root.get("lifetimeDollarsRefunded")).intValue());
            Assertions.assertEquals(7, ((Number) root.get("lifetimeDollarsPurchased")).intValue());
            Assertions.assertEquals(4, ((Number) root.get("userStatus")).intValue());
            Assertions.assertEquals(3, ((Number) root.get("refundPreference")).intValue());
        });

        ConsumptionRequest consumptionRequest = new ConsumptionRequest()
                .customerConsented(true)
                .consumptionStatus(ConsumptionStatus.NOT_CONSUMED)
                .platform(Platform.NON_APPLE)
                .sampleContentProvided(false)
                .deliveryStatus(DeliveryStatus.DID_NOT_DELIVER_DUE_TO_SERVER_OUTAGE)
                .appAccountToken(UUID.fromString("7389a31a-fb6d-4569-a2a6-db7d85d84813"))
                .accountTenure(AccountTenure.THIRTY_DAYS_TO_NINETY_DAYS)
                .playTime(PlayTime.ONE_DAY_TO_FOUR_DAYS)
                .lifetimeDollarsRefunded(LifetimeDollarsRefunded.ONE_THOUSAND_DOLLARS_TO_ONE_THOUSAND_NINE_HUNDRED_NINETY_NINE_DOLLARS_AND_NINETY_NINE_CENTS)
                .lifetimeDollarsPurchased(LifetimeDollarsPurchased.TWO_THOUSAND_DOLLARS_OR_GREATER)
                .userStatus(UserStatus.LIMITED_ACCESS)
                .refundPreference(RefundPreference.NO_PREFERENCE);

        client.sendConsumptionData("49571273", consumptionRequest);
    }

    @Test
    public void testSendConsumptionDataWithNullAppAccountToken() throws APIException, IOException {
        AppStoreServerAPIClient client = getAppStoreServerAPIClient("", request -> {
            Assertions.assertEquals("PUT", request.method());
            Assertions.assertEquals("/inApps/v1/transactions/consumption/49571273", request.url().encodedPath());
            RequestBody body = request.body();
            Assertions.assertNotNull(body);
            Assertions.assertEquals(expectedMediaType, body.contentType());
            Buffer buffer = new Buffer();
            try {
                body.writeTo(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Map<String, Object> root;
            try {
                root = new ObjectMapper().readValue(buffer.readUtf8(), Map.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertTrue((Boolean) root.get("customerConsented"));
            Assertions.assertEquals(1, ((Number) root.get("consumptionStatus")).intValue());
            Assertions.assertEquals(2, ((Number) root.get("platform")).intValue());
            Assertions.assertFalse((Boolean) root.get("sampleContentProvided"));
            Assertions.assertEquals(3, ((Number) root.get("deliveryStatus")).intValue());
            Assertions.assertEquals("", root.get("appAccountToken"));
            Assertions.assertEquals(4, ((Number) root.get("accountTenure")).intValue());
            Assertions.assertEquals(5, ((Number) root.get("playTime")).intValue());
            Assertions.assertEquals(6, ((Number) root.get("lifetimeDollarsRefunded")).intValue());
            Assertions.assertEquals(7, ((Number) root.get("lifetimeDollarsPurchased")).intValue());
            Assertions.assertEquals(4, ((Number) root.get("userStatus")).intValue());
            Assertions.assertEquals(3, ((Number) root.get("refundPreference")).intValue());
        });

        ConsumptionRequest consumptionRequest = new ConsumptionRequest()
                .customerConsented(true)
                .consumptionStatus(ConsumptionStatus.NOT_CONSUMED)
                .platform(Platform.NON_APPLE)
                .sampleContentProvided(false)
                .deliveryStatus(DeliveryStatus.DID_NOT_DELIVER_DUE_TO_SERVER_OUTAGE)
                .accountTenure(AccountTenure.THIRTY_DAYS_TO_NINETY_DAYS)
                .playTime(PlayTime.ONE_DAY_TO_FOUR_DAYS)
                .lifetimeDollarsRefunded(LifetimeDollarsRefunded.ONE_THOUSAND_DOLLARS_TO_ONE_THOUSAND_NINE_HUNDRED_NINETY_NINE_DOLLARS_AND_NINETY_NINE_CENTS)
                .lifetimeDollarsPurchased(LifetimeDollarsPurchased.TWO_THOUSAND_DOLLARS_OR_GREATER)
                .userStatus(UserStatus.LIMITED_ACCESS)
                .refundPreference(RefundPreference.NO_PREFERENCE);

        client.sendConsumptionData("49571273", consumptionRequest);
    }

    @Test
    public void testHeaders() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/transactionInfoResponse.json", request -> {
            Assertions.assertTrue(request.header("User-Agent").startsWith("app-store-server-library/java"));
            Assertions.assertEquals("application/json", request.header("Accept"));
            String authorization = request.header("Authorization");
            Assertions.assertTrue(authorization.startsWith("Bearer "));
            DecodedJWT token = JWT.decode(authorization.substring(7));
            Assertions.assertEquals(List.of("appstoreconnect-v1"), token.getAudience());
            Assertions.assertEquals("issuerId", token.getIssuer());
            Assertions.assertEquals("keyId", token.getKeyId());
            Assertions.assertEquals("com.example", token.getClaim("bid").asString());
            Assertions.assertEquals("ES256", token.getAlgorithm());
        });

        client.getTransactionInfo("1234");
    }

    @Test
    public void testAPIError() throws IOException {
        String body = TestingUtility.readFile("models/apiException.json");
        AppStoreServerAPIClient client = getAppStoreServerAPIClient(body, request -> {}, 500);
        try {
            client.getTransactionInfo("1234");
        } catch (APIException e) {
            Assertions.assertEquals(500, e.getHttpStatusCode());
            Assertions.assertEquals(APIError.GENERAL_INTERNAL, e.getApiError());
            Assertions.assertEquals(5000000L, e.getRawApiError());
            Assertions.assertEquals("An unknown error occurred.", e.getApiErrorMessage());
            return;
        }
        Assertions.fail();
    }

    @Test
    public void testAPITooManyRequests() throws IOException {
        String body = TestingUtility.readFile("models/apiTooManyRequestsException.json");
        AppStoreServerAPIClient client = getAppStoreServerAPIClient(body, request -> {}, 429);
        try {
            client.getTransactionInfo("1234");
        } catch (APIException e) {
            Assertions.assertEquals(429, e.getHttpStatusCode());
            Assertions.assertEquals(APIError.RATE_LIMIT_EXCEEDED, e.getApiError());
            Assertions.assertEquals(4290000L, e.getRawApiError());
            Assertions.assertEquals("Rate limit exceeded.", e.getApiErrorMessage());
            return;
        }
        Assertions.fail();
    }

    @Test
    public void testAPIUnknownError() throws IOException {
        String body = TestingUtility.readFile("models/apiUnknownError.json");
        AppStoreServerAPIClient client = getAppStoreServerAPIClient(body, request -> {}, 400);
        try {
            client.getTransactionInfo("1234");
        } catch (APIException e) {
            Assertions.assertEquals(400, e.getHttpStatusCode());
            Assertions.assertNull(e.getApiError());
            Assertions.assertEquals(9990000L, e.getRawApiError());
            Assertions.assertEquals("Testing error.", e.getApiErrorMessage());
            return;
        }
        Assertions.fail();
    }

    @Test
    public void testDecodingWithUnknownEnumValue() throws IOException, APIException {
        String body = TestingUtility.readFile("models/transactionHistoryResponseWithMalformedEnvironment.json");
        AppStoreServerAPIClient client = getAppStoreServerAPIClient(body, request -> {}, 200);

        TransactionHistoryRequest request = new TransactionHistoryRequest()
                .sort(TransactionHistoryRequest.Order.ASCENDING)
                .productTypes(List.of(TransactionHistoryRequest.ProductType.CONSUMABLE, TransactionHistoryRequest.ProductType.AUTO_RENEWABLE))
                .endDate(123456L)
                .startDate(123455L)
                .revoked(false)
                .inAppOwnershipType(InAppOwnershipType.FAMILY_SHARED)
                .productIds(List.of("com.example.1", "com.example.2"))
                .subscriptionGroupIdentifiers(List.of("sub_group_id", "sub_group_id_2"));

        HistoryResponse historyResponse = client.getTransactionHistory("1234", "revision_input", request);

        Assertions.assertNull(historyResponse.getEnvironment());
        Assertions.assertEquals("LocalTestingxxx", historyResponse.getRawEnvironment());
    }

    @Test
    public void testDecodingWithMalformedJson() throws IOException {
        String body = TestingUtility.readFile("models/transactionHistoryResponseWithMalformedAppAppleId.json");
        AppStoreServerAPIClient client = getAppStoreServerAPIClient(body, request -> {}, 200);

        TransactionHistoryRequest request = new TransactionHistoryRequest()
                .sort(TransactionHistoryRequest.Order.ASCENDING)
                .productTypes(List.of(TransactionHistoryRequest.ProductType.CONSUMABLE, TransactionHistoryRequest.ProductType.AUTO_RENEWABLE))
                .endDate(123456L)
                .startDate(123455L)
                .revoked(false)
                .inAppOwnershipType(InAppOwnershipType.FAMILY_SHARED)
                .productIds(List.of("com.example.1", "com.example.2"))
                .subscriptionGroupIdentifiers(List.of("sub_group_id", "sub_group_id_2"));

        try {
            client.getTransactionHistory("1234", "revision_input", request);
        } catch (APIException e) {
            Assertions.assertNull(e.getApiErrorMessage());
            Assertions.assertNull(e.getApiError());
            Assertions.assertNull(e.getRawApiError());
            Assertions.assertEquals(200, e.getHttpStatusCode());
            Assertions.assertNotNull(e.getCause());
            return;
        }
        Assertions.fail();
    }

    @Test
    public void testXcodeEnvironmentNotSupportedError() throws IOException {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            new AppStoreServerAPIClient(new String(key.readAllBytes()), "keyId", "issuerId", "com.example", Environment.XCODE);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Xcode is not a supported environment for an AppStoreServerAPIClient", e.getMessage());
            return;
        }
        Assertions.fail();
    }

    public AppStoreServerAPIClient getClientWithBody(String path, Consumer<Request> requestVerifier) throws IOException {
        String body = TestingUtility.readFile(path);
        return getAppStoreServerAPIClient(body, requestVerifier);
    }

    private AppStoreServerAPIClient getAppStoreServerAPIClient(String body, Consumer<Request> requestVerifier) throws IOException {
        return getAppStoreServerAPIClient(body, requestVerifier, 200);
    }

    private AppStoreServerAPIClient getAppStoreServerAPIClient(String body, Consumer<Request> requestVerifier, int statusCode) throws IOException {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            return new AppStoreServerAPIClient(new String(key.readAllBytes()), "keyId", "issuerId", "com.example", Environment.LOCAL_TESTING) {
                @Override
                protected Response getResponse(Request request) {
                    requestVerifier.accept(request);
                    return new Response.Builder()
                            .body(ResponseBody.create(body, MediaType.parse("application/json")))
                            .code(statusCode)
                            .request(request)
                            .protocol(Protocol.HTTP_1_1)
                            .message("")
                            .build();
                }
            };
        }
    }
}
