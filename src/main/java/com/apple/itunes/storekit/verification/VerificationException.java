// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

public class VerificationException extends Exception {

    private final VerificationStatus status;

    public VerificationException(VerificationStatus status) {
        super("Verification failed with status " + status);
        this.status = status;
    }

    public VerificationException(VerificationStatus status, String message) {
        super("Verification failed with status " + status + ". " + message);
        this.status = status;
    }

    public VerificationException(VerificationStatus status, Throwable cause) {
        super("Verification failed with status " + status, cause);
        this.status = status;
    }

    public VerificationStatus getStatus() {
        return this.status;
    }
}
