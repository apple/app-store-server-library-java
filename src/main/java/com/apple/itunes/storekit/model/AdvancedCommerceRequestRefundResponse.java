// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The response body for a transaction refund request.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefundresponse">RequestRefundResponse</a>
 **/
public class AdvancedCommerceRequestRefundResponse extends AbstractAdvancedCommerceResponse {
    protected AdvancedCommerceRequestRefundResponse() {
        super();
    }

    @JsonCreator
    public AdvancedCommerceRequestRefundResponse(
            @JsonProperty(value = "signedTransactionInfo", required = true) String signedTransactionInfo
    ) {
        super(null, Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceRequestRefundResponse self() {
        return this;
    }

    @Override
    public AdvancedCommerceRequestRefundResponse unknownFields(Map<String, Object> unknownFields) {
        return (AdvancedCommerceRequestRefundResponse) super.unknownFields(unknownFields);
    }

    @Override
    public AdvancedCommerceRequestRefundResponse signedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        return (AdvancedCommerceRequestRefundResponse) super.signedTransactionInfo(signedTransactionInfo);
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
        return "AdvancedCommerceRequestRefundResponse{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                ", unknownFields=" + getUnknownFields() +
                '}';
    }
}
