// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A value that indicates the dollar amount of refunds the customer has received in your app, since purchasing the app, across all platforms.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarsrefunded">lifetimeDollarsRefunded</a>
 */
@JsonAdapter(LifetimeDollarsRefunded.Adapter.class)
public enum LifetimeDollarsRefunded {

    UNDECLARED(0),
    ZERO_DOLLARS(1),
    ONE_CENT_TO_FORTY_NINE_DOLLARS_AND_NINETY_NINE_CENTS(2),
    FIFTY_DOLLARS_TO_NINETY_NINE_DOLLARS_AND_NINETY_NINE_CENTS(3),
    ONE_HUNDRED_DOLLARS_TO_FOUR_HUNDRED_NINETY_NINE_DOLLARS_AND_NINETY_NINE_CENTS(4),
    FIVE_HUNDRED_DOLLARS_TO_NINE_HUNDRED_NINETY_NINE_DOLLARS_AND_NINETY_NINE_CENTS(5),
    ONE_THOUSAND_DOLLARS_TO_ONE_THOUSAND_NINE_HUNDRED_NINETY_NINE_DOLLARS_AND_NINETY_NINE_CENTS(6),
    TWO_THOUSAND_DOLLARS_OR_GREATER(7);

    private final Integer value;

    LifetimeDollarsRefunded(Integer value) {
        this.value = value;
    }

    public static LifetimeDollarsRefunded fromValue(Integer value) {
        for (LifetimeDollarsRefunded b : LifetimeDollarsRefunded.values()) {
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

    public static class Adapter extends TypeAdapter<LifetimeDollarsRefunded> {
        @Override
        public void write(final JsonWriter jsonWriter, final LifetimeDollarsRefunded enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public LifetimeDollarsRefunded read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return LifetimeDollarsRefunded.fromValue(value);
        }
    }
}

