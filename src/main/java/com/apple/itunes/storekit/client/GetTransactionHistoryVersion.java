package com.apple.itunes.storekit.client;

public enum GetTransactionHistoryVersion {

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
