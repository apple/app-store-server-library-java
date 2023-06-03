// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A notification subtype value that App Store Server Notifications 2 uses.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationsubtype">notificationSubtype</a>
 */
@JsonAdapter(Subtype.Adapter.class)
public enum Subtype {

    INITIAL_BUY("INITIAL_BUY"),
    RESUBSCRIBE("RESUBSCRIBE"),
    DOWNGRADE("DOWNGRADE"),
    UPGRADE("UPGRADE"),
    AUTO_RENEW_ENABLED("AUTO_RENEW_ENABLED"),
    AUTO_RENEW_DISABLED("AUTO_RENEW_DISABLED"),
    VOLUNTARY("VOLUNTARY"),
    BILLING_RETRY("BILLING_RETRY"),
    PRICE_INCREASE("PRICE_INCREASE"),
    GRACE_PERIOD("GRACE_PERIOD"),
    PENDING("PENDING"),
    ACCEPTED("ACCEPTED"),
    BILLING_RECOVERY("BILLING_RECOVERY"),
    PRODUCT_NOT_FOR_SALE("PRODUCT_NOT_FOR_SALE"),
    SUMMARY("SUMMARY"),
    FAILURE("FAILURE");

    private final String value;

    Subtype(String value) {
        this.value = value;
    }

    public static Subtype fromValue(String value) {
        for (Subtype b : Subtype.values()) {
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

    public static class Adapter extends TypeAdapter<Subtype> {
        @Override
        public void write(final JsonWriter jsonWriter, final Subtype enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Subtype read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return Subtype.fromValue(value);
        }
    }
}

