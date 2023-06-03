// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A value that indicates whether the order ID in the request is valid for your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupstatus">OrderLookupStatus</a>
 */
@JsonAdapter(OrderLookupStatus.Adapter.class)
public enum OrderLookupStatus {

    VALID(0),
    INVALID(1);

    private final Integer value;

    OrderLookupStatus(Integer value) {
        this.value = value;
    }

    public static OrderLookupStatus fromValue(Integer value) {
        for (OrderLookupStatus b : OrderLookupStatus.values()) {
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

    public static class Adapter extends TypeAdapter<OrderLookupStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final OrderLookupStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public OrderLookupStatus read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return OrderLookupStatus.fromValue(value);
        }
    }
}

