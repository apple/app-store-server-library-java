// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates your preferred outcome for the refund request.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreference">refundPreference</a>
 */
public enum RefundPreference {

    UNDECLARED(0),
    PREFER_GRANT(1),
    PREFER_DECLINE(2),
    NO_PREFERENCE(3);

    private final Integer value;

    RefundPreference(Integer value) {
        this.value = value;
    }

    public static RefundPreference fromValue(Integer value) {
        for (RefundPreference b : RefundPreference.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return null;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

