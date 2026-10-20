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
 **/
public class StatusResponse {
    private static final String SERIALIZED_NAME_DATA = "data";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";

    @JsonProperty(SERIALIZED_NAME_DATA)
    private List<SubscriptionGroupIdentifierItem> data;
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public StatusResponse() {
    }

    public StatusResponse data(List<SubscriptionGroupIdentifierItem> data) {
        this.data = data;
        return this;
    }

    public StatusResponse addData(SubscriptionGroupIdentifierItem data) {
        Objects.requireNonNull(data);
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(data);
        return this;
    }

    /**
     * An array of information for auto-renewable subscriptions, including App Store-signed transaction information and App Store-signed renewal information.
     *
     * @return data
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptiongroupidentifieritem">SubscriptionGroupIdentifierItem</a>
     **/
    public List<SubscriptionGroupIdentifierItem> getData() {
        return data;
    }

    public void setData(List<SubscriptionGroupIdentifierItem> data) {
        this.data = data;
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
        return Environment.fromValue(environment);
    }

    /**
     * @see #getEnvironment()
     **/
    public String getRawEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
    }

    public void setRawEnvironment(String rawEnvironment) {
        this.environment = rawEnvironment;
    }

    public StatusResponse appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * Your app’s App Store identifier.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public StatusResponse bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * Your app’s bundle identifier.
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

    public StatusResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object
     *
     * @return A map of JSON keys to objects
     **/
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
        return Objects.equals(this.data, statusResponse.data) &&
                Objects.equals(this.environment, statusResponse.environment) &&
                Objects.equals(this.appAppleId, statusResponse.appAppleId) &&
                Objects.equals(this.bundleId, statusResponse.bundleId) &&
                Objects.equals(this.unknownFields, statusResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, environment, appAppleId, bundleId, unknownFields);
    }

    @Override
    public String toString() {
        return "StatusResponse{" +
                "data=" + data +
                ", environment='" + environment + '\'' +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
