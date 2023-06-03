// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * A decoded payload containing the version 2 notification data.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/responsebodyv2decodedpayload"></a>
 */
public class ResponseBodyV2DecodedPayload implements DecodedSignedData {
    private static final String SERIALIZED_NAME_NOTIFICATION_TYPE = "notificationType";
    private static final String SERIALIZED_NAME_SUBTYPE = "subtype";
    private static final String SERIALIZED_NAME_NOTIFICATION_U_U_I_D = "notificationUUID";
    private static final String SERIALIZED_NAME_DATA = "data";
    private static final String SERIALIZED_NAME_VERSION = "version";
    private static final String SERIALIZED_NAME_SIGNED_DATE = "signedDate";
    private static final String SERIALIZED_NAME_SUMMARY = "summary";
    @SerializedName(SERIALIZED_NAME_NOTIFICATION_TYPE)
    private NotificationTypeV2 notificationType;
    @SerializedName(SERIALIZED_NAME_SUBTYPE)
    private Subtype subtype;
    @SerializedName(SERIALIZED_NAME_NOTIFICATION_U_U_I_D)
    private String notificationUUID;
    @SerializedName(SERIALIZED_NAME_DATA)
    private Data data;
    @SerializedName(SERIALIZED_NAME_VERSION)
    private String version;
    @SerializedName(SERIALIZED_NAME_SIGNED_DATE)
    private Long signedDate;
    @SerializedName(SERIALIZED_NAME_SUMMARY)
    private Summary summary;


    public ResponseBodyV2DecodedPayload() {
    }

    public ResponseBodyV2DecodedPayload notificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    /**
     * The in-app purchase event for which the App Store sends this version 2 notification.
     *
     * @return notificationType
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/notificationtype">notificationType</a>
     **/
    public NotificationTypeV2 getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType;
    }

    public ResponseBodyV2DecodedPayload subtype(Subtype subtype) {
        this.subtype = subtype;
        return this;
    }

    /**
     * Additional information that identifies the notification event. The subtype field is present only for specific version 2 notifications.
     *
     * @return subtype
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/subtype">subtype</a>
     **/
    public Subtype getSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype;
    }

    public ResponseBodyV2DecodedPayload notificationUUID(String notificationUUID) {
        this.notificationUUID = notificationUUID;
        return this;
    }

    /**
     * A unique identifier for the notification.
     *
     * @return notificationUUID
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/notificationuuid">notificationUUID</a>
     **/
    public String getNotificationUUID() {
        return notificationUUID;
    }

    public void setNotificationUUID(String notificationUUID) {
        this.notificationUUID = notificationUUID;
    }

    public ResponseBodyV2DecodedPayload data(Data data) {
        this.data = data;
        return this;
    }

    /**
     * The object that contains the app metadata and signed renewal and transaction information.
     * The data and summary fields are mutually exclusive. The payload contains one of the fields, but not both.
     *
     * @return data
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/data">data</a>
     **/
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ResponseBodyV2DecodedPayload version(String version) {
        this.version = version;
        return this;
    }

    /**
     * A string that indicates the notification’s App Store Server Notifications version number.
     *
     * @return version
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/version">version</a>
     **/
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ResponseBodyV2DecodedPayload signedDate(Long signedDate) {
        this.signedDate = signedDate;
        return this;
    }

    /**
     * The UNIX time, in milliseconds, that the App Store signed the JSON Web Signature data.
     *
     * @return signedDate
     * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/signeddate">signedDate</a>
     **/
    public Long getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Long signedDate) {
        this.signedDate = signedDate;
    }

    public ResponseBodyV2DecodedPayload summary(Summary summary) {
        this.summary = summary;
        return this;
    }

    /**
     * The summary data that appears when the App Store server completes your request to extend a subscription renewal date for eligible subscribers.
     * The data and summary fields are mutually exclusive. The payload contains one of the fields, but not both.
     *
     * @return summary
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/summary">summary</a>
     **/
    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBodyV2DecodedPayload responseBodyV2DecodedPayload = (ResponseBodyV2DecodedPayload) o;
        return Objects.equals(this.notificationType, responseBodyV2DecodedPayload.notificationType) &&
                Objects.equals(this.subtype, responseBodyV2DecodedPayload.subtype) &&
                Objects.equals(this.notificationUUID, responseBodyV2DecodedPayload.notificationUUID) &&
                Objects.equals(this.data, responseBodyV2DecodedPayload.data) &&
                Objects.equals(this.version, responseBodyV2DecodedPayload.version) &&
                Objects.equals(this.signedDate, responseBodyV2DecodedPayload.signedDate) &&
                Objects.equals(this.summary, responseBodyV2DecodedPayload.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationType, subtype, notificationUUID, data, version, signedDate, summary);
    }

    @Override
    public String toString() {
        return "ResponseBodyV2DecodedPayload{" +
                "notificationType=" + notificationType +
                ", subtype=" + subtype +
                ", notificationUUID='" + notificationUUID + '\'' +
                ", data=" + data +
                ", version='" + version + '\'' +
                ", signedDate=" + signedDate +
                ", summary=" + summary +
                '}';
    }
}

