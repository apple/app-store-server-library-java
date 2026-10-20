// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The request body that contains an app account token value.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/updateappaccounttokenrequest">UpdateAppAccountTokenRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateAppAccountTokenRequest {
    private static final String SERIALIZED_NAME_APP_ACCOUNT_TOKEN = "appAccountToken";

    @JsonProperty(value = SERIALIZED_NAME_APP_ACCOUNT_TOKEN, required = true)
    private UUID appAccountToken;

    protected UpdateAppAccountTokenRequest() {
    }

    public UpdateAppAccountTokenRequest(UUID appAccountToken) {
        this.appAccountToken = Objects.requireNonNull(appAccountToken);
    }

    public UpdateAppAccountTokenRequest appAccountToken(UUID appAccountToken) {
        this.appAccountToken = Objects.requireNonNull(appAccountToken);
        return this;
    }

    /**
     * A UUID value to associate with the transaction you indicate in the endpoint parameter.
     *
     * @return appAccountToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/appaccounttoken">appAccountToken</a>
     **/
    public UUID getAppAccountToken() {
        return appAccountToken;
    }

    public void setAppAccountToken(UUID appAccountToken) {
        this.appAccountToken = Objects.requireNonNull(appAccountToken);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateAppAccountTokenRequest updateAppAccountTokenRequest = (UpdateAppAccountTokenRequest) o;
        return Objects.equals(this.appAccountToken, updateAppAccountTokenRequest.appAccountToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appAccountToken);
    }

    @Override
    public String toString() {
        return "UpdateAppAccountTokenRequest{" +
                "appAccountToken=" + appAccountToken +
                '}';
    }
}
