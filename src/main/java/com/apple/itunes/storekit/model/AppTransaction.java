// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * A decoded payload that contains app transaction information.
 *
 * @see <a href="https://developer.apple.com/documentation/storekit/apptransaction">AppTransaction</a>
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsapptransactiondecodedpayload">JWSAppTransactionDecodedPayload</a>
 **/
public class AppTransaction implements DecodedSignedData {
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_APP_TRANSACTION_ID = "appTransactionId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_ORIGINAL_APPLICATION_VERSION = "originalApplicationVersion";
    private static final String SERIALIZED_NAME_ORIGINAL_PLATFORM = "originalPlatform";
    private static final String SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE = "originalPurchaseDate";
    private static final String SERIALIZED_NAME_PREORDER_DATE = "preorderDate";
    private static final String SERIALIZED_NAME_RECEIPT_CREATION_DATE = "receiptCreationDate";
    private static final String SERIALIZED_NAME_RECEIPT_TYPE = "receiptType";
    private static final String SERIALIZED_NAME_STORE_TYPE = "storeType";
    private static final String SERIALIZED_NAME_APPLICATION_VERSION = "applicationVersion";
    private static final String SERIALIZED_NAME_VERSION_EXTERNAL_IDENTIFIER = "versionExternalIdentifier";
    private static final String SERIALIZED_NAME_DEVICE_VERIFICATION = "deviceVerification";
    private static final String SERIALIZED_NAME_DEVICE_VERIFICATION_NONCE = "deviceVerificationNonce";

    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_APP_TRANSACTION_ID)
    private String appTransactionId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_APPLICATION_VERSION)
    private String originalApplicationVersion;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_PLATFORM)
    private String originalPlatform;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long originalPurchaseDate;
    @JsonProperty(SERIALIZED_NAME_PREORDER_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long preorderDate;
    @JsonProperty(SERIALIZED_NAME_RECEIPT_CREATION_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long receiptCreationDate;
    @JsonProperty(SERIALIZED_NAME_RECEIPT_TYPE)
    private String receiptType;
    @JsonProperty(SERIALIZED_NAME_STORE_TYPE)
    private String storeType;
    @JsonProperty(SERIALIZED_NAME_APPLICATION_VERSION)
    private String applicationVersion;
    @JsonProperty(SERIALIZED_NAME_VERSION_EXTERNAL_IDENTIFIER)
    private Long versionExternalIdentifier;
    @JsonProperty(SERIALIZED_NAME_DEVICE_VERIFICATION)
    private String deviceVerification;
    @JsonProperty(SERIALIZED_NAME_DEVICE_VERIFICATION_NONCE)
    private UUID deviceVerificationNonce;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public AppTransaction() {
    }

    public AppTransaction appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * The unique identifier the App Store uses to identify the app.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public AppTransaction appTransactionId(String appTransactionId) {
        this.appTransactionId = appTransactionId;
        return this;
    }

    /**
     * The unique identifier of the app download transaction.
     *
     * @return appTransactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/apptransactionid">appTransactionId</a>
     **/
    public String getAppTransactionId() {
        return appTransactionId;
    }

    public void setAppTransactionId(String appTransactionId) {
        this.appTransactionId = appTransactionId;
    }

    public AppTransaction bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier that the app transaction applies to.
     *
     * @return bundleId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/bundleid">bundleId</a>
     **/
    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public AppTransaction originalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
        return this;
    }

    /**
     * The app version that the customer originally purchased from the App Store.
     *
     * @return originalApplicationVersion
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originalapplicationversion">originalApplicationVersion</a>
     **/
    public String getOriginalApplicationVersion() {
        return originalApplicationVersion;
    }

    public void setOriginalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
    }

    public AppTransaction originalPlatform(PurchasePlatform originalPlatform) {
        this.originalPlatform = originalPlatform != null ? originalPlatform.getValue() : null;
        return this;
    }

    /**
     * The platform on which the customer originally purchased the app.
     *
     * @return originalPlatform
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originalplatform">originalPlatform</a>
     **/
    public PurchasePlatform getOriginalPlatform() {
        return PurchasePlatform.fromValue(originalPlatform);
    }

    /**
     * @see #getOriginalPlatform()
     **/
    public String getRawOriginalPlatform() {
        return originalPlatform;
    }

    public void setOriginalPlatform(PurchasePlatform originalPlatform) {
        this.originalPlatform = originalPlatform != null ? originalPlatform.getValue() : null;
    }

    public void setRawOriginalPlatform(String rawOriginalPlatform) {
        this.originalPlatform = rawOriginalPlatform;
    }

    public AppTransaction originalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
        return this;
    }

    /**
     * The date the customer originally purchased the app from the App Store.
     *
     * @return originalPurchaseDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originalpurchasedate">originalPurchaseDate</a>
     **/
    public Long getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public void setOriginalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
    }

    public AppTransaction preorderDate(Long preorderDate) {
        this.preorderDate = preorderDate;
        return this;
    }

    /**
     * The date the customer placed an order for the app before it’s available in the App Store.
     *
     * @return preorderDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/preorderdate">preorderDate</a>
     **/
    public Long getPreorderDate() {
        return preorderDate;
    }

    public void setPreorderDate(Long preorderDate) {
        this.preorderDate = preorderDate;
    }

    public AppTransaction receiptCreationDate(Long receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
        return this;
    }

    /**
     * The date that the App Store signed the JWS app transaction.
     *
     * @return receiptCreationDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/receiptcreationdate">receiptCreationDate</a>
     **/
    public Long getReceiptCreationDate() {
        return receiptCreationDate;
    }

    public void setReceiptCreationDate(Long receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }

    public AppTransaction receiptType(Environment receiptType) {
        this.receiptType = receiptType != null ? receiptType.getValue() : null;
        return this;
    }

    /**
     * The server environment, production or sandbox, that signed the app transaction.
     *
     * @return receiptType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
     **/
    public Environment getReceiptType() {
        return Environment.fromValue(receiptType);
    }

    /**
     * @see #getReceiptType()
     **/
    public String getRawReceiptType() {
        return receiptType;
    }

    public void setReceiptType(Environment receiptType) {
        this.receiptType = receiptType != null ? receiptType.getValue() : null;
    }

    public void setRawReceiptType(String rawReceiptType) {
        this.receiptType = rawReceiptType;
    }

    public AppTransaction storeType(StoreType storeType) {
        this.storeType = storeType != null ? storeType.getValue() : null;
        return this;
    }

    /**
     * The store the customer obtained the app from.
     *
     * @return storeType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/storetype">storeType</a>
     **/
    public StoreType getStoreType() {
        return StoreType.fromValue(storeType);
    }

    /**
     * @see #getStoreType()
     **/
    public String getRawStoreType() {
        return storeType;
    }

    public void setStoreType(StoreType storeType) {
        this.storeType = storeType != null ? storeType.getValue() : null;
    }

    public void setRawStoreType(String rawStoreType) {
        this.storeType = rawStoreType;
    }

    public AppTransaction applicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }

    /**
     * The app version that the app transaction applies to.
     *
     * @return applicationVersion
     * @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/appversion">appVersion</a>
     **/
    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public AppTransaction versionExternalIdentifier(Long versionExternalIdentifier) {
        this.versionExternalIdentifier = versionExternalIdentifier;
        return this;
    }

    /**
     * The number that the App Store uses to uniquely identify the version of the app.
     *
     * @return versionExternalIdentifier
     * @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/appversionid">appVersionID</a>
     **/
    public Long getVersionExternalIdentifier() {
        return versionExternalIdentifier;
    }

    public void setVersionExternalIdentifier(Long versionExternalIdentifier) {
        this.versionExternalIdentifier = versionExternalIdentifier;
    }

    public AppTransaction deviceVerification(String deviceVerification) {
        this.deviceVerification = deviceVerification;
        return this;
    }

    /**
     * The device verification value to use to verify whether the app transaction belongs to the device.
     *
     * @return deviceVerification
     * @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/deviceverification">deviceVerification</a>
     **/
    public String getDeviceVerification() {
        return deviceVerification;
    }

    public void setDeviceVerification(String deviceVerification) {
        this.deviceVerification = deviceVerification;
    }

    public AppTransaction deviceVerificationNonce(UUID deviceVerificationNonce) {
        this.deviceVerificationNonce = deviceVerificationNonce;
        return this;
    }

    /**
     * The UUID used to compute the device verification value.
     *
     * @return deviceVerificationNonce
     * @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/deviceverificationnonce">deviceVerificationNonce</a>
     **/
    public UUID getDeviceVerificationNonce() {
        return deviceVerificationNonce;
    }

    public void setDeviceVerificationNonce(UUID deviceVerificationNonce) {
        this.deviceVerificationNonce = deviceVerificationNonce;
    }

    public AppTransaction unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object
     *
     * @return A map of JSON keys to objects
     **/
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    public Long getSignedDate() {
        return getReceiptCreationDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppTransaction appTransaction = (AppTransaction) o;
        return Objects.equals(this.appAppleId, appTransaction.appAppleId) &&
                Objects.equals(this.appTransactionId, appTransaction.appTransactionId) &&
                Objects.equals(this.bundleId, appTransaction.bundleId) &&
                Objects.equals(this.originalApplicationVersion, appTransaction.originalApplicationVersion) &&
                Objects.equals(this.originalPlatform, appTransaction.originalPlatform) &&
                Objects.equals(this.originalPurchaseDate, appTransaction.originalPurchaseDate) &&
                Objects.equals(this.preorderDate, appTransaction.preorderDate) &&
                Objects.equals(this.receiptCreationDate, appTransaction.receiptCreationDate) &&
                Objects.equals(this.receiptType, appTransaction.receiptType) &&
                Objects.equals(this.storeType, appTransaction.storeType) &&
                Objects.equals(this.applicationVersion, appTransaction.applicationVersion) &&
                Objects.equals(this.versionExternalIdentifier, appTransaction.versionExternalIdentifier) &&
                Objects.equals(this.deviceVerification, appTransaction.deviceVerification) &&
                Objects.equals(this.deviceVerificationNonce, appTransaction.deviceVerificationNonce) &&
                Objects.equals(this.unknownFields, appTransaction.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appAppleId, appTransactionId, bundleId, originalApplicationVersion, originalPlatform, originalPurchaseDate, preorderDate, receiptCreationDate, receiptType, storeType, applicationVersion, versionExternalIdentifier, deviceVerification, deviceVerificationNonce, unknownFields);
    }

    @Override
    public String toString() {
        return "AppTransaction{" +
                "appAppleId=" + appAppleId +
                ", appTransactionId='" + appTransactionId + '\'' +
                ", bundleId='" + bundleId + '\'' +
                ", originalApplicationVersion='" + originalApplicationVersion + '\'' +
                ", originalPlatform='" + originalPlatform + '\'' +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", preorderDate=" + preorderDate +
                ", receiptCreationDate=" + receiptCreationDate +
                ", receiptType='" + receiptType + '\'' +
                ", storeType='" + storeType + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", versionExternalIdentifier=" + versionExternalIdentifier +
                ", deviceVerification='" + deviceVerification + '\'' +
                ", deviceVerificationNonce=" + deviceVerificationNonce +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
