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

public class AppTransactionTest {

    @Test
    public void testAppTransactionDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedAppTransaction = SignedDataCreator.createSignedDataFromJson("models/appTransaction.json");

        AppTransaction appTransaction = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeAppTransaction(signedAppTransaction);

        Assertions.assertEquals(Environment.LOCAL_TESTING, appTransaction.getReceiptType());
        Assertions.assertEquals("LocalTesting", appTransaction.getRawReceiptType());
        Assertions.assertEquals(531412, appTransaction.getAppAppleId());
        Assertions.assertEquals("com.example", appTransaction.getBundleId());
        Assertions.assertEquals("1.2.3", appTransaction.getApplicationVersion());
        Assertions.assertEquals(512, appTransaction.getVersionExternalIdentifier());
        Assertions.assertEquals(1698148900000L, appTransaction.getReceiptCreationDate());
        Assertions.assertEquals(1698148800000L, appTransaction.getOriginalPurchaseDate());
        Assertions.assertEquals("1.1.2", appTransaction.getOriginalApplicationVersion());
        Assertions.assertEquals("device_verification_value", appTransaction.getDeviceVerification());
        Assertions.assertEquals(UUID.fromString("48ccfa42-7431-4f22-9908-7e88983e105a"), appTransaction.getDeviceVerificationNonce());
        Assertions.assertEquals(1698148700000L, appTransaction.getPreorderDate());
    }
}
