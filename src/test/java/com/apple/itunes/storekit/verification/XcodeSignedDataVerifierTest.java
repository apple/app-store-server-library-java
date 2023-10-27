// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import com.apple.itunes.storekit.model.AppTransaction;
import com.apple.itunes.storekit.model.AutoRenewStatus;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.InAppOwnershipType;
import com.apple.itunes.storekit.model.JWSRenewalInfoDecodedPayload;
import com.apple.itunes.storekit.model.JWSTransactionDecodedPayload;
import com.apple.itunes.storekit.model.OfferType;
import com.apple.itunes.storekit.model.TransactionReason;
import com.apple.itunes.storekit.model.Type;
import com.apple.itunes.storekit.util.TestingUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

public class XcodeSignedDataVerifierTest {

    private final String XCODE_BUNDLE_ID = "com.example.naturelab.backyardbirds.example";

    @Test
    public void testXcodeSignedAppTransaction() throws IOException, VerificationException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.XCODE, XCODE_BUNDLE_ID);
        String encodedAppTransaction = TestingUtility.readFile("xcode/xcode-signed-app-transaction");

        AppTransaction appTransaction = verifier.verifyAndDecodeAppTransaction(encodedAppTransaction);

        Assertions.assertNotNull(appTransaction);
        Assertions.assertNull(appTransaction.getAppAppleId());
        Assertions.assertEquals(XCODE_BUNDLE_ID, appTransaction.getBundleId());
        Assertions.assertEquals("1", appTransaction.getApplicationVersion());
        Assertions.assertNull(appTransaction.versionExternalIdentifier());
        Assertions.assertEquals(-62135769600000L, appTransaction.originalPurchaseDate());
        Assertions.assertEquals("1", appTransaction.getOriginalApplicationVersion());
        Assertions.assertEquals("cYUsXc53EbYc0pOeXG5d6/31LGHeVGf84sqSN0OrJi5u/j2H89WWKgS8N0hMsMlf", appTransaction.getDeviceVerification());
        Assertions.assertEquals(UUID.fromString("48c8b92d-ce0d-4229-bedf-e61b4f9cfc92"), appTransaction.getDeviceVerificationNonce());
        Assertions.assertNull(appTransaction.getPreorderDate());
    }

    @Test
    public void testXcodeSignedTransaction() throws IOException, VerificationException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.XCODE, XCODE_BUNDLE_ID);
        String encodedTransactino = TestingUtility.readFile("xcode/xcode-signed-transaction");

        JWSTransactionDecodedPayload transaction = verifier.verifyAndDecodeTransaction(encodedTransactino);

        Assertions.assertEquals("0", transaction.getOriginalTransactionId());
        Assertions.assertEquals("0", transaction.getTransactionId());
        Assertions.assertEquals("0", transaction.getWebOrderLineItemId());
        Assertions.assertEquals(XCODE_BUNDLE_ID, transaction.getBundleId());
        Assertions.assertEquals("pass.premium", transaction.getProductId());
        Assertions.assertEquals("6F3A93AB", transaction.getSubscriptionGroupIdentifier());
        Assertions.assertEquals(1697679936049L, transaction.getPurchaseDate());
        Assertions.assertEquals(1697679936049L, transaction.getOriginalPurchaseDate());
        Assertions.assertEquals(1700358336049L, transaction.getExpiresDate());
        Assertions.assertEquals(1, transaction.getQuantity());
        Assertions.assertEquals(Type.AUTO_RENEWABLE_SUBSCRIPTION, transaction.getType());
        Assertions.assertNull(transaction.getAppAccountToken());
        Assertions.assertEquals(InAppOwnershipType.PURCHASED, transaction.getInAppOwnershipType());
        Assertions.assertEquals(1697679936056L, transaction.getSignedDate());
        Assertions.assertNull(transaction.getRevocationReason());
        Assertions.assertNull(transaction.getRevocationDate());
        Assertions.assertFalse(transaction.getIsUpgraded());
        Assertions.assertEquals(OfferType.INTRODUCTORY_OFFER, transaction.getOfferType());
        Assertions.assertNull(transaction.getOfferIdentifier());
        Assertions.assertEquals(Environment.XCODE, transaction.getEnvironment());
        Assertions.assertEquals("USA", transaction.getStorefront());
        Assertions.assertEquals("143441", transaction.getStorefrontId());
        Assertions.assertEquals(TransactionReason.PURCHASE, transaction.getTransactionReason());
    }

    @Test
    public void testXcodeSignedRenewalInfo() throws IOException, VerificationException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.XCODE, XCODE_BUNDLE_ID);
        String encodedRenewalInfo = TestingUtility.readFile("xcode/xcode-signed-renewal-info");

        JWSRenewalInfoDecodedPayload renewalInfo = verifier.verifyAndDecodeRenewalInfo(encodedRenewalInfo);

        System.out.println(renewalInfo);
        Assertions.assertNull(renewalInfo.getExpirationIntent());
        Assertions.assertEquals("0", renewalInfo.getOriginalTransactionId());
        Assertions.assertEquals("pass.premium", renewalInfo.getAutoRenewProductId());
        Assertions.assertEquals("pass.premium", renewalInfo.getProductId());
        Assertions.assertEquals(AutoRenewStatus.ON, renewalInfo.getAutoRenewStatus());
        Assertions.assertNull(renewalInfo.getIsInBillingRetryPeriod());
        Assertions.assertNull(renewalInfo.getPriceIncreaseStatus());
        Assertions.assertNull(renewalInfo.getGracePeriodExpiresDate());
        Assertions.assertNull(renewalInfo.getOfferType());
        Assertions.assertNull(renewalInfo.getOfferIdentifier());
        Assertions.assertEquals(1697679936711L, renewalInfo.getSignedDate());
        Assertions.assertEquals(Environment.XCODE, renewalInfo.getEnvironment());
        Assertions.assertEquals(1697679936049L, renewalInfo.getRecentSubscriptionStartDate());
        Assertions.assertEquals(1700358336049L, renewalInfo.getRenewalDate());
    }

    @Test
    public void testXcodeSignedAppTransactionWithProductionEnvironment() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.PRODUCTION, XCODE_BUNDLE_ID);
        String encodedAppTransaction = TestingUtility.readFile("xcode/xcode-signed-app-transaction");
        Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppTransaction(encodedAppTransaction));
    }
}
