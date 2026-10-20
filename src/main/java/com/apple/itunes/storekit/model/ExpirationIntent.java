// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The reason an auto-renewable subscription expired.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/expirationintent">expirationIntent</a>
 **/
public enum ExpirationIntent {

    /**
     * The customer canceled their subscription.
     **/
    CUSTOMER_CANCELLED(1),
    /**
     * Billing error; for example, the customer’s payment information is no longer valid.
     **/
    BILLING_ERROR(2),
    /**
     * The customer didn’t consent to an auto-renewable subscription price increase that requires their consent, or to a subscription offer conversion that requires their consent, so the subscription expired.
     **/
    CUSTOMER_DID_NOT_CONSENT_TO_PRICE_INCREASE(3),
    /**
     * The product wasn’t available for purchase at the time of renewal.
     **/
    PRODUCT_NOT_AVAILABLE(4),
    /**
     * The subscription expired for some other reason.
     **/
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
