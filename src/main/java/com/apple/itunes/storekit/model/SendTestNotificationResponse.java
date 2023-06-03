// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * A response that contains the test notification token.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/sendtestnotificationresponse">SendTestNotificationResponse</a>
 */
public class SendTestNotificationResponse {
    private static final String SERIALIZED_NAME_TEST_NOTIFICATION_TOKEN = "testNotificationToken";
    @SerializedName(SERIALIZED_NAME_TEST_NOTIFICATION_TOKEN)
    private String testNotificationToken;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SendTestNotificationResponse sendTestNotificationResponse = (SendTestNotificationResponse) o;
        return Objects.equals(this.testNotificationToken, sendTestNotificationResponse.testNotificationToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testNotificationToken);
    }

    @Override
    public String toString() {
        return "SendTestNotificationResponse{" +
                "testNotificationToken='" + testNotificationToken + '\'' +
                '}';
    }
}

