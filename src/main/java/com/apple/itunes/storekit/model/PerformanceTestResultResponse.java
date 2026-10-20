// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An object the API returns that describes the performance test results.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresultresponse">PerformanceTestResultResponse</a>
 **/
public class PerformanceTestResultResponse {
    private static final String SERIALIZED_NAME_CONFIG = "config";
    private static final String SERIALIZED_NAME_FAILURES = "failures";
    private static final String SERIALIZED_NAME_NUM_PENDING = "numPending";
    private static final String SERIALIZED_NAME_RESPONSE_TIMES = "responseTimes";
    private static final String SERIALIZED_NAME_RESULT = "result";
    private static final String SERIALIZED_NAME_SUCCESS_RATE = "successRate";
    private static final String SERIALIZED_NAME_TARGET = "target";

    @JsonProperty(value = SERIALIZED_NAME_CONFIG, required = true)
    private PerformanceTestConfig config;
    @JsonProperty(value = SERIALIZED_NAME_FAILURES, required = true)
    private Map<String, Integer> failures;
    @JsonProperty(value = SERIALIZED_NAME_NUM_PENDING, required = true)
    private Integer numPending;
    @JsonProperty(value = SERIALIZED_NAME_RESPONSE_TIMES, required = true)
    private PerformanceTestResponseTimes responseTimes;
    @JsonProperty(value = SERIALIZED_NAME_RESULT, required = true)
    private String result;
    @JsonProperty(value = SERIALIZED_NAME_SUCCESS_RATE, required = true)
    private Integer successRate;
    @JsonProperty(value = SERIALIZED_NAME_TARGET, required = true)
    private String target;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected PerformanceTestResultResponse() {
    }

    public PerformanceTestResultResponse(
            PerformanceTestConfig config,
            Map<SendAttemptResult, Integer> failures,
            Integer numPending,
            PerformanceTestResponseTimes responseTimes,
            PerformanceTestStatus result,
            Integer successRate,
            String target
    ) {
        this.config = Objects.requireNonNull(config);
        Objects.requireNonNull(failures);
        this.failures = new HashMap<>();
        for (Map.Entry<SendAttemptResult, Integer> entry : failures.entrySet()) {
            this.failures.put(entry.getKey().getValue(), entry.getValue());
        }
        this.numPending = Objects.requireNonNull(numPending);
        this.responseTimes = Objects.requireNonNull(responseTimes);
        this.result = Objects.requireNonNull(result).getValue();
        this.successRate = Objects.requireNonNull(successRate);
        this.target = Objects.requireNonNull(target);
    }

    @JsonCreator
    public PerformanceTestResultResponse(
            @JsonProperty(value = SERIALIZED_NAME_CONFIG, required = true) PerformanceTestConfig config,
            @JsonProperty(value = SERIALIZED_NAME_FAILURES, required = true) Map<String, Integer> rawFailures,
            @JsonProperty(value = SERIALIZED_NAME_NUM_PENDING, required = true) Integer numPending,
            @JsonProperty(value = SERIALIZED_NAME_RESPONSE_TIMES, required = true) PerformanceTestResponseTimes responseTimes,
            @JsonProperty(value = SERIALIZED_NAME_RESULT, required = true) String rawResult,
            @JsonProperty(value = SERIALIZED_NAME_SUCCESS_RATE, required = true) Integer successRate,
            @JsonProperty(value = SERIALIZED_NAME_TARGET, required = true) String target
    ) {
        this.config = Objects.requireNonNull(config);
        this.failures = Objects.requireNonNull(rawFailures);
        this.numPending = Objects.requireNonNull(numPending);
        this.responseTimes = Objects.requireNonNull(responseTimes);
        this.result = Objects.requireNonNull(rawResult);
        this.successRate = Objects.requireNonNull(successRate);
        this.target = Objects.requireNonNull(target);
    }

    public PerformanceTestResultResponse config(PerformanceTestConfig config) {
        this.config = Objects.requireNonNull(config);
        return this;
    }

    /**
     * A PerformanceTestConfig object that enumerates the test parameters.
     *
     * @return config
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestconfig">PerformanceTestConfig</a>
     **/
    public PerformanceTestConfig getConfig() {
        return config;
    }

    public void setConfig(PerformanceTestConfig config) {
        this.config = Objects.requireNonNull(config);
    }

    public PerformanceTestResultResponse failures(Map<SendAttemptResult, Integer> failures) {
        Objects.requireNonNull(failures);
        this.failures = new HashMap<>();
        for (Map.Entry<SendAttemptResult, Integer> entry : failures.entrySet()) {
            this.failures.put(entry.getKey().getValue(), entry.getValue());
        }
        return this;
    }

