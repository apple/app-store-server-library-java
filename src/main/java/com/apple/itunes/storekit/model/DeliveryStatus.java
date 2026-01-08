// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates whether the app successfully delivered an In-App Purchase that works properly.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
 */
public enum DeliveryStatus {

    DELIVERED("DELIVERED"),
    UNDELIVERED_QUALITY_ISSUE("UNDELIVERED_QUALITY_ISSUE"),
    UNDELIVERED_WRONG_ITEM("UNDELIVERED_WRONG_ITEM"),
    UNDELIVERED_SERVER_OUTAGE("UNDELIVERED_SERVER_OUTAGE"),
    UNDELIVERED_OTHER("UNDELIVERED_OTHER");

    private final String value;

    DeliveryStatus(String value) {
        this.value = value;
    }

    public static DeliveryStatus fromValue(String value) {
        for (DeliveryStatus b : DeliveryStatus.values()) {
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
