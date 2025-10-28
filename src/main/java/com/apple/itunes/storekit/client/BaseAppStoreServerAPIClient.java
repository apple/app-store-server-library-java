// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import com.apple.itunes.storekit.model.CheckTestNotificationResponse;
import com.apple.itunes.storekit.model.ConsumptionRequest;
import com.apple.itunes.storekit.model.DefaultConfigurationRequest;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.ErrorPayload;
import com.apple.itunes.storekit.model.ExtendRenewalDateRequest;
import com.apple.itunes.storekit.model.ExtendRenewalDateResponse;
import com.apple.itunes.storekit.model.GetImageListResponse;
import com.apple.itunes.storekit.model.GetMessageListResponse;
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
import com.apple.itunes.storekit.model.UpdateAppAccountTokenRequest;
import com.apple.itunes.storekit.model.UploadMessageRequestBody;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * An abstract base class for an {@link AppStoreServerAPIClient} that allows replacing the underlying HTTP client
 */
public abstract class BaseAppStoreServerAPIClient {
    private static final String PRODUCTION_URL = "https://api.storekit.itunes.apple.com";
    private static final String SANDBOX_URL = "https://api.storekit-sandbox.itunes.apple.com";
    private static final String LOCAL_TESTING_URL = "https://local-testing-base-url";
    private static final String USER_AGENT = "app-store-server-library/java/3.6.0";
    private static final String JSON = "application/json; charset=utf-8";
    private static final String PNG = "image/png";

    private final BearerTokenAuthenticatorInterface bearerTokenAuthenticator;
    private final ObjectMapper objectMapper;

    protected final String url;

    public BaseAppStoreServerAPIClient(String signingKey, String keyId, String issuerId, String bundleId, Environment environment) {
       this(new BearerTokenAuthenticator(signingKey, keyId, issuerId, bundleId), environment);
    }

    public BaseAppStoreServerAPIClient(BearerTokenAuthenticatorInterface bearerTokenAuthenticator, Environment environment) {
        this.bearerTokenAuthenticator = bearerTokenAuthenticator;
        this.url = getUrlForEnvironment(environment);
        this.objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }

    protected String getUrlForEnvironment(Environment environment) {
        switch (environment) {
            case XCODE:
                throw new IllegalArgumentException("Xcode is not a supported environment for an AppStoreServerAPIClient");
            case PRODUCTION:
                return PRODUCTION_URL;
            case LOCAL_TESTING:
                return LOCAL_TESTING_URL;
            case SANDBOX:
                return SANDBOX_URL;
            default:
                // This switch statement is exhaustive
                throw new IllegalStateException();
        }
    }

    /**
     * Make an HTTP request
     * @param path The path of the request
     * @param method The HTTP method of the request
     * @param queryParameters A map of query parameters for the request
     * @param headers A map of headers for the request
     * @param contentType The content type of the request, nullable
     * @param body The Java object representing the body, nullable
     * @return An {@link HttpResponseInterface} representing the status code and optional response body
     * @throws IOException If an exception was thrown while making the request
     */
    protected abstract HttpResponseInterface makeRequest(String path,
                                                         String method,
                                                         Map<String, List<String>> queryParameters,
                                                         Map<String, String> headers,
                                                         String contentType,
                                                         byte[] body) throws IOException;

