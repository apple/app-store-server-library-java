// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * An object that enumerates the test configuration parameters.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
 **/
public class PerformanceTestConfig {
    private static final String SERIALIZED_NAME_MAX_CONCURRENT_REQUESTS = "maxConcurrentRequests";
    private static final String SERIALIZED_NAME_RESPONSE_TIME_THRESHOLD = "responseTimeThreshold";
    private static final String SERIALIZED_NAME_SUCCESS_RATE_THRESHOLD = "successRateThreshold";
    private static final String SERIALIZED_NAME_TOTAL_DURATION = "totalDuration";
    private static final String SERIALIZED_NAME_TOTAL_REQUESTS = "totalRequests";

    @JsonProperty(value = SERIALIZED_NAME_MAX_CONCURRENT_REQUESTS, required = true)
    private Long maxConcurrentRequests;
    @JsonProperty(value = SERIALIZED_NAME_RESPONSE_TIME_THRESHOLD, required = true)
    private Long responseTimeThreshold;
    @JsonProperty(value = SERIALIZED_NAME_SUCCESS_RATE_THRESHOLD, required = true)
    private Integer successRateThreshold;
    @JsonProperty(value = SERIALIZED_NAME_TOTAL_DURATION, required = true)
    private Long totalDuration;
    @JsonProperty(value = SERIALIZED_NAME_TOTAL_REQUESTS, required = true)
    private Long totalRequests;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected PerformanceTestConfig() {
    }

    @JsonCreator
    public PerformanceTestConfig(
            @JsonProperty(value = SERIALIZED_NAME_MAX_CONCURRENT_REQUESTS, required = true) Long maxConcurrentRequests,
            @JsonProperty(value = SERIALIZED_NAME_RESPONSE_TIME_THRESHOLD, required = true) Long responseTimeThreshold,
            @JsonProperty(value = SERIALIZED_NAME_SUCCESS_RATE_THRESHOLD, required = true) Integer successRateThreshold,
            @JsonProperty(value = SERIALIZED_NAME_TOTAL_DURATION, required = true) Long totalDuration,
            @JsonProperty(value = SERIALIZED_NAME_TOTAL_REQUESTS, required = true) Long totalRequests
    ) {
        this.maxConcurrentRequests = Objects.requireNonNull(maxConcurrentRequests);
        this.responseTimeThreshold = Objects.requireNonNull(responseTimeThreshold);
        this.successRateThreshold = Objects.requireNonNull(successRateThreshold);
        this.totalDuration = Objects.requireNonNull(totalDuration);
        this.totalRequests = Objects.requireNonNull(totalRequests);
    }

    public PerformanceTestConfig maxConcurrentRequests(Long maxConcurrentRequests) {
        this.maxConcurrentRequests = Objects.requireNonNull(maxConcurrentRequests);
        return this;
    }

    /**
     * The maximum number of concurrent requests the API allows.
     *
     * @return maxConcurrentRequests
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public Long getMaxConcurrentRequests() {
        return maxConcurrentRequests;
    }

    public void setMaxConcurrentRequests(Long maxConcurrentRequests) {
        this.maxConcurrentRequests = Objects.requireNonNull(maxConcurrentRequests);
    }

    public PerformanceTestConfig responseTimeThreshold(Long responseTimeThreshold) {
        this.responseTimeThreshold = Objects.requireNonNull(responseTimeThreshold);
        return this;
    }

    /**
     * The maximum time your server has to respond when the system calls your Get Retention Message endpoint in the sandbox environment.
     *
     * @return responseTimeThreshold
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public Long getResponseTimeThreshold() {
        return responseTimeThreshold;
    }

    public void setResponseTimeThreshold(Long responseTimeThreshold) {
        this.responseTimeThreshold = Objects.requireNonNull(responseTimeThreshold);
    }

    public PerformanceTestConfig successRateThreshold(Integer successRateThreshold) {
        this.successRateThreshold = Objects.requireNonNull(successRateThreshold);
        return this;
    }

    /**
     * The success rate threshold percentage.
     *
     * @return successRateThreshold
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public Integer getSuccessRateThreshold() {
        return successRateThreshold;
    }

    public void setSuccessRateThreshold(Integer successRateThreshold) {
        this.successRateThreshold = Objects.requireNonNull(successRateThreshold);
    }

    public PerformanceTestConfig totalDuration(Long totalDuration) {
        this.totalDuration = Objects.requireNonNull(totalDuration);
        return this;
    }

    /**
     * The total duration of the test in milliseconds.
     *
     * @return totalDuration
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public Long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = Objects.requireNonNull(totalDuration);
    }

    public PerformanceTestConfig totalRequests(Long totalRequests) {
        this.totalRequests = Objects.requireNonNull(totalRequests);
        return this;
    }

    /**
     * The total number of requests to make during the test.
     *
     * @return totalRequests
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public Long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Long totalRequests) {
        this.totalRequests = Objects.requireNonNull(totalRequests);
    }

    public PerformanceTestConfig unknownFields(Map<String, Object> unknownFields) {
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
        PerformanceTestConfig performanceTestConfig = (PerformanceTestConfig) o;
        return Objects.equals(this.maxConcurrentRequests, performanceTestConfig.maxConcurrentRequests) &&
                Objects.equals(this.responseTimeThreshold, performanceTestConfig.responseTimeThreshold) &&
                Objects.equals(this.successRateThreshold, performanceTestConfig.successRateThreshold) &&
                Objects.equals(this.totalDuration, performanceTestConfig.totalDuration) &&
                Objects.equals(this.totalRequests, performanceTestConfig.totalRequests) &&
                Objects.equals(this.unknownFields, performanceTestConfig.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxConcurrentRequests, responseTimeThreshold, successRateThreshold, totalDuration, totalRequests, unknownFields);
    }

    @Override
    public String toString() {
        return "PerformanceTestConfig{" +
                "maxConcurrentRequests=" + maxConcurrentRequests +
                ", responseTimeThreshold=" + responseTimeThreshold +
                ", successRateThreshold=" + successRateThreshold +
                ", totalDuration=" + totalDuration +
                ", totalRequests=" + totalRequests +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
