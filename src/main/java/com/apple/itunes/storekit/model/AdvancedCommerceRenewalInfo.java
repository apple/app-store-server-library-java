// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercerenewalinfo">advancedCommerceRenewalInfo</a>
 **/
public class AdvancedCommerceRenewalInfo {
    private static final String SERIALIZED_NAME_CONSISTENCY_TOKEN = "consistencyToken";
    private static final String SERIALIZED_NAME_DESCRIPTORS = "descriptors";
    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_PERIOD = "period";
    private static final String SERIALIZED_NAME_REQUEST_REFERENCE_ID = "requestReferenceId";
    private static final String SERIALIZED_NAME_TAX_CODE = "taxCode";

    @JsonProperty(SERIALIZED_NAME_CONSISTENCY_TOKEN)
    private String consistencyToken;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTORS)
    private AdvancedCommerceDescriptors descriptors;
    @JsonProperty(SERIALIZED_NAME_ITEMS)
    private List<AdvancedCommerceRenewalItem> items;
    @JsonProperty(SERIALIZED_NAME_PERIOD)
    private String period;
    @JsonProperty(SERIALIZED_NAME_REQUEST_REFERENCE_ID)
    private String requestReferenceId;
    @JsonProperty(SERIALIZED_NAME_TAX_CODE)
    private String taxCode;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AdvancedCommerceRenewalInfo() {
    }

    public AdvancedCommerceRenewalInfo consistencyToken(String consistencyToken) {
        this.consistencyToken = consistencyToken;
        return this;
    }

    /**
     * @return consistencyToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommerceconsistencytoken">advancedCommerceConsistencyToken</a>
     **/
    public String getConsistencyToken() {
        return consistencyToken;
    }

    public void setConsistencyToken(String consistencyToken) {
        this.consistencyToken = consistencyToken;
    }

    public AdvancedCommerceRenewalInfo descriptors(AdvancedCommerceDescriptors descriptors) {
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

    public AdvancedCommerceRenewalInfo items(List<AdvancedCommerceRenewalItem> items) {
        this.items = items;
        return this;
    }

    public AdvancedCommerceRenewalInfo addItem(AdvancedCommerceRenewalItem item) {
        Objects.requireNonNull(item);
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        return this;
    }

    /**
     * @return items
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercerenewalitems">advancedCommerceRenewalItems</a>
     **/
    public List<AdvancedCommerceRenewalItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceRenewalItem> items) {
        this.items = items;
    }

    public AdvancedCommerceRenewalInfo period(AdvancedCommercePeriod period) {
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

    public AdvancedCommerceRenewalInfo requestReferenceId(String requestReferenceId) {
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

    public AdvancedCommerceRenewalInfo taxCode(String taxCode) {
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

    public AdvancedCommerceRenewalInfo unknownFields(Map<String, Object> unknownFields) {
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
        AdvancedCommerceRenewalInfo advancedCommerceRenewalInfo = (AdvancedCommerceRenewalInfo) o;
        return Objects.equals(this.consistencyToken, advancedCommerceRenewalInfo.consistencyToken) &&
                Objects.equals(this.descriptors, advancedCommerceRenewalInfo.descriptors) &&
                Objects.equals(this.items, advancedCommerceRenewalInfo.items) &&
                Objects.equals(this.period, advancedCommerceRenewalInfo.period) &&
                Objects.equals(this.requestReferenceId, advancedCommerceRenewalInfo.requestReferenceId) &&
                Objects.equals(this.taxCode, advancedCommerceRenewalInfo.taxCode) &&
                Objects.equals(this.unknownFields, advancedCommerceRenewalInfo.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consistencyToken, descriptors, items, period, requestReferenceId, taxCode, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceRenewalInfo{" +
                "consistencyToken='" + consistencyToken + '\'' +
                ", descriptors=" + descriptors +
                ", items=" + items +
                ", period='" + period + '\'' +
                ", requestReferenceId='" + requestReferenceId + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
