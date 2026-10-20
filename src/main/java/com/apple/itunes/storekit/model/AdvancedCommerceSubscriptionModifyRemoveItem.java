// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The data your app provides to remove an item from an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyremoveitem">SubscriptionModifyRemoveItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionModifyRemoveItem extends AbstractAdvancedCommerceBaseItem {
    protected AdvancedCommerceSubscriptionModifyRemoveItem() {
        super();
    }

    public AdvancedCommerceSubscriptionModifyRemoveItem(String sku) {
        super(sku);
    }

    @Override
    protected AdvancedCommerceSubscriptionModifyRemoveItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionModifyRemoveItem sku(String sku) {
        return (AdvancedCommerceSubscriptionModifyRemoveItem) super.sku(sku);
    }

    /**
     * The product identifier of an Apple In-App Purchase product you manage in your own system.
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
        return "AdvancedCommerceSubscriptionModifyRemoveItem{" +
                "sku='" + getSku() + '\'' +
                '}';
    }
}
