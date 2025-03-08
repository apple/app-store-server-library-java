// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import com.apple.itunes.storekit.signature.JWSSignatureCreator;

import java.util.HashMap;
import java.util.Map;

public class PromotionalOfferV2SignatureCreator extends JWSSignatureCreator {

    private static final String AUDIENCE = "promotional-offer";
    private static final String PRODUCT_ID_KEY = "productId";
    private static final String OFFER_IDENTIFIER_KEY = "offerIdentifier";
    private static final String TRANSACTION_ID_KEY = "transactionId";

    /**
     * Create a PromotionalOfferV2SignatureCreator
     * @param signingKey Your private key downloaded from App Store Connect
     * @param keyId Your private key ID from App Store Connect
     * @param issuerId Your issuer ID from the Keys page in App Store Connect
     * @param bundleId Your app's bundle ID
     */
    public PromotionalOfferV2SignatureCreator(String signingKey, String keyId, String issuerId, String bundleId) {
        super(AUDIENCE, signingKey, keyId, issuerId, bundleId);
    }

    /**
     * Create a promotional offer V2 signature.
     *
     * @see <a href="https://developer.apple.com/documentation/storekit/generating-jws-to-sign-app-store-requests">Generating JWS to sign App Store requests</a>
     * @param productId The unique identifier of the product
     * @param offerIdentifier The promotional offer identifier that you set up in App Store Connect.
     * @param transactionId The unique identifier of any transaction that belongs to the customer. You can use the customer's appTransactionId, even for customers who haven't made any In-App Purchases in your app. This field is optional, but recommended.
     * @return The signed JWS
     */
    public String createSignature(String productId, String offerIdentifier, String transactionId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        if (offerIdentifier == null) {
            throw new IllegalArgumentException("offerIdentifier cannot be null");
        }
        Map<String, String> claims = new HashMap<>();
        claims.put(PRODUCT_ID_KEY, productId);
        claims.put(OFFER_IDENTIFIER_KEY, offerIdentifier);
        if (transactionId != null) {
            claims.put(TRANSACTION_ID_KEY, transactionId);
        }
        return createSignature(claims);
    }
}
