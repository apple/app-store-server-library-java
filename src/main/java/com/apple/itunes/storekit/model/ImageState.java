// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The approval state of an image.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imagestate">imageState</a>
 */
public enum ImageState {

    PENDING("PENDING"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String value;

    ImageState(String value) {
        this.value = value;
    }

    public static ImageState fromValue(String value) {
        for (ImageState b : ImageState.values()) {
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

