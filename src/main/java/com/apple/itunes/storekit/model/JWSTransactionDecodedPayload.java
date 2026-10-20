// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * A decoded payload that contains transaction information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransactiondecodedpayload">JWSTransactionDecodedPayload</a>
 **/
public class JWSTransactionDecodedPayload implements DecodedSignedData {
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    private static final String SERIALIZED_NAME_APP_TRANSACTION_ID = "appTransactionId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_CURRENCY = "currency";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_EXPIRES_DATE = "expiresDate";
    private static final String SERIALIZED_NAME_IN_APP_OWNERSHIP_TYPE = "inAppOwnershipType";
    private static final String SERIALIZED_NAME_IS_UPGRADED = "isUpgraded";
    private static final String SERIALIZED_NAME_OFFER_DISCOUNT_TYPE = "offerDiscountType";
    private static final String SERIALIZED_NAME_OFFER_IDENTIFIER = "offerIdentifier";
    private static final String SERIALIZED_NAME_OFFER_PERIOD = "offerPeriod";
    private static final String SERIALIZED_NAME_OFFER_TYPE = "offerType";
    private static final String SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE = "originalPurchaseDate";
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_PRICE = "price";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_PURCHASE_DATE = "purchaseDate";
    private static final String SERIALIZED_NAME_QUANTITY = "quantity";
    private static final String SERIALIZED_NAME_REVOCATION_DATE = "revocationDate";
    private static final String SERIALIZED_NAME_REVOCATION_PERCENTAGE = "revocationPercentage";
    private static final String SERIALIZED_NAME_REVOCATION_REASON = "revocationReason";
    private static final String SERIALIZED_NAME_REVOCATION_TYPE = "revocationType";
    private static final String SERIALIZED_NAME_SIGNED_DATE = "signedDate";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_STOREFRONT_ID = "storefrontId";
    private static final String SERIALIZED_NAME_SUBSCRIPTION_GROUP_IDENTIFIER = "subscriptionGroupIdentifier";
    private static final String SERIALIZED_NAME_TRANSACTION_ID = "transactionId";
    private static final String SERIALIZED_NAME_TRANSACTION_REASON = "transactionReason";
    private static final String SERIALIZED_NAME_TYPE = "type";
    private static final String SERIALIZED_NAME_WEB_ORDER_LINE_ITEM_ID = "webOrderLineItemId";
    private static final String SERIALIZED_NAME_ADVANCED_COMMERCE_INFO = "advancedCommerceInfo";
    private static final String SERIALIZED_NAME_BILLING_PLAN_TYPE = "billingPlanType";
    private static final String SERIALIZED_NAME_COMMITMENT_INFO = "commitmentInfo";
    private static final String SERIALIZED_NAME_PREVIOUS_ORIGINAL_TRANSACTION_ID = "previousOriginalTransactionId";

