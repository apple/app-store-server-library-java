// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The metadata to include in server requests.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    protected AdvancedCommerceRequestInfo() {
    }

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
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
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
     * The value of the advancedCommerceConsistencyToken that you receive in the JWSRenewalInfo renewal information for a subscription.
     *
     * @return consistencyToken
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
     **/
    public String getConsistencyToken() {
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
     * A UUID that you provide to uniquely identify each request.
     *
     * @return requestReferenceId
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
     **/
    public UUID getRequestReferenceId() {
        return requestReferenceId;
    }

    public void setRequestReferenceId(UUID requestReferenceId) {
        this.requestReferenceId = Objects.requireNonNull(requestReferenceId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedCommerceRequestInfo advancedCommerceRequestInfo = (AdvancedCommerceRequestInfo) o;
        return Objects.equals(this.appAccountToken, advancedCommerceRequestInfo.appAccountToken) &&
                Objects.equals(this.consistencyToken, advancedCommerceRequestInfo.consistencyToken) &&
                Objects.equals(this.requestReferenceId, advancedCommerceRequestInfo.requestReferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appAccountToken, consistencyToken, requestReferenceId);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceRequestInfo{" +
                "appAccountToken=" + appAccountToken +
                ", consistencyToken='" + consistencyToken + '\'' +
                ", requestReferenceId=" + requestReferenceId +
                '}';
    }
}
