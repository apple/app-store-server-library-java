// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The approval state of the message.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messagestate">messageState</a>
 */
public enum MessageState {

    PENDING("PENDING"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String value;

    MessageState(String value) {
        this.value = value;
    }

    public static MessageState fromValue(String value) {
        for (MessageState b : MessageState.values()) {
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

