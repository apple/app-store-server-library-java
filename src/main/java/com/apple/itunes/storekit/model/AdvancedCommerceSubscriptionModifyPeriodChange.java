// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to change the period of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyperiodchange">SubscriptionModifyPeriodChange</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionModifyPeriodChange {
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_PERIOD = "period";

    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private String effective;
    @JsonProperty(value = SERIALIZED_NAME_PERIOD, required = true)
    private String period;

    protected AdvancedCommerceSubscriptionModifyPeriodChange() {
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange(
            AdvancedCommerceEffective effective,
            AdvancedCommercePeriod period
    ) {
        this.effective = Objects.requireNonNull(effective).getValue();
        this.period = Objects.requireNonNull(period).getValue();
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange(String rawEffective, String rawPeriod) {
        this.effective = Objects.requireNonNull(rawEffective);
        this.period = Objects.requireNonNull(rawPeriod);
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
        return this;
    }

    /**
     * A string value that indicates when a requested change to an auto-renewable subscription goes into effect.
     *
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return AdvancedCommerceEffective.fromValue(effective);
    }

    /**
     * @see #getEffective()
     **/
    public String getRawEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
    }

    public void setRawEffective(String rawEffective) {
        this.effective = Objects.requireNonNull(rawEffective);
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange period(AdvancedCommercePeriod period) {
        this.period = Objects.requireNonNull(period).getValue();
        return this;
    }

    /**
     * The duration of a single cycle of an auto-renewable subscription.
     *
     * @return period
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/period">period</a>
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
        this.period = Objects.requireNonNull(period).getValue();
    }

    public void setRawPeriod(String rawPeriod) {
        this.period = Objects.requireNonNull(rawPeriod);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdvancedCommerceSubscriptionModifyPeriodChange advancedCommerceSubscriptionModifyPeriodChange = (AdvancedCommerceSubscriptionModifyPeriodChange) o;
        return Objects.equals(this.effective, advancedCommerceSubscriptionModifyPeriodChange.effective) &&
                Objects.equals(this.period, advancedCommerceSubscriptionModifyPeriodChange.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(effective, period);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionModifyPeriodChange{" +
                "effective='" + effective + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
