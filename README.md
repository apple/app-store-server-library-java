# Apple App Store Server Java Library
The Java server library for the [App Store Server API](https://developer.apple.com/documentation/appstoreserverapi) and [App Store Server Notifications](https://developer.apple.com/documentation/appstoreservernotifications)

## Table of Contents
1. [Beta](#-beta-)
2. [Installation](#installation)
3. [Documentation](#documentation)
4. [Usage](#usage)
5. [Support](#support)

## ⚠️ Beta ⚠️

This software is currently in Beta testing. Therefore, it should only be used for testing purposes, like for the Sandbox environment. API signatures may change between releases and signature verification may receive security updates.

## Installation

#### Requirements

- Java 11+

### Gradle
```groovy
implementation 'com.apple.itunes.storekit:app-store-server-library:0.1.1'

```

### Maven
```xml
<dependency>
    <groupId>com.apple.itunes.storekit</groupId>
    <artifcatId>app-store-server-library</artifcatId>
    <version>0.1.1</version>
</dependency>
```

## Documentation

[JavaDocs](TODO)

[WWDC Video](https://developer.apple.com/videos/play/wwdc2023/10143/)
## Usage

### API Usage

```java
import com.apple.itunes.storekit.client.APIException;
import com.apple.itunes.storekit.client.AppStoreServerAPIClient;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.SendTestNotificationResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class APIExample {
    public static void main(String[] args) throws Exception {
        String issuerId = "99b16628-15e4-4668-972b-eeff55eeff55";
        String keyId = "ABCDEFGHIJ";
        String bundleId = "com.example";
        Path filePath = Path.of("/path/to/key/SubscriptionKey_ABCDEFGHIJ.p8");
        String encodedKey = Files.readString(filePath);
        Environment environment = Environment.SANDBOX;

        AppStoreServerAPIClient client =
                new AppStoreServerAPIClient(encodedKey, keyId, issuerId, bundleId, environment);

        try {
            SendTestNotificationResponse response = client.requestTestNotification();
            System.out.println(response);
        } catch (APIException | IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Verification Usage

```java
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.ResponseBodyV2DecodedPayload;
import com.apple.itunes.storekit.verification.SignedDataVerifier;
import com.apple.itunes.storekit.verification.VerificationException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

public class ExampleVerification {
    public static void main(String[] args) {
        String bundleId = "com.example";
        Environment environment = Environment.SANDBOX;
        Set<InputStream> rootCAs = Set.of(
                new FileInputStream("/path/to/rootCA1"),
                new FileInputStream("/path/to/rootCA2")
        );

        SignedDataVerifier signedPayloadVerifier = new SignedDataVerifier(rootCAs, bundleId, null, environment, true);
        
        String notificationPayload = "ey...";

        try {
            ResponseBodyV2DecodedPayload payload = signedPayloadVerifier.verifyAndDecodeNotification(notificationPayload);
            System.out.println(payload);
        } catch (VerificationException e) {
            e.printStackTrace();
        }
    }
}
```

### Receipt Usage

```java
import com.apple.itunes.storekit.client.AppStoreServerAPIClient;
import com.apple.itunes.storekit.migration.ReceiptUtility;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.HistoryResponse;
import com.apple.itunes.storekit.model.TransactionHistoryRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class ExampleMigration {
    public static void main(String[] args) throws Exception {
        String issuerId = "99b16628-15e4-4668-972b-eeff55eeff55";
        String keyId = "ABCDEFGHIJ";
        String bundleId = "com.example";
        Path filePath = Path.of("/path/to/key/SubscriptionKey_ABCDEFGHIJ.p8");
        String encodedKey = Files.readString(filePath);
        Environment environment = Environment.SANDBOX;

        AppStoreServerAPIClient client =
                new AppStoreServerAPIClient(encodedKey, keyId, issuerId, bundleId, environment);

        String appReceipt = "MI...";
        ReceiptUtility receiptUtil = new ReceiptUtility();
        String transactionId = receiptUtil.extractTransactionIdFromAppReceipt(appReceipt);
        if (transactionId != null) {
            TransactionHistoryRequest request = new TransactionHistoryRequest()
                    .sort(TransactionHistoryRequest.Order.ASCENDING)
                    .revoked(false)
                    .productTypes(List.of(TransactionHistoryRequest.ProductType.AUTO_RENEWABLE));
            HistoryResponse response = null;
            List<String> transactions = new LinkedList<>();
            do {
                String revision = response != null ? response.getRevision() : null;
                response = client.getTransactionHistory(transactionId, revision, request);
                transactions.addAll(response.getSignedTransactions());
            } while (response.getHasMore());
            System.out.println(transactions);
        }
    }
}
```

### Promotional Offer Signature Creation

```java
import com.apple.itunes.storekit.offers.PromotionalOfferSignatureCreator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class ExampleSignatureCreation {
    public static void main(String[] args) throws Exception {
        String keyId = "ABCDEFGHIJ";
        String bundleId = "com.example";
        Path filePath = Path.of("/path/to/key/SubscriptionKey_ABCDEFGHIJ.p8");
        String encodedKey = Files.readString(filePath);

        PromotionalOfferSignatureCreator signatureCreator = new PromotionalOfferSignatureCreator(encodedKey, keyId, bundleId);
        
        String productId = "<product_id>";
        String subscriptionOfferId = "<subscription_offer_id>";
        String applicationUsername = "<application_username>";
        UUID nonce = UUID.randomUUID();
        long timestamp = System.currentTimeMillis();
        String encodedSignature = signatureCreator.createSignature(productId, subscriptionOfferId, applicationUsername, nonce, timestamp);
        System.out.println(encodedSignature);
    }
}
```

## Support

Only the latest major version of the library will receive updates, including security updates. Therefore, it is recommended to update to new major versions.
