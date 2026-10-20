// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import java.util.Arrays;

/**
 * Understand the error codes that App Store Server API responses return.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/error-codes">Error codes</a>
 **/
public enum APIError {
    /**
     * An error that indicates an invalid request.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalbadrequesterror">GeneralBadRequestError</a>
     **/
    GENERAL_BAD_REQUEST(4000000L),

    /**
     * An error that indicates an invalid app identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappidentifiererror">InvalidAppIdentifierError</a>
     **/
    INVALID_APP_IDENTIFIER(4000002L),

    /**
     * An error that indicates the request limit is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlimiterror">InvalidLimitError</a>
     **/
    INVALID_LIMIT(4000004L),

    /**
     * An error that indicates an invalid request revision.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrequestrevisionerror">InvalidRequestRevisionError</a>
     **/
    INVALID_REQUEST_REVISION(4000005L),

    /**
     * An error that indicates an invalid transaction identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactioniderror">InvalidTransactionIdError</a>
     **/
    INVALID_TRANSACTION_ID(4000006L),

    /**
     * An error that indicates an invalid original transaction identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidoriginaltransactioniderror">InvalidOriginalTransactionIdError</a>
     **/
    INVALID_ORIGINAL_TRANSACTION_ID(4000008L),

    /**
     * An error that indicates an invalid extend-by-days value.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidextendbydayserror">InvalidExtendByDaysError</a>
     **/
    INVALID_EXTEND_BY_DAYS(4000009L),

    /**
     * An error that indicates an invalid reason code.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidextendreasoncodeerror">InvalidExtendReasonCodeError</a>
     **/
    INVALID_EXTEND_REASON_CODE(4000010L),

    /**
     * An error that indicates an invalid request identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrequestidentifiererror">InvalidRequestIdentifierError</a>
     **/
    INVALID_REQUEST_IDENTIFIER(4000011L),

    /**
     * An error that indicates the start date is earlier than the earliest allowed date.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdatetoofarinpasterror">StartDateTooFarInPastError</a>
     **/
    START_DATE_TOO_FAR_IN_PAST(4000012L),

    /**
     * An error that indicates the end date precedes the start date, or the two dates are equal.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/startdateafterenddateerror">StartDateAfterEndDateError</a>
     **/
    START_DATE_AFTER_END_DATE(4000013L),

    /**
     * An error that indicates the pagination token is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidpaginationtokenerror">InvalidPaginationTokenError</a>
     **/
    INVALID_PAGINATION_TOKEN(4000014L),

    /**
     * An error that indicates the start date is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstartdateerror">InvalidStartDateError</a>
     **/
    INVALID_START_DATE(4000015L),

    /**
     * An error that indicates the end date is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidenddateerror">InvalidEndDateError</a>
     **/
    INVALID_END_DATE(4000016L),

    /**
     * An error that indicates the pagination token expired.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/paginationtokenexpirederror">PaginationTokenExpiredError</a>
     **/
    PAGINATION_TOKEN_EXPIRED(4000017L),

    /**
     * An error that indicates the notification type or subtype is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidnotificationtypeerror">InvalidNotificationTypeError</a>
     **/
    INVALID_NOTIFICATION_TYPE(4000018L),

    /**
     * An error that indicates the request is invalid because it has too many applied constraints.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/multiplefilterssuppliederror">MultipleFiltersSuppliedError</a>
     **/
    MULTIPLE_FILTERS_SUPPLIED(4000019L),

    /**
     * An error that indicates the test notification token is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtestnotificationtokenerror">InvalidTestNotificationTokenError</a>
     **/
    INVALID_TEST_NOTIFICATION_TOKEN(4000020L),

    /**
     * An error that indicates the sort parameter is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsorterror">InvalidSortError</a>
     **/
    INVALID_SORT(4000021L),

    /**
     * An error that indicates the product type parameter is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidproducttypeerror">InvalidProductTypeError</a>
     **/
    INVALID_PRODUCT_TYPE(4000022L),

    /**
     * An error that indicates the product ID parameter is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidproductiderror">InvalidProductIdError</a>
     **/
    INVALID_PRODUCT_ID(4000023L),

    /**
     * An error that indicates the subscription group identifier is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsubscriptiongroupidentifiererror">InvalidSubscriptionGroupIdentifierError</a>
     **/
    INVALID_SUBSCRIPTION_GROUP_IDENTIFIER(4000024L),

    /**
     * An error that indicates the query parameter exclude-revoked is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidexcluderevokederror">InvalidExcludeRevokedError</a>
     * @deprecated Use {@link #INVALID_REVOKED} instead.
     **/
    @Deprecated
    INVALID_EXCLUDE_REVOKED(4000025L),

    /**
     * An error that indicates an invalid in-app ownership type parameter.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidinappownershiptypeerror">InvalidInAppOwnershipTypeError</a>
     **/
    INVALID_IN_APP_OWNERSHIP_TYPE(4000026L),

    /**
     * An error that indicates a required storefront country code is empty.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidemptystorefrontcountrycodelisterror">InvalidEmptyStorefrontCountryCodeListError</a>
     **/
    INVALID_EMPTY_STOREFRONT_COUNTRY_CODE_LIST(4000027L),

    /**
     * An error that indicates a storefront code is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstorefrontcountrycodeerror">InvalidStorefrontCountryCodeError</a>
     **/
    INVALID_STOREFRONT_COUNTRY_CODE(4000028L),

    /**
     * An error that indicates the revoked parameter contains an invalid value.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrevokederror">InvalidRevokedError</a>
     **/
    INVALID_REVOKED(4000030L),

    /**
     * An error that indicates the status parameter is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidstatuserror">InvalidStatusError</a>
     **/
    INVALID_STATUS(4000031L),

    /**
     * An error that indicates the value of the account tenure field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidaccounttenureerror">InvalidAccountTenureError</a>
     **/
    INVALID_ACCOUNT_TENURE(4000032L),

