// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.migration;

import com.apple.itunes.storekit.util.TestingUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    public void testTransactionReceiptExtraction() throws IOException {
        String receipt = TestingUtility.readFile("mock_signed_data/legacyTransaction");

        ReceiptUtility util = new ReceiptUtility();
        String extractedTransactionId = util.extractTransactionIdFromTransactionReceipt(receipt);

        Assertions.assertEquals(TRANSACTION_RECEIPT_EXPECTED_TRANSACTION_ID, extractedTransactionId);
    }
}
