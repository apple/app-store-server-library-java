// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The data your app provides to change an item of an auto-renewable subscription.
 * 
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifychangeitem">SubscriptionModifyChangeItem</a>
 */
public enum AdvancedCommerceReason {
    UPGRADE("UPGRADE"),
    DOWNGRADE("DOWNGRADE"),
    APPLY_OFFER("APPLY_OFFER");

    private final String value;

    AdvancedCommerceReason(String value) {
        this.value = value;
    }

    public static AdvancedCommerceReason fromValue(String value) {
        for (AdvancedCommerceReason b : AdvancedCommerceReason.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}