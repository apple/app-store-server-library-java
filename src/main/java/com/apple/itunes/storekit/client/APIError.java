// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;


import java.util.Arrays;

/**
 * An error returned by the App Store Server API indicating an issue with processing a request.
 * See the specific documentation for each endpoint to learn more about what codes are possible from each endpoint.
 */
public enum APIError {
    /**
     * An error that indicates an invalid request.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalbadrequesterror">GeneralBadRequestError</a>
     */
    GENERAL_BAD_REQUEST(4000000L),

    /**
     * An error that indicates an invalid app identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappidentifiererror">InvalidAppIdentifierError</a>
     */
    INVALID_APP_IDENTIFIER(4000002L),

    /**
     * An error that indicates an invalid request revision.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrequestrevisionerror">InvalidRequestRevisionError</a>
     */
    INVALID_REQUEST_REVISION(4000005L),

    /**
     * An error that indicates an invalid transaction identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactioniderror">InvalidTransactionIdError</a>
     */
    INVALID_TRANSACTION_ID(4000006L),

    /**
     * An error that indicates an invalid original transaction identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidoriginaltransactioniderror">InvalidOriginalTransactionIdError</a>
     */
    INVALID_ORIGINAL_TRANSACTION_ID(4000008L),

    /**
     * An error that indicates an invalid extend-by-days value.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidextendbydayserror">InvalidExtendByDaysError</a>
     */
    INVALID_EXTEND_BY_DAYS(4000009L),

    /**
     * An error that indicates an invalid reason code.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidextendreasoncodeerror">InvalidExtendReasonCodeError</a>
     */
    INVALID_EXTEND_REASON_CODE(4000010L),

    /**
     * An error that indicates an invalid request identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrequestidentifiererror">InvalidRequestIdentifierError</a>
     */
    INVALID_REQUEST_IDENTIFIER(4000011L),

    /**
     * An error that indicates that the start date is earlier than the earliest allowed date.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdatetoofarinpasterror">StartDateTooFarInPastError</a>
     */
    START_DATE_TOO_FAR_IN_PAST(4000012L),

    /**
     * An error that indicates that the end date precedes the start date, or the two dates are equal.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdateafterenddateerror">StartDateAfterEndDateError</a>
     */
    START_DATE_AFTER_END_DATE(4000013L),

    /**
     * An error that indicates the pagination token is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidpaginationtokenerror">InvalidPaginationTokenError</a>
     */
    INVALID_PAGINATION_TOKEN(4000014L),

    /**
     * An error that indicates the start date is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstartdateerror">InvalidStartDateError</a>
     */
    INVALID_START_DATE(4000015L),

    /**
     * An error that indicates the end date is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidenddateerror">InvalidEndDateError</a>
     */
    INVALID_END_DATE(4000016L),

    /**
     * An error that indicates the pagination token expired.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/paginationtokenexpirederror">PaginationTokenExpiredError</a>
     */
    PAGINATION_TOKEN_EXPIRED(4000017L),

    /**
     * An error that indicates the notification type or subtype is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidnotificationtypeerror">InvalidNotificationTypeError</a>
     */
    INVALID_NOTIFICATION_TYPE(4000018L),

    /**
     * An error that indicates the request is invalid because it has too many constraints applied.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/multiplefilterssuppliederror">MultipleFiltersSuppliedError</a>
     */
    MULTIPLE_FILTERS_SUPPLIED(4000019L),

    /**
     * An error that indicates the test notification token is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtestnotificationtokenerror">InvalidTestNotificationTokenError</a>
     */
    INVALID_TEST_NOTIFICATION_TOKEN(4000020L),

    /**
     * An error that indicates an invalid sort parameter.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsorterror">InvalidSortError</a>
     */
    INVALID_SORT(4000021L),

    /**
     * An error that indicates an invalid product type parameter.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidproducttypeerror">InvalidProductTypeError</a>
     */
    INVALID_PRODUCT_TYPE(4000022L),

    /**
     * An error that indicates the product ID parameter is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidproductiderror">InvalidProductIdError</a>
     */
    INVALID_PRODUCT_ID(4000023L),

