// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Objects;

/**
 * A response that contains signed JWS renewal and JWS transaction information after a subscription price change request.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionpricechangeresponse">SubscriptionPriceChangeResponse</a>
 */
public class AdvancedCommerceSubscriptionPriceChangeResponse extends AbstractAdvancedCommerceResponse {
    private AdvancedCommerceSubscriptionPriceChangeResponse() {
        super();
    }

    public AdvancedCommerceSubscriptionPriceChangeResponse(String signedRenewalInfo, String signedTransactionInfo) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionPriceChangeResponse self() {
        return this;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "signedRenewalInfo='" + getSignedRenewalInfo() + 
                ", signedTransactionInfo='" + getSignedTransactionInfo() + 
                '}';
    }
}