    /**
     * An error that indicates the value of the app account token field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappaccounttokenerror">InvalidAppAccountTokenError</a>
     **/
    INVALID_APP_ACCOUNT_TOKEN(4000033L),

    /**
     * An error that indicates the value of the consumption status field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidconsumptionstatuserror">InvalidConsumptionStatusError</a>
     **/
    INVALID_CONSUMPTION_STATUS(4000034L),

    /**
     * An error that indicates the customer consented field is invalid or doesn’t indicate that the customer consented.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidcustomerconsentederror">InvalidCustomerConsentedError</a>
     **/
    INVALID_CUSTOMER_CONSENTED(4000035L),

    /**
     * An error that indicates the value in the delivery status field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invaliddeliverystatuserror">InvalidDeliveryStatusError</a>
     **/
    INVALID_DELIVERY_STATUS(4000036L),

    /**
     * An error that indicates the value in the lifetime dollars purchased field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlifetimedollarspurchasederror">InvalidLifetimeDollarsPurchasedError</a>
     **/
    INVALID_LIFETIME_DOLLARS_PURCHASED(4000037L),

    /**
     * An error that indicates the value in the lifetime dollars refunded field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidlifetimedollarsrefundederror">InvalidLifetimeDollarsRefundedError</a>
     **/
    INVALID_LIFETIME_DOLLARS_REFUNDED(4000038L),

    /**
     * An error that indicates the value in the platform field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidplatformerror">InvalidPlatformError</a>
     **/
    INVALID_PLATFORM(4000039L),

    /**
     * An error that indicates the value in the playtime field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidplaytimeerror">InvalidPlayTimeError</a>
     **/
    INVALID_PLAY_TIME(4000040L),

    /**
     * An error that indicates the value in the sample content provided field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidsamplecontentprovidederror">InvalidSampleContentProvidedError</a>
     **/
    INVALID_SAMPLE_CONTENT_PROVIDED(4000041L),

    /**
     * An error that indicates the value in the user status field is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invaliduserstatuserror">InvalidUserStatusError</a>
     **/
    INVALID_USER_STATUS(4000042L),

    /**
     * An error that indicates the transaction identifier doesn’t represent a consumable In-App Purchase.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactionnotconsumableerror">InvalidTransactionNotConsumableError</a>
     * @deprecated Use {@link #INVALID_TRANSACTION_TYPE_NOT_SUPPORTED} instead.
     **/
    @Deprecated
    INVALID_TRANSACTION_NOT_CONSUMABLE(4000043L),

    /**
     * An error that indicates an invalid refund preference value.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidrefundpreferenceerror">InvalidRefundPreferenceError</a>
     **/
    INVALID_REFUND_PREFERENCE(4000044L),

    /**
     * An error that indicates the transaction identifier represents an unsupported In-App Purchase type.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidtransactiontypenotsupportederror">InvalidTransactionTypeNotSupportedError</a>
     **/
    INVALID_TRANSACTION_TYPE_NOT_SUPPORTED(4000047L),

    /**
     * An error that indicates the endpoint doesn’t support an app transaction ID.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/apptransactionidnotsupportederror">AppTransactionIdNotSupportedError</a>
     **/
    APP_TRANSACTION_ID_NOT_SUPPORTED(4000048L),

    /**
     * The currency value is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidcurrencyerror">InvalidCurrencyError</a>
     **/
    INVALID_CURRENCY(4000053L),

    /**
     * At least one type of change must be provided in a modify subscription request.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/oneitemneededinmodifyerror">OneItemNeededInModifyError</a>
     **/
    ONE_ITEM_NEEDED_IN_MODIFY(4000063L),

    /**
     * The required field, requestInfo, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullrequestinfoerror">NullRequestInfoError</a>
     **/
    NULL_REQUEST_INFO(4000079L),

    /**
     * The required field, requestReferenceId, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullrequestreferenceiderror">NullRequestReferenceIDError</a>
     **/
    NULL_REQUEST_REFERENCE_ID(4000080L),

    /**
     * The requestReferenceId value is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidrequestreferenceiderror">InvalidRequestReferenceIDError</a>
     **/
    INVALID_REQUEST_REFERENCE_ID(4000081L),

    /**
     * The consistencyToken value is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidconsistencytokenerror">InvalidConsistencyTokenError</a>
     **/
    INVALID_CONSISTENCY_TOKEN(4000082L),

    /**
     * The required field, version, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullversionerror">NullVersionError</a>
     **/
    NULL_VERSION(4000083L),

    /**
     * The value of version is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/unexpectedversionerror">UnexpectedVersionError</a>
     **/
    UNEXPECTED_VERSION(4000084L),

    /**
     * The required field, transactionId, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulltransactioniderror">NullTransactionIdError</a>
     **/
    NULL_TRANSACTION_ID(4000085L),

    /**
     * The price field must contain a positive number.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/negativepriceerror">NegativePriceError</a>
     **/
    NEGATIVE_PRICE(4000086L),

    /**
     * Exceeds the maximum length of the SKU field.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/skulengthexceedederror">SKULengthExceededError</a>
     **/
    SKU_LENGTH_EXCEEDED(4000087L),

    /**
     * Exceeds the maximum length of the description field.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/descriptionlengthexceedederror">DescriptionLengthExceededError</a>
     **/
    DESCRIPTION_LENGTH_EXCEEDED(4000088L),

    /**
     * Exceeds the maximum length of the displayName field.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/displaynamelengthexceedederror">DisplayNameLengthExceededError</a>
     **/
    DISPLAY_NAME_LENGTH_EXCEEDED(4000089L),

    /**
     * The proratedPrice field must contain a positive number.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/negativeproratedpriceerror">NegativeProratedPriceError</a>
     **/
    NEGATIVE_PRORATED_PRICE(4000091L),

