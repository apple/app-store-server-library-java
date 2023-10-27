// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * A decoded payload containing subscription renewal information for an auto-renewable subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsrenewalinfodecodedpayload">JWSRenewalInfoDecodedPayload</a>
 */
public class JWSRenewalInfoDecodedPayload implements DecodedSignedData {
    private static final String SERIALIZED_NAME_EXPIRATION_INTENT = "expirationIntent";
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_AUTO_RENEW_PRODUCT_ID = "autoRenewProductId";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_AUTO_RENEW_STATUS = "autoRenewStatus";
    private static final String SERIALIZED_NAME_IS_IN_BILLING_RETRY_PERIOD = "isInBillingRetryPeriod";
    private static final String SERIALIZED_NAME_PRICE_INCREASE_STATUS = "priceIncreaseStatus";
    private static final String SERIALIZED_NAME_GRACE_PERIOD_EXPIRES_DATE = "gracePeriodExpiresDate";
    private static final String SERIALIZED_NAME_OFFER_TYPE = "offerType";
    private static final String SERIALIZED_NAME_OFFER_IDENTIFIER = "offerIdentifier";
    private static final String SERIALIZED_NAME_SIGNED_DATE = "signedDate";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_RECENT_SUBSCRIPTION_START_DATE = "recentSubscriptionStartDate";
    private static final String SERIALIZED_NAME_RENEWAL_DATE = "renewalDate";
    @SerializedName(SERIALIZED_NAME_EXPIRATION_INTENT)
    private ExpirationIntent expirationIntent;
    @SerializedName(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @SerializedName(SERIALIZED_NAME_AUTO_RENEW_PRODUCT_ID)
    private String autoRenewProductId;
    @SerializedName(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;
    @SerializedName(SERIALIZED_NAME_AUTO_RENEW_STATUS)
    private AutoRenewStatus autoRenewStatus;
    @SerializedName(SERIALIZED_NAME_IS_IN_BILLING_RETRY_PERIOD)
    private Boolean isInBillingRetryPeriod;
    @SerializedName(SERIALIZED_NAME_PRICE_INCREASE_STATUS)
    private PriceIncreaseStatus priceIncreaseStatus;
    @SerializedName(SERIALIZED_NAME_GRACE_PERIOD_EXPIRES_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long gracePeriodExpiresDate;
    @SerializedName(SERIALIZED_NAME_OFFER_TYPE)
    private OfferType offerType;
    @SerializedName(SERIALIZED_NAME_OFFER_IDENTIFIER)
    private String offerIdentifier;
    @SerializedName(SERIALIZED_NAME_SIGNED_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long signedDate;
    @SerializedName(SERIALIZED_NAME_ENVIRONMENT)
    private Environment environment;
    @SerializedName(SERIALIZED_NAME_RECENT_SUBSCRIPTION_START_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long recentSubscriptionStartDate;
    @SerializedName(SERIALIZED_NAME_RENEWAL_DATE)
    @JsonAdapter(XcodeCompatibleTimestampDeserializer.class)
    private Long renewalDate;


    public JWSRenewalInfoDecodedPayload() {
    }

    public JWSRenewalInfoDecodedPayload expirationIntent(ExpirationIntent expirationIntent) {
        this.expirationIntent = expirationIntent;
        return this;
    }

    /**
     * The reason the subscription expired.
     *
     * @return expirationIntent
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/expirationintent">expirationIntent</a>
     **/
    public ExpirationIntent getExpirationIntent() {
        return expirationIntent;
    }

    public void setExpirationIntent(ExpirationIntent expirationIntent) {
        this.expirationIntent = expirationIntent;
    }

    public JWSRenewalInfoDecodedPayload originalTransactionId(String originalTransactionId) {
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

    public JWSRenewalInfoDecodedPayload autoRenewProductId(String autoRenewProductId) {
        this.autoRenewProductId = autoRenewProductId;
        return this;
    }

    /**
     * The product identifier of the product that will renew at the next billing period.
     *
     * @return autoRenewProductId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/autorenewproductid">autoRenewProductId</a>
     **/
    public String getAutoRenewProductId() {
        return autoRenewProductId;
    }

    public void setAutoRenewProductId(String autoRenewProductId) {
        this.autoRenewProductId = autoRenewProductId;
    }

    public JWSRenewalInfoDecodedPayload productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The unique identifier for the product, that you create in App Store Connect.
     *
     * @return productId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/productid">productId</a>
     **/
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public JWSRenewalInfoDecodedPayload autoRenewStatus(AutoRenewStatus autoRenewStatus) {
        this.autoRenewStatus = autoRenewStatus;
        return this;
    }

    /**
     * The renewal status of the auto-renewable subscription.
     *
     * @return autoRenewStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/autorenewstatus">autoRenewStatus</a>
     **/
    public AutoRenewStatus getAutoRenewStatus() {
        return autoRenewStatus;
    }

    public void setAutoRenewStatus(AutoRenewStatus autoRenewStatus) {
        this.autoRenewStatus = autoRenewStatus;
    }

    public JWSRenewalInfoDecodedPayload isInBillingRetryPeriod(Boolean isInBillingRetryPeriod) {
        this.isInBillingRetryPeriod = isInBillingRetryPeriod;
        return this;
    }

    /**
     * A Boolean value that indicates whether the App Store is attempting to automatically renew an expired subscription.
     *
     * @return isInBillingRetryPeriod
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/isinbillingretryperiod">isInBillingRetryPeriod</a>
     **/
    public Boolean getIsInBillingRetryPeriod() {
        return isInBillingRetryPeriod;
    }

    public void setIsInBillingRetryPeriod(Boolean isInBillingRetryPeriod) {
        this.isInBillingRetryPeriod = isInBillingRetryPeriod;
    }

    public JWSRenewalInfoDecodedPayload priceIncreaseStatus(PriceIncreaseStatus priceIncreaseStatus) {
        this.priceIncreaseStatus = priceIncreaseStatus;
        return this;
    }

    /**
     * The status that indicates whether the auto-renewable subscription is subject to a price increase.
     *
     * @return priceIncreaseStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/priceincreasestatus">priceIncreaseStatus</a>
     **/
    public PriceIncreaseStatus getPriceIncreaseStatus() {
        return priceIncreaseStatus;
    }

    public void setPriceIncreaseStatus(PriceIncreaseStatus priceIncreaseStatus) {
        this.priceIncreaseStatus = priceIncreaseStatus;
    }

    public JWSRenewalInfoDecodedPayload gracePeriodExpiresDate(Long gracePeriodExpiresDate) {
        this.gracePeriodExpiresDate = gracePeriodExpiresDate;
        return this;
    }

    /**
     * The time when the billing grace period for subscription renewals expires.
     *
     * @return gracePeriodExpiresDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/graceperiodexpiresdate">gracePeriodExpiresDate</a>
     **/
    public Long getGracePeriodExpiresDate() {
        return gracePeriodExpiresDate;
    }

    public void setGracePeriodExpiresDate(Long gracePeriodExpiresDate) {
        this.gracePeriodExpiresDate = gracePeriodExpiresDate;
    }

    public JWSRenewalInfoDecodedPayload offerType(OfferType offerType) {
        this.offerType = offerType;
        return this;
    }

    /**
     * The type of the subscription offer.
     *
     * @return offerType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offertype">offerType</a>
     **/
    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public JWSRenewalInfoDecodedPayload offerIdentifier(String offerIdentifier) {
        this.offerIdentifier = offerIdentifier;
        return this;
    }

    /**
     * The identifier that contains the promo code or the promotional offer identifier.
     *
     * @return offerIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offeridentifier">offerIdentifier</a>
     **/
    public String getOfferIdentifier() {
        return offerIdentifier;
    }

    public void setOfferIdentifier(String offerIdentifier) {
        this.offerIdentifier = offerIdentifier;
    }

    public JWSRenewalInfoDecodedPayload signedDate(Long signedDate) {
        this.signedDate = signedDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store signed the JSON Web Signature data.
     *
     * @return signedDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/signeddate">signedDate</a>
     **/
    public Long getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Long signedDate) {
        this.signedDate = signedDate;
    }

    public JWSRenewalInfoDecodedPayload environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    /**
     * The server environment, either sandbox or production.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
     **/
    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public JWSRenewalInfoDecodedPayload recentSubscriptionStartDate(Long recentSubscriptionStartDate) {
        this.recentSubscriptionStartDate = recentSubscriptionStartDate;
        return this;
    }

    /**
     * The earliest start date of a subscription in a series of auto-renewable subscription purchases that ignores all lapses of paid service shorter than 60 days.
     *
     * @return recentSubscriptionStartDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/recentsubscriptionstartdate">recentSubscriptionStartDate</a>
     **/
    public Long getRecentSubscriptionStartDate() {
        return recentSubscriptionStartDate;
    }

    public void setRecentSubscriptionStartDate(Long recentSubscriptionStartDate) {
        this.recentSubscriptionStartDate = recentSubscriptionStartDate;
    }

    public JWSRenewalInfoDecodedPayload renewalDate(Long renewalDate) {
        this.renewalDate = renewalDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, when the most recent auto-renewable subscription purchase expires.
     *
     * @return renewalDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/renewaldate">renewalDate</a>
     **/
    public Long getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Long renewalDate) {
        this.renewalDate = renewalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JWSRenewalInfoDecodedPayload jwSRenewalInfoDecodedPayload = (JWSRenewalInfoDecodedPayload) o;
        return Objects.equals(this.expirationIntent, jwSRenewalInfoDecodedPayload.expirationIntent) &&
                Objects.equals(this.originalTransactionId, jwSRenewalInfoDecodedPayload.originalTransactionId) &&
                Objects.equals(this.autoRenewProductId, jwSRenewalInfoDecodedPayload.autoRenewProductId) &&
                Objects.equals(this.productId, jwSRenewalInfoDecodedPayload.productId) &&
                Objects.equals(this.autoRenewStatus, jwSRenewalInfoDecodedPayload.autoRenewStatus) &&
                Objects.equals(this.isInBillingRetryPeriod, jwSRenewalInfoDecodedPayload.isInBillingRetryPeriod) &&
                Objects.equals(this.priceIncreaseStatus, jwSRenewalInfoDecodedPayload.priceIncreaseStatus) &&
                Objects.equals(this.gracePeriodExpiresDate, jwSRenewalInfoDecodedPayload.gracePeriodExpiresDate) &&
                Objects.equals(this.offerType, jwSRenewalInfoDecodedPayload.offerType) &&
                Objects.equals(this.offerIdentifier, jwSRenewalInfoDecodedPayload.offerIdentifier) &&
                Objects.equals(this.signedDate, jwSRenewalInfoDecodedPayload.signedDate) &&
                Objects.equals(this.environment, jwSRenewalInfoDecodedPayload.environment) &&
                Objects.equals(this.recentSubscriptionStartDate, jwSRenewalInfoDecodedPayload.recentSubscriptionStartDate) &&
                Objects.equals(this.renewalDate, jwSRenewalInfoDecodedPayload.renewalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationIntent, originalTransactionId, autoRenewProductId, productId, autoRenewStatus, isInBillingRetryPeriod, priceIncreaseStatus, gracePeriodExpiresDate, offerType, offerIdentifier, signedDate, environment, recentSubscriptionStartDate, renewalDate);
    }

    @Override
    public String toString() {
        return "JWSRenewalInfoDecodedPayload{" +
                "expirationIntent=" + expirationIntent +
                ", originalTransactionId='" + originalTransactionId + '\'' +
                ", autoRenewProductId='" + autoRenewProductId + '\'' +
                ", productId='" + productId + '\'' +
                ", autoRenewStatus=" + autoRenewStatus +
                ", isInBillingRetryPeriod=" + isInBillingRetryPeriod +
                ", priceIncreaseStatus=" + priceIncreaseStatus +
                ", gracePeriodExpiresDate=" + gracePeriodExpiresDate +
                ", offerType=" + offerType +
                ", offerIdentifier='" + offerIdentifier + '\'' +
                ", signedDate=" + signedDate +
                ", environment=" + environment +
                ", recentSubscriptionStartDate=" + recentSubscriptionStartDate +
                ", renewalDate=" + renewalDate +
                '}';
    }
}

