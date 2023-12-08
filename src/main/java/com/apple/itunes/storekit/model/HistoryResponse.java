// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains the customer’s transaction history for an app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/historyresponse">HistoryResponse</a>
 */
public class HistoryResponse {
    private static final String SERIALIZED_NAME_REVISION = "revision";
    private static final String SERIALIZED_NAME_HAS_MORE = "hasMore";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTIONS = "signedTransactions";
    @JsonProperty(SERIALIZED_NAME_REVISION)
    private String revision;
    @JsonProperty(SERIALIZED_NAME_HAS_MORE)
    private Boolean hasMore;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_SIGNED_TRANSACTIONS)
    private List<String> signedTransactions = null;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public HistoryResponse() {
    }

    public HistoryResponse revision(String revision) {
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

    public HistoryResponse hasMore(Boolean hasMore) {
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

    public HistoryResponse bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of an app.
     *
     * @return bundleId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/bundleid">bundleId</a>
     **/
    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public HistoryResponse appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * The unique identifier of an app in the App Store.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public HistoryResponse environment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
        return this;
    }

    /**
     * The server environment in which you’re making the request, whether sandbox or production.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
     **/
    public Environment getEnvironment() {
        return environment != null ? Environment.fromValue(environment) : null;
    }

    /**
     * @see #getEnvironment()
     */
    public String getRawEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
    }

    public void setRawEnvironment(String rawEnvironment) {
        this.environment = rawEnvironment;
    }

    public HistoryResponse signedTransactions(List<String> signedTransactions) {
        this.signedTransactions = signedTransactions;
        return this;
    }

    public HistoryResponse addSignedTransactionsItem(String signedTransactionsItem) {
        if (this.signedTransactions == null) {
            this.signedTransactions = new ArrayList<>();
        }
        this.signedTransactions.add(signedTransactionsItem);
        return this;
    }

    /**
     * An array of in-app purchase transactions for the customer, signed by Apple, in JSON Web Signature format.
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

    public HistoryResponse unknownFields(Map<String, Object> unknownFields) {
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
        HistoryResponse historyResponse = (HistoryResponse) o;
        return Objects.equals(this.revision, historyResponse.revision) &&
                Objects.equals(this.hasMore, historyResponse.hasMore) &&
                Objects.equals(this.bundleId, historyResponse.bundleId) &&
                Objects.equals(this.appAppleId, historyResponse.appAppleId) &&
                Objects.equals(this.environment, historyResponse.environment) &&
                Objects.equals(this.signedTransactions, historyResponse.signedTransactions) &&
                Objects.equals(this.unknownFields, historyResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(revision, hasMore, bundleId, appAppleId, environment, signedTransactions, unknownFields);
    }

    @Override
    public String toString() {
        return "HistoryResponse{" +
                "revision='" + revision + '\'' +
                ", hasMore=" + hasMore +
                ", bundleId='" + bundleId + '\'' +
                ", appAppleId=" + appAppleId +
                ", environment='" + environment + '\'' +
                ", signedTransactions=" + signedTransactions +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

