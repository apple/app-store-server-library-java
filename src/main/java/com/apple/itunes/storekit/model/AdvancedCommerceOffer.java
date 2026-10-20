// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A discount offer for an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceOffer {
    private static final String SERIALIZED_NAME_PERIOD = "period";
    private static final String SERIALIZED_NAME_PERIOD_COUNT = "periodCount";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_REASON = "reason";

    @JsonProperty(value = SERIALIZED_NAME_PERIOD, required = true)
    private String period;
    @JsonProperty(value = SERIALIZED_NAME_PERIOD_COUNT, required = true)
    private Integer periodCount;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;
    @JsonProperty(value = SERIALIZED_NAME_REASON, required = true)
    private String reason;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected AdvancedCommerceOffer() {
    }

    public AdvancedCommerceOffer(
            AdvancedCommerceOfferPeriod period,
            Integer periodCount,
            Long price,
            AdvancedCommerceOfferReason reason
    ) {
        this.period = Objects.requireNonNull(period).getValue();
        this.periodCount = HelperValidationUtils.validatePeriodCount(periodCount);
        this.price = Objects.requireNonNull(price);
        this.reason = Objects.requireNonNull(reason).getValue();
    }

    @JsonCreator
    public AdvancedCommerceOffer(
            @JsonProperty(value = SERIALIZED_NAME_PERIOD, required = true) String rawPeriod,
            @JsonProperty(value = SERIALIZED_NAME_PERIOD_COUNT, required = true) Integer periodCount,
            @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true) Long price,
            @JsonProperty(value = SERIALIZED_NAME_REASON, required = true) String rawReason
    ) {
        this.period = Objects.requireNonNull(rawPeriod);
        this.periodCount = HelperValidationUtils.validatePeriodCount(periodCount);
        this.price = Objects.requireNonNull(price);
        this.reason = Objects.requireNonNull(rawReason);
    }

    public AdvancedCommerceOffer period(AdvancedCommerceOfferPeriod period) {
        this.period = Objects.requireNonNull(period).getValue();
        return this;
    }

    /**
     * The period of the offer.
     *
     * @return period
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
     **/
    public AdvancedCommerceOfferPeriod getPeriod() {
        return AdvancedCommerceOfferPeriod.fromValue(period);
    }

    /**
     * @see #getPeriod()
     **/
    public String getRawPeriod() {
        return period;
    }

    public void setPeriod(AdvancedCommerceOfferPeriod period) {
        this.period = Objects.requireNonNull(period).getValue();
    }

    public void setRawPeriod(String rawPeriod) {
        this.period = Objects.requireNonNull(rawPeriod);
    }

    public AdvancedCommerceOffer periodCount(Integer periodCount) {
        this.periodCount = HelperValidationUtils.validatePeriodCount(periodCount);
        return this;
    }

    /**
     * The number of periods the offer is active.
     *
     * @return periodCount
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
     **/
    public Integer getPeriodCount() {
        return periodCount;
    }

    public void setPeriodCount(Integer periodCount) {
        this.periodCount = HelperValidationUtils.validatePeriodCount(periodCount);
    }

    public AdvancedCommerceOffer price(Long price) {
        this.price = Objects.requireNonNull(price);
        return this;
    }

    /**
     * The offer price, in milliunits.
     *
     * @return price
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/price">price</a>
     **/
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = Objects.requireNonNull(price);
    }

    public AdvancedCommerceOffer reason(AdvancedCommerceOfferReason reason) {
        this.reason = Objects.requireNonNull(reason).getValue();
        return this;
    }

    /**
     * The reason for the offer.
     *
     * @return reason
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
     **/
    public AdvancedCommerceOfferReason getReason() {
        return AdvancedCommerceOfferReason.fromValue(reason);
    }

    /**
     * @see #getReason()
     **/
    public String getRawReason() {
        return reason;
    }

    public void setReason(AdvancedCommerceOfferReason reason) {
        this.reason = Objects.requireNonNull(reason).getValue();
    }

    public void setRawReason(String rawReason) {
        this.reason = Objects.requireNonNull(rawReason);
    }

    public AdvancedCommerceOffer unknownFields(Map<String, Object> unknownFields) {
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
        AdvancedCommerceOffer advancedCommerceOffer = (AdvancedCommerceOffer) o;
        return Objects.equals(this.period, advancedCommerceOffer.period) &&
                Objects.equals(this.periodCount, advancedCommerceOffer.periodCount) &&
                Objects.equals(this.price, advancedCommerceOffer.price) &&
                Objects.equals(this.reason, advancedCommerceOffer.reason) &&
                Objects.equals(this.unknownFields, advancedCommerceOffer.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period, periodCount, price, reason, unknownFields);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceOffer{" +
                "period='" + period + '\'' +
                ", periodCount=" + periodCount +
                ", price=" + price +
                ", reason='" + reason + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
