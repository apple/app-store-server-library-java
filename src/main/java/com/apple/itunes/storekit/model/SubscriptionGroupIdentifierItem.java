// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Information for auto-renewable subscriptions, including signed transaction information and signed renewal information, for one subscription group.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptiongroupidentifieritem">SubscriptionGroupIdentifierItem</a>
 **/
public class SubscriptionGroupIdentifierItem {
    private static final String SERIALIZED_NAME_SUBSCRIPTION_GROUP_IDENTIFIER = "subscriptionGroupIdentifier";
    private static final String SERIALIZED_NAME_LAST_TRANSACTIONS = "lastTransactions";

    @JsonProperty(SERIALIZED_NAME_SUBSCRIPTION_GROUP_IDENTIFIER)
    private String subscriptionGroupIdentifier;
    @JsonProperty(SERIALIZED_NAME_LAST_TRANSACTIONS)
    private List<LastTransactionsItem> lastTransactions;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public SubscriptionGroupIdentifierItem() {
    }

    public SubscriptionGroupIdentifierItem subscriptionGroupIdentifier(String subscriptionGroupIdentifier) {
        this.subscriptionGroupIdentifier = subscriptionGroupIdentifier;
        return this;
    }

    /**
     * The subscription group identifier of the auto-renewable subscriptions in the lastTransactions array.
     *
     * @return subscriptionGroupIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptiongroupidentifier">subscriptionGroupIdentifier</a>
     **/
    public String getSubscriptionGroupIdentifier() {
        return subscriptionGroupIdentifier;
    }

    public void setSubscriptionGroupIdentifier(String subscriptionGroupIdentifier) {
        this.subscriptionGroupIdentifier = subscriptionGroupIdentifier;
    }

    public SubscriptionGroupIdentifierItem lastTransactions(List<LastTransactionsItem> lastTransactions) {
        this.lastTransactions = lastTransactions;
        return this;
    }

    public SubscriptionGroupIdentifierItem addLastTransaction(LastTransactionsItem lastTransaction) {
        Objects.requireNonNull(lastTransaction);
        if (this.lastTransactions == null) {
            this.lastTransactions = new ArrayList<>();
        }
        this.lastTransactions.add(lastTransaction);
        return this;
    }

    /**
     * An array of the most recent App Store-signed transaction information and App Store-signed renewal information for all auto-renewable subscriptions in the subscription group.
     *
     * @return lastTransactions
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lasttransactionsitem">lastTransactionsItem</a>
     **/
    public List<LastTransactionsItem> getLastTransactions() {
        return lastTransactions;
    }

    public void setLastTransactions(List<LastTransactionsItem> lastTransactions) {
        this.lastTransactions = lastTransactions;
    }

    public SubscriptionGroupIdentifierItem unknownFields(Map<String, Object> unknownFields) {
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
        SubscriptionGroupIdentifierItem subscriptionGroupIdentifierItem = (SubscriptionGroupIdentifierItem) o;
        return Objects.equals(this.subscriptionGroupIdentifier, subscriptionGroupIdentifierItem.subscriptionGroupIdentifier) &&
                Objects.equals(this.lastTransactions, subscriptionGroupIdentifierItem.lastTransactions) &&
                Objects.equals(this.unknownFields, subscriptionGroupIdentifierItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptionGroupIdentifier, lastTransactions, unknownFields);
    }

    @Override
    public String toString() {
        return "SubscriptionGroupIdentifierItem{" +
                "subscriptionGroupIdentifier='" + subscriptionGroupIdentifier + '\'' +
                ", lastTransactions=" + lastTransactions +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
