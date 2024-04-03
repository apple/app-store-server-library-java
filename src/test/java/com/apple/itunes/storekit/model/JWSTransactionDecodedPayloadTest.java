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
    }
}
