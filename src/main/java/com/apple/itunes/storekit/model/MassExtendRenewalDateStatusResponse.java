// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;
import java.util.Objects;

/**
 * A response that indicates the current status of a request to extend the subscription renewal date to all eligible subscribers.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/massextendrenewaldatestatusresponse">MassExtendRenewalDateStatusResponse</a>
 **/
public class MassExtendRenewalDateStatusResponse {
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    private static final String SERIALIZED_NAME_COMPLETE = "complete";
    private static final String SERIALIZED_NAME_COMPLETE_DATE = "completeDate";
    private static final String SERIALIZED_NAME_FAILED_COUNT = "failedCount";
    private static final String SERIALIZED_NAME_SUCCEEDED_COUNT = "succeededCount";

    @JsonProperty(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;
    @JsonProperty(SERIALIZED_NAME_COMPLETE)
    private Boolean complete;
    @JsonProperty(SERIALIZED_NAME_COMPLETE_DATE)
    private Long completeDate;
    @JsonProperty(SERIALIZED_NAME_FAILED_COUNT)
    private Long failedCount;
    @JsonProperty(SERIALIZED_NAME_SUCCEEDED_COUNT)
    private Long succeededCount;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    private static final int MAXIMUM_REQUEST_IDENTIFIER_LENGTH = 128;

    public MassExtendRenewalDateStatusResponse() {
    }

    public MassExtendRenewalDateStatusResponse requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
        return this;
    }

    /**
     * The UUID that represents your request for a subscription-renewal-date extension.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    @JsonSetter(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
    }

    private String validateRequestIdentifier(String requestIdentifier) {
        if (requestIdentifier != null && requestIdentifier.length() > MAXIMUM_REQUEST_IDENTIFIER_LENGTH) {
            throw new IllegalArgumentException("requestIdentifier length longer than maximum allowed");
        }
        return requestIdentifier;
    }

    public MassExtendRenewalDateStatusResponse complete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    /**
     * A Boolean value that’s TRUE to indicate that the App Store completed your request to extend a subscription renewal date for all eligible subscribers.
     *
     * @return complete
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/complete">complete</a>
     **/
    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public MassExtendRenewalDateStatusResponse completeDate(Long completeDate) {
        this.completeDate = completeDate;
        return this;
    }

    /**
     * The date that the App Store completes the request.
     *
     * @return completeDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/completedate">completeDate</a>
     **/
    public Long getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Long completeDate) {
        this.completeDate = completeDate;
    }

    public MassExtendRenewalDateStatusResponse failedCount(Long failedCount) {
        this.failedCount = failedCount;
        return this;
    }

    /**
     * The final count of subscribers that fail to receive a subscription-renewal-date extension.
     *
     * @return failedCount
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/failedcount">failedCount</a>
     **/
    public Long getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Long failedCount) {
        this.failedCount = failedCount;
    }

    public MassExtendRenewalDateStatusResponse succeededCount(Long succeededCount) {
        this.succeededCount = succeededCount;
        return this;
    }

    /**
     * The final count of subscribers that successfully receive a subscription-renewal-date extension.
     *
     * @return succeededCount
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/succeededcount">succeededCount</a>
     **/
    public Long getSucceededCount() {
        return succeededCount;
    }

    public void setSucceededCount(Long succeededCount) {
        this.succeededCount = succeededCount;
    }

    public MassExtendRenewalDateStatusResponse unknownFields(Map<String, Object> unknownFields) {
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
        MassExtendRenewalDateStatusResponse massExtendRenewalDateStatusResponse = (MassExtendRenewalDateStatusResponse) o;
        return Objects.equals(this.requestIdentifier, massExtendRenewalDateStatusResponse.requestIdentifier) &&
                Objects.equals(this.complete, massExtendRenewalDateStatusResponse.complete) &&
                Objects.equals(this.completeDate, massExtendRenewalDateStatusResponse.completeDate) &&
                Objects.equals(this.failedCount, massExtendRenewalDateStatusResponse.failedCount) &&
                Objects.equals(this.succeededCount, massExtendRenewalDateStatusResponse.succeededCount) &&
                Objects.equals(this.unknownFields, massExtendRenewalDateStatusResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestIdentifier, complete, completeDate, failedCount, succeededCount, unknownFields);
    }

    @Override
    public String toString() {
        return "MassExtendRenewalDateStatusResponse{" +
                "requestIdentifier='" + requestIdentifier + '\'' +
                ", complete=" + complete +
                ", completeDate=" + completeDate +
                ", failedCount=" + failedCount +
                ", succeededCount=" + succeededCount +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
