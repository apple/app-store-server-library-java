// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data that describes a subscription item.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncreateitem">SubscriptionCreateItem</a>
 */
public class AdvancedCommerceSubscriptionCreateItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";

    @JsonProperty(SERIALIZED_NAME_OFFER)
    private AdvancedCommerceOffer offer;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;

    private AdvancedCommerceSubscriptionCreateItem() {
        super();
    }

    @Override
    protected AbstractAdvancedCommerceItem self() {
       return this;
    }

    public AdvancedCommerceSubscriptionCreateItem(String sku, String description, String displayName, Long price) {
        super(sku, description, displayName);
        this.price = Objects.requireNonNull(price);
    }
    
    public AdvancedCommerceSubscriptionCreateItem offer(AdvancedCommerceOffer offer) {
        this.offer = offer;
        return this;
    }

    /**
     * @return offer
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
     **/
    public AdvancedCommerceOffer getOffer() {
        return offer;
    }

    public void setOffer(AdvancedCommerceOffer offer) {
        this.offer = offer;
    }

    public AdvancedCommerceSubscriptionCreateItem price(Long price) {
        this.price = Objects.requireNonNull(price);
        return this;
    }

    /**
     * @return price
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/price">price</a>
     **/
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = Objects.requireNonNull(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceSubscriptionCreateItem that = (AdvancedCommerceSubscriptionCreateItem) o;
        return Objects.equals(offer, that.offer) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", offer=" + offer + '\'' +
                ", price=" + price +
                '}';
    }
}