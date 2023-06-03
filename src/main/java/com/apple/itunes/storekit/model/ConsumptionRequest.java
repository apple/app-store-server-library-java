// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.UUID;

/**
 * The request body containing consumption information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionrequest">ConsumptionRequest</a>
 */
public class ConsumptionRequest {
    private static final String SERIALIZED_NAME_CUSTOMER_CONSENTED = "customerConsented";
    private static final String SERIALIZED_NAME_CONSUMPTION_STATUS = "consumptionStatus";
    private static final String SERIALIZED_NAME_PLATFORM = "platform";
    private static final String SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED = "sampleContentProvided";
    private static final String SERIALIZED_NAME_DELIVERY_STATUS = "deliveryStatus";
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    private static final String SERIALIZED_NAME_ACCOUNT_TENURE = "accountTenure";
    private static final String SERIALIZED_NAME_PLAY_TIME = "playTime";
    private static final String SERIALIZED_NAME_LIFETIME_DOLLARS_REFUNDED = "lifetimeDollarsRefunded";
    private static final String SERIALIZED_NAME_LIFETIME_DOLLARS_PURCHASED = "lifetimeDollarsPurchased";
    private static final String SERIALIZED_NAME_USER_STATUS = "userStatus";
    @SerializedName(SERIALIZED_NAME_CUSTOMER_CONSENTED)
    private Boolean customerConsented;
    @SerializedName(SERIALIZED_NAME_CONSUMPTION_STATUS)
    private ConsumptionStatus consumptionStatus;
    @SerializedName(SERIALIZED_NAME_PLATFORM)
    private Platform platform;
    @SerializedName(SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED)
    private Boolean sampleContentProvided;
    @SerializedName(SERIALIZED_NAME_DELIVERY_STATUS)
    private DeliveryStatus deliveryStatus;
    @SerializedName(SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    private UUID appAccountToken;
    @SerializedName(SERIALIZED_NAME_ACCOUNT_TENURE)
    private AccountTenure accountTenure;
    @SerializedName(SERIALIZED_NAME_PLAY_TIME)
    private PlayTime playTime;
    @SerializedName(SERIALIZED_NAME_LIFETIME_DOLLARS_REFUNDED)
    private LifetimeDollarsRefunded lifetimeDollarsRefunded;
    @SerializedName(SERIALIZED_NAME_LIFETIME_DOLLARS_PURCHASED)
    private LifetimeDollarsPurchased lifetimeDollarsPurchased;
    @SerializedName(SERIALIZED_NAME_USER_STATUS)
    private UserStatus userStatus;


    public ConsumptionRequest() {
    }

    public ConsumptionRequest customerConsented(Boolean customerConsented) {
        this.customerConsented = customerConsented;
        return this;
    }

    /**
     * A Boolean value that indicates whether the customer consented to provide consumption data to the App Store.
     *
     * @return customerConsented
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/customerconsented">customerConsented</a>
     **/
    public Boolean getCustomerConsented() {
        return customerConsented;
    }

    public void setCustomerConsented(Boolean customerConsented) {
        this.customerConsented = customerConsented;
    }

    public ConsumptionRequest consumptionStatus(ConsumptionStatus consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
        return this;
    }

    /**
     * A value that indicates the extent to which the customer consumed the in-app purchase.
     *
     * @return consumptionStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionstatus">consumptionStatus</a>
     **/
    public ConsumptionStatus getConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(ConsumptionStatus consumptionStatus) {
        this.consumptionStatus = consumptionStatus;
    }

    public ConsumptionRequest platform(Platform platform) {
        this.platform = platform;
        return this;
    }

    /**
     * A value that indicates the platform on which the customer consumed the in-app purchase.
     *
     * @return platform
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/platform">platform</a>
     **/
    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public ConsumptionRequest sampleContentProvided(Boolean sampleContentProvided) {
        this.sampleContentProvided = sampleContentProvided;
        return this;
    }

    /**
     * A Boolean value that indicates whether you provided, prior to its purchase, a free sample or trial of the content, or information about its functionality.
     *
     * @return sampleContentProvided
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/samplecontentprovided">sampleContentProvided</a>
     **/
    public Boolean getSampleContentProvided() {
        return sampleContentProvided;
    }

    public void setSampleContentProvided(Boolean sampleContentProvided) {
        this.sampleContentProvided = sampleContentProvided;
    }

    public ConsumptionRequest deliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    /**
     * A value that indicates whether the app successfully delivered an in-app purchase that works properly.
     *
     * @return deliveryStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
     **/
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public ConsumptionRequest appAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * The UUID that an app optionally generates to map a customer’s in-app purchase with its resulting App Store transaction.
     *
     * @return appAccountToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appaccounttoken">appAccountToken</a>
     **/
    public UUID getAppAccountToken() {
        return appAccountToken;
    }

    public void setAppAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
    }

