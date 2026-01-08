// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The object that contains the app metadata and signed app transaction information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/appdata">appData</a>
 */
public class AppData {
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_SIGNED_APP_TRANSACTION_INFO = "signedAppTransactionInfo";
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_SIGNED_APP_TRANSACTION_INFO)
    private String signedAppTransactionInfo;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public AppData() {
    }

    public AppData appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * The unique identifier of the app that the notification applies to.
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

    public AppData bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of the app.
     *
     * @return bundleId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/bundleid">bundleId</a>
     **/
    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public AppData environment(Environment environment) {
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

    public AppData signedAppTransactionInfo(String signedAppTransactionInfo) {
        this.signedAppTransactionInfo = signedAppTransactionInfo;
        return this;
    }

    /**
     * App transaction information signed by the App Store, in JSON Web Signature (JWS) format.
     *
     * @return signedAppTransactionInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/jwsapptransaction">JWSAppTransaction</a>
     **/
    public String getSignedAppTransactionInfo() {
        return signedAppTransactionInfo;
    }

    public void setSignedAppTransactionInfo(String signedAppTransactionInfo) {
        this.signedAppTransactionInfo = signedAppTransactionInfo;
    }

    public AppData unknownFields(Map<String, Object> unknownFields) {
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
        AppData appData = (AppData) o;
        return Objects.equals(this.appAppleId, appData.appAppleId) &&
                Objects.equals(this.bundleId, appData.bundleId) &&
                Objects.equals(this.environment, appData.environment) &&
                Objects.equals(this.signedAppTransactionInfo, appData.signedAppTransactionInfo) &&
                Objects.equals(this.unknownFields, appData.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appAppleId, bundleId, environment, signedAppTransactionInfo, unknownFields);
    }

    @Override
    public String toString() {
        return "AppData{" +
                "appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", environment='" + environment + '\'' +
                ", signedAppTransactionInfo='" + signedAppTransactionInfo + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}