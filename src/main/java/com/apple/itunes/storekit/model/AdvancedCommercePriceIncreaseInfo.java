// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercepriceincreaseinfo">advancedCommercePriceIncreaseInfo</a>
 **/
public class AdvancedCommercePriceIncreaseInfo {
    private static final String SERIALIZED_NAME_DEPENDENT_SKUS = "dependentSKUs";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_STATUS = "status";

    @JsonProperty(SERIALIZED_NAME_DEPENDENT_SKUS)
    private List<String> dependentSKUs;
    @JsonProperty(SERIALIZED_NAME_PRICE)
    private Long price;
    @JsonProperty(SERIALIZED_NAME_STATUS)
    private String status;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AdvancedCommercePriceIncreaseInfo() {
    }

    public AdvancedCommercePriceIncreaseInfo dependentSKUs(List<String> dependentSKUs) {
        this.dependentSKUs = dependentSKUs;
        return this;
    }

    public AdvancedCommercePriceIncreaseInfo addDependentSKU(String dependentSKU) {
        Objects.requireNonNull(dependentSKU);
        if (this.dependentSKUs == null) {
            this.dependentSKUs = new ArrayList<>();
        }
        this.dependentSKUs.add(dependentSKU);
        return this;
    }

    /**
     * @return dependentSKUs
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercepriceincreaseinfodependentsku">advancedCommercePriceIncreaseInfoDependentSKU</a>
     **/
    public List<String> getDependentSKUs() {
        return dependentSKUs;
    }

    public void setDependentSKUs(List<String> dependentSKUs) {
        this.dependentSKUs = dependentSKUs;
    }

    public AdvancedCommercePriceIncreaseInfo price(Long price) {
        this.price = price;
        return this;
    }

    /**
     * @return price
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercepriceincreaseinfoprice">advancedCommercePriceIncreaseInfoPrice</a>
     **/
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public AdvancedCommercePriceIncreaseInfo status(AdvancedCommercePriceIncreaseInfoStatus status) {
        this.status = status != null ? status.getValue() : null;
        return this;
    }

    /**
     * @return status
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercepriceincreaseinfostatus">advancedCommercePriceIncreaseInfoStatus</a>
     **/
    public AdvancedCommercePriceIncreaseInfoStatus getStatus() {
        return AdvancedCommercePriceIncreaseInfoStatus.fromValue(status);
    }

    /**
     * @see #getStatus()
     **/
    public String getRawStatus() {
        return status;
    }

    public void setStatus(AdvancedCommercePriceIncreaseInfoStatus status) {
        this.status = status != null ? status.getValue() : null;
    }

    public void setRawStatus(String rawStatus) {
        this.status = rawStatus;
    }

    public AdvancedCommercePriceIncreaseInfo unknownFields(Map<String, Object> unknownFields) {
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
        AdvancedCommercePriceIncreaseInfo advancedCommercePriceIncreaseInfo = (AdvancedCommercePriceIncreaseInfo) o;
        return Objects.equals(this.dependentSKUs, advancedCommercePriceIncreaseInfo.dependentSKUs) &&
                Objects.equals(this.price, advancedCommercePriceIncreaseInfo.price) &&
                Objects.equals(this.status, advancedCommercePriceIncreaseInfo.status) &&
                Objects.equals(this.unknownFields, advancedCommercePriceIncreaseInfo.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dependentSKUs, price, status, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommercePriceIncreaseInfo{" +
                "dependentSKUs=" + dependentSKUs +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
