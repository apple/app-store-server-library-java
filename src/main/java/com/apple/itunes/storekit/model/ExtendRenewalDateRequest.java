// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body that contains subscription-renewal-extension data for an individual subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendrenewaldaterequest">ExtendRenewalDateRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendRenewalDateRequest {
    private static final String SERIALIZED_NAME_EXTEND_BY_DAYS = "extendByDays";
    private static final String SERIALIZED_NAME_EXTEND_REASON_CODE = "extendReasonCode";
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";

    @JsonProperty(value = SERIALIZED_NAME_EXTEND_BY_DAYS, required = true)
    private Integer extendByDays;
    @JsonProperty(value = SERIALIZED_NAME_EXTEND_REASON_CODE, required = true)
    private Integer extendReasonCode;
    @JsonProperty(value = SERIALIZED_NAME_REQUEST_IDENTIFIER, required = true)
    private String requestIdentifier;

    private static final int MINIMUM_EXTEND_BY_DAYS = 1;
    private static final int MAXIMUM_EXTEND_BY_DAYS = 90;
    private static final int MAXIMUM_REQUEST_IDENTIFIER_LENGTH = 128;

    protected ExtendRenewalDateRequest() {
    }

    public ExtendRenewalDateRequest(Integer extendByDays, ExtendReasonCode extendReasonCode, String requestIdentifier) {
        this.extendByDays = validateExtendByDays(extendByDays);
        this.extendReasonCode = Objects.requireNonNull(extendReasonCode).getValue();
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
    }

    public ExtendRenewalDateRequest(Integer extendByDays, Integer rawExtendReasonCode, String requestIdentifier) {
        this.extendByDays = validateExtendByDays(extendByDays);
        this.extendReasonCode = Objects.requireNonNull(rawExtendReasonCode);
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
    }

    public ExtendRenewalDateRequest extendByDays(Integer extendByDays) {
        this.extendByDays = validateExtendByDays(extendByDays);
        return this;
    }

    /**
     * The number of days to extend the subscription renewal date.
     *
     * @return extendByDays
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendbydays">extendByDays</a>
     **/
    public Integer getExtendByDays() {
        return extendByDays;
    }

    public void setExtendByDays(Integer extendByDays) {
        this.extendByDays = validateExtendByDays(extendByDays);
    }

    private Integer validateExtendByDays(Integer extendByDays) {
        Objects.requireNonNull(extendByDays);
        if (extendByDays < MINIMUM_EXTEND_BY_DAYS || extendByDays > MAXIMUM_EXTEND_BY_DAYS) {
            throw new IllegalArgumentException("extendByDays must be between " + MINIMUM_EXTEND_BY_DAYS + " and " + MAXIMUM_EXTEND_BY_DAYS);
        }
        return extendByDays;
    }

    public ExtendRenewalDateRequest extendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = Objects.requireNonNull(extendReasonCode).getValue();
        return this;
    }

    /**
     * The reason code for the subscription date extension.
     *
     * @return extendReasonCode
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
     **/
    public ExtendReasonCode getExtendReasonCode() {
        return ExtendReasonCode.fromValue(extendReasonCode);
    }

    /**
     * @see #getExtendReasonCode()
     **/
    public Integer getRawExtendReasonCode() {
        return extendReasonCode;
    }

    public void setExtendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = Objects.requireNonNull(extendReasonCode).getValue();
    }

    public void setRawExtendReasonCode(Integer rawExtendReasonCode) {
        this.extendReasonCode = Objects.requireNonNull(rawExtendReasonCode);
    }

    public ExtendRenewalDateRequest requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
        return this;
    }

    /**
     * A string that contains a value you provide to uniquely identify this renewal-date extension request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = validateRequestIdentifier(requestIdentifier);
    }

    private String validateRequestIdentifier(String requestIdentifier) {
        Objects.requireNonNull(requestIdentifier);
        if (requestIdentifier.length() > MAXIMUM_REQUEST_IDENTIFIER_LENGTH) {
            throw new IllegalArgumentException("requestIdentifier length longer than maximum allowed");
        }
        return requestIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExtendRenewalDateRequest extendRenewalDateRequest = (ExtendRenewalDateRequest) o;
        return Objects.equals(this.extendByDays, extendRenewalDateRequest.extendByDays) &&
                Objects.equals(this.extendReasonCode, extendRenewalDateRequest.extendReasonCode) &&
                Objects.equals(this.requestIdentifier, extendRenewalDateRequest.requestIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extendByDays, extendReasonCode, requestIdentifier);
    }

    @Override
    public String toString() {
        return "ExtendRenewalDateRequest{" +
                "extendByDays=" + extendByDays +
                ", extendReasonCode=" + extendReasonCode +
                ", requestIdentifier='" + requestIdentifier + '\'' +
                '}';
    }
}
