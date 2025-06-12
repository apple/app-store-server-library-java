// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.signature;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class JWSSignatureCreator {

    private static final String BUNDLE_ID_KEY = "bid";
    private static final String NONCE_KEY = "nonce";

    private final String audience;
    private final ECPrivateKey signingKey;
    private final String keyId;
    private final String issuerId;
    private final String bundleId;

    public JWSSignatureCreator(String audience, String signingKey, String keyId, String issuerId, String bundleId) {
        this.audience = audience;
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
        this.issuerId = issuerId;
    }

    protected String createSignature(Map<String, ?> featureSpecificClaims) {
        Map<String, Object> claims = new HashMap<>(featureSpecificClaims);
        claims.put(BUNDLE_ID_KEY, bundleId);
        claims.put(NONCE_KEY, createNonce().toString());
        return JWT.create()
                .withAudience(audience)
                .withIssuedAt(Instant.now())
                .withIssuer(issuerId)
                .withKeyId(keyId)
                .withPayload(claims)
                .sign(Algorithm.ECDSA256(signingKey));
    }

    protected UUID createNonce() {
        return UUID.randomUUID();
    }
}
