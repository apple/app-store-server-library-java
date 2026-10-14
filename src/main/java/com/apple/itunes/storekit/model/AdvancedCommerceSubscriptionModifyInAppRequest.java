// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request data your app provides to make changes to an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyinapprequest">SubscriptionModifyInAppRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionModifyInAppRequest extends AbstractAdvancedCommerceInAppRequest<AdvancedCommerceSubscriptionModifyInAppRequest> {
    private static final String OPERATION = "MODIFY_SUBSCRIPTION";
    private static final String VERSION = "1";

    private static final String SERIALIZED_NAME_ADD_ITEMS = "addItems";
    private static final String SERIALIZED_NAME_CHANGE_ITEMS = "changeItems";
    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_DESCRIPTORS = "descriptors";
    private static final String SERIALIZED_NAME_PERIOD_CHANGE = "periodChange";
    private static final String SERIALIZED_NAME_REMOVE_ITEMS = "removeItems";
    private static final String SERIALIZED_NAME_RETAIN_BILLING_CYCLE = "retainBillingCycle";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_TAX_CODE = "taxCode";
    private static final String SERIALIZED_NAME_TRANSACTION_ID = "transactionId";

    @JsonProperty(SERIALIZED_NAME_ADD_ITEMS)
    private List<AdvancedCommerceSubscriptionModifyAddItem> addItems;
    @JsonProperty(SERIALIZED_NAME_CHANGE_ITEMS)
    private List<AdvancedCommerceSubscriptionModifyChangeItem> changeItems;
    @JsonProperty(SERIALIZED_NAME_CURRENCY)
    private String currency;
    @JsonProperty(SERIALIZED_NAME_DESCRIPTORS)
    private AdvancedCommerceSubscriptionModifyDescriptors descriptors;
    @JsonProperty(SERIALIZED_NAME_PERIOD_CHANGE)
    private AdvancedCommerceSubscriptionModifyPeriodChange periodChange;
    @JsonProperty(SERIALIZED_NAME_REMOVE_ITEMS)
    private List<AdvancedCommerceSubscriptionModifyRemoveItem> removeItems;
    @JsonProperty(value = SERIALIZED_NAME_RETAIN_BILLING_CYCLE, required = true)
    private Boolean retainBillingCycle;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @JsonProperty(SERIALIZED_NAME_TAX_CODE)
    private String taxCode;
    @JsonProperty(value = SERIALIZED_NAME_TRANSACTION_ID, required = true)
    private String transactionId;

    protected AdvancedCommerceSubscriptionModifyInAppRequest() {
        super(OPERATION, VERSION);
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest(
            AdvancedCommerceRequestInfo requestInfo,
            Boolean retainBillingCycle,
            String transactionId
    ) {
        super(OPERATION, VERSION, requestInfo);
        this.retainBillingCycle = Objects.requireNonNull(retainBillingCycle);
        this.transactionId = Objects.requireNonNull(transactionId);
    }

    @Override
    protected AdvancedCommerceSubscriptionModifyInAppRequest self() {
        return this;
    }

    /**
     * @return operation
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyinapprequest">SubscriptionModifyInAppRequest</a>
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

    public AdvancedCommerceSubscriptionModifyInAppRequest addItems(List<AdvancedCommerceSubscriptionModifyAddItem> addItems) {
        this.addItems = addItems != null ? HelperValidationUtils.validateItems(addItems) : null;
        return this;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest addAddItem(AdvancedCommerceSubscriptionModifyAddItem addItem) {
        Objects.requireNonNull(addItem);
        if (this.addItems == null) {
            this.addItems = new ArrayList<>();
        }
        this.addItems.add(addItem);
        return this;
    }

    /**
     * The data your app provides to add items when it makes changes to an auto-renewable subscription.
     *
     * @return addItems
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyadditem">SubscriptionModifyAddItem</a>
     **/
    public List<AdvancedCommerceSubscriptionModifyAddItem> getAddItems() {
        return addItems;
    }

    public void setAddItems(List<AdvancedCommerceSubscriptionModifyAddItem> addItems) {
        this.addItems = addItems != null ? HelperValidationUtils.validateItems(addItems) : null;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest changeItems(List<AdvancedCommerceSubscriptionModifyChangeItem> changeItems) {
        this.changeItems = changeItems != null ? HelperValidationUtils.validateItems(changeItems) : null;
        return this;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest addChangeItem(AdvancedCommerceSubscriptionModifyChangeItem changeItem) {
        Objects.requireNonNull(changeItem);
        if (this.changeItems == null) {
            this.changeItems = new ArrayList<>();
        }
        this.changeItems.add(changeItem);
        return this;
    }

    /**
     * The data your app provides to change an item of an auto-renewable subscription.
     *
     * @return changeItems
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifychangeitem">SubscriptionModifyChangeItem</a>
     **/
    public List<AdvancedCommerceSubscriptionModifyChangeItem> getChangeItems() {
        return changeItems;
    }

    public void setChangeItems(List<AdvancedCommerceSubscriptionModifyChangeItem> changeItems) {
        this.changeItems = changeItems != null ? HelperValidationUtils.validateItems(changeItems) : null;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest currency(String currency) {
        this.currency = currency;
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
        this.currency = currency;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest descriptors(AdvancedCommerceSubscriptionModifyDescriptors descriptors) {
        this.descriptors = descriptors;
        return this;
    }

    /**
     * The data your app provides to change the description and display name of an auto-renewable subscription.
     *
     * @return descriptors
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifydescriptors">SubscriptionModifyDescriptors</a>
     **/
    public AdvancedCommerceSubscriptionModifyDescriptors getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(AdvancedCommerceSubscriptionModifyDescriptors descriptors) {
        this.descriptors = descriptors;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest periodChange(AdvancedCommerceSubscriptionModifyPeriodChange periodChange) {
        this.periodChange = periodChange;
        return this;
    }

    /**
     * The data your app provides to change the period of an auto-renewable subscription.
     *
     * @return periodChange
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyperiodchange">SubscriptionModifyPeriodChange</a>
     **/
    public AdvancedCommerceSubscriptionModifyPeriodChange getPeriodChange() {
        return periodChange;
    }

    public void setPeriodChange(AdvancedCommerceSubscriptionModifyPeriodChange periodChange) {
        this.periodChange = periodChange;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest removeItems(List<AdvancedCommerceSubscriptionModifyRemoveItem> removeItems) {
        this.removeItems = removeItems != null ? HelperValidationUtils.validateItems(removeItems) : null;
        return this;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest addRemoveItem(AdvancedCommerceSubscriptionModifyRemoveItem removeItem) {
        Objects.requireNonNull(removeItem);
        if (this.removeItems == null) {
            this.removeItems = new ArrayList<>();
        }
        this.removeItems.add(removeItem);
        return this;
    }

    /**
     * The data your app provides to remove an item from an auto-renewable subscription.
     *
     * @return removeItems
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyremoveitem">SubscriptionModifyRemoveItem</a>
     **/
    public List<AdvancedCommerceSubscriptionModifyRemoveItem> getRemoveItems() {
        return removeItems;
    }

    public void setRemoveItems(List<AdvancedCommerceSubscriptionModifyRemoveItem> removeItems) {
        this.removeItems = removeItems != null ? HelperValidationUtils.validateItems(removeItems) : null;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest retainBillingCycle(Boolean retainBillingCycle) {
        this.retainBillingCycle = Objects.requireNonNull(retainBillingCycle);
        return this;
    }

    /**
     * A Boolean value that determines whether to keep the existing billing cycle with the change you request.
     *
     * @return retainBillingCycle
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/retainbillingcycle">retainBillingCycle</a>
     **/
    public Boolean getRetainBillingCycle() {
        return retainBillingCycle;
    }

    public void setRetainBillingCycle(Boolean retainBillingCycle) {
        this.retainBillingCycle = Objects.requireNonNull(retainBillingCycle);
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest storefront(String storefront) {
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

    public AdvancedCommerceSubscriptionModifyInAppRequest taxCode(String taxCode) {
        this.taxCode = taxCode;
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
        this.taxCode = taxCode;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest transactionId(String transactionId) {
        this.transactionId = Objects.requireNonNull(transactionId);
        return this;
    }

    /**
     * A unique identifier that the App Store generates for a transaction.
     *
     * @return transactionId
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/transactionid">transactionId</a>
     **/
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = Objects.requireNonNull(transactionId);
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
        AdvancedCommerceSubscriptionModifyInAppRequest advancedCommerceSubscriptionModifyInAppRequest = (AdvancedCommerceSubscriptionModifyInAppRequest) o;
        return Objects.equals(this.addItems, advancedCommerceSubscriptionModifyInAppRequest.addItems) &&
                Objects.equals(this.changeItems, advancedCommerceSubscriptionModifyInAppRequest.changeItems) &&
                Objects.equals(this.currency, advancedCommerceSubscriptionModifyInAppRequest.currency) &&
                Objects.equals(this.descriptors, advancedCommerceSubscriptionModifyInAppRequest.descriptors) &&
                Objects.equals(this.periodChange, advancedCommerceSubscriptionModifyInAppRequest.periodChange) &&
                Objects.equals(this.removeItems, advancedCommerceSubscriptionModifyInAppRequest.removeItems) &&
                Objects.equals(this.retainBillingCycle, advancedCommerceSubscriptionModifyInAppRequest.retainBillingCycle) &&
                Objects.equals(this.storefront, advancedCommerceSubscriptionModifyInAppRequest.storefront) &&
                Objects.equals(this.taxCode, advancedCommerceSubscriptionModifyInAppRequest.taxCode) &&
                Objects.equals(this.transactionId, advancedCommerceSubscriptionModifyInAppRequest.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addItems, changeItems, currency, descriptors, periodChange, removeItems, retainBillingCycle, storefront, taxCode, transactionId);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionModifyInAppRequest{" +
                "operation='" + getOperation() + '\'' +
                ", version='" + getVersion() + '\'' +
                ", requestInfo=" + getRequestInfo() +
                ", addItems=" + addItems +
                ", changeItems=" + changeItems +
                ", currency='" + currency + '\'' +
                ", descriptors=" + descriptors +
                ", periodChange=" + periodChange +
                ", removeItems=" + removeItems +
                ", retainBillingCycle=" + retainBillingCycle +
                ", storefront='" + storefront + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
