// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The success or error information the App Store server records when it attempts to send an App Store server notification to your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptresult">sendAttemptResult</a>
 */
@JsonAdapter(SendAttemptResult.Adapter.class)
public enum SendAttemptResult {

    SUCCESS("SUCCESS"),
    TIMED_OUT("TIMED_OUT"),
    TLS_ISSUE("TLS_ISSUE"),
    CIRCULAR_REDIRECT("CIRCULAR_REDIRECT"),
    NO_RESPONSE("NO_RESPONSE"),
    SOCKET_ISSUE("SOCKET_ISSUE"),
    UNSUPPORTED_CHARSET("UNSUPPORTED_CHARSET"),
    INVALID_RESPONSE("INVALID_RESPONSE"),
    PREMATURE_CLOSE("PREMATURE_CLOSE"),
    UNSUCCESSFUL_HTTP_RESPONSE_CODE("UNSUCCESSFUL_HTTP_RESPONSE_CODE"),
    OTHER("OTHER");

    private final String value;

    SendAttemptResult(String value) {
        this.value = value;
    }

    public static SendAttemptResult fromValue(String value) {
        for (SendAttemptResult b : SendAttemptResult.values()) {
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
        return value;
    }

    public static class Adapter extends TypeAdapter<SendAttemptResult> {
        @Override
        public void write(final JsonWriter jsonWriter, final SendAttemptResult enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public SendAttemptResult read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return SendAttemptResult.fromValue(value);
        }
    }
}

