// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

public class PromotionalOfferSignatureCreator {

    private final ECPrivateKey signingKey;
    private final String keyId;
    private final String bundleId;

    public PromotionalOfferSignatureCreator(String signingKey, String keyId, String bundleId) {
        try {
            signingKey = signingKey.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll("\\R+", "")
                    .replace("-----END PRIVATE KEY-----", "");

            byte[] derEncodedSigningKey = Base64.getDecoder().decode(signingKey);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(derEncodedSigningKey);
            this.signingKey = (ECPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        this.keyId = keyId;
        this.bundleId = bundleId;
    }

    /**
     * Create a promotional offer signature
     *
     * @see <a href="https://developer.apple.com/documentation/storekit/in-app_purchase/original_api_for_in-app_purchase/subscriptions_and_offers/generating_a_signature_for_promotional_offers">Generating a signature for promotional offers</a>
     * @param productIdentifier The subscription product identifier
     * @param subscriptionOfferID The subscription discount identifier
     * @param appAccountToken An optional string value that you define; may be an empty string
     * @param nonce A one-time UUID value that your server generates. Generate a new nonce for every signature.
     * @param timestamp A timestamp your server generates in UNIX time format, in milliseconds. The timestamp keeps the offer active for 24 hours.
     * @return The Base64 encoded signature
     */
    public String createSignature(String productIdentifier, String subscriptionOfferID, String appAccountToken, UUID nonce, long timestamp) {
        String payload = this.bundleId + '\u2063' +
                this.keyId + '\u2063' +
                productIdentifier + '\u2063' +
                subscriptionOfferID + '\u2063' +
                appAccountToken.toLowerCase()  + '\u2063'+
                nonce.toString().toLowerCase() + '\u2063' +
                timestamp;
        try {
            Signature s = Signature.getInstance("SHA256withECDSA");
            s.initSign(this.signingKey);
            s.update(payload.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(s.sign());
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
