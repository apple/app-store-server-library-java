// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to add items when it makes changes to an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyadditem">SubscriptionModifyAddItem</a>
 */
public class AdvancedCommerceSubscriptionModifyAddItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_PRORATED_PRICE = "proratedPrice";

    @JsonProperty(SERIALIZED_NAME_OFFER)
    private AdvancedCommerceOffer offer;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;
    @JsonProperty(SERIALIZED_NAME_PRORATED_PRICE)
    private Long proratedPrice;

    private AdvancedCommerceSubscriptionModifyAddItem() {
        super();
    }

    protected AbstractAdvancedCommerceItem self() {
       return this;
    }

    public AdvancedCommerceSubscriptionModifyAddItem(String sku, String description, String displayName, long price) {
        super(sku, description, displayName);
        this.price = Objects.requireNonNull(price);
    }

    public AdvancedCommerceSubscriptionModifyAddItem offer(AdvancedCommerceOffer offer) {
        this.offer = offer;
        return this;
    }

    /**
     * A discount offer for an auto-renewable subscription.
     *
     * @return offer
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
     **/
    public AdvancedCommerceOffer getOffer() {
        return offer;
    }

    public void setOffer(AdvancedCommerceOffer offer) {
        this.offer = offer;
    }

    public AdvancedCommerceSubscriptionModifyAddItem price(long price) {
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

    public AdvancedCommerceSubscriptionModifyAddItem proratedPrice(Long proratedPrice) {
        this.proratedPrice = proratedPrice;
        return this;
    }

    /**
     * @return proratedPrice
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/proratedprice">proratedPrice</a>
     **/
    public Long getProratedPrice() {
        return proratedPrice;
    }

    public void setProratedPrice(Long proratedPrice) {
        this.proratedPrice = proratedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceSubscriptionModifyAddItem that = (AdvancedCommerceSubscriptionModifyAddItem) o;
        return Objects.equals(offer, that.offer) && Objects.equals(price, that.price) && Objects.equals(proratedPrice, that.proratedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, price, proratedPrice);
    }

 @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", offer=" + offer + '\'' +
                ", price=" + price  + '\'' +
                ", proratedPrice=" + proratedPrice  + '\'' +
                '}';
    }
}