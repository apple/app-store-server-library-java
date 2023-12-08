// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/status">status</a>
 */
public enum Status {

    ACTIVE(1),
    EXPIRED(2),
    BILLING_RETRY(3),
    BILLING_GRACE_PERIOD(4),
    REVOKED(5);

    private final Integer value;

    Status(Integer value) {
        this.value = value;
    }

    public static Status fromValue(Integer value) {
        for (Status b : Status.values()) {
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