    @JsonProperty(SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    private UUID appAccountToken;
    @JsonProperty(SERIALIZED_NAME_APP_TRANSACTION_ID)
    private String appTransactionId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_CURRENCY)
    private String currency;
    @JsonProperty(SERIALIZED_NAME_ENVIRONMENT)
    private String environment;
    @JsonProperty(SERIALIZED_NAME_EXPIRES_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long expiresDate;
    @JsonProperty(SERIALIZED_NAME_IN_APP_OWNERSHIP_TYPE)
    private String inAppOwnershipType;
    @JsonProperty(SERIALIZED_NAME_IS_UPGRADED)
    private Boolean isUpgraded;
    @JsonProperty(SERIALIZED_NAME_OFFER_DISCOUNT_TYPE)
    private String offerDiscountType;
    @JsonProperty(SERIALIZED_NAME_OFFER_IDENTIFIER)
    private String offerIdentifier;
    @JsonProperty(SERIALIZED_NAME_OFFER_PERIOD)
    private String offerPeriod;
    @JsonProperty(SERIALIZED_NAME_OFFER_TYPE)
    private Integer offerType;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long originalPurchaseDate;
    @JsonProperty(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @JsonProperty(SERIALIZED_NAME_PRICE)
    private Long price;
    @JsonProperty(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;
    @JsonProperty(SERIALIZED_NAME_PURCHASE_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long purchaseDate;
    @JsonProperty(SERIALIZED_NAME_QUANTITY)
    private Integer quantity;
    @JsonProperty(SERIALIZED_NAME_REVOCATION_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long revocationDate;
    @JsonProperty(SERIALIZED_NAME_REVOCATION_PERCENTAGE)
    private Integer revocationPercentage;
    @JsonProperty(SERIALIZED_NAME_REVOCATION_REASON)
    private Integer revocationReason;
    @JsonProperty(SERIALIZED_NAME_REVOCATION_TYPE)
    private String revocationType;
    @JsonProperty(SERIALIZED_NAME_SIGNED_DATE)
    @JsonDeserialize(using = XcodeCompatibleTimestampDeserializer.class)
    private Long signedDate;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @JsonProperty(SERIALIZED_NAME_STOREFRONT_ID)
    private String storefrontId;
    @JsonProperty(SERIALIZED_NAME_SUBSCRIPTION_GROUP_IDENTIFIER)
    private String subscriptionGroupIdentifier;
    @JsonProperty(SERIALIZED_NAME_TRANSACTION_ID)
    private String transactionId;
    @JsonProperty(SERIALIZED_NAME_TRANSACTION_REASON)
    private String transactionReason;
    @JsonProperty(SERIALIZED_NAME_TYPE)
    private String type;
    @JsonProperty(SERIALIZED_NAME_WEB_ORDER_LINE_ITEM_ID)
    private String webOrderLineItemId;
    @JsonProperty(SERIALIZED_NAME_ADVANCED_COMMERCE_INFO)
    private AdvancedCommerceTransactionInfo advancedCommerceInfo;
    @JsonProperty(SERIALIZED_NAME_BILLING_PLAN_TYPE)
    private String billingPlanType;
    @JsonProperty(SERIALIZED_NAME_COMMITMENT_INFO)
    private TransactionCommitmentInfo commitmentInfo;
    @JsonProperty(SERIALIZED_NAME_PREVIOUS_ORIGINAL_TRANSACTION_ID)
    private String previousOriginalTransactionId;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    private static final int MINIMUM_REVOCATION_PERCENTAGE = 0;
    private static final int MAXIMUM_REVOCATION_PERCENTAGE = 100000;

    public JWSTransactionDecodedPayload() {
    }

    public JWSTransactionDecodedPayload appAccountToken(UUID appAccountToken) {
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * A UUID you create at the time of purchase that associates the transaction with a customer on your own service.
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

    public JWSTransactionDecodedPayload appTransactionId(String appTransactionId) {
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

    public JWSTransactionDecodedPayload bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of the app.
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

    public JWSTransactionDecodedPayload currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * The three-letter ISO 4217 currency code associated with the price parameter.
     *
     * @return currency
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/currency">currency</a>
     **/
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public JWSTransactionDecodedPayload environment(Environment environment) {
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
        return Environment.fromValue(environment);
    }

    /**
     * @see #getEnvironment()
     **/
    public String getRawEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment != null ? environment.getValue() : null;
    }

    public void setRawEnvironment(String rawEnvironment) {
        this.environment = rawEnvironment;
    }

    public JWSTransactionDecodedPayload expiresDate(Long expiresDate) {
        this.expiresDate = expiresDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the subscription expires or renews.
     *
     * @return expiresDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/expiresdate">expiresDate</a>
     **/
    public Long getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Long expiresDate) {
        this.expiresDate = expiresDate;
    }

    public JWSTransactionDecodedPayload inAppOwnershipType(InAppOwnershipType inAppOwnershipType) {
        this.inAppOwnershipType = inAppOwnershipType != null ? inAppOwnershipType.getValue() : null;
        return this;
    }

    /**
     * A string that describes whether the transaction was purchased by the customer, or is available to them through Family Sharing, an organization, or a group.
     *
     * @return inAppOwnershipType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/inappownershiptype">inAppOwnershipType</a>
     **/
    public InAppOwnershipType getInAppOwnershipType() {
        return InAppOwnershipType.fromValue(inAppOwnershipType);
    }

    /**
     * @see #getInAppOwnershipType()
     **/
    public String getRawInAppOwnershipType() {
        return inAppOwnershipType;
    }

    public void setInAppOwnershipType(InAppOwnershipType inAppOwnershipType) {
        this.inAppOwnershipType = inAppOwnershipType != null ? inAppOwnershipType.getValue() : null;
    }

    public void setRawInAppOwnershipType(String rawInAppOwnershipType) {
        this.inAppOwnershipType = rawInAppOwnershipType;
    }

    public JWSTransactionDecodedPayload isUpgraded(Boolean isUpgraded) {
        this.isUpgraded = isUpgraded;
        return this;
    }

    /**
     * A Boolean value that indicates whether the customer upgraded to another subscription.
     *
     * @return isUpgraded
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/isupgraded">isUpgraded</a>
     **/
    public Boolean getIsUpgraded() {
        return isUpgraded;
    }

    public void setIsUpgraded(Boolean isUpgraded) {
        this.isUpgraded = isUpgraded;
    }

    public JWSTransactionDecodedPayload offerDiscountType(OfferDiscountType offerDiscountType) {
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
        return OfferDiscountType.fromValue(offerDiscountType);
    }

    /**
     * @see #getOfferDiscountType()
     **/
    public String getRawOfferDiscountType() {
        return offerDiscountType;
    }

    public void setOfferDiscountType(OfferDiscountType offerDiscountType) {
        this.offerDiscountType = offerDiscountType != null ? offerDiscountType.getValue() : null;
    }

    public void setRawOfferDiscountType(String rawOfferDiscountType) {
        this.offerDiscountType = rawOfferDiscountType;
    }

    public JWSTransactionDecodedPayload offerIdentifier(String offerIdentifier) {
        this.offerIdentifier = offerIdentifier;
        return this;
    }

    /**
     * The identifier that contains the offer code or the promotional offer identifier.
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

    public JWSTransactionDecodedPayload offerPeriod(String offerPeriod) {
        this.offerPeriod = offerPeriod;
        return this;
    }

    /**
     * The duration of the offer applied to the transaction.
     *
     * @return offerPeriod
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offerperiod">offerPeriod</a>
     **/
    public String getOfferPeriod() {
        return offerPeriod;
    }

    public void setOfferPeriod(String offerPeriod) {
        this.offerPeriod = offerPeriod;
    }

    public JWSTransactionDecodedPayload offerType(OfferType offerType) {
        this.offerType = offerType != null ? offerType.getValue() : null;
        return this;
    }

    /**
     * A value that represents the promotional offer type.
     *
     * @return offerType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/offertype">offerType</a>
     **/
    public OfferType getOfferType() {
        return OfferType.fromValue(offerType);
    }

    /**
     * @see #getOfferType()
     **/
    public Integer getRawOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType != null ? offerType.getValue() : null;
    }

    public void setRawOfferType(Integer rawOfferType) {
        this.offerType = rawOfferType;
    }

    public JWSTransactionDecodedPayload originalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that represents the purchase date of the original transaction identifier.
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

    public JWSTransactionDecodedPayload originalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
        return this;
    }

    /**
     * The transaction identifier of the original purchase.
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

    public JWSTransactionDecodedPayload price(Long price) {
        this.price = price;
        return this;
    }

    /**
     * An integer value that represents the price multiplied by 1000 of the in-app purchase or subscription offer you configured in App Store Connect and that the system records at the time of the purchase.
     *
     * @return price
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/price">price</a>
     **/
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public JWSTransactionDecodedPayload productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * The unique identifier of the product.
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

    public JWSTransactionDecodedPayload purchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store charged the customer’s account for a purchase, restored product, subscription, or subscription renewal after a lapse.
     *
     * @return purchaseDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/purchasedate">purchaseDate</a>
     **/
    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public JWSTransactionDecodedPayload quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * The number of products or seats the customer purchased.
     *
     * @return quantity
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/quantity">quantity</a>
     **/
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public JWSTransactionDecodedPayload revocationDate(Long revocationDate) {
        this.revocationDate = revocationDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store refunded the transaction or revoked it from Family Sharing.
     *
     * @return revocationDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationdate">revocationDate</a>
     **/
    public Long getRevocationDate() {
        return revocationDate;
    }

    public void setRevocationDate(Long revocationDate) {
        this.revocationDate = revocationDate;
    }

    public JWSTransactionDecodedPayload revocationPercentage(Integer revocationPercentage) {
        this.revocationPercentage = validateRevocationPercentage(revocationPercentage);
        return this;
    }

    /**
     * The percentage, in milliunits, of the transaction that the App Store has refunded or revoked.
     *
     * @return revocationPercentage
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationpercentage">revocationPercentage</a>
     **/
    public Integer getRevocationPercentage() {
        return revocationPercentage;
    }

    @JsonSetter(SERIALIZED_NAME_REVOCATION_PERCENTAGE)
    public void setRevocationPercentage(Integer revocationPercentage) {
        this.revocationPercentage = validateRevocationPercentage(revocationPercentage);
    }

    private Integer validateRevocationPercentage(Integer revocationPercentage) {
        if (revocationPercentage != null && (revocationPercentage < MINIMUM_REVOCATION_PERCENTAGE || revocationPercentage > MAXIMUM_REVOCATION_PERCENTAGE)) {
            throw new IllegalArgumentException("revocationPercentage must be between " + MINIMUM_REVOCATION_PERCENTAGE + " and " + MAXIMUM_REVOCATION_PERCENTAGE);
        }
        return revocationPercentage;
    }

    public JWSTransactionDecodedPayload revocationReason(RevocationReason revocationReason) {
        this.revocationReason = revocationReason != null ? revocationReason.getValue() : null;
        return this;
    }

    /**
     * The reason that the App Store refunded the transaction or revoked it from Family Sharing.
     *
     * @return revocationReason
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationreason">revocationReason</a>
     **/
    public RevocationReason getRevocationReason() {
        return RevocationReason.fromValue(revocationReason);
    }

    /**
     * @see #getRevocationReason()
     **/
    public Integer getRawRevocationReason() {
        return revocationReason;
    }

    public void setRevocationReason(RevocationReason revocationReason) {
        this.revocationReason = revocationReason != null ? revocationReason.getValue() : null;
    }

    public void setRawRevocationReason(Integer rawRevocationReason) {
        this.revocationReason = rawRevocationReason;
    }

    public JWSTransactionDecodedPayload revocationType(RevocationType revocationType) {
        this.revocationType = revocationType != null ? revocationType.getValue() : null;
        return this;
    }

    /**
     * The type of the refund or revocation that applies to the transaction.
     *
     * @return revocationType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationtype">revocationType</a>
     **/
    public RevocationType getRevocationType() {
        return RevocationType.fromValue(revocationType);
    }

    /**
     * @see #getRevocationType()
     **/
    public String getRawRevocationType() {
        return revocationType;
    }

    public void setRevocationType(RevocationType revocationType) {
        this.revocationType = revocationType != null ? revocationType.getValue() : null;
    }

    public void setRawRevocationType(String rawRevocationType) {
        this.revocationType = rawRevocationType;
    }

    public JWSTransactionDecodedPayload signedDate(Long signedDate) {
        this.signedDate = signedDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store signed the JSON Web Signature (JWS) data.
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

    public JWSTransactionDecodedPayload storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * The three-letter code that represents the country or region associated with the App Store storefront for the purchase.
     *
     * @return storefront
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/storefront">storefront</a>
     **/
    public String getStorefront() {
        return storefront;
    }

    public void setStorefront(String storefront) {
        this.storefront = storefront;
    }

    public JWSTransactionDecodedPayload storefrontId(String storefrontId) {
        this.storefrontId = storefrontId;
        return this;
    }

    /**
     * An Apple-defined value that uniquely identifies the App Store storefront associated with the purchase.
     *
     * @return storefrontId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/storefrontid">storefrontId</a>
     **/
    public String getStorefrontId() {
        return storefrontId;
    }

    public void setStorefrontId(String storefrontId) {
        this.storefrontId = storefrontId;
    }

    public JWSTransactionDecodedPayload subscriptionGroupIdentifier(String subscriptionGroupIdentifier) {
        this.subscriptionGroupIdentifier = subscriptionGroupIdentifier;
        return this;
    }

    /**
     * The identifier of the subscription group to which the subscription belongs.
     *
     * @return subscriptionGroupIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptiongroupidentifier">subscriptionGroupIdentifier</a>
     **/
    public String getSubscriptionGroupIdentifier() {
        return subscriptionGroupIdentifier;
    }

    public void setSubscriptionGroupIdentifier(String subscriptionGroupIdentifier) {
        this.subscriptionGroupIdentifier = subscriptionGroupIdentifier;
    }

    public JWSTransactionDecodedPayload transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * The unique identifier of the transaction.
     *
     * @return transactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionid">transactionId</a>
     **/
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public JWSTransactionDecodedPayload transactionReason(TransactionReason transactionReason) {
        this.transactionReason = transactionReason != null ? transactionReason.getValue() : null;
        return this;
    }

    /**
     * The reason for the purchase transaction, which indicates whether it’s a customer’s purchase or a renewal for an auto-renewable subscription that the system initiates.
     *
     * @return transactionReason
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionreason">transactionReason</a>
     **/
    public TransactionReason getTransactionReason() {
        return TransactionReason.fromValue(transactionReason);
    }

    /**
     * @see #getTransactionReason()
     **/
    public String getRawTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(TransactionReason transactionReason) {
        this.transactionReason = transactionReason != null ? transactionReason.getValue() : null;
    }

    public void setRawTransactionReason(String rawTransactionReason) {
        this.transactionReason = rawTransactionReason;
    }

    public JWSTransactionDecodedPayload type(Type type) {
        this.type = type != null ? type.getValue() : null;
        return this;
    }

    /**
     * The type of the in-app purchase.
     *
     * @return type
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/type">type</a>
     **/
    public Type getType() {
        return Type.fromValue(type);
    }

    /**
     * @see #getType()
     **/
    public String getRawType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type != null ? type.getValue() : null;
    }

    public void setRawType(String rawType) {
        this.type = rawType;
    }

    public JWSTransactionDecodedPayload webOrderLineItemId(String webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
        return this;
    }

    /**
     * The unique identifier of subscription purchase events across devices, including subscription renewals.
     *
     * @return webOrderLineItemId
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/weborderlineitemid">webOrderLineItemId</a>
     **/
    public String getWebOrderLineItemId() {
        return webOrderLineItemId;
    }

    public void setWebOrderLineItemId(String webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
    }

    public JWSTransactionDecodedPayload advancedCommerceInfo(AdvancedCommerceTransactionInfo advancedCommerceInfo) {
        this.advancedCommerceInfo = advancedCommerceInfo;
        return this;
    }

    /**
     * Transaction information that is present only for Advanced Commerce SKUs.
     *
     * @return advancedCommerceInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetransactioninfo">advancedCommerceTransactionInfo</a>
     **/
    public AdvancedCommerceTransactionInfo getAdvancedCommerceInfo() {
        return advancedCommerceInfo;
    }

    public void setAdvancedCommerceInfo(AdvancedCommerceTransactionInfo advancedCommerceInfo) {
        this.advancedCommerceInfo = advancedCommerceInfo;
    }

    public JWSTransactionDecodedPayload billingPlanType(BillingPlanType billingPlanType) {
        this.billingPlanType = billingPlanType != null ? billingPlanType.getValue() : null;
        return this;
    }

    /**
     * @return billingPlanType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/billingplantype">billingPlanType</a>
     **/
    public BillingPlanType getBillingPlanType() {
        return BillingPlanType.fromValue(billingPlanType);
    }

    /**
     * @see #getBillingPlanType()
     **/
    public String getRawBillingPlanType() {
        return billingPlanType;
    }

    public void setBillingPlanType(BillingPlanType billingPlanType) {
        this.billingPlanType = billingPlanType != null ? billingPlanType.getValue() : null;
    }

    public void setRawBillingPlanType(String rawBillingPlanType) {
        this.billingPlanType = rawBillingPlanType;
    }

    public JWSTransactionDecodedPayload commitmentInfo(TransactionCommitmentInfo commitmentInfo) {
        this.commitmentInfo = commitmentInfo;
        return this;
    }

    /**
     * @return commitmentInfo
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactioncommitmentinfo">TransactionCommitmentInfo</a>
     **/
    public TransactionCommitmentInfo getCommitmentInfo() {
        return commitmentInfo;
    }

    public void setCommitmentInfo(TransactionCommitmentInfo commitmentInfo) {
        this.commitmentInfo = commitmentInfo;
    }

    public JWSTransactionDecodedPayload previousOriginalTransactionId(String previousOriginalTransactionId) {
        this.previousOriginalTransactionId = previousOriginalTransactionId;
        return this;
    }

    /**
     * The subscription’s original transaction identifier, before you migrated the subscription.
     *
     * @return previousOriginalTransactionId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/previousoriginaltransactionid">previousOriginalTransactionId</a>
     **/
    public String getPreviousOriginalTransactionId() {
        return previousOriginalTransactionId;
    }

    public void setPreviousOriginalTransactionId(String previousOriginalTransactionId) {
        this.previousOriginalTransactionId = previousOriginalTransactionId;
    }

    public JWSTransactionDecodedPayload unknownFields(Map<String, Object> unknownFields) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JWSTransactionDecodedPayload jWSTransactionDecodedPayload = (JWSTransactionDecodedPayload) o;
        return Objects.equals(this.appAccountToken, jWSTransactionDecodedPayload.appAccountToken) &&
                Objects.equals(this.appTransactionId, jWSTransactionDecodedPayload.appTransactionId) &&
                Objects.equals(this.bundleId, jWSTransactionDecodedPayload.bundleId) &&
                Objects.equals(this.currency, jWSTransactionDecodedPayload.currency) &&
                Objects.equals(this.environment, jWSTransactionDecodedPayload.environment) &&
                Objects.equals(this.expiresDate, jWSTransactionDecodedPayload.expiresDate) &&
                Objects.equals(this.inAppOwnershipType, jWSTransactionDecodedPayload.inAppOwnershipType) &&
                Objects.equals(this.isUpgraded, jWSTransactionDecodedPayload.isUpgraded) &&
                Objects.equals(this.offerDiscountType, jWSTransactionDecodedPayload.offerDiscountType) &&
                Objects.equals(this.offerIdentifier, jWSTransactionDecodedPayload.offerIdentifier) &&
                Objects.equals(this.offerPeriod, jWSTransactionDecodedPayload.offerPeriod) &&
                Objects.equals(this.offerType, jWSTransactionDecodedPayload.offerType) &&
                Objects.equals(this.originalPurchaseDate, jWSTransactionDecodedPayload.originalPurchaseDate) &&
                Objects.equals(this.originalTransactionId, jWSTransactionDecodedPayload.originalTransactionId) &&
                Objects.equals(this.price, jWSTransactionDecodedPayload.price) &&
                Objects.equals(this.productId, jWSTransactionDecodedPayload.productId) &&
                Objects.equals(this.purchaseDate, jWSTransactionDecodedPayload.purchaseDate) &&
                Objects.equals(this.quantity, jWSTransactionDecodedPayload.quantity) &&
                Objects.equals(this.revocationDate, jWSTransactionDecodedPayload.revocationDate) &&
                Objects.equals(this.revocationPercentage, jWSTransactionDecodedPayload.revocationPercentage) &&
                Objects.equals(this.revocationReason, jWSTransactionDecodedPayload.revocationReason) &&
                Objects.equals(this.revocationType, jWSTransactionDecodedPayload.revocationType) &&
                Objects.equals(this.signedDate, jWSTransactionDecodedPayload.signedDate) &&
                Objects.equals(this.storefront, jWSTransactionDecodedPayload.storefront) &&
                Objects.equals(this.storefrontId, jWSTransactionDecodedPayload.storefrontId) &&
                Objects.equals(this.subscriptionGroupIdentifier, jWSTransactionDecodedPayload.subscriptionGroupIdentifier) &&
                Objects.equals(this.transactionId, jWSTransactionDecodedPayload.transactionId) &&
                Objects.equals(this.transactionReason, jWSTransactionDecodedPayload.transactionReason) &&
                Objects.equals(this.type, jWSTransactionDecodedPayload.type) &&
                Objects.equals(this.webOrderLineItemId, jWSTransactionDecodedPayload.webOrderLineItemId) &&
                Objects.equals(this.advancedCommerceInfo, jWSTransactionDecodedPayload.advancedCommerceInfo) &&
                Objects.equals(this.billingPlanType, jWSTransactionDecodedPayload.billingPlanType) &&
                Objects.equals(this.commitmentInfo, jWSTransactionDecodedPayload.commitmentInfo) &&
                Objects.equals(this.previousOriginalTransactionId, jWSTransactionDecodedPayload.previousOriginalTransactionId) &&
                Objects.equals(this.unknownFields, jWSTransactionDecodedPayload.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appAccountToken, appTransactionId, bundleId, currency, environment, expiresDate, inAppOwnershipType, isUpgraded, offerDiscountType, offerIdentifier, offerPeriod, offerType, originalPurchaseDate, originalTransactionId, price, productId, purchaseDate, quantity, revocationDate, revocationPercentage, revocationReason, revocationType, signedDate, storefront, storefrontId, subscriptionGroupIdentifier, transactionId, transactionReason, type, webOrderLineItemId, advancedCommerceInfo, billingPlanType, commitmentInfo, previousOriginalTransactionId, unknownFields);
    }

    @Override
    public String toString() {
        return "JWSTransactionDecodedPayload{" +
                "appAccountToken=" + appAccountToken +
                ", appTransactionId='" + appTransactionId + '\'' +
                ", bundleId='" + bundleId + '\'' +
                ", currency='" + currency + '\'' +
                ", environment='" + environment + '\'' +
                ", expiresDate=" + expiresDate +
                ", inAppOwnershipType='" + inAppOwnershipType + '\'' +
                ", isUpgraded=" + isUpgraded +
                ", offerDiscountType='" + offerDiscountType + '\'' +
                ", offerIdentifier='" + offerIdentifier + '\'' +
                ", offerPeriod='" + offerPeriod + '\'' +
                ", offerType=" + offerType +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", originalTransactionId='" + originalTransactionId + '\'' +
                ", price=" + price +
                ", productId='" + productId + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", quantity=" + quantity +
                ", revocationDate=" + revocationDate +
                ", revocationPercentage=" + revocationPercentage +
                ", revocationReason=" + revocationReason +
                ", revocationType='" + revocationType + '\'' +
                ", signedDate=" + signedDate +
                ", storefront='" + storefront + '\'' +
                ", storefrontId='" + storefrontId + '\'' +
                ", subscriptionGroupIdentifier='" + subscriptionGroupIdentifier + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", transactionReason='" + transactionReason + '\'' +
                ", type='" + type + '\'' +
                ", webOrderLineItemId='" + webOrderLineItemId + '\'' +
                ", advancedCommerceInfo=" + advancedCommerceInfo +
                ", billingPlanType='" + billingPlanType + '\'' +
                ", commitmentInfo=" + commitmentInfo +
                ", previousOriginalTransactionId='" + previousOriginalTransactionId + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
