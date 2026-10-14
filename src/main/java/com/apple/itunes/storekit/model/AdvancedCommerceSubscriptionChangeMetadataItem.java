// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The metadata to change for an item, specifically its SKU, description, and display name.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadataitem">SubscriptionChangeMetadataItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionChangeMetadataItem {
    private static final String SERIALIZED_NAME_SKU = "SKU";
    private static final String SERIALIZED_NAME_CURRENT_SKU = "currentSKU";
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";

    @JsonProperty(SERIALIZED_NAME_SKU)
    private String sku;
    @JsonProperty(value = SERIALIZED_NAME_CURRENT_SKU, required = true)
    private String currentSku;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @JsonProperty(SERIALIZED_NAME_DISPLAY_NAME)
    private String displayName;
    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private String effective;

    protected AdvancedCommerceSubscriptionChangeMetadataItem() {
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem(String currentSku, AdvancedCommerceEffective effective) {
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
        this.effective = Objects.requireNonNull(effective).getValue();
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem(String currentSku, String rawEffective) {
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
        this.effective = Objects.requireNonNull(rawEffective);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem sku(String sku) {
        this.sku = HelperValidationUtils.validateSku(sku);
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
        this.sku = HelperValidationUtils.validateSku(sku);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem currentSku(String currentSku) {
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
        return this;
    }

    /**
     * The original SKU of the item.
     *
     * @return currentSKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    public String getCurrentSku() {
        return currentSku;
    }

    public void setCurrentSku(String currentSku) {
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem description(String description) {
        this.description = description == null ? null : HelperValidationUtils.validateDescription(description);
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
        this.description = description == null ? null : HelperValidationUtils.validateDescription(description);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem displayName(String displayName) {
        this.displayName = displayName == null ? null : HelperValidationUtils.validateDisplayName(displayName);
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
        this.displayName = displayName == null ? null : HelperValidationUtils.validateDisplayName(displayName);
    }

    public AdvancedCommerceSubscriptionChangeMetadataItem effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
        return this;
    }

    /**
     * The string that determines when the metadata change goes into effect.
     *
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return AdvancedCommerceEffective.fromValue(effective);
    }

    /**
     * @see #getEffective()
     **/
    public String getRawEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
    }

    public void setRawEffective(String rawEffective) {
        this.effective = Objects.requireNonNull(rawEffective);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedCommerceSubscriptionChangeMetadataItem advancedCommerceSubscriptionChangeMetadataItem = (AdvancedCommerceSubscriptionChangeMetadataItem) o;
        return Objects.equals(this.sku, advancedCommerceSubscriptionChangeMetadataItem.sku) &&
                Objects.equals(this.currentSku, advancedCommerceSubscriptionChangeMetadataItem.currentSku) &&
                Objects.equals(this.description, advancedCommerceSubscriptionChangeMetadataItem.description) &&
                Objects.equals(this.displayName, advancedCommerceSubscriptionChangeMetadataItem.displayName) &&
                Objects.equals(this.effective, advancedCommerceSubscriptionChangeMetadataItem.effective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, currentSku, description, displayName, effective);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionChangeMetadataItem{" +
                "sku='" + sku + '\'' +
                ", currentSku='" + currentSku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", effective='" + effective + '\'' +
                '}';
    }
}
