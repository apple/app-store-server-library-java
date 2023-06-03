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
import com.google.gson.Gson;

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
    private final Gson gson;

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
        this.gson = new Gson();
    }

    /**
     * Verifies and decodes a signedTransaction obtained from the App Store Server API, an App Store Server Notification, or from a device
     *
     * @param signedTransaction The signedTransaction field
     * @return The decoded transaction info after verification
     * @throws VerificationException Thrown if the data could not be verified
     */
    public JWSTransactionDecodedPayload verifyAndDecodeTransaction(String signedTransaction) throws VerificationException {
        JWSTransactionDecodedPayload transaction = decodeSignedObject(signedTransaction, JWSTransactionDecodedPayload.class);
        if (!bundleId.equals(transaction.getBundleId())) {
            throw new VerificationException(Status.INVALID_APP_IDENTIFIER);
        }
        if (!this.environment.equals(transaction.getEnvironment())) {
            throw new VerificationException(Status.INVALID_ENVIRONMENT);
        }
        return transaction;
    }

    /**
     * Verifies and decodes a signedRenewalInfo obtained from the App Store Server API, an App Store Server Notification, or from a device
     *
     * @param signedRenewalInfo The signedRenewalInfo field
     * @return The decoded renewal info after verification
     * @throws VerificationException Thrown if the data could not be verified
     */
    public JWSRenewalInfoDecodedPayload verifyAndDecodeRenewalInfo(String signedRenewalInfo) throws VerificationException {
        return decodeSignedObject(signedRenewalInfo, JWSRenewalInfoDecodedPayload.class);
    }

    /**
     * Verifies and decodes an App Store Server Notification signedPayload
     *
     * @param signedPayload The payload received by your server
     * @return The decoded payload after verification
     * @throws VerificationException Thrown if the data could not be verified
     */
    public ResponseBodyV2DecodedPayload verifyAndDecodeNotification(String signedPayload) throws VerificationException {
        ResponseBodyV2DecodedPayload notification = decodeSignedObject(signedPayload, ResponseBodyV2DecodedPayload.class);
        Environment notificationEnv = notification.getData() != null ? notification.getData().getEnvironment() : (notification.getSummary() != null ? notification.getSummary().getEnvironment() : null);
        Long appAppleId = notification.getData() != null ? notification.getData().getAppAppleId() : (notification.getSummary() != null ? notification.getSummary().getAppAppleId() : null);
        String bundleId = notification.getData() != null ? notification.getData().getBundleId() : (notification.getSummary() != null ? notification.getSummary().getBundleId() : null);
        if (!this.bundleId.equals(bundleId) || (this.environment.equals(Environment.PRODUCTION) && !this.appAppleId.equals(appAppleId))) {
            throw new VerificationException(Status.INVALID_APP_IDENTIFIER);
        }
        if (!this.environment.equals(notificationEnv)) {
            throw new VerificationException(Status.INVALID_ENVIRONMENT);
        }
        return notification;
    }

    /**
     * Verifies and decodes a signed AppTransaction
     * @param signedAppTransaction The signed AppTransaction
     * @return The decoded AppTransaction after validation
     * @throws VerificationException Thrown if the data could not be verified
     */
    public AppTransaction verifyAndDecodeAppTransaction(String signedAppTransaction) throws VerificationException {
        AppTransaction appTransaction = decodeSignedObject(signedAppTransaction, AppTransaction.class);
        Environment environment = appTransaction.getReceiptType();
        if (!this.bundleId.equals(appTransaction.getBundleId()) || (this.environment.equals(Environment.PRODUCTION) && !this.appAppleId.equals(appTransaction.getAppAppleId()))) {
            throw new VerificationException(Status.INVALID_APP_IDENTIFIER);
        }
        if (!this.environment.equals(environment)) {
            throw new VerificationException(Status.INVALID_ENVIRONMENT);
        }
        return appTransaction;
    }

    private <T extends DecodedSignedData> T decodeSignedObject(String signedObject, Class<T> clazz) throws VerificationException {
        try {
            DecodedJWT unverifiedJWT = JWT.decode(signedObject);
            String[] x5cChain = unverifiedJWT.getHeaderClaim("x5c").asArray(String.class);
            if (x5cChain == null) {
                throw new VerificationException(Status.VERIFICATION_FAILURE, "x5c claim was null");
            }
            String payload = new String(Base64.getUrlDecoder().decode(unverifiedJWT.getPayload()));
            T decodedData = gson.fromJson(payload, clazz);
            Date effectiveDate = this.enableOnlineChecks || decodedData.getSignedDate() == null ? new Date() : new Date(decodedData.getSignedDate());
            PublicKey signingKey = chainVerifier.verifyChain(x5cChain, enableOnlineChecks, effectiveDate);
            if ("ES256".equals(unverifiedJWT.getAlgorithm())) {
                JWT.require(Algorithm.ECDSA256((ECPublicKey) signingKey)).build().verify(unverifiedJWT);
            } else {
                throw new VerificationException(Status.VERIFICATION_FAILURE, "Unrecognized JWT algorithm + " + unverifiedJWT.getAlgorithm());
            }
            return decodedData;
        } catch (VerificationException e) {
            throw e;
        } catch (Exception e) {
            throw new VerificationException(Status.VERIFICATION_FAILURE, e);
        }
    }
}
