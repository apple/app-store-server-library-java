// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A value that indicates whether the app successfully delivered an in-app purchase that works properly.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
 */
@JsonAdapter(DeliveryStatus.Adapter.class)
public enum DeliveryStatus {

    DELIVERED_AND_WORKING_PROPERLY(0),
    DID_NOT_DELIVER_DUE_TO_QUALITY_ISSUE(1),
    DELIVERED_WRONG_ITEM(2),
    DID_NOT_DELIVER_DUE_TO_SERVER_OUTAGE(3),
    DID_NOT_DELIVER_DUE_TO_IN_GAME_CURRENCY_CHANGE(4),
    DID_NOT_DELIVER_FOR_OTHER_REASON(5);

    private final Integer value;

    DeliveryStatus(Integer value) {
        this.value = value;
    }

    public static DeliveryStatus fromValue(Integer value) {
        for (DeliveryStatus b : DeliveryStatus.values()) {
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

    public static class Adapter extends TypeAdapter<DeliveryStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final DeliveryStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public DeliveryStatus read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return DeliveryStatus.fromValue(value);
        }
    }
}

