// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;
import java.util.UUID;

/**
 * The promotional offer signature you generate using an earlier signature version.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/promotionaloffersignaturev1">promotionalOfferSignatureV1</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionalOfferSignatureV1 {
    private static final String SERIALIZED_NAME_ENCODED_SIGNATURE = "encodedSignature";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_NONCE = "nonce";
    private static final String SERIALIZED_NAME_TIMESTAMP = "timestamp";
    private static final String SERIALIZED_NAME_KEY_ID = "keyId";
    private static final String SERIALIZED_NAME_OFFER_IDENTIFIER = "offerIdentifier";
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    @JsonProperty(value = SERIALIZED_NAME_ENCODED_SIGNATURE, required = true)
    private String encodedSignature;
    @JsonProperty(value = SERIALIZED_NAME_PRODUCT_ID, required = true)
    private String productId;
    @JsonProperty(value = SERIALIZED_NAME_NONCE, required = true)
    @JsonSerialize(using = UUIDLowercaseSerializer.class)
    private UUID nonce;
    @JsonProperty(value = SERIALIZED_NAME_TIMESTAMP, required = true)
    private Long timestamp;
    @JsonProperty(value = SERIALIZED_NAME_KEY_ID, required = true)
    private String keyId;
    @JsonProperty(value = SERIALIZED_NAME_OFFER_IDENTIFIER, required = true)
    private String offerIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    @JsonSerialize(using = UUIDLowercaseSerializer.class)
    private UUID appAccountToken;


    private PromotionalOfferSignatureV1() {
    }

    public PromotionalOfferSignatureV1(String encodedSignature,
                                       String productId,
                                       UUID nonce,
                                       Long timestamp,
                                       String keyId,
                                       String offerIdentifier) {
        this.encodedSignature = Objects.requireNonNull(encodedSignature);
        this.productId = Objects.requireNonNull(productId);
        this.nonce = Objects.requireNonNull(nonce);
        this.timestamp = Objects.requireNonNull(timestamp);
        this.keyId = Objects.requireNonNull(keyId);
        this.offerIdentifier = Objects.requireNonNull(offerIdentifier);
    }

    public PromotionalOfferSignatureV1 encodedSignature(String encodedSignature) {
        this.encodedSignature = Objects.requireNonNull(encodedSignature);
        return this;
    }

    /**
     * The Base64-encoded cryptographic signature you generate using the offer parameters.
     *
     * @return encodedSignature
     **/
    public String getEncodedSignature() {
        return encodedSignature;
    }

    public void setEncodedSignature(String encodedSignature) {
        this.encodedSignature = Objects.requireNonNull(encodedSignature);
    }

    public PromotionalOfferSignatureV1 productId(String productId) {
        this.productId = Objects.requireNonNull(productId);
        return this;
    }

    /**
     * The subscription’s product identifier.
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

    public PromotionalOfferSignatureV1 nonce(UUID nonce) {
        this.nonce = Objects.requireNonNull(nonce);
        return this;
    }

    /**
     * A one-time-use UUID antireplay value you generate.
     *
     * @return nonce
     **/
    public UUID getNonce() {
        return nonce;
    }

    public void setNonce(UUID nonce) {
        this.nonce = Objects.requireNonNull(nonce);
    }

    public PromotionalOfferSignatureV1 timestamp(Long timestamp) {
        this.timestamp = Objects.requireNonNull(timestamp);
        return this;
    }

    /**
     * The UNIX time, in milliseconds, when you generate the signature.
     *
     * @return timestamp
     **/
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = Objects.requireNonNull(timestamp);
    }

    public PromotionalOfferSignatureV1 keyId(String keyId) {
        this.keyId = Objects.requireNonNull(keyId);
        return this;
    }

    /**
     * A string that identifies the private key you use to generate the signature.
     *
     * @return keyId
     **/
    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = Objects.requireNonNull(keyId);
    }

    public PromotionalOfferSignatureV1 offerIdentifier(String offerIdentifier) {
        this.offerIdentifier = Objects.requireNonNull(offerIdentifier);
        return this;
    }

    /**
     * The subscription offer identifier that you set up in App Store Connect.
     *
     * @return offerIdentifier
     **/
    public String getOfferIdentifier() {
        return offerIdentifier;
    }

    public void setOfferIdentifier(String offerIdentifier) {
        this.offerIdentifier = Objects.requireNonNull(offerIdentifier);
    }

    public PromotionalOfferSignatureV1 appAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * A UUID that you provide to associate with the transaction if the customer accepts the promotional offer.
     *
     * @return appAccountToken
     **/
    public UUID getAppAccountToken() {
        return appAccountToken;
    }

    public void setAppAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PromotionalOfferSignatureV1 that = (PromotionalOfferSignatureV1) o;
        return Objects.equals(encodedSignature, that.encodedSignature) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(nonce, that.nonce) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(keyId, that.keyId) &&
                Objects.equals(offerIdentifier, that.offerIdentifier) &&
                Objects.equals(appAccountToken, that.appAccountToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encodedSignature, productId, nonce, timestamp, keyId, offerIdentifier, appAccountToken);
    }

    @Override
    public String toString() {
        return "PromotionalOfferSignatureV1{" +
                "encodedSignature='" + encodedSignature + '\'' +
                ", productId='" + productId + '\'' +
                ", nonce=" + nonce +
                ", timestamp=" + timestamp +
                ", keyId='" + keyId + '\'' +
                ", offerIdentifier='" + offerIdentifier + '\'' +
                ", appAccountToken=" + appAccountToken +
                '}';
    }
}