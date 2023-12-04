// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates whether the app successfully delivered an in-app purchase that works properly.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
 */
public enum DeliveryStatus {

    DELIVERED_AND_WORKING_PROPERLY(0),
    DID_NOT_DELIVER_DUE_TO_QUALITY_ISSUE(1),
    DELIVERED_WRONG_ITEM(2),
    DID_NOT_DELIVER_DUE_TO_SERVER_OUTAGE(3),
    DID_NOT_DELIVER_DUE_TO_IN_GAME_CURRENCY_CHANGE(4),
    DID_NOT_DELIVER_FOR_OTHER_REASON(5);

    private final Integer value;

    DeliveryStatus(Integer value) {
        this.value = value;
    }

    public static DeliveryStatus fromValue(Integer value) {
        for (DeliveryStatus b : DeliveryStatus.values()) {
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

