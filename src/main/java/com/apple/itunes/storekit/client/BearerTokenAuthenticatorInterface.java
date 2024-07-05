// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

@FunctionalInterface
public interface BearerTokenAuthenticatorInterface {
    String generateToken();
}
