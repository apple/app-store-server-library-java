// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class APIErrorTest {

    @Test
    public void testErrorCodesAreUnique() {
        Set<Long> errorCodes = new HashSet<>();
        for (APIError apiError : APIError.values()) {
            Assertions.assertTrue(errorCodes.add(apiError.errorCode()));
        }
    }

    @Test
    public void testFetchErrorResponseFromErrorCode() {
        for (APIError apiError : APIError.values()) {
            Assertions.assertEquals(apiError, APIError.fetchErrorResponseFromErrorCode(apiError.errorCode()));
        }
        Assertions.assertNull(APIError.fetchErrorResponseFromErrorCode(9990000L));
    }

    @Test
    public void testAppStoreServerAPIErrorCodes() {
        Assertions.assertEquals(APIError.INVALID_LIMIT, APIError.fetchErrorResponseFromErrorCode(4000004L));
        Assertions.assertEquals(APIError.INVALID_REFUND_PREFERENCE, APIError.fetchErrorResponseFromErrorCode(4000044L));
        Assertions.assertEquals(APIError.CONSUMPTION_PERCENTAGE_OUT_OF_RANGE, APIError.fetchErrorResponseFromErrorCode(4000207L));
        Assertions.assertEquals(APIError.UNDELIVERED_CONSUMPTION_PERCENTAGE_NON_ZERO, APIError.fetchErrorResponseFromErrorCode(4000208L));
        Assertions.assertEquals(APIError.CONSUMPTION_PERCENTAGE_AUTO_RENEWABLE_SUBSCRIPTION, APIError.fetchErrorResponseFromErrorCode(4000209L));
        Assertions.assertEquals(APIError.ADVANCED_COMMERCE_TRANSACTION_NOT_SUPPORTED, APIError.fetchErrorResponseFromErrorCode(4000210L));
        Assertions.assertEquals(APIError.INVALID_GROUP_ID, APIError.fetchErrorResponseFromErrorCode(4000225L));
        Assertions.assertEquals(APIError.INVALID_ASSIGNED_TRANSACTION_NOT_SUPPORTED, APIError.fetchErrorResponseFromErrorCode(4000227L));
        Assertions.assertEquals(APIError.ASSIGNED_SUBSCRIPTION_EXTENSION_INELIGIBLE, APIError.fetchErrorResponseFromErrorCode(4030028L));
        Assertions.assertEquals(APIError.GROUP_NOT_FOUND, APIError.fetchErrorResponseFromErrorCode(4040022L));
    }

    @Test
    public void testOneNamePerErrorCode() {
        Assertions.assertEquals(APIError.APP_TRANSACTION_ID_NOT_SUPPORTED, APIError.fetchErrorResponseFromErrorCode(4000048L));
        Assertions.assertEquals(APIError.INVALID_APP_ACCOUNT_TOKEN_UUID, APIError.fetchErrorResponseFromErrorCode(4000183L));
        Assertions.assertEquals(APIError.FAMILY_TRANSACTION_NOT_SUPPORTED, APIError.fetchErrorResponseFromErrorCode(4000185L));
        Assertions.assertEquals(APIError.TRANSACTION_ID_IS_NOT_ORIGINAL_TRANSACTION_ID, APIError.fetchErrorResponseFromErrorCode(4000187L));
        Assertions.assertEquals(APIError.APP_TRANSACTION_DOES_NOT_EXIST, APIError.fetchErrorResponseFromErrorCode(4040019L));
        for (APIError apiError : APIError.values()) {
            Assertions.assertFalse(apiError.name().endsWith("_ERROR"), apiError.name());
        }
    }

    @Test
    public void testAdvancedCommerceAPIErrorCodes() {
        Assertions.assertEquals(APIError.INVALID_CURRENCY, APIError.fetchErrorResponseFromErrorCode(4000053L));
        Assertions.assertEquals(APIError.NULL_REQUEST_INFO, APIError.fetchErrorResponseFromErrorCode(4000079L));
        Assertions.assertEquals(APIError.REPEATED_REQUEST_REFERENCE_ID, APIError.fetchErrorResponseFromErrorCode(4000097L));
        Assertions.assertEquals(APIError.REMOVAL_ALL_NOT_ALLOWED, APIError.fetchErrorResponseFromErrorCode(4000168L));
        Assertions.assertEquals(APIError.SUBSCRIPTION_ALREADY_MIGRATED, APIError.fetchErrorResponseFromErrorCode(4000176L));
        Assertions.assertEquals(APIError.REVOKE_ON_INACTIVE_SUBSCRIPTION, APIError.fetchErrorResponseFromErrorCode(4000186L));
        Assertions.assertEquals(APIError.FREE_TRIAL_OFFER_MUST_USE_PERIOD_COUNT_OF_ONE, APIError.fetchErrorResponseFromErrorCode(4000223L));
        Assertions.assertEquals(APIError.UNAUTHORIZED, APIError.fetchErrorResponseFromErrorCode(4010000L));
        Assertions.assertEquals(APIError.SUBSCRIPTION_DOES_NOT_EXIST, APIError.fetchErrorResponseFromErrorCode(4030008L));
        Assertions.assertEquals(APIError.MIGRATION_NOT_ALLOWED_WHEN_PRICE_INCREASE_COMMUNICATED, APIError.fetchErrorResponseFromErrorCode(4030027L));
        Assertions.assertEquals(APIError.PRODUCT_NOT_FOUND, APIError.fetchErrorResponseFromErrorCode(4040016L));
    }
}
