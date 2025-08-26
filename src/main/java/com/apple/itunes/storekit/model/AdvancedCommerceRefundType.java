// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Information about the refund request for an item, such as its SKU, the refund amount, reason, and type.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
 */
public enum AdvancedCommerceRefundType {

    FULL("FULL"),
    PRORATED("PRORATED"),
    CUSTOM("CUSTOM");

    private final String value;

    AdvancedCommerceRefundType(String value) {
        this.value = value;
    }

    public static AdvancedCommerceRefundType fromValue(String value) {
        for (AdvancedCommerceRefundType b : AdvancedCommerceRefundType.values()) {
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