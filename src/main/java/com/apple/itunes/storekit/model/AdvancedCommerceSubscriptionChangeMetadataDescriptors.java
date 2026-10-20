// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The subscription metadata to change, specifically the description and display name.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadatadescriptors">SubscriptionChangeMetadataDescriptors</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionChangeMetadataDescriptors {
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";

    @JsonProperty(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @JsonProperty(SERIALIZED_NAME_DISPLAY_NAME)
    private String displayName;
    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private String effective;

    protected AdvancedCommerceSubscriptionChangeMetadataDescriptors() {
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors(String rawEffective) {
        this.effective = Objects.requireNonNull(rawEffective);
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors description(String description) {
        this.description = description == null ? null : HelperValidationUtils.validateDescription(description);
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
        this.description = description == null ? null : HelperValidationUtils.validateDescription(description);
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors displayName(String displayName) {
        this.displayName = displayName == null ? null : HelperValidationUtils.validateDisplayName(displayName);
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
        this.displayName = displayName == null ? null : HelperValidationUtils.validateDisplayName(displayName);
    }

    public AdvancedCommerceSubscriptionChangeMetadataDescriptors effective(AdvancedCommerceEffective effective) {
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
        AdvancedCommerceSubscriptionChangeMetadataDescriptors advancedCommerceSubscriptionChangeMetadataDescriptors = (AdvancedCommerceSubscriptionChangeMetadataDescriptors) o;
        return Objects.equals(this.description, advancedCommerceSubscriptionChangeMetadataDescriptors.description) &&
                Objects.equals(this.displayName, advancedCommerceSubscriptionChangeMetadataDescriptors.displayName) &&
                Objects.equals(this.effective, advancedCommerceSubscriptionChangeMetadataDescriptors.effective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, displayName, effective);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionChangeMetadataDescriptors{" +
                "description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", effective='" + effective + '\'' +
                '}';
    }
}
