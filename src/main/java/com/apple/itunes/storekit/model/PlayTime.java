// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A value that indicates the amount of time that the customer used the app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/playtime">playTime</a>
 */
public enum PlayTime {

    UNDECLARED(0),
    ZERO_TO_FIVE_MINUTES(1),
    FIVE_TO_SIXTY_MINUTES(2),
    ONE_TO_SIX_HOURS(3),
    SIX_HOURS_TO_TWENTY_FOUR_HOURS(4),
    ONE_DAY_TO_FOUR_DAYS(5),
    FOUR_DAYS_TO_SIXTEEN_DAYS(6),
    OVER_SIXTEEN_DAYS(7);

    private final Integer value;

    PlayTime(Integer value) {
        this.value = value;
    }

    public static PlayTime fromValue(Integer value) {
        for (PlayTime b : PlayTime.values()) {
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

