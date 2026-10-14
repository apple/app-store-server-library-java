// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

class BearerTokenAuthenticatorTest {

    @Test
    void testCreatingToken() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            var tokenGenerator = new BearerTokenAuthenticator(new String(key.readAllBytes()), "keyId", "issuerId", "bundleId");
            String token = tokenGenerator.generateToken();
            Assertions.assertNotNull(token);
        }
    }

    @Test
    void testTokenIncludesIssuedAt() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            var tokenGenerator = new BearerTokenAuthenticator(new String(key.readAllBytes()), "keyId", "issuerId", "bundleId");
            Instant before = Instant.now().truncatedTo(ChronoUnit.SECONDS);
            DecodedJWT token = JWT.decode(tokenGenerator.generateToken());
            Instant after = Instant.now();
            Instant issuedAt = token.getIssuedAtAsInstant();
            Assertions.assertNotNull(issuedAt);
            Assertions.assertFalse(issuedAt.isBefore(before));
            Assertions.assertFalse(issuedAt.isAfter(after));
            Assertions.assertEquals(Duration.ofMinutes(5), Duration.between(issuedAt, token.getExpiresAtAsInstant()));
            Assertions.assertEquals("issuerId", token.getIssuer());
            Assertions.assertEquals("bundleId", token.getClaim("bid").asString());
        }
    }
}
