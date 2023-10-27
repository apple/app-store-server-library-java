package com.apple.itunes.storekit.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

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

    @SerializedName(SERIALIZED_NAME_RECEIPT_TYPE)
    private String receiptType;
    @SerializedName(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @SerializedName(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @SerializedName(SERIALIZED_NAME_APPLICATION_VERSION)
    private String applicationVersion;
    @SerializedName(SERIALIZED_NAME_VERSION_EXTERNAL_IDENTIFIER)
    private Long versionExternalIdentifier;
    @SerializedName(SERIALIZED_NAME_RECEIPT_CREATION_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long receiptCreationDate;
    @SerializedName(SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long originalPurchaseDate;
    @SerializedName(SERIALIZED_NAME_ORIGINAL_APPLICATION_VERSION)
    private String originalApplicationVersion;
    @SerializedName(SERIALIZED_NAME_DEVICE_VERIFICATION)
    private String deviceVerification;
    @SerializedName(SERIALIZED_NAME_DEVICE_VERIFICATION_NONCE)
    private UUID deviceVerificationNonce;
    @SerializedName(SERIALIZED_NAME_PREORDER_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long preorderDate;

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
    public Long versionExternalIdentifier() {
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
    public Long originalPurchaseDate() {
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

    public Long getSignedDate() {
        return getReceiptCreationDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppTransaction that = (AppTransaction) o;
        return Objects.equals(receiptType, that.receiptType) && Objects.equals(appAppleId, that.appAppleId) && Objects.equals(bundleId, that.bundleId) && Objects.equals(applicationVersion, that.applicationVersion) && Objects.equals(versionExternalIdentifier, that.versionExternalIdentifier) && Objects.equals(originalPurchaseDate, that.originalPurchaseDate) && Objects.equals(originalApplicationVersion, that.originalApplicationVersion) && Objects.equals(deviceVerification, that.deviceVerification) && Objects.equals(deviceVerificationNonce, that.deviceVerificationNonce) && Objects.equals(preorderDate, that.preorderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptType, appAppleId, bundleId, applicationVersion, versionExternalIdentifier, originalPurchaseDate, originalApplicationVersion, deviceVerification, deviceVerificationNonce, preorderDate);
    }

    @Override
    public String toString() {
        return "AppTransaction{" +
                "receiptType='" + receiptType + '\'' +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", versionExternalIdentifier=" + versionExternalIdentifier +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", originalApplicationVersion='" + originalApplicationVersion + '\'' +
                ", deviceVerification='" + deviceVerification + '\'' +
                ", deviceVerificationNonce=" + deviceVerificationNonce +
                ", preorderDate=" + preorderDate +
                '}';
    }
}

