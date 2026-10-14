// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A string that describes whether the transaction was purchased by the customer, or is available to them through Family Sharing, an organization, or a group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/inappownershiptype">inAppOwnershipType</a>
 **/
public enum InAppOwnershipType {

    /**
     * The transaction belongs to a family member who benefits from service.
     **/
    FAMILY_SHARED("FAMILY_SHARED"),
    /**
     * The transaction belongs to the purchaser.
     **/
    PURCHASED("PURCHASED"),
    /**
     * The transaction belongs to a customer who has access through an organization or group.
     **/
    ASSIGNED("ASSIGNED");

    private final String value;

    InAppOwnershipType(String value) {
        this.value = value;
    }

    public static InAppOwnershipType fromValue(String value) {
        for (InAppOwnershipType b : InAppOwnershipType.values()) {
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
