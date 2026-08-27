// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Thrown when a non-2xx response is returned when calling the App Store Server API.
 * <p>
 * If an error code can be parsed from the response, an {@link APIError} is included, else only the HTTP status code.
 */
public class APIException extends Exception {
    private static final Pattern RETRY_AFTER_PATTERN = Pattern.compile("[0-9]+");

    private final int httpStatusCode;
    private final Long apiErrorCode;
    private final String apiErrorMessage;
    private final Map<String, List<String>> headers;
    private final Long retryAfter;

    public APIException(int httpStatusCode, Exception cause) {
        this(httpStatusCode, cause, Map.of());
    }

    public APIException(int httpStatusCode, Exception cause, Map<String, List<String>> headers) {
        super("Failed to call API with httpStatusCode=" + httpStatusCode, cause);
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = null;
        this.apiErrorMessage = null;
        this.headers = Map.copyOf(headers);
        this.retryAfter = parseRetryAfter(this.headers);
    }

    public APIException(int httpStatusCode) {
        this(httpStatusCode, Map.of());
    }

    public APIException(int httpStatusCode, Map<String, List<String>> headers) {
        super("Failed to call API with httpStatusCode=" + httpStatusCode);
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = null;
        this.apiErrorMessage = null;
        this.headers = Map.copyOf(headers);
        this.retryAfter = parseRetryAfter(this.headers);
    }

    public APIException(int httpStatusCode, APIError apiError, String apiErrorMessage) {
        this(httpStatusCode, apiError, apiErrorMessage, Map.of());
    }

    public APIException(int httpStatusCode, APIError apiError, String apiErrorMessage, Map<String, List<String>> headers) {
        this(httpStatusCode, apiError != null ? apiError.errorCode() : null, apiErrorMessage, headers);
    }

    public APIException(int httpStatusCode, Long rawApiError, String apiErrorMessage) {
        this(httpStatusCode, rawApiError, apiErrorMessage, Map.of());
    }

    public APIException(int httpStatusCode, Long rawApiError, String apiErrorMessage, Map<String, List<String>> headers) {
        super("Failed to call API with error=\"" + apiErrorMessage + "\"");
        this.httpStatusCode = httpStatusCode;
        this.apiErrorCode = rawApiError;
        this.apiErrorMessage = apiErrorMessage;
        this.headers = Map.copyOf(headers);
        this.retryAfter = parseRetryAfter(this.headers);
    }

    private static Long parseRetryAfter(Map<String, List<String>> headers) {
        List<String> retryAfterValues = headers.get("retry-after");
        if (retryAfterValues == null || retryAfterValues.isEmpty()) {
            return null;
        }
        String rawRetryAfter = retryAfterValues.get(0);
        if (rawRetryAfter == null) {
            return null;
        }
        String trimmedRetryAfter = rawRetryAfter.trim();
        if (!RETRY_AFTER_PATTERN.matcher(trimmedRetryAfter).matches()) {
            return null;
        }
        try {
            return Long.parseLong(trimmedRetryAfter);
        } catch (NumberFormatException e) {
            return null;
        }
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

    /**
     * @return The headers of the response, keyed by lowercased header name
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    /**
     * A UNIX time, in milliseconds, that informs you when you can next send a request.
     *
     * @return The time you can next send a request, or null if the response did not include the header
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/identifying-rate-limits">Identifying rate limits</a>
     */
    public Long getRetryAfter() {
        return retryAfter;
    }

    @Override
    public String toString() {
        return "APIException{" +
                "httpStatusCode=" + httpStatusCode +
                ", apiError=" + apiErrorCode +
                ", apiErrorMessage='" + apiErrorMessage + '\'' +
                ", retryAfter=" + retryAfter +
                '}';
    }
}
