// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/renewalbillingplantype">renewalBillingPlanType</a>
 **/
public enum RenewalBillingPlanType {

    BILLED_UPFRONT("BILLED_UPFRONT"),
    MONTHLY("MONTHLY");

    private final String value;

    RenewalBillingPlanType(String value) {
        this.value = value;
    }

    public static RenewalBillingPlanType fromValue(String value) {
        for (RenewalBillingPlanType b : RenewalBillingPlanType.values()) {
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
