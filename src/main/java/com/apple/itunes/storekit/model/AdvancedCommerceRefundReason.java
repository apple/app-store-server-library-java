// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A reason to request a refund.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundreason">refundReason</a>
 **/
public enum AdvancedCommerceRefundReason {

    /**
     * The customer didn’t intend to make the Apple In-App Purchase.
     **/
    UNINTENDED_PURCHASE("UNINTENDED_PURCHASE"),
    /**
     * The customer had issues with receiving or using the Apple In-App Purchase.
     **/
    FULFILLMENT_ISSUE("FULFILLMENT_ISSUE"),
    /**
     * The customer wasn’t satisfied with the Apple In-App Purchase.
     **/
    UNSATISFIED_WITH_PURCHASE("UNSATISFIED_WITH_PURCHASE"),
    /**
     * The customer requested a refund based on a legal reason.
     **/
    LEGAL("LEGAL"),
    /**
     * The customer requested a refund for other reasons.
     **/
    OTHER("OTHER"),
    /**
     * The customer modified one or more items in the subscription, which results in a refund.
     **/
    MODIFY_ITEMS_REFUND("MODIFY_ITEMS_REFUND"),
    /**
     * For testing purposes only, a simulation of a refund that the App Store declines.
     **/
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
