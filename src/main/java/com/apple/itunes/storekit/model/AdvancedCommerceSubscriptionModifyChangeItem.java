// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The data your app provides to change an item of an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifychangeitem">SubscriptionModifyChangeItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionModifyChangeItem extends AbstractAdvancedCommerceItem {
    private static final String SERIALIZED_NAME_CURRENT_SKU = "currentSKU";
    private static final String SERIALIZED_NAME_EFFECTIVE = "effective";
    private static final String SERIALIZED_NAME_OFFER = "offer";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_PRORATED_PRICE = "proratedPrice";
    private static final String SERIALIZED_NAME_REASON = "reason";

    @JsonProperty(value = SERIALIZED_NAME_CURRENT_SKU, required = true)
    private String currentSku;
    @JsonProperty(value = SERIALIZED_NAME_EFFECTIVE, required = true)
    private String effective;
    @JsonProperty(SERIALIZED_NAME_OFFER)
    private AdvancedCommerceOffer offer;
    @JsonProperty(value = SERIALIZED_NAME_PRICE, required = true)
    private Long price;
    @JsonProperty(SERIALIZED_NAME_PRORATED_PRICE)
    private Long proratedPrice;
    @JsonProperty(value = SERIALIZED_NAME_REASON, required = true)
    private String reason;

    protected AdvancedCommerceSubscriptionModifyChangeItem() {
        super();
    }

    public AdvancedCommerceSubscriptionModifyChangeItem(
            String sku,
            String description,
            String displayName,
            String currentSku,
            AdvancedCommerceEffective effective,
            Long price,
            AdvancedCommerceReason reason
    ) {
        super(sku, description, displayName);
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
        this.effective = Objects.requireNonNull(effective).getValue();
        this.price = Objects.requireNonNull(price);
        this.reason = Objects.requireNonNull(reason).getValue();
    }

    public AdvancedCommerceSubscriptionModifyChangeItem(
            String sku,
            String description,
            String displayName,
            String currentSku,
            String rawEffective,
            Long price,
            String rawReason
    ) {
        super(sku, description, displayName);
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
        this.effective = Objects.requireNonNull(rawEffective);
        this.price = Objects.requireNonNull(price);
        this.reason = Objects.requireNonNull(rawReason);
    }

    @Override
    protected AdvancedCommerceSubscriptionModifyChangeItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceSubscriptionModifyChangeItem sku(String sku) {
        return (AdvancedCommerceSubscriptionModifyChangeItem) super.sku(sku);
    }

    @Override
    public AdvancedCommerceSubscriptionModifyChangeItem description(String description) {
        return (AdvancedCommerceSubscriptionModifyChangeItem) super.description(description);
    }

    @Override
    public AdvancedCommerceSubscriptionModifyChangeItem displayName(String displayName) {
        return (AdvancedCommerceSubscriptionModifyChangeItem) super.displayName(displayName);
    }

    /**
     * The product identifier of an Apple In-App Purchase product you manage in your own system.
     *
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    @Override
    public String getSku() {
        return super.getSku();
    }

    /**
     * A string you provide that describes a SKU.
     *
     * @return description
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/description">description</a>
     **/
    @Override
    public String getDescription() {
        return super.getDescription();
    }

    /**
     * A string with a product name that you can localize and is suitable for display to customers.
     *
     * @return displayName
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displayname">displayName</a>
     **/
    @Override
    public String getDisplayName() {
        return super.getDisplayName();
    }

    public AdvancedCommerceSubscriptionModifyChangeItem currentSku(String currentSku) {
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
        return this;
    }

    /**
     * The product identifier of an Apple In-App Purchase product you manage in your own system.
     *
     * @return currentSKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    public String getCurrentSku() {
        return currentSku;
    }

    public void setCurrentSku(String currentSku) {
        this.currentSku = HelperValidationUtils.validateSku(Objects.requireNonNull(currentSku));
    }

    public AdvancedCommerceSubscriptionModifyChangeItem effective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
        return this;
    }

    /**
     * A string value that indicates when a requested change to an auto-renewable subscription goes into effect.
     *
     * @return effective
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/effective">effective</a>
     **/
    public AdvancedCommerceEffective getEffective() {
        return AdvancedCommerceEffective.fromValue(effective);
    }

    /**
     * @see #getEffective()
     **/
    public String getRawEffective() {
        return effective;
    }

    public void setEffective(AdvancedCommerceEffective effective) {
        this.effective = Objects.requireNonNull(effective).getValue();
    }

    public void setRawEffective(String rawEffective) {
        this.effective = Objects.requireNonNull(rawEffective);
    }

    public AdvancedCommerceSubscriptionModifyChangeItem offer(AdvancedCommerceOffer offer) {
        this.offer = offer;
        return this;
    }

    /**
     * A discount offer for an auto-renewable subscription.
     *
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
     * A price, in milliunits of a currency, for an Advanced Commerce API SKU.
     *
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
     * A prorated price, in milliunits of a currency, for an Advanced Commerce API SKU.
     *
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
        this.reason = Objects.requireNonNull(reason).getValue();
        return this;
    }

    /**
     * @return reason
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionmodifychangeitem">SubscriptionModifyChangeItem</a>
     **/
    public AdvancedCommerceReason getReason() {
        return AdvancedCommerceReason.fromValue(reason);
    }

    /**
     * @see #getReason()
     **/
    public String getRawReason() {
        return reason;
    }

    public void setReason(AdvancedCommerceReason reason) {
        this.reason = Objects.requireNonNull(reason).getValue();
    }

    public void setRawReason(String rawReason) {
        this.reason = Objects.requireNonNull(rawReason);
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
        AdvancedCommerceSubscriptionModifyChangeItem advancedCommerceSubscriptionModifyChangeItem = (AdvancedCommerceSubscriptionModifyChangeItem) o;
        return Objects.equals(this.currentSku, advancedCommerceSubscriptionModifyChangeItem.currentSku) &&
                Objects.equals(this.effective, advancedCommerceSubscriptionModifyChangeItem.effective) &&
                Objects.equals(this.offer, advancedCommerceSubscriptionModifyChangeItem.offer) &&
                Objects.equals(this.price, advancedCommerceSubscriptionModifyChangeItem.price) &&
                Objects.equals(this.proratedPrice, advancedCommerceSubscriptionModifyChangeItem.proratedPrice) &&
                Objects.equals(this.reason, advancedCommerceSubscriptionModifyChangeItem.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentSku, effective, offer, price, proratedPrice, reason);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionModifyChangeItem{" +
                "sku='" + getSku() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", displayName='" + getDisplayName() + '\'' +
                ", currentSku='" + currentSku + '\'' +
                ", effective='" + effective + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                ", proratedPrice=" + proratedPrice +
                ", reason='" + reason + '\'' +
                '}';
    }
}
