// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type that describes the In-App Purchase or external purchase event for which the App Store sends the version 2 notification.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/notificationtype">notificationType</a>
 **/
public enum NotificationTypeV2 {

    /**
     * A notification type that, along with its subtype, indicates that the customer subscribed to an auto-renewable subscription.
     **/
    SUBSCRIBED("SUBSCRIBED"),
    /**
     * A notification type that, along with its subtype, indicates that the customer made a change to their subscription plan.
     **/
    DID_CHANGE_RENEWAL_PREF("DID_CHANGE_RENEWAL_PREF"),
    /**
     * A notification type that, along with its subtype, indicates that the customer made a change to the subscription renewal status.
     **/
    DID_CHANGE_RENEWAL_STATUS("DID_CHANGE_RENEWAL_STATUS"),
    /**
     * A notification type that, along with its subtype, indicates that a customer with an active subscription redeemed a subscription offer.
     **/
    OFFER_REDEEMED("OFFER_REDEEMED"),
    /**
     * A notification type that, along with its subtype, indicates that the subscription successfully renewed.
     **/
    DID_RENEW("DID_RENEW"),
    /**
     * A notification type that, along with its subtype, indicates that a subscription expired.
     **/
    EXPIRED("EXPIRED"),
    /**
     * A notification type that, along with its subtype, indicates that the subscription failed to renew due to a billing issue.
     **/
    DID_FAIL_TO_RENEW("DID_FAIL_TO_RENEW"),
    /**
     * A notification type that indicates that the billing grace period has ended without renewing the subscription, so you can turn off access to the service or content.
     **/
    GRACE_PERIOD_EXPIRED("GRACE_PERIOD_EXPIRED"),
    /**
     * A notification type that, along with its subtype, indicates that the system has informed the customer of an auto-renewable subscription price increase.
     **/
    PRICE_INCREASE("PRICE_INCREASE"),
    /**
     * A notification type that indicates that the App Store successfully refunded a transaction for a consumable In-App Purchase, a non-consumable In-App Purchase, an auto-renewable subscription, or a non-renewing subscription.
     **/
    REFUND("REFUND"),
    /**
     * A notification type that indicates the App Store declined a refund request.
     **/
    REFUND_DECLINED("REFUND_DECLINED"),
    /**
     * A notification type that indicates that the customer initiated a refund request for a consumable In-App Purchase or auto-renewable subscription, and the App Store is requesting that you provide consumption data.
     **/
    CONSUMPTION_REQUEST("CONSUMPTION_REQUEST"),
    /**
     * A notification type that indicates the App Store extended the subscription renewal date for a specific subscription.
     **/
    RENEWAL_EXTENDED("RENEWAL_EXTENDED"),
    /**
     * A notification type that indicates that an In-App Purchase the customer was entitled to through Family Sharing is no longer available through sharing.
     **/
    REVOKE("REVOKE"),
    /**
     * A notification type that the App Store server sends when you request it by calling the Request a Test Notification endpoint.
     **/
    TEST("TEST"),
    /**
     * A notification type that, along with its subtype, indicates that the App Store is attempting to extend the subscription renewal date that you request by calling Extend Subscription Renewal Dates for All Active Subscribers.
     **/
    RENEWAL_EXTENSION("RENEWAL_EXTENSION"),
    /**
     * A notification type that indicates the App Store reversed a previously granted refund due to a dispute that the customer raised.
     **/
    REFUND_REVERSED("REFUND_REVERSED"),
    /**
     * A notification type that applies only to apps that get tokens from the External Purchase or TransactionReporting APIs.
     **/
    EXTERNAL_PURCHASE_TOKEN("EXTERNAL_PURCHASE_TOKEN"),
    /**
     * A notification type that indicates the customer purchased a consumable, non-consumable, or non-renewing subscription.
     **/
    ONE_TIME_CHARGE("ONE_TIME_CHARGE"),
    /**
     * A notification type that indicates that you called the Change Subscription Price endpoint.
     **/
    PRICE_CHANGE("PRICE_CHANGE"),
    /**
     * A notification type that indicates you used the Change Subscription Metadata endpoint to change the metadata for a subscription.
     **/
    METADATA_UPDATE("METADATA_UPDATE"),
    /**
     * A notification type that indicates you used the Migrate Subscription to Advanced Commerce API endpoint.
     **/
    MIGRATION("MIGRATION"),
    /**
     * A notification type that indicates the parent or guardian has withdrawn consent for a child’s app usage.
     **/
    RESCIND_CONSENT("RESCIND_CONSENT");

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
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
