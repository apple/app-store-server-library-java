// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * The app metadata and the signed renewal and transaction information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/data">data</a>
 */
public class Data {
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_BUNDLE_VERSION = "bundleVersion";
    private static final String SERIALIZED_NAME_SIGNED_TRANSACTION_INFO = "signedTransactionInfo";
    private static final String SERIALIZED_NAME_SIGNED_RENEWAL_INFO = "signedRenewalInfo";
    @SerializedName(SERIALIZED_NAME_ENVIRONMENT)
    private Environment environment;
    @SerializedName(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @SerializedName(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @SerializedName(SERIALIZED_NAME_BUNDLE_VERSION)
    private String bundleVersion;
    @SerializedName(SERIALIZED_NAME_SIGNED_TRANSACTION_INFO)
    private String signedTransactionInfo;
    @SerializedName(SERIALIZED_NAME_SIGNED_RENEWAL_INFO)
    private String signedRenewalInfo;


    public Data() {
    }

    public Data environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    /**
     * The server environment that the notification applies to, either sandbox or production.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/environment">environment</a>
     **/
    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Data appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * The unique identifier of an app in the App Store.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public Data bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of an app.
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

    public Data bundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
        return this;
    }

    /**
     * The version of the build that identifies an iteration of the bundle.
     *
     * @return bundleVersion
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/bundleversion">bundleVersion</a>
     **/
    public String getBundleVersion() {
        return bundleVersion;
    }

    public void setBundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    public Data signedTransactionInfo(String signedTransactionInfo) {
        this.signedTransactionInfo = signedTransactionInfo;
        return this;
    }

    /**
     * Transaction information signed by the App Store, in JSON Web Signature (JWS) format.
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

    public Data signedRenewalInfo(String signedRenewalInfo) {
        this.signedRenewalInfo = signedRenewalInfo;
        return this;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return Objects.equals(this.environment, data.environment) &&
                Objects.equals(this.appAppleId, data.appAppleId) &&
                Objects.equals(this.bundleId, data.bundleId) &&
                Objects.equals(this.bundleVersion, data.bundleVersion) &&
                Objects.equals(this.signedTransactionInfo, data.signedTransactionInfo) &&
                Objects.equals(this.signedRenewalInfo, data.signedRenewalInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(environment, appAppleId, bundleId, bundleVersion, signedTransactionInfo, signedRenewalInfo);
    }

    @Override
    public String toString() {
        return "Data{" +
                "environment=" + environment +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", bundleVersion='" + bundleVersion + '\'' +
                ", signedTransactionInfo='" + signedTransactionInfo + '\'' +
                ", signedRenewalInfo='" + signedRenewalInfo + '\'' +
                '}';
    }
}

