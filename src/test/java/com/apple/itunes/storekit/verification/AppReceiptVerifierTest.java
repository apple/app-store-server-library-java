// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import com.apple.itunes.storekit.model.AppReceipt;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.InAppPurchaseReceipt;
import com.apple.itunes.storekit.util.ReceiptCreator;
import org.bouncycastle.asn1.DERUTF8String;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.cert.CertPathValidatorException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

public class AppReceiptVerifierTest {

    private static final String BUNDLE_ID = "com.example";
    private static final String APP_VERSION = "1.2.3";
    private static final String ORIGINAL_APP_VERSION = "1.0";
    private static final byte[] OPAQUE_VALUE = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final byte[] SHA1_HASH = {
            (byte) 0xa1, (byte) 0xb2, (byte) 0xc3, (byte) 0xd4, (byte) 0xe5, (byte) 0xf6, 0x07, 0x18,
            0x29, 0x3a, 0x4b, 0x5c, 0x6d, 0x7e, (byte) 0x8f, (byte) 0x90, 0x11, 0x22, 0x33, 0x44};
    private static final byte[] UNKNOWN_RECEIPT_ATTRIBUTE_VALUE = {0x0d, 0x0e, 0x0a, 0x0d};
    private static final byte[] UNKNOWN_IN_APP_ATTRIBUTE_VALUE = {0x0b, 0x0e, 0x0e, 0x0f};

    private static final String RECEIPT_CREATION_DATE = "2024-03-01T12:00:00Z";
    private static final long RECEIPT_CREATION_DATE_MILLIS = 1709294400000L;
    private static final String ORIGINAL_PURCHASE_DATE = "2023-11-15T08:30:00Z";
    private static final long ORIGINAL_PURCHASE_DATE_MILLIS = 1700037000000L;
    private static final String EXPIRATION_DATE = "2030-01-01T00:00:00Z";
    private static final long EXPIRATION_DATE_MILLIS = 1893456000000L;

    private static final String CONSUMABLE_PRODUCT_ID = "com.example.coins";
    private static final String CONSUMABLE_PURCHASE_DATE = "2024-01-15T12:00:00Z";
    private static final long CONSUMABLE_PURCHASE_DATE_MILLIS = 1705320000000L;
    private static final String CONSUMABLE_ORIGINAL_PURCHASE_DATE = "2024-01-10T09:00:00Z";
    private static final long CONSUMABLE_ORIGINAL_PURCHASE_DATE_MILLIS = 1704877200000L;

    private static final String SUBSCRIPTION_PRODUCT_ID = "com.example.subscription";
    private static final String SUBSCRIPTION_PURCHASE_DATE = "2024-02-01T09:30:00Z";
    private static final long SUBSCRIPTION_PURCHASE_DATE_MILLIS = 1706779800000L;
    private static final String SUBSCRIPTION_EXPIRES_DATE = "2030-02-01T09:30:00Z";
    private static final long SUBSCRIPTION_EXPIRES_DATE_MILLIS = 1896168600000L;
    private static final String SUBSCRIPTION_CANCELLATION_DATE = "2024-06-01T00:00:00Z";
    private static final long SUBSCRIPTION_CANCELLATION_DATE_MILLIS = 1717200000000L;

    private static final long DAY_IN_MILLIS = 86_400_000L;

    private static ReceiptCreator receiptCreator;
    private static byte[] sandboxReceipt;

