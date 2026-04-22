// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to change an item of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifychangeitem">SubscriptionModifyChangeItem</a>
 */
public class AdvancedCommerceSubscriptionModifyChangeItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_CURRENT_SKU = "currentSKU";
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_PRORATED_PRICE = "proratedPrice";
    private static final String SERIALIZED_NAME_REASON = "reason";

    @JsonProperty(value = SERIALIZED_NAME_CURRENT_SKU, required = true)
    private String currentSKU;
    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private AdvancedCommerceEffective effective;
    @JsonProperty(SERIALIZED_NAME_OFFER)
    private AdvancedCommerceOffer offer;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;
    @JsonProperty(SERIALIZED_NAME_PRORATED_PRICE)
    private Long proratedPrice;
    @JsonProperty(value = SERIALIZED_NAME_REASON, required = true)
    private AdvancedCommerceReason reason;

    private AdvancedCommerceSubscriptionModifyChangeItem() {}

    @Override
    protected AdvancedCommerceSubscriptionModifyChangeItem self() {
       return this;
    }

    public AdvancedCommerceSubscriptionModifyChangeItem(String currentSKU, String description, String displayName, AdvancedCommerceEffective effective, Long price, AdvancedCommerceReason reason, String sku) {
        super(sku, description, displayName);
        this.currentSKU = AdvancedCommerceValidationUtils.validateSku(currentSKU);
        this.effective = Objects.requireNonNull(effective);
        this.price = Objects.requireNonNull(price);
        this.reason = Objects.requireNonNull(reason);
    }

    public AdvancedCommerceSubscriptionModifyChangeItem currentSKU(String currentSKU) {
        this.currentSKU = AdvancedCommerceValidationUtils.validateSku(currentSKU);
        return this;
    }

    /**
     * @return currentSKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     */
    public String getCurrentSKU() {
        return currentSKU;
    }

    public void setCurrentSKU(String currentSKU) {
        this.currentSKU = AdvancedCommerceValidationUtils.validateSku(currentSKU);
    }

    public AdvancedCommerceSubscriptionModifyChangeItem effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
        return this;
    }

    /**
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective);
    }

    public AdvancedCommerceSubscriptionModifyChangeItem offer(AdvancedCommerceOffer offer) {
        this.offer = offer;
        return this;
    }

    /**
     * @return offer
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offer">Offer</a>
     **/
    public AdvancedCommerceOffer getOffer() {
        return offer;
    }

    public void setOffer(AdvancedCommerceOffer offer) {
        this.offer = offer;
    }

    public AdvancedCommerceSubscriptionModifyChangeItem price(Long price) {
        this.price = Objects.requireNonNull(price);
        return this;
    }

    /**
     * @return price
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/price">price</a>
     **/
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = Objects.requireNonNull(price);
    }

    public AdvancedCommerceSubscriptionModifyChangeItem proratedPrice(Long proratedPrice) {
        this.proratedPrice = proratedPrice;
        return this;
    }

    /**
     * @return proratedPrice
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/proratedprice">proratedPrice</a>
     **/
    public Long getProratedPrice() {
        return proratedPrice;
    }

    public void setProratedPrice(Long proratedPrice) {
        this.proratedPrice = proratedPrice;
    }

    public AdvancedCommerceSubscriptionModifyChangeItem reason(AdvancedCommerceReason reason) {
        this.reason = Objects.requireNonNull(reason);
        return this;
    }

    /**
     * @return reason
     */
    public AdvancedCommerceReason getReason() {
        return reason;
    }

    public void setReason(AdvancedCommerceReason reason) {
        this.reason = Objects.requireNonNull(reason);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdvancedCommerceSubscriptionModifyChangeItem that = (AdvancedCommerceSubscriptionModifyChangeItem) o;
        return Objects.equals(currentSKU, that.currentSKU) && Objects.equals(effective, that.effective) && Objects.equals(offer, that.offer) && Objects.equals(price, that.price) && Objects.equals(proratedPrice, that.proratedPrice) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentSKU, effective, offer, price, proratedPrice, reason);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", displayName='" + displayName + '\'' +
                ", currentSKU='" + currentSKU + '\'' +
                ", effective=" + effective + '\'' +
                ", offer=" + offer + '\'' +
                ", price=" + price  + '\'' +
                ", proratedPrice=" + proratedPrice + '\'' +
                ", reason=" + reason + '\'' +
                '}';
    }
}