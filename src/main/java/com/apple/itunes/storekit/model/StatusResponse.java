// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains status information for all of a customer’s auto-renewable subscriptions in your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/statusresponse">StatusResponse</a>
 */
public class StatusResponse {
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_DATA = "data";
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_DATA)
    private List<SubscriptionGroupIdentifierItem> data = null;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public StatusResponse() {
    }

    public StatusResponse environment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
        return this;
    }

    /**
     * The server environment, sandbox or production, in which the App Store generated the response.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
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

    public StatusResponse bundleId(String bundleId) {
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

    public StatusResponse appAppleId(Long appAppleId) {
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

    public StatusResponse data(List<SubscriptionGroupIdentifierItem> data) {
        this.data = data;
        return this;
    }

    public StatusResponse addDataItem(SubscriptionGroupIdentifierItem dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * An array of information for auto-renewable subscriptions, including App Store-signed transaction information and App Store-signed renewal information.
     *
     * @return data
     **/
    public List<SubscriptionGroupIdentifierItem> getData() {
        return data;
    }

    public void setData(List<SubscriptionGroupIdentifierItem> data) {
        this.data = data;
    }


    public StatusResponse unknownFields(Map<String, Object> unknownFields) {
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
        StatusResponse statusResponse = (StatusResponse) o;
        return Objects.equals(this.environment, statusResponse.environment) &&
                Objects.equals(this.bundleId, statusResponse.bundleId) &&
                Objects.equals(this.appAppleId, statusResponse.appAppleId) &&
                Objects.equals(this.data, statusResponse.data) &&
                Objects.equals(this.unknownFields, statusResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(environment, bundleId, appAppleId, data, unknownFields);
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "environment='" + environment + '\'' +
                ", bundleId='" + bundleId + '\'' +
                ", appAppleId=" + appAppleId +
                ", data=" + data +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

