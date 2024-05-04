// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that includes the order lookup status and an array of signed transactions for the in-app purchases in the order.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupresponse">OrderLookupResponse</a>
 */
public class OrderLookupResponse {
    private static final String SERIALIZED_NAME_STATUS = "status";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTIONS = "signedTransactions";
    @JsonProperty(SERIALIZED_NAME_STATUS)
    private Integer status;
    @JsonProperty(SERIALIZED_NAME_SIGNED_TRANSACTIONS)
    private List<String> signedTransactions = null;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public OrderLookupResponse() {
    }

    public OrderLookupResponse status(OrderLookupStatus status) {
        this.status = status != null ? status.getValue() : null;
        return this;
    }

    /**
     * The status that indicates whether the order ID is valid.
     *
     * @return status
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/orderlookupstatus">OrderLookupStatus</a>
     **/
    public OrderLookupStatus getStatus() {
        return status != null ? OrderLookupStatus.fromValue(status) : null;
    }

    /**
     * @see #getStatus()
     */
    public Integer getRawStatus() {
        return status;
    }

    public void setStatus(OrderLookupStatus status) {
        this.status = status != null ? status.getValue() : null;
    }

    public void setRawStatus(Integer rawStatus) {
        this.status = rawStatus;
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
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransaction">JWSTransaction</a>
     **/
    public List<String> getSignedTransactions() {
        return signedTransactions;
    }

    public void setSignedTransactions(List<String> signedTransactions) {
        this.signedTransactions = signedTransactions;
    }


    public OrderLookupResponse unknownFields(Map<String, Object> unknownFields) {
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
        OrderLookupResponse orderLookupResponse = (OrderLookupResponse) o;
        return Objects.equals(this.status, orderLookupResponse.status) &&
                Objects.equals(this.signedTransactions, orderLookupResponse.signedTransactions) &&
                Objects.equals(this.unknownFields, orderLookupResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, signedTransactions, unknownFields);
    }

    @Override
    public String toString() {
        return "OrderLookupResponse{" +
                "status=" + status +
                ", signedTransactions=" + signedTransactions +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

