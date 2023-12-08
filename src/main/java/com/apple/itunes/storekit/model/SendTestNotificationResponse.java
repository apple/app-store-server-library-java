// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

/**
 * A response that contains the test notification token.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendtestnotificationresponse">SendTestNotificationResponse</a>
 */
public class SendTestNotificationResponse {
    private static final String SERIALIZED_NAME_TEST_NOTIFICATION_TOKEN = "testNotificationToken";
    @JsonProperty(SERIALIZED_NAME_TEST_NOTIFICATION_TOKEN)
    private String testNotificationToken;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public SendTestNotificationResponse() {
    }

    public SendTestNotificationResponse testNotificationToken(String testNotificationToken) {
        this.testNotificationToken = testNotificationToken;
        return this;
    }

    /**
     * A unique identifier for a notification test that the App Store server sends to your server.
     *
     * @return testNotificationToken
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/testnotificationtoken">testNotificationToken</a>
     **/
    public String getTestNotificationToken() {
        return testNotificationToken;
    }

    public void setTestNotificationToken(String testNotificationToken) {
        this.testNotificationToken = testNotificationToken;
    }


    public SendTestNotificationResponse unknownFields(Map<String, Object> unknownFields) {
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
        SendTestNotificationResponse sendTestNotificationResponse = (SendTestNotificationResponse) o;
        return Objects.equals(this.testNotificationToken, sendTestNotificationResponse.testNotificationToken) &&
                Objects.equals(this.unknownFields, sendTestNotificationResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testNotificationToken, unknownFields);
    }

    @Override
    public String toString() {
        return "SendTestNotificationResponse{" +
                "testNotificationToken='" + testNotificationToken + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

