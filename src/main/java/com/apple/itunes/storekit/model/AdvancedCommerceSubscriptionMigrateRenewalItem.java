// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

/**
 * The item information that replaces a migrated subscription item when the subscription renews.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigraterenewalitem">SubscriptionMigrateRenewalItem</a>
 */
public class AdvancedCommerceSubscriptionMigrateRenewalItem extends AbstractAdvancedCommerceItem {
    private AdvancedCommerceSubscriptionMigrateRenewalItem() {
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
        return getClass().getSimpleName() + " {" +
                " sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                " }";
    }
}