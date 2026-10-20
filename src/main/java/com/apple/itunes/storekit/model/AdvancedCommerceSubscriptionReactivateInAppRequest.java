// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request your app provides to reactivate a subscription that has automatic renewal turned off.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateinapprequest">SubscriptionReactivateInAppRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionReactivateInAppRequest extends AbstractAdvancedCommerceInAppRequest<AdvancedCommerceSubscriptionReactivateInAppRequest> {
    private static final String OPERATION = "REACTIVATE_SUBSCRIPTION";
    private static final String VERSION = "1";

    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_TRANSACTION_ID = "transactionId";

    @JsonProperty(SERIALIZED_NAME_ITEMS)
    private List<AdvancedCommerceSubscriptionReactivateItem> items;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @JsonProperty(value = SERIALIZED_NAME_TRANSACTION_ID, required = true)
    private String transactionId;

    protected AdvancedCommerceSubscriptionReactivateInAppRequest() {
        super(OPERATION, VERSION);
    }

    public AdvancedCommerceSubscriptionReactivateInAppRequest(
            AdvancedCommerceRequestInfo requestInfo,
            String transactionId
    ) {
        super(OPERATION, VERSION, requestInfo);
        this.transactionId = Objects.requireNonNull(transactionId);
    }

    @Override
    protected AdvancedCommerceSubscriptionReactivateInAppRequest self() {
        return this;
    }

    /**
     * @return operation
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateinapprequest">SubscriptionReactivateInAppRequest</a>
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

    public AdvancedCommerceSubscriptionReactivateInAppRequest items(List<AdvancedCommerceSubscriptionReactivateItem> items) {
        this.items = items != null ? HelperValidationUtils.validateItems(items) : null;
        return this;
    }

    public AdvancedCommerceSubscriptionReactivateInAppRequest addItem(AdvancedCommerceSubscriptionReactivateItem item) {
        Objects.requireNonNull(item);
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        return this;
    }

    /**
     * An item in a subscription to reactivate.
     *
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateitem">SubscriptionReactivateItem</a>
     **/
    public List<AdvancedCommerceSubscriptionReactivateItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceSubscriptionReactivateItem> items) {
        this.items = items != null ? HelperValidationUtils.validateItems(items) : null;
    }

    public AdvancedCommerceSubscriptionReactivateInAppRequest storefront(String storefront) {
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

    public AdvancedCommerceSubscriptionReactivateInAppRequest transactionId(String transactionId) {
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
        AdvancedCommerceSubscriptionReactivateInAppRequest advancedCommerceSubscriptionReactivateInAppRequest = (AdvancedCommerceSubscriptionReactivateInAppRequest) o;
        return Objects.equals(this.items, advancedCommerceSubscriptionReactivateInAppRequest.items) &&
                Objects.equals(this.storefront, advancedCommerceSubscriptionReactivateInAppRequest.storefront) &&
                Objects.equals(this.transactionId, advancedCommerceSubscriptionReactivateInAppRequest.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items, storefront, transactionId);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionReactivateInAppRequest{" +
                "operation='" + getOperation() + '\'' +
                ", version='" + getVersion() + '\'' +
                ", requestInfo=" + getRequestInfo() +
                ", items=" + items +
                ", storefront='" + storefront + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
