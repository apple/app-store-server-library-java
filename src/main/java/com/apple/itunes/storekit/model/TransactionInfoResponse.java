// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * A response that contains signed transaction information for a single transaction.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactioninforesponse">TransactionInfoResponse</a>
 */
public class TransactionInfoResponse {
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTION_INFO = "signedTransactionInfo";
    @SerializedName(SERIALIZED_NAME_SIGNED_TRANSACTION_INFO)
    private String signedTransactionInfo;


    public TransactionInfoResponse() {
    }

    public TransactionInfoResponse signedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
        return this;
    }

    /**
     * A customer’s in-app purchase transaction, signed by Apple, in JSON Web Signature (JWS) format.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionInfoResponse transactionInfoResponse = (TransactionInfoResponse) o;
        return Objects.equals(this.signedTransactionInfo, transactionInfoResponse.signedTransactionInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedTransactionInfo);
    }

    @Override
    public String toString() {
        return "TransactionInfoResponse{" +
                "signedTransactionInfo='" + signedTransactionInfo + '\'' +
                '}';
    }
}

