// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
    private static final String SERIALIZED_NAME_REFUND_PREFERENCE = "refundPreference";
    @JsonProperty(SERIALIZED_NAME_CUSTOMER_CONSENTED)
    private Boolean customerConsented;
    @JsonProperty(SERIALIZED_NAME_CONSUMPTION_STATUS)
    private Integer consumptionStatus;
    @JsonProperty(SERIALIZED_NAME_PLATFORM)
    private Integer platform;
    @JsonProperty(SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED)
    private Boolean sampleContentProvided;
    @JsonProperty(SERIALIZED_NAME_DELIVERY_STATUS)
    private Integer deliveryStatus;
    @JsonProperty(SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    @JsonSerialize(nullsUsing = AppAccountTokenNullSerializer.class)
    private UUID appAccountToken;
    @JsonProperty(SERIALIZED_NAME_ACCOUNT_TENURE)
    private Integer accountTenure;
    @JsonProperty(SERIALIZED_NAME_PLAY_TIME)
    private Integer playTime;
    @JsonProperty(SERIALIZED_NAME_LIFETIME_DOLLARS_REFUNDED)
    private Integer lifetimeDollarsRefunded;
    @JsonProperty(SERIALIZED_NAME_LIFETIME_DOLLARS_PURCHASED)
    private Integer lifetimeDollarsPurchased;
    @JsonProperty(SERIALIZED_NAME_USER_STATUS)
    private Integer userStatus;
    @JsonProperty(SERIALIZED_NAME_REFUND_PREFERENCE)
    private Integer refundPreference;


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
        this.consumptionStatus = consumptionStatus != null ? consumptionStatus.getValue() : null;
        return this;
    }

    /**
     * A value that indicates the extent to which the customer consumed the in-app purchase.
     *
     * @return consumptionStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionstatus">consumptionStatus</a>
     **/
    public ConsumptionStatus getConsumptionStatus() {
        return consumptionStatus != null ? ConsumptionStatus.fromValue(consumptionStatus) : null;
    }

    /**
     * @see #getConsumptionStatus()
     */
    public Integer getRawConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(ConsumptionStatus consumptionStatus) {
        this.consumptionStatus = consumptionStatus != null ? consumptionStatus.getValue() : null;
    }

    public void setRawConsumptionStatus(Integer rawConsumptionStatus) {
        this.consumptionStatus = rawConsumptionStatus;
    }

    public ConsumptionRequest platform(Platform platform) {
        this.platform = platform != null ? platform.getValue() :  null;
        return this;
    }

    /**
     * A value that indicates the platform on which the customer consumed the in-app purchase.
     *
     * @return platform
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/platform">platform</a>
     **/
    public Platform getPlatform() {
        return platform != null ? Platform.fromValue(platform) : null;
    }

    /**
     * @see #getPlatform()
     */
    public Integer getRawPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform != null ? platform.getValue() : null;
    }

    public void setRawPlatform(Integer rawPlatform) {
        this.platform = rawPlatform;
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
        this.deliveryStatus = deliveryStatus != null ? deliveryStatus.getValue() : null;
        return this;
    }

    /**
     * A value that indicates whether the app successfully delivered an in-app purchase that works properly.
     *
     * @return deliveryStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatus">deliveryStatus</a>
     **/
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus != null ? DeliveryStatus.fromValue(deliveryStatus) : null;
    }

    /**
     * @see #getDeliveryStatus()
     */
    public Integer getRawDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus != null ? deliveryStatus.getValue() : null;
    }

    public void setRawDeliveryStatus(Integer rawDeliveryStatus) {
        this.deliveryStatus = rawDeliveryStatus;
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
        this.accountTenure = accountTenure != null ? accountTenure.getValue() : null;
        return this;
    }

    /**
     * The age of the customer’s account.
     *
     * @return accountTenure
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accounttenure">accountTenure</a>
     **/
    public AccountTenure getAccountTenure() {
        return accountTenure != null ? AccountTenure.fromValue(accountTenure) : null;
    }

    /**
     * @see #getAccountTenure()
     */
    public Integer getRawAccountTenure() {
        return accountTenure;
    }

    public void setAccountTenure(AccountTenure accountTenure) {
        this.accountTenure = accountTenure != null ? accountTenure.getValue() : null;
    }

    public void setRawAccountTenure(Integer rawAccountTenure) {
        this.accountTenure = rawAccountTenure;
    }

    public ConsumptionRequest playTime(PlayTime playTime) {
        this.playTime = playTime != null ? playTime.getValue() : null;
        return this;
    }

    /**
     * A value that indicates the amount of time that the customer used the app.
     *
     * @return playTime
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/playtime">playTime</a>
     **/
    public PlayTime getPlayTime() {
        return playTime != null ? PlayTime.fromValue(playTime) : null;
    }

    /**
     * @see #getPlayTime()
     */
    public Integer getRawPlayTime() {
        return playTime;
    }

    public void setPlayTime(PlayTime playTime) {
        this.playTime = playTime != null ? playTime.getValue() : null;
    }

    public void setRawPlayTime(Integer rawPlayTime) {
        this.playTime = rawPlayTime;
    }

    public ConsumptionRequest lifetimeDollarsRefunded(LifetimeDollarsRefunded lifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = lifetimeDollarsRefunded != null ? lifetimeDollarsRefunded.getValue() : null;
        return this;
    }

    /**
     * A value that indicates the total amount, in USD, of refunds the customer has received, in your app, across all platforms.
     *
     * @return lifetimeDollarsRefunded
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarsrefunded">lifetimeDollarsRefunded</a>
     **/
    public LifetimeDollarsRefunded getLifetimeDollarsRefunded() {
        return lifetimeDollarsRefunded != null ? LifetimeDollarsRefunded.fromValue(lifetimeDollarsRefunded) : null;
    }

    /**
     * @see #getLifetimeDollarsRefunded()
     */
    public Integer getRawLifetimeDollarsRefunded() {
        return lifetimeDollarsRefunded;
    }

    public void setLifetimeDollarsRefunded(LifetimeDollarsRefunded lifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = lifetimeDollarsRefunded != null ? lifetimeDollarsRefunded.getValue() : null;
    }

    public void setRawLifetimeDollarsRefunded(Integer rawLifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = rawLifetimeDollarsRefunded;
    }

    public ConsumptionRequest lifetimeDollarsPurchased(LifetimeDollarsPurchased lifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = lifetimeDollarsPurchased != null ? lifetimeDollarsPurchased.getValue() : null;
        return this;
    }

    /**
     * A value that indicates the total amount, in USD, of in-app purchases the customer has made in your app, across all platforms.
     *
     * @return lifetimeDollarsPurchased
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarspurchased">lifetimeDollarsPurchased</a>
     **/
    public LifetimeDollarsPurchased getLifetimeDollarsPurchased() {
        return lifetimeDollarsPurchased != null ? LifetimeDollarsPurchased.fromValue(lifetimeDollarsPurchased) : null;
    }

    /**
     * @see #getLifetimeDollarsPurchased()
     */
    public Integer getRawLifetimeDollarsPurchased() {
        return lifetimeDollarsPurchased;
    }

    public void setLifetimeDollarsPurchased(LifetimeDollarsPurchased lifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = lifetimeDollarsPurchased != null ? lifetimeDollarsPurchased.getValue() : null;
    }

    public void setRawLifetimeDollarsPurchased(Integer rawLifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = rawLifetimeDollarsPurchased;
    }

    public ConsumptionRequest userStatus(UserStatus userStatus) {
        this.userStatus = userStatus != null ? userStatus.getValue() : null;
        return this;
    }

    /**
     * The status of the customer’s account.
     *
     * @return userStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/userstatus">userStatus</a>
     **/
    public UserStatus getUserStatus() {
        return userStatus != null ? UserStatus.fromValue(userStatus) : null;
    }

    /**
     * @see #getUserStatus()
     */
    public Integer getRawUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus != null ? userStatus.getValue() : null;
    }

    public void setRawUserStatus(Integer rawUserStatus) {
        this.userStatus = rawUserStatus;
    }

    public ConsumptionRequest refundPreference(RefundPreference refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
        return this;
    }

    /**
     * A value that indicates your preference, based on your operational logic, as to whether Apple should grant the refund.
     *
     * @return refundPreference
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreference">refundPreference</a>
     **/
    public RefundPreference getRefundPreference() {
        return refundPreference != null ? RefundPreference.fromValue(refundPreference) : null;
    }

    /**
     * @see #getRefundPreference()
     */
    public Integer getRawRefundPreference() {
        return refundPreference;
    }

    public void setRefundPreference(RefundPreference refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
    }

    public void setRawRefundPreference(Integer rawRefundPreference) {
        this.refundPreference = rawRefundPreference;
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
                Objects.equals(this.userStatus, consumptionRequest.userStatus) &&
                Objects.equals(this.refundPreference, consumptionRequest.refundPreference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerConsented, consumptionStatus, platform, sampleContentProvided, deliveryStatus, appAccountToken, accountTenure, playTime, lifetimeDollarsRefunded, lifetimeDollarsPurchased, userStatus, refundPreference);
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
                ", refundPreference=" + refundPreference +
                '}';
    }
}

