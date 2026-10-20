// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * The request data your app provides when a customer purchases an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncreaterequest">SubscriptionCreateRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionCreateRequest extends AbstractAdvancedCommerceInAppRequest<AdvancedCommerceSubscriptionCreateRequest> {
    private static final String OPERATION = "CREATE_SUBSCRIPTION";
    private static final String VERSION = "1";

    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_DESCRIPTORS = "descriptors";
    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_PERIOD = "period";
    private static final String SERIALIZED_NAME_PREVIOUS_TRANSACTION_ID = "previousTransactionId";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_TAX_CODE = "taxCode";

    @JsonProperty(value = SERIALIZED_NAME_CURRENCY, required = true)
    private String currency;
    @JsonProperty(value = SERIALIZED_NAME_DESCRIPTORS, required = true)
    private AdvancedCommerceDescriptors descriptors;
    @JsonProperty(value = SERIALIZED_NAME_ITEMS, required = true)
    private List<AdvancedCommerceSubscriptionCreateItem> items;
    @JsonProperty(value = SERIALIZED_NAME_PERIOD, required = true)
    private String period;
    @JsonProperty(SERIALIZED_NAME_PREVIOUS_TRANSACTION_ID)
    private String previousTransactionId;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @JsonProperty(value = SERIALIZED_NAME_TAX_CODE, required = true)
    private String taxCode;

    protected AdvancedCommerceSubscriptionCreateRequest() {
        super(OPERATION, VERSION);
    }

    public AdvancedCommerceSubscriptionCreateRequest(
            AdvancedCommerceRequestInfo requestInfo,
            String currency,
            AdvancedCommerceDescriptors descriptors,
            List<AdvancedCommerceSubscriptionCreateItem> items,
            AdvancedCommercePeriod period,
            String taxCode
    ) {
        super(OPERATION, VERSION, requestInfo);
        this.currency = Objects.requireNonNull(currency);
        this.descriptors = Objects.requireNonNull(descriptors);
        this.items = HelperValidationUtils.validateItems(items);
        this.period = Objects.requireNonNull(period).getValue();
        this.taxCode = Objects.requireNonNull(taxCode);
    }

    public AdvancedCommerceSubscriptionCreateRequest(
            AdvancedCommerceRequestInfo requestInfo,
            String currency,
            AdvancedCommerceDescriptors descriptors,
            List<AdvancedCommerceSubscriptionCreateItem> items,
            String rawPeriod,
            String taxCode
    ) {
        super(OPERATION, VERSION, requestInfo);
        this.currency = Objects.requireNonNull(currency);
        this.descriptors = Objects.requireNonNull(descriptors);
        this.items = HelperValidationUtils.validateItems(items);
        this.period = Objects.requireNonNull(rawPeriod);
        this.taxCode = Objects.requireNonNull(taxCode);
    }

    @Override
    protected AdvancedCommerceSubscriptionCreateRequest self() {
        return this;
    }

    /**
     * @return operation
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncreaterequest">SubscriptionCreateRequest</a>
     **/
    @Override
    public String getOperation() {
        return super.getOperation();
    }

    /**
     * A number that represents the version of the data structure or Advanced Commerce API.
     *
     * @return version
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/version">version</a>
     **/
    @Override
    public String getVersion() {
        return super.getVersion();
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

    public AdvancedCommerceSubscriptionCreateRequest currency(String currency) {
        this.currency = Objects.requireNonNull(currency);
        return this;
    }

    /**
     * The three-letter ISO 4217 currency code for the price of a product.
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

    public AdvancedCommerceSubscriptionCreateRequest descriptors(AdvancedCommerceDescriptors descriptors) {
        this.descriptors = Objects.requireNonNull(descriptors);
        return this;
    }

    /**
     * The display name and description of a subscription product.
     *
     * @return descriptors
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/descriptors">Descriptors</a>
     **/
    public AdvancedCommerceDescriptors getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(AdvancedCommerceDescriptors descriptors) {
        this.descriptors = Objects.requireNonNull(descriptors);
    }

    public AdvancedCommerceSubscriptionCreateRequest items(List<AdvancedCommerceSubscriptionCreateItem> items) {
        this.items = HelperValidationUtils.validateItems(items);
        return this;
    }

    public AdvancedCommerceSubscriptionCreateRequest addItem(AdvancedCommerceSubscriptionCreateItem item) {
        Objects.requireNonNull(item);
        this.items.add(item);
        return this;
    }

    /**
     * The data that describes a subscription item.
     *
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncreateitem">SubscriptionCreateItem</a>
     **/
    public List<AdvancedCommerceSubscriptionCreateItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceSubscriptionCreateItem> items) {
        this.items = HelperValidationUtils.validateItems(items);
    }

    public AdvancedCommerceSubscriptionCreateRequest period(AdvancedCommercePeriod period) {
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

    public AdvancedCommerceSubscriptionCreateRequest previousTransactionId(String previousTransactionId) {
        this.previousTransactionId = previousTransactionId;
        return this;
    }

    /**
     * A unique identifier that the App Store generates for a transaction.
     *
     * @return previousTransactionId
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/transactionid">transactionId</a>
     **/
    public String getPreviousTransactionId() {
        return previousTransactionId;
    }

    public void setPreviousTransactionId(String previousTransactionId) {
        this.previousTransactionId = previousTransactionId;
    }

    public AdvancedCommerceSubscriptionCreateRequest storefront(String storefront) {
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

    public AdvancedCommerceSubscriptionCreateRequest taxCode(String taxCode) {
        this.taxCode = Objects.requireNonNull(taxCode);
        return this;
    }

    /**
     * A tax code that applies to a SKU.
     *
     * @return taxCode
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/taxcode">taxCode</a>
     **/
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = Objects.requireNonNull(taxCode);
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
        AdvancedCommerceSubscriptionCreateRequest advancedCommerceSubscriptionCreateRequest = (AdvancedCommerceSubscriptionCreateRequest) o;
        return Objects.equals(this.currency, advancedCommerceSubscriptionCreateRequest.currency) &&
                Objects.equals(this.descriptors, advancedCommerceSubscriptionCreateRequest.descriptors) &&
                Objects.equals(this.items, advancedCommerceSubscriptionCreateRequest.items) &&
                Objects.equals(this.period, advancedCommerceSubscriptionCreateRequest.period) &&
                Objects.equals(this.previousTransactionId, advancedCommerceSubscriptionCreateRequest.previousTransactionId) &&
                Objects.equals(this.storefront, advancedCommerceSubscriptionCreateRequest.storefront) &&
                Objects.equals(this.taxCode, advancedCommerceSubscriptionCreateRequest.taxCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency, descriptors, items, period, previousTransactionId, storefront, taxCode);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionCreateRequest{" +
                "operation='" + getOperation() + '\'' +
                ", version='" + getVersion() + '\'' +
                ", requestInfo=" + getRequestInfo() +
                ", currency='" + currency + '\'' +
                ", descriptors=" + descriptors +
                ", items=" + items +
                ", period='" + period + '\'' +
                ", previousTransactionId='" + previousTransactionId + '\'' +
                ", storefront='" + storefront + '\'' +
                ", taxCode='" + taxCode + '\'' +
                '}';
    }
}
