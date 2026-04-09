// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The size of an image.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imagesize">imageSize</a>
 */
public enum ImageSize {

    FULL_SIZE("FULL_SIZE"),
    BULLET_POINT("BULLET_POINT");

    private final String value;

    ImageSize(String value) {
        this.value = value;
    }

    public static ImageSize fromValue(String value) {
        for (ImageSize b : ImageSize.values()) {
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

