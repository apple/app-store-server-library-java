// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

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
    private static final String SERIALIZED_NAME_RENEWAL_PRICE = "renewalPrice";
    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_OFFER_DISCOUNT_TYPE = "offerDiscountType";
    private static final String SERIALIZED_NAME_ELIGIBLE_WIN_BACK_OFFER_IDS = "eligibleWinBackOfferIds";
    private static final String SERIALIZED_NAME_APP_TRANSACTION_ID = "appTransactionId";
    private static final String SERIALIZED_NAME_OFFER_PERIOD = "offerPeriod";
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    @JsonProperty(SERIALIZED_NAME_EXPIRATION_INTENT)
    private Integer expirationIntent;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @JsonProperty(SERIALIZED_NAME_AUTO_RENEW_PRODUCT_ID)
    private String autoRenewProductId;
    @JsonProperty(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;
    @JsonProperty(SERIALIZED_NAME_AUTO_RENEW_STATUS)
    private Integer autoRenewStatus;
    @JsonProperty(SERIALIZED_NAME_IS_IN_BILLING_RETRY_PERIOD)
    private Boolean isInBillingRetryPeriod;
    @JsonProperty(SERIALIZED_NAME_PRICE_INCREASE_STATUS)
    private Integer priceIncreaseStatus;
    @JsonProperty(SERIALIZED_NAME_GRACE_PERIOD_EXPIRES_DATE)
    @JsonDeserialize(using=XcodeCompatibleTimestampDeserializer.class)
    private Long gracePeriodExpiresDate;
    @JsonProperty(SERIALIZED_NAME_OFFER_TYPE)
    private Integer offerType;
    @JsonProperty(SERIALIZED_NAME_OFFER_IDENTIFIER)
    private String offerIdentifier;
    @JsonProperty(SERIALIZED_NAME_SIGNED_DATE)
    @JsonDeserialize(using=XcodeCompatibleTimestampDeserializer.class)
    private Long signedDate;
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_RECENT_SUBSCRIPTION_START_DATE)
    @JsonDeserialize(using=XcodeCompatibleTimestampDeserializer.class)
    private Long recentSubscriptionStartDate;
    @JsonProperty(SERIALIZED_NAME_RENEWAL_DATE)
    @JsonDeserialize(using=XcodeCompatibleTimestampDeserializer.class)
    private Long renewalDate;
    @JsonProperty(SERIALIZED_NAME_RENEWAL_PRICE)
    private Long renewalPrice;
    @JsonProperty(SERIALIZED_NAME_CURRENCY)
    private String currency;
    @JsonProperty(SERIALIZED_NAME_OFFER_DISCOUNT_TYPE)
    private String offerDiscountType;
    @JsonProperty(SERIALIZED_NAME_ELIGIBLE_WIN_BACK_OFFER_IDS)
    private List<String> eligibleWinBackOfferIds = null;
    @JsonProperty(SERIALIZED_NAME_APP_TRANSACTION_ID)
    private String appTransactionId;
    @JsonProperty(SERIALIZED_NAME_OFFER_PERIOD)
    private String offerPeriod;
    @JsonProperty(SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    private UUID appAccountToken;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public JWSRenewalInfoDecodedPayload() {
    }

    public JWSRenewalInfoDecodedPayload expirationIntent(ExpirationIntent expirationIntent) {
        this.expirationIntent = expirationIntent != null ? expirationIntent.getValue() : null;
        return this;
    }

    /**
     * The reason the subscription expired.
     *
     * @return expirationIntent
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/expirationintent">expirationIntent</a>
     **/
    public ExpirationIntent getExpirationIntent() {
        return expirationIntent != null ? ExpirationIntent.fromValue(expirationIntent) : null;
    }

    /**
     * @see #getExpirationIntent()
     */
    public Integer getRawExpirationIntent() {
        return expirationIntent;
    }

    public void setExpirationIntent(ExpirationIntent expirationIntent) {
        this.expirationIntent = expirationIntent != null ? expirationIntent.getValue() : null;
    }

    public void setRawExpirationIntent(Integer rawExpirationIntent) {
        this.expirationIntent = rawExpirationIntent;
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
        this.autoRenewStatus = autoRenewStatus != null ? autoRenewStatus.getValue() : null;
        return this;
    }

    /**
     * The renewal status of the auto-renewable subscription.
     *
     * @return autoRenewStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/autorenewstatus">autoRenewStatus</a>
     **/
    public AutoRenewStatus getAutoRenewStatus() {
        return autoRenewStatus != null ? AutoRenewStatus.fromValue(autoRenewStatus) : null;
    }

    /**
     * @see #getAutoRenewStatus()
     */
    public Integer getRawAutoRenewStatus() {
        return autoRenewStatus;
    }

    public void setAutoRenewStatus(AutoRenewStatus autoRenewStatus) {
        this.autoRenewStatus = autoRenewStatus != null ? autoRenewStatus.getValue() : null;
    }

    public void setRawAutoRenewStatus(Integer rawAutoRenewStatus) {
        this.autoRenewStatus = rawAutoRenewStatus;
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
        this.priceIncreaseStatus = priceIncreaseStatus != null ? priceIncreaseStatus.getValue() : null;
        return this;
    }

    /**
     * The status that indicates whether the auto-renewable subscription is subject to a price increase.
     *
     * @return priceIncreaseStatus
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/priceincreasestatus">priceIncreaseStatus</a>
     **/
    public PriceIncreaseStatus getPriceIncreaseStatus() {
        return priceIncreaseStatus != null ? PriceIncreaseStatus.fromValue(priceIncreaseStatus) : null;
    }

    /**
     * @see #getPriceIncreaseStatus()
     */
    public Integer getRawPriceIncreaseStatus() {
        return priceIncreaseStatus;
    }

    public void setPriceIncreaseStatus(PriceIncreaseStatus priceIncreaseStatus) {
        this.priceIncreaseStatus = priceIncreaseStatus != null ? priceIncreaseStatus.getValue() : null;
    }

    public void setRawPriceIncreaseStatus(Integer rawPriceIncreaseStatus) {
        this.priceIncreaseStatus = rawPriceIncreaseStatus;
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
        this.offerType = offerType != null ? offerType.getValue() : null;
        return this;
    }

    /**
     * The type of subscription offer.
     *
     * @return offerType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offertype">offerType</a>
     **/
    public OfferType getOfferType() {
        return offerType != null ? OfferType.fromValue(offerType) : null;
    }

    /**
     * @see #getOfferType()
     */
    public Integer getRawOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType != null ? offerType.getValue() : null;
    }

    public void setRawOfferType(Integer rawOfferType) {
        this.offerType = rawOfferType;
    }

    public JWSRenewalInfoDecodedPayload offerIdentifier(String offerIdentifier) {
        this.offerIdentifier = offerIdentifier;
        return this;
    }

    /**
     * The offer code or the promotional offer identifier.
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
        this.environment = environment != null ? environment.getValue() : null;
        return this;
    }

    /**
     * The server environment, either sandbox or production.
     *
     * @return environment
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/environment">environment</a>
     **/
    public Environment getEnvironment() {
        return environment != null ? Environment.fromValue(environment) : null;
    }

    /**
     * @see #getEnvironment()
     */
    public String getRawEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
    }

    public void setRawEnvironment(String rawEnvironment) {
        this.environment = rawEnvironment;
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

    public JWSRenewalInfoDecodedPayload renewalPrice(Long renewalPrice) {
        this.renewalPrice = renewalPrice;
        return this;
    }

    /**
     * The renewal price, in milliunits, of the auto-renewable subscription that renews at the next billing period.
     *
     * @return renewalPrice
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/renewalprice">renewalPrice</a>
     **/
    public Long getRenewalPrice() {
        return renewalPrice;
    }

    public void setRenewalPrice(Long renewalPrice) {
        this.renewalPrice = renewalPrice;
    }

    public JWSRenewalInfoDecodedPayload currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * The currency code for the renewalPrice of the subscription.
     *
     * @return currency
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/currency">currency</a>
     **/
    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public JWSRenewalInfoDecodedPayload offerDiscountType(OfferDiscountType offerDiscountType) {
        this.offerDiscountType = offerDiscountType != null ? offerDiscountType.getValue() : null;
        return this;
    }

    /**
     * The payment mode you configure for the offer.
     *
     * @return offerDiscountType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offerdiscounttype">offerDiscountType</a>
     **/
    public OfferDiscountType getOfferDiscountType() {
        return offerDiscountType != null ? OfferDiscountType.fromValue(offerDiscountType) : null;
    }

    /**
     * @see #getOfferDiscountType()
     */
    public String getRawOfferDiscountType() {
        return offerDiscountType;
    }

    public void setOfferDiscountType(OfferDiscountType offerDiscountType) {
        this.offerDiscountType = offerDiscountType != null ? offerDiscountType.getValue() : null;
    }

    public void setRawOfferDiscountType(String rawOfferDiscountType) {
        this.offerDiscountType = rawOfferDiscountType;
    }

    public JWSRenewalInfoDecodedPayload eligibleWinBackOfferIds(List<String> eligibleWinBackOfferIds) {
        this.eligibleWinBackOfferIds = eligibleWinBackOfferIds;
        return this;
    }

    public JWSRenewalInfoDecodedPayload addEligibleWinBackOfferId(String eligibleWinBackOfferId) {
        if (this.eligibleWinBackOfferIds == null) {
            this.eligibleWinBackOfferIds = new ArrayList<>();
        }
        this.eligibleWinBackOfferIds.add(eligibleWinBackOfferId);
        return this;
    }

    /**
     * An array of win-back offer identifiers that a customer is eligible to redeem, which sorts the identifiers to present the better offers first.
     *
     * @return eligibleWinBackOfferIds
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/eligiblewinbackofferids">eligibleWinBackOfferIds</a>
     **/
    public List<String> getEligibleWinBackOfferIds() {
        return eligibleWinBackOfferIds;
    }

    public void setEligibleWinBackOfferIds(List<String> eligibleWinBackOfferIds) {
        this.eligibleWinBackOfferIds = eligibleWinBackOfferIds;
    }

    public JWSRenewalInfoDecodedPayload appTransactionId(String appTransactionId) {
        this.appTransactionId = appTransactionId;
        return this;
    }

    /**
     * The unique identifier of the app download transaction.
     *
     * @return appTransactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appTransactionId">appTransactionId</a>
     **/
    public String getAppTransactionId() {
        return this.appTransactionId;
    }

    public void setAppTransactionId(String appTransactionId) {
        this.appTransactionId = appTransactionId;
    }

    public JWSRenewalInfoDecodedPayload offerPeriod(String offerPeriod) {
        this.offerPeriod = offerPeriod;
        return this;
    }

    /**
     * The duration of the offer.
     *
     * @return offerPeriod
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offerPeriod">offerPeriod</a>
     **/
    public String getOfferPeriod() {
        return this.offerPeriod;
    }

    public void setOfferPeriod(String offerPeriod) {
        this.offerPeriod = offerPeriod;
    }

    public JWSRenewalInfoDecodedPayload appAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * The UUID that an app optionally generates to map a customer’s In-App Purchase with its resulting App Store transaction.
     *
     * @return appAccountToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appAccountToken">appAccountToken</a>
     **/
    public UUID getAppAccountToken() {
        return this.appAccountToken;
    }

    public void setAppAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
    }

    public JWSRenewalInfoDecodedPayload unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JWSRenewalInfoDecodedPayload that = (JWSRenewalInfoDecodedPayload) o;
        return Objects.equals(expirationIntent, that.expirationIntent) && Objects.equals(originalTransactionId, that.originalTransactionId) && Objects.equals(autoRenewProductId, that.autoRenewProductId) && Objects.equals(productId, that.productId) && Objects.equals(autoRenewStatus, that.autoRenewStatus) && Objects.equals(isInBillingRetryPeriod, that.isInBillingRetryPeriod) && Objects.equals(priceIncreaseStatus, that.priceIncreaseStatus) && Objects.equals(gracePeriodExpiresDate, that.gracePeriodExpiresDate) && Objects.equals(offerType, that.offerType) && Objects.equals(offerIdentifier, that.offerIdentifier) && Objects.equals(signedDate, that.signedDate) && Objects.equals(environment, that.environment) && Objects.equals(recentSubscriptionStartDate, that.recentSubscriptionStartDate) && Objects.equals(renewalDate, that.renewalDate) && Objects.equals(renewalPrice, that.renewalPrice) && Objects.equals(currency, that.currency) && Objects.equals(offerDiscountType, that.offerDiscountType) && Objects.equals(eligibleWinBackOfferIds, that.eligibleWinBackOfferIds) && Objects.equals(appTransactionId, that.appTransactionId) && Objects.equals(offerPeriod, that.offerPeriod) && Objects.equals(appAccountToken, that.appAccountToken) && Objects.equals(unknownFields, that.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expirationIntent, originalTransactionId, autoRenewProductId, productId, autoRenewStatus, isInBillingRetryPeriod, priceIncreaseStatus, gracePeriodExpiresDate, offerType, offerIdentifier, signedDate, environment, recentSubscriptionStartDate, renewalDate, renewalPrice, currency, offerDiscountType, eligibleWinBackOfferIds, appTransactionId, offerPeriod, appAccountToken, unknownFields);
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
                ", environment='" + environment + '\'' +
                ", recentSubscriptionStartDate=" + recentSubscriptionStartDate +
                ", renewalDate=" + renewalDate +
                ", renewalPrice=" + renewalPrice +
                ", currency='" + currency + '\'' +
                ", offerDiscountType='" + offerDiscountType + '\'' +
                ", eligibleWinBackOfferIds=" + eligibleWinBackOfferIds +
                ", appTransactionId='" + appTransactionId + '\'' +
                ", offerPeriod='" + offerPeriod + '\'' +
                ", appAccountToken='" + appAccountToken + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

