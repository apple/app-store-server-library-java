// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The reason an auto-renewable subscription expired.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/expirationintent">expirationIntent</a>
 */
public enum ExpirationIntent {

    CUSTOMER_CANCELLED(1),
    BILLING_ERROR(2),
    CUSTOMER_DID_NOT_CONSENT_TO_PRICE_INCREASE(3),
    PRODUCT_NOT_AVAILABLE(4),
    OTHER(5);

    private final Integer value;

    ExpirationIntent(Integer value) {
        this.value = value;
    }

    public static ExpirationIntent fromValue(Integer value) {
        for (ExpirationIntent b : ExpirationIntent.values()) {
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

