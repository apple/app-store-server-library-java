// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * The request body for requesting a refund for a transaction.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefundrequest">RequestRefundRequest</a>
 */
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

    private AdvancedCommerceRequestRefundRequest() {
        super();
    }

    public AdvancedCommerceRequestRefundRequest(
            List<AdvancedCommerceRequestRefundItem> items,
            Boolean refundRiskingPreference,
            AdvancedCommerceRequestInfo requestInfo
    ) {
        super(requestInfo);
        this.items = Objects.requireNonNull(items);
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
    }

    @Override
    protected AdvancedCommerceRequestRefundRequest self() {
        return this;
    }

    public AdvancedCommerceRequestRefundRequest currency(String currency) {
        this.currency = Objects.requireNonNull(currency);
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
        this.currency = Objects.requireNonNull(currency);
    }

    public AdvancedCommerceRequestRefundRequest items(List<AdvancedCommerceRequestRefundItem> items) {
        this.items = Objects.requireNonNull(items);
        return this;
    }

    public AdvancedCommerceRequestRefundRequest addItem(AdvancedCommerceRequestRefundItem item) {
        Objects.requireNonNull(item);
        this.items.add(item);
        return this;
    }

    /**
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
     **/
    public List<AdvancedCommerceRequestRefundItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceRequestRefundItem> items) {
        this.items = Objects.requireNonNull(items);
    }

    public AdvancedCommerceRequestRefundRequest refundRiskingPreference(Boolean refundRiskingPreference) {
        this.refundRiskingPreference = Objects.requireNonNull(refundRiskingPreference);
        return this;
    }

    /**
     * @return refundRiskingPreference
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundriskingpreference">RefundRiskingPreference</a>
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceRequestRefundRequest that = (AdvancedCommerceRequestRefundRequest) o;
        return Objects.equals(currency, that.currency) && 
            Objects.equals(items, that.items) && 
            Objects.equals(refundRiskingPreference, that.refundRiskingPreference) && 
            Objects.equals(storefront, that.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency, items, refundRiskingPreference, storefront);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "currency='" + currency + '\'' +
                ", items=" + items +
                ", refundRiskingPreference=" + refundRiskingPreference +
                ", requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                '}';
    }
}