// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import com.apple.itunes.storekit.model.AppTransaction;
import com.apple.itunes.storekit.model.DecodedSignedData;
import com.apple.itunes.storekit.model.Environment;
import com.apple.itunes.storekit.model.JWSRenewalInfoDecodedPayload;
import com.apple.itunes.storekit.model.JWSTransactionDecodedPayload;
import com.apple.itunes.storekit.model.ResponseBodyV2DecodedPayload;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

/**
 * A verifier and decoder class designed to decode signed data from the App Store.
 */
public class SignedDataVerifier {

    private final String bundleId;
    private final Long appAppleId;
    private final Environment environment;
    private final ChainVerifier chainVerifier;
    private final boolean enableOnlineChecks;
    private final ObjectMapper objectMapper;

    /**
     *
     * @param rootCertificates The set of Apple Root certificate authority certificates, as found on <a href="https://www.apple.com/certificateauthority/">Apple PKI</a>
     * @param bundleId The bundle identifier of the app.
     * @param appAppleId The unique identifier of the app in the App Store.
     * @param environment The server environment, either sandbox or production.
     * @param enableOnlineChecks Whether to enable revocation checking and check expiration using the current date
     */
    public SignedDataVerifier(Set<InputStream> rootCertificates, String bundleId, Long appAppleId, Environment environment, boolean enableOnlineChecks) {
        this.bundleId = bundleId;
        this.appAppleId = appAppleId;
        this.environment = environment;
        this.chainVerifier = new ChainVerifier(rootCertificates);
        this.enableOnlineChecks = enableOnlineChecks;
        this.objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        if (appAppleId == null && Environment.PRODUCTION.equals(environment)) {
            throw new IllegalArgumentException("appAppleId is required when the environment is Production");
        }
    }

    /**
     * Verifies and decodes a signedTransaction obtained from the App Store Server API, an App Store Server Notification, or from a device
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwstransaction">JWSTransaction</a>
     *
     * @param signedTransaction The signedTransaction field
     * @return The decoded transaction info after verification
     * @throws VerificationException Thrown if the data could not be verified
     */
    public JWSTransactionDecodedPayload verifyAndDecodeTransaction(String signedTransaction) throws VerificationException {
        JWSTransactionDecodedPayload transaction = decodeSignedObject(signedTransaction, JWSTransactionDecodedPayload.class);
        if (!bundleId.equals(transaction.getBundleId())) {
            throw new VerificationException(VerificationStatus.INVALID_APP_IDENTIFIER);
        }
        if (!this.environment.equals(transaction.getEnvironment())) {
            throw new VerificationException(VerificationStatus.INVALID_ENVIRONMENT);
        }
        return transaction;
    }

    /**
     * Verifies and decodes a signedRenewalInfo obtained from the App Store Server API, an App Store Server Notification, or from a device
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/jwsrenewalinfo">JWSRenewalInfo</a>
     *
     * @param signedRenewalInfo The signedRenewalInfo field
     * @return The decoded renewal info after verification
     * @throws VerificationException Thrown if the data could not be verified
     */
    public JWSRenewalInfoDecodedPayload verifyAndDecodeRenewalInfo(String signedRenewalInfo) throws VerificationException {
        JWSRenewalInfoDecodedPayload renewalInfo = decodeSignedObject(signedRenewalInfo, JWSRenewalInfoDecodedPayload.class);
        if (!this.environment.equals(renewalInfo.getEnvironment())) {
            throw new VerificationException(VerificationStatus.INVALID_ENVIRONMENT);
        }
        return renewalInfo;
    }

