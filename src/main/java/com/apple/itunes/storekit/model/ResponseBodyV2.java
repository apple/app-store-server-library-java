// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The response body the App Store sends in a version 2 server notification.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/responsebodyv2"></a>
 */
public class ResponseBodyV2 {
    private static final String SERIALIZED_NAME_SIGNED_PAYLOAD = "signedPayload";
    @JsonProperty(SERIALIZED_NAME_SIGNED_PAYLOAD)
    private String signedPayload;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public ResponseBodyV2() {
    }

    public ResponseBodyV2 signedPayload(String signedPayload) {
        this.signedPayload = signedPayload;
        return this;
    }

    /**
     * A cryptographically signed payload, in JSON Web Signature (JWS) format, containing the response body for a version 2 notification.
     *
     * @return signedPayload
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/signedpayload">signedPayload</a>
     **/
    public String getSignedPayload() {
        return signedPayload;
    }

    public void setSignedPayload(String signedPayload) {
        this.signedPayload = signedPayload;
    }


    public ResponseBodyV2 unknownFields(Map<String, Object> unknownFields) {
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
        ResponseBodyV2 responseBodyV2 = (ResponseBodyV2) o;
        return Objects.equals(this.signedPayload, responseBodyV2.signedPayload) &&
                Objects.equals(this.unknownFields, responseBodyV2.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedPayload, unknownFields);
    }

    @Override
    public String toString() {
        return "ResponseBodyV2{" +
                "signedPayload='" + signedPayload + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