    /**
     * The required field, offer period, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullofferperioderror">NullOfferPeriodError</a>
     **/
    NULL_OFFER_PERIOD(4000092L),

    /**
     * The required field, periodCount, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullperiodcounterror">NullPeriodCountError</a>
     **/
    NULL_PERIOD_COUNT(4000093L),

    /**
     * Period count must be a positive number.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/periodcountnotpositiveerror">PeriodCountNotPositiveError</a>
     **/
    PERIOD_COUNT_NOT_POSITIVE(4000094L),

    /**
     * The required field, reason, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullreasonerror">NullReasonError</a>
     **/
    NULL_REASON(4000095L),

    /**
     * Previous original transaction id is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidprevioustransactioniderror">InvalidPreviousTransactionIDError</a>
     **/
    INVALID_PREVIOUS_TRANSACTION_ID(4000096L),

    /**
     * The requestReferenceId was repeated.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/repeatedrequestreferenceiderror">RepeatedRequestReferenceIdError</a>
     **/
    REPEATED_REQUEST_REFERENCE_ID(4000097L),

    /**
     * The required field, currency, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullcurrencyerror">NullCurrencyError</a>
     **/
    NULL_CURRENCY(4000098L),

    /**
     * The required field, taxCode, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulltaxcodeerror">NullTaxCodeError</a>
     **/
    NULL_TAX_CODE(4000099L),

    /**
     * The required field, storefront, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullstorefronterror">NullStorefrontError</a>
     **/
    NULL_STOREFRONT(4000100L),

    /**
     * The required field, items, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullitemserror">NullItemsError</a>
     **/
    NULL_ITEMS(4000101L),

    /**
     * The required field, item, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullitemerror">NullItemError</a>
     **/
    NULL_ITEM(4000102L),

    /**
     * The required field, descriptors, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulldescriptorserror">NullDescriptorsError</a>
     **/
    NULL_DESCRIPTORS(4000103L),

    /**
     * The required field, period, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullperioderror">NullPeriodError</a>
     **/
    NULL_PERIOD(4000104L),

    /**
     * The required field, SKU, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullskuerror">NullSKUError</a>
     **/
    NULL_SKU(4000105L),

    /**
     * The required field, displayName, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulldisplaynameerror">NullDisplayNameError</a>
     **/
    NULL_DISPLAY_NAME(4000106L),

    /**
     * The required field, description, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulldescriptionerror">NullDescriptionError</a>
     **/
    NULL_DESCRIPTION(4000107L),

    /**
     * The required field, price, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullpriceerror">NullPriceError</a>
     **/
    NULL_PRICE(4000109L),

    /**
     * The required field, retainBillingCycle, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullretainbillingcycleerror">NullRetainBillingCycleError</a>
     **/
    NULL_RETAIN_BILLING_CYCLE(4000110L),

    /**
     * The required field, effective, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulleffectiveerror">NullEffectiveError</a>
     **/
    NULL_EFFECTIVE(4000111L),

    /**
     * The required field, SKU in changeItems, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullnewskuerror">NullNewSKUError</a>
     **/
    NULL_NEW_SKU(4000112L),

    /**
     * The previous subscription targeted is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidprevioussubscriptionerror">InvalidPreviousSubscriptionError</a>
     **/
    INVALID_PREVIOUS_SUBSCRIPTION(4000113L),

    /**
     * Provided SKU is already owned.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/productalreadyexistserror">ProductAlreadyExistsError</a>
     **/
    PRODUCT_ALREADY_EXISTS(4000114L),

    /**
     * Product changes are invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidproductchangeserror">InvalidProductChangesError</a>
     **/
    INVALID_PRODUCT_CHANGES(4000115L),

    /**
     * The targeted salable isn't configured as a generic salable.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidsalableerror">InvalidSalableError</a>
     **/
    INVALID_SALABLE(4000116L),

    /**
     * The salable duration is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidsalabledurationerror">InvalidSalableDurationError</a>
     **/
    INVALID_SALABLE_DURATION(4000117L),

    /**
     * The displayName is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invaliddisplaynameerror">InvalidDisplayNameError</a>
     **/
    INVALID_DISPLAY_NAME(4000118L),

    /**
     * The description is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invaliddescriptionerror">InvalidDescriptionError</a>
     **/
    INVALID_DESCRIPTION(4000119L),

    /**
     * The requested product to change doesn't exist.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidproducterror">InvalidProductError</a>
     **/
    INVALID_PRODUCT(4000121L),

    /**
     * The SKU was invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidskuerror">InvalidSKUError</a>
     **/
    INVALID_SKU(4000122L),

    /**
     * The refundType is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidrefundtypeerror">InvalidRefundTypeError</a>
     **/
    INVALID_REFUND_TYPE(4000123L),

    /**
     * The refundReason is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidrefundreasonerror">InvalidRefundReasonError</a>
     **/
    INVALID_REFUND_REASON(4000124L),

    /**
     * The change reason is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidchangereasonerror">InvalidChangeReasonError</a>
     **/
    INVALID_CHANGE_REASON(4000125L),

    /**
     * The offer reason is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidofferreasonerror">InvalidOfferReasonError</a>
     **/
    INVALID_OFFER_REASON(4000126L),

    /**
     * The taxCode is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidtaxproductcodeerror">InvalidTaxProductCodeError</a>
     **/
    INVALID_TAX_PRODUCT_CODE(4000127L),

    /**
     * The offer period is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidofferperioderror">InvalidOfferPeriodError</a>
     **/
    INVALID_OFFER_PERIOD(4000128L),

    /**
     * The offer periodCount is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidofferperiodcounterror">InvalidOfferPeriodCountError</a>
     **/
    INVALID_OFFER_PERIOD_COUNT(4000129L),

