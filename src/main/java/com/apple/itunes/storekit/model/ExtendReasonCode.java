// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The code that represents the reason for the subscription-renewal-date extension.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
 */
public enum ExtendReasonCode {

    UNDECLARED(0),
    CUSTOMER_SATISFACTION(1),
    OTHER(2),
    SERVICE_ISSUE_OR_OUTAGE(3);

    private final Integer value;

    ExtendReasonCode(Integer value) {
        this.value = value;
    }

    public static ExtendReasonCode fromValue(Integer value) {
        for (ExtendReasonCode b : ExtendReasonCode.values()) {
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

