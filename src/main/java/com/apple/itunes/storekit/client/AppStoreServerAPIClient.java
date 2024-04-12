// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import com.apple.itunes.storekit.model.CheckTestNotificationResponse;
import com.apple.itunes.storekit.model.ConsumptionRequest;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.ErrorPayload;
import com.apple.itunes.storekit.model.ExtendRenewalDateRequest;
import com.apple.itunes.storekit.model.ExtendRenewalDateResponse;
import com.apple.itunes.storekit.model.HistoryResponse;
import com.apple.itunes.storekit.model.MassExtendRenewalDateRequest;
import com.apple.itunes.storekit.model.MassExtendRenewalDateResponse;
import com.apple.itunes.storekit.model.MassExtendRenewalDateStatusResponse;
import com.apple.itunes.storekit.model.NotificationHistoryRequest;
import com.apple.itunes.storekit.model.NotificationHistoryResponse;
import com.apple.itunes.storekit.model.OrderLookupResponse;
import com.apple.itunes.storekit.model.RefundHistoryResponse;
import com.apple.itunes.storekit.model.SendTestNotificationResponse;
import com.apple.itunes.storekit.model.Status;
import com.apple.itunes.storekit.model.StatusResponse;
import com.apple.itunes.storekit.model.TransactionHistoryRequest;
import com.apple.itunes.storekit.model.TransactionInfoResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class AppStoreServerAPIClient {
    private static final String PRODUCTION_URL = "https://api.storekit.itunes.apple.com";
    private static final String SANDBOX_URL = "https://api.storekit-sandbox.itunes.apple.com";
    private static final String LOCAL_TESTING_URL = "https://local-testing-base-url";
    private static final String USER_AGENT = "app-store-server-library/java/2.0.0";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient httpClient;
    private final BearerTokenAuthenticator bearerTokenAuthenticator;
    private final HttpUrl urlBase;
    private final ObjectMapper objectMapper;

    /**
     * Create an App Store Server API client
     * @param signingKey Your private key downloaded from App Store Connect
     * @param keyId Your private key ID from App Store Connect
     * @param issuerId Your issuer ID from the Keys page in App Store Connect
     * @param bundleId Your app’s bundle ID
     * @param environment The environment to target
     */
    public AppStoreServerAPIClient(String signingKey, String keyId, String issuerId, String bundleId, Environment environment) {
        this.bearerTokenAuthenticator = new BearerTokenAuthenticator(signingKey, keyId, issuerId, bundleId);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.httpClient = builder.build();
        switch (environment) {
            case XCODE:
                throw new IllegalArgumentException("Xcode is not a supported environment for an AppStoreServerAPIClient");
            case PRODUCTION:
                this.urlBase = HttpUrl.parse(PRODUCTION_URL);
                break;
            case LOCAL_TESTING:
                this.urlBase = HttpUrl.parse(LOCAL_TESTING_URL);
                break;
            case SANDBOX:
                this.urlBase = HttpUrl.parse(SANDBOX_URL);
                break;
            default:
                // This switch statement is exhaustive
                throw new IllegalStateException();
        }
        this.objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }

    private Response makeRequest(String path, String method, Map<String, List<String>> queryParameters, Object body) throws IOException {
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.addHeader("User-Agent", USER_AGENT);
        requestBuilder.addHeader("Authorization", "Bearer " + bearerTokenAuthenticator.generateToken());
        requestBuilder.addHeader("Accept", "application/json");
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(urlBase.resolve(path)).newBuilder();
        for (Map.Entry<String, List<String>> entry : queryParameters.entrySet()) {
            for (String queryValue : entry.getValue()) {
                urlBuilder.addQueryParameter(entry.getKey(), queryValue);
            }
        }
        requestBuilder.url(urlBuilder.build());
        if (body != null) {
            RequestBody requestBody = RequestBody.create(objectMapper.writeValueAsString(body), JSON);
            requestBuilder.method(method, requestBody);
        } else if (method.equals("POST")){
            requestBuilder.method(method, RequestBody.create("", null));
        } else {
            requestBuilder.method(method, null);
        }
        return getResponse(requestBuilder.build());
    }

    protected Response getResponse(Request request) throws IOException {
        Call call = httpClient.newCall(request);
        return call.execute();
    }

    protected <T> T makeHttpCall(String path, String method, Map<String, List<String>> queryParameters, Object body, Class<T> clazz) throws IOException, APIException {
        try (Response r = makeRequest(path, method, queryParameters, body)) {
            if (r.code() >= 200 && r.code() < 300) {
                if (clazz.equals(Void.class)) {
                    return null;
                }
                // Success
                ResponseBody responseBody = r.body();
                if (responseBody == null) {
                    throw new RuntimeException("Response code was 2xx but no body returned");
                }
                try {
                    return objectMapper.readValue(responseBody.charStream(), clazz);
                } catch (JsonProcessingException e) {
                    throw new APIException(r.code(), e);
                }
            } else {
                // Best effort to decode the body
                try {
                    ResponseBody responseBody = r.body();
                    if (responseBody != null) {
                        ErrorPayload errorPayload = objectMapper.readValue(responseBody.charStream(), ErrorPayload.class);
                        throw new APIException(r.code(), errorPayload.getErrorCode(), errorPayload.getErrorMessage());
                    }
                } catch (APIException e) {
                    throw e;
                } catch (Exception e) {
                    throw new APIException(r.code(), e);
                }
                throw new APIException(r.code());
            }
        }
    }


    /**
     * Uses a subscription’s product identifier to extend the renewal date for all of its eligible active subscribers.
     *
     * @param massExtendRenewalDateRequest The request body for extending a subscription renewal date for all of its active subscribers.
     * @return A response that indicates the server successfully received the subscription-renewal-date extension request.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extend_subscription_renewal_dates_for_all_active_subscribers">Extend Subscription Renewal Dates for All Active Subscribers</a>
     */
    public MassExtendRenewalDateResponse extendRenewalDateForAllActiveSubscribers(MassExtendRenewalDateRequest massExtendRenewalDateRequest) throws APIException, IOException {
        return makeHttpCall("/inApps/v1/subscriptions/extend/mass", "POST", Map.of(), massExtendRenewalDateRequest, MassExtendRenewalDateResponse.class);
    }

    /**
     * Extends the renewal date of a customer’s active subscription using the original transaction identifier.
     *
     * @param originalTransactionId    The original transaction identifier of the subscription receiving a renewal date extension.
     * @param extendRenewalDateRequest The request body containing subscription-renewal-extension data.
     * @return A response that indicates whether an individual renewal-date extension succeeded, and related details.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extend_a_subscription_renewal_date">Extend a Subscription Renewal Date</a>
     */
    public ExtendRenewalDateResponse extendSubscriptionRenewalDate(String originalTransactionId, ExtendRenewalDateRequest extendRenewalDateRequest) throws APIException, IOException {
        return makeHttpCall("/inApps/v1/subscriptions/extend/" + originalTransactionId, "PUT", Map.of(), extendRenewalDateRequest, ExtendRenewalDateResponse.class);
    }

    /**
     * Get the statuses for all of a customer’s auto-renewable subscriptions in your app.
     *
     * @param transactionId The identifier of a transaction that belongs to the customer, and which may be an original transaction identifier.
     * @param status An optional filter that indicates the status of subscriptions to include in the response. Your query may specify more than one status query parameter.
     * @return A response that contains status information for all of a customer’s auto-renewable subscriptions in your app.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_all_subscription_statuses">Get All Subscription Statuses</a>
     */
    public StatusResponse getAllSubscriptionStatuses(String transactionId, Status[] status) throws APIException, IOException {
        Map<String, List<String>> queryParameters = new HashMap<>();
        if (status != null) {
            queryParameters.put("status", Arrays.stream(status).map(s -> s.getValue().toString()).collect(Collectors.toList()));
        }
        return makeHttpCall("/inApps/v1/subscriptions/" + transactionId, "GET", queryParameters, null, StatusResponse.class);
    }

    /**
     * Get a paginated list of all of a customer’s refunded in-app purchases for your app.
     *
     * @param transactionId The identifier of a transaction that belongs to the customer, and which may be an original transaction identifier.
     * @param revision              A token you provide to get the next set of up to 20 transactions. All responses include a revision token. Use the revision token from the previous RefundHistoryResponse.
     * @return A response that contains status information for all of a customer’s auto-renewable subscriptions in your app.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_refund_history">Get Refund History</a>
     */
    public RefundHistoryResponse getRefundHistory(String transactionId, String revision) throws APIException, IOException {
        Map<String, List<String>> queryParameters = new HashMap<>();
        if (revision != null) {
            queryParameters.put("revision", List.of(revision));
        }
        return makeHttpCall("/inApps/v2/refund/lookup/" + transactionId, "GET", queryParameters, null, RefundHistoryResponse.class);
    }

    /**
     * Checks whether a renewal date extension request completed, and provides the final count of successful or failed extensions.
     *
     * @param requestIdentifier The UUID that represents your request to the Extend Subscription Renewal Dates for All Active Subscribers endpoint.
     * @param productId         The product identifier of the auto-renewable subscription that you request a renewal-date extension for.
     * @return A response that indicates the current status of a request to extend the subscription renewal date to all eligible subscribers.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_status_of_subscription_renewal_date_extensions">Get Status of Subscription Renewal Date Extensions</a>
     */
    public MassExtendRenewalDateStatusResponse getStatusOfSubscriptionRenewalDateExtensions(String requestIdentifier, String productId) throws APIException, IOException {
        return makeHttpCall("/inApps/v1/subscriptions/extend/mass/" + productId + "/" + requestIdentifier, "GET", Map.of(), null, MassExtendRenewalDateStatusResponse.class);
    }

    /**
     * Check the status of the test App Store server notification sent to your server.
     *
     * @param testNotificationToken The test notification token received from the Request a Test Notification endpoint
     * @return A response that contains the contents of the test notification sent by the App Store server and the result from your server.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_test_notification_status">Get Test Notification Status</a>
     */
    public CheckTestNotificationResponse getTestNotificationStatus(String testNotificationToken) throws APIException, IOException {
        return makeHttpCall("/inApps/v1/notifications/test/" + testNotificationToken, "GET", Map.of(), null, CheckTestNotificationResponse.class);
    }

    /**
     * Get a list of notifications that the App Store server attempted to send to your server.
     *
     * @param paginationToken An optional token you use to get the next set of up to 20 notification history records. All responses that have more records available include a paginationToken. Omit this parameter the first time you call this endpoint.
     * @param notificationHistoryRequest The request body that includes the start and end dates, and optional query constraints.
     * @return A response that contains the App Store Server Notifications history for your app.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_notification_history">Get Notification History</a>
     */
    public NotificationHistoryResponse getNotificationHistory(String paginationToken, NotificationHistoryRequest notificationHistoryRequest) throws APIException, IOException {
        Map<String, List<String>> queryParameters = new HashMap<>();
        if (paginationToken != null) {
            queryParameters.put("paginationToken", List.of(paginationToken));
        }
        return makeHttpCall("/inApps/v1/notifications/history", "POST", queryParameters, notificationHistoryRequest, NotificationHistoryResponse.class);
    }

    /**
     * Get a customer’s in-app purchase transaction history for your app.
     *
     * @param transactionId The identifier of a transaction that belongs to the customer, and which may be an original transaction identifier.
     * @param revision              A token you provide to get the next set of up to 20 transactions. All responses include a revision token. Note: For requests that use the revision token, include the same query parameters from the initial request. Use the revision token from the previous HistoryResponse.
     * @return A response that contains the customer’s transaction history for an app.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_transaction_history">Get Transaction History</a>
     */
    public HistoryResponse getTransactionHistory(String transactionId, String revision, TransactionHistoryRequest transactionHistoryRequest) throws APIException, IOException {
        Map<String, List<String>> queryParameters = new HashMap<>();
        if (revision != null) {
            queryParameters.put("revision", List.of(revision));
        }
        if (transactionHistoryRequest.getStartDate() != null) {
            queryParameters.put("startDate", List.of(transactionHistoryRequest.getStartDate().toString()));
        }
        if (transactionHistoryRequest.getEndDate() != null) {
            queryParameters.put("endDate", List.of(transactionHistoryRequest.getEndDate().toString()));
        }
        if (transactionHistoryRequest.getProductIds() != null) {
            queryParameters.put("productId", transactionHistoryRequest.getProductIds());
        }
        if (transactionHistoryRequest.getProductTypes() != null) {
            queryParameters.put("productType", transactionHistoryRequest.getProductTypes().stream().map(Enum::name).collect(Collectors.toList()));
        }
        if (transactionHistoryRequest.getSort() != null) {
            queryParameters.put("sort", List.of(transactionHistoryRequest.getSort().name()));
        }
        if (transactionHistoryRequest.getSubscriptionGroupIdentifiers() != null) {
            queryParameters.put("subscriptionGroupIdentifier", transactionHistoryRequest.getSubscriptionGroupIdentifiers());
        }
        if (transactionHistoryRequest.getInAppOwnershipType() != null) {
            queryParameters.put("inAppOwnershipType", List.of(transactionHistoryRequest.getInAppOwnershipType().name()));
        }
        if (transactionHistoryRequest.getRevoked() != null) {
            queryParameters.put("revoked", List.of(transactionHistoryRequest.getRevoked().toString()));
        }
        return makeHttpCall("/inApps/v1/history/" + transactionId, "GET", queryParameters, null, HistoryResponse.class);
    }

    /**
     * Get information about a single transaction for your app.
     * 
     * @param transactionId The identifier of a transaction that belongs to the customer, and which may be an original transaction identifier.
     * @return A response that contains signed transaction information for a single transaction.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_transaction_info">Get Transaction Info</a>
     */
    public TransactionInfoResponse getTransactionInfo(String transactionId) throws APIException, IOException {
        return makeHttpCall("/inApps/v1/transactions/" + transactionId, "GET", Map.of(), null, TransactionInfoResponse.class);
    }

    /**
     * Get a customer’s in-app purchases from a receipt using the order ID.
     *
     * @param orderId The order ID for in-app purchases that belong to the customer.
     * @return A response that includes the order lookup status and an array of signed transactions for the in-app purchases in the order.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/look_up_order_id">Look Up Order ID</a>
     */
    public OrderLookupResponse lookUpOrderId(String orderId) throws APIException, IOException {
        return makeHttpCall("/inApps/v1/lookup/" + orderId, "GET", Map.of(), null, OrderLookupResponse.class);
    }

    /**
     * Ask App Store Server Notifications to send a test notification to your server.
     *
     * @return A response that contains the test notification token.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/request_a_test_notification">Request a Test Notification</a>
     */
    public SendTestNotificationResponse requestTestNotification() throws APIException, IOException {
        return makeHttpCall("/inApps/v1/notifications/test", "POST", Map.of(), null, SendTestNotificationResponse.class);
    }

    /**
     * Send consumption information about a consumable in-app purchase to the App Store after your server receives a consumption request notification.
     *
     * @param transactionId The transaction identifier for which you’re providing consumption information. You receive this identifier in the CONSUMPTION_REQUEST notification the App Store sends to your server.
     * @param consumptionRequest    The request body containing consumption information.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/send_consumption_information">Send Consumption Information</a>
     */
    public void sendConsumptionData(String transactionId, ConsumptionRequest consumptionRequest) throws APIException, IOException {
        makeHttpCall("/inApps/v1/transactions/consumption/" + transactionId, "PUT", Map.of(), consumptionRequest, Void.class);
    }
}
