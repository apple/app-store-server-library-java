// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The relationship of the user with the family-shared purchase to which they have access.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/inappownershiptype">inAppOwnershipType</a>
 */
public enum InAppOwnershipType {

    FAMILY_SHARED("FAMILY_SHARED"),
    PURCHASED("PURCHASED");

    private final String value;

    InAppOwnershipType(String value) {
        this.value = value;
    }

    public static InAppOwnershipType fromValue(String value) {
        for (InAppOwnershipType b : InAppOwnershipType.values()) {
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

