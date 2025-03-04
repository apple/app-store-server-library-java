// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.advancedcommerce;

import com.apple.itunes.storekit.model.AdvancedCommerceInAppRequest;
import com.apple.itunes.storekit.signature.JWSSignatureCreator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class AdvancedCommerceInAppSignatureCreator extends JWSSignatureCreator {

    private static final String AUDIENCE = "advanced-commerce-api";
    private static final String REQUEST_KEY = "request";

    private final ObjectMapper objectMapper;

    /**
     * Create an AdvancedCommerceInAppSignatureCreator
     * @param signingKey Your private key downloaded from App Store Connect
     * @param keyId Your private key ID from App Store Connect
     * @param issuerId Your issuer ID from the Keys page in App Store Connect
     * @param bundleId Your app's bundle ID
     */
    public AdvancedCommerceInAppSignatureCreator(String signingKey, String keyId, String issuerId, String bundleId) {
        super(AUDIENCE, signingKey, keyId, issuerId, bundleId);
        this.objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }

    /**
     * Create an Advanced Commerce in-app signed request.
     *
     * @see <a href="https://developer.apple.com/documentation/storekit/generating-jws-to-sign-app-store-requests">Generating JWS to sign App Store requests</a>
     * @param advancedCommerceInAppRequest The request to be signed.
     * @return The signed JWS
     */
    public String createSignature(AdvancedCommerceInAppRequest advancedCommerceInAppRequest) throws IOException {
        if (advancedCommerceInAppRequest == null) {
            throw new IllegalArgumentException("advancedCommerceInAppRequest cannot be null");
        }
        String jsonRequest = objectMapper.writeValueAsString(advancedCommerceInAppRequest);
        byte[] utf8Bytes = jsonRequest.getBytes(StandardCharsets.UTF_8);
        String encodedRequest = Base64.getEncoder().encodeToString(utf8Bytes);
        Map<String, Object> claims = new HashMap<>();
        claims.put(REQUEST_KEY, encodedRequest);
        return createSignature(claims);
    }
}
