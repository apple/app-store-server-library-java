// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains an array of signed JSON Web Signature (JWS) refunded transactions, and paging information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundhistoryresponse">RefundHistoryResponse</a>
 */
public class RefundHistoryResponse {
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTIONS = "signedTransactions";
    private static final String SERIALIZED_NAME_REVISION = "revision";
    private static final String SERIALIZED_NAME_HAS_MORE = "hasMore";
    @JsonProperty(SERIALIZED_NAME_SIGNED_TRANSACTIONS)
    private List<String> signedTransactions = null;
    @JsonProperty(SERIALIZED_NAME_REVISION)
    private String revision;
    @JsonProperty(SERIALIZED_NAME_HAS_MORE)
    private Boolean hasMore;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public RefundHistoryResponse() {
    }

    public RefundHistoryResponse signedTransactions(List<String> signedTransactions) {
        this.signedTransactions = signedTransactions;
        return this;
    }

    public RefundHistoryResponse addSignedTransactionsItem(String signedTransactionsItem) {
        if (this.signedTransactions == null) {
            this.signedTransactions = new ArrayList<>();
        }
        this.signedTransactions.add(signedTransactionsItem);
        return this;
    }

    /**
     * A list of up to 20 JWS transactions, or an empty array if the customer hasn&#39;t received any refunds in your app. The transactions are sorted in ascending order by revocationDate.
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

    public RefundHistoryResponse revision(String revision) {
        this.revision = revision;
        return this;
    }

    /**
     * A token you use in a query to request the next set of transactions for the customer.
     *
     * @return revision
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revision">revision</a>
     **/
    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public RefundHistoryResponse hasMore(Boolean hasMore) {
        this.hasMore = hasMore;
        return this;
    }

    /**
     * A Boolean value indicating whether the App Store has more transaction data.
     *
     * @return hasMore
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/hasmore">hasMore</a>
     **/
    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }


    public RefundHistoryResponse unknownFields(Map<String, Object> unknownFields) {
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
        RefundHistoryResponse refundHistoryResponse = (RefundHistoryResponse) o;
        return Objects.equals(this.signedTransactions, refundHistoryResponse.signedTransactions) &&
                Objects.equals(this.revision, refundHistoryResponse.revision) &&
                Objects.equals(this.hasMore, refundHistoryResponse.hasMore) &&
                Objects.equals(this.unknownFields, refundHistoryResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedTransactions, revision, hasMore, unknownFields);
    }

    @Override
    public String toString() {
        return "RefundHistoryResponse{" +
                "signedTransactions=" + signedTransactions +
                ", revision='" + revision + '\'' +
                ", hasMore=" + hasMore +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

