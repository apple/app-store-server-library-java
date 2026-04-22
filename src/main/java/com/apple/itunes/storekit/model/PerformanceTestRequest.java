// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request object you provide for a performance test that contains an original transaction identifier.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestrequest">PerformanceTestRequest</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceTestRequest {
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    @JsonProperty(value = SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID, required = true)
    private String originalTransactionId;

    private PerformanceTestRequest() {
    }

    public PerformanceTestRequest(String originalTransactionId) {
        this.originalTransactionId = Objects.requireNonNull(originalTransactionId);
    }

    public PerformanceTestRequest originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = Objects.requireNonNull(originalTransactionId);
        return this;
    }

    /**
     * The original transaction identifier of an In-App Purchase you initiate in the sandbox environment, to use as the purchase for this test.
     *
     * @return originalTransactionId
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/originaltransactionid">originalTransactionId</a>
     **/
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = Objects.requireNonNull(originalTransactionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PerformanceTestRequest performanceTestRequest = (PerformanceTestRequest) o;
        return Objects.equals(this.originalTransactionId, performanceTestRequest.originalTransactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalTransactionId);
    }

    @Override
    public String toString() {
        return "PerformanceTestRequest{" +
                "originalTransactionId='" + originalTransactionId + '\'' +
                '}';
    }
}
