// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/billingplantype">billingPlanType</a>
 **/
public enum BillingPlanType {

    BILLED_UPFRONT("BILLED_UPFRONT"),
    MONTHLY("MONTHLY");

    private final String value;

    BillingPlanType(String value) {
        this.value = value;
    }

    public static BillingPlanType fromValue(String value) {
        for (BillingPlanType b : BillingPlanType.values()) {
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
