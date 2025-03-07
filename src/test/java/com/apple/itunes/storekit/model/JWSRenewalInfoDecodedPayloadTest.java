// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import com.apple.itunes.storekit.verification.VerificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

public class JWSRenewalInfoDecodedPayloadTest {

    @Test
    public void testRenewalInfoDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedRenewalInfo = SignedDataCreator.createSignedDataFromJson("models/signedRenewalInfo.json");

        JWSRenewalInfoDecodedPayload renewalInfo = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeRenewalInfo(signedRenewalInfo);

        Assertions.assertEquals(ExpirationIntent.CUSTOMER_CANCELLED, renewalInfo.getExpirationIntent());
        Assertions.assertEquals(1, renewalInfo.getRawExpirationIntent());
        Assertions.assertEquals("12345", renewalInfo.getOriginalTransactionId());
        Assertions.assertEquals("com.example.product.2", renewalInfo.getAutoRenewProductId());
        Assertions.assertEquals("com.example.product", renewalInfo.getProductId());
        Assertions.assertEquals(AutoRenewStatus.ON, renewalInfo.getAutoRenewStatus());
        Assertions.assertEquals(1, renewalInfo.getRawAutoRenewStatus());
        Assertions.assertTrue(renewalInfo.getIsInBillingRetryPeriod());
        Assertions.assertEquals(PriceIncreaseStatus.CUSTOMER_HAS_NOT_RESPONDED, renewalInfo.getPriceIncreaseStatus());
        Assertions.assertEquals(0, renewalInfo.getRawPriceIncreaseStatus());
        Assertions.assertEquals(1698148900000L, renewalInfo.getGracePeriodExpiresDate());
        Assertions.assertEquals(OfferType.PROMOTIONAL_OFFER, renewalInfo.getOfferType());
        Assertions.assertEquals(2, renewalInfo.getRawOfferType());
        Assertions.assertEquals("abc.123", renewalInfo.getOfferIdentifier());
        Assertions.assertEquals(1698148800000L, renewalInfo.getSignedDate());
        Assertions.assertEquals(Environment.LOCAL_TESTING, renewalInfo.getEnvironment());
        Assertions.assertEquals("LocalTesting", renewalInfo.getRawEnvironment());
        Assertions.assertEquals(1698148800000L, renewalInfo.getRecentSubscriptionStartDate());
        Assertions.assertEquals(1698148850000L, renewalInfo.getRenewalDate());
        Assertions.assertEquals(9990, renewalInfo.getRenewalPrice());
        Assertions.assertEquals("USD", renewalInfo.getCurrency());
        Assertions.assertEquals(OfferDiscountType.PAY_AS_YOU_GO, renewalInfo.getOfferDiscountType());
        Assertions.assertEquals("PAY_AS_YOU_GO", renewalInfo.getRawOfferDiscountType());
        Assertions.assertEquals(List.of("eligible1", "eligible2"), renewalInfo.getEligibleWinBackOfferIds());
        Assertions.assertEquals("71134", renewalInfo.getAppTransactionId());
        Assertions.assertEquals("P1Y", renewalInfo.getOfferPeriod());
        Assertions.assertEquals(UUID.fromString("7e3fb20b-4cdb-47cc-936d-99d65f608138"), renewalInfo.getAppAccountToken());
    }
}
