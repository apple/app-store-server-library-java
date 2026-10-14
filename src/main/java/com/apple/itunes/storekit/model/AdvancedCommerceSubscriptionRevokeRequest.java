// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body you provide to terminate a subscription and all its items immediately.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionrevokerequest">SubscriptionRevokeRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionRevokeRequest extends AdvancedCommerceRequest<AdvancedCommerceSubscriptionRevokeRequest> {
    private static final String SERIALIZED_NAME_REFUND_REASON = "refundReason";
    private static final String SERIALIZED_NAME_REFUND_RISKING_PREFERENCE = "refundRiskingPreference";
    private static final String SERIALIZED_NAME_REFUND_TYPE = "refundType";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";

    @JsonProperty(value = SERIALIZED_NAME_REFUND_REASON, required = true)
    private String refundReason;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_RISKING_PREFERENCE, required = true)
    private Boolean refundRiskingPreference;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_TYPE, required = true)
    private String refundType;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;

    protected AdvancedCommerceSubscriptionRevokeRequest() {
        super();
    }

    public AdvancedCommerceSubscriptionRevokeRequest(
            AdvancedCommerceRequestInfo requestInfo,
            AdvancedCommerceRefundReason refundReason,
            Boolean refundRiskingPreference,
            AdvancedCommerceRefundType refundType
    ) {
        super(requestInfo);
        this.refundReason = Objects.requireNonNull(refundReason).getValue();
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        this.refundType = Objects.requireNonNull(refundType).getValue();
    }

    public AdvancedCommerceSubscriptionRevokeRequest(
            AdvancedCommerceRequestInfo requestInfo,
            String rawRefundReason,
            Boolean refundRiskingPreference,
            String rawRefundType
    ) {
        super(requestInfo);
        this.refundReason = Objects.requireNonNull(rawRefundReason);
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        this.refundType = Objects.requireNonNull(rawRefundType);
    }

    @Override
    protected AdvancedCommerceSubscriptionRevokeRequest self() {
        return this;
    }

    /**
     * The metadata to include in server requests.
     *
     * @return requestInfo
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
     **/
    @Override
    public AdvancedCommerceRequestInfo getRequestInfo() {
        return super.getRequestInfo();
    }

    public AdvancedCommerceSubscriptionRevokeRequest refundReason(AdvancedCommerceRefundReason refundReason) {
        this.refundReason = Objects.requireNonNull(refundReason).getValue();
        return this;
    }

    /**
     * A reason to request a refund.
     *
     * @return refundReason
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundreason">refundReason</a>
     **/
    public AdvancedCommerceRefundReason getRefundReason() {
        return AdvancedCommerceRefundReason.fromValue(refundReason);
    }

    /**
     * @see #getRefundReason()
     **/
    public String getRawRefundReason() {
        return refundReason;
    }

    public void setRefundReason(AdvancedCommerceRefundReason refundReason) {
        this.refundReason = Objects.requireNonNull(refundReason).getValue();
    }

    public void setRawRefundReason(String rawRefundReason) {
        this.refundReason = Objects.requireNonNull(rawRefundReason);
    }

    public AdvancedCommerceSubscriptionRevokeRequest refundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        return this;
    }

    /**
     * A Boolean value that indicates whether the App Store asks you for consumption data to help inform the refund decision.
     *
     * @return refundRiskingPreference
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundriskingpreference">refundRiskingPreference</a>
     **/
    public Boolean getRefundRiskingPreference() {
        return refundRiskingPreference;
    }

    public void setRefundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
    }

    public AdvancedCommerceSubscriptionRevokeRequest refundType(AdvancedCommerceRefundType refundType) {
        this.refundType = Objects.requireNonNull(refundType).getValue();
        return this;
    }

    /**
     * @return refundType
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionrevokerequest">SubscriptionRevokeRequest</a>
     **/
    public AdvancedCommerceRefundType getRefundType() {
        return AdvancedCommerceRefundType.fromValue(refundType);
    }

    /**
     * @see #getRefundType()
     **/
    public String getRawRefundType() {
        return refundType;
    }

    public void setRefundType(AdvancedCommerceRefundType refundType) {
        this.refundType = Objects.requireNonNull(refundType).getValue();
    }

    public void setRawRefundType(String rawRefundType) {
        this.refundType = Objects.requireNonNull(rawRefundType);
    }

    public AdvancedCommerceSubscriptionRevokeRequest storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * A three-letter code that represents the country or region associated with the App Store storefront.
     *
     * @return storefront
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/storefront">storefront</a>
     **/
    public String getStorefront() {
        return storefront;
    }

    public void setStorefront(String storefront) {
        this.storefront = storefront;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AdvancedCommerceSubscriptionRevokeRequest advancedCommerceSubscriptionRevokeRequest = (AdvancedCommerceSubscriptionRevokeRequest) o;
        return Objects.equals(this.refundReason, advancedCommerceSubscriptionRevokeRequest.refundReason) &&
                Objects.equals(this.refundRiskingPreference, advancedCommerceSubscriptionRevokeRequest.refundRiskingPreference) &&
                Objects.equals(this.refundType, advancedCommerceSubscriptionRevokeRequest.refundType) &&
                Objects.equals(this.storefront, advancedCommerceSubscriptionRevokeRequest.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refundReason, refundRiskingPreference, refundType, storefront);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionRevokeRequest{" +
                "requestInfo=" + getRequestInfo() +
                ", refundReason='" + refundReason + '\'' +
                ", refundRiskingPreference=" + refundRiskingPreference +
                ", refundType='" + refundType + '\'' +
                ", storefront='" + storefront + '\'' +
                '}';
    }
}
