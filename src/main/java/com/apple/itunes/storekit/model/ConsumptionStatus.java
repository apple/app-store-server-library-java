// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates the extent to which the customer consumed the in-app purchase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionstatus">consumptionStatus</a>
 */
public enum ConsumptionStatus {

    UNDECLARED(0),
    NOT_CONSUMED(1),
    PARTIALLY_CONSUMED(2),
    FULLY_CONSUMED(3);

    private final Integer value;

    ConsumptionStatus(Integer value) {
        this.value = value;
    }

    public static ConsumptionStatus fromValue(Integer value) {
        for (ConsumptionStatus b : ConsumptionStatus.values()) {
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

