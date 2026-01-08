// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body that contains consumption information for an In-App Purchase.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionrequest">ConsumptionRequest</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumptionRequest {
    private static final String SERIALIZED_NAME_CUSTOMER_CONSENTED = "customerConsented";
    private static final String SERIALIZED_NAME_CONSUMPTION_PERCENTAGE = "consumptionPercentage";
    private static final String SERIALIZED_NAME_DELIVERY_STATUS = "deliveryStatus";
    private static final String SERIALIZED_NAME_REFUND_PREFERENCE = "refundPreference";
    private static final String SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED = "sampleContentProvided";

    @JsonProperty(value = SERIALIZED_NAME_CUSTOMER_CONSENTED, required = true)
    private boolean customerConsented;
    @JsonProperty(SERIALIZED_NAME_CONSUMPTION_PERCENTAGE)
    private Integer consumptionPercentage;
    @JsonProperty(value = SERIALIZED_NAME_DELIVERY_STATUS, required = true)
    private String deliveryStatus;
    @JsonProperty(SERIALIZED_NAME_REFUND_PREFERENCE)
    private String refundPreference;
    @JsonProperty(value = SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED, required = true)
    private boolean sampleContentProvided;

    private ConsumptionRequest() {
    }

    public ConsumptionRequest(boolean customerConsented, DeliveryStatus deliveryStatus, boolean sampleContentProvided) {
        this.customerConsented = customerConsented;
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
        this.sampleContentProvided = sampleContentProvided;
    }

    public ConsumptionRequest(boolean customerConsented, String rawDeliveryStatus, boolean sampleContentProvided) {
        this.customerConsented = customerConsented;
        this.deliveryStatus = Objects.requireNonNull(rawDeliveryStatus);
        this.sampleContentProvided = sampleContentProvided;
    }

    public ConsumptionRequest customerConsented(boolean customerConsented) {
        this.customerConsented = customerConsented;
        return this;
    }

    /**
     * A Boolean value that indicates whether the customer consented to provide consumption data to the App Store.
     *
     * @return customerConsented
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/customerconsented">customerConsented</a>
     **/
    public boolean getCustomerConsented() {
        return customerConsented;
    }

    public void setCustomerConsented(boolean customerConsented) {
        this.customerConsented = customerConsented;
    }

    public ConsumptionRequest consumptionPercentage(Integer consumptionPercentage) {
        this.consumptionPercentage = consumptionPercentage;
        return this;
    }

    /**
     * An integer that indicates the percentage, in milliunits, of the In-App Purchase the customer consumed.
     *
     * @return consumptionPercentage
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionpercentage">consumptionPercentage</a>
     **/
    public Integer getConsumptionPercentage() {
        return consumptionPercentage;
    }

    public void setConsumptionPercentage(Integer consumptionPercentage) {
        this.consumptionPercentage = consumptionPercentage;
    }

    public ConsumptionRequest deliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
        return this;
    }

    /**
     * A value that indicates whether the app successfully delivered an in-app purchase that works properly.
     *
     * @return deliveryStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
     **/
    public DeliveryStatus getDeliveryStatus() {
        return DeliveryStatus.fromValue(deliveryStatus);
    }

    /**
     * @see #getDeliveryStatus()
     */
    public String getRawDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus =  Objects.requireNonNull(deliveryStatus).getValue();
    }

    public void setRawDeliveryStatus(String rawDeliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(rawDeliveryStatus);
    }

    public ConsumptionRequest refundPreference(RefundPreference refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
        return this;
    }

    /**
     * A value that indicates your preferred outcome for the refund request.
     *
     * @return refundPreference
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreference">refundPreference</a>
     **/
    public RefundPreference getRefundPreference() {
        return refundPreference != null ? RefundPreference.fromValue(refundPreference) : null;
    }

    /**
     * @see #getRefundPreference()
     */
    public String getRawRefundPreference() {
        return refundPreference;
    }

    public void setRefundPreference(RefundPreference refundPreference) {
        this.refundPreference = Objects.requireNonNull(refundPreference).getValue();
    }

    public void setRawRefundPreference(String rawRefundPreference) {
        this.refundPreference = Objects.requireNonNull(rawRefundPreference);
    }

    public ConsumptionRequest sampleContentProvided(boolean sampleContentProvided) {
        this.sampleContentProvided = sampleContentProvided;
        return this;
    }

    /**
     * A Boolean value that indicates whether you provided, prior to its purchase, a free sample or trial of the content, or information about its functionality.
     *
     * @return sampleContentProvided
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/samplecontentprovided">sampleContentProvided</a>
     **/
    public boolean getSampleContentProvided() {
        return sampleContentProvided;
    }

    public void setSampleContentProvided(boolean sampleContentProvided) {
        this.sampleContentProvided = sampleContentProvided;
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
        return (this.customerConsented == consumptionRequest.customerConsented) &&
                Objects.equals(this.consumptionPercentage, consumptionRequest.consumptionPercentage) &&
                Objects.equals(this.deliveryStatus, consumptionRequest.deliveryStatus) &&
                Objects.equals(this.refundPreference, consumptionRequest.refundPreference) &&
                (this.sampleContentProvided == consumptionRequest.sampleContentProvided);
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
                ", deliveryStatus=" + deliveryStatus +
                ", refundPreference=" + refundPreference +
                ", sampleContentProvided=" + sampleContentProvided +
                '}';
    }
}
