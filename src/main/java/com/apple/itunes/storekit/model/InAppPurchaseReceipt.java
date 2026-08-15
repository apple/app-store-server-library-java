// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A decoded in-app purchase attribute from a legacy App Store receipt.
 *
 * @see <a href="https://developer.apple.com/documentation/appstorereceipts/responsebody/receipt/in_app">in_app</a>
 */
public class InAppPurchaseReceipt {

    private Long quantity;
    private String productId;
    private String transactionId;
    private String originalTransactionId;
    private Long purchaseDate;
    private Long originalPurchaseDate;
    private Long expiresDate;
    private Long cancellationDate;
    private Long webOrderLineItemId;
    private Boolean isInIntroOfferPeriod;
    private Map<Integer, List<byte[]>> unknownAttributes;

    public InAppPurchaseReceipt() {
    }

    public InAppPurchaseReceipt quantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * The number of items purchased.
     *
     * @return quantity
     */
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public InAppPurchaseReceipt productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The unique identifier of the product purchased.
     *
     * @return productId
     */
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public InAppPurchaseReceipt transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * The unique identifier of the transaction.
     *
     * @return transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public InAppPurchaseReceipt originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
        return this;
    }

    /**
     * The unique identifier of the original transaction.
     *
     * @return originalTransactionId
     */
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public InAppPurchaseReceipt purchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    /**
     * The time of the purchase, in UNIX time, in milliseconds.
     *
     * @return purchaseDate
     */
    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public InAppPurchaseReceipt originalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
        return this;
    }

    /**
     * The time of the original purchase, in UNIX time, in milliseconds.
     *
     * @return originalPurchaseDate
     */
    public Long getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public void setOriginalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
    }

    public InAppPurchaseReceipt expiresDate(Long expiresDate) {
        this.expiresDate = expiresDate;
        return this;
    }

    /**
     * The expiration time of the subscription, in UNIX time, in milliseconds.
     *
     * @return expiresDate
     */
    public Long getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Long expiresDate) {
        this.expiresDate = expiresDate;
    }

    public InAppPurchaseReceipt cancellationDate(Long cancellationDate) {
        this.cancellationDate = cancellationDate;
        return this;
    }

    /**
     * The time Apple customer support canceled the transaction or the
     * subscription was upgraded, in UNIX time, in milliseconds.
     *
     * @return cancellationDate
     */
    public Long getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Long cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public InAppPurchaseReceipt webOrderLineItemId(Long webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
        return this;
    }

    /**
     * The unique identifier of subscription purchase events across devices,
     * including subscription renewals.
     *
     * @return webOrderLineItemId
     */
    public Long getWebOrderLineItemId() {
        return webOrderLineItemId;
    }

    public void setWebOrderLineItemId(Long webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
    }

    public InAppPurchaseReceipt isInIntroOfferPeriod(Boolean isInIntroOfferPeriod) {
        this.isInIntroOfferPeriod = isInIntroOfferPeriod;
        return this;
    }

    /**
     * Whether the subscription is in an introductory offer period.
     *
     * @return isInIntroOfferPeriod
     */
    public Boolean getIsInIntroOfferPeriod() {
        return isInIntroOfferPeriod;
    }

    public void setIsInIntroOfferPeriod(Boolean isInIntroOfferPeriod) {
        this.isInIntroOfferPeriod = isInIntroOfferPeriod;
    }

    public InAppPurchaseReceipt unknownAttributes(Map<Integer, List<byte[]>> unknownAttributes) {
        this.unknownAttributes = unknownAttributes;
        return this;
    }

    /**
     * Attribute types this library does not model, keyed by type, with the
     * verified-but-undecoded value bytes, so fields Apple adds later remain
     * accessible without a library update.
     *
     * @return unknownAttributes
     */
    public Map<Integer, List<byte[]>> getUnknownAttributes() {
        return unknownAttributes != null ? unknownAttributes : Collections.emptyMap();
    }

    public void setUnknownAttributes(Map<Integer, List<byte[]>> unknownAttributes) {
        this.unknownAttributes = unknownAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InAppPurchaseReceipt that = (InAppPurchaseReceipt) o;
        return Objects.equals(quantity, that.quantity)
                && Objects.equals(productId, that.productId)
                && Objects.equals(transactionId, that.transactionId)
                && Objects.equals(originalTransactionId, that.originalTransactionId)
                && Objects.equals(purchaseDate, that.purchaseDate)
                && Objects.equals(originalPurchaseDate, that.originalPurchaseDate)
                && Objects.equals(expiresDate, that.expiresDate)
                && Objects.equals(cancellationDate, that.cancellationDate)
                && Objects.equals(webOrderLineItemId, that.webOrderLineItemId)
                && Objects.equals(isInIntroOfferPeriod, that.isInIntroOfferPeriod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, productId, transactionId, originalTransactionId,
                purchaseDate, originalPurchaseDate, expiresDate, cancellationDate,
                webOrderLineItemId, isInIntroOfferPeriod);
    }

    @Override
    public String toString() {
        return "InAppPurchaseReceipt{" +
                "quantity=" + quantity +
                ", productId='" + productId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", originalTransactionId='" + originalTransactionId + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", expiresDate=" + expiresDate +
                ", cancellationDate=" + cancellationDate +
                ", webOrderLineItemId=" + webOrderLineItemId +
                ", isInIntroOfferPeriod=" + isInIntroOfferPeriod +
                '}';
    }
}
