// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import com.apple.itunes.storekit.model.AdvancedCommerceTransactionInfo;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.JWSRenewalInfoDecodedPayload;
import com.apple.itunes.storekit.model.JWSTransactionDecodedPayload;
import com.apple.itunes.storekit.model.NotificationTypeV2;
import com.apple.itunes.storekit.model.ResponseBodyV2DecodedPayload;
import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SignedDataVerifierTest {

    @Test
    public void testAppStoreServerNotificationDecoding() throws VerificationException, IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.SANDBOX, "com.example");
        ResponseBodyV2DecodedPayload notification = verifier.verifyAndDecodeNotification(TestingUtility.readFile("mock_signed_data/testNotification"));
        Assertions.assertEquals(NotificationTypeV2.TEST, notification.getNotificationType());
    }

    @Test
    public void testMissingX5CHeader() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.SANDBOX, "com.example");
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(TestingUtility.readFile("mock_signed_data/missingX5CHeaderClaim")));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    @Test
    public void testWrongBundleIdForServerNotification() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.SANDBOX, "com.example");
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(TestingUtility.readFile("mock_signed_data/wrongBundleId")));
        Assertions.assertEquals(VerificationStatus.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testWrongAppAppleIdForNotification() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.PRODUCTION, "com.example", 1235L);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(TestingUtility.readFile("mock_signed_data/testNotification")));
        Assertions.assertEquals(VerificationStatus.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testWrongBundleIdForTransaction() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.SANDBOX, "com.example.x");
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeTransaction(TestingUtility.readFile("mock_signed_data/transactionInfo")));
        Assertions.assertEquals(VerificationStatus.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testWrongEnvironmentForServerNotification() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.PRODUCTION, "com.example");
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification(TestingUtility.readFile("mock_signed_data/testNotification")));
        Assertions.assertEquals(VerificationStatus.INVALID_ENVIRONMENT, exception.getStatus());
    }

    @Test
    public void testRenewalInfoDecoding() throws VerificationException, IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.SANDBOX, "com.example");
        JWSRenewalInfoDecodedPayload renewalInfo = verifier.verifyAndDecodeRenewalInfo(TestingUtility.readFile("mock_signed_data/renewalInfo"));
        Assertions.assertEquals(Environment.SANDBOX, renewalInfo.getEnvironment());
    }

    @Test
    public void testTransactionInfoDecoding() throws VerificationException, IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier(Environment.SANDBOX, "com.example");
        JWSTransactionDecodedPayload transaction = verifier.verifyAndDecodeTransaction(TestingUtility.readFile("mock_signed_data/transactionInfo"));
        Assertions.assertEquals(Environment.SANDBOX, transaction.getEnvironment());
    }

    @Test
    public void testMalformedJWTWithTooManyParts() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification("a.b.c.d"));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    @Test
    public void testMalformedJWTWithMalformedData() throws IOException {
        SignedDataVerifier verifier = TestingUtility.getSignedPayloadVerifier();
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeNotification("a.b.c"));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    /**
     * The payload of a JWS is always UTF-8 encoded, so decoding it must not depend on the default charset of the JVM.
     * The expected values below are written as escape sequences so that this test does not depend on the encoding
     * used to compile it either.
     */
    @Test
    public void testNonAsciiDataDecodingIsIndependentOfTheDefaultCharset() throws VerificationException, IOException, NoSuchAlgorithmException {
        String signedTransaction = SignedDataCreator.createSignedDataFromJson("models/signedTransactionWithNonAsciiData.json");

        JWSTransactionDecodedPayload transaction = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeTransaction(signedTransaction);

        AdvancedCommerceTransactionInfo advancedCommerceInfo = transaction.getAdvancedCommerceInfo();
        Assertions.assertEquals("Abonnement Caf\u00e9 \u2014 5,99 \u20ac par mois", advancedCommerceInfo.getDescriptors().getDescription());
        Assertions.assertEquals("Caf\u00e9 Premium", advancedCommerceInfo.getDescriptors().getDisplayName());
        Assertions.assertEquals("\u30d7\u30ec\u30df\u30a2\u30e0\u6a5f\u80fd", advancedCommerceInfo.getItems().get(0).getDescription());
        Assertions.assertEquals("\u30d7\u30ec\u30df\u30a2\u30e0", advancedCommerceInfo.getItems().get(0).getDisplayName());
    }
}
