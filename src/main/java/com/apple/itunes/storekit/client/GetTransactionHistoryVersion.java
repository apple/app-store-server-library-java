// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.client;

public enum GetTransactionHistoryVersion {

    /**
     * @deprecated Use {@link #V2} instead.
     */
    @Deprecated(since = "2.2.0")
    V1("v1"),
    V2("v2");

    private final String urlVersion;

    GetTransactionHistoryVersion(String urlVersion) {
        this.urlVersion = urlVersion;
    }

    String getUrlVersion() {
        return urlVersion;
    }
}