    /**
     * The renewal period is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidrenewalperioderror">InvalidRenewalPeriodError</a>
     **/
    INVALID_RENEWAL_PERIOD(4000130L),

    /**
     * The renewal price is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidrenewalpriceerror">InvalidRenewalPriceError</a>
     **/
    INVALID_RENEWAL_PRICE(4000131L),

    /**
     * The amount is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidamounterror">InvalidAmountError</a>
     **/
    INVALID_AMOUNT(4000132L),

    /**
     * The storefronts mismatch.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/mismatchedstorefronterror">MismatchedStorefrontError</a>
     **/
    MISMATCHED_STOREFRONT(4000133L),

    /**
     * Pricing isn't configured for the storefront.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/missingpricingconfigforstorefronterror">MissingPricingConfigForStorefrontError</a>
     **/
    MISSING_PRICING_CONFIG_FOR_STOREFRONT(4000134L),

    /**
     * The operation isn't allowed.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/operationnotallowederror">OperationNotAllowedError</a>
     **/
    OPERATION_NOT_ALLOWED(4000135L),

    /**
     * More items were provided than allowed.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/moreitemsthanallowederror">MoreItemsThanAllowedError</a>
     **/
    MORE_ITEMS_THAN_ALLOWED(4000136L),

    /**
     * More offers were provided than allowed.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/moreoffersthanallowederror">MoreOffersThanAllowedError</a>
     **/
    MORE_OFFERS_THAN_ALLOWED(4000137L),

    /**
     * The addItems and changeItems entries cannot be empty.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/emptyaddchangeitemserror">EmptyAddChangeItemsError</a>
     **/
    EMPTY_ADD_CHANGE_ITEMS(4000139L),

    /**
     * All items must be updated on a period change.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/missingupdateditemswithperiodchangeerror">MissingUpdatedItemsWithPeriodChangeError</a>
     **/
    MISSING_UPDATED_ITEMS_WITH_PERIOD_CHANGE(4000140L),

    /**
     * Period reset conflicts with retaining billing cycle.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/periodresetwithretainbillingcycleerror">PeriodResetWithRetainBillingCycleError</a>
     **/
    PERIOD_RESET_WITH_RETAIN_BILLING_CYCLE(4000141L),

    /**
     * A period change at next cycle conflicts with addition at the current period.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/periodchangeeffectiveconflicterror">PeriodChangeEffectiveConflictError</a>
     **/
    PERIOD_CHANGE_EFFECTIVE_CONFLICT(4000142L),

    /**
     * Multiple operations on a single SKU isn't allowed.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/multipleoperationsonsingleskuerror">MultipleOperationsOnSingleSKUError</a>
     **/
    MULTIPLE_OPERATIONS_ON_SINGLE_SKU(4000143L),

    /**
     * The removeItems object was present without addItems or changeItems.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/removeitemswithoutaddorchangeitemserror">RemoveItemsWithoutAddOrChangeItemsError</a>
     **/
    REMOVE_ITEMS_WITHOUT_ADD_OR_CHANGE_ITEMS(4000144L),

    /**
     * A product in removeItems wasn't found for the given subscription.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/removeitemnotfounderror">RemoveItemNotFoundError</a>
     **/
    REMOVE_ITEM_NOT_FOUND(4000145L),

    /**
     * The targeted item in changeItems wasn't found.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/changeitemnotfounderror">ChangeItemNotFoundError</a>
     **/
    CHANGE_ITEM_NOT_FOUND(4000146L),

    /**
     * The request contains a billing period that doesn't align with the subscription's billing cycle.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/misalignedbillingcycleerror">MisalignedBillingCycleError</a>
     **/
    MISALIGNED_BILLING_CYCLE(4000147L),

    /**
     * Bill cycle reset with effective later.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/billingcycleresetwitheffectivelatererror">BillingCycleResetWithEffectiveLaterError</a>
     **/
    BILLING_CYCLE_RESET_WITH_EFFECTIVE_LATER(4000148L),

    /**
     * Period change immediately with effective later.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/periodchangeimmediatewitheffectiveatnextbillingcycleerror">PeriodChangeImmediateWithEffectiveAtNextBillingCycleError</a>
     **/
    PERIOD_CHANGE_IMMEDIATE_WITH_EFFECTIVE_AT_NEXT_BILLING_CYCLE(4000149L),

    /**
     * Prorated price and offer price are mutually exclusive.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/multiplepriceserror">MultiplePricesError</a>
     **/
    MULTIPLE_PRICES(4000150L),

    /**
     * The prorated price was invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidproratedpriceerror">InvalidProratedPriceError</a>
     **/
    INVALID_PRORATED_PRICE(4000151L),

    /**
     * The subscription offer price is higher than the regular subscription price.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidofferpriceerror">InvalidOfferPriceError</a>
     **/
    INVALID_OFFER_PRICE(4000152L),

    /**
     * The refundAmount value is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullrefundamounterror">NullRefundAmountError</a>
     **/
    NULL_REFUND_AMOUNT(4000153L),

    /**
     * The refundAmount must be a positive number.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/negativerefundamounterror">NegativeRefundAmountError</a>
     **/
    NEGATIVE_REFUND_AMOUNT(4000154L),

    /**
     * Can't provide the refund amount because the refundType isn't CUSTOM.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/refundamountwithoutcustomerror">RefundAmountWithoutCustomError</a>
     **/
    REFUND_AMOUNT_WITHOUT_CUSTOM(4000155L),

    /**
     * The required field, refundReason, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullrefundreasonerror">NullRefundReasonError</a>
     **/
    NULL_REFUND_REASON(4000156L),

    /**
     * The required field, refundType, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullrefundtypeerror">NullRefundTypeError</a>
     **/
    NULL_REFUND_TYPE(4000157L),

    /**
     * The type SIMULATE_REFUND_DECLINE is only valid in Sandbox.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/simulaterefunddeclineonlyinsandboxerror">SimulateRefundDeclineOnlyInSandboxError</a>
     **/
    SIMULATE_REFUND_DECLINE_ONLY_IN_SANDBOX(4000158L),

