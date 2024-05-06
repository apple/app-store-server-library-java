// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import com.apple.itunes.storekit.verification.SignedDataVerifier;
import com.apple.itunes.storekit.verification.VerificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

public class ResponseBodyV2DecodedPayloadTest {

    @Test
    public void testNotificationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
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
        Assertions.assertNull(notification.getExternalPurchaseToken());
        Assertions.assertEquals(Environment.LOCAL_TESTING, notification.getData().getEnvironment());
        Assertions.assertEquals("LocalTesting", notification.getData().getRawEnvironment());
        Assertions.assertEquals(41234L, notification.getData().getAppAppleId());
        Assertions.assertEquals("com.example", notification.getData().getBundleId());
        Assertions.assertEquals("1.2.3", notification.getData().getBundleVersion());
        Assertions.assertEquals("signed_transaction_info_value", notification.getData().getSignedTransactionInfo());
        Assertions.assertEquals("signed_renewal_info_value", notification.getData().getSignedRenewalInfo());
        Assertions.assertEquals(Status.ACTIVE, notification.getData().getStatus());
        Assertions.assertEquals(1, notification.getData().getRawStatus());
        Assertions.assertNull(notification.getData().getConsumptionRequestReason());
        Assertions.assertNull(notification.getData().getRawConsumptionRequestReason());
    }

    @Test
    public void testConsumptionRequestNotificationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedNotification = SignedDataCreator.createSignedDataFromJson("models/signedConsumptionRequestNotification.json");

        ResponseBodyV2DecodedPayload notification = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeNotification(signedNotification);

        Assertions.assertEquals(NotificationTypeV2.CONSUMPTION_REQUEST, notification.getNotificationType());
        Assertions.assertEquals("CONSUMPTION_REQUEST", notification.getRawNotificationType());
        Assertions.assertNull(notification.getSubtype());
        Assertions.assertNull(notification.getRawSubtype());
        Assertions.assertEquals("002e14d5-51f5-4503-b5a8-c3a1af68eb20", notification.getNotificationUUID());
        Assertions.assertEquals("2.0", notification.getVersion());
        Assertions.assertEquals(1698148900000L, notification.getSignedDate());
        Assertions.assertNotNull(notification.getData());
        Assertions.assertNull(notification.getSummary());
        Assertions.assertNull(notification.getExternalPurchaseToken());
        Assertions.assertEquals(Environment.LOCAL_TESTING, notification.getData().getEnvironment());
        Assertions.assertEquals("LocalTesting", notification.getData().getRawEnvironment());
        Assertions.assertEquals(41234L, notification.getData().getAppAppleId());
        Assertions.assertEquals("com.example", notification.getData().getBundleId());
        Assertions.assertEquals("1.2.3", notification.getData().getBundleVersion());
        Assertions.assertEquals("signed_transaction_info_value", notification.getData().getSignedTransactionInfo());
        Assertions.assertEquals("signed_renewal_info_value", notification.getData().getSignedRenewalInfo());
        Assertions.assertEquals(Status.ACTIVE, notification.getData().getStatus());
        Assertions.assertEquals(1, notification.getData().getRawStatus());
        Assertions.assertEquals(ConsumptionRequestReason.UNINTENDED_PURCHASE, notification.getData().getConsumptionRequestReason());
        Assertions.assertEquals("UNINTENDED_PURCHASE", notification.getData().getRawConsumptionRequestReason());
    }

    @Test
    public void testSummaryNotificationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
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
        Assertions.assertNull(notification.getExternalPurchaseToken());
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

    @Test
    public void testExternalPurchaseTokenNotificationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedNotification = SignedDataCreator.createSignedDataFromJson("models/signedExternalPurchaseTokenNotification.json");

        SignedDataVerifier verifier = new SignedDataVerifier(Set.of(new ByteArrayInputStream(TestingUtility.readBytes("certs/testCA.der"))), "com.example", 1234L, Environment.LOCAL_TESTING, false) {
            @Override
            protected void verifyNotification(String bundleId, Long appAppleId, Environment notificationEnv) {
                Assertions.assertEquals("com.example", bundleId);
                Assertions.assertEquals(55555, appAppleId);
                Assertions.assertEquals(Environment.PRODUCTION, notificationEnv);
            }
        };

        ResponseBodyV2DecodedPayload notification = verifier.verifyAndDecodeNotification(signedNotification);

        Assertions.assertEquals(NotificationTypeV2.EXTERNAL_PURCHASE_TOKEN, notification.getNotificationType());
        Assertions.assertEquals("EXTERNAL_PURCHASE_TOKEN", notification.getRawNotificationType());
        Assertions.assertEquals(Subtype.UNREPORTED, notification.getSubtype());
        Assertions.assertEquals("UNREPORTED", notification.getRawSubtype());
        Assertions.assertEquals("002e14d5-51f5-4503-b5a8-c3a1af68eb20", notification.getNotificationUUID());
        Assertions.assertEquals("2.0", notification.getVersion());
        Assertions.assertEquals(1698148900000L, notification.getSignedDate());
        Assertions.assertNull(notification.getData());
        Assertions.assertNull(notification.getSummary());
        Assertions.assertNotNull(notification.getExternalPurchaseToken());
        Assertions.assertEquals("b2158121-7af9-49d4-9561-1f588205523e", notification.getExternalPurchaseToken().getExternalPurchaseId());
        Assertions.assertEquals(1698148950000L, notification.getExternalPurchaseToken().getTokenCreationDate());
        Assertions.assertEquals(55555L, notification.getExternalPurchaseToken().getAppAppleId());
        Assertions.assertEquals("com.example", notification.getExternalPurchaseToken().getBundleId());
    }

    @Test
    public void testExternalPurchaseTokenSandboxNotificationDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedNotification = SignedDataCreator.createSignedDataFromJson("models/signedExternalPurchaseTokenSandboxNotification.json");

        SignedDataVerifier verifier = new SignedDataVerifier(Set.of(new ByteArrayInputStream(TestingUtility.readBytes("certs/testCA.der"))), "com.example", 1234L, Environment.LOCAL_TESTING, false) {
            @Override
            protected void verifyNotification(String bundleId, Long appAppleId, Environment notificationEnv) {
                Assertions.assertEquals("com.example", bundleId);
                Assertions.assertEquals(55555, appAppleId);
                Assertions.assertEquals(Environment.SANDBOX, notificationEnv);
            }
        };

        ResponseBodyV2DecodedPayload notification = verifier.verifyAndDecodeNotification(signedNotification);

        Assertions.assertEquals(NotificationTypeV2.EXTERNAL_PURCHASE_TOKEN, notification.getNotificationType());
        Assertions.assertEquals("EXTERNAL_PURCHASE_TOKEN", notification.getRawNotificationType());
        Assertions.assertEquals(Subtype.UNREPORTED, notification.getSubtype());
        Assertions.assertEquals("UNREPORTED", notification.getRawSubtype());
        Assertions.assertEquals("002e14d5-51f5-4503-b5a8-c3a1af68eb20", notification.getNotificationUUID());
        Assertions.assertEquals("2.0", notification.getVersion());
        Assertions.assertEquals(1698148900000L, notification.getSignedDate());
        Assertions.assertNull(notification.getData());
        Assertions.assertNull(notification.getSummary());
        Assertions.assertNotNull(notification.getExternalPurchaseToken());
        Assertions.assertEquals("SANDBOX_b2158121-7af9-49d4-9561-1f588205523e", notification.getExternalPurchaseToken().getExternalPurchaseId());
        Assertions.assertEquals(1698148950000L, notification.getExternalPurchaseToken().getTokenCreationDate());
        Assertions.assertEquals(55555L, notification.getExternalPurchaseToken().getAppAppleId());
        Assertions.assertEquals("com.example", notification.getExternalPurchaseToken().getBundleId());
    }
}
