// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body you provide to terminate a subscription and all its items immediately.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionrevokerequest">SubscriptionRevokeRequest</a>
 */
public class AdvancedCommerceSubscriptionRevokeRequest extends AdvancedCommerceRequest<AdvancedCommerceSubscriptionRevokeRequest> {
    private static final String SERIALIZED_NAME_REFUND_REASON = "refundReason";
    private static final String SERIALIZED_NAME_REFUND_RISKING_PREFERENCE = "refundRiskingPreference";
    private static final String SERIALIZED_NAME_REFUND_TYPE = "refundType";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";

    @JsonProperty(value = SERIALIZED_NAME_REFUND_REASON, required = true)
    private AdvancedCommerceRefundReason refundReason;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_RISKING_PREFERENCE, required = true)
    private Boolean refundRiskingPreference;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_TYPE, required = true)
    private String refundType;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;

    private AdvancedCommerceSubscriptionRevokeRequest() {
        super();
    }

    public AdvancedCommerceSubscriptionRevokeRequest(
            AdvancedCommerceRequestInfo requestInfo,
            Boolean refundRiskingPreference,
            AdvancedCommerceRefundReason refundReason,
            String refundType
        ) {
        super(requestInfo);
        this.refundReason = Objects.requireNonNull(refundReason);
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        this.refundType = Objects.requireNonNull(refundType);
    }

    @Override
    protected AdvancedCommerceSubscriptionRevokeRequest self() {
        return this;
    }

    public AdvancedCommerceSubscriptionRevokeRequest refundReason(AdvancedCommerceRefundReason refundReason) {
        this.refundReason = Objects.requireNonNull(refundReason);
        return this;
    }

    /**
     * @return refundReason
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundreason">refundReason</a>
     **/
    public AdvancedCommerceRefundReason getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(AdvancedCommerceRefundReason refundReason) {
        this.refundReason = Objects.requireNonNull(refundReason);
    }

    public AdvancedCommerceSubscriptionRevokeRequest refundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        return this;
    }

    /**
     * @return refundRiskingPreference
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundriskingpreference">refundRiskingPreference</a>
     **/
    public Boolean getRefundRiskingPreference() {
        return refundRiskingPreference;
    }

    public void setRefundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
    }

    public AdvancedCommerceSubscriptionRevokeRequest refundType(String refundType) {
        this.refundType  = Objects.requireNonNull(refundType);
        return this;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = Objects.requireNonNull(refundType);
    }

    public AdvancedCommerceSubscriptionRevokeRequest storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        AdvancedCommerceSubscriptionRevokeRequest that = (AdvancedCommerceSubscriptionRevokeRequest) o;
        return Objects.equals(refundReason, that.refundReason)
                && Objects.equals(refundRiskingPreference, that.refundRiskingPreference)
                && Objects.equals(refundType, that.refundType)
                && Objects.equals(storefront, that.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refundReason, refundRiskingPreference, refundType, storefront);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "refundReason=" + refundReason +
                ", refundRiskingPreference=" + refundRiskingPreference +
                ", refundType='" + refundType + '\'' +
                ", requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                '}';
    }
}