    /**
     * The required field, refundRiskingPreference, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullrefundriskingerror">NullRefundRiskingError</a>
     **/
    NULL_REFUND_RISKING(4000159L),

    /**
     * When included, provide at least one item in items.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/atleastoneitemerror">AtLeastOneItemError</a>
     **/
    AT_LEAST_ONE_ITEM(4000160L),

    /**
     * An error that indicates the image that’s uploading is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/invalidimageerror">InvalidImageError</a>
     **/
    INVALID_IMAGE(4000161L),

    /**
     * An error that indicates the header text is too long.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/headertoolongerror">HeaderTooLongError</a>
     **/
    HEADER_TOO_LONG(4000162L),

    /**
     * An error that indicates the body text is too long.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/bodytoolongerror">BodyTooLongError</a>
     **/
    BODY_TOO_LONG(4000163L),

    /**
     * An error that indicates the locale is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/invalidlocaleerror">InvalidLocaleError</a>
     **/
    INVALID_LOCALE(4000164L),

    /**
     * Provide either the displayName or a description.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/atleastoneofdisplaynameordescriptionerror">AtLeastOneOfDisplayNameOrDescriptionError</a>
     **/
    AT_LEAST_ONE_OF_DISPLAY_NAME_OR_DESCRIPTION(4000165L),

    /**
     * The required field, targetProductID, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulltargetproductiderror">NullTargetProductIDError</a>
     **/
    NULL_TARGET_PRODUCT_ID(4000166L),

    /**
     * The targetProductID value is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidtargetproductiderror">InvalidTargetProductIDError</a>
     **/
    INVALID_TARGET_PRODUCT_ID(4000167L),

    /**
     * The active subscription must contain at least one item and cannot be completely empty.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/removalallnotallowederror">RemovalAllNotAllowedError</a>
     **/
    REMOVAL_ALL_NOT_ALLOWED(4000168L),

    /**
     * The required field, currentSKU, is missing.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nullcurrentskuerror">NullCurrentSKUError</a>
     **/
    NULL_CURRENT_SKU(4000169L),

    /**
     * Exceeds the maximum length of the currentSKU field.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/currentskulengthexceedederror">CurrentSKULengthExceededError</a>
     **/
    CURRENT_SKU_LENGTH_EXCEEDED(4000170L),

    /**
     * The required field, advancedCommerceData, was null.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/nulladvancedcommercedataerror">NullAdvancedCommerceDataError</a>
     **/
    NULL_ADVANCED_COMMERCE_DATA(4000171L),

    /**
     * The operation is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidoperationerror">InvalidOperationError</a>
     **/
    INVALID_OPERATION(4000172L),

    /**
     * The payload is malformed.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/malformedpayloaderror">MalformedPayloadError</a>
     **/
    MALFORMED_PAYLOAD(4000173L),

    /**
     * The signature is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidsignatureerror">InvalidSignatureError</a>
     **/
    INVALID_SIGNATURE(4000174L),

    /**
     * An error that indicates the alternative text for an image is too long.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/alttexttoolongerror">AltTextTooLongError</a>
     **/
    ALT_TEXT_TOO_LONG(4000175L),

    /**
     * The subscription was already migrated.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionalreadymigratederror">SubscriptionAlreadyMigratedError</a>
     **/
    SUBSCRIPTION_ALREADY_MIGRATED(4000176L),

    /**
     * An active or pending offer prevents changes to the item mid-cycle.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/offerpreventsitemmidcyclechangeerror">OfferPreventsItemMidCycleChangeError</a>
     **/
    OFFER_PREVENTS_ITEM_MID_CYCLE_CHANGE(4000177L),

    /**
     * Price change is not allowed through plan modification.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/pricechangenotsupportedthroughmodifyitemserror">PriceChangeNotSupportedThroughModifyItemsError</a>
     **/
    PRICE_CHANGE_NOT_SUPPORTED_THROUGH_MODIFY_ITEMS(4000178L),

    /**
     * The number of items in subscription exceeds the limit.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/itemlimitexceedederror">ItemLimitExceededError</a>
     **/
    ITEM_LIMIT_EXCEEDED(4000179L),

    /**
     * Pending subscription changes must specify a renewalItem, and if there are no pending changes, a renewalItem cannot be specified.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/pendingchangesmismatcherror">PendingChangesMismatchError</a>
     **/
    PENDING_CHANGES_MISMATCH(4000180L),

    /**
     * The transaction has pending refunds.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/pendingrefunderror">PendingRefundError</a>
     **/
    PENDING_REFUND(4000181L),

    /**
     * Only requests against the latest transaction can have a PRORATED refundType value.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/proratedonlylatesttransactionerror">ProratedOnlyLatestTransactionError</a>
     **/
    PRORATED_ONLY_LATEST_TRANSACTION(4000182L),

    /**
     * An error that indicates the app account token value is not a valid UUID.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidappaccounttokenuuiderror">InvalidAppAccountTokenUUIDError</a>
     **/
    INVALID_APP_ACCOUNT_TOKEN_UUID(4000183L),

    /**
     * If one item has a refundReason value of SIMULATE_REFUND_DECLINE, all items must have a refundReason value of SIMULATE_REFUND_DECLINE.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/partialsimulaterefunddeclineerror">PartialSimulateRefundDeclineError</a>
     **/
    PARTIAL_SIMULATE_REFUND_DECLINE(4000184L),

    /**
     * An error that indicates the transaction is for a product the customer obtains through Family Sharing, which the endpoint doesn’t support.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/familytransactionnotsupportederror">FamilyTransactionNotSupportedError</a>
     **/
    FAMILY_TRANSACTION_NOT_SUPPORTED(4000185L),

