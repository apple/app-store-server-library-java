// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A response that contains the App Store Server Notifications history for your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationhistoryresponse">NotificationHistoryResponse</a>
 */
public class NotificationHistoryResponse {
    private static final String SERIALIZED_NAME_PAGINATION_TOKEN = "paginationToken";
    private static final String SERIALIZED_NAME_HAS_MORE = "hasMore";
    private static final String SERIALIZED_NAME_NOTIFICATION_HISTORY = "notificationHistory";
    @SerializedName(SERIALIZED_NAME_PAGINATION_TOKEN)
    private String paginationToken;
    @SerializedName(SERIALIZED_NAME_HAS_MORE)
    private Boolean hasMore;
    @SerializedName(SERIALIZED_NAME_NOTIFICATION_HISTORY)
    private List<NotificationHistoryResponseItem> notificationHistory = null;


    public NotificationHistoryResponse() {
    }

    public NotificationHistoryResponse paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    /**
     * A pagination token that you return to the endpoint on a subsequent call to receive the next set of results.
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

    public NotificationHistoryResponse hasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    /**
     * A Boolean value indicating whether the App Store has more transaction data.
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

    public NotificationHistoryResponse notificationHistory(List<NotificationHistoryResponseItem> notificationHistory) {
        this.notificationHistory = notificationHistory;
        return this;
    }

    public NotificationHistoryResponse addNotificationHistoryItem(NotificationHistoryResponseItem notificationHistoryItem) {
        if (this.notificationHistory == null) {
            this.notificationHistory = new ArrayList<>();
        }
        this.notificationHistory.add(notificationHistoryItem);
        return this;
    }

    /**
     * An array of App Store server notification history records.
     *
     * @return notificationHistory
     **/
    public List<NotificationHistoryResponseItem> getNotificationHistory() {
        return notificationHistory;
    }

    public void setNotificationHistory(List<NotificationHistoryResponseItem> notificationHistory) {
        this.notificationHistory = notificationHistory;
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
        return Objects.equals(this.paginationToken, notificationHistoryResponse.paginationToken) &&
                Objects.equals(this.hasMore, notificationHistoryResponse.hasMore) &&
                Objects.equals(this.notificationHistory, notificationHistoryResponse.notificationHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paginationToken, hasMore, notificationHistory);
    }

    @Override
    public String toString() {
        return "NotificationHistoryResponse{" +
                "paginationToken='" + paginationToken + '\'' +
                ", hasMore=" + hasMore +
                ", notificationHistory=" + notificationHistory +
                '}';
    }
}

