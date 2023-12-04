// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates whether the order ID in the request is valid for your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupstatus">OrderLookupStatus</a>
 */
public enum OrderLookupStatus {

    VALID(0),
    INVALID(1);

    private final Integer value;

    OrderLookupStatus(Integer value) {
        this.value = value;
    }

    public static OrderLookupStatus fromValue(Integer value) {
        for (OrderLookupStatus b : OrderLookupStatus.values()) {
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

