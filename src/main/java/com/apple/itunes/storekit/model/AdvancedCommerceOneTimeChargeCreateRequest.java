// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request data your app provides when a customer purchases a one-time-charge product.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/onetimechargecreaterequest">OneTimeChargeCreateRequest</a>
 */
public class AdvancedCommerceOneTimeChargeCreateRequest extends AbstractAdvancedCommerceInAppRequest<AdvancedCommerceOneTimeChargeCreateRequest> {

    /**
     * The constant that represents the operation of this request.
     */
    private static final String OPERATION = "CREATE_ONE_TIME_CHARGE";
    /**
     * The version number of the API.
     */
    private static final String VERSION = "1";

    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_ITEM = "item";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_TAX_CODE = "taxCode";

    @JsonProperty(value = SERIALIZED_NAME_CURRENCY, required = true)
    private String currency;
    @JsonProperty(value = SERIALIZED_NAME_ITEM, required = true)
    private AdvancedCommerceOneTimeChargeItem item;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @JsonProperty(value = SERIALIZED_NAME_TAX_CODE, required = true)
    private String taxCode;

    private AdvancedCommerceOneTimeChargeCreateRequest() {}

    public AdvancedCommerceOneTimeChargeCreateRequest(
            String currency,
            AdvancedCommerceOneTimeChargeItem item,
            AdvancedCommerceRequestInfo requestInfo,
            String taxCode
    ) {
        super(OPERATION, VERSION, requestInfo);
        this.currency = Objects.requireNonNull(currency);
        this.item = Objects.requireNonNull(item);
        this.taxCode = Objects.requireNonNull(taxCode);
    }

    @Override
    protected AdvancedCommerceOneTimeChargeCreateRequest self() {
        return this;
    }

    public AdvancedCommerceOneTimeChargeCreateRequest currency(String currency) {
        this.currency = Objects.requireNonNull(currency);
        return this;
    }

    /**
     * The currency of the price of the product.
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

    public AdvancedCommerceOneTimeChargeCreateRequest item(AdvancedCommerceOneTimeChargeItem item) {
        this.item = Objects.requireNonNull(item);
        return this;
    }

    /**
     * The details of the product for purchase.
     *
     * @return item
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/onetimechargeitem">OneTimeChargeItem</a>
     **/
    public AdvancedCommerceOneTimeChargeItem getItem() {
        return item;
    }

    public void setItem(AdvancedCommerceOneTimeChargeItem item) {
        this.item = Objects.requireNonNull(item);
    }

    public AdvancedCommerceOneTimeChargeCreateRequest storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * The storefront for the transaction.
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

    public AdvancedCommerceOneTimeChargeCreateRequest taxCode(String taxCode) {
        this.taxCode = Objects.requireNonNull(taxCode);
        return this;
    }

    /**
     * The tax code for this product.
     *
     * @return taxCode
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/taxCode">taxCode</a>
     **/
    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = Objects.requireNonNull(taxCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceOneTimeChargeCreateRequest that = (AdvancedCommerceOneTimeChargeCreateRequest) o;
        return Objects.equals(currency, that.currency) && Objects.equals(item, that.item) && Objects.equals(storefront, that.storefront) && Objects.equals(taxCode, that.taxCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency, item, storefront, taxCode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "currency='" + currency + '\'' +
                ", item=" + item +
                ", requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                ", taxCode='" + taxCode + '\'' +
                "}";
    }
}