    /**
     * An error that indicates an invalid subscription group identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsubscriptiongroupidentifiererror">InvalidSubscriptionGroupIdentifierError</a>
     */
    INVALID_SUBSCRIPTION_GROUP_IDENTIFIER(4000024L),

    /**
     * An error that indicates the query parameter exclude-revoked is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidexcluderevokederror">InvalidExcludeRevokedError</a>
     */
    @Deprecated
    INVALID_EXCLUDE_REVOKED(4000025L),

    /**
     * An error that indicates an invalid in-app ownership type parameter.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidinappownershiptypeerror">InvalidInAppOwnershipTypeError</a>
     */
    INVALID_IN_APP_OWNERSHIP_TYPE(4000026L),

    /**
     * An error that indicates a required storefront country code is empty.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidemptystorefrontcountrycodelisterror">InvalidEmptyStorefrontCountryCodeListError</a>
     */
    INVALID_EMPTY_STOREFRONT_COUNTRY_CODE_LIST(4000027L),

    /**
     * An error that indicates a storefront code is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstorefrontcountrycodeerror">InvalidStorefrontCountryCodeError</a>
     */
    INVALID_STOREFRONT_COUNTRY_CODE(4000028L),

    /**
     * An error that indicates the revoked parameter contains an invalid value.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrevokederror">InvalidRevokedError</a>
     */
    INVALID_REVOKED(4000030L),

    /**
     * An error that indicates the status parameter is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstatuserror">InvalidStatusError</a>
     */
    INVALID_STATUS(4000031L),

    /**
     * An error that indicates the value of the account tenure field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidaccounttenureerror">InvalidAccountTenureError</a>
     */
    INVALID_ACCOUNT_TENURE(4000032L),

    /**
     * An error that indicates the value of the app account token field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappaccounttokenerror">InvalidAppAccountTokenError</a>
     */
    INVALID_APP_ACCOUNT_TOKEN(4000033L),

    /**
     * An error that indicates the value of the consumption status field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidconsumptionstatuserror">InvalidConsumptionStatusError</a>
     */
    INVALID_CONSUMPTION_STATUS(4000034L),

    /**
     * An error that indicates the customer consented field is invalid or doesn’t indicate that the customer consented.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidcustomerconsentederror">InvalidCustomerConsentedError</a>
     */
    INVALID_CUSTOMER_CONSENTED(4000035L),

    /**
     * An error that indicates the value in the delivery status field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invaliddeliverystatuserror">InvalidDeliveryStatusError</a>
     */
    INVALID_DELIVERY_STATUS(4000036L),

    /**
     * An error that indicates the value in the lifetime dollars purchased field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlifetimedollarspurchasederror">InvalidLifetimeDollarsPurchasedError</a>
     */
    INVALID_LIFETIME_DOLLARS_PURCHASED(4000037L),

    /**
     * An error that indicates the value in the lifetime dollars refunded field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlifetimedollarsrefundederror">InvalidLifetimeDollarsRefundedError</a>
     */
    INVALID_LIFETIME_DOLLARS_REFUNDED(4000038L),

    /**
     * An error that indicates the value in the platform field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidplatformerror">InvalidPlatformError</a>
     */
    INVALID_PLATFORM(4000039L),

    /**
     * An error that indicates the value in the playtime field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidplaytimeerror">InvalidPlayTimeError</a>
     */
    INVALID_PLAY_TIME(4000040L),

    /**
     * An error that indicates the value in the sample content provided field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsamplecontentprovidederror">InvalidSampleContentProvidedError</a>
     */
    INVALID_SAMPLE_CONTENT_PROVIDED(4000041L),

    /**
     * An error that indicates the value in the user status field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invaliduserstatuserror">InvalidUserStatusError</a>
     */
    INVALID_USER_STATUS(4000042L),

    /**
     * An error that indicates the transaction identifier doesn’t represent a consumable in-app purchase.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactionnotconsumableerror">InvalidTransactionNotConsumableError</a>
     */
    @Deprecated
    INVALID_TRANSACTION_NOT_CONSUMABLE(4000043L),

    /**
     * An error that indicates the transaction identifier represents an unsupported in-app purchase type.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactiontypenotsupportederror">InvalidTransactionTypeNotSupportedError</a>
     */
    INVALID_TRANSACTION_TYPE_NOT_SUPPORTED(4000047L),

