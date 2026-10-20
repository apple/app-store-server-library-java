// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The response body for a successful subscription cancellation.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncancelresponse">SubscriptionCancelResponse</a>
 **/
public class AdvancedCommerceSubscriptionCancelResponse extends AbstractAdvancedCommerceResponse {
    protected AdvancedCommerceSubscriptionCancelResponse() {
        super();
    }

    @JsonCreator
    public AdvancedCommerceSubscriptionCancelResponse(
            @JsonProperty(value = "signedRenewalInfo", required = true) String signedRenewalInfo,
            @JsonProperty(value = "signedTransactionInfo", required = true) String signedTransactionInfo
    ) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionCancelResponse self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionCancelResponse unknownFields(Map<String, Object> unknownFields) {
        return (AdvancedCommerceSubscriptionCancelResponse) super.unknownFields(unknownFields);
    }

    @Override
    public AdvancedCommerceSubscriptionCancelResponse signedRenewalInfo(String signedRenewalInfo) {
        Objects.requireNonNull(signedRenewalInfo);
        return (AdvancedCommerceSubscriptionCancelResponse) super.signedRenewalInfo(signedRenewalInfo);
    }

    @Override
    public AdvancedCommerceSubscriptionCancelResponse signedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        return (AdvancedCommerceSubscriptionCancelResponse) super.signedTransactionInfo(signedTransactionInfo);
    }

    @Override
    public void setSignedRenewalInfo(String signedRenewalInfo) {
        Objects.requireNonNull(signedRenewalInfo);
        super.setSignedRenewalInfo(signedRenewalInfo);
    }

    @Override
    public void setSignedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        super.setSignedTransactionInfo(signedTransactionInfo);
    }

    /**
     * Subscription renewal information signed by the App Store, in JSON Web Signature (JWS) format.
     *
     * @return signedRenewalInfo
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/jwsrenewalinfo">JWSRenewalInfo</a>
     **/
    @Override
    public String getSignedRenewalInfo() {
        return super.getSignedRenewalInfo();
    }

    /**
     * Transaction information signed by the App Store, in JWS Compact Serialization format.
     *
     * @return signedTransactionInfo
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/jwstransaction">JWSTransaction</a>
     **/
    @Override
    public String getSignedTransactionInfo() {
        return super.getSignedTransactionInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionCancelResponse{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                ", unknownFields=" + getUnknownFields() +
                '}';
    }
}
