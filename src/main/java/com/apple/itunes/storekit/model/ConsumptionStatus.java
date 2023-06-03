// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A value that indicates the extent to which the customer consumed the in-app purchase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionstatus">consumptionStatus</a>
 */
@JsonAdapter(ConsumptionStatus.Adapter.class)
public enum ConsumptionStatus {

    UNDECLARED(0),
    NOT_CONSUMED(1),
    PARTIALLY_CONSUMED(2),
    FULLY_CONSUMED(3);

    private final Integer value;

    ConsumptionStatus(Integer value) {
        this.value = value;
    }

    public static ConsumptionStatus fromValue(Integer value) {
        for (ConsumptionStatus b : ConsumptionStatus.values()) {
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

    public static class Adapter extends TypeAdapter<ConsumptionStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final ConsumptionStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public ConsumptionStatus read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return ConsumptionStatus.fromValue(value);
        }
    }
}

