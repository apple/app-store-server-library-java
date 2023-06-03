// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The code that represents the reason for the subscription-renewal-date extension.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
 */
@JsonAdapter(ExtendReasonCode.Adapter.class)
public enum ExtendReasonCode {

    UNDECLARED(0),
    CUSTOMER_SATISFACTION(1),
    OTHER(2),
    SERVICE_ISSUE_OR_OUTAGE(3);

    private final Integer value;

    ExtendReasonCode(Integer value) {
        this.value = value;
    }

    public static ExtendReasonCode fromValue(Integer value) {
        for (ExtendReasonCode b : ExtendReasonCode.values()) {
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

    public static class Adapter extends TypeAdapter<ExtendReasonCode> {
        @Override
        public void write(final JsonWriter jsonWriter, final ExtendReasonCode enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public ExtendReasonCode read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return ExtendReasonCode.fromValue(value);
        }
    }
}