    /**
     * Only active subscriptions are revocable.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/revokeoninactivesubscriptionerror">RevokeOnInactiveSubscriptionError</a>
     **/
    REVOKE_ON_INACTIVE_SUBSCRIPTION(4000186L),

    /**
     * An error that indicates the endpoint expects an original transaction identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionidisnotoriginaltransactioniderror">TransactionIdIsNotOriginalTransactionIdError</a>
     **/
    TRANSACTION_ID_IS_NOT_ORIGINAL_TRANSACTION_ID(4000187L),

    /**
     * Invalid request. dependentSKUs can't be shared between multiple SKUs.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/dependentskuscannotbesharederror">DependentSKUsCannotBeSharedError</a>
     **/
    DEPENDENT_SKUS_CANNOT_BE_SHARED(4000192L),

    /**
     * Invalid request. dependentSKUs can't be chained.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/dependentskuscannotbechainederror">DependentSKUsCannotBeChainedError</a>
     **/
    DEPENDENT_SKUS_CANNOT_BE_CHAINED(4000193L),

    /**
     * Invalid request. The same SKU can't be repeated in this request.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/itemcannotbespecifiedmultipletimeserror">ItemCannotBeSpecifiedMultipleTimesError</a>
     **/
    ITEM_CANNOT_BE_SPECIFIED_MULTIPLE_TIMES(4000194L),

    /**
     * Invalid request. A price change can't be issued when the price increase has already been communicated.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/pricechangecannotbeissuedwhenalreadycommunicatederror">PriceChangeCannotBeIssuedWhenAlreadyCommunicatedError</a>
     **/
    PRICE_CHANGE_CANNOT_BE_ISSUED_WHEN_ALREADY_COMMUNICATED(4000205L),

    /**
     * An error that indicates the consumption percentage is outside the valid range.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionpercentageoutofrangeerror">ConsumptionPercentageOutOfRangeError</a>
     **/
    CONSUMPTION_PERCENTAGE_OUT_OF_RANGE(4000207L),

    /**
     * An error that indicates the consumption percentage must be zero for the provided delivery status.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/undeliveredconsumptionpercentagenonzeroerror">UndeliveredConsumptionPercentageNonZeroError</a>
     **/
    UNDELIVERED_CONSUMPTION_PERCENTAGE_NON_ZERO(4000208L),

    /**
     * An error that indicates the consumption percentage field is unsupported for auto-renewable subscription transactions.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/consumptionpercentageautorenewablesubscriptionerror">ConsumptionPercentageAutoRenewableSubscriptionError</a>
     **/
    CONSUMPTION_PERCENTAGE_AUTO_RENEWABLE_SUBSCRIPTION(4000209L),

    /**
     * An error that indicates Advanced Commerce API transactions are not supported by the endpoint.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/advancedcommercetransactionnotsupportederror">AdvancedCommerceTransactionNotSupportedError</a>
     **/
    ADVANCED_COMMERCE_TRANSACTION_NOT_SUPPORTED(4000210L),

    /**
     * An error the API returns that indicates the performance test request is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/invalidperformancetestrequesterror">InvalidPerformanceTestRequestError</a>
     **/
    INVALID_PERFORMANCE_TEST_REQUEST(4000211L),

    /**
     * An error that indicates the request ID is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/invalidrequestiderror">InvalidRequestIdError</a>
     **/
    INVALID_REQUEST_ID(4000212L),

    /**
     * An error that indicates an error with an existing test.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/existingperformancetestrunerror">ExistingPerformanceTestRunError</a>
     **/
    EXISTING_PERFORMANCE_TEST_RUN(4000213L),

    /**
     * Invalid request. Price provided for a changed item with an offer while subject to a price increase was invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidpriceforchangeiteminpriceincreaseerror">InvalidPriceForChangeItemInPriceIncreaseError</a>
     **/
    INVALID_PRICE_FOR_CHANGE_ITEM_IN_PRICE_INCREASE(4000214L),

    /**
     * An error that indicates the URL is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/badrequestrealtimeurlerror">BadRequestRealtimeUrlError</a>
     **/
    BAD_REQUEST_REALTIME_URL(4000215L),

    /**
     * An error that indicates the image size provided is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/badrequestimagesizeerror">BadRequestImageSizeError</a>
     **/
    BAD_REQUEST_IMAGE_SIZE(4000216L),

    /**
     * An error that indicates there are too many bullet points.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/badrequesttoomanybulletpointserror">BadRequestTooManyBulletPointsError</a>
     **/
    BAD_REQUEST_TOO_MANY_BULLET_POINTS(4000218L),

    /**
     * An error that indicates the text for a bullet point is too long.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/badrequestbulletpointtexttoolongerror">BadRequestBulletPointTextTooLongError</a>
     **/
    BAD_REQUEST_BULLET_POINT_TEXT_TOO_LONG(4000219L),

    /**
     * Invalid request. SKU values provided in request must be a SKU that will renew.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidskuprovidedmustbecurrentskusettorenewerror">InvalidSKUProvidedMustBeCurrentSKUSetToRenewError</a>
     **/
    INVALID_SKU_PROVIDED_MUST_BE_CURRENT_SKU_SET_TO_RENEW(4000220L),

    /**
     * Advanced Commerce API Price Increase mechanism is not currently supported in India.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/acapriceincreaseisnotcurrentlysupportedinindiaerror">ACAPriceIncreaseIsNotCurrentlySupportedInIndiaError</a>
     **/
    ACA_PRICE_INCREASE_IS_NOT_CURRENTLY_SUPPORTED_IN_INDIA(4000221L),

    /**
     * Invalid request. A prorated price shouldn't be present to change items with the change taking effect later.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/invalidproratedpriceforchangeitemwitheffectivelatererror">InvalidProratedPriceForChangeItemWithEffectiveLaterError</a>
     **/
    INVALID_PRORATED_PRICE_FOR_CHANGE_ITEM_WITH_EFFECTIVE_LATER(4000222L),

