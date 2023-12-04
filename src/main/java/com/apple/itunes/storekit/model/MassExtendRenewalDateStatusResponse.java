// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A response that indicates the current status of a request to extend the subscription renewal date to all eligible subscribers.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/massextendrenewaldatestatusresponse">MassExtendRenewalDateStatusResponse</a>
 */
public class MassExtendRenewalDateStatusResponse {
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    private static final String SERIALIZED_NAME_COMPLETE = "complete";
    private static final String SERIALIZED_NAME_COMPLETE_DATE = "completeDate";
    private static final String SERIALIZED_NAME_SUCCEEDED_COUNT = "succeededCount";
    private static final String SERIALIZED_NAME_FAILED_COUNT = "failedCount";
    @JsonProperty(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;
    @JsonProperty(SERIALIZED_NAME_COMPLETE)
    private Boolean complete;
    @JsonProperty(SERIALIZED_NAME_COMPLETE_DATE)
    private Long completeDate;
    @JsonProperty(SERIALIZED_NAME_SUCCEEDED_COUNT)
    private Long succeededCount;
    @JsonProperty(SERIALIZED_NAME_FAILED_COUNT)
    private Long failedCount;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public MassExtendRenewalDateStatusResponse() {
    }

    public MassExtendRenewalDateStatusResponse requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
        return this;
    }

    /**
     * A string that contains a unique identifier you provide to track each subscription-renewal-date extension request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
    }

    public MassExtendRenewalDateStatusResponse complete(Boolean complete) {
        this.complete = complete;
        return this;
    }

    /**
     * A Boolean value that indicates whether the App Store completed the request to extend a subscription renewal date to active subscribers.
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
     * The UNIX time, in milliseconds, that the App Store completes a request to extend a subscription renewal date for eligible subscribers.
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

    public MassExtendRenewalDateStatusResponse succeededCount(Long succeededCount) {
        this.succeededCount = succeededCount;
        return this;
    }

    /**
     * The count of subscriptions that successfully receive a subscription-renewal-date extension.
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

    public MassExtendRenewalDateStatusResponse failedCount(Long failedCount) {
        this.failedCount = failedCount;
        return this;
    }

    /**
     * The count of subscriptions that fail to receive a subscription-renewal-date extension.
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


    public MassExtendRenewalDateStatusResponse unknownFields(Map<String, Object> unknownFields) {
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
        MassExtendRenewalDateStatusResponse massExtendRenewalDateStatusResponse = (MassExtendRenewalDateStatusResponse) o;
        return Objects.equals(this.requestIdentifier, massExtendRenewalDateStatusResponse.requestIdentifier) &&
                Objects.equals(this.complete, massExtendRenewalDateStatusResponse.complete) &&
                Objects.equals(this.completeDate, massExtendRenewalDateStatusResponse.completeDate) &&
                Objects.equals(this.succeededCount, massExtendRenewalDateStatusResponse.succeededCount) &&
                Objects.equals(this.failedCount, massExtendRenewalDateStatusResponse.failedCount) &&
                Objects.equals(this.unknownFields, massExtendRenewalDateStatusResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestIdentifier, complete, completeDate, succeededCount, failedCount, unknownFields);
    }

    @Override
    public String toString() {
        return "MassExtendRenewalDateStatusResponse{" +
                "requestIdentifier='" + requestIdentifier + '\'' +
                ", complete=" + complete +
                ", completeDate=" + completeDate +
                ", succeededCount=" + succeededCount +
                ", failedCount=" + failedCount +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

