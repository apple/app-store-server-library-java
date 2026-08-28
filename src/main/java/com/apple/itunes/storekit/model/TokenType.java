// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of an external purchase custom link token.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/tokentype">tokenType</a>
 */
public enum TokenType {

    SERVICES("SERVICES"),
    ACQUISITION("ACQUISITION");

    private final String value;

    TokenType(String value) {
        this.value = value;
    }

    public static TokenType fromValue(String value) {
        for (TokenType b : TokenType.values()) {
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
