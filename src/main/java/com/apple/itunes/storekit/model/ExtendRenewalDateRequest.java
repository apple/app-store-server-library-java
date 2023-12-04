// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body that contains subscription-renewal-extension data for an individual subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendrenewaldaterequest">ExtendRenewalDateRequest</a>
 */
public class ExtendRenewalDateRequest {
    private static final String SERIALIZED_NAME_EXTEND_BY_DAYS = "extendByDays";
    private static final String SERIALIZED_NAME_EXTEND_REASON_CODE = "extendReasonCode";
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    @JsonProperty(SERIALIZED_NAME_EXTEND_BY_DAYS)
    private Integer extendByDays;
    @JsonProperty(SERIALIZED_NAME_EXTEND_REASON_CODE)
    private ExtendReasonCode extendReasonCode;
    @JsonProperty(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;


    public ExtendRenewalDateRequest() {
    }

    public ExtendRenewalDateRequest extendByDays(Integer extendByDays) {
        this.extendByDays = extendByDays;
        return this;
    }

    /**
     * The number of days to extend the subscription renewal date.
     *
     * @return extendByDays
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendbydays">extendByDays</a>
     * maximum: 90
     **/
    public Integer getExtendByDays() {
        return extendByDays;
    }

    public void setExtendByDays(Integer extendByDays) {
        this.extendByDays = extendByDays;
    }

    public ExtendRenewalDateRequest extendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = extendReasonCode;
        return this;
    }

    /**
     * The reason code for the subscription date extension
     *
     * @return extendReasonCode
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendreasoncode">extendReasonCode</a>
     **/
    public ExtendReasonCode getExtendReasonCode() {
        return extendReasonCode;
    }

    public void setExtendReasonCode(ExtendReasonCode extendReasonCode) {
        this.extendReasonCode = extendReasonCode;
    }

    public ExtendRenewalDateRequest requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
        return this;
    }

    /**
     * A string that contains a unique identifier you provide to track each subscription-renewal-date extension request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
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

