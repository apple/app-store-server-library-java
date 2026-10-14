// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates whether the order ID in the request is valid for your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupstatus">OrderLookupStatus</a>
 **/
public enum OrderLookupStatus {

    /**
     * The orderId that you provided in the Look Up Order ID request is valid and contains at least one in-app purchase for your app.
     **/
    VALID(0),
    /**
     * The orderId is invalid or doesn’t contain any in-app purchases for your app.
     **/
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
