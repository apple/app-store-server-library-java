// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.verification;

public enum VerificationStatus {
    OK,
    VERIFICATION_FAILURE,
    INVALID_APP_IDENTIFIER,
    INVALID_ENVIRONMENT,
    INVALID_CERTIFICATE,
    INVALID_CHAIN_LENGTH,
    INVALID_CHAIN
}
