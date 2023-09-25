// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

class BearerTokenAuthenticatorTest {

    @Test
    void testConstructor() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("testSigningKey.p8")) {
            new BearerTokenAuthenticator(new String(key.readAllBytes()), "keyId", "issuerId", "bundleId");
        }
    }

}
