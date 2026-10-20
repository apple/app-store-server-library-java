// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The code that represents the reason for the subscription-renewal-date extension.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
 **/
public enum ExtendReasonCode {

    /**
     * Undeclared; no information provided.
     **/
    UNDECLARED(0),
    /**
     * The renewal-date extension is for customer satisfaction.
     **/
    CUSTOMER_SATISFACTION(1),
    /**
     * The renewal-date extension is for other reasons.
     **/
    OTHER(2),
    /**
     * The renewal-date extension is due to a service issue or outage.
     **/
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
