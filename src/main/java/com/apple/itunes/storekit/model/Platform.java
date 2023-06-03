// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The platform on which the customer consumed the in-app purchase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/platform">platform</a>
 */
@JsonAdapter(Platform.Adapter.class)
public enum Platform {

    UNDECLARED(0),
    APPLE(1),
    NON_APPLE(2);

    private final Integer value;

    Platform(Integer value) {
        this.value = value;
    }

    public static Platform fromValue(Integer value) {
        for (Platform b : Platform.values()) {
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

    public static class Adapter extends TypeAdapter<Platform> {
        @Override
        public void write(final JsonWriter jsonWriter, final Platform enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Platform read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return Platform.fromValue(value);
        }
    }
}

