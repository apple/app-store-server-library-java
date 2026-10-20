// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * A response object you provide to present an offer or switch-plan recommendation message.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/advancedcommerceinfo">advancedCommerceInfo</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceInfo {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    private static final String SERIALIZED_NAME_ADVANCED_COMMERCE_DATA = "advancedCommerceData";

    @JsonProperty(SERIALIZED_NAME_MESSAGE_IDENTIFIER)
    private UUID messageIdentifier;
    @JsonProperty(SERIALIZED_NAME_ADVANCED_COMMERCE_DATA)
    private String advancedCommerceData;

    public AdvancedCommerceInfo() {
    }

    public AdvancedCommerceInfo messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
        return this;
    }

    /**
     * The identifier of the message to display to the customer, along with the offer or switch-plan recommendation provided in advancedCommerceData.
     *
     * @return messageIdentifier
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messageidentifier">messageIdentifier</a>
     **/
    public UUID getMessageIdentifier() {
        return messageIdentifier;
    }

    public void setMessageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
    }

    public AdvancedCommerceInfo advancedCommerceData(String advancedCommerceData) {
        this.advancedCommerceData = advancedCommerceData;
        return this;
    }

    /**
     * A Base64-encoded JSON object which contains a JWS describing an offer or switch-plan recommendation.
     *
     * @return advancedCommerceData
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/advancedcommercedata">advancedCommerceData</a>
     **/
    public String getAdvancedCommerceData() {
        return advancedCommerceData;
    }

    public void setAdvancedCommerceData(String advancedCommerceData) {
        this.advancedCommerceData = advancedCommerceData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedCommerceInfo advancedCommerceInfo = (AdvancedCommerceInfo) o;
        return Objects.equals(this.messageIdentifier, advancedCommerceInfo.messageIdentifier) &&
                Objects.equals(this.advancedCommerceData, advancedCommerceInfo.advancedCommerceData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier, advancedCommerceData);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceInfo{" +
                "messageIdentifier=" + messageIdentifier +
                ", advancedCommerceData='" + advancedCommerceData + '\'' +
                '}';
    }
}
