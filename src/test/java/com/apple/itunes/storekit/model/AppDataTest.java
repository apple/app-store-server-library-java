// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.TestingUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AppDataTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testAppData() throws IOException {
        String json = TestingUtility.readFile("models/appData.json");

        AppData appData = objectMapper.readValue(json, AppData.class);
        
        Assertions.assertEquals(Long.valueOf(987654321L), appData.getAppAppleId());
        Assertions.assertEquals("com.example", appData.getBundleId());
        Assertions.assertEquals(Environment.SANDBOX, appData.getEnvironment());
        Assertions.assertEquals("Sandbox", appData.getRawEnvironment());
        Assertions.assertEquals("signed-app-transaction-info", appData.getSignedAppTransactionInfo());
    }
}