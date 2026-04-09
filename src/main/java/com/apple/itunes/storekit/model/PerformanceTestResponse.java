// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The performance test response object.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponse">PerformanceTestResponse</a>
 */
public class PerformanceTestResponse {
    private static final String SERIALIZED_NAME_CONFIG = "config";
    private static final String SERIALIZED_NAME_REQUEST_ID = "requestId";
    @JsonProperty(SERIALIZED_NAME_CONFIG)
    private PerformanceTestConfig config;
    @JsonProperty(SERIALIZED_NAME_REQUEST_ID)
    private String requestId;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public PerformanceTestResponse() {
    }

    public PerformanceTestResponse config(PerformanceTestConfig config) {
        this.config = config;
        return this;
    }

    /**
     * The performance test configuration object.
     *
     * @return config
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public PerformanceTestConfig getConfig() {
        return config;
    }

    public void setConfig(PerformanceTestConfig config) {
        this.config = config;
    }

    public PerformanceTestResponse requestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * The performance test request identifier.
     *
     * @return requestId
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/requestid">requestId</a>
     **/
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public PerformanceTestResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     Fields that are not recognized for this object

     @return A map of JSON keys to objects
     */
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
        PerformanceTestResponse performanceTestResponse = (PerformanceTestResponse) o;
        return Objects.equals(this.config, performanceTestResponse.config) &&
                Objects.equals(this.requestId, performanceTestResponse.requestId) &&
                Objects.equals(this.unknownFields, performanceTestResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config, requestId, unknownFields);
    }

    @Override
    public String toString() {
        return "PerformanceTestResponse{" +
                "config=" + config +
                ", requestId='" + requestId + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
