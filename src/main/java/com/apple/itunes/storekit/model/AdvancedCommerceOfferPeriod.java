// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The period of the offer.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
 */
public enum AdvancedCommerceOfferPeriod {

    P3D("P3D"),
    P1W("P1W"),
    P2W("P2W"),
    P1M("P1M"),
    P2M("P2M"),
    P3M("P3M"),
    P6M("P6M"),
    P9M("P9M"),
    P1Y("P1Y");

    private final String value;

    AdvancedCommerceOfferPeriod(String value) {
        this.value = value;
    }

    public static AdvancedCommerceOfferPeriod fromValue(String value) {
        for (AdvancedCommerceOfferPeriod b : AdvancedCommerceOfferPeriod.values()) {
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