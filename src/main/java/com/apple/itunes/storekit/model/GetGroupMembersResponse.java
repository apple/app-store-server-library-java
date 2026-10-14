// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains a page of the customers that belong to a group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/getgroupmembersresponse">GetGroupMembersResponse</a>
 **/
public class GetGroupMembersResponse {
    private static final String SERIALIZED_NAME_MEMBERS = "members";
    private static final String SERIALIZED_NAME_PAGINATION_TOKEN = "paginationToken";
    private static final String SERIALIZED_NAME_HAS_MORE = "hasMore";

    @JsonProperty(SERIALIZED_NAME_MEMBERS)
    private List<GroupMemberEntry> members;
    @JsonProperty(SERIALIZED_NAME_PAGINATION_TOKEN)
    private String paginationToken;
    @JsonProperty(SERIALIZED_NAME_HAS_MORE)
    private Boolean hasMore;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public GetGroupMembersResponse() {
    }

    public GetGroupMembersResponse members(List<GroupMemberEntry> members) {
        this.members = members;
        return this;
    }

    public GetGroupMembersResponse addMember(GroupMemberEntry member) {
        Objects.requireNonNull(member);
        if (this.members == null) {
            this.members = new ArrayList<>();
        }
        this.members.add(member);
        return this;
    }

    /**
     * An array of the customers that belong to the group.
     *
     * @return members
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/groupmemberentry">GroupMemberEntry</a>
     **/
    public List<GroupMemberEntry> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMemberEntry> members) {
        this.members = members;
    }

    public GetGroupMembersResponse paginationToken(String paginationToken) {
        this.paginationToken = paginationToken;
        return this;
    }

    /**
     * A token you send in a subsequent request to get the next set of members.
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

    public GetGroupMembersResponse hasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    /**
     * A Boolean value that indicates whether the group has more members than the response contains.
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

    public GetGroupMembersResponse unknownFields(Map<String, Object> unknownFields) {
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
        GetGroupMembersResponse getGroupMembersResponse = (GetGroupMembersResponse) o;
        return Objects.equals(this.members, getGroupMembersResponse.members) &&
                Objects.equals(this.paginationToken, getGroupMembersResponse.paginationToken) &&
                Objects.equals(this.hasMore, getGroupMembersResponse.hasMore) &&
                Objects.equals(this.unknownFields, getGroupMembersResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(members, paginationToken, hasMore, unknownFields);
    }

    @Override
    public String toString() {
        return "GetGroupMembersResponse{" +
                "members=" + members +
                ", paginationToken='" + paginationToken + '\'' +
                ", hasMore=" + hasMore +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
