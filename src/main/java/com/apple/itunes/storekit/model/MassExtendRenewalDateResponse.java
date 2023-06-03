// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * A response that indicates the server successfully received the subscription-renewal-date extension request.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/massextendrenewaldateresponse">MassExtendRenewalDateResponse</a>
 */
public class MassExtendRenewalDateResponse {
    private static final String SERIALIZED_NAME_REQUEST_IDENTIFIER = "requestIdentifier";
    @SerializedName(SERIALIZED_NAME_REQUEST_IDENTIFIER)
    private String requestIdentifier;


    public MassExtendRenewalDateResponse() {
    }

    public MassExtendRenewalDateResponse requestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
        return this;
    }

    /**
     * A string that contains a unique identifier you provide to track each subscription-renewal-date extension request.
     *
     * @return requestIdentifier
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/requestidentifier">requestIdentifier</a>
     **/
    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    public void setRequestIdentifier(String requestIdentifier) {
        this.requestIdentifier = requestIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MassExtendRenewalDateResponse massExtendRenewalDateResponse = (MassExtendRenewalDateResponse) o;
        return Objects.equals(this.requestIdentifier, massExtendRenewalDateResponse.requestIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestIdentifier);
    }

    @Override
    public String toString() {
        return "MassExtendRenewalDateResponse{" +
                "requestIdentifier='" + requestIdentifier + '\'' +
                '}';
    }
}

