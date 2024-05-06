// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The customer-provided reason for a refund request.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/consumptionrequestreason">consumptionRequestReason</a>
 */
public enum ConsumptionRequestReason {

    UNINTENDED_PURCHASE("UNINTENDED_PURCHASE"),
    FULFILLMENT_ISSUE("FULFILLMENT_ISSUE"),
    UNSATISFIED_WITH_PURCHASE("UNSATISFIED_WITH_PURCHASE"),
    LEGAL("LEGAL"),
    OTHER("OTHER");

    private final String value;

    ConsumptionRequestReason(String value) {
        this.value = value;
    }

    public static ConsumptionRequestReason fromValue(String value) {
        for (ConsumptionRequestReason b : ConsumptionRequestReason.values()) {
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

