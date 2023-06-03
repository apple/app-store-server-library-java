// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * An error or result that the App Store server receives when attempting to send an App Store server notification to your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/firstsendattemptresult">firstSendAttemptResult</a>
 */
@JsonAdapter(FirstSendAttemptResult.Adapter.class)
public enum FirstSendAttemptResult {

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

    FirstSendAttemptResult(String value) {
        this.value = value;
    }

    public static FirstSendAttemptResult fromValue(String value) {
        for (FirstSendAttemptResult b : FirstSendAttemptResult.values()) {
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

    public static class Adapter extends TypeAdapter<FirstSendAttemptResult> {
        @Override
        public void write(final JsonWriter jsonWriter, final FirstSendAttemptResult enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public FirstSendAttemptResult read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return FirstSendAttemptResult.fromValue(value);
        }
    }
}

