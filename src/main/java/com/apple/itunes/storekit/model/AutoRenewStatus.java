// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The renewal status for an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/autorenewstatus">autoRenewStatus</a>
 */
public enum AutoRenewStatus {

    OFF(0),
    ON(1);

    private final Integer value;

    AutoRenewStatus(Integer value) {
        this.value = value;
    }

    public static AutoRenewStatus fromValue(Integer value) {
        for (AutoRenewStatus b : AutoRenewStatus.values()) {
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

