// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of an external purchase custom link token.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/tokentype">tokenType</a>
 **/
public enum TokenType {

    /**
     * A token type that indicates an initial acquisition.
     **/
    ACQUISITION("ACQUISITION"),
    /**
     * A token type that indicates usage of App Store services.
     **/
    SERVICES("SERVICES"),
    /**
     * A token type an app receives from the MarketplaceKit token(for:) API.
     **/
    CORE_TECHNOLOGY("CORE_TECHNOLOGY");

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
