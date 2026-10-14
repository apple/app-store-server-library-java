// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A string that describes the store the customer obtained the app from.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/storetype">storeType</a>
 **/
public enum StoreType {

    /**
     * The customer obtained the app from the App Store.
     **/
    CONSUMER("CONSUMER");

    private final String value;

    StoreType(String value) {
        this.value = value;
    }

    public static StoreType fromValue(String value) {
        for (StoreType b : StoreType.values()) {
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