    @BeforeAll
    public static void setup() throws Exception {
        receiptCreator = ReceiptCreator.createReceiptCreator();
        sandboxReceipt = receiptCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE));
    }

    @Test
    public void testAppReceiptDecoding() throws Exception {
        AppReceipt receipt = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false).verifyAndDecodeAppReceipt(encode(sandboxReceipt));

        Assertions.assertEquals("ProductionSandbox", receipt.getReceiptType());
        Assertions.assertEquals(BUNDLE_ID, receipt.getBundleId());
        Assertions.assertArrayEquals(new DERUTF8String(BUNDLE_ID).getEncoded(), receipt.getBundleIdBytes());
        Assertions.assertEquals(APP_VERSION, receipt.getApplicationVersion());
        Assertions.assertEquals(ORIGINAL_APP_VERSION, receipt.getOriginalApplicationVersion());
        Assertions.assertArrayEquals(OPAQUE_VALUE, receipt.getOpaqueValue());
        Assertions.assertArrayEquals(SHA1_HASH, receipt.getSha1Hash());
        Assertions.assertEquals(RECEIPT_CREATION_DATE_MILLIS, receipt.getReceiptCreationDate());
        Assertions.assertEquals(ORIGINAL_PURCHASE_DATE_MILLIS, receipt.getOriginalPurchaseDate());
        Assertions.assertEquals(EXPIRATION_DATE_MILLIS, receipt.getExpirationDate());
        Assertions.assertEquals(2, receipt.getInAppPurchases().size());

        InAppPurchaseReceipt consumable = receipt.getInAppPurchases().get(0);
        Assertions.assertEquals(1L, consumable.getQuantity());
        Assertions.assertEquals(CONSUMABLE_PRODUCT_ID, consumable.getProductId());
        Assertions.assertEquals("70000000000001", consumable.getTransactionId());
        Assertions.assertEquals("70000000000001", consumable.getOriginalTransactionId());
        Assertions.assertEquals(CONSUMABLE_PURCHASE_DATE_MILLIS, consumable.getPurchaseDate());
        Assertions.assertEquals(CONSUMABLE_ORIGINAL_PURCHASE_DATE_MILLIS, consumable.getOriginalPurchaseDate());
        Assertions.assertEquals(42L, consumable.getWebOrderLineItemId());

        InAppPurchaseReceipt subscription = receipt.getInAppPurchases().get(1);
        Assertions.assertEquals(1L, subscription.getQuantity());
        Assertions.assertEquals(SUBSCRIPTION_PRODUCT_ID, subscription.getProductId());
        Assertions.assertEquals("70000000000002", subscription.getTransactionId());
        Assertions.assertEquals("70000000000002", subscription.getOriginalTransactionId());
        Assertions.assertEquals(SUBSCRIPTION_PURCHASE_DATE_MILLIS, subscription.getPurchaseDate());
        Assertions.assertEquals(SUBSCRIPTION_PURCHASE_DATE_MILLIS, subscription.getOriginalPurchaseDate());
        Assertions.assertEquals(SUBSCRIPTION_EXPIRES_DATE_MILLIS, subscription.getExpiresDate());
        Assertions.assertEquals(SUBSCRIPTION_CANCELLATION_DATE_MILLIS, subscription.getCancellationDate());
        Assertions.assertEquals(12345L, subscription.getWebOrderLineItemId());
    }

    /**
     * An in-app purchase attribute that is present but empty means "absent", and
     * the intro offer flag is an integer that must surface as a boolean, so a
     * caller can distinguish "no expiration" from "expired at epoch".
     */
    @Test
    public void testInAppPurchaseFlagAndEmptyDateDecoding() throws Exception {
        AppReceipt receipt = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false).verifyAndDecodeAppReceipt(encode(sandboxReceipt));

        InAppPurchaseReceipt consumable = receipt.getInAppPurchases().get(0);
        Assertions.assertEquals(Boolean.FALSE, consumable.getIsInIntroOfferPeriod());
        Assertions.assertNull(consumable.getExpiresDate());
        Assertions.assertNull(consumable.getCancellationDate());

        InAppPurchaseReceipt subscription = receipt.getInAppPurchases().get(1);
        Assertions.assertEquals(Boolean.TRUE, subscription.getIsInIntroOfferPeriod());
    }

    /**
     * Attribute types this library does not model must survive decoding with
     * their raw bytes, so a receipt field Apple adds later stays reachable.
     */
    @Test
    public void testUnknownAttributesArePreserved() throws Exception {
        AppReceipt receipt = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false).verifyAndDecodeAppReceipt(encode(sandboxReceipt));

        Assertions.assertEquals(1, receipt.getUnknownAttributes().get(9999).size());
        Assertions.assertArrayEquals(UNKNOWN_RECEIPT_ATTRIBUTE_VALUE, receipt.getUnknownAttributes().get(9999).get(0));
        Assertions.assertArrayEquals(UNKNOWN_IN_APP_ATTRIBUTE_VALUE, receipt.getInAppPurchases().get(0).getUnknownAttributes().get(1799).get(0));
    }

    @Test
    public void testWrongBundleId() throws Exception {
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, "com.example.other", false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(sandboxReceipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testWrongEnvironment() throws Exception {
        byte[] productionReceipt = receiptCreator.signReceipt(receiptPayload("Production", BUNDLE_ID, RECEIPT_CREATION_DATE));
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(productionReceipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_ENVIRONMENT, exception.getStatus());
    }

    /**
     * A receipt type this library does not recognize maps to no environment at
     * all rather than defaulting to the verifier's, so an unexpected value can
     * never be mistaken for a match.
     */
    @Test
    public void testUnknownReceiptType() throws Exception {
        byte[] unknownTypeReceipt = receiptCreator.signReceipt(receiptPayload("ProductionInternal", BUNDLE_ID, RECEIPT_CREATION_DATE));
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(unknownTypeReceipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_ENVIRONMENT, exception.getStatus());
    }

    @Test
    public void testTamperedPayload() throws Exception {
        byte[] tamperedReceipt = sandboxReceipt.clone();
        // Flip a bit inside the app version of the encapsulated payload; the
        // chain is untouched, so only the signature check can catch this.
        tamperedReceipt[indexOf(tamperedReceipt, APP_VERSION.getBytes(StandardCharsets.UTF_8))] ^= 0x01;
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(tamperedReceipt)));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    @Test
    public void testReceiptSignedByForeignRoot() throws Exception {
        ReceiptCreator foreignCreator = ReceiptCreator.createReceiptCreator();
        byte[] forgedReceipt = foreignCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE));
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(forgedReceipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN, exception.getStatus());
    }

    @Test
    public void testLeafWithoutReceiptSigningOid() throws Exception {
        ReceiptCreator creator = ReceiptCreator.createReceiptCreator(false, true, daysAgo(3650), inOneYear());
        byte[] receipt = creator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE));
        AppReceiptVerifier verifier = getReceiptVerifier(creator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN, exception.getStatus());
        Assertions.assertInstanceOf(CertPathValidatorException.class, exception.getCause());
        Assertions.assertTrue(exception.getCause().toString().contains("OID: 1.2.840.113635.100.6.11.1 was not found on the signing certificate"));
    }

    @Test
    public void testIntermediateWithoutWwdrOid() throws Exception {
        ReceiptCreator creator = ReceiptCreator.createReceiptCreator(true, false, daysAgo(3650), inOneYear());
        byte[] receipt = creator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE));
        AppReceiptVerifier verifier = getReceiptVerifier(creator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN, exception.getStatus());
        Assertions.assertInstanceOf(CertPathValidatorException.class, exception.getCause());
        Assertions.assertTrue(exception.getCause().toString().contains("OID: 1.2.840.113635.100.6.2.1 was not found on the intermediate WWDR certificate"));
    }

    @Test
    public void testReceiptWithoutRootCertificateEmbedded() throws Exception {
        byte[] receipt = receiptCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE), 2);
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN_LENGTH, exception.getStatus());
    }

    @Test
    public void testReceiptThatIsNotBase64() throws Exception {
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt("!!!not-base64!!!"));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    @Test
    public void testReceiptThatIsNotAPkcs7Container() throws Exception {
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(new byte[]{1, 2, 3, 4})));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    /**
     * Bytes appended after the container must not be ignored — a verifier that
     * parsed a prefix would accept a receipt carrying unverified extra data.
     */
    @Test
    public void testTrailingBytesAfterContainer() throws Exception {
        byte[] paddedReceipt = new byte[sandboxReceipt.length + 4];
        System.arraycopy(sandboxReceipt, 0, paddedReceipt, 0, sandboxReceipt.length);
        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(paddedReceipt)));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    /**
     * Receipts outlive the certificates that signed them, so with online checks
     * off the chain is evaluated at the receipt's creation date.
     */
    @Test
    public void testReceiptSignedByNowExpiredCertificates() throws Exception {
        ReceiptCreator expiredCreator = ReceiptCreator.createReceiptCreator(true, true, daysAgo(730), daysAgo(365));
        Instant createdAt = Instant.now().minus(547, ChronoUnit.DAYS).truncatedTo(ChronoUnit.SECONDS);
        String creationDate = createdAt.toString();
        byte[] receipt = expiredCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, creationDate), Date.from(createdAt));

        AppReceipt decoded = getReceiptVerifier(expiredCreator, Environment.SANDBOX, BUNDLE_ID, false).verifyAndDecodeAppReceipt(encode(receipt));
        Assertions.assertEquals(Instant.parse(creationDate).toEpochMilli(), decoded.getReceiptCreationDate());
    }

    /**
     * Enabling online checks moves the evaluation to now, which is the point of
     * the option: the same receipt must then fail on the expired chain.
     */
    @Test
    public void testReceiptSignedByNowExpiredCertificatesWithOnlineChecks() throws Exception {
        ReceiptCreator expiredCreator = ReceiptCreator.createReceiptCreator(true, true, daysAgo(730), daysAgo(365));
        Instant createdAt = Instant.now().minus(547, ChronoUnit.DAYS).truncatedTo(ChronoUnit.SECONDS);
        String creationDate = createdAt.toString();
        byte[] receipt = expiredCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, creationDate), Date.from(createdAt));

        AppReceiptVerifier verifier = getReceiptVerifier(expiredCreator, Environment.SANDBOX, BUNDLE_ID, true);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN, exception.getStatus());
    }

    /**
     * Xcode-generated receipts are not signed by the App Store, so they are
     * decoded without any chain or signature check.
     */
    @Test
    public void testXcodeReceiptDecoding() throws Exception {
        ReceiptCreator xcodeCreator = ReceiptCreator.createSelfSignedReceiptCreator();
        byte[] receipt = xcodeCreator.signReceipt(ReceiptCreator.doubleWrap(receiptPayload("Xcode", BUNDLE_ID, RECEIPT_CREATION_DATE)));

        AppReceipt decoded = getReceiptVerifier(xcodeCreator, Environment.XCODE, BUNDLE_ID, false).verifyAndDecodeAppReceipt(encode(receipt));
        Assertions.assertEquals("Xcode", decoded.getReceiptType());
        Assertions.assertEquals(BUNDLE_ID, decoded.getBundleId());
        Assertions.assertEquals(APP_VERSION, decoded.getApplicationVersion());
        Assertions.assertEquals(RECEIPT_CREATION_DATE_MILLIS, decoded.getReceiptCreationDate());
        Assertions.assertEquals(2, decoded.getInAppPurchases().size());
    }

    /** Skipping the signature checks must not skip the app identity check. */
    @Test
    public void testXcodeReceiptWithWrongBundleId() throws Exception {
        ReceiptCreator xcodeCreator = ReceiptCreator.createSelfSignedReceiptCreator();
        byte[] receipt = xcodeCreator.signReceipt(ReceiptCreator.doubleWrap(receiptPayload("Xcode", BUNDLE_ID, RECEIPT_CREATION_DATE)));

        AppReceiptVerifier verifier = getReceiptVerifier(xcodeCreator, Environment.XCODE, "com.example.other", false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    /** Skipping the signature checks must not skip the environment check either. */
    @Test
    public void testXcodeReceiptWithWrongEnvironment() throws Exception {
        ReceiptCreator xcodeCreator = ReceiptCreator.createSelfSignedReceiptCreator();
        byte[] receipt = xcodeCreator.signReceipt(ReceiptCreator.doubleWrap(receiptPayload("Production", BUNDLE_ID, RECEIPT_CREATION_DATE)));

        AppReceiptVerifier verifier = getReceiptVerifier(xcodeCreator, Environment.XCODE, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_ENVIRONMENT, exception.getStatus());
    }

    /**
     * The signer certificate is what the chain is built for, so a receipt whose
     * signer is not among the embedded certificates has no chain to verify.
     */
    @Test
    public void testReceiptWithoutTheSignerCertificateEmbedded() throws Exception {
        byte[] receipt = receiptCreator.signReceiptWithoutSignerCertificate(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE));

        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN, exception.getStatus());
    }

    /**
     * The embedded certificates are attacker-supplied and are ordered into a
     * chain before anything about the receipt has been verified, so a receipt
     * carrying more of them than a chain can hold is rejected rather than
     * assembled.
     */
    @Test
    public void testReceiptWithTooManyEmbeddedCertificates() throws Exception {
        byte[] receipt = receiptCreator.signReceiptWithPadding(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE), 30);

        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN_LENGTH, exception.getStatus());
    }

    /**
     * A correctly signed receipt still fails when the signer names a digest
     * outside the allowlist, so the accepted algorithms never widen to whatever
     * a signer proposes.
     */
    @Test
    public void testReceiptWithADigestAppleDoesNotUse() throws Exception {
        byte[] receipt = receiptCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE), "SHA512withRSA");

        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    /**
     * The payload is parsed before it has been verified, so a date it can carry
     * but no instant can represent must surface as a verification failure rather
     * than as a runtime exception escaping the declared contract.
     */
    @Test
    public void testReceiptWithADateOutsideTheRepresentableRange() throws Exception {
        byte[] receipt = receiptCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, "+1000000000-01-01T00:00:00Z"));

        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.VERIFICATION_FAILURE, exception.getStatus());
    }

    /** As with an Xcode receipt, LocalTesting data is not signed by the App Store. */
    @Test
    public void testLocalTestingReceiptDecoding() throws Exception {
        ReceiptCreator localTestingCreator = ReceiptCreator.createSelfSignedReceiptCreator();
        byte[] receipt = localTestingCreator.signReceipt(receiptPayload("LocalTesting", BUNDLE_ID, RECEIPT_CREATION_DATE));

        AppReceipt decoded = getReceiptVerifier(localTestingCreator, Environment.LOCAL_TESTING, BUNDLE_ID, false).verifyAndDecodeAppReceipt(encode(receipt));
        Assertions.assertEquals("LocalTesting", decoded.getReceiptType());
        Assertions.assertEquals(BUNDLE_ID, decoded.getBundleId());
    }

    /** Skipping the signature checks must not skip the app identity check. */
    @Test
    public void testLocalTestingReceiptWithWrongBundleId() throws Exception {
        ReceiptCreator localTestingCreator = ReceiptCreator.createSelfSignedReceiptCreator();
        byte[] receipt = localTestingCreator.signReceipt(receiptPayload("LocalTesting", BUNDLE_ID, RECEIPT_CREATION_DATE));

        AppReceiptVerifier verifier = getReceiptVerifier(localTestingCreator, Environment.LOCAL_TESTING, "com.example.other", false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndDecodeAppReceipt(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_APP_IDENTIFIER, exception.getStatus());
    }

    @Test
    public void testVerifyAndExtractTransactionId() throws Exception {
        String transactionId = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false).verifyAndExtractTransactionId(encode(sandboxReceipt));
        Assertions.assertEquals("70000000000001", transactionId);
    }

    /** Same output contract as ReceiptUtility: a verified receipt with no in-app purchases yields null. */
    @Test
    public void testVerifyAndExtractTransactionIdWithoutInAppPurchases() throws Exception {
        byte[] receipt = receiptCreator.signReceipt(ReceiptCreator.attributeSet()
                .string(0, "ProductionSandbox")
                .string(2, BUNDLE_ID)
                .date(12, RECEIPT_CREATION_DATE)
                .build());
        Assertions.assertNull(getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false).verifyAndExtractTransactionId(encode(receipt)));
    }

    /** Unlike ReceiptUtility, extraction refuses a receipt that does not verify. */
    @Test
    public void testVerifyAndExtractTransactionIdRejectsForeignReceipt() throws Exception {
        ReceiptCreator foreignCreator = ReceiptCreator.createReceiptCreator();
        byte[] receipt = foreignCreator.signReceipt(receiptPayload("ProductionSandbox", BUNDLE_ID, RECEIPT_CREATION_DATE));

        AppReceiptVerifier verifier = getReceiptVerifier(receiptCreator, Environment.SANDBOX, BUNDLE_ID, false);
        VerificationException exception = Assertions.assertThrows(VerificationException.class, () -> verifier.verifyAndExtractTransactionId(encode(receipt)));
        Assertions.assertEquals(VerificationStatus.INVALID_CHAIN, exception.getStatus());
    }

    private static AppReceiptVerifier getReceiptVerifier(ReceiptCreator creator, Environment environment, String bundleId, boolean enableOnlineChecks) throws Exception {
        return new AppReceiptVerifier(Set.of(creator.getRootCertificate()), bundleId, environment, enableOnlineChecks);
    }

    private static byte[] receiptPayload(String receiptType, String bundleId, String creationDate) throws Exception {
        return ReceiptCreator.attributeSet()
                .string(0, receiptType)
                .string(2, bundleId)
                .string(3, APP_VERSION)
                .raw(4, OPAQUE_VALUE)
                .raw(5, SHA1_HASH)
                .date(12, creationDate)
                .date(18, ORIGINAL_PURCHASE_DATE)
                .string(19, ORIGINAL_APP_VERSION)
                .date(21, EXPIRATION_DATE)
                .raw(9999, UNKNOWN_RECEIPT_ATTRIBUTE_VALUE)
                .raw(17, consumablePurchase())
                .raw(17, subscriptionPurchase())
                .build();
    }

    private static byte[] consumablePurchase() throws Exception {
        return ReceiptCreator.attributeSet()
                .integer(1701, 1)
                .string(1702, CONSUMABLE_PRODUCT_ID)
                .string(1703, "70000000000001")
                .date(1704, CONSUMABLE_PURCHASE_DATE)
                .string(1705, "70000000000001")
                .date(1706, CONSUMABLE_ORIGINAL_PURCHASE_DATE)
                .date(1708, "")
                .integer(1711, 42)
                .date(1712, "")
                .integer(1719, 0)
                .raw(1799, UNKNOWN_IN_APP_ATTRIBUTE_VALUE)
                .build();
    }

    private static byte[] subscriptionPurchase() throws Exception {
        return ReceiptCreator.attributeSet()
                .integer(1701, 1)
                .string(1702, SUBSCRIPTION_PRODUCT_ID)
                .string(1703, "70000000000002")
                .date(1704, SUBSCRIPTION_PURCHASE_DATE)
                .string(1705, "70000000000002")
                .date(1706, SUBSCRIPTION_PURCHASE_DATE)
                .date(1708, SUBSCRIPTION_EXPIRES_DATE)
                .integer(1711, 12345)
                .date(1712, SUBSCRIPTION_CANCELLATION_DATE)
                .integer(1719, 1)
                .build();
    }

    private static String encode(byte[] receipt) {
        return Base64.getEncoder().encodeToString(receipt);
    }

    private static Date inOneYear() {
        return new Date(System.currentTimeMillis() + 365 * DAY_IN_MILLIS);
    }

    private static Date daysAgo(int days) {
        return new Date(System.currentTimeMillis() - days * DAY_IN_MILLIS);
    }

    private static int indexOf(byte[] haystack, byte[] needle) {
        for (int i = 0; i <= haystack.length - needle.length; i++) {
            boolean match = true;
            for (int j = 0; j < needle.length; j++) {
                if (haystack[i + j] != needle[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        throw new AssertionError("Expected bytes not found in the receipt");
    }
}
