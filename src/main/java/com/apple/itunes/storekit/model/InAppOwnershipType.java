// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The relationship of the user with the family-shared purchase to which they have access.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/inappownershiptype">inAppOwnershipType</a>
 */
@JsonAdapter(InAppOwnershipType.Adapter.class)
public enum InAppOwnershipType {

    FAMILY_SHARED("FAMILY_SHARED"),
    PURCHASED("PURCHASED");

    private final String value;

    InAppOwnershipType(String value) {
        this.value = value;
    }

    public static InAppOwnershipType fromValue(String value) {
        for (InAppOwnershipType b : InAppOwnershipType.values()) {
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

    public static class Adapter extends TypeAdapter<InAppOwnershipType> {
        @Override
        public void write(final JsonWriter jsonWriter, final InAppOwnershipType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public InAppOwnershipType read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return InAppOwnershipType.fromValue(value);
        }
    }
}

