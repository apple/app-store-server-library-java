// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The app metadata and the signed renewal and transaction information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/data">data</a>
 */
public class Data {
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_BUNDLE_VERSION = "bundleVersion";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTION_INFO = "signedTransactionInfo";
    private static final String SERIALIZED_NAME_SIGNED_RENEWAL_INFO = "signedRenewalInfo";
    private static final String SERIALIZED_NAME_STATUS = "status";
    private static final String SERIALIZED_NAME_CONSUMPTION_REQUEST_REASON = "consumptionRequestReason";
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_VERSION)
    private String bundleVersion;
    @JsonProperty(SERIALIZED_NAME_SIGNED_TRANSACTION_INFO)
    private String signedTransactionInfo;
    @JsonProperty(SERIALIZED_NAME_SIGNED_RENEWAL_INFO)
    private String signedRenewalInfo;
    @JsonProperty(SERIALIZED_NAME_STATUS)
    private Integer status;
    @JsonProperty(SERIALIZED_NAME_CONSUMPTION_REQUEST_REASON)
    private String consumptionRequestReason;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public Data() {
    }

    public Data environment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
        return this;
    }

    /**
     * The server environment that the notification applies to, either sandbox or production.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/environment">environment</a>
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
        this.environment = environment != null ? environment.getValue() : null;
    }

    public void setRawEnvironment(String rawEnvironment) {
        this.environment = rawEnvironment;
    }

    public Data appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * The unique identifier of an app in the App Store.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public Data bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of an app.
     *
     * @return bundleId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/bundleid">bundleId</a>
     **/
    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public Data bundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
        return this;
    }

    /**
     * The version of the build that identifies an iteration of the bundle.
     *
     * @return bundleVersion
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/bundleversion">bundleVersion</a>
     **/
    public String getBundleVersion() {
        return bundleVersion;
    }

    public void setBundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    public Data signedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
        return this;
    }

    /**
     * Transaction information signed by the App Store, in JSON Web Signature (JWS) format.
     *
     * @return signedTransactionInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransaction">JWSTransaction</a>
     **/
    public String getSignedTransactionInfo() {
        return signedTransactionInfo;
    }

    public void setSignedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
    }

    public Data signedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
        return this;
    }

    /**
     * Subscription renewal information, signed by the App Store, in JSON Web Signature (JWS) format.
     *
     * @return signedRenewalInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsrenewalinfo">JWSRenewalInfo</a>
     **/
    public String getSignedRenewalInfo() {
        return signedRenewalInfo;
    }

    public void setSignedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
    }

    public Data status(Status status) {
        this.status = status != null ? status.getValue() : null;
        return this;
    }

    /**
     * The status of an auto-renewable subscription as of the signedDate in the responseBodyV2DecodedPayload.
     *
     * @return status
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/status">status</a>
     **/
    public Status getStatus() {
        return status != null ? Status.fromValue(status) : null;
    }

    /**
     * @see #getStatus()
     */
    public Integer getRawStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status != null ? status.getValue() : null;
    }

    public void setRawStatus(Integer rawStatus) {
        this.status = rawStatus;
    }

    public Data consumptionRequestReason(ConsumptionRequestReason consumptionRequestReason) {
        this.consumptionRequestReason = consumptionRequestReason != null ? consumptionRequestReason.getValue() : null;
        return this;
    }

    /**
     * The reason the customer requested the refund.
     *
     * @return consumptionRequestReason
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/consumptionrequestreason">consumptionRequestReason</a>
     **/
    public ConsumptionRequestReason getConsumptionRequestReason() {
        return consumptionRequestReason != null ? ConsumptionRequestReason.fromValue(consumptionRequestReason) : null;
    }

    /**
     * @see #getConsumptionRequestReason()
     */
    public String getRawConsumptionRequestReason() {
        return consumptionRequestReason;
    }

    public void setConsumptionRequestReason(ConsumptionRequestReason consumptionRequestReason) {
        this.consumptionRequestReason = consumptionRequestReason != null ? consumptionRequestReason.getValue() : null;
    }

    public void setRawConsumptionRequestReason(String rawConsumptionRequestReason) {
        this.consumptionRequestReason = rawConsumptionRequestReason;
    }

    public Data unknownFields(Map<String, Object> unknownFields) {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return Objects.equals(this.environment, data.environment) &&
                Objects.equals(this.appAppleId, data.appAppleId) &&
                Objects.equals(this.bundleId, data.bundleId) &&
                Objects.equals(this.bundleVersion, data.bundleVersion) &&
                Objects.equals(this.signedTransactionInfo, data.signedTransactionInfo) &&
                Objects.equals(this.signedRenewalInfo, data.signedRenewalInfo) &&
                Objects.equals(this.status, data.status) &&
                Objects.equals(this.consumptionRequestReason, data.consumptionRequestReason) &&
                Objects.equals(this.unknownFields, data.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(environment, appAppleId, bundleId, bundleVersion, signedTransactionInfo, signedRenewalInfo, status, consumptionRequestReason, unknownFields);
    }

    @Override
    public String toString() {
        return "Data{" +
                "environment='" + environment + '\'' +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", bundleVersion='" + bundleVersion + '\'' +
                ", signedTransactionInfo='" + signedTransactionInfo + '\'' +
                ", signedRenewalInfo='" + signedRenewalInfo + '\'' +
                ", status=" + status +
                ", consumptionRequestReason='" + consumptionRequestReason + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

