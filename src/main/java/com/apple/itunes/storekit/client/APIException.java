// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

/**
 * Thrown when a non-2xx response is returned when calling the App Store Server API.
 * <p>
 * If an error code can be parsed from the response, an {@link APIError} is included, else only the HTTP status code.
 */
public class APIException extends Exception {
    private final int httpStatusCode;
    private final Long apiErrorCode;
    private final String apiErrorMessage;

    public APIException(int httpStatusCode, Exception cause) {
        super("Failed to call API with httpStatusCode=" + httpStatusCode, cause);
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = null;
        this.apiErrorMessage = null;
    }

    public APIException(int httpStatusCode) {
        super("Failed to call API with httpStatusCode=" + httpStatusCode);
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = null;
        this.apiErrorMessage = null;
    }

    public APIException(int httpStatusCode, APIError apiError, String apiErrorMessage) {
        super("Failed to call API with error=\"" + apiErrorMessage + "\"");
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = apiError != null ? apiError.errorCode() : null;
        this.apiErrorMessage = apiErrorMessage;
    }

    public APIException(int httpStatusCode, Long rawApiError, String apiErrorMessage) {
        super("Failed to call API with error=\"" + apiErrorMessage + "\"");
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = rawApiError;
        this.apiErrorMessage = apiErrorMessage;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public APIError getApiError() {
        return apiErrorCode != null ? APIError.fetchErrorResponseFromErrorCode(apiErrorCode) : null;
    }

    public Long getRawApiError() {
        return apiErrorCode;
    }

    public String getApiErrorMessage() {
        return apiErrorMessage;
    }

    @Override
    public String toString() {
        return "APIException{" +
                "httpStatusCode=" + httpStatusCode +
                ", apiError=" + apiErrorCode +
                ", apiErrorMessage='" + apiErrorMessage + '\'' +
                '}';
    }
}
