// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The reason for a refunded transaction.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationreason">revocationReason</a>
 **/
public enum RevocationReason {

    /**
     * The App Store refunded the transaction on behalf of the customer due to an actual or perceived issue within your app.
     **/
    REFUNDED_DUE_TO_ISSUE(1),
    /**
     * The App Store refunded the transaction on behalf of the customer for other reasons, for example, an accidental purchase.
     **/
    REFUNDED_FOR_OTHER_REASON(0);

    private final Integer value;

    RevocationReason(Integer value) {
        this.value = value;
    }

    public static RevocationReason fromValue(Integer value) {
        for (RevocationReason b : RevocationReason.values()) {
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
