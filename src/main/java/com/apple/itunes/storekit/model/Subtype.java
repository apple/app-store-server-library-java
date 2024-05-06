// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A string that provides details about select notification types in version 2.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/subtype">subtype</a>
 */
public enum Subtype {

    INITIAL_BUY("INITIAL_BUY"),
    RESUBSCRIBE("RESUBSCRIBE"),
    DOWNGRADE("DOWNGRADE"),
    UPGRADE("UPGRADE"),
    AUTO_RENEW_ENABLED("AUTO_RENEW_ENABLED"),
    AUTO_RENEW_DISABLED("AUTO_RENEW_DISABLED"),
    VOLUNTARY("VOLUNTARY"),
    BILLING_RETRY("BILLING_RETRY"),
    PRICE_INCREASE("PRICE_INCREASE"),
    GRACE_PERIOD("GRACE_PERIOD"),
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    BILLING_RECOVERY("BILLING_RECOVERY"),
    PRODUCT_NOT_FOR_SALE("PRODUCT_NOT_FOR_SALE"),
    SUMMARY("SUMMARY"),
    FAILURE("FAILURE"),
    UNREPORTED("UNREPORTED");

    private final String value;

    Subtype(String value) {
        this.value = value;
    }

    public static Subtype fromValue(String value) {
        for (Subtype b : Subtype.values()) {
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

