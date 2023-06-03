// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The reason an auto-renewable subscription expired.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/expirationintent">expirationIntent</a>
 */
@JsonAdapter(ExpirationIntent.Adapter.class)
public enum ExpirationIntent {

    CUSTOMER_CANCELLED(1),
    BILLING_ERROR(2),
    CUSTOMER_DID_NOT_CONSENT_TO_PRICE_INCREASE(3),
    PRODUCT_NOT_AVAILABLE(4),
    OTHER(5);

    private final Integer value;

    ExpirationIntent(Integer value) {
        this.value = value;
    }

    public static ExpirationIntent fromValue(Integer value) {
        for (ExpirationIntent b : ExpirationIntent.values()) {
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

    public static class Adapter extends TypeAdapter<ExpirationIntent> {
        @Override
        public void write(final JsonWriter jsonWriter, final ExpirationIntent enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public ExpirationIntent read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return ExpirationIntent.fromValue(value);
        }
    }
}

