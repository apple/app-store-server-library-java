// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The response body that contains the URL for your Get Retention Message endpoint.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimeurlresponse">RealtimeUrlResponse</a>
 **/
public class RealtimeUrlResponse {
    private static final String SERIALIZED_NAME_REALTIME_URL = "realtimeURL";

    @JsonProperty(value = SERIALIZED_NAME_REALTIME_URL, required = true)
    private String realtimeURL;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    private static final int MAXIMUM_REALTIME_URL_LENGTH = 256;

    protected RealtimeUrlResponse() {
    }

    @JsonCreator
    public RealtimeUrlResponse(
            @JsonProperty(value = SERIALIZED_NAME_REALTIME_URL, required = true) String realtimeURL
    ) {
        this.realtimeURL = validateRealtimeURL(realtimeURL);
    }

    public RealtimeUrlResponse realtimeURL(String realtimeURL) {
        this.realtimeURL = validateRealtimeURL(realtimeURL);
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
        this.realtimeURL = validateRealtimeURL(realtimeURL);
    }

    private String validateRealtimeURL(String realtimeURL) {
        Objects.requireNonNull(realtimeURL);
        if (realtimeURL.length() > MAXIMUM_REALTIME_URL_LENGTH) {
            throw new IllegalArgumentException("realtimeURL length longer than maximum allowed");
        }
        return realtimeURL;
    }

    public RealtimeUrlResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object
     *
     * @return A map of JSON keys to objects
     **/
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealtimeUrlResponse realtimeUrlResponse = (RealtimeUrlResponse) o;
        return Objects.equals(this.realtimeURL, realtimeUrlResponse.realtimeURL) &&
                Objects.equals(this.unknownFields, realtimeUrlResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(realtimeURL, unknownFields);
    }

    @Override
    public String toString() {
        return "RealtimeUrlResponse{" +
                "realtimeURL='" + realtimeURL + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
