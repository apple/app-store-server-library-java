// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import com.apple.itunes.storekit.signature.JWSSignatureCreator;

import java.util.HashMap;
import java.util.Map;

public class IntroductoryOfferEligibilitySignatureCreator extends JWSSignatureCreator {

    private static final String AUDIENCE = "introductory-offer-eligibility";
    private static final String PRODUCT_ID_KEY = "productId";
    private static final String ALLOW_INTRODUCTORY_OFFER_KEY = "allowIntroductoryOffer";
    private static final String TRANSACTION_ID_KEY = "transactionId";

    /**
     * Create an IntroductoryOfferEligibilitySignatureCreator
     * @param signingKey Your private key downloaded from App Store Connect
     * @param keyId Your private key ID from App Store Connect
     * @param issuerId Your issuer ID from the Keys page in App Store Connect
     * @param bundleId Your app's bundle ID
     */
    public IntroductoryOfferEligibilitySignatureCreator(String signingKey, String keyId, String issuerId, String bundleId) {
        super(AUDIENCE, signingKey, keyId, issuerId, bundleId);
    }

    /**
     * Create an introductory offer eligibility signature.
     *
     * @see <a href="https://developer.apple.com/documentation/storekit/generating-jws-to-sign-app-store-requests">Generating JWS to sign App Store requests</a>
     * @param productId The unique identifier of the product
     * @param allowIntroductoryOffer A boolean value that determines whether the customer is eligible for an introductory offer
     * @param transactionId The unique identifier of any transaction that belongs to the customer. You can use the customer's appTransactionId, even for customers who haven't made any In-App Purchases in your app.
     * @return The signed JWS
     */
    public String createSignature(String productId, boolean allowIntroductoryOffer, String transactionId) {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        if (transactionId == null) {
            throw new IllegalArgumentException("transactionId cannot be null");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put(PRODUCT_ID_KEY, productId);
        claims.put(ALLOW_INTRODUCTORY_OFFER_KEY, allowIntroductoryOffer);
        claims.put(TRANSACTION_ID_KEY, transactionId);
        return createSignature(claims);
    }
}
