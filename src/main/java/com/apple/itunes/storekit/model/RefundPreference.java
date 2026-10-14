// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates your preferred outcome for the refund request.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreference">refundPreference</a>
 **/
public enum RefundPreference {

    /**
     * You prefer that the App Store declines the refund.
     **/
    DECLINE("DECLINE"),
    /**
     * You prefer that the App Store grants the refund in full.
     **/
    GRANT_FULL("GRANT_FULL"),
    /**
     * You prefer that the App Store grants a prorated refund.
     **/
    GRANT_PRORATED("GRANT_PRORATED");

    private final String value;

    RefundPreference(String value) {
        this.value = value;
    }

    public static RefundPreference fromValue(String value) {
        for (RefundPreference b : RefundPreference.values()) {
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
