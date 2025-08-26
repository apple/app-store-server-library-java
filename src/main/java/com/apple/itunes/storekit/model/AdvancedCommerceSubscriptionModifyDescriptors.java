// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to change the description and display name of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifydescriptors">SubscriptionModifyDescriptors</a>
 */
public class AdvancedCommerceSubscriptionModifyDescriptors {
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
    
    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private AdvancedCommerceEffective effective;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @JsonProperty(SERIALIZED_NAME_DISPLAY_NAME)
    private String displayName;

    private AdvancedCommerceSubscriptionModifyDescriptors() {}

    public AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionModifyDescriptors effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
        return this;
    }

    /**
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionModifyDescriptors description(String description) {
        this.description = description == null ? null : AdvancedCommerceValidationUtils.validateDescription(description);
        return this;
    }

    /**
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : AdvancedCommerceValidationUtils.validateDescription(description);
    }

    public AdvancedCommerceSubscriptionModifyDescriptors displayName(String displayName) {
        this.displayName = displayName == null ? null : AdvancedCommerceValidationUtils.validateDisplayName(displayName);
        return this;
    }

    /**
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
        AdvancedCommerceSubscriptionModifyDescriptors that = (AdvancedCommerceSubscriptionModifyDescriptors) o;
        return Objects.equals(effective, that.effective) && Objects.equals(description, that.description) && Objects.equals(displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), effective, description, displayName);
    }

    @Override
    public String toString() {
         return getClass().getSimpleName() + "{" +
                "effective=" + effective + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}