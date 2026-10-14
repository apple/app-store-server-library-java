// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The response body for a successful subscription metadata change.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadataresponse">SubscriptionChangeMetadataResponse</a>
 **/
public class AdvancedCommerceSubscriptionChangeMetadataResponse extends AbstractAdvancedCommerceResponse {
    protected AdvancedCommerceSubscriptionChangeMetadataResponse() {
        super();
    }

    @JsonCreator
    public AdvancedCommerceSubscriptionChangeMetadataResponse(
            @JsonProperty(value = "signedRenewalInfo", required = true) String signedRenewalInfo,
            @JsonProperty(value = "signedTransactionInfo", required = true) String signedTransactionInfo
    ) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionChangeMetadataResponse self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionChangeMetadataResponse unknownFields(Map<String, Object> unknownFields) {
        return (AdvancedCommerceSubscriptionChangeMetadataResponse) super.unknownFields(unknownFields);
    }

    @Override
    public AdvancedCommerceSubscriptionChangeMetadataResponse signedRenewalInfo(String signedRenewalInfo) {
        Objects.requireNonNull(signedRenewalInfo);
        return (AdvancedCommerceSubscriptionChangeMetadataResponse) super.signedRenewalInfo(signedRenewalInfo);
    }

    @Override
    public AdvancedCommerceSubscriptionChangeMetadataResponse signedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        return (AdvancedCommerceSubscriptionChangeMetadataResponse) super.signedTransactionInfo(signedTransactionInfo);
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
        return "AdvancedCommerceSubscriptionChangeMetadataResponse{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                ", unknownFields=" + getUnknownFields() +
                '}';
    }
}
