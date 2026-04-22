// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Objects;

/**
 * The response body for a transaction refund request.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefundresponse">RequestRefundResponse</a>
 */
public class AdvancedCommerceRequestRefundResponse extends AbstractAdvancedCommerceResponse {
    private AdvancedCommerceRequestRefundResponse() {
        super();
    }

    public AdvancedCommerceRequestRefundResponse(String signedTransactionInfo) {
        super(null, Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceRequestRefundResponse self() {
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                '}';
    }
}