// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * The decoded request body the App Store sends to your server to request a real-time retention message.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/decodedrealtimerequestbody">DecodedRealtimeRequestBody</a>
 */
public class DecodedRealtimeRequestBody implements DecodedSignedData {
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_USER_LOCALE = "userLocale";
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    private static final String SERIALIZED_NAME_SIGNED_DATE = "signedDate";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    @JsonProperty(value = SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID, required = true)
    private String originalTransactionId;
    @JsonProperty(value = SERIALIZED_NAME_APP_APPLE_ID, required = true)
    private Long appAppleId;
    @JsonProperty(value = SERIALIZED_NAME_PRODUCT_ID, required = true)
    private String productId;
    @JsonProperty(value = SERIALIZED_NAME_USER_LOCALE, required = true)
    private String userLocale;
    @JsonProperty(value = SERIALIZED_NAME_REQUEST_IDENTIFIER, required = true)
    private UUID requestIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_SIGNED_DATE, required = true)
    private Long signedDate;
    @JsonProperty(value = SERIALIZED_NAME_ENVIRONMENT, required = true)
    private String environment;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    private DecodedRealtimeRequestBody() {
    }

    public DecodedRealtimeRequestBody(String originalTransactionId,
                                      Long appAppleId,
                                      String productId,
                                      String userLocale,
                                      UUID requestIdentifier,
                                      Long signedDate,
                                      Environment environment) {
        this(originalTransactionId, appAppleId, productId, userLocale, requestIdentifier, signedDate, Objects.requireNonNull(environment).getValue());
    }

    public DecodedRealtimeRequestBody(String originalTransactionId,
                                      Long appAppleId,
                                      String productId,
                                      String userLocale,
                                      UUID requestIdentifier,
                                      Long signedDate,
                                      String rawEnvironment) {
        this.originalTransactionId = Objects.requireNonNull(originalTransactionId);
        this.appAppleId = Objects.requireNonNull(appAppleId);
        this.productId = Objects.requireNonNull(productId);
        this.userLocale = Objects.requireNonNull(userLocale);
        this.requestIdentifier = Objects.requireNonNull(requestIdentifier);
        this.signedDate = Objects.requireNonNull(signedDate);
        this.environment = Objects.requireNonNull(rawEnvironment);
    }

    public DecodedRealtimeRequestBody originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = Objects.requireNonNull(originalTransactionId);
        return this;
    }

    /**
     * The original transaction identifier of the customer’s subscription.
     *
     * @return originalTransactionId
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/originaltransactionid">originalTransactionId</a>
     **/
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = Objects.requireNonNull(originalTransactionId);
    }

    public DecodedRealtimeRequestBody appAppleId(Long appAppleId) {
        this.appAppleId = Objects.requireNonNull(appAppleId);
        return this;
    }

    /**
     * The unique identifier of the app in the App Store.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = Objects.requireNonNull(appAppleId);
    }

    public DecodedRealtimeRequestBody productId(String productId) {
        this.productId = Objects.requireNonNull(productId);
        return this;
    }

    /**
     * The unique identifier of the auto-renewable subscription.
     *
     * @return productId
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/productid">productId</a>
     **/
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = Objects.requireNonNull(productId);
    }

    public DecodedRealtimeRequestBody userLocale(String userLocale) {
        this.userLocale = Objects.requireNonNull(userLocale);
        return this;
    }

    /**
     * The device’s locale.
     *
     * @return userLocale
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/locale">locale</a>
     **/
    public String getUserLocale() {
        return userLocale;
    }

    public void setUserLocale(String userLocale) {
        this.userLocale = Objects.requireNonNull(userLocale);
    }

    public DecodedRealtimeRequestBody requestIdentifier(UUID requestIdentifier) {
        this.requestIdentifier = Objects.requireNonNull(requestIdentifier);
        return this;
    }

    /**
     * A UUID the App Store server creates to uniquely identify each request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/requestidentifier">requestIdentifier</a>
     **/
    public UUID getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(UUID requestIdentifier) {
        this.requestIdentifier = Objects.requireNonNull(requestIdentifier);
    }

    public DecodedRealtimeRequestBody signedDate(Long signedDate) {
        this.signedDate = Objects.requireNonNull(signedDate);
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store signed the JSON Web Signature (JWS) data.
     *
     * @return signedDate
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/signeddate">signedDate</a>
     **/
    public Long getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Long signedDate) {
        this.signedDate = Objects.requireNonNull(signedDate);
    }

    public DecodedRealtimeRequestBody environment(Environment environment) {
        this.environment = Objects.requireNonNull(environment).getValue();
        return this;
    }

    /**
     * The server environment, either sandbox or production.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/environment">environment</a>
     **/
    public Environment getEnvironment() {
        return environment != null ? Environment.fromValue(environment) : null;
    }

    /**
     * @see #getEnvironment()
     */
    public String getRawEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = Objects.requireNonNull(environment).getValue();
    }

    public void setRawEnvironment(String rawEnvironment) {
        this.environment = Objects.requireNonNull(rawEnvironment);
    }

    public DecodedRealtimeRequestBody unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     Fields that are not recognized for this object

     @return A map of JSON keys to objects
     */
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecodedRealtimeRequestBody that = (DecodedRealtimeRequestBody) o;
        return Objects.equals(originalTransactionId, that.originalTransactionId) &&
                Objects.equals(appAppleId, that.appAppleId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(userLocale, that.userLocale) &&
                Objects.equals(requestIdentifier, that.requestIdentifier) &&
                Objects.equals(signedDate, that.signedDate) &&
                Objects.equals(environment, that.environment) &&
                Objects.equals(unknownFields, that.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalTransactionId, appAppleId, productId, userLocale, requestIdentifier, signedDate, environment, unknownFields);
    }

    @Override
    public String toString() {
        return "DecodedRealtimeRequestBody{" +
                "originalTransactionId='" + originalTransactionId + '\'' +
                ", appAppleId=" + appAppleId +
                ", productId='" + productId + '\'' +
                ", userLocale='" + userLocale + '\'' +
                ", requestIdentifier=" + requestIdentifier +
                ", signedDate=" + signedDate +
                ", environment='" + environment + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}