    /**
     * A Failures object that represents a map of server-to-server notification failure reasons and counts that represent the number of failures encountered during the performance test.
     *
     * @return failures
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/failures">Failures</a>
     **/
    public Map<SendAttemptResult, Integer> getFailures() {
        Map<SendAttemptResult, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : failures.entrySet()) {
            SendAttemptResult key = SendAttemptResult.fromValue(entry.getKey());
            if (key != null) {
                result.put(key, entry.getValue());
            }
        }
        return result;
    }

    /**
     * @see #getFailures()
     **/
    public Map<String, Integer> getRawFailures() {
        return failures;
    }

    public void setFailures(Map<SendAttemptResult, Integer> failures) {
        Objects.requireNonNull(failures);
        this.failures = new HashMap<>();
        for (Map.Entry<SendAttemptResult, Integer> entry : failures.entrySet()) {
            this.failures.put(entry.getKey().getValue(), entry.getValue());
        }
    }

    public void setRawFailures(Map<String, Integer> rawFailures) {
        this.failures = Objects.requireNonNull(rawFailures);
    }

    public PerformanceTestResultResponse numPending(Integer numPending) {
        this.numPending = Objects.requireNonNull(numPending);
        return this;
    }

    /**
     * An integer that describes the number of pending requests in the performance test.
     *
     * @return numPending
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresultresponse">PerformanceTestResultResponse</a>
     **/
    public Integer getNumPending() {
        return numPending;
    }

    public void setNumPending(Integer numPending) {
        this.numPending = Objects.requireNonNull(numPending);
    }

    public PerformanceTestResultResponse responseTimes(PerformanceTestResponseTimes responseTimes) {
        this.responseTimes = Objects.requireNonNull(responseTimes);
        return this;
    }

    /**
     * A PerformanceTestResponseTimes object that enumerates the response times measured during the test.
     *
     * @return responseTimes
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresponsetimes">PerformanceTestResponseTimes</a>
     **/
    public PerformanceTestResponseTimes getResponseTimes() {
        return responseTimes;
    }

    public void setResponseTimes(PerformanceTestResponseTimes responseTimes) {
        this.responseTimes = Objects.requireNonNull(responseTimes);
    }

    public PerformanceTestResultResponse result(PerformanceTestStatus result) {
        this.result = Objects.requireNonNull(result).getValue();
        return this;
    }

    /**
     * A PerformanceTestStatus object that describes the overall result of the test.
     *
     * @return result
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performanceteststatus">PerformanceTestStatus</a>
     **/
    public PerformanceTestStatus getResult() {
        return PerformanceTestStatus.fromValue(result);
    }

    /**
     * @see #getResult()
     **/
    public String getRawResult() {
        return result;
    }

    public void setResult(PerformanceTestStatus result) {
        this.result = Objects.requireNonNull(result).getValue();
    }

    public void setRawResult(String rawResult) {
        this.result = Objects.requireNonNull(rawResult);
    }

    public PerformanceTestResultResponse successRate(Integer successRate) {
        this.successRate = Objects.requireNonNull(successRate);
        return this;
    }

    /**
     * An integer that describes the success rate percentage of the performance test.
     *
     * @return successRate
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresultresponse">PerformanceTestResultResponse</a>
     **/
    public Integer getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Integer successRate) {
        this.successRate = Objects.requireNonNull(successRate);
    }

    public PerformanceTestResultResponse target(String target) {
        this.target = Objects.requireNonNull(target);
        return this;
    }

    /**
     * The target URL for the performance test.
     *
     * @return target
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresultresponse">PerformanceTestResultResponse</a>
     **/
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = Objects.requireNonNull(target);
    }

    public PerformanceTestResultResponse unknownFields(Map<String, Object> unknownFields) {
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
        PerformanceTestResultResponse performanceTestResultResponse = (PerformanceTestResultResponse) o;
        return Objects.equals(this.config, performanceTestResultResponse.config) &&
                Objects.equals(this.failures, performanceTestResultResponse.failures) &&
                Objects.equals(this.numPending, performanceTestResultResponse.numPending) &&
                Objects.equals(this.responseTimes, performanceTestResultResponse.responseTimes) &&
                Objects.equals(this.result, performanceTestResultResponse.result) &&
                Objects.equals(this.successRate, performanceTestResultResponse.successRate) &&
                Objects.equals(this.target, performanceTestResultResponse.target) &&
                Objects.equals(this.unknownFields, performanceTestResultResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config, failures, numPending, responseTimes, result, successRate, target, unknownFields);
    }

    @Override
    public String toString() {
        return "PerformanceTestResultResponse{" +
                "config=" + config +
                ", failures=" + failures +
                ", numPending=" + numPending +
                ", responseTimes=" + responseTimes +
                ", result='" + result + '\'' +
                ", successRate=" + successRate +
                ", target='" + target + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
