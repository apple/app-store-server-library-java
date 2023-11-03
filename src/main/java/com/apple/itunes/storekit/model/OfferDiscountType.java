// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The payment mode you configure for an introductory offer, promotional offer, or offer code on an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offerdiscounttype">offerDiscountType</a>
 */
@JsonAdapter(OfferDiscountType.Adapter.class)
public enum OfferDiscountType {

    FREE_TRIAL("FREE_TRIAL"),
    PAY_AS_YOU_GO("PAY_AS_YOU_GO"),
    PAY_UP_FRONT("PAY_UP_FRONT");

    private final String value;

    OfferDiscountType(String value) {
        this.value = value;
    }

    public static OfferDiscountType fromValue(String value) {
        for (OfferDiscountType b : OfferDiscountType.values()) {
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

    public static class Adapter extends TypeAdapter<OfferDiscountType> {
        @Override
        public void write(final JsonWriter jsonWriter, final OfferDiscountType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public OfferDiscountType read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return OfferDiscountType.fromValue(value);
        }
    }
}