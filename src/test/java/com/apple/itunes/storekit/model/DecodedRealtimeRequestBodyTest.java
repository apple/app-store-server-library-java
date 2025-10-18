// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;


import com.apple.itunes.storekit.util.SignedDataCreator;
import com.apple.itunes.storekit.util.TestingUtility;
import com.apple.itunes.storekit.verification.VerificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class DecodedRealtimeRequestBodyTest {

    @Test
    public void testRealtimeRequestDecoding() throws IOException, NoSuchAlgorithmException, VerificationException {
        String signedRealtimeRequest = SignedDataCreator.createSignedDataFromJson("models/decodedRealtimeRequest.json");

        DecodedRealtimeRequestBody request = TestingUtility.getSignedPayloadVerifier().verifyAndDecodeRealtimeRequest(signedRealtimeRequest);

        Assertions.assertEquals("99371282", request.getOriginalTransactionId());
        Assertions.assertEquals(531412, request.getAppAppleId());
        Assertions.assertEquals("com.example.product", request.getProductId());
        Assertions.assertEquals("en-US", request.getUserLocale());
        Assertions.assertEquals(UUID.fromString("3db5c98d-8acf-4e29-831e-8e1f82f9f6e9"), request.getRequestIdentifier());
        Assertions.assertEquals(Environment.LOCAL_TESTING, request.getEnvironment());
        Assertions.assertEquals("LocalTesting", request.getRawEnvironment());
        Assertions.assertEquals(1698148900000L, request.getSignedDate());
    }
}
