// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import com.apple.itunes.storekit.verification.VerificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class JWSTransactionDecodedPayloadTest {

    @Test
    public void testTransactionDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedTransaction = SignedDataCreator.createSignedDataFromJson("models/signedTransaction.json");

        JWSTransactionDecodedPayload transaction = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeTransaction(signedTransaction);

        Assertions.assertEquals("12345", transaction.getOriginalTransactionId());
        Assertions.assertEquals("23456", transaction.getTransactionId());
        Assertions.assertEquals("34343", transaction.getWebOrderLineItemId());
        Assertions.assertEquals("com.example", transaction.getBundleId());
        Assertions.assertEquals("com.example.product", transaction.getProductId());
        Assertions.assertEquals("55555", transaction.getSubscriptionGroupIdentifier());
        Assertions.assertEquals(1698148800000L, transaction.getOriginalPurchaseDate());
        Assertions.assertEquals(1698148900000L, transaction.getPurchaseDate());
        Assertions.assertEquals(1698148950000L, transaction.getRevocationDate());
        Assertions.assertEquals(1698149000000L, transaction.getExpiresDate());
        Assertions.assertEquals(1, transaction.getQuantity());
        Assertions.assertEquals(Type.AUTO_RENEWABLE_SUBSCRIPTION, transaction.getType());
        Assertions.assertEquals("Auto-Renewable Subscription", transaction.getRawType());
        Assertions.assertEquals(UUID.fromString("7e3fb20b-4cdb-47cc-936d-99d65f608138"), transaction.getAppAccountToken());
        Assertions.assertEquals(InAppOwnershipType.PURCHASED, transaction.getInAppOwnershipType());
        Assertions.assertEquals("PURCHASED", transaction.getRawInAppOwnershipType());
        Assertions.assertEquals(1698148900000L, transaction.getSignedDate());
        Assertions.assertEquals(RevocationReason.REFUNDED_DUE_TO_ISSUE, transaction.getRevocationReason());
        Assertions.assertEquals(1, transaction.getRawRevocationReason());
        Assertions.assertEquals("abc.123", transaction.getOfferIdentifier());
        Assertions.assertTrue(transaction.getIsUpgraded());
        Assertions.assertEquals(OfferType.INTRODUCTORY_OFFER, transaction.getOfferType());
        Assertions.assertEquals(1, transaction.getRawOfferType());
        Assertions.assertEquals("USA", transaction.getStorefront());
        Assertions.assertEquals("143441", transaction.getStorefrontId());
        Assertions.assertEquals(TransactionReason.PURCHASE, transaction.getTransactionReason());
        Assertions.assertEquals("PURCHASE", transaction.getRawTransactionReason());
        Assertions.assertEquals(Environment.LOCAL_TESTING, transaction.getEnvironment());
        Assertions.assertEquals("LocalTesting", transaction.getRawEnvironment());
        Assertions.assertEquals(10990, transaction.getPrice());
        Assertions.assertEquals("USD", transaction.getCurrency());
        Assertions.assertEquals(OfferDiscountType.PAY_AS_YOU_GO, transaction.getOfferDiscountType());
        Assertions.assertEquals("PAY_AS_YOU_GO", transaction.getRawOfferDiscountType());
        Assertions.assertEquals("71134", transaction.getAppTransactionId());
        Assertions.assertEquals("P1Y", transaction.getOfferPeriod());
        Assertions.assertNotNull(transaction.getAdvancedCommerceInfo());
        AdvancedCommerceTransactionInfo info = transaction.getAdvancedCommerceInfo();
        Assertions.assertNotNull(info.getDescriptors());
        Assertions.assertEquals("Premium Plan", info.getDescriptors().getDescription());
        Assertions.assertEquals("Premium", info.getDescriptors().getDisplayName());
        Assertions.assertEquals(1500L, info.getEstimatedTax());
        Assertions.assertEquals(AdvancedCommercePeriod.P1M, info.getPeriod());
        Assertions.assertEquals("P1M", info.getRawPeriod());
        Assertions.assertEquals("ref-12345", info.getRequestReferenceId());
        Assertions.assertEquals("TAX_CODE_1", info.getTaxCode());
        Assertions.assertEquals(8490L, info.getTaxExclusivePrice());
        Assertions.assertEquals("0.15", info.getTaxRate());
        Assertions.assertNotNull(info.getItems());
        Assertions.assertEquals(1, info.getItems().size());
        AdvancedCommerceTransactionItem acItem = info.getItems().get(0);
        Assertions.assertEquals("com.example.sku.premium", acItem.getSku());
        Assertions.assertEquals("Premium feature", acItem.getDescription());
        Assertions.assertEquals("Premium Feature", acItem.getDisplayName());
        Assertions.assertEquals(9990L, acItem.getPrice());
        Assertions.assertEquals(1698149200000L, acItem.getRevocationDate());
        Assertions.assertNotNull(acItem.getRefunds());
        Assertions.assertEquals(1, acItem.getRefunds().size());
        AdvancedCommerceRefund refund = acItem.getRefunds().get(0);
        Assertions.assertEquals(5000L, refund.getRefundAmount());
        Assertions.assertEquals(1698149100000L, refund.getRefundDate());
        Assertions.assertEquals(AdvancedCommerceRefundReason.FULFILLMENT_ISSUE, refund.getRefundReason());
        Assertions.assertEquals("FULFILLMENT_ISSUE", refund.getRawRefundReason());
        Assertions.assertEquals(AdvancedCommerceRefundType.PRORATED, refund.getRefundType());
        Assertions.assertEquals("PRORATED", refund.getRawRefundType());
        Assertions.assertEquals(BillingPlanType.MONTHLY, transaction.getBillingPlanType());
        Assertions.assertEquals("MONTHLY", transaction.getRawBillingPlanType());
        Assertions.assertNotNull(transaction.getCommitmentInfo());
        TransactionCommitmentInfo commitment = transaction.getCommitmentInfo();
        Assertions.assertEquals(3, commitment.getBillingPeriodNumber());
        Assertions.assertEquals(1698150000000L, commitment.getCommitmentExpiresDate());
        Assertions.assertEquals(119880L, commitment.getCommitmentPrice());
        Assertions.assertEquals(12, commitment.getTotalBillingPeriods());
        Assertions.assertEquals("11111", transaction.getPreviousOriginalTransactionId());
        Assertions.assertNull(transaction.getUnknownFields());
    }

    @Test
    public void testTransactionWithRevocationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedTransaction = SignedDataCreator.createSignedDataFromJson("models/signedTransactionWithRevocation.json");

        JWSTransactionDecodedPayload transaction = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeTransaction(signedTransaction);

        Assertions.assertEquals("12345", transaction.getOriginalTransactionId());
        Assertions.assertEquals("23456", transaction.getTransactionId());
        Assertions.assertEquals("34343", transaction.getWebOrderLineItemId());
        Assertions.assertEquals("com.example", transaction.getBundleId());
        Assertions.assertEquals("com.example.product", transaction.getProductId());
        Assertions.assertEquals("55555", transaction.getSubscriptionGroupIdentifier());
        Assertions.assertEquals(1698148800000L, transaction.getOriginalPurchaseDate());
        Assertions.assertEquals(1698148900000L, transaction.getPurchaseDate());
        Assertions.assertEquals(1698148950000L, transaction.getRevocationDate());
        Assertions.assertEquals(1698149000000L, transaction.getExpiresDate());
        Assertions.assertEquals(1, transaction.getQuantity());
        Assertions.assertEquals(Type.AUTO_RENEWABLE_SUBSCRIPTION, transaction.getType());
        Assertions.assertEquals("Auto-Renewable Subscription", transaction.getRawType());
        Assertions.assertEquals(UUID.fromString("7e3fb20b-4cdb-47cc-936d-99d65f608138"), transaction.getAppAccountToken());
        Assertions.assertEquals(InAppOwnershipType.PURCHASED, transaction.getInAppOwnershipType());
        Assertions.assertEquals("PURCHASED", transaction.getRawInAppOwnershipType());
        Assertions.assertEquals(1698148900000L, transaction.getSignedDate());
        Assertions.assertEquals(RevocationReason.REFUNDED_DUE_TO_ISSUE, transaction.getRevocationReason());
        Assertions.assertEquals(1, transaction.getRawRevocationReason());
        Assertions.assertEquals("abc.123", transaction.getOfferIdentifier());
        Assertions.assertTrue(transaction.getIsUpgraded());
        Assertions.assertEquals(OfferType.INTRODUCTORY_OFFER, transaction.getOfferType());
        Assertions.assertEquals(1, transaction.getRawOfferType());
        Assertions.assertEquals("USA", transaction.getStorefront());
        Assertions.assertEquals("143441", transaction.getStorefrontId());
        Assertions.assertEquals(TransactionReason.PURCHASE, transaction.getTransactionReason());
        Assertions.assertEquals("PURCHASE", transaction.getRawTransactionReason());
        Assertions.assertEquals(Environment.LOCAL_TESTING, transaction.getEnvironment());
        Assertions.assertEquals("LocalTesting", transaction.getRawEnvironment());
        Assertions.assertEquals(10990, transaction.getPrice());
        Assertions.assertEquals("USD", transaction.getCurrency());
        Assertions.assertEquals(OfferDiscountType.PAY_AS_YOU_GO, transaction.getOfferDiscountType());
        Assertions.assertEquals("PAY_AS_YOU_GO", transaction.getRawOfferDiscountType());
        Assertions.assertEquals("71134", transaction.getAppTransactionId());
        Assertions.assertEquals("P1Y", transaction.getOfferPeriod());
        Assertions.assertEquals(RevocationType.REFUND_PRORATED, transaction.getRevocationType());
        Assertions.assertEquals("REFUND_PRORATED", transaction.getRawRevocationType());
        Assertions.assertEquals(50000, transaction.getRevocationPercentage());
        Assertions.assertNull(transaction.getPreviousOriginalTransactionId());
    }

    @Test
    public void testTransactionWithAssignmentRevocationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedTransaction = SignedDataCreator.createSignedDataFromJson("models/signedTransactionWithAssignmentRevocation.json");

        JWSTransactionDecodedPayload transaction = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeTransaction(signedTransaction);

        Assertions.assertEquals("12345", transaction.getOriginalTransactionId());
        Assertions.assertEquals("23456", transaction.getTransactionId());
        Assertions.assertEquals(5, transaction.getQuantity());
        Assertions.assertEquals(InAppOwnershipType.ASSIGNED, transaction.getInAppOwnershipType());
        Assertions.assertEquals("ASSIGNED", transaction.getRawInAppOwnershipType());
        Assertions.assertEquals(1698148950000L, transaction.getRevocationDate());
        Assertions.assertEquals(RevocationType.ASSIGNMENT_REVOKE, transaction.getRevocationType());
        Assertions.assertEquals("ASSIGNMENT_REVOKE", transaction.getRawRevocationType());
        Assertions.assertNull(transaction.getRevocationReason());
        Assertions.assertNull(transaction.getRevocationPercentage());
        Assertions.assertNull(transaction.getUnknownFields());
    }
}
