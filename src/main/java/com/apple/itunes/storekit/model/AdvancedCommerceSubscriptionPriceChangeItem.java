// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The data your app provides to change a subscription price.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionpricechangeitem">SubscriptionPriceChangeItem</a>
 */
public class AdvancedCommerceSubscriptionPriceChangeItem extends AbstractAdvancedCommerceBaseItem{
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_DEPENDENT_SKUS = "dependentSKUs";

    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;
    @JsonProperty(SERIALIZED_DEPENDENT_SKUS)
    private List<String> dependentSKUs;

    private AdvancedCommerceSubscriptionPriceChangeItem() {
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

    public AdvancedCommerceSubscriptionPriceChangeItem price(Long price) {
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

    public AdvancedCommerceSubscriptionPriceChangeItem dependentSKUs(List<String> dependentSKUs) {
        validateDependentSKUs(dependentSKUs);
        this.dependentSKUs = dependentSKUs;
        return this;
    }

    public AdvancedCommerceSubscriptionPriceChangeItem addDependentSKU(String dependentSKU) {
        Objects.requireNonNull(dependentSKU);
        AdvancedCommerceValidationUtils.validateSku(dependentSKU);
        if (this.dependentSKUs == null) {
            this.dependentSKUs = new ArrayList<>();
        }
        this.dependentSKUs.add(dependentSKU);
        return this;
    }

    /**
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
                AdvancedCommerceValidationUtils.validateSku(sku);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceSubscriptionPriceChangeItem that = (AdvancedCommerceSubscriptionPriceChangeItem) o;
        return Objects.equals(price, that.price) && Objects.equals(dependentSKUs, that.dependentSKUs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, dependentSKUs);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "sku='" + sku + '\'' +
                ", price=" + price +
                ", dependentSKUs=" + dependentSKUs +
                '}';
    }
}