// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A string that describes the kind of multiseat purchase a customer’s access comes from.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/grouptype">groupType</a>
 **/
public enum GroupType {

    /**
     * An organization bought seats through Volume Purchasing and assigned one to the customer.
     **/
    ORGANIZATION("ORGANIZATION"),
    /**
     * A subscriber bought seats through Group Purchases and invited the customer to join.
     **/
    CONSUMER("CONSUMER");

    private final String value;

    GroupType(String value) {
        this.value = value;
    }

    public static GroupType fromValue(String value) {
        for (GroupType b : GroupType.values()) {
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
