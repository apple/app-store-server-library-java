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
     * This general error occurs for various reasons, suggesting the request to the server is malformed.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalbadrequesterror">GeneralBadRequestError</a>
     */
    GENERAL_BAD_REQUEST(4000000L),

    /**
     * An error that indicates an invalid app identifier.
     *
     * This error occurs when the provided app identifier does not match any existing app in the App Store's records, often due to a typo or incorrect app ID being used in the request.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappidentifiererror">InvalidAppIdentifierError</a>
     */
    INVALID_APP_IDENTIFIER(4000002L),

    /**
     * An error that indicates an invalid request revision.
     *
     * This error signifies that the revision number or identifier provided in the request does not match any known revision, suggesting a potential error in specifying the revision details.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrequestrevisionerror">InvalidRequestRevisionError</a>
     */
    INVALID_REQUEST_REVISION(4000005L),

    /**
     * An error indicating the provided transaction identifier is invalid.
     *
     * This error occurs when the transaction ID sent in the request cannot be found or does not match any existing transactions in the system, possibly due to a typo or outdated information.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactioniderror">InvalidTransactionIdError</a>
     */
    INVALID_TRANSACTION_ID(4000006L),

    /**
     * An error indicating the original transaction identifier is invalid.
     *
     * This occurs when referencing a transaction that does not exist or the original transaction ID is incorrect, often during attempts to verify or modify a transaction's status.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidoriginaltransactioniderror">InvalidOriginalTransactionIdError</a>
     */
    INVALID_ORIGINAL_TRANSACTION_ID(4000008L),

    /**
     * An error indicating the 'extend-by-days' value provided is invalid.
     *
     * This error highlights issues with the number of days specified for extending a subscription or trial, usually because the value is out of the accepted range or format.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidextendbydayserror">InvalidExtendByDaysError</a>
     */
    INVALID_EXTEND_BY_DAYS(4000009L),

    /**
     * An error indicating the reason code for an extension is invalid.
     *
     * This error suggests that the provided reason code for requesting an extension, such as for a subscription renewal, does not match any of the known or valid reason codes.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidextendreasoncodeerror">InvalidExtendReasonCodeError</a>
     */
    INVALID_EXTEND_REASON_CODE(4000010L),

    /**
     * An error indicating the provided request identifier is invalid.
     *
     * This error occurs when the specified request ID does not match any known or pending requests, possibly due to a mistyped or outdated identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrequestidentifiererror">InvalidRequestIdentifierError</a>
     */
    INVALID_REQUEST_IDENTIFIER(4000011L),

    /**
     * An error indicating the specified start date is earlier than allowed.
     *
     * This occurs when a request includes a start date that falls before the earliest date permitted by the App Store's policies or the specific API's operational parameters.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdatetoofarinpasterror">StartDateTooFarInPastError</a>
     */
    START_DATE_TOO_FAR_IN_PAST(4000012L),

    /**
     * An error indicating the end date is set before the start date or the same as the start date.
     *
     * This error highlights logical inconsistencies in date ranges provided in requests, such as for subscription periods or event scheduling, which are not permitted.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdateafterenddateerror">StartDateAfterEndDateError</a>
     */
    START_DATE_AFTER_END_DATE(4000013L),

    /**
     * An error indicating the pagination token used in the request is invalid.
     *
     * This error typically occurs when navigating through a list of items provided by the API and the supplied token for fetching the next set of results is malformed or expired.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidpaginationtokenerror">InvalidPaginationTokenError</a>
     */
    INVALID_PAGINATION_TOKEN(4000014L),

    /**
     * An error indicating the provided start date does not meet validation criteria.
     *
     * This may occur if the date format is incorrect, or the date is outside an acceptable range for the operation being performed.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstartdateerror">InvalidStartDateError</a>
     */
    INVALID_START_DATE(4000015L),

    /**
     * An error indicating the provided end date does not meet validation criteria.
     *
     * Similar to the start date error, this can happen if the date is improperly formatted or not within an expected range.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidenddateerror">InvalidEndDateError</a>
     */
    INVALID_END_DATE(4000016L),

    /**
     * An error indicating the pagination token used in the request has expired.
     *
     * Pagination tokens are typically time-sensitive. This error occurs if a token is used beyond its valid lifespan.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/paginationtokenexpirederror">PaginationTokenExpiredError</a>
     */
    PAGINATION_TOKEN_EXPIRED(4000017L),

    /**
     * An error indicating the notification type or subtype specified in the request is not recognized.
     *
     * This error suggests a mismatch between the provided notification type/subtype and those defined by the API.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidnotificationtypeerror">InvalidNotificationTypeError</a>
     */
    INVALID_NOTIFICATION_TYPE(4000018L),

    /**
     * An error indicating that the request cannot be processed due to multiple conflicting filters.
     *
     * This occurs when a request includes multiple filters that cannot be applied together or are mutually exclusive.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/multiplefilterssuppliederror">MultipleFiltersSuppliedError</a>
     */
    MULTIPLE_FILTERS_SUPPLIED(4000019L),

    /**
     * An error indicating the test notification token provided is invalid.
     *
     * This error can arise if the token format is incorrect or the token does not match any known valid tokens.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtestnotificationtokenerror">InvalidTestNotificationTokenError</a>
     */
    INVALID_TEST_NOTIFICATION_TOKEN(4000020L),

    /**
     * An error indicating the sort parameter provided in the request is invalid.
     *
     * This error is triggered if the sort parameter does not match any of the allowed sorting criteria for the API endpoint.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsorterror">InvalidSortError</a>
     */
    INVALID_SORT(4000021L),

    /**
     * An error that indicates an invalid product type parameter.
     *
     * This error occurs when the product type provided does not match any known product types, potentially due to incorrect data entry.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidproducttypeerror">InvalidProductTypeError</a>
     */
    INVALID_PRODUCT_TYPE(4000022L),

    /**
     * An error that indicates the product ID parameter is invalid.
     *
     * This error signifies that the provided product ID does not exist or is incorrectly formatted, indicating a possible error in data entry or retrieval.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidproductiderror">InvalidProductIdError</a>
     */
    INVALID_PRODUCT_ID(4000023L),

    /**
     * An error that indicates an invalid subscription group identifier.
     *
     * This error arises when the subscription group identifier provided does not correspond to any existing subscription groups, suggesting an error in specifying the identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsubscriptiongroupidentifiererror">InvalidSubscriptionGroupIdentifierError</a>
     */
    INVALID_SUBSCRIPTION_GROUP_IDENTIFIER(4000024L),

    /**
     * An error that indicates the query parameter exclude-revoked is invalid.
     *
     * This deprecated error occurs if the exclude-revoked parameter was not correctly specified, suggesting a format or logical error.
     *
     * @deprecated
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidexcluderevokederror">InvalidExcludeRevokedError</a>
     */
    INVALID_EXCLUDE_REVOKED(4000025L),

    /**
     * An error that indicates an invalid in-app ownership type parameter.
     *
     * Triggered when the in-app ownership type specified does not align with valid ownership types, potentially due to incorrect data provision.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidinappownershiptypeerror">InvalidInAppOwnershipTypeError</a>
     */
    INVALID_IN_APP_OWNERSHIP_TYPE(4000026L),

    /**
     * An error that indicates a required storefront country code is empty.
     *
     * This error occurs when the storefront country code, a necessary parameter for some requests, is not provided, indicating a missing value.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidemptystorefrontcountrycodelisterror">InvalidEmptyStorefrontCountryCodeListError</a>
     */
    INVALID_EMPTY_STOREFRONT_COUNTRY_CODE_LIST(4000027L),

    /**
     * An error that indicates a storefront code is invalid.
     *
     * Occurs when the storefront country code provided does not match any known codes, suggesting an error in specifying the code.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstorefrontcountrycodeerror">InvalidStorefrontCountryCodeError</a>
     */
    INVALID_STOREFRONT_COUNTRY_CODE(4000028L),

    /**
     * An error that indicates the revoked parameter contains an invalid value.
     *
     * This error signifies that the value provided for the revoked parameter is not recognized, possibly due to incorrect formatting or values.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrevokederror">InvalidRevokedError</a>
     */
    INVALID_REVOKED(4000030L),

    /**
     * An error indicating the status parameter is invalid.
     *
     * Occurs when the status value provided in the request does not match any of the expected status values defined by the API.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstatuserror">InvalidStatusError</a>
     */
    INVALID_STATUS(4000031L),

    /**
     * An error indicating the account tenure value is invalid.
     *
     * This error can happen if the specified value for the account tenure does not conform to the expected format or range.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidaccounttenureerror">InvalidAccountTenureError</a>
     */
    INVALID_ACCOUNT_TENURE(4000032L),

    /**
     * An error indicating the app account token is invalid.
     *
     * This error occurs when the token provided does not match the format or has expired, suggesting an issue in token generation or provision.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappaccounttokenerror">InvalidAppAccountTokenError</a>
     */
    INVALID_APP_ACCOUNT_TOKEN(4000033L),

    /**
     * An error indicating the consumption status value is invalid.
     *
     * Triggered when the consumption status provided is not recognized, possibly due to incorrect data entry or misunderstanding of valid values.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidconsumptionstatuserror">InvalidConsumptionStatusError</a>
     */
    INVALID_CONSUMPTION_STATUS(4000034L),

    /**
     * An error indicating the customer consented field is invalid.
     *
     * Occurs when the provided value does not clearly indicate customer consent, or the format is not as expected by the API.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidcustomerconsentederror">InvalidCustomerConsentedError</a>
     */
    INVALID_CUSTOMER_CONSENTED(4000035L),

    /**
     * An error indicating the delivery status is invalid.
     *
     * This error highlights issues with the specified delivery status, either due to incorrect formatting or invalid status values.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invaliddeliverystatuserror">InvalidDeliveryStatusError</a>
     */
    INVALID_DELIVERY_STATUS(4000036L),

    /**
     * An error indicating the lifetime dollars purchased value is invalid.
     *
     * Triggered when the amount specified does not align with expected values, possibly indicating a data entry error.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlifetimedollarspurchasederror">InvalidLifetimeDollarsPurchasedError</a>
     */
    INVALID_LIFETIME_DOLLARS_PURCHASED(4000037L),

    /**
     * An error indicating the lifetime dollars refunded value is invalid.
     *
     * Occurs when the specified refunded amount is outside expected ranges, suggesting an error in value provision.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlifetimedollarsrefundederror">InvalidLifetimeDollarsRefundedError</a>
     */
    INVALID_LIFETIME_DOLLARS_REFUNDED(4000038L),

    /**
     * An error indicating the platform specified is invalid.
     *
     * This error is encountered when the platform identifier provided does not match any known platforms within the App Store ecosystem.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidplatformerror">InvalidPlatformError</a>
     */
    INVALID_PLATFORM(4000039L),

    /**
     * An error indicating the playtime value is invalid.
     *
     * Triggered when playtime data provided does not adhere to the expected format or is outside allowable ranges.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidplaytimeerror">InvalidPlayTimeError</a>
     */
    INVALID_PLAY_TIME(4000040L),

    /**
     * An error indicating the sample content provided is invalid.
     *
     * Occurs when content samples submitted do not meet criteria set by the App Store, potentially due to format or content guidelines.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsamplecontentprovidederror">InvalidSampleContentProvidedError</a>
     */
    INVALID_SAMPLE_CONTENT_PROVIDED(4000041L),

    /**
     * An error indicating the user status value is invalid.
     *
     * This error suggests that the user status provided in the request is not recognized or outside the expected values.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invaliduserstatuserror">InvalidUserStatusError</a>
     */
    INVALID_USER_STATUS(4000042L),

    /**
     * An error that indicates the transaction identifier doesn’t represent a consumable in-app purchase.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactionnotconsumableerror">InvalidTransactionNotConsumableError</a>
     */
    INVALID_TRANSACTION_NOT_CONSUMABLE(4000043L),

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
