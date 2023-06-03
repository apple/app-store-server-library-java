// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.migration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTF8String;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SignedData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptUtility {

    private static final int IN_APP_TYPE_ID = 17;
    private static final int TRANSACTION_IDENTIFIER_TYPE_ID = 1703;
    private static final int ORIGINAL_TRANSACTION_IDENTIFIER_TYPE_ID = 1705;

    /**
     * Extracts a transaction id from an encoded App Receipt. Throws if the receipt does not match the expected format.
     * *NO validation* is performed on the receipt, and any data returned should only be used to call the App Store Server API.
     *
     * @param appReceipt The unmodified app receipt
     * @return A transaction id from the array of in-app purchases, null if the receipt contains no in-app purchases.
     * @throws IOException              If the receipt was malformed
     * @throws IllegalArgumentException If the receipt could not be parsed or did not match the expected format
     */
    public String extractTransactionIdFromAppReceipt(String appReceipt) throws IOException {
        // PKCS#7
        try (ASN1InputStream in = new ASN1InputStream(Base64.getDecoder().decode(appReceipt))) {
            ASN1Primitive root = in.readObject();
            if (root instanceof ASN1Sequence) {
                ASN1Sequence seq = (ASN1Sequence) root;
                if (seq.size() > 1 && seq.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
                    ASN1Encodable content = new SignedData(ASN1Sequence.getInstance((ASN1TaggedObject) seq.getObjectAt(1), true)).getContentInfo().getContent();
                    // Outer receipt
                    if (content instanceof ASN1OctetString) {
                        try (ASN1InputStream contentStream = new ASN1InputStream(((ASN1OctetString) content).getOctetStream())) {
                            ASN1Primitive contentRoot = contentStream.readObject();
                            if (contentRoot instanceof ASN1Set) {
                                return Arrays.stream(((ASN1Set) contentRoot).toArray())
                                        .filter(ASN1Sequence.class::isInstance)
                                        .map(ASN1Sequence.class::cast)
                                        .filter(s -> s.size() == 3)
                                        .filter(s -> s.getObjectAt(0) instanceof ASN1Integer)
                                        .filter(s -> ((ASN1Integer) s.getObjectAt(0)).hasValue(IN_APP_TYPE_ID))
                                        .filter(s -> s.getObjectAt(2) instanceof ASN1OctetString)
                                        .flatMap(s -> {
                                            // In-Apps
                                            try (ASN1InputStream inAppStream = new ASN1InputStream(((ASN1OctetString) s.getObjectAt(2)).getOctetStream())) {
                                                ASN1Primitive inAppRoot = inAppStream.readObject();
                                                if (inAppRoot instanceof ASN1Set) {
                                                    return Arrays.stream(((ASN1Set) inAppRoot).toArray())
                                                            .filter(ASN1Sequence.class::isInstance)
                                                            .map(ASN1Sequence.class::cast)
                                                            .filter(a -> a.size() == 3)
                                                            .filter(a -> a.getObjectAt(0) instanceof ASN1Integer)
                                                            .filter(a -> ((ASN1Integer) a.getObjectAt(0)).hasValue(TRANSACTION_IDENTIFIER_TYPE_ID) || ((ASN1Integer) a.getObjectAt(0)).hasValue(ORIGINAL_TRANSACTION_IDENTIFIER_TYPE_ID))
                                                            .map(a -> a.getObjectAt(2))
                                                            .map(ASN1OctetString.class::cast);
                                                } else {
                                                    throw new IllegalArgumentException("Invalid App Receipt");
                                                }
                                            } catch (IOException e) {
                                                throw new IllegalArgumentException("Invalid App Receipt");
                                            }
                                        }).map(s -> {
                                            // Transaction identifier
                                            try (ASN1InputStream transactionIdentifierStream = new ASN1InputStream(s.getOctetStream())) {
                                                ASN1Primitive transactionIdentifierRoot = transactionIdentifierStream.readObject();
                                                if (!(transactionIdentifierRoot instanceof ASN1UTF8String)) {
                                                    throw new IllegalArgumentException("Invalid App Receipt");
                                                }
                                                return ((ASN1UTF8String) transactionIdentifierRoot).getString();
                                            } catch (IOException e) {
                                                throw new IllegalArgumentException("Invalid App Receipt");
                                            }
                                        }).findAny().orElse(null);
                            }
                            throw new IllegalArgumentException("Invalid App Receipt");
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Extracts a transaction id from an encoded transactional receipt. Throws if the receipt does not match the expected format.
     * *NO validation* is performed on the receipt, and any data returned should only be used to call the App Store Server API.
     *
     * @param transactionReceipt The unmodified transactionReceipt
     * @return A transaction id, or null if no transactionId is found in the receipt
     * @throws IllegalArgumentException If the receipt could not be parsed or did not match the expected format
     */
    public String extractTransactionIdFromTransactionReceipt(String transactionReceipt) {
        byte[] decodedTopLevelContainer = Base64.getDecoder().decode(transactionReceipt);
        String topLevel = new String(decodedTopLevelContainer, StandardCharsets.UTF_8);
        Matcher topLevelMatcher = Pattern.compile("\"purchase-info\"\\s+=\\s+\"([a-zA-Z0-9+/=]+)\";").matcher(topLevel);
        String encodedPurchaseInfo = topLevelMatcher.find() && topLevelMatcher.groupCount() == 1 ? topLevelMatcher.group(1) : null;
        if (encodedPurchaseInfo == null) {
            throw new IllegalArgumentException("Invalid purchase-info");
        }
        byte[] decodedPurchaseInfoContainer = Base64.getDecoder().decode(encodedPurchaseInfo);
        String purchaseInfo = new String(decodedPurchaseInfoContainer, StandardCharsets.UTF_8);
        Matcher purchaseInfoMatcher = Pattern.compile("\"transaction-id\"\\s+=\\s+\"([a-zA-Z0-9+/=]+)\";").matcher(purchaseInfo);
        return purchaseInfoMatcher.find() && purchaseInfoMatcher.groupCount() == 1 ? purchaseInfoMatcher.group(1) : null;
    }
}
