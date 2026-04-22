// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The duration of a single cycle of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/period">period</a>
 */
public enum AdvancedCommercePeriod {

    P1W("P1W"),
    P1M("P1M"),
    P2M("P2M"),
    P3M("P3M"),
    P6M("P6M"),
    P1Y("P1Y");

    private final String value;

    AdvancedCommercePeriod(String value) {
        this.value = value;
    }

    public static AdvancedCommercePeriod fromValue(String value) {
        for (AdvancedCommercePeriod b : AdvancedCommercePeriod.values()) {
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