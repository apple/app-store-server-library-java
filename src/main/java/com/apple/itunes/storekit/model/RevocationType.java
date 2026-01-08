// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of the refund or revocation that applies to the transaction.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/revocationtype">revocationType</a>
 */
public enum RevocationType {

    REFUND_FULL("REFUND_FULL"),
    REFUND_PRORATED("REFUND_PRORATED"),
    FAMILY_REVOKE("FAMILY_REVOKE");

    private final String value;

    RevocationType(String value) {
        this.value = value;
    }

    public static RevocationType fromValue(String value) {
        for (RevocationType b : RevocationType.values()) {
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