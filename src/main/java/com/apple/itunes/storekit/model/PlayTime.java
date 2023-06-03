// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A value that indicates the amount of time that the customer used the app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/playtime">playTime</a>
 */
@JsonAdapter(PlayTime.Adapter.class)
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
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Adapter extends TypeAdapter<PlayTime> {
        @Override
        public void write(final JsonWriter jsonWriter, final PlayTime enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public PlayTime read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return PlayTime.fromValue(value);
        }
    }
}

