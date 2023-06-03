// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The status of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/status">status</a>
 */
@JsonAdapter(Status.Adapter.class)
public enum Status {

    ACTIVE(1),
    EXPIRED(2),
    BILLING_RETRY(3),
    BILLING_GRACE_PERIOD(4),
    REVOKED(5);

    private final Integer value;

    Status(Integer value) {
        this.value = value;
    }

    public static Status fromValue(Integer value) {
        for (Status b : Status.values()) {
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

    public static class Adapter extends TypeAdapter<Status> {
        @Override
        public void write(final JsonWriter jsonWriter, final Status enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public Status read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return Status.fromValue(value);
        }
    }
}

