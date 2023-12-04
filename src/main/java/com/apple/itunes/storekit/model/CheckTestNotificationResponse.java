// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains the contents of the test notification sent by the App Store server and the result from your server.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/checktestnotificationresponse">CheckTestNotificationResponse</a>
 */
public class CheckTestNotificationResponse {
    private static final String SERIALIZED_NAME_SIGNED_PAYLOAD = "signedPayload";
    private static final String SERIALIZED_NAME_SEND_ATTEMPTS = "sendAttempts";
    @JsonProperty(SERIALIZED_NAME_SIGNED_PAYLOAD)
    private String signedPayload;
    @JsonProperty(SERIALIZED_NAME_SEND_ATTEMPTS)
    private List<SendAttemptItem> sendAttempts;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public CheckTestNotificationResponse() {
    }

    public CheckTestNotificationResponse signedPayload(String signedPayload) {
        this.signedPayload = signedPayload;
        return this;
    }

    /**
     * A cryptographically signed payload, in JSON Web Signature (JWS) format, containing the response body for a version 2 notification.
     *
     * @return signedPayload
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/signedpayload">signedPayload</a>
     **/
    public String getSignedPayload() {
        return signedPayload;
    }

    public void setSignedPayload(String signedPayload) {
        this.signedPayload = signedPayload;
    }

    public CheckTestNotificationResponse sendAttempts(List<SendAttemptItem> sendAttempts) {
        this.sendAttempts = sendAttempts;
        return this;
    }

    /**
     * An array of information the App Store server records for its attempts to send the TEST notification to your server. The array may contain a maximum of six sendAttemptItem objects.
     *
     * @return sendAttempts
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendattemptitem">sendAttemptItem</a>
     **/
    public List<SendAttemptItem> getSendAttempts() {
        return sendAttempts;
    }

    public void setSendAttempts(List<SendAttemptItem> sendAttempts) {
        this.sendAttempts = sendAttempts;
    }

    public CheckTestNotificationResponse unknownFields(Map<String, Object> unknownFields) {
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
        CheckTestNotificationResponse checkTestNotificationResponse = (CheckTestNotificationResponse) o;
        return Objects.equals(this.signedPayload, checkTestNotificationResponse.signedPayload) &&
                Objects.equals(this.sendAttempts, checkTestNotificationResponse.sendAttempts) &&
                Objects.equals(this.unknownFields, checkTestNotificationResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signedPayload, sendAttempts, unknownFields);
    }

    @Override
    public String toString() {
        return "CheckTestNotificationResponse{" +
                "signedPayload='" + signedPayload + '\'' +
                ", sendAttempts=" + sendAttempts +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

