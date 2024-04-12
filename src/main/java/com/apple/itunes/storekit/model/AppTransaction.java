package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 Information that represents the customer’s purchase of the app, cryptographically signed by the App Store.

 @see <a href="https://developer.apple.com/documentation/storekit/apptransaction">AppTransaction</a>
 */
public class AppTransaction implements DecodedSignedData {

    private static final String SERIALIZED_NAME_RECEIPT_TYPE = "receiptType";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_APPLICATION_VERSION = "applicationVersion";
    private static final String SERIALIZED_NAME_VERSION_EXTERNAL_IDENTIFIER = "versionExternalIdentifier";
    private static final String SERIALIZED_NAME_RECEIPT_CREATION_DATE = "receiptCreationDate";
    private static final String SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE = "originalPurchaseDate";
    private static final String SERIALIZED_NAME_ORIGINAL_APPLICATION_VERSION = "originalApplicationVersion";
    private static final String SERIALIZED_NAME_DEVICE_VERIFICATION = "deviceVerification";
    private static final String SERIALIZED_NAME_DEVICE_VERIFICATION_NONCE = "deviceVerificationNonce";
    private static final String SERIALIZED_NAME_PREORDER_DATE = "preorderDate";

    @JsonProperty(SERIALIZED_NAME_RECEIPT_TYPE)
    private String receiptType;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_APPLICATION_VERSION)
    private String applicationVersion;
    @JsonProperty(SERIALIZED_NAME_VERSION_EXTERNAL_IDENTIFIER)
    private Long versionExternalIdentifier;
    @JsonProperty(SERIALIZED_NAME_RECEIPT_CREATION_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long receiptCreationDate;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long originalPurchaseDate;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_APPLICATION_VERSION)
    private String originalApplicationVersion;
    @JsonProperty(SERIALIZED_NAME_DEVICE_VERIFICATION)
    private String deviceVerification;
    @JsonProperty(SERIALIZED_NAME_DEVICE_VERIFICATION_NONCE)
    private UUID deviceVerificationNonce;
    @JsonProperty(SERIALIZED_NAME_PREORDER_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long preorderDate;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    /**
     The server environment that signs the app transaction.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3963901-environment">environment</a>
     */
    public Environment getReceiptType() {
        return this.receiptType != null ? Environment.fromValue(this.receiptType) : null;
    }

    /**
     * @see #getReceiptType()
     */
    public String getRawReceiptType() {
        return this.receiptType;
    }

    public void setReceiptType(Environment receiptType) {
        this.receiptType = receiptType != null ? receiptType.getValue() : null;
    }

    public void setRawReceiptType(String rawReceiptType) {
        this.receiptType = rawReceiptType;
    }

    public AppTransaction receiptType(Environment receiptType) {
        this.receiptType = receiptType != null ? receiptType.getValue() : null;
        return this;
    }

    /**
     The unique identifier the App Store uses to identify the app.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954436-appid">appId</a>
     */
    public Long getAppAppleId() {
        return this.appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public AppTransaction appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     The bundle identifier that the app transaction applies to.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954439-bundleid">bundleId</a>
     */
    public String getBundleId() {
        return this.bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public AppTransaction bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     The app version that the app transaction applies to.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954437-appversion">appVersion</a>
     */
    public String getApplicationVersion() {
        return this.applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public AppTransaction applicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }

    /**
     The version external identifier of the app

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954438-appversionid">appVersionID</a>
     */
    public Long getVersionExternalIdentifier() {
        return this.versionExternalIdentifier;
    }

    public void setVersionExternalIdentifier(Long versionExternalIdentifier) {
        this.versionExternalIdentifier = versionExternalIdentifier;
    }

    public AppTransaction versionExternalIdentifier(Long versionExternalIdentifier) {
        this.versionExternalIdentifier = versionExternalIdentifier;
        return this;
    }

    /**
     The date that the App Store signed the JWS app transaction.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954449-signeddate">signedDate</a>
     */
    public Long getReceiptCreationDate() {
        return this.receiptCreationDate;
    }

    public void setReceiptCreationDate(Long receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }

    public AppTransaction receiptCreationDate(Long receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
        return this;
    }

    /**
     The date the user originally purchased the app from the App Store.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954448-originalpurchasedate">originalPurchaseDate</a>
     */
    public Long getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public void setOriginalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
    }

    public AppTransaction originalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
        return this;
    }

    /**
     The app version that the user originally purchased from the App Store.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954447-originalappversion">originalAppVersion</a>
     */
    public String getOriginalApplicationVersion() {
        return this.originalApplicationVersion;
    }

    public void setOriginalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
    }

    public AppTransaction originalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
        return this;
    }

    /**
     The Base64 device verification value to use to verify whether the app transaction belongs to the device.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954441-deviceverification">deviceVerification</a>
     */
    public String getDeviceVerification() {
        return this.deviceVerification;
    }
    
    public void setDeviceVerification(String deviceVerification) {
        this.deviceVerification = deviceVerification;
    }
    
    public AppTransaction deviceVerification(String deviceVerification) {
        this.deviceVerification = deviceVerification;
        return this;
    }

    /**
     The UUID used to compute the device verification value.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/3954442-deviceverificationnonce">deviceVerificationNonce</a>
     */
    public UUID getDeviceVerificationNonce() {
        return deviceVerificationNonce;
    }
    
    public void setDeviceVerificationNonce(UUID deviceVerificationNonce) {
        this.deviceVerificationNonce = deviceVerificationNonce;
    }
    
    public AppTransaction deviceVerificationNonce(UUID deviceVerificationNonce) {
        this.deviceVerificationNonce = deviceVerificationNonce;
        return this;
    }
    

    /**
     The date the customer placed an order for the app before it’s available in the App Store.

     @see <a href="https://developer.apple.com/documentation/storekit/apptransaction/4013175-preorderdate">preorderDate</a>
     */
    public Long getPreorderDate() {
        return preorderDate;
    }
    
    public void setPreorderDate(Long preorderDate) {
        this.preorderDate = preorderDate;
    }
    
    public AppTransaction preorderDate(Long preorderDate) {
        this.preorderDate = preorderDate;
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

    public AppTransaction unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    public Long getSignedDate() {
        return getReceiptCreationDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppTransaction that = (AppTransaction) o;
        return Objects.equals(receiptType, that.receiptType) && Objects.equals(appAppleId, that.appAppleId) && Objects.equals(bundleId, that.bundleId) && Objects.equals(applicationVersion, that.applicationVersion) && Objects.equals(versionExternalIdentifier, that.versionExternalIdentifier) && Objects.equals(originalPurchaseDate, that.originalPurchaseDate) && Objects.equals(originalApplicationVersion, that.originalApplicationVersion) && Objects.equals(deviceVerification, that.deviceVerification) && Objects.equals(deviceVerificationNonce, that.deviceVerificationNonce) && Objects.equals(preorderDate, that.preorderDate) && Objects.equals(unknownFields, that.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptType, appAppleId, bundleId, applicationVersion, versionExternalIdentifier, originalPurchaseDate, originalApplicationVersion, deviceVerification, deviceVerificationNonce, preorderDate, unknownFields);
    }

    @Override
    public String toString() {
        return "AppTransaction{" +
                "receiptType='" + receiptType + '\'' +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", versionExternalIdentifier=" + versionExternalIdentifier +
                ", receiptCreationDate=" + receiptCreationDate +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", originalApplicationVersion='" + originalApplicationVersion + '\'' +
                ", deviceVerification='" + deviceVerification + '\'' +
                ", deviceVerificationNonce=" + deviceVerificationNonce +
                ", preorderDate=" + preorderDate +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

