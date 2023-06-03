// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The renewal status for an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/autorenewstatus">autoRenewStatus</a>
 */
@JsonAdapter(AutoRenewStatus.Adapter.class)
public enum AutoRenewStatus {

    OFF(0),
    ON(1);

    private final Integer value;

    AutoRenewStatus(Integer value) {
        this.value = value;
    }

    public static AutoRenewStatus fromValue(Integer value) {
        for (AutoRenewStatus b : AutoRenewStatus.values()) {
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

    public static class Adapter extends TypeAdapter<AutoRenewStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final AutoRenewStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public AutoRenewStatus read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return AutoRenewStatus.fromValue(value);
        }
    }
}

