// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Values that represent Apple platforms.
 *
 * @see <a href="https://developer.apple.com/documentation/storekit/appstore/platform">AppStore.Platform</a>
 */
public enum PurchasePlatform {

    IOS("iOS"),
    MAC_OS("macOS"),
    TV_OS("tvOS"),
    VISION_OS("visionOS");

    private final String value;

    PurchasePlatform(String value) {
        this.value = value;
    }

    public static PurchasePlatform fromValue(String value) {
        for (PurchasePlatform b : PurchasePlatform.values()) {
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

