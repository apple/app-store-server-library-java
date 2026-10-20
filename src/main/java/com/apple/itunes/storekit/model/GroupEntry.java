// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The identifier, type, and per-product roles for a group that a customer belongs to.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/groupentry">GroupEntry</a>
 **/
public class GroupEntry {
    private static final String SERIALIZED_NAME_GROUP_ID = "groupId";
    private static final String SERIALIZED_NAME_GROUP_TYPE = "groupType";
    private static final String SERIALIZED_NAME_ROLES = "roles";

    @JsonProperty(SERIALIZED_NAME_GROUP_ID)
    private String groupId;
    @JsonProperty(SERIALIZED_NAME_GROUP_TYPE)
    private String groupType;
    @JsonProperty(SERIALIZED_NAME_ROLES)
    private List<RoleEntry> roles;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public GroupEntry() {
    }

    public GroupEntry groupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * The identifier of the group.
     *
     * @return groupId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/groupid">groupId</a>
     **/
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public GroupEntry groupType(GroupType groupType) {
        this.groupType = groupType != null ? groupType.getValue() : null;
        return this;
    }

    /**
     * The type of the group.
     *
     * @return groupType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/grouptype">groupType</a>
     **/
    public GroupType getGroupType() {
        return GroupType.fromValue(groupType);
    }

    /**
     * @see #getGroupType()
     **/
    public String getRawGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
        this.groupType = groupType != null ? groupType.getValue() : null;
    }

    public void setRawGroupType(String rawGroupType) {
        this.groupType = rawGroupType;
    }

    public GroupEntry roles(List<RoleEntry> roles) {
        this.roles = roles;
        return this;
    }

    public GroupEntry addRole(RoleEntry role) {
        Objects.requireNonNull(role);
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
        return this;
    }

    /**
     * An optional array of the customer’s roles in this group, one for each of your products that the group provides access to.
     *
     * @return roles
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/roleentry">RoleEntry</a>
     **/
    public List<RoleEntry> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntry> roles) {
        this.roles = roles;
    }

    public GroupEntry unknownFields(Map<String, Object> unknownFields) {
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
        GroupEntry groupEntry = (GroupEntry) o;
        return Objects.equals(this.groupId, groupEntry.groupId) &&
                Objects.equals(this.groupType, groupEntry.groupType) &&
                Objects.equals(this.roles, groupEntry.roles) &&
                Objects.equals(this.unknownFields, groupEntry.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupType, roles, unknownFields);
    }

    @Override
    public String toString() {
        return "GroupEntry{" +
                "groupId='" + groupId + '\'' +
                ", groupType='" + groupType + '\'' +
                ", roles=" + roles +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
