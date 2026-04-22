// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Objects;

/**
 * The response body for a successful revoke-subscription request.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionrevokeresponse">SubscriptionRevokeResponse</a>
 */
public class AdvancedCommerceSubscriptionRevokeResponse extends AbstractAdvancedCommerceResponse {
    private AdvancedCommerceSubscriptionRevokeResponse() {
        super();
    }

    public AdvancedCommerceSubscriptionRevokeResponse(String signedRenewalInfo, String signedTransactionInfo) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionRevokeResponse self() {
        return this;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                '}';
    }
}