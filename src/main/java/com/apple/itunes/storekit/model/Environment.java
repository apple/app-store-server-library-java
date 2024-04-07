// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The server environment, either sandbox or production.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
 */
public enum Environment {

    SANDBOX("Sandbox"),
    PRODUCTION("Production"),
    XCODE("Xcode"),
    // Used for unit testing
    LOCAL_TESTING("LocalTesting");

    private final String value;

    Environment(String value) {
        this.value = value;
    }

    public static Environment fromValue(String value) {
        for (Environment b : Environment.values()) {
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

