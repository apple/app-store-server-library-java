// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of the performance test.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performanceteststatus">performanceTestStatus</a>
 */
public enum PerformanceTestStatus {

    PENDING("PENDING"),
    PASS("PASS"),
    FAIL("FAIL");

    private final String value;

    PerformanceTestStatus(String value) {
        this.value = value;
    }

    public static PerformanceTestStatus fromValue(String value) {
        for (PerformanceTestStatus b : PerformanceTestStatus.values()) {
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
