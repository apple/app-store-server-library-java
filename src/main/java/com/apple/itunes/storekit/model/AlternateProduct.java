// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * A switch-plan message and product ID you provide in a real-time response to your Get Retention Message endpoint.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/alternateproduct">alternateProduct</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlternateProduct {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER)
    private UUID messageIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_PRODUCT_ID)
    private String productId;


    public AlternateProduct() {
    }

    public AlternateProduct messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
        return this;
    }

    /**
     * The message identifier of the text to display in the switch-plan retention message.
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

    public AlternateProduct productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The product identifier of the subscription the retention message suggests for your customer to switch to.
     *
     * @return productId
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/productid">productId</a>
     **/
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlternateProduct that = (AlternateProduct) o;
        return Objects.equals(messageIdentifier, that.messageIdentifier) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier, productId);
    }

    @Override
    public String toString() {
        return "AlternateProduct{" +
                "messageIdentifier=" + messageIdentifier +
                ", productId='" + productId + '\'' +
                '}';
    }
}