// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractAdvancedCommerceItem extends AbstractAdvancedCommerceBaseItem {
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";

    @JsonProperty(value = SERIALIZED_NAME_DESCRIPTION, required = true)
    protected String description;
    @JsonProperty(value = SERIALIZED_NAME_DISPLAY_NAME, required = true)
    protected String displayName;

    protected AbstractAdvancedCommerceItem() {}

    protected AbstractAdvancedCommerceItem(String sku, String description, String displayName) {
        super(sku);
        this.description = AdvancedCommerceValidationUtils.validateDescription(description);
        this.displayName = AdvancedCommerceValidationUtils.validateDisplayName(displayName);
    }

    protected abstract AbstractAdvancedCommerceItem self();

    public AbstractAdvancedCommerceItem description(String description) {
        this.description = AdvancedCommerceValidationUtils.validateDescription(description);
        return self();
    }

    /**
     * A string you provide that describes a SKU.
     * 
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = AdvancedCommerceValidationUtils.validateDescription(description);
    }

    public AbstractAdvancedCommerceItem displayName(String displayName) {
        this.displayName = AdvancedCommerceValidationUtils.validateDisplayName(displayName);
        return self();
    }

    /**
     * A string with a product name that you can localize and is suitable for display to customers.
     * 
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = AdvancedCommerceValidationUtils.validateDisplayName(displayName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractAdvancedCommerceItem that = (AbstractAdvancedCommerceItem) o;
        return Objects.equals(this.sku, that.sku) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, description, displayName);
    }
}