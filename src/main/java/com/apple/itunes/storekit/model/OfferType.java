// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of offer.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offertype">offerType</a>
 **/
public enum OfferType {

    /**
     * An introductory offer.
     **/
    INTRODUCTORY_OFFER(1),
    /**
     * A promotional offer.
     **/
    PROMOTIONAL_OFFER(2),
    /**
     * An offer with an offer code.
     **/
    OFFER_CODE(3),
    /**
     * A win-back offer.
     **/
    WIN_BACK_OFFER(4);

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
