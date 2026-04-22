// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The response body that contains the URL for your Get Retention Message endpoint.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimeurlresponse">RealtimeUrlResponse</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RealtimeUrlResponse {
    private static final String SERIALIZED_NAME_REALTIME_URL = "realtimeURL";
    @JsonProperty(SERIALIZED_NAME_REALTIME_URL)
    private String realtimeURL;

    private static final int MAXIMUM_REALTIME_URL_LENGTH = 256;

    private RealtimeUrlResponse() {
    }

    public RealtimeUrlResponse(String realtimeURL) {
        this.realtimeURL = validateRealtimeUrl(realtimeURL);
    }

    public RealtimeUrlResponse realtimeURL(String realtimeURL) {
        this.realtimeURL = validateRealtimeUrl(realtimeURL);
        return this;
    }

    /**
     * A string that contains the URL you provided for your Get Retention Message endpoint.
     *
     * @return realtimeURL
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimeurl">realtimeURL</a>
     **/
    public String getRealtimeURL() {
        return realtimeURL;
    }

    public void setRealtimeURL(String realtimeURL) {
        this.realtimeURL = validateRealtimeUrl(realtimeURL);
    }

    private String validateRealtimeUrl(String realtimeURL) {
        Objects.requireNonNull(realtimeURL);
        if (realtimeURL.length() > MAXIMUM_REALTIME_URL_LENGTH) {
            throw new IllegalArgumentException("realtimeURL length longer than maximum allowed");
        }
        return realtimeURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealtimeUrlResponse realtimeUrlRequest = (RealtimeUrlResponse) o;
        return Objects.equals(this.realtimeURL, realtimeUrlRequest.realtimeURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realtimeURL);
    }

    @Override
    public String toString() {
        return "RealtimeUrlResponse{" +
                "realtimeURL=" + realtimeURL +
                '}';
    }
}

