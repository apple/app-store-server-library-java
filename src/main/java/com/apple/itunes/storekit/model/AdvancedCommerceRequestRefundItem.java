// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Information about the refund request for an item, such as its SKU, the refund amount, reason, and type.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceRequestRefundItem extends AbstractAdvancedCommerceBaseItem {
    private static final String SERIALIZED_NAME_REFUND_AMOUNT = "refundAmount";
    private static final String SERIALIZED_NAME_REFUND_REASON = "refundReason";
    private static final String SERIALIZED_NAME_REFUND_TYPE = "refundType";
    private static final String SERIALIZED_NAME_REVOKE = "revoke";

    @JsonProperty(SERIALIZED_NAME_REFUND_AMOUNT)
    private Long refundAmount;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_REASON, required = true)
    private String refundReason;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_TYPE, required = true)
    private String refundType;
    @JsonProperty(value = SERIALIZED_NAME_REVOKE, required = true)
    private Boolean revoke;

    protected AdvancedCommerceRequestRefundItem() {
        super();
    }

    public AdvancedCommerceRequestRefundItem(
            String sku,
            AdvancedCommerceRefundReason refundReason,
            AdvancedCommerceRefundType refundType,
            Boolean revoke
    ) {
        super(sku);
        this.refundReason = Objects.requireNonNull(refundReason).getValue();
        this.refundType = Objects.requireNonNull(refundType).getValue();
        this.revoke = Objects.requireNonNull(revoke);
    }

    public AdvancedCommerceRequestRefundItem(String sku, String rawRefundReason, String rawRefundType, Boolean revoke) {
        super(sku);
        this.refundReason = Objects.requireNonNull(rawRefundReason);
        this.refundType = Objects.requireNonNull(rawRefundType);
        this.revoke = Objects.requireNonNull(revoke);
    }

    @Override
    protected AdvancedCommerceRequestRefundItem self() {
        return this;
    }

    @Override
    public AdvancedCommerceRequestRefundItem sku(String sku) {
        return (AdvancedCommerceRequestRefundItem) super.sku(sku);
    }

    /**
     * The product identifier.
     *
     * @return SKU
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/sku">SKU</a>
     **/
    @Override
    public String getSku() {
        return super.getSku();
    }

    public AdvancedCommerceRequestRefundItem refundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
        return this;
    }

    /**
     * The refund amount you’re requesting for the SKU, in milliunits of the currency.
     *
     * @return refundAmount
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundamount">refundAmount</a>
     **/
    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public AdvancedCommerceRequestRefundItem refundReason(AdvancedCommerceRefundReason refundReason) {
        this.refundReason = Objects.requireNonNull(refundReason).getValue();
        return this;
    }

    /**
     * The reason for the refund request.
     *
     * @return refundReason
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundreason">refundReason</a>
     **/
    public AdvancedCommerceRefundReason getRefundReason() {
        return AdvancedCommerceRefundReason.fromValue(refundReason);
    }

    /**
     * @see #getRefundReason()
     **/
    public String getRawRefundReason() {
        return refundReason;
    }

    public void setRefundReason(AdvancedCommerceRefundReason refundReason) {
        this.refundReason = Objects.requireNonNull(refundReason).getValue();
    }

    public void setRawRefundReason(String rawRefundReason) {
        this.refundReason = Objects.requireNonNull(rawRefundReason);
    }

    public AdvancedCommerceRequestRefundItem refundType(AdvancedCommerceRefundType refundType) {
        this.refundType = Objects.requireNonNull(refundType).getValue();
        return this;
    }

    /**
     * The type of refund requested.
     *
     * @return refundType
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
     **/
    public AdvancedCommerceRefundType getRefundType() {
        return AdvancedCommerceRefundType.fromValue(refundType);
    }

    /**
     * @see #getRefundType()
     **/
    public String getRawRefundType() {
        return refundType;
    }

    public void setRefundType(AdvancedCommerceRefundType refundType) {
        this.refundType = Objects.requireNonNull(refundType).getValue();
    }

    public void setRawRefundType(String rawRefundType) {
        this.refundType = Objects.requireNonNull(rawRefundType);
    }

    public AdvancedCommerceRequestRefundItem revoke(Boolean revoke) {
        this.revoke = Objects.requireNonNull(revoke);
        return this;
    }

    /**
     * @return revoke
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
     **/
    public Boolean getRevoke() {
        return revoke;
    }

    public void setRevoke(Boolean revoke) {
        this.revoke = Objects.requireNonNull(revoke);
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
        AdvancedCommerceRequestRefundItem advancedCommerceRequestRefundItem = (AdvancedCommerceRequestRefundItem) o;
        return Objects.equals(this.refundAmount, advancedCommerceRequestRefundItem.refundAmount) &&
                Objects.equals(this.refundReason, advancedCommerceRequestRefundItem.refundReason) &&
                Objects.equals(this.refundType, advancedCommerceRequestRefundItem.refundType) &&
                Objects.equals(this.revoke, advancedCommerceRequestRefundItem.revoke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), refundAmount, refundReason, refundType, revoke);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceRequestRefundItem{" +
                "sku='" + getSku() + '\'' +
                ", refundAmount=" + refundAmount +
                ", refundReason='" + refundReason + '\'' +
                ", refundType='" + refundType + '\'' +
                ", revoke=" + revoke +
                '}';
    }
}
