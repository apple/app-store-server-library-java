// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The payment mode you configure for an introductory offer, promotional offer, or offer code on an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offerdiscounttype">offerDiscountType</a>
 */
public enum OfferDiscountType {

    FREE_TRIAL("FREE_TRIAL"),
    PAY_AS_YOU_GO("PAY_AS_YOU_GO"),
    PAY_UP_FRONT("PAY_UP_FRONT");

    private final String value;

    OfferDiscountType(String value) {
        this.value = value;
    }

    public static OfferDiscountType fromValue(String value) {
        for (OfferDiscountType b : OfferDiscountType.values()) {
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