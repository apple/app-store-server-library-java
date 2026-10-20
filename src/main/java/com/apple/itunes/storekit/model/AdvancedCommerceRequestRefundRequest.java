// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * The request body for requesting a refund for a transaction.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefundrequest">RequestRefundRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceRequestRefundRequest extends AdvancedCommerceRequest<AdvancedCommerceRequestRefundRequest> {
    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_REFUND_RISKING_PREFERENCE = "refundRiskingPreference";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";

    @JsonProperty(SERIALIZED_NAME_CURRENCY)
    private String currency;
    @JsonProperty(value = SERIALIZED_NAME_ITEMS, required = true)
    private List<AdvancedCommerceRequestRefundItem> items;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_RISKING_PREFERENCE, required = true)
    private Boolean refundRiskingPreference;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;

    protected AdvancedCommerceRequestRefundRequest() {
        super();
    }

    public AdvancedCommerceRequestRefundRequest(
            AdvancedCommerceRequestInfo requestInfo,
            List<AdvancedCommerceRequestRefundItem> items,
            Boolean refundRiskingPreference
    ) {
        super(requestInfo);
        this.items = HelperValidationUtils.validateItems(items);
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
    }

    @Override
    protected AdvancedCommerceRequestRefundRequest self() {
        return this;
    }

    /**
     * The metadata to include in server requests.
     *
     * @return requestInfo
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
     **/
    @Override
    public AdvancedCommerceRequestInfo getRequestInfo() {
        return super.getRequestInfo();
    }

    public AdvancedCommerceRequestRefundRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * The currency of the transaction.
     *
     * @return currency
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/currency">currency</a>
     **/
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AdvancedCommerceRequestRefundRequest items(List<AdvancedCommerceRequestRefundItem> items) {
        this.items = HelperValidationUtils.validateItems(items);
        return this;
    }

    public AdvancedCommerceRequestRefundRequest addItem(AdvancedCommerceRequestRefundItem item) {
        Objects.requireNonNull(item);
        this.items.add(item);
        return this;
    }

    /**
     * Information about the refund request for an item, such as its SKU, the refund amount, reason, and type.
     *
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
     **/
    public List<AdvancedCommerceRequestRefundItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceRequestRefundItem> items) {
        this.items = HelperValidationUtils.validateItems(items);
    }

    public AdvancedCommerceRequestRefundRequest refundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        return this;
    }

    /**
     * A Boolean value that indicates whether the App Store asks you for consumption data to help inform the refund decision.
     *
     * @return refundRiskingPreference
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundriskingpreference">refundRiskingPreference</a>
     **/
    public Boolean getRefundRiskingPreference() {
        return refundRiskingPreference;
    }

    public void setRefundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
    }

    public AdvancedCommerceRequestRefundRequest storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * A three-letter code that represents the country or region associated with the App Store storefront.
     *
     * @return storefront
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/storefront">storefront</a>
     **/
    public String getStorefront() {
        return storefront;
    }

    public void setStorefront(String storefront) {
        this.storefront = storefront;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AdvancedCommerceRequestRefundRequest advancedCommerceRequestRefundRequest = (AdvancedCommerceRequestRefundRequest) o;
        return Objects.equals(this.currency, advancedCommerceRequestRefundRequest.currency) &&
                Objects.equals(this.items, advancedCommerceRequestRefundRequest.items) &&
                Objects.equals(this.refundRiskingPreference, advancedCommerceRequestRefundRequest.refundRiskingPreference) &&
                Objects.equals(this.storefront, advancedCommerceRequestRefundRequest.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency, items, refundRiskingPreference, storefront);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceRequestRefundRequest{" +
                "requestInfo=" + getRequestInfo() +
                ", currency='" + currency + '\'' +
                ", items=" + items +
                ", refundRiskingPreference=" + refundRiskingPreference +
                ", storefront='" + storefront + '\'' +
                '}';
    }
}
