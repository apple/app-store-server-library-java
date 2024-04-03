// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Map;

public class BearerTokenAuthenticator {
    private static final String APP_STORE_CONNECT_AUDIENCE = "appstoreconnect-v1";
    private static final String BUNDLE_ID_KEY = "bid";

    private final ECPrivateKey signingKey;
    private final String keyId;
    private final String issuerId;
    private final String bundleId;

    public BearerTokenAuthenticator(String signingKey, String keyId, String issuerId, String bundleId) {
        try {
            signingKey = signingKey.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll("\\R+", "")
                    .replace("-----END PRIVATE KEY-----", "");

            byte[] derEncodedSigningKey = Base64.getDecoder().decode(signingKey);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(derEncodedSigningKey);
            this.signingKey = (ECPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        this.keyId = keyId;
        this.issuerId = issuerId;
        this.bundleId = bundleId;
    }

    public String generateToken() {
        return JWT.create()
                .withAudience(APP_STORE_CONNECT_AUDIENCE)
                .withExpiresAt(Instant.now().plus(ChronoUnit.MINUTES.getDuration().multipliedBy(5)))
                .withIssuer(issuerId)
                .withKeyId(keyId)
                .withPayload(Map.of(BUNDLE_ID_KEY, bundleId))
                .sign(Algorithm.ECDSA256(signingKey));
    }
}
