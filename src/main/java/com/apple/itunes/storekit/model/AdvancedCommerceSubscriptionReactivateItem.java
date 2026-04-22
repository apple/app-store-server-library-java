// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

/**
 * An item in a subscription to reactive.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateitem">SubscriptionReactivateItem</a>
 */
public class AdvancedCommerceSubscriptionReactivateItem extends AbstractAdvancedCommerceBaseItem {

    private AdvancedCommerceSubscriptionReactivateItem() {
        super();
    }

    public AdvancedCommerceSubscriptionReactivateItem(String sku) {
        super(sku);
    }

    @Override
    protected AbstractAdvancedCommerceBaseItem self() {
        return this;
    }

    @Override
    public String toString() {
       return getClass().getSimpleName() + "{" +
                "sku='" + sku + '\'' +
                '}';
    }
}