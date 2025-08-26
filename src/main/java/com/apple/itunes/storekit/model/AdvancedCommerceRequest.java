// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public abstract class AdvancedCommerceRequest<T extends AdvancedCommerceRequest<T>> {

    protected static final String SERIALIZED_NAME_REQUEST_INFO = "requestInfo";

    @JsonProperty(value = SERIALIZED_NAME_REQUEST_INFO, required = true)
    protected AdvancedCommerceRequestInfo requestInfo;

    protected AdvancedCommerceRequest() {}

    public AdvancedCommerceRequest(AdvancedCommerceRequestInfo requestInfo) {
        this.requestInfo = Objects.requireNonNull(requestInfo);
    }

    public T requestInfo(AdvancedCommerceRequestInfo requestInfo) {
        this.requestInfo = Objects.requireNonNull(requestInfo);
        return self();
    }

    /**
     * The metadata to include in server requests.
     *
     * @return requestInfo
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
     **/
    public AdvancedCommerceRequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(AdvancedCommerceRequestInfo requestInfo) {
        this.requestInfo = Objects.requireNonNull(requestInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvancedCommerceRequest<?> that = (AdvancedCommerceRequest<?>) o;
        return Objects.equals(requestInfo, that.requestInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(requestInfo);
    }

    protected abstract T self();
}