    /**
     * An error that indicates the subscription doesn't qualify for a renewal-date extension due to its subscription state.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptionextensionineligibleerror">SubscriptionExtensionIneligibleError</a>
     */
    SUBSCRIPTION_EXTENSION_INELIGIBLE(4030004L),

    /**
     * An error that indicates the subscription doesn’t qualify for a renewal-date extension because it has already received the maximum extensions.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptionmaxextensionerror">SubscriptionMaxExtensionError</a>
     */
    SUBSCRIPTION_MAX_EXTENSION(4030005L),

    /**
     * An error that indicates a subscription isn't directly eligible for a renewal date extension because the user obtained it through Family Sharing.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/familysharedsubscriptionextensionineligibleerror">FamilySharedSubscriptionExtensionIneligibleError</a>
     */
    FAMILY_SHARED_SUBSCRIPTION_EXTENSION_INELIGIBLE(4030007L),

    /**
     * An error that indicates the App Store account wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accountnotfounderror">AccountNotFoundError</a>
     */
    ACCOUNT_NOT_FOUND(4040001L),

    /**
     * An error response that indicates the App Store account wasn’t found, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accountnotfoundretryableerror">AccountNotFoundRetryableError</a>
     */
    ACCOUNT_NOT_FOUND_RETRYABLE(4040002L),

    /**
     * An error that indicates the app wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appnotfounderror">AppNotFoundError</a>
     */
    APP_NOT_FOUND(4040003L),

    /**
     * An error response that indicates the app wasn’t found, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appnotfoundretryableerror">AppNotFoundRetryableError</a>
     */
    APP_NOT_FOUND_RETRYABLE(4040004L),

    /**
     * An error that indicates an original transaction identifier wasn't found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originaltransactionidnotfounderror">OriginalTransactionIdNotFoundError</a>
     */
    ORIGINAL_TRANSACTION_ID_NOT_FOUND(4040005L),

    /**
     * An error response that indicates the original transaction identifier wasn’t found, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originaltransactionidnotfoundretryableerror">OriginalTransactionIdNotFoundRetryableError</a>
     */
    ORIGINAL_TRANSACTION_ID_NOT_FOUND_RETRYABLE(4040006L),

    /**
     * An error that indicates that the App Store server couldn’t find a notifications URL for your app in this environment.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/servernotificationurlnotfounderror">ServerNotificationUrlNotFoundError</a>
     */
    SERVER_NOTIFICATION_URL_NOT_FOUND(4040007L),

    /**
     * An error that indicates that the test notification token is expired or the test notification status isn’t available.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/testnotificationnotfounderror">TestNotificationNotFoundError</a>
     */
    TEST_NOTIFICATION_NOT_FOUND(4040008L),

    /**
     * An error that indicates the server didn't find a subscription-renewal-date extension request for the request identifier and product identifier you provided.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/statusrequestnotfounderror">StatusRequestNotFoundError</a>
     */
    STATUS_REQUEST_NOT_FOUND(4040009L),

    /**
     * An error that indicates a transaction identifier wasn't found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionidnotfounderror">TransactionIdNotFoundError</a>
     */
    TRANSACTION_ID_NOT_FOUND(4040010L),

    /**
     * An error that indicates that the request exceeded the rate limit.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/ratelimitexceedederror">RateLimitExceededError</a>
     */
    RATE_LIMIT_EXCEEDED(4290000L),

    /**
     * An error that indicates a general internal error.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalinternalerror">GeneralInternalError</a>
     */
    GENERAL_INTERNAL(5000000L),

    /**
     * An error response that indicates an unknown error occurred, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalinternalretryableerror">GeneralInternalRetryableError</a>
     */
    GENERAL_INTERNAL_RETRYABLE(5000001L);

    private final long errorCode;

    APIError(long errorCode) {
        this.errorCode = errorCode;
    }

    public static APIError fetchErrorResponseFromErrorCode(long errorCode) {
        return Arrays.stream(APIError.values()).filter(v -> v.errorCode == errorCode).findAny().orElse(null);
    }

    public long errorCode() {
        return errorCode;
    }
}
