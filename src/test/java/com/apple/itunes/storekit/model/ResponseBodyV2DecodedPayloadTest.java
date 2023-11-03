// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import com.apple.itunes.storekit.verification.VerificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.UUID;

public class ResponseBodyV2DecodedPayloadTest {

    @Test
    public void testNotificationDecoding() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, VerificationException {
        String signedNotification = SignedDataCreator.createSignedDataFromJson("models/signedNotification.json");

        ResponseBodyV2DecodedPayload notification = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeNotification(signedNotification);

        Assertions.assertEquals(NotificationTypeV2.SUBSCRIBED, notification.getNotificationType());
        Assertions.assertEquals("SUBSCRIBED", notification.getRawNotificationType());
        Assertions.assertEquals(Subtype.INITIAL_BUY, notification.getSubtype());
        Assertions.assertEquals("INITIAL_BUY", notification.getRawSubtype());
        Assertions.assertEquals("002e14d5-51f5-4503-b5a8-c3a1af68eb20", notification.getNotificationUUID());
        Assertions.assertEquals("2.0", notification.getVersion());
        Assertions.assertEquals(1698148900000L, notification.getSignedDate());
        Assertions.assertNotNull(notification.getData());
        Assertions.assertNull(notification.getSummary());
        Assertions.assertEquals(Environment.LOCAL_TESTING, notification.getData().getEnvironment());
        Assertions.assertEquals("LocalTesting", notification.getData().getRawEnvironment());
        Assertions.assertEquals(41234L, notification.getData().getAppAppleId());
        Assertions.assertEquals("com.example", notification.getData().getBundleId());
        Assertions.assertEquals("1.2.3", notification.getData().getBundleVersion());
        Assertions.assertEquals("signed_transaction_info_value", notification.getData().getSignedTransactionInfo());
        Assertions.assertEquals("signed_renewal_info_value", notification.getData().getSignedRenewalInfo());
        Assertions.assertEquals(Status.ACTIVE, notification.getData().getStatus());
        Assertions.assertEquals(1, notification.getData().getRawStatus());
    }

    @Test
    public void testSummaryNotificationDecoding() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, VerificationException {
        String signedNotification = SignedDataCreator.createSignedDataFromJson("models/signedSummaryNotification.json");

        ResponseBodyV2DecodedPayload notification = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeNotification(signedNotification);

        Assertions.assertEquals(NotificationTypeV2.RENEWAL_EXTENSION, notification.getNotificationType());
        Assertions.assertEquals("RENEWAL_EXTENSION", notification.getRawNotificationType());
        Assertions.assertEquals(Subtype.SUMMARY, notification.getSubtype());
        Assertions.assertEquals("SUMMARY", notification.getRawSubtype());
        Assertions.assertEquals("002e14d5-51f5-4503-b5a8-c3a1af68eb20", notification.getNotificationUUID());
        Assertions.assertEquals("2.0", notification.getVersion());
        Assertions.assertEquals(1698148900000L, notification.getSignedDate());
        Assertions.assertNull(notification.getData());
        Assertions.assertNotNull(notification.getSummary());
        Assertions.assertEquals(Environment.LOCAL_TESTING, notification.getSummary().getEnvironment());
        Assertions.assertEquals("LocalTesting", notification.getSummary().getRawEnvironment());
        Assertions.assertEquals(41234L, notification.getSummary().getAppAppleId());
        Assertions.assertEquals("com.example", notification.getSummary().getBundleId());
        Assertions.assertEquals("com.example.product", notification.getSummary().getProductId());
        Assertions.assertEquals("efb27071-45a4-4aca-9854-2a1e9146f265", notification.getSummary().getRequestIdentifier());
        Assertions.assertEquals(List.of("CAN", "USA", "MEX"), notification.getSummary().getStorefrontCountryCodes());
        Assertions.assertEquals(5, notification.getSummary().getSucceededCount());
        Assertions.assertEquals(2, notification.getSummary().getFailedCount());
    }
}
