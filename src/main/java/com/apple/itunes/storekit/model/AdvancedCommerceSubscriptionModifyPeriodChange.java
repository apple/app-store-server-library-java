// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to change the period of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyperiodchange">SubscriptionModifyPeriodChange</a>
 */
public class AdvancedCommerceSubscriptionModifyPeriodChange {
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_PERIOD = "period";

    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private AdvancedCommerceEffective effective;
    @JsonProperty(value = SERIALIZED_NAME_PERIOD, required = true)
    private AdvancedCommercePeriod period;

    private AdvancedCommerceSubscriptionModifyPeriodChange() {}

    public AdvancedCommerceSubscriptionModifyPeriodChange(
            AdvancedCommerceEffective effective,
            AdvancedCommercePeriod period
    ) {
        this.effective = Objects.requireNonNull(effective);
        this.period = Objects.requireNonNull(period);
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange(String rawEffective, String rawPeriod) {
        this.effective = AdvancedCommerceEffective.fromValue(rawEffective);
        this.period = AdvancedCommercePeriod.fromValue(rawPeriod);
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
        return this;
    }

    /**
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionModifyPeriodChange period(AdvancedCommercePeriod period) {
        this.period = Objects.requireNonNull(period);
        return this;
    }

    /**
     * @return period
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/period">Period</a>
     **/
    public AdvancedCommercePeriod getPeriod() {
        return period;
    }

    public void setPeriod(AdvancedCommercePeriod period) {
        this.period = Objects.requireNonNull(period);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvancedCommerceSubscriptionModifyPeriodChange that = (AdvancedCommerceSubscriptionModifyPeriodChange) o;
        return Objects.equals(effective, that.effective) && Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(effective, period);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionModifyPeriodChange{" +
                "effective=" + effective +
                ", period=" + period +
                '}';
    }
}