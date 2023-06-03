// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The cause of a purchase transaction, which indicates whether it’s a customer’s purchase or a renewal for an auto-renewable subscription that the system initiates.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionreason">transactionReason</a>
 */
@JsonAdapter(Type.Adapter.class)
public enum TransactionReason {

    PURCHASE("PURCHASE"),
    RENEWAL("RENEWAL");

    private final String value;

    TransactionReason(String value) {
        this.value = value;
    }

    public static TransactionReason fromValue(String value) {
        for (TransactionReason b : TransactionReason.values()) {
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

    public static class Adapter extends TypeAdapter<TransactionReason> {
        @Override
        public void write(final JsonWriter jsonWriter, final TransactionReason enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public TransactionReason read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return TransactionReason.fromValue(value);
        }
    }
}

