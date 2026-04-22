// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public abstract class AbstractAdvancedCommerceResponse {

    private static final String SERIALIZED_NAME_SIGNED_RENEWAL_INFO = "signedRenewalInfo";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTION_INFO = "signedTransactionInfo";

    @JsonProperty(SERIALIZED_NAME_SIGNED_RENEWAL_INFO)
    private String signedRenewalInfo;
    @JsonProperty(SERIALIZED_NAME_SIGNED_TRANSACTION_INFO)
    private String signedTransactionInfo;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected AbstractAdvancedCommerceResponse() {}

    protected abstract AbstractAdvancedCommerceResponse self();

    protected AbstractAdvancedCommerceResponse(String signedRenewalInfo, String signedTransactionInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
        this.signedTransactionInfo = signedTransactionInfo;
    }

    public AbstractAdvancedCommerceResponse signedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
        return self();
    }

    /**
     * Subscription renewal information, signed by the App Store, in JSON Web Signature (JWS) format.
     * 
     * @return signedRenewalInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsrenewalinfo">JWSRenewalInfo</a>
     **/
    public String getSignedRenewalInfo() {
        return signedRenewalInfo;
    }

    public void setSignedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
    }

    public AbstractAdvancedCommerceResponse signedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
        return self();
    }

    /**
     * Transaction information signed by the App Store, in JSON Web Signature (JWS) Compact Serialization format.
     *
     * @return signedTransactionInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransaction">JWSTransaction</a>
     **/
    public String getSignedTransactionInfo() {
        return signedTransactionInfo;
    }

    public void setSignedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
    }

    public AbstractAdvancedCommerceResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return self();
    }

    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAdvancedCommerceResponse that = (AbstractAdvancedCommerceResponse) o;
        return Objects.equals(signedRenewalInfo, that.signedRenewalInfo) && Objects.equals(signedTransactionInfo, that.signedTransactionInfo) && Objects.equals(unknownFields, that.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedRenewalInfo, signedTransactionInfo, unknownFields);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "signedRenewalInfo='" + signedRenewalInfo + '\'' +
                ", signedTransactionInfo='" + signedTransactionInfo + '\'' +
                 ", unknownFields=" + unknownFields +
                '}';
    }
}