    protected <T> T makeHttpCall(String path, String method, Map<String, List<String>> queryParameters, Object body, Class<T> clazz, String contentType) throws IOException, APIException {
        Map<String, String> headers = Map.of("User-Agent", USER_AGENT,
                                             "Authorization", "Bearer " + bearerTokenAuthenticator.generateToken(),
                                             "Accept", "application/json");
        byte[] encodedBody;
        if (body instanceof byte[]) {
            encodedBody = (byte[]) body;
        } else if (body != null) {
            encodedBody = objectMapper.writeValueAsString(body).getBytes(StandardCharsets.UTF_8);
        } else if (method.equals("POST")) {
            encodedBody = new byte[] {};
        } else {
            encodedBody = null;
        }
        try (var r = makeRequest(path, method, queryParameters, headers, contentType, encodedBody)) {
            if (r.statusCode() >= 200 && r.statusCode() < 300) {
                if (clazz.equals(Void.class)) {
                    return null;
                }
                // Success
                var responseBody = r.body();
                if (responseBody == null) {
                    throw new RuntimeException("Response code was 2xx but no body returned");
                }
                try {
                    return objectMapper.readValue(responseBody, clazz);
                } catch (JsonProcessingException e) {
                    throw new APIException(r.statusCode(), e);
                }
            } else {
                // Best effort to decode the body
                try {
                    var responseBody = r.body();
                    if (responseBody != null) {
                        ErrorPayload errorPayload;
                        try {
                            errorPayload = objectMapper.readValue(responseBody, ErrorPayload.class);
                        } catch (JsonProcessingException ignored) {
                            // If we cannot parse the body, then simply return the status code
                            throw new APIException(r.statusCode());
                        }
                        throw new APIException(r.statusCode(), errorPayload.getErrorCode(), errorPayload.getErrorMessage());
                    }
                } catch (APIException e) {
                    throw e;
                } catch (Exception e) {
                    throw new APIException(r.statusCode(), e);
                }
                throw new APIException(r.statusCode());
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
        return makeHttpCall("/inApps/v1/subscriptions/extend/mass", "POST", Map.of(), massExtendRenewalDateRequest, MassExtendRenewalDateResponse.class, JSON);
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
        return makeHttpCall("/inApps/v1/subscriptions/extend/" + originalTransactionId, "PUT", Map.of(), extendRenewalDateRequest, ExtendRenewalDateResponse.class, JSON);
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
        return makeHttpCall("/inApps/v1/subscriptions/" + transactionId, "GET", queryParameters, null, StatusResponse.class, null);
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
        return makeHttpCall("/inApps/v2/refund/lookup/" + transactionId, "GET", queryParameters, null, RefundHistoryResponse.class, null);
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
        return makeHttpCall("/inApps/v1/subscriptions/extend/mass/" + productId + "/" + requestIdentifier, "GET", Map.of(), null, MassExtendRenewalDateStatusResponse.class, null);
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
        return makeHttpCall("/inApps/v1/notifications/test/" + testNotificationToken, "GET", Map.of(), null, CheckTestNotificationResponse.class, null);
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
        return makeHttpCall("/inApps/v1/notifications/history", "POST", queryParameters, notificationHistoryRequest, NotificationHistoryResponse.class, JSON);
    }

    /**
     * @see #getTransactionHistory(String, String, TransactionHistoryRequest, GetTransactionHistoryVersion)
     */
    @Deprecated(since = "2.2.0")
    public HistoryResponse getTransactionHistory(String transactionId, String revision, TransactionHistoryRequest transactionHistoryRequest) throws APIException, IOException {
        return this.getTransactionHistory(transactionId, revision, transactionHistoryRequest, GetTransactionHistoryVersion.V1);
    }

    /**
     * Get a customer’s in-app purchase transaction history for your app.
     *
     * @param transactionId The identifier of a transaction that belongs to the customer, and which may be an original transaction identifier.
     * @param revision              A token you provide to get the next set of up to 20 transactions. All responses include a revision token. Note: For requests that use the revision token, include the same query parameters from the initial request. Use the revision token from the previous HistoryResponse.
     * @param version The version of the Get Transaction History endpoint to use. V2 is recommended.
     * @return A response that contains the customer’s transaction history for an app.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/get_transaction_history">Get Transaction History</a>
     */
    public HistoryResponse getTransactionHistory(String transactionId, String revision, TransactionHistoryRequest transactionHistoryRequest, GetTransactionHistoryVersion version) throws APIException, IOException {
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
        return makeHttpCall("/inApps/" + version.getUrlVersion() + "/history/" + transactionId, "GET", queryParameters, null, HistoryResponse.class, null);
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
        return makeHttpCall("/inApps/v1/transactions/" + transactionId, "GET", Map.of(), null, TransactionInfoResponse.class, null);
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
        return makeHttpCall("/inApps/v1/lookup/" + orderId, "GET", Map.of(), null, OrderLookupResponse.class, null);
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
        return makeHttpCall("/inApps/v1/notifications/test", "POST", Map.of(), null, SendTestNotificationResponse.class, null);
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
        makeHttpCall("/inApps/v1/transactions/consumption/" + transactionId, "PUT", Map.of(), consumptionRequest, Void.class, JSON);
    }


    /**
     * Sets the app account token value for a purchase the customer makes outside your app, or updates its value in an existing transaction.
     *
     * @param originalTransactionId The original transaction identifier of the transaction to receive the app account token update.
     * @param updateAppAccountTokenRequest The request body that contains a valid app account token value.
     * @throws APIException If a response was returned indicating the request could not be processed.
     * @throws IOException  If an exception was thrown while making the request.
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/set-app-account-token">Set App Account Token</a>
     */
    public void setAppAccountToken(String originalTransactionId, UpdateAppAccountTokenRequest updateAppAccountTokenRequest) throws APIException, IOException {
        makeHttpCall("/inApps/v1/transactions/" + originalTransactionId + "/appAccountToken", "PUT", Map.of(), updateAppAccountTokenRequest, Void.class, JSON);
    }

    /**
     * Upload an image to use for retention messaging.
     *
     * @param imageIdentifier A UUID you provide to uniquely identify the image you upload.
     * @param image The image file to upload.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/upload-image">Upload Image</a>
     */
    public void uploadImage(UUID imageIdentifier, byte[] image) throws APIException, IOException {
        makeHttpCall("/inApps/v1/messaging/image/" + imageIdentifier, "PUT", Map.of(), image, Void.class, PNG);
    }

    /**
     * Delete a previously uploaded image.
     *
     * @param imageIdentifier The identifier of the image to delete.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/delete-image">Delete Image</a>
     */
    public void deleteImage(UUID imageIdentifier) throws APIException, IOException {
        makeHttpCall("/inApps/v1/messaging/image/" + imageIdentifier, "DELETE", Map.of(), null, Void.class, null);
    }

    /**
     * Get the image identifier and state for all uploaded images.
     *
     * @return A response that contains status information for all images.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/get-image-list">Get Image List</a>
     */
    public GetImageListResponse getImageList() throws APIException, IOException {
        return makeHttpCall("/inApps/v1/messaging/image/list", "GET", Map.of(), null, GetImageListResponse.class, null);
    }

    /**
     * Upload a message to use for retention messaging.
     *
     * @param messageIdentifier A UUID you provide to uniquely identify the message you upload.
     * @param uploadMessageRequestBody The message text to upload.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/upload-message">Upload Message</a>
     */
    public void uploadMessage(UUID messageIdentifier, UploadMessageRequestBody uploadMessageRequestBody) throws APIException, IOException {
        makeHttpCall("/inApps/v1/messaging/message/" + messageIdentifier, "PUT", Map.of(), uploadMessageRequestBody, Void.class, JSON);
    }

    /**
     * Delete a previously uploaded message.
     *
     * @param messageIdentifier The identifier of the message to delete.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/delete-message">Delete Message</a>
     */
    public void deleteMessage(UUID messageIdentifier) throws APIException, IOException {
        makeHttpCall("/inApps/v1/messaging/message/" + messageIdentifier, "DELETE", Map.of(), null, Void.class, null);
    }

    /**
     * Get the message identifier and state of all uploaded messages.
     *
     * @return A response that contains status information for all messages.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/get-message-list">Get Message List</a>
     */
    public GetMessageListResponse getMessageList() throws APIException, IOException {
        return makeHttpCall("/inApps/v1/messaging/message/list", "GET", Map.of(), null, GetMessageListResponse.class, null);
    }

    /**
     * Configure a default message for a specific product in a specific locale.
     *
     * @param productId The product identifier for the default configuration.
     * @param locale The locale for the default configuration.
     * @param defaultConfigurationRequest The request body that includes the message identifier to configure as the default message.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/configure-default-message">Configure Default Message</a>
     */
    public void configureDefaultMessage(String productId, String locale, DefaultConfigurationRequest defaultConfigurationRequest) throws APIException, IOException {
        makeHttpCall("/inApps/v1/messaging/default/" + productId + "/" + locale, "PUT", Map.of(), defaultConfigurationRequest, Void.class, JSON);
    }

    /**
     * Delete a default message for a product in a locale.
     *
     * @param productId The product ID of the default message configuration.
     * @param locale The locale of the default message configuration.
     * @throws APIException If a response was returned indicating the request could not be processed
     * @throws IOException  If an exception was thrown while making the request
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/delete-default-message">Delete Default Message</a>
     */
    public void deleteDefaultMessage(String productId, String locale) throws APIException, IOException {
        makeHttpCall("/inApps/v1/messaging/default/" + productId + "/" + locale, "DELETE", Map.of(), null, Void.class, null);
    }

    protected interface HttpResponseInterface extends Closeable {
        /**
         * @return The HTTP status code of the response
         */
        int statusCode();
        /**
         * A nullable {@link Reader} containing the response body
         * @return The response body, if it exists
         */
        Reader body();
    }
}
