// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The request body the App Store server sends to your Get Retention Message endpoint.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimerequestbody">RealtimeRequestBody</a>
 */
public class RealtimeRequestBody {
    private static final String SERIALIZED_NAME_SIGNED_PAYLOAD = "signedPayload";
    @JsonProperty(SERIALIZED_NAME_SIGNED_PAYLOAD)
    private String signedPayload;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public RealtimeRequestBody() {
    }

    public RealtimeRequestBody signedPayload(String signedPayload) {
        this.signedPayload = signedPayload;
        return this;
    }

    /**
     * The payload in JSON Web Signature (JWS) format, signed by the App Store.
     *
     * @return signedPayload
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/signedpayload">signedPayload</a>
     **/
    public String getSignedPayload() {
        return signedPayload;
    }

    public void setSignedPayload(String signedPayload) {
        this.signedPayload = signedPayload;
    }


    public RealtimeRequestBody unknownFields(Map<String, Object> unknownFields) {
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
        RealtimeRequestBody responseBodyV2 = (RealtimeRequestBody) o;
        return Objects.equals(this.signedPayload, responseBodyV2.signedPayload) &&
                Objects.equals(this.unknownFields, responseBodyV2.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedPayload, unknownFields);
    }

    @Override
    public String toString() {
        return "RealtimeRequestBody{" +
                "signedPayload='" + signedPayload + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

