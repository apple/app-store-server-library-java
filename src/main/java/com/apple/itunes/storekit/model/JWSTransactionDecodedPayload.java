// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.UUID;

/**
 * A decoded payload containing transaction information.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransactiondecodedpayload">JWSTransactionDecodedPayload</a>
 */
public class JWSTransactionDecodedPayload implements DecodedSignedData {
    private static final String SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID = "originalTransactionId";
    private static final String SERIALIZED_NAME_TRANSACTION_ID = "transactionId";
    private static final String SERIALIZED_NAME_WEB_ORDER_LINE_ITEM_ID = "webOrderLineItemId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
    private static final String SERIALIZED_NAME_SUBSCRIPTION_GROUP_IDENTIFIER = "subscriptionGroupIdentifier";
    private static final String SERIALIZED_NAME_PURCHASE_DATE = "purchaseDate";
    private static final String SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE = "originalPurchaseDate";
    private static final String SERIALIZED_NAME_EXPIRES_DATE = "expiresDate";
    private static final String SERIALIZED_NAME_QUANTITY = "quantity";
    private static final String SERIALIZED_NAME_TYPE = "type";
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    private static final String SERIALIZED_NAME_IN_APP_OWNERSHIP_TYPE = "inAppOwnershipType";
    private static final String SERIALIZED_NAME_SIGNED_DATE = "signedDate";
    private static final String SERIALIZED_NAME_REVOCATION_REASON = "revocationReason";
    private static final String SERIALIZED_NAME_REVOCATION_DATE = "revocationDate";
    private static final String SERIALIZED_NAME_IS_UPGRADED = "isUpgraded";
    private static final String SERIALIZED_NAME_OFFER_TYPE = "offerType";
    private static final String SERIALIZED_NAME_OFFER_IDENTIFIER = "offerIdentifier";
    private static final String SERIALIZED_NAME_ENVIRONMENT = "environment";
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";
    private static final String SERIALIZED_NAME_STOREFRONT_ID = "storefrontId";
    private static final String SERIALIZED_NAME_TRANSACTION_REASON = "transactionReason";
    @SerializedName(SERIALIZED_NAME_ORIGINAL_TRANSACTION_ID)
    private String originalTransactionId;
    @SerializedName(SERIALIZED_NAME_TRANSACTION_ID)
    private String transactionId;
    @SerializedName(SERIALIZED_NAME_WEB_ORDER_LINE_ITEM_ID)
    private String webOrderLineItemId;
    @SerializedName(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @SerializedName(SERIALIZED_NAME_PRODUCT_ID)
    private String productId;
    @SerializedName(SERIALIZED_NAME_SUBSCRIPTION_GROUP_IDENTIFIER)
    private String subscriptionGroupIdentifier;
    @SerializedName(SERIALIZED_NAME_PURCHASE_DATE)
    private Long purchaseDate;
    @SerializedName(SERIALIZED_NAME_ORIGINAL_PURCHASE_DATE)
    private Long originalPurchaseDate;
    @SerializedName(SERIALIZED_NAME_EXPIRES_DATE)
    private Long expiresDate;
    @SerializedName(SERIALIZED_NAME_QUANTITY)
    private Integer quantity;
    @SerializedName(SERIALIZED_NAME_TYPE)
    private Type type;
    @SerializedName(SERIALIZED_NAME_APP_ACCOUNT_TOKEN)
    private UUID appAccountToken;
    @SerializedName(SERIALIZED_NAME_IN_APP_OWNERSHIP_TYPE)
    private InAppOwnershipType inAppOwnershipType;
    @SerializedName(SERIALIZED_NAME_SIGNED_DATE)
    private Long signedDate;
    @SerializedName(SERIALIZED_NAME_REVOCATION_REASON)
    private RevocationReason revocationReason;
    @SerializedName(SERIALIZED_NAME_REVOCATION_DATE)
    private Long revocationDate;
    @SerializedName(SERIALIZED_NAME_IS_UPGRADED)
    private Boolean isUpgraded;
    @SerializedName(SERIALIZED_NAME_OFFER_TYPE)
    private OfferType offerType;
    @SerializedName(SERIALIZED_NAME_OFFER_IDENTIFIER)
    private String offerIdentifier;
    @SerializedName(SERIALIZED_NAME_ENVIRONMENT)
    private Environment environment;
    @SerializedName(SERIALIZED_NAME_STOREFRONT)
    private String storefront;
    @SerializedName(SERIALIZED_NAME_STOREFRONT_ID)
    private String storefrontId;
    @SerializedName(SERIALIZED_NAME_TRANSACTION_REASON)
    private TransactionReason transactionReason;


    public JWSTransactionDecodedPayload() {
    }

    public JWSTransactionDecodedPayload originalTransactionId(String originalTransactionId) {
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

    public JWSTransactionDecodedPayload transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * The unique identifier for a transaction such as an in-app purchase, restored in-app purchase, or subscription renewal.
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

    public JWSTransactionDecodedPayload webOrderLineItemId(String webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
        return this;
    }

    /**
     * The unique identifier of subscription-purchase events across devices, including renewals.
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

    public JWSTransactionDecodedPayload bundleId(String bundleId) {
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

    public JWSTransactionDecodedPayload productId(String productId) {
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

    public JWSTransactionDecodedPayload subscriptionGroupIdentifier(String subscriptionGroupIdentifier) {
        this.subscriptionGroupIdentifier = subscriptionGroupIdentifier;
        return this;
    }

    /**
     * The identifier of the subscription group that the subscription belongs to.
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

    public JWSTransactionDecodedPayload purchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    /**
     * The time that the App Store charged the user’s account for an in-app purchase, a restored in-app purchase, a subscription, or a subscription renewal after a lapse.
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

    public JWSTransactionDecodedPayload originalPurchaseDate(Long originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
        return this;
    }

    /**
     * The purchase date of the transaction associated with the original transaction identifier.
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

    public JWSTransactionDecodedPayload expiresDate(Long expiresDate) {
        this.expiresDate = expiresDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, an auto-renewable subscription expires or renews.
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

    public JWSTransactionDecodedPayload quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * The number of consumable products purchased.
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

    public JWSTransactionDecodedPayload type(Type type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the in-app purchase.
     *
     * @return type
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/type">type</a>
     **/
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public JWSTransactionDecodedPayload appAccountToken(UUID appAccountToken) {
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

    public JWSTransactionDecodedPayload inAppOwnershipType(InAppOwnershipType inAppOwnershipType) {
        this.inAppOwnershipType = inAppOwnershipType;
        return this;
    }

    /**
     * A string that describes whether the transaction was purchased by the user, or is available to them through Family Sharing.
     *
     * @return inAppOwnershipType
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/inappownershiptype">inAppOwnershipType</a>
     **/
    public InAppOwnershipType getInAppOwnershipType() {
        return inAppOwnershipType;
    }

    public void setInAppOwnershipType(InAppOwnershipType inAppOwnershipType) {
        this.inAppOwnershipType = inAppOwnershipType;
    }

    public JWSTransactionDecodedPayload signedDate(Long signedDate) {
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

    public JWSTransactionDecodedPayload revocationReason(RevocationReason revocationReason) {
        this.revocationReason = revocationReason;
        return this;
    }

    /**
     * The reason that the App Store refunded the transaction or revoked it from family sharing.
     *
     * @return revocationReason
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/revocationreason">revocationReason</a>
     **/
    public RevocationReason getRevocationReason() {
        return revocationReason;
    }

    public void setRevocationReason(RevocationReason revocationReason) {
        this.revocationReason = revocationReason;
    }

    public JWSTransactionDecodedPayload revocationDate(Long revocationDate) {
        this.revocationDate = revocationDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that Apple Support refunded a transaction.
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

    public JWSTransactionDecodedPayload isUpgraded(Boolean isUpgraded) {
        this.isUpgraded = isUpgraded;
        return this;
    }

    /**
     * The Boolean value that indicates whether the user upgraded to another subscription.
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

    public JWSTransactionDecodedPayload offerType(OfferType offerType) {
        this.offerType = offerType;
        return this;
    }

    /**
     * A value that represents the promotional offer type.
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

    public JWSTransactionDecodedPayload offerIdentifier(String offerIdentifier) {
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

    public JWSTransactionDecodedPayload environment(Environment environment) {
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

    public JWSTransactionDecodedPayload storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * The three-letter code that represents the country or region associated with the App Store storefront of the purchase.
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
     * An Apple-defined value that uniquely identifies an App Store storefront.
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

    public JWSTransactionDecodedPayload transactionReason(TransactionReason transactionReason) {
        this.transactionReason = transactionReason;
        return this;
    }

    /**
     * The cause of a purchase transaction, which indicates whether it’s a customer’s purchase or a renewal for an auto-renewable subscription that the system initiates.
     *
     * @return transactionReason
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionreason">transactionReason</a>
     **/
    public TransactionReason getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(TransactionReason transactionReason) {
        this.transactionReason = transactionReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JWSTransactionDecodedPayload jwSTransactionDecodedPayload = (JWSTransactionDecodedPayload) o;
        return Objects.equals(this.originalTransactionId, jwSTransactionDecodedPayload.originalTransactionId) &&
                Objects.equals(this.transactionId, jwSTransactionDecodedPayload.transactionId) &&
                Objects.equals(this.webOrderLineItemId, jwSTransactionDecodedPayload.webOrderLineItemId) &&
                Objects.equals(this.bundleId, jwSTransactionDecodedPayload.bundleId) &&
                Objects.equals(this.productId, jwSTransactionDecodedPayload.productId) &&
                Objects.equals(this.subscriptionGroupIdentifier, jwSTransactionDecodedPayload.subscriptionGroupIdentifier) &&
                Objects.equals(this.purchaseDate, jwSTransactionDecodedPayload.purchaseDate) &&
                Objects.equals(this.originalPurchaseDate, jwSTransactionDecodedPayload.originalPurchaseDate) &&
                Objects.equals(this.expiresDate, jwSTransactionDecodedPayload.expiresDate) &&
                Objects.equals(this.quantity, jwSTransactionDecodedPayload.quantity) &&
                Objects.equals(this.type, jwSTransactionDecodedPayload.type) &&
                Objects.equals(this.appAccountToken, jwSTransactionDecodedPayload.appAccountToken) &&
                Objects.equals(this.inAppOwnershipType, jwSTransactionDecodedPayload.inAppOwnershipType) &&
                Objects.equals(this.signedDate, jwSTransactionDecodedPayload.signedDate) &&
                Objects.equals(this.revocationReason, jwSTransactionDecodedPayload.revocationReason) &&
                Objects.equals(this.revocationDate, jwSTransactionDecodedPayload.revocationDate) &&
                Objects.equals(this.isUpgraded, jwSTransactionDecodedPayload.isUpgraded) &&
                Objects.equals(this.offerType, jwSTransactionDecodedPayload.offerType) &&
                Objects.equals(this.offerIdentifier, jwSTransactionDecodedPayload.offerIdentifier) &&
                Objects.equals(this.environment, jwSTransactionDecodedPayload.environment) &&
                Objects.equals(this.storefront, jwSTransactionDecodedPayload.storefront) &&
                Objects.equals(this.storefrontId, jwSTransactionDecodedPayload.storefrontId) &&
                Objects.equals(this.transactionReason, jwSTransactionDecodedPayload.transactionReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalTransactionId, transactionId, webOrderLineItemId, bundleId, productId, subscriptionGroupIdentifier, purchaseDate, originalPurchaseDate, expiresDate, quantity, type, appAccountToken, inAppOwnershipType, signedDate, revocationReason, revocationDate, isUpgraded, offerType, offerIdentifier, environment, storefront, storefrontId, transactionReason);
    }

    @Override
    public String toString() {
        return "JWSTransactionDecodedPayload{" +
                "originalTransactionId='" + originalTransactionId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", webOrderLineItemId='" + webOrderLineItemId + '\'' +
                ", bundleId='" + bundleId + '\'' +
                ", productId='" + productId + '\'' +
                ", subscriptionGroupIdentifier='" + subscriptionGroupIdentifier + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", originalPurchaseDate=" + originalPurchaseDate +
                ", expiresDate=" + expiresDate +
                ", quantity=" + quantity +
                ", type=" + type +
                ", appAccountToken=" + appAccountToken +
                ", inAppOwnershipType=" + inAppOwnershipType +
                ", signedDate=" + signedDate +
                ", revocationReason=" + revocationReason +
                ", revocationDate=" + revocationDate +
                ", isUpgraded=" + isUpgraded +
                ", offerType=" + offerType +
                ", offerIdentifier='" + offerIdentifier + '\'' +
                ", environment=" + environment +
                ", storefront='" + storefront + '\'' +
                ", storefrontId='" + storefrontId + '\'' +
                ", transactionReason=" + transactionReason +
                '}';
    }
}

