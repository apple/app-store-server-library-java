// Copyright (c) 2026 Apple Inc. Licensed under MIT License.
package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractAdvancedCommerceBaseItem {
    private static final String SERIALIZED_NAME_SKU = "SKU";

    @JsonProperty(value = SERIALIZED_NAME_SKU, required = true)
    protected String sku;

    protected AbstractAdvancedCommerceBaseItem() {}

    protected AbstractAdvancedCommerceBaseItem(String sku) {
        this.sku = AdvancedCommerceValidationUtils.validateSku(sku);
    }

    protected abstract AbstractAdvancedCommerceBaseItem self();

    public AbstractAdvancedCommerceBaseItem sku(String sku) {
        this.sku = AdvancedCommerceValidationUtils.validateSku(sku);
        return self();
    }

    /**
     * The product identifier of an in-app purchase product you manage in your own system.
     * 
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = AdvancedCommerceValidationUtils.validateSku(sku);
    }

}
