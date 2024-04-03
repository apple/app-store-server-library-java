// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.offers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.UUID;

class PromotionalOfferSignatureCreatorTest {

    @Test
    void testSignatureCreator() throws Exception {
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(new String(key.readAllBytes()), "keyId", "bundleId");
            String signature = signatureCreator.createSignature("productId", "offerId", "applicationUsername", UUID.fromString("20fba8a0-2b80-4a7d-a17f-85c1854727f8"), 1698148900000L);
            Assertions.assertNotNull(signature);
        }
    }
}
