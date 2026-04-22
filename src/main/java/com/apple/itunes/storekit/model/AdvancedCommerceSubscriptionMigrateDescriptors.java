// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

/*
 * The description and display name of the subscription to migrate to that you manage.
 * 
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmigratedescriptors">SubscriptionMigrateDescriptors</a>
 */
public class AdvancedCommerceSubscriptionMigrateDescriptors extends AdvancedCommerceDescriptors {
    private AdvancedCommerceSubscriptionMigrateDescriptors() {
        super();
    }

    public AdvancedCommerceSubscriptionMigrateDescriptors(String description, String displayName) {
        super(description, displayName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
    
}
