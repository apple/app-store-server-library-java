// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The success or error information and the date the App Store server records when it attempts to send a server notification to your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptitem">sendAttemptItem</a>
 */
public class SendAttemptItem {
    private static final String SERIALIZED_NAME_ATTEMPT_DATE = "attemptDate";
    private static final String SERIALIZED_NAME_SEND_ATTEMPT_RESULT = "sendAttemptResult";
    @JsonProperty(SERIALIZED_NAME_ATTEMPT_DATE)
    private Long attemptDate;
    @JsonProperty(SERIALIZED_NAME_SEND_ATTEMPT_RESULT)
    private String sendAttemptResult;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public SendAttemptItem() {
    }

    public SendAttemptItem attemptDate(Long attemptDate) {
        this.attemptDate = attemptDate;
        return this;
    }

    /**
     * The date the App Store server attempts to send a notification.
     *
     * @return attemptDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/attemptdate">attemptDate</a>
     **/
    public Long getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(Long attemptDate) {
        this.attemptDate = attemptDate;
    }

    public SendAttemptItem sendAttemptResult(SendAttemptResult sendAttemptResult) {
        this.sendAttemptResult = sendAttemptResult != null ? sendAttemptResult.getValue() : null;
        return this;
    }

    /**
     * The success or error information the App Store server records when it attempts to send an App Store server notification to your server.
     *
     * @return sendAttemptResult
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptresult">sendAttemptResult</a>
     **/
    public SendAttemptResult getSendAttemptResult() {
        return sendAttemptResult != null ? SendAttemptResult.fromValue(sendAttemptResult) : null;
    }

    /**
     * @see #getSendAttemptResult()
     */
    public String getRawSendAttemptResult() {
        return sendAttemptResult;
    }

    public void setSendAttemptResult(SendAttemptResult sendAttemptResult) {
        this.sendAttemptResult = sendAttemptResult != null ? sendAttemptResult.getValue() : null;
    }

    public void setRawSendAttemptResult(String rawSendAttemptResult) {
        this.sendAttemptResult = rawSendAttemptResult;
    }


    public SendAttemptItem unknownFields(Map<String, Object> unknownFields) {
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
        SendAttemptItem sendAttemptItem = (SendAttemptItem) o;
        return Objects.equals(this.attemptDate, sendAttemptItem.attemptDate) &&
                Objects.equals(this.sendAttemptResult, sendAttemptItem.sendAttemptResult) &&
                Objects.equals(this.unknownFields, sendAttemptItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptDate, sendAttemptResult, unknownFields);
    }

    @Override
    public String toString() {
        return "SendAttemptItem{" +
                "attemptDate=" + attemptDate +
                ", sendAttemptResult='" + sendAttemptResult + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

