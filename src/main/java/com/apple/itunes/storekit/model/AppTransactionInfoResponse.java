// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A response that contains signed app transaction information for a customer.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/apptransactioninforesponse">AppTransactionInfoResponse</a>
 */
public class AppTransactionInfoResponse {
    private static final String SERIALIZED_NAME_SIGNED_APP_TRANSACTION_INFO = "signedAppTransactionInfo";

    @JsonProperty(SERIALIZED_NAME_SIGNED_APP_TRANSACTION_INFO)
    private String signedAppTransactionInfo;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AppTransactionInfoResponse() {
    }

    public AppTransactionInfoResponse signedAppTransactionInfo(String signedAppTransactionInfo) {
        this.signedAppTransactionInfo = signedAppTransactionInfo;
        return this;
    }

    /**
     * A customer’s app transaction information, signed by Apple, in JSON Web Signature (JWS) format.
     * 
     * @return signedAppTransactionInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsapptransaction">JWSAppTransaction</a>
     **/
    public String getSignedAppTransactionInfo() {
        return signedAppTransactionInfo;
    }

    public void setSignedAppTransactionInfo(String signedAppTransactionInfo) {
        this.signedAppTransactionInfo = signedAppTransactionInfo;
    }

    public AppTransactionInfoResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object.
     * 
     * @return A map of JSON keys to objects.
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
        AppTransactionInfoResponse that = (AppTransactionInfoResponse) o;
        return Objects.equals(this.signedAppTransactionInfo, that.signedAppTransactionInfo) &&
                Objects.equals(this.unknownFields, that.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedAppTransactionInfo, unknownFields);
    }

    @Override
    public String toString() {
        return "AppTransactionInfoResponse{" +
                "signedAppTransactionInfo='" + signedAppTransactionInfo + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}