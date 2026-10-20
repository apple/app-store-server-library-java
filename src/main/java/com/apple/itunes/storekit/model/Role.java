// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A string that identifies a customer’s role for a product within a group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/role">role</a>
 **/
public enum Role {

    /**
     * The customer has a seat in the group but doesn’t administer it.
     **/
    NONE("NONE"),
    /**
     * The customer administers the group for the product.
     **/
    ADMIN("ADMIN");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static Role fromValue(String value) {
        for (Role b : Role.values()) {
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
