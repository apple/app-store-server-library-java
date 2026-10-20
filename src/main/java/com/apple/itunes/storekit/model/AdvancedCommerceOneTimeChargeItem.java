// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The details of a one-time charge product, including its display name, price, SKU, and metadata.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/onetimechargeitem">OneTimeChargeItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceOneTimeChargeItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_PRICE = "price";

    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;

    protected AdvancedCommerceOneTimeChargeItem() {
        super();
    }

    public AdvancedCommerceOneTimeChargeItem(String description, String displayName, String sku, Long price) {
        super(sku, description, displayName);
        this.price = Objects.requireNonNull(price);
    }

    @Override
    protected AdvancedCommerceOneTimeChargeItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceOneTimeChargeItem sku(String sku) {
        return (AdvancedCommerceOneTimeChargeItem) super.sku(sku);
    }

    @Override
    public AdvancedCommerceOneTimeChargeItem description(String description) {
        return (AdvancedCommerceOneTimeChargeItem) super.description(description);
    }

    @Override
    public AdvancedCommerceOneTimeChargeItem displayName(String displayName) {
        return (AdvancedCommerceOneTimeChargeItem) super.displayName(displayName);
    }

    /**
     * The product identifier.
     *
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    @Override
    public String getSku() {
        return super.getSku();
    }

    /**
     * A description of the product that doesn’t display to customers.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * The product name, suitable for display to customers.
     *
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    @Override
    public String getDisplayName() {
        return super.getDisplayName();
    }

    public AdvancedCommerceOneTimeChargeItem price(Long price) {
        this.price = Objects.requireNonNull(price);
        return this;
    }

    /**
     * The price, in milliunits of the currency, of the one-time charge product.
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
        AdvancedCommerceOneTimeChargeItem advancedCommerceOneTimeChargeItem = (AdvancedCommerceOneTimeChargeItem) o;
        return Objects.equals(this.price, advancedCommerceOneTimeChargeItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceOneTimeChargeItem{" +
                "sku='" + getSku() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                ", price=" + price +
                '}';
    }
}
