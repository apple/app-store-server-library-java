// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The metadata to include in server requests.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
 */
public class AdvancedCommerceRequestInfo {
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    private static final String SERIALIZED_NAME_CONSISTENCY_TOKEN = "consistencyToken";
    private static final String SERIALIZED_NAME_REQUEST_REFERENCE_ID = "requestReferenceId";

    @JsonProperty(SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    private UUID appAccountToken;
    @JsonProperty(SERIALIZED_NAME_CONSISTENCY_TOKEN)
    private String consistencyToken;
    @JsonProperty(value = SERIALIZED_NAME_REQUEST_REFERENCE_ID, required = true)
    private UUID requestReferenceId;

    private AdvancedCommerceRequestInfo() {}

    public AdvancedCommerceRequestInfo(UUID requestReferenceId) {
        this.requestReferenceId = Objects.requireNonNull(requestReferenceId);
    }

    public AdvancedCommerceRequestInfo appAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * A UUID that represents an app account token, to associate with the transaction in the request.
     * 
     * @return appAccountToken
     **/
    public UUID getAppAccountToken() {
        return appAccountToken;
    }

    public void setAppAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
    }

    public AdvancedCommerceRequestInfo consistencyToken(String consistencyToken) {
        this.consistencyToken = consistencyToken;
        return this;
    }

    /**
     * The value of the advancedCommerceConsistencyToken that you receive in the JWSRenewalInfo renewal information for a subscription. Don’t generate this value.
     * 
     * @return consistencyToken
     * @see <a href="https://developer.apple.com/documentation/AppStoreServerAPI/advancedCommerceConsistencyToken">advancedCommerceConsistencyToken</a>
     **/
    public String consistencyToken() {
        return consistencyToken;
    }

    public void setConsistencyToken(String consistencyToken) {
        this.consistencyToken = consistencyToken;
    }

    public AdvancedCommerceRequestInfo requestReferenceId(UUID requestReferenceId) {
        this.requestReferenceId = Objects.requireNonNull(requestReferenceId);
        return this;
    }

    /**
     * A UUID that you provide to uniquely identify each request. If the request times out, you can use the same requestReferenceId value to retry the request. Otherwise, provide a unique value.
     * 
     * @return requestReferenceId
     **/
    public UUID getRequestReferenceId() {
        return requestReferenceId;
    }

    public void setRequestReferenceId(UUID requestReferenceId) {
        this.requestReferenceId = Objects.requireNonNull(requestReferenceId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvancedCommerceRequestInfo that = (AdvancedCommerceRequestInfo) o;
        return Objects.equals(appAccountToken, that.appAccountToken) && Objects.equals(consistencyToken, that.consistencyToken) && Objects.equals(requestReferenceId, that.requestReferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appAccountToken, consistencyToken, requestReferenceId);
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "appAccountToken=" + appAccountToken +
                ", consistencyToken='" + consistencyToken + '\'' +
                ", requestReferenceId=" + requestReferenceId +
                '}';
    }
}