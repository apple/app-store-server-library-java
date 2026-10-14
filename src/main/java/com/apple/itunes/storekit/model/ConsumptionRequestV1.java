// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;
import java.util.UUID;

/**
 * The request body containing consumption information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionrequestv1">ConsumptionRequestV1</a>
 * @deprecated Use {@link ConsumptionRequest} instead.
 **/
@Deprecated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsumptionRequestV1 {
    private static final String SERIALIZED_NAME_ACCOUNT_TENURE = "accountTenure";
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    private static final String SERIALIZED_NAME_CONSUMPTION_STATUS = "consumptionStatus";
    private static final String SERIALIZED_NAME_CUSTOMER_CONSENTED = "customerConsented";
    private static final String SERIALIZED_NAME_DELIVERY_STATUS = "deliveryStatus";
    private static final String SERIALIZED_NAME_LIFETIME_DOLLARS_PURCHASED = "lifetimeDollarsPurchased";
    private static final String SERIALIZED_NAME_LIFETIME_DOLLARS_REFUNDED = "lifetimeDollarsRefunded";
    private static final String SERIALIZED_NAME_PLATFORM = "platform";
    private static final String SERIALIZED_NAME_PLAY_TIME = "playTime";
    private static final String SERIALIZED_NAME_REFUND_PREFERENCE = "refundPreference";
    private static final String SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED = "sampleContentProvided";
    private static final String SERIALIZED_NAME_USER_STATUS = "userStatus";

    @JsonProperty(value = SERIALIZED_NAME_ACCOUNT_TENURE, required = true)
    private Integer accountTenure;
    @JsonProperty(value = SERIALIZED_NAME_APP_ACCOUNT_TOKEN, required = true)
    @JsonSerialize(nullsUsing = AppAccountTokenNullSerializer.class)
    private UUID appAccountToken;
    @JsonProperty(value = SERIALIZED_NAME_CONSUMPTION_STATUS, required = true)
    private Integer consumptionStatus;
    @JsonProperty(value = SERIALIZED_NAME_CUSTOMER_CONSENTED, required = true)
    private Boolean customerConsented;
    @JsonProperty(value = SERIALIZED_NAME_DELIVERY_STATUS, required = true)
    private Integer deliveryStatus;
    @JsonProperty(value = SERIALIZED_NAME_LIFETIME_DOLLARS_PURCHASED, required = true)
    private Integer lifetimeDollarsPurchased;
    @JsonProperty(value = SERIALIZED_NAME_LIFETIME_DOLLARS_REFUNDED, required = true)
    private Integer lifetimeDollarsRefunded;
    @JsonProperty(value = SERIALIZED_NAME_PLATFORM, required = true)
    private Integer platform;
    @JsonProperty(value = SERIALIZED_NAME_PLAY_TIME, required = true)
    private Integer playTime;
    @JsonProperty(SERIALIZED_NAME_REFUND_PREFERENCE)
    private Integer refundPreference;
    @JsonProperty(value = SERIALIZED_NAME_SAMPLE_CONTENT_PROVIDED, required = true)
    private Boolean sampleContentProvided;
    @JsonProperty(value = SERIALIZED_NAME_USER_STATUS, required = true)
    private Integer userStatus;

    protected ConsumptionRequestV1() {
    }

    public ConsumptionRequestV1(
            AccountTenure accountTenure,
            UUID appAccountToken,
            ConsumptionStatus consumptionStatus,
            Boolean customerConsented,
            DeliveryStatusV1 deliveryStatus,
            LifetimeDollarsPurchased lifetimeDollarsPurchased,
            LifetimeDollarsRefunded lifetimeDollarsRefunded,
            Platform platform,
            PlayTime playTime,
            Boolean sampleContentProvided,
            UserStatus userStatus
    ) {
        this.accountTenure = Objects.requireNonNull(accountTenure).getValue();
        this.appAccountToken = appAccountToken;
        this.consumptionStatus = Objects.requireNonNull(consumptionStatus).getValue();
        this.customerConsented = Objects.requireNonNull(customerConsented);
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
        this.lifetimeDollarsPurchased = Objects.requireNonNull(lifetimeDollarsPurchased).getValue();
        this.lifetimeDollarsRefunded = Objects.requireNonNull(lifetimeDollarsRefunded).getValue();
        this.platform = Objects.requireNonNull(platform).getValue();
        this.playTime = Objects.requireNonNull(playTime).getValue();
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
        this.userStatus = Objects.requireNonNull(userStatus).getValue();
    }

    public ConsumptionRequestV1(
            Integer rawAccountTenure,
            UUID appAccountToken,
            Integer rawConsumptionStatus,
            Boolean customerConsented,
            Integer rawDeliveryStatus,
            Integer rawLifetimeDollarsPurchased,
            Integer rawLifetimeDollarsRefunded,
            Integer rawPlatform,
            Integer rawPlayTime,
            Boolean sampleContentProvided,
            Integer rawUserStatus
    ) {
        this.accountTenure = Objects.requireNonNull(rawAccountTenure);
        this.appAccountToken = appAccountToken;
        this.consumptionStatus = Objects.requireNonNull(rawConsumptionStatus);
        this.customerConsented = Objects.requireNonNull(customerConsented);
        this.deliveryStatus = Objects.requireNonNull(rawDeliveryStatus);
        this.lifetimeDollarsPurchased = Objects.requireNonNull(rawLifetimeDollarsPurchased);
        this.lifetimeDollarsRefunded = Objects.requireNonNull(rawLifetimeDollarsRefunded);
        this.platform = Objects.requireNonNull(rawPlatform);
        this.playTime = Objects.requireNonNull(rawPlayTime);
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
        this.userStatus = Objects.requireNonNull(rawUserStatus);
    }

    public ConsumptionRequestV1 accountTenure(AccountTenure accountTenure) {
        this.accountTenure = Objects.requireNonNull(accountTenure).getValue();
        return this;
    }

    /**
     * The age of the customer’s account.
     *
     * @return accountTenure
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accounttenure">accountTenure</a>
     **/
    public AccountTenure getAccountTenure() {
        return AccountTenure.fromValue(accountTenure);
    }

    /**
     * @see #getAccountTenure()
     **/
    public Integer getRawAccountTenure() {
        return accountTenure;
    }

    public void setAccountTenure(AccountTenure accountTenure) {
        this.accountTenure = Objects.requireNonNull(accountTenure).getValue();
    }

    public void setRawAccountTenure(Integer rawAccountTenure) {
        this.accountTenure = Objects.requireNonNull(rawAccountTenure);
    }

    public ConsumptionRequestV1 appAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * The UUID of the in-app user account that completed the in-app purchase transaction.
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

    public ConsumptionRequestV1 consumptionStatus(ConsumptionStatus consumptionStatus) {
        this.consumptionStatus = Objects.requireNonNull(consumptionStatus).getValue();
        return this;
    }

    /**
     * A value that indicates the extent to which the customer consumed the in-app purchase.
     *
     * @return consumptionStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionstatus">consumptionStatus</a>
     **/
    public ConsumptionStatus getConsumptionStatus() {
        return ConsumptionStatus.fromValue(consumptionStatus);
    }

    /**
     * @see #getConsumptionStatus()
     **/
    public Integer getRawConsumptionStatus() {
        return consumptionStatus;
    }

    public void setConsumptionStatus(ConsumptionStatus consumptionStatus) {
        this.consumptionStatus = Objects.requireNonNull(consumptionStatus).getValue();
    }

    public void setRawConsumptionStatus(Integer rawConsumptionStatus) {
        this.consumptionStatus = Objects.requireNonNull(rawConsumptionStatus);
    }

    public ConsumptionRequestV1 customerConsented(Boolean customerConsented) {
        this.customerConsented = Objects.requireNonNull(customerConsented);
        return this;
    }

    /**
     * A Boolean value of true or false that indicates whether the customer consented to provide consumption data.
     *
     * @return customerConsented
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/customerconsented">customerConsented</a>
     **/
    public Boolean getCustomerConsented() {
        return customerConsented;
    }

    public void setCustomerConsented(Boolean customerConsented) {
        this.customerConsented = Objects.requireNonNull(customerConsented);
    }

    public ConsumptionRequestV1 deliveryStatus(DeliveryStatusV1 deliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
        return this;
    }

    /**
     * A value that indicates whether the app successfully delivered an in-app purchase that works properly.
     *
     * @return deliveryStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/deliverystatusv1">deliveryStatusV1</a>
     **/
    public DeliveryStatusV1 getDeliveryStatus() {
        return DeliveryStatusV1.fromValue(deliveryStatus);
    }

    /**
     * @see #getDeliveryStatus()
     **/
    public Integer getRawDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusV1 deliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(deliveryStatus).getValue();
    }

    public void setRawDeliveryStatus(Integer rawDeliveryStatus) {
        this.deliveryStatus = Objects.requireNonNull(rawDeliveryStatus);
    }

    public ConsumptionRequestV1 lifetimeDollarsPurchased(LifetimeDollarsPurchased lifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = Objects.requireNonNull(lifetimeDollarsPurchased).getValue();
        return this;
    }

    /**
     * A value that indicates the total amount, in USD, of in-app purchases the customer has made in your app, across all platforms.
     *
     * @return lifetimeDollarsPurchased
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarspurchased">lifetimeDollarsPurchased</a>
     **/
    public LifetimeDollarsPurchased getLifetimeDollarsPurchased() {
        return LifetimeDollarsPurchased.fromValue(lifetimeDollarsPurchased);
    }

    /**
     * @see #getLifetimeDollarsPurchased()
     **/
    public Integer getRawLifetimeDollarsPurchased() {
        return lifetimeDollarsPurchased;
    }

    public void setLifetimeDollarsPurchased(LifetimeDollarsPurchased lifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = Objects.requireNonNull(lifetimeDollarsPurchased).getValue();
    }

    public void setRawLifetimeDollarsPurchased(Integer rawLifetimeDollarsPurchased) {
        this.lifetimeDollarsPurchased = Objects.requireNonNull(rawLifetimeDollarsPurchased);
    }

    public ConsumptionRequestV1 lifetimeDollarsRefunded(LifetimeDollarsRefunded lifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = Objects.requireNonNull(lifetimeDollarsRefunded).getValue();
        return this;
    }

    /**
     * A value that indicates the total amount, in USD, of refunds the customer has received, in your app, across all platforms.
     *
     * @return lifetimeDollarsRefunded
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/lifetimedollarsrefunded">lifetimeDollarsRefunded</a>
     **/
    public LifetimeDollarsRefunded getLifetimeDollarsRefunded() {
        return LifetimeDollarsRefunded.fromValue(lifetimeDollarsRefunded);
    }

    /**
     * @see #getLifetimeDollarsRefunded()
     **/
    public Integer getRawLifetimeDollarsRefunded() {
        return lifetimeDollarsRefunded;
    }

    public void setLifetimeDollarsRefunded(LifetimeDollarsRefunded lifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = Objects.requireNonNull(lifetimeDollarsRefunded).getValue();
    }

    public void setRawLifetimeDollarsRefunded(Integer rawLifetimeDollarsRefunded) {
        this.lifetimeDollarsRefunded = Objects.requireNonNull(rawLifetimeDollarsRefunded);
    }

    public ConsumptionRequestV1 platform(Platform platform) {
        this.platform = Objects.requireNonNull(platform).getValue();
        return this;
    }

    /**
     * A value that indicates the platform on which the customer consumed the in-app purchase.
     *
     * @return platform
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/platform">platform</a>
     **/
    public Platform getPlatform() {
        return Platform.fromValue(platform);
    }

    /**
     * @see #getPlatform()
     **/
    public Integer getRawPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = Objects.requireNonNull(platform).getValue();
    }

    public void setRawPlatform(Integer rawPlatform) {
        this.platform = Objects.requireNonNull(rawPlatform);
    }

    public ConsumptionRequestV1 playTime(PlayTime playTime) {
        this.playTime = Objects.requireNonNull(playTime).getValue();
        return this;
    }

    /**
     * A value that indicates the amount of time that the customer used the app.
     *
     * @return playTime
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/playtime">playTime</a>
     **/
    public PlayTime getPlayTime() {
        return PlayTime.fromValue(playTime);
    }

    /**
     * @see #getPlayTime()
     **/
    public Integer getRawPlayTime() {
        return playTime;
    }

    public void setPlayTime(PlayTime playTime) {
        this.playTime = Objects.requireNonNull(playTime).getValue();
    }

    public void setRawPlayTime(Integer rawPlayTime) {
        this.playTime = Objects.requireNonNull(rawPlayTime);
    }

    public ConsumptionRequestV1 refundPreference(RefundPreferenceV1 refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
        return this;
    }

    /**
     * A value that indicates your preference, based on your operational logic, as to whether Apple should grant the refund.
     *
     * @return refundPreference
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/refundpreferencev1">refundPreferenceV1</a>
     **/
    public RefundPreferenceV1 getRefundPreference() {
        return RefundPreferenceV1.fromValue(refundPreference);
    }

    /**
     * @see #getRefundPreference()
     **/
    public Integer getRawRefundPreference() {
        return refundPreference;
    }

    public void setRefundPreference(RefundPreferenceV1 refundPreference) {
        this.refundPreference = refundPreference != null ? refundPreference.getValue() : null;
    }

    public void setRawRefundPreference(Integer rawRefundPreference) {
        this.refundPreference = rawRefundPreference;
    }

    public ConsumptionRequestV1 sampleContentProvided(Boolean sampleContentProvided) {
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
        return this;
    }

    /**
     * A Boolean value of true or false that indicates whether you provided, prior to its purchase, a free sample or trial of the content, or information about its functionality.
     *
     * @return sampleContentProvided
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/samplecontentprovided">sampleContentProvided</a>
     **/
    public Boolean getSampleContentProvided() {
        return sampleContentProvided;
    }

    public void setSampleContentProvided(Boolean sampleContentProvided) {
        this.sampleContentProvided = Objects.requireNonNull(sampleContentProvided);
    }

    public ConsumptionRequestV1 userStatus(UserStatus userStatus) {
        this.userStatus = Objects.requireNonNull(userStatus).getValue();
        return this;
    }

    /**
     * The status of the customer’s account.
     *
     * @return userStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/userstatus">userStatus</a>
     **/
    public UserStatus getUserStatus() {
        return UserStatus.fromValue(userStatus);
    }

    /**
     * @see #getUserStatus()
     **/
    public Integer getRawUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = Objects.requireNonNull(userStatus).getValue();
    }

    public void setRawUserStatus(Integer rawUserStatus) {
        this.userStatus = Objects.requireNonNull(rawUserStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsumptionRequestV1 consumptionRequestV1 = (ConsumptionRequestV1) o;
        return Objects.equals(this.accountTenure, consumptionRequestV1.accountTenure) &&
                Objects.equals(this.appAccountToken, consumptionRequestV1.appAccountToken) &&
                Objects.equals(this.consumptionStatus, consumptionRequestV1.consumptionStatus) &&
                Objects.equals(this.customerConsented, consumptionRequestV1.customerConsented) &&
                Objects.equals(this.deliveryStatus, consumptionRequestV1.deliveryStatus) &&
                Objects.equals(this.lifetimeDollarsPurchased, consumptionRequestV1.lifetimeDollarsPurchased) &&
                Objects.equals(this.lifetimeDollarsRefunded, consumptionRequestV1.lifetimeDollarsRefunded) &&
                Objects.equals(this.platform, consumptionRequestV1.platform) &&
                Objects.equals(this.playTime, consumptionRequestV1.playTime) &&
                Objects.equals(this.refundPreference, consumptionRequestV1.refundPreference) &&
                Objects.equals(this.sampleContentProvided, consumptionRequestV1.sampleContentProvided) &&
                Objects.equals(this.userStatus, consumptionRequestV1.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTenure, appAccountToken, consumptionStatus, customerConsented, deliveryStatus, lifetimeDollarsPurchased, lifetimeDollarsRefunded, platform, playTime, refundPreference, sampleContentProvided, userStatus);
    }

    @Override
    public String toString() {
        return "ConsumptionRequestV1{" +
                "accountTenure=" + accountTenure +
                ", appAccountToken=" + appAccountToken +
                ", consumptionStatus=" + consumptionStatus +
                ", customerConsented=" + customerConsented +
                ", deliveryStatus=" + deliveryStatus +
                ", lifetimeDollarsPurchased=" + lifetimeDollarsPurchased +
                ", lifetimeDollarsRefunded=" + lifetimeDollarsRefunded +
                ", platform=" + platform +
                ", playTime=" + playTime +
                ", refundPreference=" + refundPreference +
                ", sampleContentProvided=" + sampleContentProvided +
                ", userStatus=" + userStatus +
                '}';
    }
}
