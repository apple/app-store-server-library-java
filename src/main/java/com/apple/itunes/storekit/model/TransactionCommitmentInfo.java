// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;
import java.util.Objects;

/**
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactioncommitmentinfo">TransactionCommitmentInfo</a>
 **/
public class TransactionCommitmentInfo {
    private static final String SERIALIZED_NAME_BILLING_PERIOD_NUMBER = "billingPeriodNumber";
    private static final String SERIALIZED_NAME_COMMITMENT_EXPIRES_DATE = "commitmentExpiresDate";
    private static final String SERIALIZED_NAME_COMMITMENT_PRICE = "commitmentPrice";
    private static final String SERIALIZED_NAME_TOTAL_BILLING_PERIODS = "totalBillingPeriods";

    @JsonProperty(SERIALIZED_NAME_BILLING_PERIOD_NUMBER)
    private Integer billingPeriodNumber;
    @JsonProperty(SERIALIZED_NAME_COMMITMENT_EXPIRES_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long commitmentExpiresDate;
    @JsonProperty(SERIALIZED_NAME_COMMITMENT_PRICE)
    private Long commitmentPrice;
    @JsonProperty(SERIALIZED_NAME_TOTAL_BILLING_PERIODS)
    private Integer totalBillingPeriods;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    private static final int MINIMUM_BILLING_PERIOD_NUMBER = 1;
    private static final int MAXIMUM_BILLING_PERIOD_NUMBER = 12;

    public TransactionCommitmentInfo() {
    }

    public TransactionCommitmentInfo billingPeriodNumber(Integer billingPeriodNumber) {
        this.billingPeriodNumber = validateBillingPeriodNumber(billingPeriodNumber);
        return this;
    }

    /**
     * @return billingPeriodNumber
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/billingperiodnumber">billingPeriodNumber</a>
     **/
    public Integer getBillingPeriodNumber() {
        return billingPeriodNumber;
    }

    @JsonSetter(SERIALIZED_NAME_BILLING_PERIOD_NUMBER)
    public void setBillingPeriodNumber(Integer billingPeriodNumber) {
        this.billingPeriodNumber = validateBillingPeriodNumber(billingPeriodNumber);
    }

    private Integer validateBillingPeriodNumber(Integer billingPeriodNumber) {
        if (billingPeriodNumber != null && (billingPeriodNumber < MINIMUM_BILLING_PERIOD_NUMBER || billingPeriodNumber > MAXIMUM_BILLING_PERIOD_NUMBER)) {
            throw new IllegalArgumentException("billingPeriodNumber must be between " + MINIMUM_BILLING_PERIOD_NUMBER + " and " + MAXIMUM_BILLING_PERIOD_NUMBER);
        }
        return billingPeriodNumber;
    }

    public TransactionCommitmentInfo commitmentExpiresDate(Long commitmentExpiresDate) {
        this.commitmentExpiresDate = commitmentExpiresDate;
        return this;
    }

    /**
     * @return commitmentExpiresDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/commitmentexpiresdate">commitmentExpiresDate</a>
     **/
    public Long getCommitmentExpiresDate() {
        return commitmentExpiresDate;
    }

    public void setCommitmentExpiresDate(Long commitmentExpiresDate) {
        this.commitmentExpiresDate = commitmentExpiresDate;
    }

    public TransactionCommitmentInfo commitmentPrice(Long commitmentPrice) {
        this.commitmentPrice = commitmentPrice;
        return this;
    }

    /**
     * @return commitmentPrice
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/commitmentprice">commitmentPrice</a>
     **/
    public Long getCommitmentPrice() {
        return commitmentPrice;
    }

    public void setCommitmentPrice(Long commitmentPrice) {
        this.commitmentPrice = commitmentPrice;
    }

    public TransactionCommitmentInfo totalBillingPeriods(Integer totalBillingPeriods) {
        this.totalBillingPeriods = totalBillingPeriods;
        return this;
    }

    /**
     * @return totalBillingPeriods
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/totalbillingperiods">totalBillingPeriods</a>
     **/
    public Integer getTotalBillingPeriods() {
        return totalBillingPeriods;
    }

    public void setTotalBillingPeriods(Integer totalBillingPeriods) {
        this.totalBillingPeriods = totalBillingPeriods;
    }

    public TransactionCommitmentInfo unknownFields(Map<String, Object> unknownFields) {
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
        TransactionCommitmentInfo transactionCommitmentInfo = (TransactionCommitmentInfo) o;
        return Objects.equals(this.billingPeriodNumber, transactionCommitmentInfo.billingPeriodNumber) &&
                Objects.equals(this.commitmentExpiresDate, transactionCommitmentInfo.commitmentExpiresDate) &&
                Objects.equals(this.commitmentPrice, transactionCommitmentInfo.commitmentPrice) &&
                Objects.equals(this.totalBillingPeriods, transactionCommitmentInfo.totalBillingPeriods) &&
                Objects.equals(this.unknownFields, transactionCommitmentInfo.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingPeriodNumber, commitmentExpiresDate, commitmentPrice, totalBillingPeriods, unknownFields);
    }

    @Override
    public String toString() {
        return "TransactionCommitmentInfo{" +
                "billingPeriodNumber=" + billingPeriodNumber +
                ", commitmentExpiresDate=" + commitmentExpiresDate +
                ", commitmentPrice=" + commitmentPrice +
                ", totalBillingPeriods=" + totalBillingPeriods +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
