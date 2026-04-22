// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The details of a one-time charge product, including its display name, price, SKU, and metadata.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/onetimechargeitem">OneTimeChargeItem</a>
 */
public class AdvancedCommerceOneTimeChargeItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_PRICE = "price";
    
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;
    
    private AdvancedCommerceOneTimeChargeItem() {
        super();
    }

    @Override
    protected AdvancedCommerceOneTimeChargeItem self() {
        return this;
    }

    public AdvancedCommerceOneTimeChargeItem(String description, String displayName, String sku, Long price) {
        super(sku, description, displayName);
        this.price = Objects.requireNonNull(price);
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceOneTimeChargeItem that = (AdvancedCommerceOneTimeChargeItem) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", price=" + price +
                '}';
    }
}