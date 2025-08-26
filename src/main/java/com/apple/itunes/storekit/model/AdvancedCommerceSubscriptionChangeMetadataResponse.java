// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Objects;

/**
 * The response body for a successful subscription metadata change.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadataresponse">SubscriptionChangeMetadataResponse</a>
 */
public class AdvancedCommerceSubscriptionChangeMetadataResponse extends AbstractAdvancedCommerceResponse {
    private AdvancedCommerceSubscriptionChangeMetadataResponse() {
        super();
    }

    public AdvancedCommerceSubscriptionChangeMetadataResponse(String signedRenewalInfo, String signedTransactionInfo) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionChangeMetadataResponse self() {
        return this;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + '\'' +
                ", signedTransactionInfo='" + getSignedTransactionInfo() + '\'' +
                '}';
    }
}