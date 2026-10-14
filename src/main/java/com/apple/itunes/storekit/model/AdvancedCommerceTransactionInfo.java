// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetransactioninfo">advancedCommerceTransactionInfo</a>
 **/
public class AdvancedCommerceTransactionInfo {
    private static final String SERIALIZED_NAME_DESCRIPTORS = "descriptors";
    private static final String SERIALIZED_NAME_ESTIMATED_TAX = "estimatedTax";
    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_PERIOD = "period";
    private static final String SERIALIZED_NAME_REQUEST_REFERENCE_ID = "requestReferenceId";
    private static final String SERIALIZED_NAME_TAX_CODE = "taxCode";
    private static final String SERIALIZED_NAME_TAX_EXCLUSIVE_PRICE = "taxExclusivePrice";
    private static final String SERIALIZED_NAME_TAX_RATE = "taxRate";

    @JsonProperty(SERIALIZED_NAME_DESCRIPTORS)
    private AdvancedCommerceDescriptors descriptors;
    @JsonProperty(SERIALIZED_NAME_ESTIMATED_TAX)
    private Long estimatedTax;
    @JsonProperty(SERIALIZED_NAME_ITEMS)
    private List<AdvancedCommerceTransactionItem> items;
    @JsonProperty(SERIALIZED_NAME_PERIOD)
    private String period;
    @JsonProperty(SERIALIZED_NAME_REQUEST_REFERENCE_ID)
    private String requestReferenceId;
    @JsonProperty(SERIALIZED_NAME_TAX_CODE)
    private String taxCode;
    @JsonProperty(SERIALIZED_NAME_TAX_EXCLUSIVE_PRICE)
    private Long taxExclusivePrice;
    @JsonProperty(SERIALIZED_NAME_TAX_RATE)
    private String taxRate;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AdvancedCommerceTransactionInfo() {
    }

    public AdvancedCommerceTransactionInfo descriptors(AdvancedCommerceDescriptors descriptors) {
        this.descriptors = descriptors;
        return this;
    }

    /**
     * @return descriptors
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercedescriptors">advancedCommerceDescriptors</a>
     **/
    public AdvancedCommerceDescriptors getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(AdvancedCommerceDescriptors descriptors) {
        this.descriptors = descriptors;
    }

    public AdvancedCommerceTransactionInfo estimatedTax(Long estimatedTax) {
        this.estimatedTax = estimatedTax;
        return this;
    }

    /**
     * @return estimatedTax
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommerceestimatedtax">advancedCommerceEstimatedTax</a>
     **/
    public Long getEstimatedTax() {
        return estimatedTax;
    }

    public void setEstimatedTax(Long estimatedTax) {
        this.estimatedTax = estimatedTax;
    }

    public AdvancedCommerceTransactionInfo items(List<AdvancedCommerceTransactionItem> items) {
        this.items = items;
        return this;
    }

    public AdvancedCommerceTransactionInfo addItem(AdvancedCommerceTransactionItem item) {
        Objects.requireNonNull(item);
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        return this;
    }

    /**
     * @return items
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetransactionitems">advancedCommerceTransactionItems</a>
     **/
    public List<AdvancedCommerceTransactionItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceTransactionItem> items) {
        this.items = items;
    }

    public AdvancedCommerceTransactionInfo period(AdvancedCommercePeriod period) {
        this.period = period != null ? period.getValue() : null;
        return this;
    }

    /**
     * @return period
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommerceperiod">advancedCommercePeriod</a>
     **/
    public AdvancedCommercePeriod getPeriod() {
        return AdvancedCommercePeriod.fromValue(period);
    }

    /**
     * @see #getPeriod()
     **/
    public String getRawPeriod() {
        return period;
    }

    public void setPeriod(AdvancedCommercePeriod period) {
        this.period = period != null ? period.getValue() : null;
    }

    public void setRawPeriod(String rawPeriod) {
        this.period = rawPeriod;
    }

    public AdvancedCommerceTransactionInfo requestReferenceId(String requestReferenceId) {
        this.requestReferenceId = requestReferenceId;
        return this;
    }

    /**
     * @return requestReferenceId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercerequestreferenceid">advancedCommerceRequestReferenceId</a>
     **/
    public String getRequestReferenceId() {
        return requestReferenceId;
    }

    public void setRequestReferenceId(String requestReferenceId) {
        this.requestReferenceId = requestReferenceId;
    }

    public AdvancedCommerceTransactionInfo taxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    /**
     * @return taxCode
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetaxcode">advancedCommerceTaxCode</a>
     **/
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public AdvancedCommerceTransactionInfo taxExclusivePrice(Long taxExclusivePrice) {
        this.taxExclusivePrice = taxExclusivePrice;
        return this;
    }

    /**
     * @return taxExclusivePrice
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetaxexclusiveprice">advancedCommerceTaxExclusivePrice</a>
     **/
    public Long getTaxExclusivePrice() {
        return taxExclusivePrice;
    }

    public void setTaxExclusivePrice(Long taxExclusivePrice) {
        this.taxExclusivePrice = taxExclusivePrice;
    }

    public AdvancedCommerceTransactionInfo taxRate(String taxRate) {
        this.taxRate = taxRate;
        return this;
    }

    /**
     * @return taxRate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetaxrate">advancedCommerceTaxRate</a>
     **/
    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public AdvancedCommerceTransactionInfo unknownFields(Map<String, Object> unknownFields) {
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
        AdvancedCommerceTransactionInfo advancedCommerceTransactionInfo = (AdvancedCommerceTransactionInfo) o;
        return Objects.equals(this.descriptors, advancedCommerceTransactionInfo.descriptors) &&
                Objects.equals(this.estimatedTax, advancedCommerceTransactionInfo.estimatedTax) &&
                Objects.equals(this.items, advancedCommerceTransactionInfo.items) &&
                Objects.equals(this.period, advancedCommerceTransactionInfo.period) &&
                Objects.equals(this.requestReferenceId, advancedCommerceTransactionInfo.requestReferenceId) &&
                Objects.equals(this.taxCode, advancedCommerceTransactionInfo.taxCode) &&
                Objects.equals(this.taxExclusivePrice, advancedCommerceTransactionInfo.taxExclusivePrice) &&
                Objects.equals(this.taxRate, advancedCommerceTransactionInfo.taxRate) &&
                Objects.equals(this.unknownFields, advancedCommerceTransactionInfo.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptors, estimatedTax, items, period, requestReferenceId, taxCode, taxExclusivePrice, taxRate, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceTransactionInfo{" +
                "descriptors=" + descriptors +
                ", estimatedTax=" + estimatedTax +
                ", items=" + items +
                ", period='" + period + '\'' +
                ", requestReferenceId='" + requestReferenceId + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", taxExclusivePrice=" + taxExclusivePrice +
                ", taxRate='" + taxRate + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
