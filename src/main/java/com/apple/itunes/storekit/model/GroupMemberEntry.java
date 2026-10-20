// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A customer that belongs to a group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/groupmemberentry">GroupMemberEntry</a>
 **/
public class GroupMemberEntry {
    private static final String SERIALIZED_NAME_APP_TRANSACTION_ID = "appTransactionId";

    @JsonProperty(SERIALIZED_NAME_APP_TRANSACTION_ID)
    private String appTransactionId;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public GroupMemberEntry() {
    }

    public GroupMemberEntry appTransactionId(String appTransactionId) {
        this.appTransactionId = appTransactionId;
        return this;
    }

    /**
     * The unique identifier of the member’s app download transaction.
     *
     * @return appTransactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/apptransactionid">appTransactionId</a>
     **/
    public String getAppTransactionId() {
        return appTransactionId;
    }

    public void setAppTransactionId(String appTransactionId) {
        this.appTransactionId = appTransactionId;
    }

    public GroupMemberEntry unknownFields(Map<String, Object> unknownFields) {
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
        GroupMemberEntry groupMemberEntry = (GroupMemberEntry) o;
        return Objects.equals(this.appTransactionId, groupMemberEntry.appTransactionId) &&
                Objects.equals(this.unknownFields, groupMemberEntry.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appTransactionId, unknownFields);
    }

    @Override
    public String toString() {
        return "GroupMemberEntry{" +
                "appTransactionId='" + appTransactionId + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
