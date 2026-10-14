// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains the App Store Server Notifications history for your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationhistoryresponse">NotificationHistoryResponse</a>
 **/
public class NotificationHistoryResponse {
    private static final String SERIALIZED_NAME_NOTIFICATION_HISTORY = "notificationHistory";
    private static final String SERIALIZED_NAME_HAS_MORE = "hasMore";
    private static final String SERIALIZED_NAME_PAGINATION_TOKEN = "paginationToken";

    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_HISTORY)
    private List<NotificationHistoryResponseItem> notificationHistory;
    @JsonProperty(SERIALIZED_NAME_HAS_MORE)
    private Boolean hasMore;
    @JsonProperty(SERIALIZED_NAME_PAGINATION_TOKEN)
    private String paginationToken;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public NotificationHistoryResponse() {
    }

    public NotificationHistoryResponse notificationHistory(List<NotificationHistoryResponseItem> notificationHistory) {
        this.notificationHistory = notificationHistory;
        return this;
    }

    public NotificationHistoryResponse addNotificationHistory(NotificationHistoryResponseItem notificationHistory) {
        Objects.requireNonNull(notificationHistory);
        if (this.notificationHistory == null) {
            this.notificationHistory = new ArrayList<>();
        }
        this.notificationHistory.add(notificationHistory);
        return this;
    }

    /**
     * An array of App Store Server Notifications history records.
     *
     * @return notificationHistory
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationhistoryresponseitem">notificationHistoryResponseItem</a>
     **/
    public List<NotificationHistoryResponseItem> getNotificationHistory() {
        return notificationHistory;
    }

    public void setNotificationHistory(List<NotificationHistoryResponseItem> notificationHistory) {
        this.notificationHistory = notificationHistory;
    }

    public NotificationHistoryResponse hasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    /**
     * A Boolean value that indicates whether the App Store has more notification history records to send.
     *
     * @return hasMore
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/hasmore">hasMore</a>
     **/
    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public NotificationHistoryResponse paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    /**
     * A pagination token that you provide to Get Notification History on a subsequent request to get the next page of responses.
     *
     * @return paginationToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/paginationtoken">paginationToken</a>
     **/
    public String getPaginationToken() {
        return paginationToken;
    }

    public void setPaginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
    }

    public NotificationHistoryResponse unknownFields(Map<String, Object> unknownFields) {
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
        NotificationHistoryResponse notificationHistoryResponse = (NotificationHistoryResponse) o;
        return Objects.equals(this.notificationHistory, notificationHistoryResponse.notificationHistory) &&
                Objects.equals(this.hasMore, notificationHistoryResponse.hasMore) &&
                Objects.equals(this.paginationToken, notificationHistoryResponse.paginationToken) &&
                Objects.equals(this.unknownFields, notificationHistoryResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationHistory, hasMore, paginationToken, unknownFields);
    }

    @Override
    public String toString() {
        return "NotificationHistoryResponse{" +
                "notificationHistory=" + notificationHistory +
                ", hasMore=" + hasMore +
                ", paginationToken='" + paginationToken + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
