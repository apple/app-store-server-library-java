// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The data your app provides to change a subscription price.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionpricechangeitem">SubscriptionPriceChangeItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionPriceChangeItem extends AbstractAdvancedCommerceBaseItem {
    private static final String SERIALIZED_NAME_DEPENDENT_SKUS = "dependentSKUs";
    private static final String SERIALIZED_NAME_PRICE = "price";

    @JsonProperty(SERIALIZED_NAME_DEPENDENT_SKUS)
    private List<String> dependentSKUs;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;

    protected AdvancedCommerceSubscriptionPriceChangeItem() {
        super();
    }

    public AdvancedCommerceSubscriptionPriceChangeItem(String sku, Long price) {
        super(sku);
        this.price = Objects.requireNonNull(price);
    }

    @Override
    protected AdvancedCommerceSubscriptionPriceChangeItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionPriceChangeItem sku(String sku) {
        return (AdvancedCommerceSubscriptionPriceChangeItem) super.sku(sku);
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

    public AdvancedCommerceSubscriptionPriceChangeItem dependentSKUs(List<String> dependentSKUs) {
        validateDependentSKUs(dependentSKUs);
        this.dependentSKUs = dependentSKUs;
        return this;
    }

    public AdvancedCommerceSubscriptionPriceChangeItem addDependentSKU(String dependentSKU) {
        Objects.requireNonNull(dependentSKU);
        HelperValidationUtils.validateSku(dependentSKU);
        if (this.dependentSKUs == null) {
            this.dependentSKUs = new ArrayList<>();
        }
        this.dependentSKUs.add(dependentSKU);
        return this;
    }

    /**
     * The product identifier of a dependent SKU in a subscription price change.
     *
     * @return dependentSKUs
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/dependentsku">dependentSKU</a>
     **/
    public List<String> getDependentSKUs() {
        return dependentSKUs;
    }

    public void setDependentSKUs(List<String> dependentSKUs) {
        validateDependentSKUs(dependentSKUs);
        this.dependentSKUs = dependentSKUs;
    }

    private void validateDependentSKUs(List<String> dependentSKUs) {
        if (dependentSKUs != null) {
            for (String sku : dependentSKUs) {
                HelperValidationUtils.validateSku(sku);
            }
        }
    }

    public AdvancedCommerceSubscriptionPriceChangeItem price(Long price) {
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
        AdvancedCommerceSubscriptionPriceChangeItem advancedCommerceSubscriptionPriceChangeItem = (AdvancedCommerceSubscriptionPriceChangeItem) o;
        return Objects.equals(this.dependentSKUs, advancedCommerceSubscriptionPriceChangeItem.dependentSKUs) &&
                Objects.equals(this.price, advancedCommerceSubscriptionPriceChangeItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dependentSKUs, price);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionPriceChangeItem{" +
                "sku='" + getSku() + '\'' +
                ", dependentSKUs=" + dependentSKUs +
                ", price=" + price +
                '}';
    }
}
