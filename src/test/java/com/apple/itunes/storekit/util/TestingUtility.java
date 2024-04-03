// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.util;

import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.verification.SignedDataVerifier;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class TestingUtility {

    public static String readFile(String file) throws IOException {
        return new String(readBytes(file), StandardCharsets.UTF_8);
    }

    public static byte[] readBytes(String file) throws IOException {
        try (InputStream stream = TestingUtility.class.getClassLoader().getResourceAsStream(file)) {
            Assertions.assertNotNull(stream);
            return stream.readAllBytes();
        }
    }

    public static SignedDataVerifier getSignedPayloadVerifier(Environment environment, String bundleId, Long appAppleId) throws IOException {
        return new SignedDataVerifier(Set.of(new ByteArrayInputStream(readBytes("certs/testCA.der"))), bundleId, appAppleId, environment, false);
    }

    public static SignedDataVerifier getSignedPayloadVerifier(Environment environment, String bundleId) throws IOException {
        return getSignedPayloadVerifier(environment, bundleId, 1234L);
    }

    public static SignedDataVerifier getSignedPayloadVerifier() throws IOException {
        return getSignedPayloadVerifier(Environment.LOCAL_TESTING, "com.example");
    }
}
