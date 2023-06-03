// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * The success or error information and the date the App Store server records when it attempts to send a server notification to your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptitem">sendAttemptItem</a>
 */
public class SendAttemptItem {
    private static final String SERIALIZED_NAME_ATTEMPT_DATE = "attemptDate";
    private static final String SERIALIZED_NAME_SEND_ATTEMPT_RESULT = "sendAttemptResult";
    @SerializedName(SERIALIZED_NAME_ATTEMPT_DATE)
    private Long attemptDate;
    @SerializedName(SERIALIZED_NAME_SEND_ATTEMPT_RESULT)
    private SendAttemptResult sendAttemptResult;

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
        this.sendAttemptResult = sendAttemptResult;
        return this;
    }

    /**
     * The success or error information the App Store server records when it attempts to send an App Store server notification to your server.
     *
     * @return sendAttemptResult
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptresult">sendAttemptResult</a>
     **/
    public SendAttemptResult getSendAttemptResult() {
        return sendAttemptResult;
    }

    public void setSendAttemptResult(SendAttemptResult sendAttemptResult) {
        this.sendAttemptResult = sendAttemptResult;
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
                Objects.equals(this.sendAttemptResult, sendAttemptItem.sendAttemptResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptDate, sendAttemptResult);
    }

    @Override
    public String toString() {
        return "TransactionInfoResponse{" +
                "attemptDate=" + attemptDate +
                ", sendAttemptResult=" + sendAttemptResult +
                '}';
    }
}

