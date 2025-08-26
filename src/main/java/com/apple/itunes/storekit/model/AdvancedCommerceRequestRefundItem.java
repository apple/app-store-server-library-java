// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Information about the refund request for an item, such as its SKU, the refund amount, reason, and type.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestrefunditem">RequestRefundItem</a>
 */
public class AdvancedCommerceRequestRefundItem extends AbstractAdvancedCommerceBaseItem {
    private static final String SERIALIZED_NAME_REFUND_AMOUNT = "refundAmount";
    private static final String SERIALIZED_NAME_REFUND_REASON = "refundReason";
    private static final String SERIALIZED_NAME_REFUND_TYPE = "refundType";
    private static final String SERIALIZED_NAME_REVOKE = "revoke";

    @JsonProperty(SERIALIZED_NAME_REFUND_AMOUNT)
    private Integer refundAmount;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_REASON, required = true)
    private String refundReason;
    @JsonProperty(value = SERIALIZED_NAME_REFUND_TYPE, required = true)
    private String refundType;
    @JsonProperty(value = SERIALIZED_NAME_REVOKE, required = true)
    private Boolean revoke;

    private AdvancedCommerceRequestRefundItem() {
        super();
    }

    public AdvancedCommerceRequestRefundItem(
            String sku,
            String rawRefundReason,
            String rawRefundType,
            Boolean revoke
    ) {
        super(sku);
        this.refundReason = Objects.requireNonNull(rawRefundReason);
        this.refundType = Objects.requireNonNull(rawRefundType);
        this.revoke = Objects.requireNonNull(revoke);
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

    @Override
    protected AdvancedCommerceRequestRefundItem self() {
        return this;
    }

    public AdvancedCommerceRequestRefundItem refundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
        return this;
    }

    /**
     * The refund amount you’re requesting for the SKU, in milliunits of the currency.
     *
     * @return refundAmount
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundamount">refundAmount</a>
     **/
    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
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
     **/
    public AdvancedCommerceRefundType getRefundType() {
        return AdvancedCommerceRefundType.fromValue(refundType);
    }

    /**
     * @see #getRefundType()
     */
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
     **/
    public Boolean getRevoke() {
        return revoke;
    }

    public void setRevoke(Boolean revoke) {
        this.revoke = Objects.requireNonNull(revoke);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvancedCommerceRequestRefundItem that = (AdvancedCommerceRequestRefundItem) o;
        return Objects.equals(sku, that.sku) && Objects.equals(refundAmount, that.refundAmount) && Objects.equals(refundReason, that.refundReason) && Objects.equals(refundType, that.refundType) && Objects.equals(revoke, that.revoke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, refundAmount, refundReason, refundType, revoke);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceRequestRefundItem{" +
                "sku='" + sku + '\'' +
                ", refundAmount=" + refundAmount +
                ", refundReason=" + refundReason +
                ", refundType='" + refundType + '\'' +
                ", revoke=" + revoke +
                '}';
    }
}