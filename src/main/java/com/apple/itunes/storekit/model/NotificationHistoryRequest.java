// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body for notification history.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationhistoryrequest">NotificationHistoryRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationHistoryRequest {
    private static final String SERIALIZED_NAME_START_DATE = "startDate";
    private static final String SERIALIZED_NAME_END_DATE = "endDate";
    private static final String SERIALIZED_NAME_NOTIFICATION_TYPE = "notificationType";
    private static final String SERIALIZED_NAME_NOTIFICATION_SUBTYPE = "notificationSubtype";
    private static final String SERIALIZED_NAME_ONLY_FAILURES = "onlyFailures";
    private static final String SERIALIZED_NAME_TRANSACTION_ID = "transactionId";

    @JsonProperty(value = SERIALIZED_NAME_START_DATE, required = true)
    private Long startDate;
    @JsonProperty(value = SERIALIZED_NAME_END_DATE, required = true)
    private Long endDate;
    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_TYPE)
    private String notificationType;
    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_SUBTYPE)
    private String notificationSubtype;
    @JsonProperty(SERIALIZED_NAME_ONLY_FAILURES)
    private Boolean onlyFailures;
    @JsonProperty(SERIALIZED_NAME_TRANSACTION_ID)
    private String transactionId;

    protected NotificationHistoryRequest() {
    }

    public NotificationHistoryRequest(Long startDate, Long endDate) {
        this.startDate = Objects.requireNonNull(startDate);
        this.endDate = Objects.requireNonNull(endDate);
    }

    public NotificationHistoryRequest startDate(Long startDate) {
        this.startDate = Objects.requireNonNull(startDate);
        return this;
    }

    /**
     * The start date of the timespan for the requested App Store Server Notification history records.
     *
     * @return startDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdate">startDate</a>
     **/
    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = Objects.requireNonNull(startDate);
    }

    public NotificationHistoryRequest endDate(Long endDate) {
        this.endDate = Objects.requireNonNull(endDate);
        return this;
    }

    /**
     * The end date of the timespan for the requested App Store Server Notification history records.
     *
     * @return endDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/enddate">endDate</a>
     **/
    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = Objects.requireNonNull(endDate);
    }

    public NotificationHistoryRequest notificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType != null ? notificationType.getValue() : null;
        return this;
    }

    /**
     * A notification type.
     *
     * @return notificationType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationtype">notificationType</a>
     **/
    public NotificationTypeV2 getNotificationType() {
        return NotificationTypeV2.fromValue(notificationType);
    }

    /**
     * @see #getNotificationType()
     **/
    public String getRawNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType != null ? notificationType.getValue() : null;
    }

    public void setRawNotificationType(String rawNotificationType) {
        this.notificationType = rawNotificationType;
    }

    public NotificationHistoryRequest notificationSubtype(Subtype notificationSubtype) {
        this.notificationSubtype = notificationSubtype != null ? notificationSubtype.getValue() : null;
        return this;
    }

    /**
     * A notification subtype.
     *
     * @return notificationSubtype
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationsubtype">notificationSubtype</a>
     **/
    public Subtype getNotificationSubtype() {
        return Subtype.fromValue(notificationSubtype);
    }

    /**
     * @see #getNotificationSubtype()
     **/
    public String getRawNotificationSubtype() {
        return notificationSubtype;
    }

    public void setNotificationSubtype(Subtype notificationSubtype) {
        this.notificationSubtype = notificationSubtype != null ? notificationSubtype.getValue() : null;
    }

    public void setRawNotificationSubtype(String rawNotificationSubtype) {
        this.notificationSubtype = rawNotificationSubtype;
    }

    public NotificationHistoryRequest onlyFailures(Boolean onlyFailures) {
        this.onlyFailures = onlyFailures;
        return this;
    }

    /**
     * A Boolean value you set to true to request only the notifications that haven’t reached your server successfully.
     *
     * @return onlyFailures
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/onlyfailures">onlyFailures</a>
     **/
    public Boolean getOnlyFailures() {
        return onlyFailures;
    }

    public void setOnlyFailures(Boolean onlyFailures) {
        this.onlyFailures = onlyFailures;
    }

    public NotificationHistoryRequest transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * The transaction identifier, which may be an original transaction identifier, of any transaction belonging to the customer.
     *
     * @return transactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionid">transactionId</a>
     **/
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificationHistoryRequest notificationHistoryRequest = (NotificationHistoryRequest) o;
        return Objects.equals(this.startDate, notificationHistoryRequest.startDate) &&
                Objects.equals(this.endDate, notificationHistoryRequest.endDate) &&
                Objects.equals(this.notificationType, notificationHistoryRequest.notificationType) &&
                Objects.equals(this.notificationSubtype, notificationHistoryRequest.notificationSubtype) &&
                Objects.equals(this.onlyFailures, notificationHistoryRequest.onlyFailures) &&
                Objects.equals(this.transactionId, notificationHistoryRequest.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, notificationType, notificationSubtype, onlyFailures, transactionId);
    }

    @Override
    public String toString() {
        return "NotificationHistoryRequest{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", notificationType='" + notificationType + '\'' +
                ", notificationSubtype='" + notificationSubtype + '\'' +
                ", onlyFailures=" + onlyFailures +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
