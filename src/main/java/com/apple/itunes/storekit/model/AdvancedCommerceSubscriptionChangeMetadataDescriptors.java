// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The subscription metadata to change, specifically the description and display name.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadatadescriptors">SubscriptionChangeMetadataDescriptors</a>
 */
public class AdvancedCommerceSubscriptionChangeMetadataDescriptors {
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";

    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private AdvancedCommerceEffective effective;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @JsonProperty(SERIALIZED_NAME_DISPLAY_NAME)
    private String displayName;

    private AdvancedCommerceSubscriptionChangeMetadataDescriptors() {}

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
        return this;
    }

    /**
     * The string that determines when the metadata change goes into effect.
     *
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">Effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors description(String description) {
        this.description = description == null ? null : AdvancedCommerceValidationUtils.validateDescription(description);
        return this;
    }

    /**
     * The new description for the subscription.
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

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors displayName(String displayName) {
        this.displayName = displayName == null ? null : AdvancedCommerceValidationUtils.validateDisplayName(displayName);
        return this;
    }

    /**
     * The new display name for the subscription.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvancedCommerceSubscriptionChangeMetadataDescriptors that = (AdvancedCommerceSubscriptionChangeMetadataDescriptors) o;
        return Objects.equals(effective, that.effective) && Objects.equals(description, that.description) && Objects.equals(displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), effective, description, displayName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "effective=" + effective +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}