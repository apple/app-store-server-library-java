// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

/**
 * The data your app provides to remove an item from an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyremoveitem">SubscriptionModifyRemoveItem</a>
 */
public class AdvancedCommerceSubscriptionModifyRemoveItem extends AbstractAdvancedCommerceBaseItem {
    private AdvancedCommerceSubscriptionModifyRemoveItem() {
        super();
    }

    public AdvancedCommerceSubscriptionModifyRemoveItem(String sku) {
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