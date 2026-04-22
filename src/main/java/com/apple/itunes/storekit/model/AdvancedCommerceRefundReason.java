// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A reason to request a refund.
 * 
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundreason">refundReason</a>
 */
public enum AdvancedCommerceRefundReason {

    UNINTENDED_PURCHASE("UNINTENDED_PURCHASE"),
    FULFILLMENT_ISSUE("FULFILLMENT_ISSUE"),
    UNSATISFIED_WITH_PURCHASE("UNSATISFIED_WITH_PURCHASE"),
    LEGAL("LEGAL"),
    OTHER("OTHER"),
    MODIFY_ITEMS_REFUND("MODIFY_ITEMS_REFUND"),
    SIMULATE_REFUND_DECLINE("SIMULATE_REFUND_DECLINE");

    private final String value;

    AdvancedCommerceRefundReason(String value) {
        this.value = value;
    }

    public static AdvancedCommerceRefundReason fromValue(String value) {
        for (AdvancedCommerceRefundReason b : AdvancedCommerceRefundReason.values()) {
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