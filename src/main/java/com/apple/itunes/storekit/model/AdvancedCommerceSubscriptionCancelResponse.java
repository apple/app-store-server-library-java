// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Objects;

/**
 * The response body for a successful subscription cancellation.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncancelresponse">SubscriptionCancelResponse</a>
 */
public class AdvancedCommerceSubscriptionCancelResponse extends AbstractAdvancedCommerceResponse {
    private AdvancedCommerceSubscriptionCancelResponse() {
        super();
    }

    public AdvancedCommerceSubscriptionCancelResponse(String signedRenewalInfo, String signedTransactionInfo) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionCancelResponse self() {
        return this;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                '}';
    }
}