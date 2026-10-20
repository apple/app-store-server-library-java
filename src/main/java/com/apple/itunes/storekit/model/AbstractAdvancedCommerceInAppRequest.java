// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractAdvancedCommerceInAppRequest<T extends AbstractAdvancedCommerceInAppRequest<T>> extends AdvancedCommerceRequest<T> implements AdvancedCommerceInAppRequest {

    private static final String SERIALIZED_NAME_OPERATION = "operation";
    private static final String SERIALIZED_NAME_VERSION = "version";

    @JsonProperty(value = SERIALIZED_NAME_OPERATION, required = true)
    private final String operation;
    @JsonProperty(value = SERIALIZED_NAME_VERSION, required = true)
    private final String version;

    protected AbstractAdvancedCommerceInAppRequest(String operation, String version) {
        this.operation = Objects.requireNonNull(operation);
        this.version = Objects.requireNonNull(version);
    }

    protected AbstractAdvancedCommerceInAppRequest(String operation, String version, AdvancedCommerceRequestInfo requestInfo) {
        super(requestInfo);
        this.operation = Objects.requireNonNull(operation);
        this.version = Objects.requireNonNull(version);
    }

    /**
     * The constant that represents the operation of this request.
     *
     * @return operation
     **/
    public String getOperation() {
        return operation;
    }

    /**
     * A number that represents the version of the data structure or Advanced Commerce API.
     *
     * @return version
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/version">version</a>
     **/
    public String getVersion() {
        return version;
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