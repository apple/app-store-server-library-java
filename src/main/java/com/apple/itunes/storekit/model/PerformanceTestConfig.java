// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * An object that enumerates the test configuration parameters.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
 */
public class PerformanceTestConfig {
    private static final String SERIALIZED_NAME_MAX_CONCURRENT_REQUESTS = "maxConcurrentRequests";
    private static final String SERIALIZED_NAME_TOTAL_REQUESTS = "totalRequests";
    private static final String SERIALIZED_NAME_TOTAL_DURATION = "totalDuration";
    private static final String SERIALIZED_NAME_RESPONSE_TIME_THRESHOLD = "responseTimeThreshold";
    private static final String SERIALIZED_NAME_SUCCESS_RATE_THRESHOLD = "successRateThreshold";
    @JsonProperty(SERIALIZED_NAME_MAX_CONCURRENT_REQUESTS)
    private Long maxConcurrentRequests;
    @JsonProperty(SERIALIZED_NAME_TOTAL_REQUESTS)
    private Long totalRequests;
    @JsonProperty(SERIALIZED_NAME_TOTAL_DURATION)
    private Long totalDuration;
    @JsonProperty(SERIALIZED_NAME_RESPONSE_TIME_THRESHOLD)
    private Long responseTimeThreshold;
    @JsonProperty(SERIALIZED_NAME_SUCCESS_RATE_THRESHOLD)
    private Integer successRateThreshold;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public PerformanceTestConfig() {
    }

    public PerformanceTestConfig maxConcurrentRequests(Long maxConcurrentRequests) {
        this.maxConcurrentRequests = maxConcurrentRequests;
        return this;
    }

    /**
     * The maximum number of concurrent requests the API allows.
     *
     * @return maxConcurrentRequests
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/maxconcurrentrequests">maxConcurrentRequests</a>
     **/
    public Long getMaxConcurrentRequests() {
        return maxConcurrentRequests;
    }

    public void setMaxConcurrentRequests(Long maxConcurrentRequests) {
        this.maxConcurrentRequests = maxConcurrentRequests;
    }

    public PerformanceTestConfig totalRequests(Long totalRequests) {
        this.totalRequests = totalRequests;
        return this;
    }

    /**
     * The total number of requests to make during the test.
     *
     * @return totalRequests
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/totalrequests">totalRequests</a>
     **/
    public Long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Long totalRequests) {
        this.totalRequests = totalRequests;
    }

    public PerformanceTestConfig totalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
        return this;
    }

    /**
     * The total duration of the test in milliseconds.
     *
     * @return totalDuration
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/totalduration">totalDuration</a>
     **/
    public Long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public PerformanceTestConfig responseTimeThreshold(Long responseTimeThreshold) {
        this.responseTimeThreshold = responseTimeThreshold;
        return this;
    }

    /**
     * The maximum time your server has to respond when the system calls your Get Retention Message endpoint in the sandbox environment.
     *
     * @return responseTimeThreshold
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/responsetimethreshold">responseTimeThreshold</a>
     **/
    public Long getResponseTimeThreshold() {
        return responseTimeThreshold;
    }

    public void setResponseTimeThreshold(Long responseTimeThreshold) {
        this.responseTimeThreshold = responseTimeThreshold;
    }

    public PerformanceTestConfig successRateThreshold(Integer successRateThreshold) {
        this.successRateThreshold = successRateThreshold;
        return this;
    }

    /**
     * The success rate threshold percentage.
     *
     * @return successRateThreshold
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/successratethreshold">successRateThreshold</a>
     **/
    public Integer getSuccessRateThreshold() {
        return successRateThreshold;
    }

    public void setSuccessRateThreshold(Integer successRateThreshold) {
        this.successRateThreshold = successRateThreshold;
    }


    public PerformanceTestConfig unknownFields(Map<String, Object> unknownFields) {
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
        PerformanceTestConfig performanceTestConfig = (PerformanceTestConfig) o;
        return Objects.equals(this.maxConcurrentRequests, performanceTestConfig.maxConcurrentRequests) &&
                Objects.equals(this.totalRequests, performanceTestConfig.totalRequests) &&
                Objects.equals(this.totalDuration, performanceTestConfig.totalDuration) &&
                Objects.equals(this.responseTimeThreshold, performanceTestConfig.responseTimeThreshold) &&
                Objects.equals(this.successRateThreshold, performanceTestConfig.successRateThreshold) &&
                Objects.equals(this.unknownFields, performanceTestConfig.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxConcurrentRequests, totalRequests, totalDuration, responseTimeThreshold, successRateThreshold, unknownFields);
    }

    @Override
    public String toString() {
        return "PerformanceTestConfig{" +
                "maxConcurrentRequests=" + maxConcurrentRequests +
                ", totalRequests=" + totalRequests +
                ", totalDuration=" + totalDuration +
                ", responseTimeThreshold=" + responseTimeThreshold +
                ", successRateThreshold=" + successRateThreshold +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
