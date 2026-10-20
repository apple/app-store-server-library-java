// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * An object that describes test response times.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
 **/
public class PerformanceTestResponseTimes {
    private static final String SERIALIZED_NAME_AVERAGE = "average";
    private static final String SERIALIZED_NAME_P50 = "p50";
    private static final String SERIALIZED_NAME_P90 = "p90";
    private static final String SERIALIZED_NAME_P95 = "p95";
    private static final String SERIALIZED_NAME_P99 = "p99";

    @JsonProperty(value = SERIALIZED_NAME_AVERAGE, required = true)
    private Long average;
    @JsonProperty(value = SERIALIZED_NAME_P50, required = true)
    private Long p50;
    @JsonProperty(value = SERIALIZED_NAME_P90, required = true)
    private Long p90;
    @JsonProperty(value = SERIALIZED_NAME_P95, required = true)
    private Long p95;
    @JsonProperty(value = SERIALIZED_NAME_P99, required = true)
    private Long p99;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected PerformanceTestResponseTimes() {
    }

    @JsonCreator
    public PerformanceTestResponseTimes(
            @JsonProperty(value = SERIALIZED_NAME_AVERAGE, required = true) Long average,
            @JsonProperty(value = SERIALIZED_NAME_P50, required = true) Long p50,
            @JsonProperty(value = SERIALIZED_NAME_P90, required = true) Long p90,
            @JsonProperty(value = SERIALIZED_NAME_P95, required = true) Long p95,
            @JsonProperty(value = SERIALIZED_NAME_P99, required = true) Long p99
    ) {
        this.average = Objects.requireNonNull(average);
        this.p50 = Objects.requireNonNull(p50);
        this.p90 = Objects.requireNonNull(p90);
        this.p95 = Objects.requireNonNull(p95);
        this.p99 = Objects.requireNonNull(p99);
    }

    public PerformanceTestResponseTimes average(Long average) {
        this.average = Objects.requireNonNull(average);
        return this;
    }

    /**
     * Average response time in milliseconds.
     *
     * @return average
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
     **/
    public Long getAverage() {
        return average;
    }

    public void setAverage(Long average) {
        this.average = Objects.requireNonNull(average);
    }

    public PerformanceTestResponseTimes p50(Long p50) {
        this.p50 = Objects.requireNonNull(p50);
        return this;
    }

    /**
     * The 50th percentile response time in milliseconds.
     *
     * @return p50
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
     **/
    public Long getP50() {
        return p50;
    }

    public void setP50(Long p50) {
        this.p50 = Objects.requireNonNull(p50);
    }

    public PerformanceTestResponseTimes p90(Long p90) {
        this.p90 = Objects.requireNonNull(p90);
        return this;
    }

    /**
     * The 90th percentile response time in milliseconds.
     *
     * @return p90
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
     **/
    public Long getP90() {
        return p90;
    }

    public void setP90(Long p90) {
        this.p90 = Objects.requireNonNull(p90);
    }

    public PerformanceTestResponseTimes p95(Long p95) {
        this.p95 = Objects.requireNonNull(p95);
        return this;
    }

    /**
     * The 95th percentile response time in milliseconds.
     *
     * @return p95
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
     **/
    public Long getP95() {
        return p95;
    }

    public void setP95(Long p95) {
        this.p95 = Objects.requireNonNull(p95);
    }

    public PerformanceTestResponseTimes p99(Long p99) {
        this.p99 = Objects.requireNonNull(p99);
        return this;
    }

    /**
     * The 99th percentile response time in milliseconds.
     *
     * @return p99
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
     **/
    public Long getP99() {
        return p99;
    }

    public void setP99(Long p99) {
        this.p99 = Objects.requireNonNull(p99);
    }

    public PerformanceTestResponseTimes unknownFields(Map<String, Object> unknownFields) {
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
        PerformanceTestResponseTimes performanceTestResponseTimes = (PerformanceTestResponseTimes) o;
        return Objects.equals(this.average, performanceTestResponseTimes.average) &&
                Objects.equals(this.p50, performanceTestResponseTimes.p50) &&
                Objects.equals(this.p90, performanceTestResponseTimes.p90) &&
                Objects.equals(this.p95, performanceTestResponseTimes.p95) &&
                Objects.equals(this.p99, performanceTestResponseTimes.p99) &&
                Objects.equals(this.unknownFields, performanceTestResponseTimes.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(average, p50, p90, p95, p99, unknownFields);
    }

    @Override
    public String toString() {
        return "PerformanceTestResponseTimes{" +
                "average=" + average +
                ", p50=" + p50 +
                ", p90=" + p90 +
                ", p95=" + p95 +
                ", p99=" + p99 +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
