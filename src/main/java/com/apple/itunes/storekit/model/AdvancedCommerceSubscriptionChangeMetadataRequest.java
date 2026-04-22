// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The request body you provide to change the metadata of a subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadatarequest">SubscriptionChangeMetadataRequest</a>
 */
public class AdvancedCommerceSubscriptionChangeMetadataRequest extends AdvancedCommerceRequest<AdvancedCommerceSubscriptionChangeMetadataRequest> {
    private static final String SERIALIZED_NAME_DESCRIPTORS = "descriptors";
    private static final String SERIALIZED_NAME_ITEMS = "items";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_TAX_CODE = "taxCode";

    @JsonProperty(SERIALIZED_NAME_DESCRIPTORS)
    private AdvancedCommerceSubscriptionChangeMetadataDescriptors descriptors;
    @JsonProperty(SERIALIZED_NAME_ITEMS)
    private List<AdvancedCommerceSubscriptionChangeMetadataItem> items;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @JsonProperty(SERIALIZED_NAME_TAX_CODE)
    private String taxCode;

    private AdvancedCommerceSubscriptionChangeMetadataRequest() {}

    public AdvancedCommerceSubscriptionChangeMetadataRequest(AdvancedCommerceRequestInfo requestInfo) {
        super(requestInfo);
    }

    @Override
    protected AdvancedCommerceSubscriptionChangeMetadataRequest self() {
        return this;
    }

    public AdvancedCommerceSubscriptionChangeMetadataRequest descriptors(AdvancedCommerceSubscriptionChangeMetadataDescriptors descriptors) {
        this.descriptors = descriptors;
        return this;
    }

    /**
     * @return descriptors
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadatadescriptors">SubscriptionChangeMetadataDescriptors</a>
     **/
    public AdvancedCommerceSubscriptionChangeMetadataDescriptors getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(AdvancedCommerceSubscriptionChangeMetadataDescriptors descriptors) {
        this.descriptors = descriptors;
    }

    public AdvancedCommerceSubscriptionChangeMetadataRequest items(List<AdvancedCommerceSubscriptionChangeMetadataItem> items) {
        this.items = items;
        return this;
    }

    public AdvancedCommerceSubscriptionChangeMetadataRequest addItem(AdvancedCommerceSubscriptionChangeMetadataItem item) {
        Objects.requireNonNull(item);
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        return this;
    }

    /**
     * @return items
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionchangemetadataitem">SubscriptionChangeMetadataItem</a>
     **/
    public List<AdvancedCommerceSubscriptionChangeMetadataItem> getItems() {
        return items;
    }

    public void setItems(List<AdvancedCommerceSubscriptionChangeMetadataItem> items) {
        this.items = items;
    }


    public AdvancedCommerceSubscriptionChangeMetadataRequest taxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    /**
     * @return taxCode
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/taxcode">TaxCode</a>
     **/
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public AdvancedCommerceSubscriptionChangeMetadataRequest storefront(String storefront) {
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
        AdvancedCommerceSubscriptionChangeMetadataRequest that = (AdvancedCommerceSubscriptionChangeMetadataRequest) o;
        return Objects.equals(descriptors, that.descriptors) && Objects.equals(items, that.items) && Objects.equals(taxCode, that.taxCode) && Objects.equals(storefront, that.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descriptors, items, storefront, taxCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "descriptors=" + descriptors + '\'' +
                ", items=" + items + '\'' +
                ", requestInfo=" + getRequestInfo() + '\'' +
                ", storefront='" + storefront + '\'' +
                ", taxCode='" + taxCode + '\'' +
                '}';
    }
}