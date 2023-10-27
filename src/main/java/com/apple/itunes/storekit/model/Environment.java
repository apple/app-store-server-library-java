// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The server environment, either sandbox or production.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
 */
@JsonAdapter(Environment.Adapter.class)
public enum Environment {

    SANDBOX("Sandbox"),
    PRODUCTION("Production"),
    XCODE("Xcode"),
    LOCAL_TESTING("LocalTesting");

    private final String value;

    Environment(String value) {
        this.value = value;
    }

    public static Environment fromValue(String value) {
        for (Environment b : Environment.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Adapter extends TypeAdapter<Environment> {
        @Override
        public void write(final JsonWriter jsonWriter, final Environment enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Environment read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return Environment.fromValue(value);
        }
    }
}

