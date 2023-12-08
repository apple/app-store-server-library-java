// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The payload data for a subscription-renewal-date extension notification.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/summary">summary</a>
 */
public class Summary {
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    private static final String SERIALIZED_NAME_STOREFRONT_COUNTRY_CODES = "storefrontCountryCodes";
    private static final String SERIALIZED_NAME_SUCCEEDED_COUNT = "succeededCount";
    private static final String SERIALIZED_NAME_FAILED_COUNT = "failedCount";
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;
    @JsonProperty(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT_COUNTRY_CODES)
    private List<String> storefrontCountryCodes;
    @JsonProperty(SERIALIZED_NAME_SUCCEEDED_COUNT)
    private Long succeededCount;
    @JsonProperty(SERIALIZED_NAME_FAILED_COUNT)
    private Long failedCount;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public Summary() {
    }

    public Summary environment(Environment environment) {
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

    public Summary appAppleId(Long appAppleId) {
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

    public Summary bundleId(String bundleId) {
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

    public Summary productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The unique identifier for the product, that you create in App Store Connect.
     *
     * @return productId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/productid">productId</a>
     **/
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Summary requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
        return this;
    }

    /**
     * A string that contains a unique identifier you provide to track each subscription-renewal-date extension request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
    }

    public Summary storefrontCountryCodes(List<String> storefrontCountryCodes) {
        this.storefrontCountryCodes = storefrontCountryCodes;
        return this;
    }

    public Summary addStorefrontCountryCodesItem(String storefrontCountryCodesItem) {
        if (this.storefrontCountryCodes == null) {
            this.storefrontCountryCodes = new ArrayList<>();
        }
        this.storefrontCountryCodes.add(storefrontCountryCodesItem);
        return this;
    }

    /**
     * A list of storefront country codes you provide to limit the storefronts for a subscription-renewal-date extension.
     *
     * @return storefrontCountryCodes
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/storefrontcountrycodes">storefrontCountryCodes</a>
     **/
    public List<String> getStorefrontCountryCodes() {
        return storefrontCountryCodes;
    }

    public void setStorefrontCountryCodes(List<String> storefrontCountryCodes) {
        this.storefrontCountryCodes = storefrontCountryCodes;
    }

    public Summary succeededCount(Long succeededCount) {
        this.succeededCount = succeededCount;
        return this;
    }

    /**
     * The count of subscriptions that successfully receive a subscription-renewal-date extension.
     *
     * @return succeededCount
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/succeededcount">succeededCount</a>
     **/
    public Long getSucceededCount() {
        return succeededCount;
    }

    public void setSucceededCount(Long succeededCount) {
        this.succeededCount = succeededCount;
    }

    public Summary failedCount(Long failedCount) {
        this.failedCount = failedCount;
        return this;
    }

    /**
     * The count of subscriptions that fail to receive a subscription-renewal-date extension.
     *
     * @return failedCount
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/failedcount">failedCount</a>
     **/
    public Long getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Long failedCount) {
        this.failedCount = failedCount;
    }


    public Summary unknownFields(Map<String, Object> unknownFields) {
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
        Summary summary = (Summary) o;
        return Objects.equals(this.environment, summary.environment) &&
                Objects.equals(this.appAppleId, summary.appAppleId) &&
                Objects.equals(this.bundleId, summary.bundleId) &&
                Objects.equals(this.productId, summary.productId) &&
                Objects.equals(this.requestIdentifier, summary.requestIdentifier) &&
                Objects.equals(this.storefrontCountryCodes, summary.storefrontCountryCodes) &&
                Objects.equals(this.succeededCount, summary.succeededCount) &&
                Objects.equals(this.failedCount, summary.failedCount) &&
                Objects.equals(this.unknownFields, summary.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(environment, appAppleId, bundleId, productId, requestIdentifier, storefrontCountryCodes, succeededCount, failedCount, unknownFields);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "environment='" + environment + '\'' +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", productId='" + productId + '\'' +
                ", requestIdentifier='" + requestIdentifier + '\'' +
                ", storefrontCountryCodes=" + storefrontCountryCodes +
                ", succeededCount=" + succeededCount +
                ", failedCount=" + failedCount +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

