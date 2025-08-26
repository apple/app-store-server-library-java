// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Objects;

/**
 * A response that contains signed renewal and transaction information after a subscription successfully migrates to the Advanced Commerce API.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigrateresponse">SubscriptionMigrateResponse</a>
 */
public class AdvancedCommerceSubscriptionMigrateResponse extends AbstractAdvancedCommerceResponse {
    private AdvancedCommerceSubscriptionMigrateResponse() {
        super();
    }

    public AdvancedCommerceSubscriptionMigrateResponse(String signedRenewalInfo, String signedTransactionInfo) {
        super(Objects.requireNonNull(signedRenewalInfo), Objects.requireNonNull(signedTransactionInfo));
    }

    @Override
    protected AdvancedCommerceSubscriptionMigrateResponse self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateResponse signedRenewalInfo(String signedRenewalInfo) {
        Objects.requireNonNull(signedRenewalInfo);
        return (AdvancedCommerceSubscriptionMigrateResponse) super.signedRenewalInfo(signedRenewalInfo);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateResponse signedTransactionInfo(String signedTransactionInfo) {
        Objects.requireNonNull(signedTransactionInfo);
        return (AdvancedCommerceSubscriptionMigrateResponse) super.signedTransactionInfo(signedTransactionInfo);
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