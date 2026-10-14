// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The success or error information the App Store server records when it attempts to send an App Store server notification to your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptresult">sendAttemptResult</a>
 **/
public enum SendAttemptResult {

    /**
     * The App Store server received a success response when it sent the notification to your server.
     **/
    SUCCESS("SUCCESS"),
    /**
     * The App Store server didn’t get a response from your server and timed out.
     **/
    TIMED_OUT("TIMED_OUT"),
    /**
     * The App Store server couldn’t establish a TLS session or validate your certificate.
     **/
    TLS_ISSUE("TLS_ISSUE"),
    /**
     * The App Store server detected a continual redirect.
     **/
    CIRCULAR_REDIRECT("CIRCULAR_REDIRECT"),
    /**
     * The App Store server didn’t receive a valid HTTP response from your server.
     **/
    NO_RESPONSE("NO_RESPONSE"),
    /**
     * A network error caused the notification attempt to fail.
     **/
    SOCKET_ISSUE("SOCKET_ISSUE"),
    /**
     * The App Store server doesn’t support the supplied charset.
     **/
    UNSUPPORTED_CHARSET("UNSUPPORTED_CHARSET"),
    /**
     * The App Store server received an invalid response from your server.
     **/
    INVALID_RESPONSE("INVALID_RESPONSE"),
    /**
     * The App Store server’s connection to your server was closed while the send was in progress.
     **/
    PREMATURE_CLOSE("PREMATURE_CLOSE"),
    /**
     * The App Store server didn’t receive an HTTP 200 response from your server.
     **/
    UNSUCCESSFUL_HTTP_RESPONSE_CODE("UNSUCCESSFUL_HTTP_RESPONSE_CODE"),
    /**
     * Another error occurred that prevented your server from receiving the notification.
     **/
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
        return String.valueOf(value);
    }
}
