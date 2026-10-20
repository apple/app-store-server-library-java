// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.migration;

import com.apple.itunes.storekit.util.TestingUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class ReceiptUtilityTest {

    private static final String APP_RECEIPT_EXPECTED_TRANSACTION_ID = "0";
    private static final String TRANSACTION_RECEIPT_EXPECTED_TRANSACTION_ID = "33993399";

    @Test
    public void testXcodeAppReceiptExtractionWithNoTransactions() throws IOException {
        String receipt = TestingUtility.readFile("xcode/xcode-app-receipt-empty");

        ReceiptUtility util = new ReceiptUtility();
        String extractedTransactionId = util.extractTransactionIdFromAppReceipt(receipt);

        Assertions.assertNull(extractedTransactionId);
    }

    @Test
    public void testXcodeAppReceiptExtractionWithTransactions() throws IOException {
        String receipt = TestingUtility.readFile("xcode/xcode-app-receipt-with-transaction");

        ReceiptUtility util = new ReceiptUtility();
        String extractedTransactionId = util.extractTransactionIdFromAppReceipt(receipt);

        Assertions.assertEquals(APP_RECEIPT_EXPECTED_TRANSACTION_ID, extractedTransactionId);
    }

    @Test
    public void testAppReceiptExtractionWithEmptyReceipt() {
        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt(""));
    }

    @Test
    public void testAppReceiptExtractionWithNonSequenceRoot() {
        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt("AgEB"));
    }

    @Test
    public void testAppReceiptExtractionWithNonPKCS7Sequence() {
        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt("MAMCAQE="));
    }

    @Test
    public void testAppReceiptExtractionWithInvalidBase64() {
        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt("not a receipt!"));
    }

    @Test
    public void testAppReceiptExtractionWithUnpaddedBase64() throws IOException {
        String receipt = TestingUtility.readFile("xcode/xcode-app-receipt-with-transaction");
        Assertions.assertTrue(receipt.endsWith("="));
        String unpaddedReceipt = receipt.replace("=", "");

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt(unpaddedReceipt));
    }

    @Test
    public void testAppReceiptExtractionWithUrlSafeBase64() throws IOException {
        byte[] receipt = Base64.getDecoder().decode(TestingUtility.readFile("xcode/xcode-app-receipt-with-transaction"));
        String urlSafeReceipt = Base64.getUrlEncoder().encodeToString(receipt);
        Assertions.assertTrue(urlSafeReceipt.contains("-") || urlSafeReceipt.contains("_"));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt(urlSafeReceipt));
    }

    @Test
    public void testAppReceiptExtractionWithTruncatedReceipt() throws IOException {
        byte[] receipt = Base64.getDecoder().decode(TestingUtility.readFile("xcode/xcode-app-receipt-with-transaction"));
        String truncatedReceipt = Base64.getEncoder().encodeToString(Arrays.copyOf(receipt, receipt.length / 2));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt(truncatedReceipt));
    }

    @Test
    public void testAppReceiptExtractionWithMalformedSignedData() {
        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromAppReceipt("MA4GCSqGSIb3DQEHAgIBAQ=="));
    }

    @Test
    public void testTransactionReceiptExtraction() throws IOException {
        String receipt = TestingUtility.readFile("mock_signed_data/legacyTransaction");

        ReceiptUtility util = new ReceiptUtility();
        String extractedTransactionId = util.extractTransactionIdFromTransactionReceipt(receipt);

        Assertions.assertEquals(TRANSACTION_RECEIPT_EXPECTED_TRANSACTION_ID, extractedTransactionId);
    }

    @Test
    public void testTransactionReceiptExtractionWithMissingPurchaseInfo() {
        String receipt = Base64.getEncoder().encodeToString("{\n\t\"signature\" = \"abc\";\n}".getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithInvalidBase64() {
        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt("not a receipt!"));
    }

    @Test
    public void testTransactionReceiptExtractionWithInvalidPurchaseInfo() {
        String receipt = Base64.getEncoder().encodeToString("{\n\t\"purchase-info\" = \"a\";\n}".getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithUnpaddedBase64() throws IOException {
        String receipt = TestingUtility.readFile("mock_signed_data/legacyTransaction");
        Assertions.assertTrue(receipt.endsWith("="));
        String unpaddedReceipt = receipt.replace("=", "");

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(unpaddedReceipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithUnpaddedPurchaseInfo() {
        String receipt = Base64.getEncoder().encodeToString("{\n\t\"purchase-info\" = \"YQ\";\n}".getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithUnpaddedPurchaseInfoContainingTransactionId() {
        String purchaseInfo = Base64.getEncoder().withoutPadding().encodeToString("{\n\t\"transaction-id\" = \"1234\";\n}".getBytes(StandardCharsets.UTF_8));
        Assertions.assertNotEquals(0, purchaseInfo.length() % 4);
        String receipt = Base64.getEncoder().encodeToString(("{\n\t\"purchase-info\" = \"" + purchaseInfo + "\";\n}").getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithPurchaseInfoNotUTF8() {
        String purchaseInfo = Base64.getEncoder().encodeToString(new byte[]{(byte) 0xff, (byte) 0xfe, (byte) 0xfd});
        String receipt = Base64.getEncoder().encodeToString(("{\n\t\"purchase-info\" = \"" + purchaseInfo + "\";\n}").getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithPurchaseInfoContainingTransactionIdAndInvalidUTF8() {
        byte[] transactionId = "{\n\t\"transaction-id\" = \"123\";\n}".getBytes(StandardCharsets.UTF_8);
        byte[] purchaseInfoBytes = Arrays.copyOf(transactionId, transactionId.length + 1);
        purchaseInfoBytes[transactionId.length] = (byte) 0xff;
        String purchaseInfo = Base64.getEncoder().encodeToString(purchaseInfoBytes);
        String receipt = Base64.getEncoder().encodeToString(("{\n\t\"purchase-info\" = \"" + purchaseInfo + "\";\n}").getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithInvalidUTF8() {
        String purchaseInfo = Base64.getEncoder().encodeToString("{\n\t\"transaction-id\" = \"123\";\n}".getBytes(StandardCharsets.UTF_8));
        byte[] topLevel = ("{\n\t\"purchase-info\" = \"" + purchaseInfo + "\";\n}").getBytes(StandardCharsets.UTF_8);
        byte[] topLevelWithInvalidByte = Arrays.copyOf(topLevel, topLevel.length + 1);
        topLevelWithInvalidByte[topLevel.length] = (byte) 0xff;
        String receipt = Base64.getEncoder().encodeToString(topLevelWithInvalidByte);
        String validReceipt = Base64.getEncoder().encodeToString(topLevel);

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertEquals("123", util.extractTransactionIdFromTransactionReceipt(validReceipt));
        Assertions.assertThrows(IllegalArgumentException.class, () -> util.extractTransactionIdFromTransactionReceipt(receipt));
    }

    @Test
    public void testTransactionReceiptExtractionWithNoTransactionId() {
        String purchaseInfo = Base64.getEncoder().encodeToString("{\n\t\"product-id\" = \"com.example.product\";\n}".getBytes(StandardCharsets.UTF_8));
        String receipt = Base64.getEncoder().encodeToString(("{\n\t\"purchase-info\" = \"" + purchaseInfo + "\";\n}").getBytes(StandardCharsets.UTF_8));

        ReceiptUtility util = new ReceiptUtility();
        Assertions.assertNull(util.extractTransactionIdFromTransactionReceipt(receipt));
    }
}
