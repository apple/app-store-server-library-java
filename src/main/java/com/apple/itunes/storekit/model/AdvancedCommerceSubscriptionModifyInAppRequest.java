// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request data your app provides to make changes to an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyinapprequest">SubscriptionModifyInAppRequest</a>
 */
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

    private AdvancedCommerceSubscriptionModifyInAppRequest() {}

    public AdvancedCommerceSubscriptionModifyInAppRequest(
            AdvancedCommerceRequestInfo requestInfo,
            String transactionId,
            Boolean retainBillingCycle
    ) {
        super(OPERATION, VERSION, requestInfo);
        this.transactionId = Objects.requireNonNull(transactionId);
        this.retainBillingCycle = Objects.requireNonNull(retainBillingCycle);
    }

    @Override
    protected AdvancedCommerceSubscriptionModifyInAppRequest self() {
        return this;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest addItems(List<AdvancedCommerceSubscriptionModifyAddItem> addItems) {
        this.addItems = addItems != null ? AdvancedCommerceValidationUtils.validateItems(addItems) : null;
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
     * @return addItems
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyadditem">SubscriptionModifyAddItem</a>
     **/
    public List<AdvancedCommerceSubscriptionModifyAddItem> getAddItems() {
        return addItems;
    }

    public void setAddItems(List<AdvancedCommerceSubscriptionModifyAddItem> addItems) {
        this.addItems = addItems != null ? AdvancedCommerceValidationUtils.validateItems(addItems) : null;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest changeItems(List<AdvancedCommerceSubscriptionModifyChangeItem> changeItems) {
        this.changeItems = changeItems != null ? AdvancedCommerceValidationUtils.validateItems(changeItems) : null;
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
     * @return changeItems
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifychangeitem">SubscriptionModifyChangeItem</a>
     **/
    public List<AdvancedCommerceSubscriptionModifyChangeItem> getChangeItems() {
        return changeItems;
    }

    public void setChangeItems(List<AdvancedCommerceSubscriptionModifyChangeItem> changeItems) {
        this.changeItems = changeItems != null ? AdvancedCommerceValidationUtils.validateItems(changeItems) : null;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
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
        this.removeItems = removeItems;
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
     * @return removeItems
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifyremoveitem">SubscriptionModifyRemoveItem</a>
     **/
    public List<AdvancedCommerceSubscriptionModifyRemoveItem> getRemoveItems() {
        return removeItems;
    }

    public void setRemoveItems(List<AdvancedCommerceSubscriptionModifyRemoveItem> removeItems) {
        this.removeItems = removeItems;
    }

    public AdvancedCommerceSubscriptionModifyInAppRequest retainBillingCycle(Boolean retainBillingCycle) {
        this.retainBillingCycle = Objects.requireNonNull(retainBillingCycle);
        return this;
    }

    /**
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceSubscriptionModifyInAppRequest that = (AdvancedCommerceSubscriptionModifyInAppRequest) o;
        return Objects.equals(addItems, that.addItems) && Objects.equals(changeItems, that.changeItems) && Objects.equals(currency, that.currency) && Objects.equals(descriptors, that.descriptors) && Objects.equals(periodChange, that.periodChange) && Objects.equals(removeItems, that.removeItems) && Objects.equals(retainBillingCycle, that.retainBillingCycle) && Objects.equals(storefront, that.storefront) && Objects.equals(taxCode, that.taxCode) && Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), addItems, changeItems, currency, descriptors, periodChange, removeItems, retainBillingCycle, storefront, taxCode, transactionId);
    }

    @Override
    public String toString() {
         return getClass().getSimpleName() + "{" +
                "addItems=" + addItems +
                ", changeItems=" + changeItems +
                ", currency='" + currency + '\'' +
                ", descriptors=" + descriptors +
                ", periodChange=" + periodChange +
                ", removeItems=" + removeItems +
                ", retainBillingCycle=" + retainBillingCycle +
                ", requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}