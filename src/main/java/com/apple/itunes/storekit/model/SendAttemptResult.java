// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The success or error information the App Store server records when it attempts to send an App Store server notification to your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptresult">sendAttemptResult</a>
 */
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
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

