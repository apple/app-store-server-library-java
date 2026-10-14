// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The most recent App Store-signed transaction information and App Store-signed renewal information for an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lasttransactionsitem">lastTransactionsItem</a>
 **/
public class LastTransactionsItem {
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_STATUS = "status";
    private static final String SERIALIZED_NAME_SIGNED_RENEWAL_INFO = "signedRenewalInfo";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTION_INFO = "signedTransactionInfo";

    @JsonProperty(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @JsonProperty(SERIALIZED_NAME_STATUS)
    private Integer status;
    @JsonProperty(SERIALIZED_NAME_SIGNED_RENEWAL_INFO)
    private String signedRenewalInfo;
    @JsonProperty(SERIALIZED_NAME_SIGNED_TRANSACTION_INFO)
    private String signedTransactionInfo;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public LastTransactionsItem() {
    }

    public LastTransactionsItem originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
        return this;
    }

    /**
     * The original transaction identifier of the auto-renewable subscription.
     *
     * @return originalTransactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originaltransactionid">originalTransactionId</a>
     **/
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public LastTransactionsItem status(Status status) {
        this.status = status != null ? status.getValue() : null;
        return this;
    }

    /**
     * The status of the auto-renewable subscription.
     *
     * @return status
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/status">status</a>
     **/
    public Status getStatus() {
        return Status.fromValue(status);
    }

    /**
     * @see #getStatus()
     **/
    public Integer getRawStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status != null ? status.getValue() : null;
    }

    public void setRawStatus(Integer rawStatus) {
        this.status = rawStatus;
    }

    public LastTransactionsItem signedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
        return this;
    }

    /**
     * The subscription renewal information signed by the App Store, in JSON Web Signature (JWS) format.
     *
     * @return signedRenewalInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsrenewalinfo">JWSRenewalInfo</a>
     **/
    public String getSignedRenewalInfo() {
        return signedRenewalInfo;
    }

    public void setSignedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
    }

    public LastTransactionsItem signedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
        return this;
    }

    /**
     * The transaction information signed by the App Store, in JWS format.
     *
     * @return signedTransactionInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransaction">JWSTransaction</a>
     **/
    public String getSignedTransactionInfo() {
        return signedTransactionInfo;
    }

    public void setSignedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
    }

    public LastTransactionsItem unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object
     *
     * @return A map of JSON keys to objects
     **/
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
        LastTransactionsItem lastTransactionsItem = (LastTransactionsItem) o;
        return Objects.equals(this.originalTransactionId, lastTransactionsItem.originalTransactionId) &&
                Objects.equals(this.status, lastTransactionsItem.status) &&
                Objects.equals(this.signedRenewalInfo, lastTransactionsItem.signedRenewalInfo) &&
                Objects.equals(this.signedTransactionInfo, lastTransactionsItem.signedTransactionInfo) &&
                Objects.equals(this.unknownFields, lastTransactionsItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalTransactionId, status, signedRenewalInfo, signedTransactionInfo, unknownFields);
    }

    @Override
    public String toString() {
        return "LastTransactionsItem{" +
                "originalTransactionId='" + originalTransactionId + '\'' +
                ", status=" + status +
                ", signedRenewalInfo='" + signedRenewalInfo + '\'' +
                ", signedTransactionInfo='" + signedTransactionInfo + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
