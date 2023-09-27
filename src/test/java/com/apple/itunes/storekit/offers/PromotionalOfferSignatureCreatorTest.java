// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

class PromotionalOfferSignatureCreatorTest {

    @Test
    void testConstructor() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("testSigningKey.p8")) {
            new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
        }
    }

}
