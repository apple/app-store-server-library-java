// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * An item in a subscription to reactivate.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateitem">SubscriptionReactivateItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionReactivateItem extends AbstractAdvancedCommerceBaseItem {
    protected AdvancedCommerceSubscriptionReactivateItem() {
        super();
    }

    public AdvancedCommerceSubscriptionReactivateItem(String sku) {
        super(sku);
    }

    @Override
    protected AdvancedCommerceSubscriptionReactivateItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionReactivateItem sku(String sku) {
        return (AdvancedCommerceSubscriptionReactivateItem) super.sku(sku);
    }

    /**
     * The SKU of the item to reactivate.
     *
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    @Override
    public String getSku() {
        return super.getSku();
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
        return "AdvancedCommerceSubscriptionReactivateItem{" +
                "sku='" + getSku() + '\'' +
                '}';
    }
}
