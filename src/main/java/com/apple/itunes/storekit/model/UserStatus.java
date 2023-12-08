// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The status of a customer’s account within your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/userstatus">userStatus</a>
 */
public enum UserStatus {

    UNDECLARED(0),
    ACTIVE(1),
    SUSPENDED(2),
    TERMINATED(3),
    LIMITED_ACCESS(4);

    private final Integer value;

    UserStatus(Integer value) {
        this.value = value;
    }

    public static UserStatus fromValue(Integer value) {
        for (UserStatus b : UserStatus.values()) {
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

