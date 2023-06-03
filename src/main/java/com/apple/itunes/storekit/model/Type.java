// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type of in-app purchase products you can offer in your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/type">type</a>
 */
@JsonAdapter(Type.Adapter.class)
public enum Type {

    AUTO_RENEWABLE_SUBSCRIPTION("Auto-Renewable Subscription"),
    NON_CONSUMABLE("Non-Consumable"),
    CONSUMABLE("Consumable"),
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
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Adapter extends TypeAdapter<Type> {
        @Override
        public void write(final JsonWriter jsonWriter, final Type enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Type read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return Type.fromValue(value);
        }
    }
}

