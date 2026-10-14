// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SKU, description, and display name to use for a migrated subscription item.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigrateitem">SubscriptionMigrateItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionMigrateItem extends AbstractAdvancedCommerceItem {
    protected AdvancedCommerceSubscriptionMigrateItem() {
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
    public AdvancedCommerceSubscriptionMigrateItem sku(String sku) {
        return (AdvancedCommerceSubscriptionMigrateItem) super.sku(sku);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateItem description(String description) {
        return (AdvancedCommerceSubscriptionMigrateItem) super.description(description);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateItem displayName(String displayName) {
        return (AdvancedCommerceSubscriptionMigrateItem) super.displayName(displayName);
    }

    /**
     * The SKU to use for the migrated item.
     *
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    @Override
    public String getSku() {
        return super.getSku();
    }

    /**
     * The description of the SKU.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * The display name of the SKU.
     *
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    @Override
    public String getDisplayName() {
        return super.getDisplayName();
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
        return "AdvancedCommerceSubscriptionMigrateItem{" +
                "sku='" + getSku() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                '}';
    }
}
