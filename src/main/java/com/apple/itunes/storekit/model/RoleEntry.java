// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A customer’s role for a single product within a group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/roleentry">RoleEntry</a>
 **/
public class RoleEntry {
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_ROLE = "role";

    @JsonProperty(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;
    @JsonProperty(SERIALIZED_NAME_ROLE)
    private String role;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public RoleEntry() {
    }

    public RoleEntry productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The product identifier of the in-app purchase that the role applies to.
     *
     * @return productId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/productid">productId</a>
     **/
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public RoleEntry role(Role role) {
        this.role = role != null ? role.getValue() : null;
        return this;
    }

    /**
     * The customer’s role for the product.
     *
     * @return role
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/role">role</a>
     **/
    public Role getRole() {
        return Role.fromValue(role);
    }

    /**
     * @see #getRole()
     **/
    public String getRawRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role != null ? role.getValue() : null;
    }

    public void setRawRole(String rawRole) {
        this.role = rawRole;
    }

    public RoleEntry unknownFields(Map<String, Object> unknownFields) {
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
        RoleEntry roleEntry = (RoleEntry) o;
        return Objects.equals(this.productId, roleEntry.productId) &&
                Objects.equals(this.role, roleEntry.role) &&
                Objects.equals(this.unknownFields, roleEntry.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, role, unknownFields);
    }

    @Override
    public String toString() {
        return "RoleEntry{" +
                "productId='" + productId + '\'' +
                ", role='" + role + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
