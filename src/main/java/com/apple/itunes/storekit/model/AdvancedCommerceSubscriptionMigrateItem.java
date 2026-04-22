// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

/**
 * The SKU, description, and display name to use for a migrated subscription item.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigrateitem">SubscriptionMigrateItem</a>
 */
public class AdvancedCommerceSubscriptionMigrateItem extends AbstractAdvancedCommerceItem {
    private AdvancedCommerceSubscriptionMigrateItem() {
        super();
    }

    public AdvancedCommerceSubscriptionMigrateItem(String sku, String description, String displayName) {
        super(sku, description, displayName);
    }

    @Override
    protected AdvancedCommerceSubscriptionMigrateItem self() {
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                " sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                " }";
    }
}