// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.List;

public class TransactionHistoryRequest {
    private Long startDate;
    private Long endDate;
    private List<String> productIds;
    private List<ProductType> productTypes;
    private Order sort;
    private List<String> subscriptionGroupIdentifiers;
    private InAppOwnershipType inAppOwnershipType;
    private Boolean revoked;

    /**
     * An optional start date of the timespan for the transaction history records you’re requesting. The startDate must precede the endDate if you specify both dates. To be included in results, the transaction’s purchaseDate must be equal to or greater than the startDate.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdate">startDate</a>
     */
    public Long getStartDate() {
        return startDate;
    }

    /**
     * @see #getStartDate()
     */
    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    /**
     * @see #getStartDate()
     */
    public TransactionHistoryRequest startDate(Long startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * An optional end date of the timespan for the transaction history records you’re requesting. Choose an endDate that’s later than the startDate if you specify both dates. Using an endDate in the future is valid. To be included in results, the transaction’s purchaseDate must be less than the endDate.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/enddate">endDate</a>
     */
    public Long getEndDate() {
        return endDate;
    }

    /**
     * @see #getEndDate()
     */
    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    /**
     * @see #getEndDate()
     */
    public TransactionHistoryRequest endDate(Long endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * An optional filter that indicates the product identifier to include in the transaction history. Your query may specify more than one productID.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/productid">productId</a>
     */
    public List<String> getProductIds() {
        return productIds;
    }

    /**
     * @see #getProductIds()
     */
    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }

    /**
     * @see #getProductIds()
     */
    public TransactionHistoryRequest productIds(List<String> productIds) {
        this.productIds = productIds;
        return this;
    }

    /**
     * An optional filter that indicates the product type to include in the transaction history. Your query may specify more than one productType.
     */
    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    /**
     * @see #getProductTypes()
     */
    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    /**
     * @see #getProductTypes()
     */
    public TransactionHistoryRequest productTypes(List<ProductType> productTypes) {
        this.productTypes = productTypes;
        return this;
    }

    /**
     * An optional sort order for the transaction history records. The response sorts the transaction records by their recently modified date. The default value is ASCENDING, so you receive the oldest records first.
     */
    public Order getSort() {
        return sort;
    }

    /**
     * @see #getSort()
     */
    public void setSort(Order sort) {
        this.sort = sort;
    }

    /**
     * @see #getSort()
     */
    public TransactionHistoryRequest sort(Order sort) {
        this.sort = sort;
        return this;
    }

    /**
     * An optional filter that indicates the subscription group identifier to include in the transaction history. Your query may specify more than one subscriptionGroupIdentifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptiongroupidentifier">subscriptionGroupIdentifier</a>
     */
    public List<String> getSubscriptionGroupIdentifiers() {
        return subscriptionGroupIdentifiers;
    }

    /**
     * @see #getSubscriptionGroupIdentifiers()
     */
    public void setSubscriptionGroupIdentifiers(List<String> subscriptionGroupIdentifiers) {
        this.subscriptionGroupIdentifiers = subscriptionGroupIdentifiers;
    }

    /**
     * @see #getSubscriptionGroupIdentifiers()
     */
    public TransactionHistoryRequest subscriptionGroupIdentifiers(List<String> subscriptionGroupIdentifiers) {
        this.subscriptionGroupIdentifiers = subscriptionGroupIdentifiers;
        return this;
    }

    /**
     * An optional filter that limits the transaction history by the in-app ownership type.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/inappownershiptype">inAppOwnershipType</a>
     */
    public InAppOwnershipType getInAppOwnershipType() {
        return inAppOwnershipType;
    }

    /**
     * @see #getInAppOwnershipType()
     */
    public void setInAppOwnershipType(InAppOwnershipType inAppOwnershipType) {
        this.inAppOwnershipType = inAppOwnershipType;
    }

    /**
     * @see #getInAppOwnershipType()
     */
    public TransactionHistoryRequest inAppOwnershipType(InAppOwnershipType inAppOwnershipType) {
        this.inAppOwnershipType = inAppOwnershipType;
        return this;
    }

    /**
     * An optional Boolean value that indicates whether the response includes only revoked transactions when the value is true, or contains only nonrevoked transactions when the value is false. By default, the request doesn't include this parameter.
     */
    public Boolean getRevoked() {
        return revoked;
    }

    /**
     * @see #getRevoked()
     */
    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }

    /**
     * @see #getRevoked()
     */
    public TransactionHistoryRequest revoked(Boolean revoked) {
        this.revoked = revoked;
        return this;
    }

    public enum ProductType {
        AUTO_RENEWABLE,
        NON_RENEWABLE,
        CONSUMABLE,
        NON_CONSUMABLE
    }

    public enum Order {
        ASCENDING,
        DESCENDING
    }

    @Override
    public String toString() {
        return "TransactionHistoryRequest{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", productIds=" + productIds +
                ", productTypes=" + productTypes +
                ", sort=" + sort +
                ", subscriptionGroupIdentifiers=" + subscriptionGroupIdentifiers +
                ", inAppOwnershipType=" + inAppOwnershipType +
                ", revoked=" + revoked +
                '}';
    }
}
