// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of subscription offer.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offertype">offerType</a>
 */
public enum OfferType {

    INTRODUCTORY_OFFER(1),
    PROMOTIONAL_OFFER(2),
    SUBSCRIPTION_OFFER_CODE(3);

    private final Integer value;

    OfferType(Integer value) {
        this.value = value;
    }

    public static OfferType fromValue(Integer value) {
        for (OfferType b : OfferType.values()) {
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