    /**
     * Verifies and decodes an App Store Server Notification signedPayload
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/signedpayload">signedPayload</a>
     *
     * @param signedPayload The payload received by your server
     * @return The decoded payload after verification
     * @throws VerificationException Thrown if the data could not be verified
     */
    public ResponseBodyV2DecodedPayload verifyAndDecodeNotification(String signedPayload) throws VerificationException {
        ResponseBodyV2DecodedPayload notification = decodeSignedObject(signedPayload, ResponseBodyV2DecodedPayload.class);
        String bundleId;
        Long appAppleId;
        Environment notificationEnv;
        if (notification.getData() != null) {
            bundleId = notification.getData().getBundleId();
            appAppleId = notification.getData().getAppAppleId();
            notificationEnv = notification.getData().getEnvironment();
        } else if (notification.getSummary() != null) {
            bundleId = notification.getSummary().getBundleId();
            appAppleId = notification.getSummary().getAppAppleId();
            notificationEnv = notification.getSummary().getEnvironment();
        } else if (notification.getExternalPurchaseToken() != null) {
            bundleId = notification.getExternalPurchaseToken().getBundleId();
            appAppleId = notification.getExternalPurchaseToken().getAppAppleId();
            String externalPurchaseId = notification.getExternalPurchaseToken().getExternalPurchaseId();
            if (externalPurchaseId != null && externalPurchaseId.startsWith("SANDBOX")) {
                notificationEnv = Environment.SANDBOX;
            } else {
                notificationEnv = Environment.PRODUCTION;
            }
        } else {
            bundleId = null;
            appAppleId = null;
            notificationEnv = null;
        }
        verifyNotification(bundleId, appAppleId, notificationEnv);
        return notification;
    }

    protected void verifyNotification(String bundleId, Long appAppleId, Environment notificationEnv) throws VerificationException {
        if (!this.bundleId.equals(bundleId) || (this.environment.equals(Environment.PRODUCTION) && !this.appAppleId.equals(appAppleId))) {
            throw new VerificationException(VerificationStatus.INVALID_APP_IDENTIFIER);
        }
        if (!this.environment.equals(notificationEnv)) {
            throw new VerificationException(VerificationStatus.INVALID_ENVIRONMENT);
        }
    }

    /**
     * Verifies and decodes a signed AppTransaction
     * @see <a href="https://developer.apple.com/documentation/storekit/apptransaction">AppTransaction</a>
     *
     * @param signedAppTransaction The signed AppTransaction
     * @return The decoded AppTransaction after validation
     * @throws VerificationException Thrown if the data could not be verified
     */
    public AppTransaction verifyAndDecodeAppTransaction(String signedAppTransaction) throws VerificationException {
        AppTransaction appTransaction = decodeSignedObject(signedAppTransaction, AppTransaction.class);
        Environment environment = appTransaction.getReceiptType();
        if (!this.bundleId.equals(appTransaction.getBundleId()) || (this.environment.equals(Environment.PRODUCTION) && !this.appAppleId.equals(appTransaction.getAppAppleId()))) {
            throw new VerificationException(VerificationStatus.INVALID_APP_IDENTIFIER);
        }
        if (!this.environment.equals(environment)) {
            throw new VerificationException(VerificationStatus.INVALID_ENVIRONMENT);
        }
        return appTransaction;
    }

    protected <T extends DecodedSignedData> T decodeSignedObject(String signedObject, Class<T> clazz) throws VerificationException {
        try {
            DecodedJWT unverifiedJWT = JWT.decode(signedObject);
            if (Environment.XCODE.equals(this.environment) || Environment.LOCAL_TESTING.equals(this.environment)) {
                // Data is not signed by the App Store, and verification should be skipped
                // The environment MUST be checked in the public method calling this
                return parseJWTPayload(clazz, unverifiedJWT);
            }
            String[] x5cChain = unverifiedJWT.getHeaderClaim("x5c").asArray(String.class);
            if (x5cChain == null) {
                throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "x5c claim was null");
            }
            T decodedData = parseJWTPayload(clazz, unverifiedJWT);
            Date effectiveDate = this.enableOnlineChecks || decodedData.getSignedDate() == null ? new Date() : new Date(decodedData.getSignedDate());
            PublicKey signingKey = chainVerifier.verifyChain(x5cChain, enableOnlineChecks, effectiveDate);
            if ("ES256".equals(unverifiedJWT.getAlgorithm())) {
                JWT.require(Algorithm.ECDSA256((ECPublicKey) signingKey)).build().verify(unverifiedJWT);
            } else {
                throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, "Unrecognized JWT algorithm + " + unverifiedJWT.getAlgorithm());
            }
            return decodedData;
        } catch (VerificationException e) {
            throw e;
        } catch (Exception e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, e);
        }
    }

    protected <T extends DecodedSignedData> T parseJWTPayload(Class<T> clazz, DecodedJWT jwt) throws VerificationException {
        String payload = new String(Base64.getUrlDecoder().decode(jwt.getPayload()));
        try {
            return objectMapper.readValue(payload, clazz);
        } catch (JsonProcessingException e) {
            throw new VerificationException(VerificationStatus.VERIFICATION_FAILURE, e);
        }
    }
}
