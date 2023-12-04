// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A response that indicates whether an individual renewal-date extension succeeded, and related details.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/extendrenewaldateresponse">ExtendRenewalDateResponse</a>
 */
public class ExtendRenewalDateResponse {
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_WEB_ORDER_LINE_ITEM_ID = "webOrderLineItemId";
    private static final String SERIALIZED_NAME_SUCCESS = "success";
    private static final String SERIALIZED_NAME_EFFECTIVE_DATE = "effectiveDate";
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @JsonProperty(SERIALIZED_NAME_WEB_ORDER_LINE_ITEM_ID)
    private String webOrderLineItemId;
    @JsonProperty(SERIALIZED_NAME_SUCCESS)
    private Boolean success;
    @JsonProperty(SERIALIZED_NAME_EFFECTIVE_DATE)
    private Long effectiveDate;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public ExtendRenewalDateResponse() {
    }

    public ExtendRenewalDateResponse originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
        return this;
    }

    /**
     * The original transaction identifier of a purchase.
     *
     * @return originalTransactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originaltransactionid">originalTransactionId</a>
     **/
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public ExtendRenewalDateResponse webOrderLineItemId(String webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
        return this;
    }

    /**
     * The unique identifier of subscription-purchase events across devices, including renewals.
     *
     * @return webOrderLineItemId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/weborderlineitemid">webOrderLineItemId</a>
     **/
    public String getWebOrderLineItemId() {
        return webOrderLineItemId;
    }

    public void setWebOrderLineItemId(String webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
    }

    public ExtendRenewalDateResponse success(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * A Boolean value that indicates whether the subscription-renewal-date extension succeeded.
     *
     * @return success
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/success">success</a>
     **/
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ExtendRenewalDateResponse effectiveDate(Long effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    /**
     * The new subscription expiration date for a subscription-renewal extension.
     *
     * @return effectiveDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/effectivedate">effectiveDate</a>
     **/
    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Long effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public ExtendRenewalDateResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     Fields that are not recognized for this object

     @return A map of JSON keys to objects
     */
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExtendRenewalDateResponse extendRenewalDateResponse = (ExtendRenewalDateResponse) o;
        return Objects.equals(this.originalTransactionId, extendRenewalDateResponse.originalTransactionId) &&
                Objects.equals(this.webOrderLineItemId, extendRenewalDateResponse.webOrderLineItemId) &&
                Objects.equals(this.success, extendRenewalDateResponse.success) &&
                Objects.equals(this.effectiveDate, extendRenewalDateResponse.effectiveDate) &&
                Objects.equals(this.unknownFields, extendRenewalDateResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalTransactionId, webOrderLineItemId, success, effectiveDate, unknownFields);
    }

    @Override
    public String toString() {
        return "ExtendRenewalDateResponse{" +
                "originalTransactionId='" + originalTransactionId + '\'' +
                ", webOrderLineItemId='" + webOrderLineItemId + '\'' +
                ", success=" + success +
                ", effectiveDate=" + effectiveDate +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

