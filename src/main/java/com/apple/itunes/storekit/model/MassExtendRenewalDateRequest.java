// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request body that contains subscription-renewal-extension data to apply for all eligible active subscribers.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/massextendrenewaldaterequest">MassExtendRenewalDateRequest</a>
 */
public class MassExtendRenewalDateRequest {
    private static final String SERIALIZED_NAME_EXTEND_BY_DAYS = "extendByDays";
    private static final String SERIALIZED_NAME_EXTEND_REASON_CODE = "extendReasonCode";
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    private static final String SERIALIZED_NAME_STOREFRONT_COUNTRY_CODES = "storefrontCountryCodes";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    @JsonProperty(SERIALIZED_NAME_EXTEND_BY_DAYS)
    private Integer extendByDays;
    @JsonProperty(SERIALIZED_NAME_EXTEND_REASON_CODE)
    private ExtendReasonCode extendReasonCode;
    @JsonProperty(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT_COUNTRY_CODES)
    private List<String> storefrontCountryCodes = null;
    @JsonProperty(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;


    public MassExtendRenewalDateRequest() {
    }

    public MassExtendRenewalDateRequest extendByDays(Integer extendByDays) {
        this.extendByDays = extendByDays;
        return this;
    }

    /**
     * The number of days to extend the subscription renewal date.
     *
     * @return extendByDays
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendbydays">extendByDays</a>
     * maximum: 90
     **/
    public Integer getExtendByDays() {
        return extendByDays;
    }

    public void setExtendByDays(Integer extendByDays) {
        this.extendByDays = extendByDays;
    }

    public MassExtendRenewalDateRequest extendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = extendReasonCode;
        return this;
    }

    /**
     * The reason code for the subscription-renewal-date extension.
     *
     * @return extendReasonCode
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
     **/
    public ExtendReasonCode getExtendReasonCode() {
        return extendReasonCode;
    }

    public void setExtendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = extendReasonCode;
    }

    public MassExtendRenewalDateRequest requestIdentifier(String requestIdentifier) {
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

    public MassExtendRenewalDateRequest storefrontCountryCodes(List<String> storefrontCountryCodes) {
        this.storefrontCountryCodes = storefrontCountryCodes;
        return this;
    }

    public MassExtendRenewalDateRequest addStorefrontCountryCodesItem(String storefrontCountryCodesItem) {
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

    public MassExtendRenewalDateRequest productId(String productId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MassExtendRenewalDateRequest massExtendRenewalDateRequest = (MassExtendRenewalDateRequest) o;
        return Objects.equals(this.extendByDays, massExtendRenewalDateRequest.extendByDays) &&
                Objects.equals(this.extendReasonCode, massExtendRenewalDateRequest.extendReasonCode) &&
                Objects.equals(this.requestIdentifier, massExtendRenewalDateRequest.requestIdentifier) &&
                Objects.equals(this.storefrontCountryCodes, massExtendRenewalDateRequest.storefrontCountryCodes) &&
                Objects.equals(this.productId, massExtendRenewalDateRequest.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extendByDays, extendReasonCode, requestIdentifier, storefrontCountryCodes, productId);
    }

    @Override
    public String toString() {
        return "MassExtendRenewalDateRequest{" +
                "extendByDays=" + extendByDays +
                ", extendReasonCode=" + extendReasonCode +
                ", requestIdentifier='" + requestIdentifier + '\'' +
                ", storefrontCountryCodes=" + storefrontCountryCodes +
                ", productId='" + productId + '\'' +
                '}';
    }
}

