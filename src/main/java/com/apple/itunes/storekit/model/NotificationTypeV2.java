// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * A notification type value that App Store Server Notifications V2 uses.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/notificationtype">notificationType</a>
 */
@JsonAdapter(NotificationTypeV2.Adapter.class)
public enum NotificationTypeV2 {

    SUBSCRIBED("SUBSCRIBED"),
    DID_CHANGE_RENEWAL_PREF("DID_CHANGE_RENEWAL_PREF"),
    DID_CHANGE_RENEWAL_STATUS("DID_CHANGE_RENEWAL_STATUS"),
    OFFER_REDEEMED("OFFER_REDEEMED"),
    DID_RENEW("DID_RENEW"),
    EXPIRED("EXPIRED"),
    DID_FAIL_TO_RENEW("DID_FAIL_TO_RENEW"),
    GRACE_PERIOD_EXPIRED("GRACE_PERIOD_EXPIRED"),
    PRICE_INCREASE("PRICE_INCREASE"),
    REFUND("REFUND"),
    REFUND_DECLINED("REFUND_DECLINED"),
    CONSUMPTION_REQUEST("CONSUMPTION_REQUEST"),
    RENEWAL_EXTENDED("RENEWAL_EXTENDED"),
    REVOKE("REVOKE"),
    TEST("TEST"),
    RENEWAL_EXTENSION("RENEWAL_EXTENSION"),
    REFUND_REVERSED("REFUND_REVERSED");

    private final String value;

    NotificationTypeV2(String value) {
        this.value = value;
    }

    public static NotificationTypeV2 fromValue(String value) {
        for (NotificationTypeV2 b : NotificationTypeV2.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Adapter extends TypeAdapter<NotificationTypeV2> {
        @Override
        public void write(final JsonWriter jsonWriter, final NotificationTypeV2 enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public NotificationTypeV2 read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return NotificationTypeV2.fromValue(value);
        }
    }
}

