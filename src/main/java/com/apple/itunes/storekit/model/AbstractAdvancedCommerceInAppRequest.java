// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public abstract class AbstractAdvancedCommerceInAppRequest<T extends AbstractAdvancedCommerceInAppRequest<T>> extends AdvancedCommerceRequest<T> implements AdvancedCommerceInAppRequest {

    private static final String SERIALIZED_NAME_OPERATION = "operation";
    private static final String SERIALIZED_NAME_VERSION = "version";

    @JsonProperty(value = SERIALIZED_NAME_OPERATION, required = true)
    private final String operation;
    @JsonProperty(value = SERIALIZED_NAME_VERSION, required = true)
    private final String version;

    protected AbstractAdvancedCommerceInAppRequest() {
        this.operation = null;
        this.version = null;
    }

    protected AbstractAdvancedCommerceInAppRequest(String operation, String version, AdvancedCommerceRequestInfo requestInfo) {
        super(requestInfo);
        this.operation = Objects.requireNonNull(operation);
        this.version = Objects.requireNonNull(version);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractAdvancedCommerceInAppRequest<?> that = (AbstractAdvancedCommerceInAppRequest<?>) o;
        return Objects.equals(operation, that.operation) && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operation, version);
    }

    protected abstract T self();
}