// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request your app provides to reactivate a subscription that has automatic renewal turned off.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateinapprequest">SubscriptionReactivateInAppRequest</a>
 */
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

    private AdvancedCommerceSubscriptionReactivateInAppRequest() {}

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

    public AdvancedCommerceSubscriptionReactivateInAppRequest items(List<AdvancedCommerceSubscriptionReactivateItem> items) {
        this.items = items;
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
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionreactivateitem">SubscriptionReactivateItem</a>
     **/
    public List<AdvancedCommerceSubscriptionReactivateItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceSubscriptionReactivateItem> items) {
        this.items = items;
    }

    public AdvancedCommerceSubscriptionReactivateInAppRequest storefront(String storefront) {
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

    public AdvancedCommerceSubscriptionReactivateInAppRequest transactionId(String transactionId) {
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
        AdvancedCommerceSubscriptionReactivateInAppRequest that = (AdvancedCommerceSubscriptionReactivateInAppRequest) o;
        return Objects.equals(items, that.items) && Objects.equals(storefront, that.storefront) && Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items, storefront, transactionId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "items=" + items +
                ", requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}