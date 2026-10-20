// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A response you provide to choose, in real time, a retention message the system displays to the customer.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimeresponsebody">RealtimeResponseBody</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RealtimeResponseBody {
    private static final String SERIALIZED_NAME_MESSAGE = "message";
    private static final String SERIALIZED_NAME_ALTERNATE_PRODUCT = "alternateProduct";
    private static final String SERIALIZED_NAME_PROMOTIONAL_OFFER = "promotionalOffer";
    private static final String SERIALIZED_NAME_ADVANCED_COMMERCE_INFO = "advancedCommerceInfo";

    @JsonProperty(SERIALIZED_NAME_MESSAGE)
    private Message message;
    @JsonProperty(SERIALIZED_NAME_ALTERNATE_PRODUCT)
    private AlternateProduct alternateProduct;
    @JsonProperty(SERIALIZED_NAME_PROMOTIONAL_OFFER)
    private PromotionalOffer promotionalOffer;
    @JsonProperty(SERIALIZED_NAME_ADVANCED_COMMERCE_INFO)
    private AdvancedCommerceInfo advancedCommerceInfo;

    public RealtimeResponseBody() {
    }

    public RealtimeResponseBody message(Message message) {
        this.message = message;
        return this;
    }

    /**
     * A retention message that’s text-based and can include an optional image.
     *
     * @return message
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/message">message</a>
     **/
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public RealtimeResponseBody alternateProduct(AlternateProduct alternateProduct) {
        this.alternateProduct = alternateProduct;
        return this;
    }

    /**
     * A retention message with a switch-plan option.
     *
     * @return alternateProduct
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/alternateproduct">alternateProduct</a>
     **/
    public AlternateProduct getAlternateProduct() {
        return alternateProduct;
    }

    public void setAlternateProduct(AlternateProduct alternateProduct) {
        this.alternateProduct = alternateProduct;
    }

    public RealtimeResponseBody promotionalOffer(PromotionalOffer promotionalOffer) {
        this.promotionalOffer = promotionalOffer;
        return this;
    }

    /**
     * A retention message that includes a promotional offer.
     *
     * @return promotionalOffer
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/promotionaloffer">promotionalOffer</a>
     **/
    public PromotionalOffer getPromotionalOffer() {
        return promotionalOffer;
    }

    public void setPromotionalOffer(PromotionalOffer promotionalOffer) {
        this.promotionalOffer = promotionalOffer;
    }

    public RealtimeResponseBody advancedCommerceInfo(AdvancedCommerceInfo advancedCommerceInfo) {
        this.advancedCommerceInfo = advancedCommerceInfo;
        return this;
    }

    /**
     * A retention offer or switch plan option.
     *
     * @return advancedCommerceInfo
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/advancedcommerceinfo">advancedCommerceInfo</a>
     **/
    public AdvancedCommerceInfo getAdvancedCommerceInfo() {
        return advancedCommerceInfo;
    }

    public void setAdvancedCommerceInfo(AdvancedCommerceInfo advancedCommerceInfo) {
        this.advancedCommerceInfo = advancedCommerceInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealtimeResponseBody realtimeResponseBody = (RealtimeResponseBody) o;
        return Objects.equals(this.message, realtimeResponseBody.message) &&
                Objects.equals(this.alternateProduct, realtimeResponseBody.alternateProduct) &&
                Objects.equals(this.promotionalOffer, realtimeResponseBody.promotionalOffer) &&
                Objects.equals(this.advancedCommerceInfo, realtimeResponseBody.advancedCommerceInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, alternateProduct, promotionalOffer, advancedCommerceInfo);
    }

    @Override
    public String toString() {
        return "RealtimeResponseBody{" +
                "message=" + message +
                ", alternateProduct=" + alternateProduct +
                ", promotionalOffer=" + promotionalOffer +
                ", advancedCommerceInfo=" + advancedCommerceInfo +
                '}';
    }
}
