// Copyright (c) 2024 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * The payload data that contains an external purchase token.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/externalpurchasetoken">externalPurchaseToken</a>
 */
public class ExternalPurchaseToken {
    private static final String SERIALIZED_NAME_EXTERNAL_PURCHASE_ID = "externalPurchaseId";
    private static final String SERIALIZED_NAME_TOKEN_CREATION_DATE = "tokenCreationDate";
    private static final String SERIALIZED_NAME_APP_APPLE_ID = "appAppleId";
    private static final String SERIALIZED_NAME_BUNDLE_ID = "bundleId";
    private static final String SERIALIZED_NAME_TOKEN_TYPE = "tokenType";
    private static final String SERIALIZED_NAME_TOKEN_EXPIRATION_DATE = "tokenExpirationDate";
    @JsonProperty(SERIALIZED_NAME_EXTERNAL_PURCHASE_ID)
    private String externalPurchaseId;
    @JsonProperty(SERIALIZED_NAME_TOKEN_CREATION_DATE)
    private Long tokenCreationDate;
    @JsonProperty(SERIALIZED_NAME_APP_APPLE_ID)
    private Long appAppleId;
    @JsonProperty(SERIALIZED_NAME_BUNDLE_ID)
    private String bundleId;
    @JsonProperty(SERIALIZED_NAME_TOKEN_TYPE)
    private String tokenType;
    @JsonProperty(SERIALIZED_NAME_TOKEN_EXPIRATION_DATE)
    private Long tokenExpirationDate;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public ExternalPurchaseToken() {
    }

    public ExternalPurchaseToken externalPurchaseId(String externalPurchaseId) {
        this.externalPurchaseId = externalPurchaseId;
        return this;
    }

    /**
     * The field of an external purchase token that uniquely identifies the token.
     *
     * @return externalPurchaseId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/externalpurchaseid">externalPurchaseId</a>
     **/
    public String getExternalPurchaseId() {
        return externalPurchaseId;
    }

    public void setExternalPurchaseId(String externalPurchaseId) {
        this.externalPurchaseId = externalPurchaseId;
    }

    public ExternalPurchaseToken tokenCreationDate(Long tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
        return this;
    }

    /**
     * The field of an external purchase token that contains the UNIX date, in milliseconds, when the system created the token.
     *
     * @return tokenCreationDate
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/tokencreationdate">tokenCreationDate</a>
     **/
    public Long getTokenCreationDate() {
        return tokenCreationDate;
    }

    public void setTokenCreationDate(Long tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
    }

    public ExternalPurchaseToken appAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
        return this;
    }

    /**
     * The unique identifier of an app in the App Store.
     *
     * @return appAppleId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/appappleid">appAppleId</a>
     **/
    public Long getAppAppleId() {
        return appAppleId;
    }

    public void setAppAppleId(Long appAppleId) {
        this.appAppleId = appAppleId;
    }

    public ExternalPurchaseToken bundleId(String bundleId) {
        this.bundleId = bundleId;
        return this;
    }

    /**
     * The bundle identifier of an app.
     *
     * @return bundleId
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/bundleid">bundleId</a>
     **/
    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public ExternalPurchaseToken tokenType(TokenType tokenType) {
        this.tokenType = tokenType != null ? tokenType.getValue() : null;
        return this;
    }

    /**
     * The type of an external purchase custom link token.
     *
     * @return tokenType
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/tokentype">tokenType</a>
     **/
    public TokenType getTokenType() {
        return tokenType != null ? TokenType.fromValue(tokenType) : null;
    }

    /**
     * @see #getTokenType()
     */
    public String getRawTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType != null ? tokenType.getValue() : null;
    }

    public void setRawTokenType(String rawTokenType) {
        this.tokenType = rawTokenType;
    }

    public ExternalPurchaseToken tokenExpirationDate(Long tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
        return this;
    }

    /**
     * The field of a custom link token that contains the UNIX date, in milliseconds, when the token expires.
     *
     * @return tokenExpirationDate
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/tokenexpirationdate">tokenExpirationDate</a>
     **/
    public Long getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(Long tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public ExternalPurchaseToken unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     Fields that are not recognized for this object

     @return A map of JSON keys to objects
     */
    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }

    public void setUnknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExternalPurchaseToken externalPurchaseToken = (ExternalPurchaseToken) o;
        return Objects.equals(this.externalPurchaseId, externalPurchaseToken.externalPurchaseId) &&
                Objects.equals(this.tokenCreationDate, externalPurchaseToken.tokenCreationDate) &&
                Objects.equals(this.appAppleId, externalPurchaseToken.appAppleId) &&
                Objects.equals(this.bundleId, externalPurchaseToken.bundleId) &&
                Objects.equals(this.tokenType, externalPurchaseToken.tokenType) &&
                Objects.equals(this.tokenExpirationDate, externalPurchaseToken.tokenExpirationDate) &&
                Objects.equals(this.unknownFields, externalPurchaseToken.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalPurchaseId, tokenCreationDate, appAppleId, bundleId, tokenType, tokenExpirationDate, unknownFields);
    }

    @Override
    public String toString() {
        return "ExternalPurchaseToken{" +
                "externalPurchaseId='" + externalPurchaseId + '\'' +
                ", tokenCreationDate=" + tokenCreationDate +
                ", appAppleId=" + appAppleId +
                ", bundleId='" + bundleId + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", tokenExpirationDate=" + tokenExpirationDate +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

