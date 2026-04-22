// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The reason for the offer.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
 */
public enum AdvancedCommerceOfferReason {

    ACQUISITION("ACQUISITION"),
    WIN_BACK("WIN_BACK"),
    RETENTION("RETENTION");

    private final String value;

    AdvancedCommerceOfferReason(String value) {
        this.value = value;
    }

    public static AdvancedCommerceOfferReason fromValue(String value) {
        for (AdvancedCommerceOfferReason b : AdvancedCommerceOfferReason.values()) {
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