// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The display name and description of a subscription product.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/descriptors">Descriptors</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceDescriptors {
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";

    @JsonProperty(value = SERIALIZED_NAME_DESCRIPTION, required = true)
    private String description;
    @JsonProperty(value = SERIALIZED_NAME_DISPLAY_NAME, required = true)
    private String displayName;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected AdvancedCommerceDescriptors() {
    }

    @JsonCreator
    public AdvancedCommerceDescriptors(
            @JsonProperty(value = SERIALIZED_NAME_DESCRIPTION, required = true) String description,
            @JsonProperty(value = SERIALIZED_NAME_DISPLAY_NAME, required = true) String displayName
    ) {
        this.description = HelperValidationUtils.validateDescription(description);
        this.displayName = HelperValidationUtils.validateDisplayName(displayName);
    }

    public AdvancedCommerceDescriptors description(String description) {
        this.description = HelperValidationUtils.validateDescription(description);
        return this;
    }

    /**
     * A string that contains a description of the product.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = HelperValidationUtils.validateDescription(description);
    }

    public AdvancedCommerceDescriptors displayName(String displayName) {
        this.displayName = HelperValidationUtils.validateDisplayName(displayName);
        return this;
    }

    /**
     * A string that contains the name of the product, suitable for display to customers.
     *
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = HelperValidationUtils.validateDisplayName(displayName);
    }

    public AdvancedCommerceDescriptors unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object
     *
     * @return A map of JSON keys to objects
     **/
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedCommerceDescriptors advancedCommerceDescriptors = (AdvancedCommerceDescriptors) o;
        return Objects.equals(this.description, advancedCommerceDescriptors.description) &&
                Objects.equals(this.displayName, advancedCommerceDescriptors.displayName) &&
                Objects.equals(this.unknownFields, advancedCommerceDescriptors.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, displayName, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceDescriptors{" +
                "description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
