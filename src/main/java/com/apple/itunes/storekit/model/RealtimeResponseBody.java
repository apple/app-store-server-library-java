// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * A response you provide to choose, in real time, a retention message the system displays to the customer.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimeresponsebody">RealtimeResponseBody</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RealtimeResponseBody {
    private static final String SERIALIZED_NAME_MESSAGE = "message";
    private static final String SERIALIZED_NAME_ALTERNATE_PRODUCT = "alternateProduct";
    private static final String SERIALIZED_NAME_PROMOTIONAL_OFFER = "promotionalOffer";
    @JsonProperty(value = SERIALIZED_NAME_MESSAGE)
    private Message message;
    @JsonProperty(value = SERIALIZED_NAME_ALTERNATE_PRODUCT)
    private AlternateProduct alternateProduct;
    @JsonProperty(value = SERIALIZED_NAME_PROMOTIONAL_OFFER)
    private PromotionalOffer promotionalOffer;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealtimeResponseBody that = (RealtimeResponseBody) o;
        return Objects.equals(message, that.message) &&
               Objects.equals(alternateProduct, that.alternateProduct) &&
               Objects.equals(promotionalOffer, that.promotionalOffer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, alternateProduct, promotionalOffer);
    }

    @Override
    public String toString() {
        return "RealtimeResponseBody{" +
                "message=" + message +
                ", alternateProduct=" + alternateProduct +
                ", promotionalOffer=" + promotionalOffer +
                '}';
    }
}