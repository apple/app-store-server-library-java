// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body that contains consumption information for an In-App Purchase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionrequest">ConsumptionRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumptionRequest {
    private static final String SERIALIZED_NAME_CUSTOMER_CONSENTED = "customerConsented";
    private static final String SERIALIZED_NAME_CONSUMPTION_PERCENTAGE = "consumptionPercentage";
    private static final String SERIALIZED_NAME_DELIVERY_STATUS = "deliveryStatus";
    private static final String SERIALIZED_NAME_REFUND_PREFERENCE = "refundPreference";
    private static final String SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED = "sampleContentProvided";

    @JsonProperty(value = SERIALIZED_NAME_CUSTOMER_CONSENTED, required = true)
    private Boolean customerConsented;
    @JsonProperty(SERIALIZED_NAME_CONSUMPTION_PERCENTAGE)
    private Integer consumptionPercentage;
    @JsonProperty(value = SERIALIZED_NAME_DELIVERY_STATUS, required = true)
    private String deliveryStatus;
    @JsonProperty(SERIALIZED_NAME_REFUND_PREFERENCE)
    private String refundPreference;
    @JsonProperty(value = SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED, required = true)
    private Boolean sampleContentProvided;

    private static final int MINIMUM_CONSUMPTION_PERCENTAGE = 0;
    private static final int MAXIMUM_CONSUMPTION_PERCENTAGE = 100000;

    protected ConsumptionRequest() {
    }

    public ConsumptionRequest(Boolean customerConsented, DeliveryStatus deliveryStatus, Boolean sampleContentProvided) {
        this.customerConsented = Objects.requireNonNull(customerConsented);
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
    }

    public ConsumptionRequest(Boolean customerConsented, String rawDeliveryStatus, Boolean sampleContentProvided) {
        this.customerConsented = Objects.requireNonNull(customerConsented);
        this.deliveryStatus = Objects.requireNonNull(rawDeliveryStatus);
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
    }

    public ConsumptionRequest customerConsented(Boolean customerConsented) {
        this.customerConsented = Objects.requireNonNull(customerConsented);
        return this;
    }

    /**
     * A Boolean value of true or false that indicates whether the customer consented to provide consumption data.
     *
     * @return customerConsented
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/customerconsented">customerConsented</a>
     **/
    public Boolean getCustomerConsented() {
        return customerConsented;
    }

    public void setCustomerConsented(Boolean customerConsented) {
        this.customerConsented = Objects.requireNonNull(customerConsented);
    }

    public ConsumptionRequest consumptionPercentage(Integer consumptionPercentage) {
        this.consumptionPercentage = validateConsumptionPercentage(consumptionPercentage);
        return this;
    }

    /**
     * An integer that indicates the percentage of the In-App Purchase the customer consumed, in milliunits.
     *
     * @return consumptionPercentage
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionpercentage">consumptionPercentage</a>
     **/
    public Integer getConsumptionPercentage() {
        return consumptionPercentage;
    }

    public void setConsumptionPercentage(Integer consumptionPercentage) {
        this.consumptionPercentage = validateConsumptionPercentage(consumptionPercentage);
    }

    private Integer validateConsumptionPercentage(Integer consumptionPercentage) {
        if (consumptionPercentage != null && (consumptionPercentage < MINIMUM_CONSUMPTION_PERCENTAGE || consumptionPercentage > MAXIMUM_CONSUMPTION_PERCENTAGE)) {
            throw new IllegalArgumentException("consumptionPercentage must be between " + MINIMUM_CONSUMPTION_PERCENTAGE + " and " + MAXIMUM_CONSUMPTION_PERCENTAGE);
        }
        return consumptionPercentage;
    }

    public ConsumptionRequest deliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
        return this;
    }

    /**
     * A value that indicates whether the app successfully delivered an In-App Purchase that works properly.
     *
     * @return deliveryStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
     **/
    public DeliveryStatus getDeliveryStatus() {
        return DeliveryStatus.fromValue(deliveryStatus);
    }

    /**
     * @see #getDeliveryStatus()
     **/
    public String getRawDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
    }

    public void setRawDeliveryStatus(String rawDeliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(rawDeliveryStatus);
    }

    public ConsumptionRequest refundPreference(RefundPreference refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
        return this;
    }

    /**
     * A value that indicates your preference, based on your operational logic, as to whether the App Store should grant the refund.
     *
     * @return refundPreference
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreference">refundPreference</a>
     **/
    public RefundPreference getRefundPreference() {
        return RefundPreference.fromValue(refundPreference);
    }

    /**
     * @see #getRefundPreference()
     **/
    public String getRawRefundPreference() {
        return refundPreference;
    }

    public void setRefundPreference(RefundPreference refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
    }

    public void setRawRefundPreference(String rawRefundPreference) {
        this.refundPreference = rawRefundPreference;
    }

    public ConsumptionRequest sampleContentProvided(Boolean sampleContentProvided) {
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
        return this;
    }

    /**
     * A Boolean value of true or false that indicates whether you provided, prior to its purchase, a free sample or trial of the content, or information about its functionality.
     *
     * @return sampleContentProvided
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/samplecontentprovided">sampleContentProvided</a>
     **/
    public Boolean getSampleContentProvided() {
        return sampleContentProvided;
    }

    public void setSampleContentProvided(Boolean sampleContentProvided) {
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsumptionRequest consumptionRequest = (ConsumptionRequest) o;
        return Objects.equals(this.customerConsented, consumptionRequest.customerConsented) &&
                Objects.equals(this.consumptionPercentage, consumptionRequest.consumptionPercentage) &&
                Objects.equals(this.deliveryStatus, consumptionRequest.deliveryStatus) &&
                Objects.equals(this.refundPreference, consumptionRequest.refundPreference) &&
                Objects.equals(this.sampleContentProvided, consumptionRequest.sampleContentProvided);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerConsented, consumptionPercentage, deliveryStatus, refundPreference, sampleContentProvided);
    }

    @Override
    public String toString() {
        return "ConsumptionRequest{" +
                "customerConsented=" + customerConsented +
                ", consumptionPercentage=" + consumptionPercentage +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", refundPreference='" + refundPreference + '\'' +
                ", sampleContentProvided=" + sampleContentProvided +
                '}';
    }
}
