// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.HistoryResponse;
import com.apple.itunes.storekit.model.InAppOwnershipType;
import com.apple.itunes.storekit.model.TransactionHistoryRequest;
import com.apple.itunes.storekit.util.TestingUtility;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class TransactionHistoryRequestQueryTest {

    @Test
    public void testGetTransactionHistoryWithRawInAppOwnershipType() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/transactionHistoryResponse.json", request -> {
            Assertions.assertEquals("GET", request.method());
            Assertions.assertEquals("/inApps/v2/history/1234", request.url().encodedPath());
            Assertions.assertEquals("NEW_OWNERSHIP_TYPE", request.url().queryParameter("inAppOwnershipType"));
        });

        TransactionHistoryRequest request = new TransactionHistoryRequest();
        request.setRawInAppOwnershipType("NEW_OWNERSHIP_TYPE");

        HistoryResponse historyResponse = client.getTransactionHistory("1234", null, request, GetTransactionHistoryVersion.V2);

        Assertions.assertNotNull(historyResponse);
    }

    @Test
    public void testGetTransactionHistoryWithInAppOwnershipType() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/transactionHistoryResponse.json", request -> {
            Assertions.assertEquals("/inApps/v2/history/1234", request.url().encodedPath());
            Assertions.assertEquals("PURCHASED", request.url().queryParameter("inAppOwnershipType"));
        });

        TransactionHistoryRequest request = new TransactionHistoryRequest()
                .inAppOwnershipType(InAppOwnershipType.PURCHASED);

        HistoryResponse historyResponse = client.getTransactionHistory("1234", null, request, GetTransactionHistoryVersion.V2);

        Assertions.assertNotNull(historyResponse);
    }

    @Test
    public void testGetTransactionHistoryWithoutInAppOwnershipType() throws APIException, IOException {
        AppStoreServerAPIClient client = getClientWithBody("models/transactionHistoryResponse.json", request -> {
            Assertions.assertEquals("/inApps/v2/history/1234", request.url().encodedPath());
            Assertions.assertNull(request.url().queryParameter("inAppOwnershipType"));
        });

        HistoryResponse historyResponse = client.getTransactionHistory("1234", null, new TransactionHistoryRequest(), GetTransactionHistoryVersion.V2);

        Assertions.assertNotNull(historyResponse);
    }

    private AppStoreServerAPIClient getClientWithBody(String path, Consumer<Request> requestVerifier) throws IOException {
        String body = TestingUtility.readFile(path);
        try (InputStream key = this.getClass().getClassLoader().getResourceAsStream("certs/testSigningKey.p8")) {
            Assertions.assertNotNull(key);
            return new AppStoreServerAPIClient(new String(key.readAllBytes()), "keyId", "issuerId", "com.example", Environment.LOCAL_TESTING) {
                @Override
                protected Response getResponse(Request request) {
                    requestVerifier.accept(request);
                    return new Response.Builder()
                            .body(ResponseBody.create(body, MediaType.parse("application/json")))
                            .code(200)
                            .request(request)
                            .protocol(Protocol.HTTP_1_1)
                            .message("")
                            .build();
                }
            };
        }
    }
}
