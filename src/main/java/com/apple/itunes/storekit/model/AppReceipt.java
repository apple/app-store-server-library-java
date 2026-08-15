// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A decoded legacy App Store receipt (the PKCS#7 app receipt).
 *
 * @see <a href="https://developer.apple.com/documentation/appstorereceipts/responsebody/receipt">receipt</a>
 */
public class AppReceipt {

    private String receiptType;
    private String bundleId;
    private byte[] bundleIdBytes;
    private String applicationVersion;
    private byte[] opaqueValue;
    private byte[] sha1Hash;
    private Long receiptCreationDate;
    private Long originalPurchaseDate;
    private String originalApplicationVersion;
    private Long expirationDate;
    private List<InAppPurchaseReceipt> inAppPurchases;
    private Map<Integer, List<byte[]>> unknownAttributes;

    public AppReceipt() {
    }

    public AppReceipt receiptType(String receiptType) {
        this.receiptType = receiptType;
        return this;
    }

    /**
     * The raw receipt type, e.g. {@code Production}, {@code ProductionVPP},
     * {@code ProductionSandbox}, {@code ProductionVPPSandbox} or {@code Xcode}.
     *
     * @return receiptType
     */
    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public AppReceipt bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of the app the receipt belongs to.
     *
     * @return bundleId
     */
    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public AppReceipt bundleIdBytes(byte[] bundleIdBytes) {
        this.bundleIdBytes = bundleIdBytes;
        return this;
    }

    /**
     * The raw ASN.1 bytes of the bundle identifier attribute, needed together
     * with {@link #getOpaqueValue()} and {@link #getSha1Hash()} to compute the
     * device-hash binding described in Apple's receipt validation guide.
     *
     * @return bundleIdBytes
     */
    public byte[] getBundleIdBytes() {
        return bundleIdBytes;
    }

    public void setBundleIdBytes(byte[] bundleIdBytes) {
        this.bundleIdBytes = bundleIdBytes;
    }

    public AppReceipt applicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }

    /**
     * The app's version number.
     *
     * @return applicationVersion
     */
    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public AppReceipt opaqueValue(byte[] opaqueValue) {
        this.opaqueValue = opaqueValue;
        return this;
    }

    /**
     * An opaque value used, with other data, to compute the device hash.
     *
     * @return opaqueValue
     */
    public byte[] getOpaqueValue() {
        return opaqueValue;
    }

    public void setOpaqueValue(byte[] opaqueValue) {
        this.opaqueValue = opaqueValue;
    }

    public AppReceipt sha1Hash(byte[] sha1Hash) {
        this.sha1Hash = sha1Hash;
        return this;
    }

    /**
     * The SHA-1 device-hash attribute of the receipt.
     *
     * @return sha1Hash
     */
    public byte[] getSha1Hash() {
        return sha1Hash;
    }

    public void setSha1Hash(byte[] sha1Hash) {
        this.sha1Hash = sha1Hash;
    }

    public AppReceipt receiptCreationDate(Long receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
        return this;
    }

    /**
     * The time the App Store generated the receipt, in UNIX time, in
     * milliseconds.
     *
     * @return receiptCreationDate
     */
    public Long getReceiptCreationDate() {
        return receiptCreationDate;
    }

    public void setReceiptCreationDate(Long receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }

    public AppReceipt originalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
        return this;
    }

    /**
     * The time of the original app purchase, in UNIX time, in milliseconds.
     *
     * @return originalPurchaseDate
     */
    public Long getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public void setOriginalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
    }

    public AppReceipt originalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
        return this;
    }

    /**
     * The version of the app that the user originally purchased.
     *
     * @return originalApplicationVersion
     */
    public String getOriginalApplicationVersion() {
        return originalApplicationVersion;
    }

    public void setOriginalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
    }

    public AppReceipt expirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * The expiration date of the receipt, in UNIX time, in milliseconds.
     * Present for apps purchased through the Volume Purchase Program.
     *
     * @return expirationDate
     */
    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public AppReceipt inAppPurchases(List<InAppPurchaseReceipt> inAppPurchases) {
        this.inAppPurchases = inAppPurchases;
        return this;
    }

    /**
     * The decoded in-app purchase attributes contained in the receipt.
     *
     * @return inAppPurchases
     */
    public List<InAppPurchaseReceipt> getInAppPurchases() {
        return inAppPurchases != null ? inAppPurchases : Collections.emptyList();
    }

    public void setInAppPurchases(List<InAppPurchaseReceipt> inAppPurchases) {
        this.inAppPurchases = inAppPurchases;
    }

    public AppReceipt unknownAttributes(Map<Integer, List<byte[]>> unknownAttributes) {
        this.unknownAttributes = unknownAttributes;
        return this;
    }

    /**
     * Attribute types this library does not model, keyed by type, with the
     * verified-but-undecoded value bytes, so fields Apple adds later remain
     * accessible without a library update.
     *
     * @return unknownAttributes
     */
    public Map<Integer, List<byte[]>> getUnknownAttributes() {
        return unknownAttributes != null ? unknownAttributes : Collections.emptyMap();
    }

    public void setUnknownAttributes(Map<Integer, List<byte[]>> unknownAttributes) {
        this.unknownAttributes = unknownAttributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppReceipt that = (AppReceipt) o;
        return Objects.equals(receiptType, that.receiptType)
                && Objects.equals(bundleId, that.bundleId)
                && Arrays.equals(bundleIdBytes, that.bundleIdBytes)
                && Objects.equals(applicationVersion, that.applicationVersion)
                && Arrays.equals(opaqueValue, that.opaqueValue)
                && Arrays.equals(sha1Hash, that.sha1Hash)
                && Objects.equals(receiptCreationDate, that.receiptCreationDate)
                && Objects.equals(originalPurchaseDate, that.originalPurchaseDate)
                && Objects.equals(originalApplicationVersion, that.originalApplicationVersion)
                && Objects.equals(expirationDate, that.expirationDate)
                && Objects.equals(inAppPurchases, that.inAppPurchases);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(receiptType, bundleId, applicationVersion, receiptCreationDate,
                originalPurchaseDate, originalApplicationVersion, expirationDate, inAppPurchases);
        result = 31 * result + Arrays.hashCode(bundleIdBytes);
        result = 31 * result + Arrays.hashCode(opaqueValue);
        result = 31 * result + Arrays.hashCode(sha1Hash);
        return result;
    }

    @Override
    public String toString() {
        return "AppReceipt{" +
                "receiptType='" + receiptType + '\'' +
                ", bundleId='" + bundleId + '\'' +
                ", applicationVersion='" + applicationVersion + '\'' +
                ", receiptCreationDate=" + receiptCreationDate +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", originalApplicationVersion='" + originalApplicationVersion + '\'' +
                ", expirationDate=" + expirationDate +
                ", inAppPurchases=" + inAppPurchases +
                '}';
    }
}
