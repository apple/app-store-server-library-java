// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ChainVerifier {
    private static final int EXPECTED_CHAIN_LENGTH = 3;
    private final Set<TrustAnchor> trustAnchors;

    public ChainVerifier(Set<InputStream> rootCertificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            this.trustAnchors = new HashSet<>();
            for (InputStream inputStream : rootCertificates) {
                Certificate certificate = certificateFactory.generateCertificate(inputStream);
                if (!(certificate instanceof X509Certificate)) {
                    throw new RuntimeException("Root certificate not of the expected X509 format");
                }
                trustAnchors.add(new TrustAnchor((X509Certificate) certificate, null));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (trustAnchors.size() == 0) {
            throw new RuntimeException("At least one root certificate is required");
        }
    }

    public PublicKey verifyChain(String[] certificates, boolean performRevocationChecking, Date effectiveDate) throws VerificationException {
        CertificateFactory certificateFactory;
        CertPathValidator certPathValidator;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
            certPathValidator = CertPathValidator.getInstance("PKIX");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        List<Certificate> parsedCertificates = new LinkedList<>();
        try {
            for (String c : certificates) {
                InputStream derEncodedCert = new ByteArrayInputStream(Base64.getDecoder().decode(c));
                parsedCertificates.add(certificateFactory.generateCertificate(derEncodedCert));
            }
        } catch (Exception e) {
            throw new VerificationException(VerificationStatus.INVALID_CERTIFICATE, e);
        }

        if (parsedCertificates.size() != EXPECTED_CHAIN_LENGTH) {
            throw new VerificationException(VerificationStatus.INVALID_CHAIN_LENGTH);
        }

        try {
            //We don't include the root cert in the path, due to OCSP not being supported
            CertPath certPath = certificateFactory.generateCertPath(parsedCertificates.subList(0, EXPECTED_CHAIN_LENGTH - 1));
            PKIXParameters parameters = new PKIXParameters(trustAnchors);
            parameters.setRevocationEnabled(performRevocationChecking);
            parameters.setDate(effectiveDate);
            if (performRevocationChecking) {
                PKIXRevocationChecker revocationChecker = (PKIXRevocationChecker) certPathValidator.getRevocationChecker();
                revocationChecker.setOptions(Set.of(PKIXRevocationChecker.Option.NO_FALLBACK));
                parameters.addCertPathChecker(revocationChecker);
            }
            parameters.addCertPathChecker(new AppleExtensionCertPathChecker());
            PKIXCertPathValidatorResult certPathValidatorResult = (PKIXCertPathValidatorResult) certPathValidator.validate(certPath, parameters);
            return certPathValidatorResult.getPublicKey();
        } catch (Exception e) {
            throw new VerificationException(VerificationStatus.INVALID_CHAIN, e);
        }
    }
}
