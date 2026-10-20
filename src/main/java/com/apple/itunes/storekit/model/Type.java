// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of In-App Purchase products you can offer in your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/type">type</a>
 **/
public enum Type {

    /**
     * An auto-renewable subscription
     **/
    AUTO_RENEWABLE_SUBSCRIPTION("Auto-Renewable Subscription"),
    /**
     * A non-consumable In-App Purchase
     **/
    NON_CONSUMABLE("Non-Consumable"),
    /**
     * A consumable In-App Purchase
     **/
    CONSUMABLE("Consumable"),
    /**
     * A non-renewing subscription
     **/
    NON_RENEWING_SUBSCRIPTION("Non-Renewing Subscription");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public static Type fromValue(String value) {
        for (Type b : Type.values()) {
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
