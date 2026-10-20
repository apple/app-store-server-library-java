// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains the groups a customer belongs to, and their role in each group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/getcustomergroupsresponse">GetCustomerGroupsResponse</a>
 **/
public class GetCustomerGroupsResponse {
    private static final String SERIALIZED_NAME_GROUPS = "groups";

    @JsonProperty(SERIALIZED_NAME_GROUPS)
    private List<GroupEntry> groups;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public GetCustomerGroupsResponse() {
    }

    public GetCustomerGroupsResponse groups(List<GroupEntry> groups) {
        this.groups = groups;
        return this;
    }

    public GetCustomerGroupsResponse addGroup(GroupEntry group) {
        Objects.requireNonNull(group);
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.add(group);
        return this;
    }

    /**
     * An array of groups that the customer belongs to.
     *
     * @return groups
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/groupentry">GroupEntry</a>
     **/
    public List<GroupEntry> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupEntry> groups) {
        this.groups = groups;
    }

    public GetCustomerGroupsResponse unknownFields(Map<String, Object> unknownFields) {
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
        GetCustomerGroupsResponse getCustomerGroupsResponse = (GetCustomerGroupsResponse) o;
        return Objects.equals(this.groups, getCustomerGroupsResponse.groups) &&
                Objects.equals(this.unknownFields, getCustomerGroupsResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groups, unknownFields);
    }

    @Override
    public String toString() {
        return "GetCustomerGroupsResponse{" +
                "groups=" + groups +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
