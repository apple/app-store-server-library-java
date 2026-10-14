// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The platform on which a customer originally purchases an app.
 *
 * @see <a href="https://developer.apple.com/documentation/storekit/appstore/platform">AppStore.Platform</a>
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originalplatform">originalPlatform</a>
 **/
public enum PurchasePlatform {

    MAC_OS("macOS"),
    IOS("iOS"),
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
