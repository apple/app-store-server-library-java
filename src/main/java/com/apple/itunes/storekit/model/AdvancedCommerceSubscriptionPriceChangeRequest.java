// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * The request body you use to change the price of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionpricechangerequest">SubscriptionPriceChangeRequest</a>
 */
public class AdvancedCommerceSubscriptionPriceChangeRequest extends AdvancedCommerceRequest<AdvancedCommerceSubscriptionPriceChangeRequest> {
    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";

    @JsonProperty(SERIALIZED_NAME_CURRENCY)
    private String currency;
    @JsonProperty(value = SERIALIZED_NAME_ITEMS, required = true)
    private List<AdvancedCommerceSubscriptionPriceChangeItem> items;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    public AdvancedCommerceSubscriptionPriceChangeRequest() {}

    public AdvancedCommerceSubscriptionPriceChangeRequest(
            AdvancedCommerceRequestInfo requestInfo,
            List<AdvancedCommerceSubscriptionPriceChangeItem> items
    ) {
        super(requestInfo);
        this.items = Objects.requireNonNull(items);
    }

    @Override
    protected AdvancedCommerceSubscriptionPriceChangeRequest self() {
        return this;
    }

    public AdvancedCommerceSubscriptionPriceChangeRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * The currency of the prices.
     *
     * @return currency
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/currency">currency</a>
     **/
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AdvancedCommerceSubscriptionPriceChangeRequest items(List<AdvancedCommerceSubscriptionPriceChangeItem> items) {
        this.items = Objects.requireNonNull(items);
        return this;
    }

    public AdvancedCommerceSubscriptionPriceChangeRequest addItem(AdvancedCommerceSubscriptionPriceChangeItem item) {
        Objects.requireNonNull(item);
        this.items.add(item);
        return this;
    }

    /**
     * An array that contains one or more SKUs and the changed price for each SKU.
     *
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionpricechangeitem">SubscriptionPriceChangeItem</a>
     **/
    public List<AdvancedCommerceSubscriptionPriceChangeItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceSubscriptionPriceChangeItem> items) {
        this.items = Objects.requireNonNull(items);
    }

    public AdvancedCommerceSubscriptionPriceChangeRequest storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * The App Store storefront of the subscription.
     * 
     * @return storefront
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/storefront">storefront</a>
     **/
    public String getStorefront() {
        return storefront;
    }

    public void setStorefront(String storefront) {
        this.storefront = storefront;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceSubscriptionPriceChangeRequest that = (AdvancedCommerceSubscriptionPriceChangeRequest) o;
        return Objects.equals(currency, that.currency) && 
            Objects.equals(items, that.items) &&
            Objects.equals(storefront, that.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency, items, storefront);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "currency='" + currency + '\'' +
                ", items=" + items +
                ", requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                '}';
    }
}