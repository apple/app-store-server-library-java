// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The cause of a purchase transaction, which indicates whether it’s a customer’s purchase or a renewal for an auto-renewable subscription that the system initiates.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionreason">transactionReason</a>
 */
public enum TransactionReason {

    PURCHASE("PURCHASE"),
    RENEWAL("RENEWAL");

    private final String value;

    TransactionReason(String value) {
        this.value = value;
    }

    public static TransactionReason fromValue(String value) {
        for (TransactionReason b : TransactionReason.values()) {
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

