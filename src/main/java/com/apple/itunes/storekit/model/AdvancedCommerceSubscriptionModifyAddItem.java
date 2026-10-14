// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to add items when it makes changes to an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyadditem">SubscriptionModifyAddItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    protected AdvancedCommerceSubscriptionModifyAddItem() {
        super();
    }

    public AdvancedCommerceSubscriptionModifyAddItem(String sku, String description, String displayName, Long price) {
        super(sku, description, displayName);
        this.price = Objects.requireNonNull(price);
    }

    @Override
    protected AdvancedCommerceSubscriptionModifyAddItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionModifyAddItem sku(String sku) {
        return (AdvancedCommerceSubscriptionModifyAddItem) super.sku(sku);
    }

    @Override
    public AdvancedCommerceSubscriptionModifyAddItem description(String description) {
        return (AdvancedCommerceSubscriptionModifyAddItem) super.description(description);
    }

    @Override
    public AdvancedCommerceSubscriptionModifyAddItem displayName(String displayName) {
        return (AdvancedCommerceSubscriptionModifyAddItem) super.displayName(displayName);
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

    /**
     * A string you provide that describes a SKU.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * A string with a product name that you can localize and is suitable for display to customers.
     *
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    @Override
    public String getDisplayName() {
        return super.getDisplayName();
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

    public AdvancedCommerceSubscriptionModifyAddItem price(Long price) {
        this.price = Objects.requireNonNull(price);
        return this;
    }

    /**
     * A price, in milliunits of a currency, for an Advanced Commerce API SKU.
     *
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
     * A prorated price, in milliunits of a currency, for an Advanced Commerce API SKU.
     *
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AdvancedCommerceSubscriptionModifyAddItem advancedCommerceSubscriptionModifyAddItem = (AdvancedCommerceSubscriptionModifyAddItem) o;
        return Objects.equals(this.offer, advancedCommerceSubscriptionModifyAddItem.offer) &&
                Objects.equals(this.price, advancedCommerceSubscriptionModifyAddItem.price) &&
                Objects.equals(this.proratedPrice, advancedCommerceSubscriptionModifyAddItem.proratedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, price, proratedPrice);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionModifyAddItem{" +
                "sku='" + getSku() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                ", proratedPrice=" + proratedPrice +
                '}';
    }
}
