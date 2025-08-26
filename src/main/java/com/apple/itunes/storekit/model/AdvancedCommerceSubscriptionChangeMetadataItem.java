// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The metadata to change for an item, specifically its SKU, description, and display name.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadataitem">SubscriptionChangeMetadataItem</a>
 */
public class AdvancedCommerceSubscriptionChangeMetadataItem {
    private static final String SERIALIZED_NAME_CURRENT_SKU = "currentSKU";
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
    private static final String SERIALIZED_NAME_SKU = "SKU";

    @JsonProperty(value = SERIALIZED_NAME_CURRENT_SKU, required = true)
    private String currentSku;
    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private AdvancedCommerceEffective effective;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @JsonProperty(SERIALIZED_NAME_DISPLAY_NAME)
    private String displayName;
    @JsonProperty(SERIALIZED_NAME_SKU)
    private String sku;

    private AdvancedCommerceSubscriptionChangeMetadataItem() {}

    public AdvancedCommerceSubscriptionChangeMetadataItem(String currentSKU, AdvancedCommerceEffective effective) {
        this.currentSku = AdvancedCommerceValidationUtils.validateSku(currentSKU);
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem currentSku(String currentSku) {
        this.currentSku = AdvancedCommerceValidationUtils.validateSku(currentSku);
        return this;
    }

    /**
     * The original SKU of the item.
     *
     * @return currentSku
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    public String getCurrentSku() {
        return currentSku;
    }

    public void setCurrentSku(String currentSku) {
        this.currentSku = AdvancedCommerceValidationUtils.validateSku(currentSku);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
        return this;
    }

    /**
     * The string that determines when the metadata change goes into effect.
     *
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem description(String description) {
        this.description = description == null ? null : AdvancedCommerceValidationUtils.validateDescription(description);
        return this;
    }

    /**
     * The new description for the item.
     * 
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : AdvancedCommerceValidationUtils.validateDescription(description);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem displayName(String displayName) {
        this.displayName = displayName == null ? null : AdvancedCommerceValidationUtils.validateDisplayName(displayName);
        return this;
    }

    /**
     * The new display name for the item.
     * 
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : AdvancedCommerceValidationUtils.validateDisplayName(displayName);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem sku(String sku) {
        this.sku = AdvancedCommerceValidationUtils.validateSku(sku);
        return this;
    }

    /**
     * The new SKU of the item.
     * 
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : AdvancedCommerceValidationUtils.validateSku(sku);
    } 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvancedCommerceSubscriptionChangeMetadataItem that = (AdvancedCommerceSubscriptionChangeMetadataItem) o;
        return Objects.equals(effective, that.effective) && Objects.equals(currentSku, that.currentSku) && Objects.equals(description, that.description) && Objects.equals(displayName, that.displayName) && Objects.equals(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(effective, currentSku, description, displayName, sku);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionChangeMetadataItem{" +
                "sku='" + sku + '\'' +
                ", currentSku='" + currentSku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", effective=" + effective +
                '}';
    }
}