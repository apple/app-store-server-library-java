// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The platform on which the customer consumed the in-app purchase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/platform">platform</a>
 */
public enum Platform {

    UNDECLARED(0),
    APPLE(1),
    NON_APPLE(2);

    private final Integer value;

    Platform(Integer value) {
        this.value = value;
    }

    public static Platform fromValue(Integer value) {
        for (Platform b : Platform.values()) {
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

