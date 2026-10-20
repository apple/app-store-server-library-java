// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request body that contains subscription-renewal-extension data to apply for all eligible active subscribers.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/massextendrenewaldaterequest">MassExtendRenewalDateRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MassExtendRenewalDateRequest {
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    private static final String SERIALIZED_NAME_EXTEND_BY_DAYS = "extendByDays";
    private static final String SERIALIZED_NAME_EXTEND_REASON_CODE = "extendReasonCode";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_STOREFRONT_COUNTRY_CODES = "storefrontCountryCodes";

    @JsonProperty(value = SERIALIZED_NAME_REQUEST_IDENTIFIER, required = true)
    private String requestIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_EXTEND_BY_DAYS, required = true)
    private Integer extendByDays;
    @JsonProperty(value = SERIALIZED_NAME_EXTEND_REASON_CODE, required = true)
    private Integer extendReasonCode;
    @JsonProperty(value = SERIALIZED_NAME_PRODUCT_ID, required = true)
    private String productId;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT_COUNTRY_CODES)
    private List<String> storefrontCountryCodes;

    private static final int MAXIMUM_REQUEST_IDENTIFIER_LENGTH = 128;
    private static final int MINIMUM_EXTEND_BY_DAYS = 1;
    private static final int MAXIMUM_EXTEND_BY_DAYS = 90;
    private static final int MAXIMUM_STOREFRONT_COUNTRY_CODE_LENGTH = 3;

    protected MassExtendRenewalDateRequest() {
    }

    public MassExtendRenewalDateRequest(
            String requestIdentifier,
            Integer extendByDays,
            ExtendReasonCode extendReasonCode,
            String productId
    ) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
        this.extendByDays = validateExtendByDays(extendByDays);
        this.extendReasonCode = Objects.requireNonNull(extendReasonCode).getValue();
        this.productId = Objects.requireNonNull(productId);
    }

    public MassExtendRenewalDateRequest(
            String requestIdentifier,
            Integer extendByDays,
            Integer rawExtendReasonCode,
            String productId
    ) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
        this.extendByDays = validateExtendByDays(extendByDays);
        this.extendReasonCode = Objects.requireNonNull(rawExtendReasonCode);
        this.productId = Objects.requireNonNull(productId);
    }

    public MassExtendRenewalDateRequest requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
        return this;
    }

    /**
     * A string that contains a one-time UUID value you provide to identify this subscription-renewal-date extension request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
    }

    private String validateRequestIdentifier(String requestIdentifier) {
        Objects.requireNonNull(requestIdentifier);
        if (requestIdentifier.length() > MAXIMUM_REQUEST_IDENTIFIER_LENGTH) {
            throw new IllegalArgumentException("requestIdentifier length longer than maximum allowed");
        }
        return requestIdentifier;
    }

    public MassExtendRenewalDateRequest extendByDays(Integer extendByDays) {
        this.extendByDays = validateExtendByDays(extendByDays);
        return this;
    }

    /**
     * The number of days to extend the subscription renewal date.
     *
     * @return extendByDays
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendbydays">extendByDays</a>
     **/
    public Integer getExtendByDays() {
        return extendByDays;
    }

    public void setExtendByDays(Integer extendByDays) {
        this.extendByDays = validateExtendByDays(extendByDays);
    }

    private Integer validateExtendByDays(Integer extendByDays) {
        Objects.requireNonNull(extendByDays);
        if (extendByDays < MINIMUM_EXTEND_BY_DAYS || extendByDays > MAXIMUM_EXTEND_BY_DAYS) {
            throw new IllegalArgumentException("extendByDays must be between " + MINIMUM_EXTEND_BY_DAYS + " and " + MAXIMUM_EXTEND_BY_DAYS);
        }
        return extendByDays;
    }

    public MassExtendRenewalDateRequest extendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = Objects.requireNonNull(extendReasonCode).getValue();
        return this;
    }

    /**
     * The reason code for the subscription-renewal-date extension.
     *
     * @return extendReasonCode
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
     **/
    public ExtendReasonCode getExtendReasonCode() {
        return ExtendReasonCode.fromValue(extendReasonCode);
    }

    /**
     * @see #getExtendReasonCode()
     **/
    public Integer getRawExtendReasonCode() {
        return extendReasonCode;
    }

    public void setExtendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = Objects.requireNonNull(extendReasonCode).getValue();
    }

    public void setRawExtendReasonCode(Integer rawExtendReasonCode) {
        this.extendReasonCode = Objects.requireNonNull(rawExtendReasonCode);
    }

    public MassExtendRenewalDateRequest productId(String productId) {
        this.productId = Objects.requireNonNull(productId);
        return this;
    }

    /**
     * The product identifier of the auto-renewable subscription that you’re requesting the renewal-date extension for.
     *
     * @return productId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/productid">productId</a>
     **/
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = Objects.requireNonNull(productId);
    }

    public MassExtendRenewalDateRequest storefrontCountryCodes(List<String> storefrontCountryCodes) {
        validateStorefrontCountryCodes(storefrontCountryCodes);
        this.storefrontCountryCodes = storefrontCountryCodes;
        return this;
    }

    public MassExtendRenewalDateRequest addStorefrontCountryCode(String storefrontCountryCode) {
        Objects.requireNonNull(storefrontCountryCode);
        validateStorefrontCountryCode(storefrontCountryCode);
        if (this.storefrontCountryCodes == null) {
            this.storefrontCountryCodes = new ArrayList<>();
        }
        this.storefrontCountryCodes.add(storefrontCountryCode);
        return this;
    }

    /**
     * A list of storefront country codes you provide to limit the storefronts that are eligible to receive the subscription-renewal-date extension.
     *
     * @return storefrontCountryCodes
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/storefrontcountrycodes">storefrontCountryCodes</a>
     **/
    public List<String> getStorefrontCountryCodes() {
        return storefrontCountryCodes;
    }

    public void setStorefrontCountryCodes(List<String> storefrontCountryCodes) {
        validateStorefrontCountryCodes(storefrontCountryCodes);
        this.storefrontCountryCodes = storefrontCountryCodes;
    }

    private void validateStorefrontCountryCodes(List<String> storefrontCountryCodes) {
        if (storefrontCountryCodes != null) {
            for (String storefrontCountryCode : storefrontCountryCodes) {
                validateStorefrontCountryCode(storefrontCountryCode);
            }
        }
    }

    private void validateStorefrontCountryCode(String storefrontCountryCode) {
        if (storefrontCountryCode != null && storefrontCountryCode.length() > MAXIMUM_STOREFRONT_COUNTRY_CODE_LENGTH) {
            throw new IllegalArgumentException("storefrontCountryCode length longer than maximum allowed");
        }
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
        return Objects.equals(this.requestIdentifier, massExtendRenewalDateRequest.requestIdentifier) &&
                Objects.equals(this.extendByDays, massExtendRenewalDateRequest.extendByDays) &&
                Objects.equals(this.extendReasonCode, massExtendRenewalDateRequest.extendReasonCode) &&
                Objects.equals(this.productId, massExtendRenewalDateRequest.productId) &&
                Objects.equals(this.storefrontCountryCodes, massExtendRenewalDateRequest.storefrontCountryCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestIdentifier, extendByDays, extendReasonCode, productId, storefrontCountryCodes);
    }

    @Override
    public String toString() {
        return "MassExtendRenewalDateRequest{" +
                "requestIdentifier='" + requestIdentifier + '\'' +
                ", extendByDays=" + extendByDays +
                ", extendReasonCode=" + extendReasonCode +
                ", productId='" + productId + '\'' +
                ", storefrontCountryCodes=" + storefrontCountryCodes +
                '}';
    }
}
