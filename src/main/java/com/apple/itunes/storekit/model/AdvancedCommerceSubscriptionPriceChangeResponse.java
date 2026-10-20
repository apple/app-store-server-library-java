// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A response that contains signed JWS renewal and JWS transaction information after a subscription price change request.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionpricechangeresponse">SubscriptionPriceChangeResponse</a>
 **/
public class AdvancedCommerceSubscriptionPriceChangeResponse extends AbstractAdvancedCommerceResponse {
    protected AdvancedCommerceSubscriptionPriceChangeResponse() {
        super();
    }

    @JsonCreator
    public AdvancedCommerceSubscriptionPriceChangeResponse(
            @JsonProperty(value = "signedRenewalInfo", required = true) String signedRenewalInfo,
            @JsonProperty(value = "signedTransactionInfo", required = true) String signedTransactionInfo
    ) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionPriceChangeResponse self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionPriceChangeResponse unknownFields(Map<String, Object> unknownFields) {
        return (AdvancedCommerceSubscriptionPriceChangeResponse) super.unknownFields(unknownFields);
    }

    @Override
    public AdvancedCommerceSubscriptionPriceChangeResponse signedRenewalInfo(String signedRenewalInfo) {
        Objects.requireNonNull(signedRenewalInfo);
        return (AdvancedCommerceSubscriptionPriceChangeResponse) super.signedRenewalInfo(signedRenewalInfo);
    }

    @Override
    public AdvancedCommerceSubscriptionPriceChangeResponse signedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        return (AdvancedCommerceSubscriptionPriceChangeResponse) super.signedTransactionInfo(signedTransactionInfo);
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
        return "AdvancedCommerceSubscriptionPriceChangeResponse{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                ", unknownFields=" + getUnknownFields() +
                '}';
    }
}
