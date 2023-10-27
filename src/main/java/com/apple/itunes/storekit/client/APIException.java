// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

/**
 * Thrown when a non-2xx response is returned when calling the App Store Server API.
 * <p>
 * If an error code can be parsed from the response, an {@link APIError} is included, else only the HTTP status code.
 */
public class APIException extends Exception {
    private final int httpStatusCode;
    private final Long apiError;

    public APIException(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        this.apiError = null;
    }

    public APIException(int httpStatusCode, APIError apiError) {
        this.httpStatusCode = httpStatusCode;
        this.apiError = apiError != null ? apiError.errorCode() : null;
    }

    public APIException(int httpStatusCode, Long rawApiError) {
        this.httpStatusCode = httpStatusCode;
        this.apiError = rawApiError;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public APIError getApiError() {
        return apiError != null ? APIError.fetchErrorResponseFromErrorCode(apiError) : null;
    }

    public Long getRawApiError() {
        return apiError;
    }

    @Override
    public String toString() {
        return "APIException{" +
                "httpStatusCode=" + httpStatusCode +
                ", apiError=" + apiError +
                "} " + super.toString();
    }
}
