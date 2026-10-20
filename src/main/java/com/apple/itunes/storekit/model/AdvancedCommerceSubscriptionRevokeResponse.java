// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The response body for a successful revoke-subscription request.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionrevokeresponse">SubscriptionRevokeResponse</a>
 **/
public class AdvancedCommerceSubscriptionRevokeResponse extends AbstractAdvancedCommerceResponse {
    protected AdvancedCommerceSubscriptionRevokeResponse() {
        super();
    }

    @JsonCreator
    public AdvancedCommerceSubscriptionRevokeResponse(
            @JsonProperty(value = "signedRenewalInfo", required = true) String signedRenewalInfo,
            @JsonProperty(value = "signedTransactionInfo", required = true) String signedTransactionInfo
    ) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionRevokeResponse self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionRevokeResponse unknownFields(Map<String, Object> unknownFields) {
        return (AdvancedCommerceSubscriptionRevokeResponse) super.unknownFields(unknownFields);
    }

    @Override
    public AdvancedCommerceSubscriptionRevokeResponse signedRenewalInfo(String signedRenewalInfo) {
        Objects.requireNonNull(signedRenewalInfo);
        return (AdvancedCommerceSubscriptionRevokeResponse) super.signedRenewalInfo(signedRenewalInfo);
    }

    @Override
    public AdvancedCommerceSubscriptionRevokeResponse signedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        return (AdvancedCommerceSubscriptionRevokeResponse) super.signedTransactionInfo(signedTransactionInfo);
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
        return "AdvancedCommerceSubscriptionRevokeResponse{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                ", unknownFields=" + getUnknownFields() +
                '}';
    }
}
