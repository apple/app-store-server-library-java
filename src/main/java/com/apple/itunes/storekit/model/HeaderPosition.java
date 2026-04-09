// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The position where the header text appears in a message.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/headerposition">headerPosition</a>
 */
public enum HeaderPosition {

    ABOVE_BODY("ABOVE_BODY"),
    ABOVE_IMAGE("ABOVE_IMAGE");

    private final String value;

    HeaderPosition(String value) {
        this.value = value;
    }

    public static HeaderPosition fromValue(String value) {
        for (HeaderPosition b : HeaderPosition.values()) {
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