    public ConsumptionRequest accountTenure(AccountTenure accountTenure) {
        this.accountTenure = accountTenure;
        return this;
    }

    /**
     * The age of the customer’s account.
     *
     * @return accountTenure
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accounttenure">accountTenure</a>
     **/
    public AccountTenure getAccountTenure() {
        return accountTenure;
    }

    public void setAccountTenure(AccountTenure accountTenure) {
        this.accountTenure = accountTenure;
    }

    public ConsumptionRequest playTime(PlayTime playTime) {
        this.playTime = playTime;
        return this;
    }

    /**
     * A value that indicates the amount of time that the customer used the app.
     *
     * @return playTime
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionrequest">ConsumptionRequest</a>
     **/
    public PlayTime getPlayTime() {
        return playTime;
    }

    public void setPlayTime(PlayTime playTime) {
        this.playTime = playTime;
    }

    public ConsumptionRequest lifetimeDollarsRefunded(LifetimeDollarsRefunded lifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = lifetimeDollarsRefunded;
        return this;
    }

    /**
     * A value that indicates the total amount, in USD, of refunds the customer has received, in your app, across all platforms.
     *
     * @return lifetimeDollarsRefunded
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarsrefunded">lifetimeDollarsRefunded</a>
     **/
    public LifetimeDollarsRefunded getLifetimeDollarsRefunded() {
        return lifetimeDollarsRefunded;
    }

    public void setLifetimeDollarsRefunded(LifetimeDollarsRefunded lifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = lifetimeDollarsRefunded;
    }

    public ConsumptionRequest lifetimeDollarsPurchased(LifetimeDollarsPurchased lifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = lifetimeDollarsPurchased;
        return this;
    }

    /**
     * A value that indicates the total amount, in USD, of in-app purchases the customer has made in your app, across all platforms.
     *
     * @return lifetimeDollarsPurchased
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarspurchased">lifetimeDollarsPurchased</a>
     **/
    public LifetimeDollarsPurchased getLifetimeDollarsPurchased() {
        return lifetimeDollarsPurchased;
    }

    public void setLifetimeDollarsPurchased(LifetimeDollarsPurchased lifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = lifetimeDollarsPurchased;
    }

    public ConsumptionRequest userStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    /**
     * The status of the customer’s account.
     *
     * @return userStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/userstatus">userStatus</a>
     **/
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsumptionRequest consumptionRequest = (ConsumptionRequest) o;
        return Objects.equals(this.customerConsented, consumptionRequest.customerConsented) &&
                Objects.equals(this.consumptionStatus, consumptionRequest.consumptionStatus) &&
                Objects.equals(this.platform, consumptionRequest.platform) &&
                Objects.equals(this.sampleContentProvided, consumptionRequest.sampleContentProvided) &&
                Objects.equals(this.deliveryStatus, consumptionRequest.deliveryStatus) &&
                Objects.equals(this.appAccountToken, consumptionRequest.appAccountToken) &&
                Objects.equals(this.accountTenure, consumptionRequest.accountTenure) &&
                Objects.equals(this.playTime, consumptionRequest.playTime) &&
                Objects.equals(this.lifetimeDollarsRefunded, consumptionRequest.lifetimeDollarsRefunded) &&
                Objects.equals(this.lifetimeDollarsPurchased, consumptionRequest.lifetimeDollarsPurchased) &&
                Objects.equals(this.userStatus, consumptionRequest.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerConsented, consumptionStatus, platform, sampleContentProvided, deliveryStatus, appAccountToken, accountTenure, playTime, lifetimeDollarsRefunded, lifetimeDollarsPurchased, userStatus);
    }

    @Override
    public String toString() {
        return "ConsumptionRequest{" +
                "customerConsented=" + customerConsented +
                ", consumptionStatus=" + consumptionStatus +
                ", platform=" + platform +
                ", sampleContentProvided=" + sampleContentProvided +
                ", deliveryStatus=" + deliveryStatus +
                ", appAccountToken=" + appAccountToken +
                ", accountTenure=" + accountTenure +
                ", playTime=" + playTime +
                ", lifetimeDollarsRefunded=" + lifetimeDollarsRefunded +
                ", lifetimeDollarsPurchased=" + lifetimeDollarsPurchased +
                ", userStatus=" + userStatus +
                '}';
    }
}