    /**
     * Invalid request. The subscription offer configuration is invalid; free trial offers must use a period count of 1.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/freetrialoffermustuseperiodcountofoneerror">FreeTrialOfferMustUsePeriodCountOfOneError</a>
     **/
    FREE_TRIAL_OFFER_MUST_USE_PERIOD_COUNT_OF_ONE(4000223L),

    /**
     * An error that indicates that no image object is included, but the request indicates that the header should be placed above the image.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/badrequestaboveimagerequiresanimageerror">BadRequestAboveImageRequiresAnImageError</a>
     **/
    BAD_REQUEST_ABOVE_IMAGE_REQUIRES_AN_IMAGE(4000224L),

    /**
     * An error that indicates the group identifier is invalid.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidgroupiderror">InvalidGroupIdError</a>
     **/
    INVALID_GROUP_ID(4000225L),

    /**
     * An error that indicates the transaction is one that an organization or group assigns to the customer, which the endpoint doesn’t support.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/invalidassignedtransactionnotsupportederror">InvalidAssignedTransactionNotSupportedError</a>
     **/
    INVALID_ASSIGNED_TRANSACTION_NOT_SUPPORTED(4000227L),

    /**
     * Unauthorized.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/unauthorizederror">UnauthorizedError</a>
     **/
    UNAUTHORIZED(4010000L),

    /**
     * An error that indicates the subscription doesn’t qualify for a renewal-date extension due to its subscription state.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptionextensionineligibleerror">SubscriptionExtensionIneligibleError</a>
     **/
    SUBSCRIPTION_EXTENSION_INELIGIBLE(4030004L),

    /**
     * An error that indicates the subscription doesn’t qualify for a renewal-date extension because it has already received the maximum extensions.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/subscriptionmaxextensionerror">SubscriptionMaxExtensionError</a>
     **/
    SUBSCRIPTION_MAX_EXTENSION(4030005L),

    /**
     * An error that indicates a subscription isn’t directly eligible for a renewal date extension because the customer obtained it through Family Sharing.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/familysharedsubscriptionextensionineligibleerror">FamilySharedSubscriptionExtensionIneligibleError</a>
     **/
    FAMILY_SHARED_SUBSCRIPTION_EXTENSION_INELIGIBLE(4030007L),

    /**
     * The subscription doesn't exist.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptiondoesnotexisterror">SubscriptionDoesNotExistError</a>
     **/
    SUBSCRIPTION_DOES_NOT_EXIST(4030008L),

    /**
     * The subscription already exists.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionalreadyexistserror">SubscriptionAlreadyExistsError</a>
     **/
    SUBSCRIPTION_ALREADY_EXISTS(4030009L),

    /**
     * The subscription isn't eligible for the requested changes.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionnoteligibleerror">SubscriptionNotEligibleError</a>
     **/
    SUBSCRIPTION_NOT_ELIGIBLE(4030010L),

    /**
     * The subscription is already active, and cannot be reactivated or renewed at this time.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptionalreadyactiveerror">SubscriptionAlreadyActiveError</a>
     **/
    SUBSCRIPTION_ALREADY_ACTIVE(4030011L),

    /**
     * The customer doesn't own the product.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/productnotownederror">ProductNotOwnedError</a>
     **/
    PRODUCT_NOT_OWNED(4030013L),

    /**
     * An error that indicates when you reach the maximum number of uploaded images.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/maximumnumberofimagesreachederror">MaximumNumberOfImagesReachedError</a>
     **/
    MAXIMUM_NUMBER_OF_IMAGES_REACHED(4030014L),

    /**
     * The subscription is not active.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/inactiveacasuberror">InactiveACASubError</a>
     **/
    INACTIVE_ACA_SUB(4030015L),

    /**
     * An error that indicates when you reach the maximum number of uploaded messages.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/maximumnumberofmessagesreachederror">MaximumNumberOfMessagesReachedError</a>
     **/
    MAXIMUM_NUMBER_OF_MESSAGES_REACHED(4030016L),

    /**
     * An error that indicates the message isn’t in the approved state, so you can’t configure it as a default message.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messagenotapprovederror">MessageNotApprovedError</a>
     **/
    MESSAGE_NOT_APPROVED(4030017L),

    /**
     * An error that indicates the image isn’t in the approved state, so you can’t configure it as part of a default message.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imagenotapprovederror">ImageNotApprovedError</a>
     **/
    IMAGE_NOT_APPROVED(4030018L),

    /**
     * An error that indicates the image is currently in use as part of a message, so you can’t delete it.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imageinuseerror">ImageInUseError</a>
     **/
    IMAGE_IN_USE(4030019L),

    /**
     * Insufficient funds for refund.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/insufficientfundserror">InsufficientFundsError</a>
     **/
    INSUFFICIENT_FUNDS(4030020L),

    /**
     * The transaction was already refunded.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/alreadyrefundederror">AlreadyRefundedError</a>
     **/
    ALREADY_REFUNDED(4030021L),

    /**
     * The storefront changed.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/storefrontchangeerror">StorefrontChangeError</a>
     **/
    STOREFRONT_CHANGE(4030022L),

    /**
     * The product isn't eligible for the requested operation.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/productnoteligibleerror">ProductNotEligibleError</a>
     **/
    PRODUCT_NOT_ELIGIBLE(4030023L),

    /**
     * The transaction is not refundable.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/transactionnotrefundableerror">TransactionNotRefundableError</a>
     **/
    TRANSACTION_NOT_REFUNDABLE(4030024L),

    /**
     * The transaction can't be refunded; customer can contact Apple Support for assistance.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/transactioncannotberefundedcontactsupporterror">TransactionCannotBeRefundedContactSupportError</a>
     **/
    TRANSACTION_CANNOT_BE_REFUNDED_CONTACT_SUPPORT(4030025L),

