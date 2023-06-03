// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type of subscription offer.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offertype">offerType</a>
 */
@JsonAdapter(OfferType.Adapter.class)
public enum OfferType {

    INTRODUCTORY_OFFER(1),
    PROMOTIONAL_OFFER(2),
    SUBSCRIPTION_OFFER_CODE(3);

    private final Integer value;

    OfferType(Integer value) {
        this.value = value;
    }

    public static OfferType fromValue(Integer value) {
        for (OfferType b : OfferType.values()) {
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

    public static class Adapter extends TypeAdapter<OfferType> {
        @Override
        public void write(final JsonWriter jsonWriter, final OfferType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public OfferType read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return OfferType.fromValue(value);
        }
    }
}

