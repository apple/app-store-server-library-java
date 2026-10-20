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
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlternateProduct {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_BILLING_PLAN_TYPE = "billingPlanType";

    @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER, required = true)
    private UUID messageIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_PRODUCT_ID, required = true)
    private String productId;
    @JsonProperty(SERIALIZED_NAME_BILLING_PLAN_TYPE)
    private String billingPlanType;

    protected AlternateProduct() {
    }

    public AlternateProduct(UUID messageIdentifier, String productId) {
        this.messageIdentifier = Objects.requireNonNull(messageIdentifier);
        this.productId = Objects.requireNonNull(productId);
    }

    public AlternateProduct messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = Objects.requireNonNull(messageIdentifier);
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
        this.messageIdentifier = Objects.requireNonNull(messageIdentifier);
    }

    public AlternateProduct productId(String productId) {
        this.productId = Objects.requireNonNull(productId);
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
        this.productId = Objects.requireNonNull(productId);
    }

    public AlternateProduct billingPlanType(BillingPlanType billingPlanType) {
        this.billingPlanType = billingPlanType != null ? billingPlanType.getValue() : null;
        return this;
    }

    /**
     * @return billingPlanType
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/billingplantype">billingPlanType</a>
     **/
    public BillingPlanType getBillingPlanType() {
        return BillingPlanType.fromValue(billingPlanType);
    }

    /**
     * @see #getBillingPlanType()
     **/
    public String getRawBillingPlanType() {
        return billingPlanType;
    }

    public void setBillingPlanType(BillingPlanType billingPlanType) {
        this.billingPlanType = billingPlanType != null ? billingPlanType.getValue() : null;
    }

    public void setRawBillingPlanType(String rawBillingPlanType) {
        this.billingPlanType = rawBillingPlanType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlternateProduct alternateProduct = (AlternateProduct) o;
        return Objects.equals(this.messageIdentifier, alternateProduct.messageIdentifier) &&
                Objects.equals(this.productId, alternateProduct.productId) &&
                Objects.equals(this.billingPlanType, alternateProduct.billingPlanType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier, productId, billingPlanType);
    }

    @Override
    public String toString() {
        return "AlternateProduct{" +
                "messageIdentifier=" + messageIdentifier +
                ", productId='" + productId + '\'' +
                ", billingPlanType='" + billingPlanType + '\'' +
                '}';
    }
}
