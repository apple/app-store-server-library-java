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
import java.time.Clock;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChainVerifier {
    private static final int EXPECTED_CHAIN_LENGTH = 3;
    private static final int MAXIMUM_CACHE_SIZE = 32; // There are unlikely to be more than a couple keys at once
    private static final int CACHE_TIME_LIMIT = 15; // 15 minutes

    private final Set<TrustAnchor> trustAnchors;
    private final ConcurrentHashMap<List<String>, CachedEntry> verifiedPublicKeyCache;
    private final Clock clock;

    public ChainVerifier(Set<InputStream> rootCertificates) {
        this(rootCertificates, Clock.systemUTC());
    }

    ChainVerifier(Set<InputStream> rootCertificates, Clock clock) {
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
        this.verifiedPublicKeyCache = new ConcurrentHashMap<>();
        this.clock = clock;
    }

    public PublicKey verifyChain(String[] certificates, boolean performRevocationChecking, Date effectiveDate) throws VerificationException {
        if (performRevocationChecking && certificates.length > 0) {
            // If revocation checking is enabled (which also implies effectiveDate is now), check the cache
            PublicKey cachedKey = getCachedPrivateKey(Arrays.asList(certificates));
            if (cachedKey != null) {
                return cachedKey;
            }
        }
        PublicKey publicKey = verifyChainWithoutCaching(certificates, performRevocationChecking, effectiveDate);
        if (performRevocationChecking) {
            putVerifiedPublicKey(Arrays.asList(certificates), publicKey);
        }
        return publicKey;
    }

    PublicKey verifyChainWithoutCaching(String[] certificates, boolean performRevocationChecking, Date effectiveDate) throws VerificationException {
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

    private PublicKey getCachedPrivateKey(List<String> certificateChain) {
        if (verifiedPublicKeyCache.containsKey(certificateChain) && verifiedPublicKeyCache.get(certificateChain).cachedExpirationDate.isAfter(clock.instant())) {
            return verifiedPublicKeyCache.get(certificateChain).publicKey;
        }
        return null;
    }

    private void putVerifiedPublicKey(List<String> certificateChain, PublicKey publicKey) {
        Instant cacheExpiration = clock.instant().plus(CACHE_TIME_LIMIT, ChronoUnit.MINUTES);
        verifiedPublicKeyCache.put(certificateChain, new CachedEntry(cacheExpiration, publicKey));
        if (verifiedPublicKeyCache.size() > MAXIMUM_CACHE_SIZE) {
            // In the very unlikely event that the map has become too large, clear out old entries
            verifiedPublicKeyCache.entrySet().removeIf(e -> e.getValue().cachedExpirationDate.isBefore(clock.instant()));
        }
    }

    private static class CachedEntry {
        private final Instant cachedExpirationDate;
        private final PublicKey publicKey;

        public CachedEntry(Instant cachedExpirationDate, PublicKey publicKey) {
            this.cachedExpirationDate = cachedExpirationDate;
            this.publicKey = publicKey;
        }
    }
}
