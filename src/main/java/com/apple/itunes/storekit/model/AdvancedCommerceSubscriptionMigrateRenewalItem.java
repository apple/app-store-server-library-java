// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The item information that replaces a migrated subscription item when the subscription renews.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigraterenewalitem">SubscriptionMigrateRenewalItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionMigrateRenewalItem extends AbstractAdvancedCommerceItem {
    protected AdvancedCommerceSubscriptionMigrateRenewalItem() {
        super();
    }

    public AdvancedCommerceSubscriptionMigrateRenewalItem(String sku, String description, String displayName) {
        super(sku, description, displayName);
    }

    @Override
    protected AdvancedCommerceSubscriptionMigrateRenewalItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateRenewalItem sku(String sku) {
        return (AdvancedCommerceSubscriptionMigrateRenewalItem) super.sku(sku);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateRenewalItem description(String description) {
        return (AdvancedCommerceSubscriptionMigrateRenewalItem) super.description(description);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateRenewalItem displayName(String displayName) {
        return (AdvancedCommerceSubscriptionMigrateRenewalItem) super.displayName(displayName);
    }

    /**
     * The SKU that the subscription item renews to at the next renewal period.
     *
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    @Override
    public String getSku() {
        return super.getSku();
    }

    /**
     * The description of the renewing SKU.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * The display name of the renewing SKU.
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
        return "AdvancedCommerceSubscriptionMigrateRenewalItem{" +
                "sku='" + getSku() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                '}';
    }
}
