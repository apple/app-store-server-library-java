// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status that indicates whether an auto-renewable subscription is subject to a price increase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/priceincreasestatus">priceIncreaseStatus</a>
 **/
public enum PriceIncreaseStatus {

    /**
     * The customer hasn’t yet responded to an auto-renewable subscription price increase that requires customer consent.
     **/
    CUSTOMER_HAS_NOT_RESPONDED(0),
    /**
     * The customer consented to an auto-renewable subscription price increase that requires customer consent, or the App Store has notified the customer of an auto-renewable subscription price increase that doesn’t require consent.
     **/
    CUSTOMER_CONSENTED_OR_WAS_NOTIFIED_WITHOUT_NEEDING_CONSENT(1);

    private final Integer value;

    PriceIncreaseStatus(Integer value) {
        this.value = value;
    }

    public static PriceIncreaseStatus fromValue(Integer value) {
        for (PriceIncreaseStatus b : PriceIncreaseStatus.values()) {
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
