// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The duration of a single cycle of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/period">period</a>
 **/
public enum AdvancedCommercePeriod {

    /**
     * A period that is 1 week in duration.
     **/
    P1W("P1W"),
    /**
     * A period that is 1 month in duration.
     **/
    P1M("P1M"),
    /**
     * A period that is 2 months in duration.
     **/
    P2M("P2M"),
    /**
     * A period that is 3 months in duration.
     **/
    P3M("P3M"),
    /**
     * A period that is 6 months in duration.
     **/
    P6M("P6M"),
    /**
     * A period that is 1 year in duration.
     **/
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
