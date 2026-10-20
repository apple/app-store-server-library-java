// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data that describes a subscription item.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncreateitem">SubscriptionCreateItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionCreateItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";

    @JsonProperty(SERIALIZED_NAME_OFFER)
    private AdvancedCommerceOffer offer;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;

    protected AdvancedCommerceSubscriptionCreateItem() {
        super();
    }

    public AdvancedCommerceSubscriptionCreateItem(String sku, String description, String displayName, Long price) {
        super(sku, description, displayName);
        this.price = Objects.requireNonNull(price);
    }

    @Override
    protected AdvancedCommerceSubscriptionCreateItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionCreateItem sku(String sku) {
        return (AdvancedCommerceSubscriptionCreateItem) super.sku(sku);
    }

    @Override
    public AdvancedCommerceSubscriptionCreateItem description(String description) {
        return (AdvancedCommerceSubscriptionCreateItem) super.description(description);
    }

    @Override
    public AdvancedCommerceSubscriptionCreateItem displayName(String displayName) {
        return (AdvancedCommerceSubscriptionCreateItem) super.displayName(displayName);
    }

    /**
     * The item’s product identifier, which you define.
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

    public AdvancedCommerceSubscriptionCreateItem offer(AdvancedCommerceOffer offer) {
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

    public AdvancedCommerceSubscriptionCreateItem price(Long price) {
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
        AdvancedCommerceSubscriptionCreateItem advancedCommerceSubscriptionCreateItem = (AdvancedCommerceSubscriptionCreateItem) o;
        return Objects.equals(this.offer, advancedCommerceSubscriptionCreateItem.offer) &&
                Objects.equals(this.price, advancedCommerceSubscriptionCreateItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offer, price);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionCreateItem{" +
                "sku='" + getSku() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                '}';
    }
}
