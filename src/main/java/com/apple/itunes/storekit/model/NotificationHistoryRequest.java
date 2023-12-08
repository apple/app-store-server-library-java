// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body for notification history.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationhistoryrequest">NotificationHistoryRequest</a>
 */
public class NotificationHistoryRequest {
    private static final String SERIALIZED_NAME_START_DATE = "startDate";
    private static final String SERIALIZED_NAME_END_DATE = "endDate";
    private static final String SERIALIZED_NAME_NOTIFICATION_TYPE = "notificationType";
    private static final String SERIALIZED_NAME_NOTIFICATION_SUBTYPE = "notificationSubtype";
    private static final String SERIALIZED_NAME_TRANSACTION_ID = "transactionId";
    private static final String SERIALIZED_NAME_ONLY_FAILURES = "onlyFailures";
    @JsonProperty(SERIALIZED_NAME_START_DATE)
    private Long startDate;
    @JsonProperty(SERIALIZED_NAME_END_DATE)
    private Long endDate;
    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_TYPE)
    private NotificationTypeV2 notificationType;
    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_SUBTYPE)
    private Subtype notificationSubtype;
    @JsonProperty(SERIALIZED_NAME_TRANSACTION_ID)
    private String transactionId;
    @JsonProperty(SERIALIZED_NAME_ONLY_FAILURES)
    private Boolean onlyFailures;


    public NotificationHistoryRequest() {
    }

    public NotificationHistoryRequest startDate(Long startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the timespan for the requested App Store Server Notification history records. The startDate needs to precede the endDate. Choose a startDate that’s within the past 180 days from the current date.
     *
     * @return startDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdate">startDate</a>
     **/
    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public NotificationHistoryRequest endDate(Long endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the timespan for the requested App Store Server Notification history records. Choose an endDate that’s later than the startDate. If you choose an endDate in the future, the endpoint automatically uses the current date as the endDate.
     *
     * @return endDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/enddate">endDate</a>
     **/
    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public NotificationHistoryRequest notificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    /**
     * A notification type. Provide this field to limit the notification history records to those with this one notification type. For a list of notifications types, see notificationType.
     * Include either the transactionId or the notificationType in your query, but not both.
     *
     * @return notificationType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationtype">notificationType</a>
     **/
    public NotificationTypeV2 getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType;
    }

    public NotificationHistoryRequest notificationSubtype(Subtype notificationSubtype) {
        this.notificationSubtype = notificationSubtype;
        return this;
    }

    /**
     * A notification subtype. Provide this field to limit the notification history records to those with this one notification subtype. For a list of subtypes, see subtype. If you specify a notificationSubtype, you need to also specify its related notificationType.
     *
     * @return notificationSubtype
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationsubtype">notificationSubtype</a>
     **/
    public Subtype getNotificationSubtype() {
        return notificationSubtype;
    }

    public void setNotificationSubtype(Subtype notificationSubtype) {
        this.notificationSubtype = notificationSubtype;
    }

    public NotificationHistoryRequest transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * The transaction identifier, which may be an original transaction identifier, of any transaction belonging to the customer. Provide this field to limit the notification history request to this one customer.
     * Include either the transactionId or the notificationType in your query, but not both.
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

    public NotificationHistoryRequest onlyFailures(Boolean onlyFailures) {
        this.onlyFailures = onlyFailures;
        return this;
    }

    /**
     * A Boolean value you set to true to request only the notifications that haven’t reached your server successfully. The response also includes notifications that the App Store server is currently retrying to send to your server.
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
                Objects.equals(this.transactionId, notificationHistoryRequest.transactionId) &&
                Objects.equals(this.onlyFailures, notificationHistoryRequest.onlyFailures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, notificationType, notificationSubtype, transactionId, onlyFailures);
    }

    @Override
    public String toString() {
        return "NotificationHistoryRequest{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", notificationType=" + notificationType +
                ", notificationSubtype=" + notificationSubtype +
                ", transactionId='" + transactionId + '\'' +
                ", onlyFailures=" + onlyFailures +
                '}';
    }
}

