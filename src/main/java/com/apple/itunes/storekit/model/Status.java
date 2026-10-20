// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/status">status</a>
 **/
public enum Status {

    /**
     * The auto-renewable subscription is active.
     **/
    ACTIVE(1),
    /**
     * The auto-renewable subscription is expired.
     **/
    EXPIRED(2),
    /**
     * The auto-renewable subscription is in a billing retry period.
     **/
    BILLING_RETRY(3),
    /**
     * The auto-renewable subscription is in a Billing Grace Period.
     **/
    BILLING_GRACE_PERIOD(4),
    /**
     * The auto-renewable subscription is revoked.
     **/
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
