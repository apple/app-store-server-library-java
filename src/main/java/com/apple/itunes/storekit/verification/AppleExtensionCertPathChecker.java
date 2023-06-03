// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Set;

public class AppleExtensionCertPathChecker extends PKIXCertPathChecker {

    private static final String WWDR_INTERMEDIATE_OID = "1.2.840.113635.100.6.2.1";
    private static final String RECEIPT_SIGNER_OID = "1.2.840.113635.100.6.11.1";

    private int currentDepth;
    private boolean forward;

    @Override
    public void init(boolean forward) {
        currentDepth = 0;
        this.forward = forward;
    }

    @Override
    public AppleExtensionCertPathChecker clone() {
        AppleExtensionCertPathChecker clone = (AppleExtensionCertPathChecker) super.clone();
        clone.currentDepth = this.currentDepth;
        clone.forward = this.forward;
        return clone;
    }

    @Override
    public boolean isForwardCheckingSupported() {
        return true;
    }

    @Override
    public Set<String> getSupportedExtensions() {
        return Set.of(WWDR_INTERMEDIATE_OID, RECEIPT_SIGNER_OID);
    }

    @Override
    public void check(Certificate cert, Collection<String> unresolvedCritExts) throws CertPathValidatorException {
        X509Certificate xcert = (X509Certificate) cert;
        if (forward && currentDepth == 0 || (!forward && currentDepth == 1)) {
            if (!xcert.getNonCriticalExtensionOIDs().contains(RECEIPT_SIGNER_OID)) {
                throw new CertPathValidatorException("OID: " + RECEIPT_SIGNER_OID + " was not found on the signing certificate");
            }
        }
        if (forward && currentDepth == 1 || (!forward && currentDepth == 0)) {
            if (!xcert.getNonCriticalExtensionOIDs().contains(WWDR_INTERMEDIATE_OID)) {
                throw new CertPathValidatorException("OID: " + WWDR_INTERMEDIATE_OID + " was not found on the intermediate WWDR certificate");
            }
        }
        if (currentDepth >= 2) {
            throw new CertPathValidatorException("Maximum depth exceeded");
        }
        ++currentDepth;
    }
}
