// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The reason for a refunded transaction.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationreason">revocationReason</a>
 */
@JsonAdapter(RevocationReason.Adapter.class)
public enum RevocationReason {

    REFUNDED_DUE_TO_ISSUE(1),
    REFUNDED_FOR_OTHER_REASON(0);

    private final Integer value;

    RevocationReason(Integer value) {
        this.value = value;
    }

    public static RevocationReason fromValue(Integer value) {
        for (RevocationReason b : RevocationReason.values()) {
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

    public static class Adapter extends TypeAdapter<RevocationReason> {
        @Override
        public void write(final JsonWriter jsonWriter, final RevocationReason enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public RevocationReason read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return RevocationReason.fromValue(value);
        }
    }
}

