// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An object the API returns that describes the performance test results.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestresultresponse">PerformanceTestResultResponse</a>
 */
public class PerformanceTestResultResponse {
    private static final String SERIALIZED_NAME_CONFIG = "config";
    private static final String SERIALIZED_NAME_TARGET = "target";
    private static final String SERIALIZED_NAME_RESULT = "result";
    private static final String SERIALIZED_NAME_SUCCESS_RATE = "successRate";
    private static final String SERIALIZED_NAME_NUM_PENDING = "numPending";
    private static final String SERIALIZED_NAME_RESPONSE_TIMES = "responseTimes";
    private static final String SERIALIZED_NAME_FAILURES = "failures";
    @JsonProperty(SERIALIZED_NAME_CONFIG)
    private PerformanceTestConfig config;
    @JsonProperty(SERIALIZED_NAME_TARGET)
    private String target;
    @JsonProperty(SERIALIZED_NAME_RESULT)
    private String result;
    @JsonProperty(SERIALIZED_NAME_SUCCESS_RATE)
    private Integer successRate;
    @JsonProperty(SERIALIZED_NAME_NUM_PENDING)
    private Integer numPending;
    @JsonProperty(SERIALIZED_NAME_RESPONSE_TIMES)
    private PerformanceTestResponseTimes responseTimes;
    @JsonProperty(SERIALIZED_NAME_FAILURES)
    private Map<String, Integer> failures;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public PerformanceTestResultResponse() {
    }

    public PerformanceTestResultResponse config(PerformanceTestConfig config) {
        this.config = config;
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
        this.config = config;
    }

    public PerformanceTestResultResponse target(String target) {
        this.target = target;
        return this;
    }

    /**
     * The target URL for the performance test.
     *
     * @return target
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/target">target</a>
     **/
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public PerformanceTestResultResponse result(PerformanceTestStatus result) {
        this.result = result != null ? result.getValue() : null;
        return this;
    }

    /**
     * A PerformanceTestStatus object that describes the overall result of the test.
     *
     * @return result
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performanceteststatus">performanceTestStatus</a>
     **/
    public PerformanceTestStatus getResult() {
        return result != null ? PerformanceTestStatus.fromValue(result) : null;
    }

    /**
     * @see #getResult()
     */
    public String getRawResult() {
        return result;
    }

    public void setResult(PerformanceTestStatus result) {
        this.result = result != null ? result.getValue() : null;
    }

    public void setRawResult(String rawResult) {
        this.result = rawResult;
    }

    public PerformanceTestResultResponse successRate(Integer successRate) {
        this.successRate = successRate;
        return this;
    }

    /**
     * An integer that describes he success rate percentage of the performance test.
     *
     * @return successRate
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/successrate">successRate</a>
     **/
    public Integer getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Integer successRate) {
        this.successRate = successRate;
    }

    public PerformanceTestResultResponse numPending(Integer numPending) {
        this.numPending = numPending;
        return this;
    }

    /**
     * An integer that describes the number of pending requests in the performance test.
     *
     * @return numPending
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/numpending">numPending</a>
     **/
    public Integer getNumPending() {
        return numPending;
    }

    public void setNumPending(Integer numPending) {
        this.numPending = numPending;
    }

    public PerformanceTestResultResponse responseTimes(PerformanceTestResponseTimes responseTimes) {
        this.responseTimes = responseTimes;
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
        this.responseTimes = responseTimes;
    }

    public PerformanceTestResultResponse failures(Map<SendAttemptResult, Integer> failures) {
        if (failures != null) {
            this.failures = new HashMap<>();
            for (Map.Entry<SendAttemptResult, Integer> entry : failures.entrySet()) {
                this.failures.put(entry.getKey().getValue(), entry.getValue());
            }
        } else {
            this.failures = null;
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
        if (failures == null) {
            return null;
        }
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
     */
    public Map<String, Integer> getRawFailures() {
        return failures;
    }

    public void setFailures(Map<SendAttemptResult, Integer> failures) {
        if (failures != null) {
            this.failures = new HashMap<>();
            for (Map.Entry<SendAttemptResult, Integer> entry : failures.entrySet()) {
                this.failures.put(entry.getKey().getValue(), entry.getValue());
            }
        } else {
            this.failures = null;
        }
    }

    public void setRawFailures(Map<String, Integer> rawFailures) {
        this.failures = rawFailures;
    }


    public PerformanceTestResultResponse unknownFields(Map<String, Object> unknownFields) {
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
        PerformanceTestResultResponse performanceTestResultResponse = (PerformanceTestResultResponse) o;
        return Objects.equals(this.config, performanceTestResultResponse.config) &&
                Objects.equals(this.target, performanceTestResultResponse.target) &&
                Objects.equals(this.result, performanceTestResultResponse.result) &&
                Objects.equals(this.successRate, performanceTestResultResponse.successRate) &&
                Objects.equals(this.numPending, performanceTestResultResponse.numPending) &&
                Objects.equals(this.responseTimes, performanceTestResultResponse.responseTimes) &&
                Objects.equals(this.failures, performanceTestResultResponse.failures) &&
                Objects.equals(this.unknownFields, performanceTestResultResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config, target, result, successRate, numPending, responseTimes, failures, unknownFields);
    }

    @Override
    public String toString() {
        return "PerformanceTestResultResponse{" +
                "config=" + config +
                ", target='" + target + '\'' +
                ", result='" + result + '\'' +
                ", successRate=" + successRate +
                ", numPending=" + numPending +
                ", responseTimes=" + responseTimes +
                ", failures=" + failures +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
