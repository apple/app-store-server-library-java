// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A response that indicates the server successfully received the subscription-renewal-date extension request.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/massextendrenewaldateresponse">MassExtendRenewalDateResponse</a>
 */
public class MassExtendRenewalDateResponse {
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    @JsonProperty(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public MassExtendRenewalDateResponse() {
    }

    public MassExtendRenewalDateResponse requestIdentifier(String requestIdentifier) {
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


    public MassExtendRenewalDateResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     Fields that are not recognized for this object

     @return A map of JSON keys to objects
     */
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
        MassExtendRenewalDateResponse massExtendRenewalDateResponse = (MassExtendRenewalDateResponse) o;
        return Objects.equals(this.requestIdentifier, massExtendRenewalDateResponse.requestIdentifier) &&
                Objects.equals(this.unknownFields, massExtendRenewalDateResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestIdentifier, unknownFields);
    }

    @Override
    public String toString() {
        return "MassExtendRenewalDateResponse{" +
                "requestIdentifier='" + requestIdentifier + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

