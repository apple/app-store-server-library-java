// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A string value that indicates when a requested change to an auto-renewable subscription goes into effect.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
 */
public enum AdvancedCommerceEffective {

    IMMEDIATELY("IMMEDIATELY"),
    NEXT_BILL_CYCLE("NEXT_BILL_CYCLE");

    private final String value;

    AdvancedCommerceEffective(String value) {
        this.value = value;
    }

    public static AdvancedCommerceEffective fromValue(String value) {
        for (AdvancedCommerceEffective b : AdvancedCommerceEffective.values()) {
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