// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The status that indicates whether an auto-renewable subscription is subject to a price increase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/priceincreasestatus">priceIncreaseStatus</a>
 */
@JsonAdapter(PriceIncreaseStatus.Adapter.class)
public enum PriceIncreaseStatus {

    CUSTOMER_HAS_NOT_RESPONDED(0),
    CUSTOMER_CONSENTED_OR_WAS_NOTIFIED_WITHOUT_NEEDING_CONSENT(1);

    private final Integer value;

    PriceIncreaseStatus(Integer value) {
        this.value = value;
    }

    public static PriceIncreaseStatus fromValue(Integer value) {
        for (PriceIncreaseStatus b : PriceIncreaseStatus.values()) {
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

    public static class Adapter extends TypeAdapter<PriceIncreaseStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final PriceIncreaseStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public PriceIncreaseStatus read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return PriceIncreaseStatus.fromValue(value);
        }
    }
}

