// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates your preferred outcome for the refund request.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreferencev1">refundPreferenceV1</a>
 * @deprecated Use {@link RefundPreference} instead.
 **/
@Deprecated
public enum RefundPreferenceV1 {

    /**
     * The refund preference is undeclared.
     **/
    UNDECLARED(0),
    /**
     * You prefer that the App Store grants the refund.
     **/
    PREFER_GRANT(1),
    /**
     * You prefer that the App Store declines the refund.
     **/
    PREFER_DECLINE(2),
    /**
     * You have no preference whether the App Store grants or declines the refund.
     **/
    NO_PREFERENCE(3);

    private final Integer value;

    RefundPreferenceV1(Integer value) {
        this.value = value;
    }

    public static RefundPreferenceV1 fromValue(Integer value) {
        for (RefundPreferenceV1 b : RefundPreferenceV1.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return null;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
