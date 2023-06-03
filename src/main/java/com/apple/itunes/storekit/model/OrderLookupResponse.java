// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A response that includes the order lookup status and an array of signed transactions for the in-app purchases in the order.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupresponse">OrderLookupResponse</a>
 */
public class OrderLookupResponse {
    private static final String SERIALIZED_NAME_STATUS = "status";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTIONS = "signedTransactions";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private OrderLookupStatus status;
    @SerializedName(SERIALIZED_NAME_SIGNED_TRANSACTIONS)
    private List<String> signedTransactions = null;


    public OrderLookupResponse() {
    }

    public OrderLookupResponse status(OrderLookupStatus status) {
        this.status = status;
        return this;
    }

    /**
     * The status that indicates whether the order ID is valid.
     *
     * @return status
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupstatus">OrderLookupStatus</a>
     **/
    public OrderLookupStatus getStatus() {
        return status;
    }

    public void setStatus(OrderLookupStatus status) {
        this.status = status;
    }

    public OrderLookupResponse signedTransactions(List<String> signedTransactions) {
        this.signedTransactions = signedTransactions;
        return this;
    }

    public OrderLookupResponse addSignedTransactionsItem(String signedTransactionsItem) {
        if (this.signedTransactions == null) {
            this.signedTransactions = new ArrayList<>();
        }
        this.signedTransactions.add(signedTransactionsItem);
        return this;
    }

    /**
     * An array of in-app purchase transactions that are part of order, signed by Apple, in JSON Web Signature format.
     *
     * @return signedTransactions
     **/
    public List<String> getSignedTransactions() {
        return signedTransactions;
    }

    public void setSignedTransactions(List<String> signedTransactions) {
        this.signedTransactions = signedTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderLookupResponse orderLookupResponse = (OrderLookupResponse) o;
        return Objects.equals(this.status, orderLookupResponse.status) &&
                Objects.equals(this.signedTransactions, orderLookupResponse.signedTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, signedTransactions);
    }

    @Override
    public String toString() {
        return "OrderLookupResponse{" +
                "status=" + status +
                ", signedTransactions=" + signedTransactions +
                '}';
    }
}

