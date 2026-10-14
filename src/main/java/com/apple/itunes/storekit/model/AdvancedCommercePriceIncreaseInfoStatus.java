// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercepriceincreaseinfostatus">advancedCommercePriceIncreaseInfoStatus</a>
 **/
public enum AdvancedCommercePriceIncreaseInfoStatus {

    SCHEDULED("SCHEDULED"),
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED");

    private final String value;

    AdvancedCommercePriceIncreaseInfoStatus(String value) {
        this.value = value;
    }

    public static AdvancedCommercePriceIncreaseInfoStatus fromValue(String value) {
        for (AdvancedCommercePriceIncreaseInfoStatus b : AdvancedCommercePriceIncreaseInfoStatus.values()) {
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
