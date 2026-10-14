// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * The description and display name of the subscription to migrate to that you manage.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigratedescriptors">SubscriptionMigrateDescriptors</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionMigrateDescriptors extends AdvancedCommerceDescriptors {
    protected AdvancedCommerceSubscriptionMigrateDescriptors() {
        super();
    }

    public AdvancedCommerceSubscriptionMigrateDescriptors(String description, String displayName) {
        super(description, displayName);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateDescriptors description(String description) {
        return (AdvancedCommerceSubscriptionMigrateDescriptors) super.description(description);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateDescriptors displayName(String displayName) {
        return (AdvancedCommerceSubscriptionMigrateDescriptors) super.displayName(displayName);
    }

    @Override
    public AdvancedCommerceSubscriptionMigrateDescriptors unknownFields(Map<String, Object> unknownFields) {
        return (AdvancedCommerceSubscriptionMigrateDescriptors) super.unknownFields(unknownFields);
    }

    /**
     * The description of the subscription to migrate to.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * The display name of the subscription to migrate to.
     *
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    @Override
    public String getDisplayName() {
        return super.getDisplayName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionMigrateDescriptors{" +
                "description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                ", unknownFields=" + getUnknownFields() +
                '}';
    }
}