    /**
     * An error that indicates that passing a performance test is required before you can set a URL for the production environment.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/forbiddennopassingtesterror">ForbiddenNoPassingTestError</a>
     **/
    FORBIDDEN_NO_PASSING_TEST(4030026L),

    /**
     * The subscription isn't eligible for migration because a price increase has already been communicated to the customer.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/migrationnotallowedwhenpriceincreasecommunicatederror">MigrationNotAllowedWhenPriceIncreaseCommunicatedError</a>
     **/
    MIGRATION_NOT_ALLOWED_WHEN_PRICE_INCREASE_COMMUNICATED(4030027L),

    /**
     * An error that indicates a subscription isn’t eligible for a renewal date extension because the customer has access through an organization or group.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/assignedsubscriptionextensionineligibleerror">AssignedSubscriptionExtensionIneligibleError</a>
     **/
    ASSIGNED_SUBSCRIPTION_EXTENSION_INELIGIBLE(4030028L),

    /**
     * An error that indicates the App Store account wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accountnotfounderror">AccountNotFoundError</a>
     **/
    ACCOUNT_NOT_FOUND(4040001L),

    /**
     * An error response that indicates the App Store account wasn’t found, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accountnotfoundretryableerror">AccountNotFoundRetryableError</a>
     **/
    ACCOUNT_NOT_FOUND_RETRYABLE(4040002L),

    /**
     * An error that indicates the app wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appnotfounderror">AppNotFoundError</a>
     **/
    APP_NOT_FOUND(4040003L),

    /**
     * An error response that indicates the app wasn’t found, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appnotfoundretryableerror">AppNotFoundRetryableError</a>
     **/
    APP_NOT_FOUND_RETRYABLE(4040004L),

    /**
     * An error that indicates an original transaction identifier wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originaltransactionidnotfounderror">OriginalTransactionIdNotFoundError</a>
     **/
    ORIGINAL_TRANSACTION_ID_NOT_FOUND(4040005L),

    /**
     * An error response that indicates the original transaction identifier wasn’t found, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/originaltransactionidnotfoundretryableerror">OriginalTransactionIdNotFoundRetryableError</a>
     **/
    ORIGINAL_TRANSACTION_ID_NOT_FOUND_RETRYABLE(4040006L),

    /**
     * An error that indicates the App Store server couldn’t find a notifications URL for your app in the environment.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/servernotificationurlnotfounderror">ServerNotificationURLNotFoundError</a>
     **/
    SERVER_NOTIFICATION_URL_NOT_FOUND(4040007L),

    /**
     * An error that indicates the test notification token is expired or the test notification status isn’t available.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/testnotificationnotfounderror">TestNotificationNotFoundError</a>
     **/
    TEST_NOTIFICATION_NOT_FOUND(4040008L),

    /**
     * An error that indicates the server didn’t find a subscription-renewal-date extension request for the request identifier and product identifier you provided.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/statusrequestnotfounderror">StatusRequestNotFoundError</a>
     **/
    STATUS_REQUEST_NOT_FOUND(4040009L),

    /**
     * An error that indicates a transaction identifier wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/transactionidnotfounderror">TransactionIdNotFoundError</a>
     **/
    TRANSACTION_ID_NOT_FOUND(4040010L),

    /**
     * An error that indicates the system can’t find the image identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imagenotfounderror">ImageNotFoundError</a>
     **/
    IMAGE_NOT_FOUND(4040014L),

    /**
     * An error that indicates the system can’t find the message identifier.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messagenotfounderror">MessageNotFoundError</a>
     **/
    MESSAGE_NOT_FOUND(4040015L),

    /**
     * Product not found.
     *
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/productnotfounderror">ProductNotFoundError</a>
     **/
    PRODUCT_NOT_FOUND(4040016L),

    /**
     * An error the API returns if the service can’t find the specified test run.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/performancetestrunnotfounderror">PerformanceTestRunNotFoundError</a>
     **/
    PERFORMANCE_TEST_RUN_NOT_FOUND(4040018L),

    /**
     * An error response that indicates an app transaction doesn’t exist for the specified customer.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/apptransactiondoesnotexisterror">AppTransactionDoesNotExistError</a>
     **/
    APP_TRANSACTION_DOES_NOT_EXIST(4040019L),

    /**
     * An error that indicates a default message isn’t configured.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/defaultmessagenotfounderror">DefaultMessageNotFoundError</a>
     **/
    DEFAULT_MESSAGE_NOT_FOUND(4040020L),

    /**
     * An error that indicates that the URL for your endpoint isn’t configured.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/realtimeurlnotfounderror">RealtimeUrlNotFoundError</a>
     **/
    REALTIME_URL_NOT_FOUND(4040021L),

    /**
     * An error that indicates the group wasn’t found.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/groupnotfounderror">GroupNotFoundError</a>
     **/
    GROUP_NOT_FOUND(4040022L),

    /**
     * An error that indicates the image identifier already exists.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imagealreadyexistserror">ImageAlreadyExistsError</a>
     **/
    IMAGE_ALREADY_EXISTS(4090000L),

    /**
     * An error that indicates the message identifier already exists.
     *
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messagealreadyexistserror">MessageAlreadyExistsError</a>
     **/
    MESSAGE_ALREADY_EXISTS(4090001L),

    /**
     * An error that indicates the request exceeded the rate limit.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/ratelimitexceedederror">RateLimitExceededError</a>
     **/
    RATE_LIMIT_EXCEEDED(4290000L),

    /**
     * An error that indicates a general internal error.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalinternalerror">GeneralInternalError</a>
     **/
    GENERAL_INTERNAL(5000000L),

    /**
     * An error response that indicates an unknown error occurred, but you can try again.
     *
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/generalinternalretryableerror">GeneralInternalRetryableError</a>
     **/
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
