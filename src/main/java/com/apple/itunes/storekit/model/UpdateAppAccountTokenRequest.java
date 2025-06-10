// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The request body that contains an app account token value.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/updateappaccounttokenrequest">UpdateAppAccountTokenRequest</a>
 **/
public class UpdateAppAccountTokenRequest {
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";
    @JsonProperty(value = SERIALIZED_NAME_APP_ACCOUNT_TOKEN, required = true)
    private UUID appAccountToken;

    private UpdateAppAccountTokenRequest() {
    }

    public UpdateAppAccountTokenRequest(UUID appAccountToken) {
        Objects.requireNonNull(appAccountToken);
        this.appAccountToken = appAccountToken;
    }

    public UpdateAppAccountTokenRequest appAccountToken(UUID appAccountToken) {
        Objects.requireNonNull(appAccountToken);
        this.appAccountToken = appAccountToken;
        return this;
    }

    /**
     * The UUID that an app optionally generates to map a customer’s in-app purchase with its resulting App Store transaction.
     *
     * @return appAccountToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appaccounttoken">appAccountToken</a>
     **/
    public UUID getAppAccountToken() {
        return appAccountToken;
    }

    public void setAppAccountToken(UUID appAccountToken) {
        Objects.requireNonNull(appAccountToken);
        this.appAccountToken = appAccountToken;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UpdateAppAccountTokenRequest)) return false;
        UpdateAppAccountTokenRequest that = (UpdateAppAccountTokenRequest) o;
        return Objects.equals(getAppAccountToken(), that.getAppAccountToken());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getAppAccountToken());
    }

    @Override
    public String toString() {
        return "UpdateAppAccountTokenRequest{" +
                "appAccountToken=" + appAccountToken +
                '}';
    }
}
