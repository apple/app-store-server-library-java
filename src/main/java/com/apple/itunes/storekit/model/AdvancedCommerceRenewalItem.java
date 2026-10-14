// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercerenewalitem">advancedCommerceRenewalItem</a>
 **/
public class AdvancedCommerceRenewalItem {
    private static final String SERIALIZED_NAME_SKU = "SKU";
    private static final String SERIALIZED_NAME_DESCRIPTION = "description";
    private static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_PRICE_INCREASE_INFO = "priceIncreaseInfo";

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
    @JsonProperty(SERIALIZED_NAME_PRICE_INCREASE_INFO)
    private AdvancedCommercePriceIncreaseInfo priceIncreaseInfo;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AdvancedCommerceRenewalItem() {
    }

    public AdvancedCommerceRenewalItem sku(String sku) {
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

    public AdvancedCommerceRenewalItem description(String description) {
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

    public AdvancedCommerceRenewalItem displayName(String displayName) {
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

    public AdvancedCommerceRenewalItem offer(AdvancedCommerceOffer offer) {
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

    public AdvancedCommerceRenewalItem price(Long price) {
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

    public AdvancedCommerceRenewalItem priceIncreaseInfo(AdvancedCommercePriceIncreaseInfo priceIncreaseInfo) {
        this.priceIncreaseInfo = priceIncreaseInfo;
        return this;
    }

    /**
     * @return priceIncreaseInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercepriceincreaseinfo">advancedCommercePriceIncreaseInfo</a>
     **/
    public AdvancedCommercePriceIncreaseInfo getPriceIncreaseInfo() {
        return priceIncreaseInfo;
    }

    public void setPriceIncreaseInfo(AdvancedCommercePriceIncreaseInfo priceIncreaseInfo) {
        this.priceIncreaseInfo = priceIncreaseInfo;
    }

    public AdvancedCommerceRenewalItem unknownFields(Map<String, Object> unknownFields) {
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
        AdvancedCommerceRenewalItem advancedCommerceRenewalItem = (AdvancedCommerceRenewalItem) o;
        return Objects.equals(this.sku, advancedCommerceRenewalItem.sku) &&
                Objects.equals(this.description, advancedCommerceRenewalItem.description) &&
                Objects.equals(this.displayName, advancedCommerceRenewalItem.displayName) &&
                Objects.equals(this.offer, advancedCommerceRenewalItem.offer) &&
                Objects.equals(this.price, advancedCommerceRenewalItem.price) &&
                Objects.equals(this.priceIncreaseInfo, advancedCommerceRenewalItem.priceIncreaseInfo) &&
                Objects.equals(this.unknownFields, advancedCommerceRenewalItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, description, displayName, offer, price, priceIncreaseInfo, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceRenewalItem{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                ", priceIncreaseInfo=" + priceIncreaseInfo +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
