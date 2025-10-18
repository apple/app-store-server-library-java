// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * A promotional offer and message you provide in a real-time response to your Get Retention Message endpoint.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/promotionaloffer">promotionalOffer</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionalOffer {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    private static final String SERIALIZED_NAME_PROMOTIONAL_OFFER_SIGNATURE_V2 = "promotionalOfferSignatureV2";
    private static final String SERIALIZED_NAME_PROMOTIONAL_OFFER_SIGNATURE_V1 = "promotionalOfferSignatureV1";
    @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER)
    private UUID messageIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_PROMOTIONAL_OFFER_SIGNATURE_V2)
    private String promotionalOfferSignatureV2;
    @JsonProperty(value = SERIALIZED_NAME_PROMOTIONAL_OFFER_SIGNATURE_V1)
    private PromotionalOfferSignatureV1 promotionalOfferSignatureV1;


    public PromotionalOffer() {
    }

    public PromotionalOffer messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
        return this;
    }

    /**
     * The identifier of the message to display to the customer, along with the promotional offer.
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

    public PromotionalOffer promotionalOfferSignatureV2(String promotionalOfferSignatureV2) {
        this.promotionalOfferSignatureV2 = promotionalOfferSignatureV2;
        return this;
    }

    /**
     * The promotional offer signature in V2 format.
     *
     * @return promotionalOfferSignatureV2
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/promotionaloffersignaturev2">promotionalOfferSignatureV2</a>
     **/
    public String getPromotionalOfferSignatureV2() {
        return promotionalOfferSignatureV2;
    }

    public void setPromotionalOfferSignatureV2(String promotionalOfferSignatureV2) {
        this.promotionalOfferSignatureV2 = promotionalOfferSignatureV2;
    }

    public PromotionalOffer promotionalOfferSignatureV1(PromotionalOfferSignatureV1 promotionalOfferSignatureV1) {
        this.promotionalOfferSignatureV1 = promotionalOfferSignatureV1;
        return this;
    }

    /**
     * The promotional offer signature in V1 format.
     *
     * @return promotionalOfferSignatureV1
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/promotionaloffersignaturev1">promotionalOfferSignatureV1</a>
     **/
    public PromotionalOfferSignatureV1 getPromotionalOfferSignatureV1() {
        return promotionalOfferSignatureV1;
    }

    public void setPromotionalOfferSignatureV1(PromotionalOfferSignatureV1 promotionalOfferSignatureV1) {
        this.promotionalOfferSignatureV1 = promotionalOfferSignatureV1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionalOffer that = (PromotionalOffer) o;
        return Objects.equals(messageIdentifier, that.messageIdentifier) &&
               Objects.equals(promotionalOfferSignatureV2, that.promotionalOfferSignatureV2) &&
               Objects.equals(promotionalOfferSignatureV1, that.promotionalOfferSignatureV1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier, promotionalOfferSignatureV2, promotionalOfferSignatureV1);
    }

    @Override
    public String toString() {
        return "PromotionalOffer{" +
                "messageIdentifier=" + messageIdentifier +
                ", promotionalOfferSignatureV2='" + promotionalOfferSignatureV2 + '\'' +
                ", promotionalOfferSignatureV1=" + promotionalOfferSignatureV1 +
                '}';
    }
}