// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * The most recent App Store-signed transaction information and App Store-signed renewal information for an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lasttransactionsitem">lastTransactionsItem</a>
 */
public class LastTransactionsItem {
    private static final String SERIALIZED_NAME_STATUS = "status";
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTION_INFO = "signedTransactionInfo";
    private static final String SERIALIZED_NAME_SIGNED_RENEWAL_INFO = "signedRenewalInfo";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private Status status;
    @SerializedName(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @SerializedName(SERIALIZED_NAME_SIGNED_TRANSACTION_INFO)
    private String signedTransactionInfo;
    @SerializedName(SERIALIZED_NAME_SIGNED_RENEWAL_INFO)
    private String signedRenewalInfo;


    public LastTransactionsItem() {
    }

    public LastTransactionsItem status(Status status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the auto-renewable subscription.
     *
     * @return status
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/status">status</a>
     **/
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LastTransactionsItem originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
        return this;
    }

    /**
     * The original transaction identifier of a purchase.
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

    public LastTransactionsItem signedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
        return this;
    }

    /**
     * Transaction information signed by the App Store, in JSON Web Signature (JWS) format.
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

    public LastTransactionsItem signedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
        return this;
    }

    /**
     * Subscription renewal information, signed by the App Store, in JSON Web Signature (JWS) format.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LastTransactionsItem lastTransactionsItem = (LastTransactionsItem) o;
        return Objects.equals(this.status, lastTransactionsItem.status) &&
                Objects.equals(this.originalTransactionId, lastTransactionsItem.originalTransactionId) &&
                Objects.equals(this.signedTransactionInfo, lastTransactionsItem.signedTransactionInfo) &&
                Objects.equals(this.signedRenewalInfo, lastTransactionsItem.signedRenewalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, originalTransactionId, signedTransactionInfo, signedRenewalInfo);
    }

    @Override
    public String toString() {
        return "LastTransactionsItem{" +
                "status=" + status +
                ", originalTransactionId='" + originalTransactionId + '\'' +
                ", signedTransactionInfo='" + signedTransactionInfo + '\'' +
                ", signedRenewalInfo='" + signedRenewalInfo + '\'' +
                '}';
    }
}

