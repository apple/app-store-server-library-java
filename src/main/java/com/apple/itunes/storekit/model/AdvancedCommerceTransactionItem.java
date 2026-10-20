// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetransactionitem">advancedCommerceTransactionItem</a>
 **/
public class AdvancedCommerceTransactionItem {
    private static final String SERIALIZED_NAME_SKU = "SKU";
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_REFUNDS = "refunds";
    private static final String SERIALIZED_NAME_REVOCATION_DATE = "revocationDate";

    @JsonProperty(SERIALIZED_NAME_SKU)
    private String sku;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @JsonProperty(SERIALIZED_NAME_DISPLAY_NAME)
    private String displayName;
    @JsonProperty(SERIALIZED_NAME_OFFER)
    private AdvancedCommerceOffer offer;
    @JsonProperty(SERIALIZED_NAME_PRICE)
    private Long price;
    @JsonProperty(SERIALIZED_NAME_REFUNDS)
    private List<AdvancedCommerceRefund> refunds;
    @JsonProperty(SERIALIZED_NAME_REVOCATION_DATE)
    private Long revocationDate;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AdvancedCommerceTransactionItem() {
    }

    public AdvancedCommerceTransactionItem sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercesku">advancedCommerceSKU</a>
     **/
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public AdvancedCommerceTransactionItem description(String description) {
        this.description = description;
        return this;
    }

    /**
     * @return description
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercedescription">advancedCommerceDescription</a>
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AdvancedCommerceTransactionItem displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercedisplayname">advancedCommerceDisplayName</a>
     **/
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public AdvancedCommerceTransactionItem offer(AdvancedCommerceOffer offer) {
        this.offer = offer;
        return this;
    }

    /**
     * @return offer
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommerceoffer">advancedCommerceOffer</a>
     **/
    public AdvancedCommerceOffer getOffer() {
        return offer;
    }

    public void setOffer(AdvancedCommerceOffer offer) {
        this.offer = offer;
    }

    public AdvancedCommerceTransactionItem price(Long price) {
        this.price = price;
        return this;
    }

    /**
     * @return price
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommerceprice">advancedCommercePrice</a>
     **/
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public AdvancedCommerceTransactionItem refunds(List<AdvancedCommerceRefund> refunds) {
        this.refunds = refunds;
        return this;
    }

    public AdvancedCommerceTransactionItem addRefund(AdvancedCommerceRefund refund) {
        Objects.requireNonNull(refund);
        if (this.refunds == null) {
            this.refunds = new ArrayList<>();
        }
        this.refunds.add(refund);
        return this;
    }

    /**
     * @return refunds
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercerefunds">advancedCommerceRefunds</a>
     **/
    public List<AdvancedCommerceRefund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<AdvancedCommerceRefund> refunds) {
        this.refunds = refunds;
    }

    public AdvancedCommerceTransactionItem revocationDate(Long revocationDate) {
        this.revocationDate = revocationDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store refunded the transaction or revoked it from Family Sharing.
     *
     * @return revocationDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationdate">revocationDate</a>
     **/
    public Long getRevocationDate() {
        return revocationDate;
    }

    public void setRevocationDate(Long revocationDate) {
        this.revocationDate = revocationDate;
    }

    public AdvancedCommerceTransactionItem unknownFields(Map<String, Object> unknownFields) {
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
        AdvancedCommerceTransactionItem advancedCommerceTransactionItem = (AdvancedCommerceTransactionItem) o;
        return Objects.equals(this.sku, advancedCommerceTransactionItem.sku) &&
                Objects.equals(this.description, advancedCommerceTransactionItem.description) &&
                Objects.equals(this.displayName, advancedCommerceTransactionItem.displayName) &&
                Objects.equals(this.offer, advancedCommerceTransactionItem.offer) &&
                Objects.equals(this.price, advancedCommerceTransactionItem.price) &&
                Objects.equals(this.refunds, advancedCommerceTransactionItem.refunds) &&
                Objects.equals(this.revocationDate, advancedCommerceTransactionItem.revocationDate) &&
                Objects.equals(this.unknownFields, advancedCommerceTransactionItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, description, displayName, offer, price, refunds, revocationDate, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceTransactionItem{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                ", refunds=" + refunds +
                ", revocationDate=" + revocationDate +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
