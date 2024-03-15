// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
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
    private static final String SERIALIZED_NAME_EXTERNAL_PURCHASE_TOKEN = "externalPurchaseToken";
    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_TYPE)
    private String notificationType;
    @JsonProperty(SERIALIZED_NAME_SUBTYPE)
    private String subtype;
    @JsonProperty(SERIALIZED_NAME_NOTIFICATION_U_U_I_D)
    private String notificationUUID;
    @JsonProperty(SERIALIZED_NAME_DATA)
    private Data data;
    @JsonProperty(SERIALIZED_NAME_VERSION)
    private String version;
    @JsonProperty(SERIALIZED_NAME_SIGNED_DATE)
    private Long signedDate;
    @JsonProperty(SERIALIZED_NAME_SUMMARY)
    private Summary summary;
    @JsonProperty(SERIALIZED_NAME_EXTERNAL_PURCHASE_TOKEN)
    private ExternalPurchaseToken externalPurchaseToken;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public ResponseBodyV2DecodedPayload() {
    }

    public ResponseBodyV2DecodedPayload notificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType != null ? notificationType.getValue() : null;
        return this;
    }

    /**
     * The in-app purchase event for which the App Store sends this version 2 notification.
     *
     * @return notificationType
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/notificationtype">notificationType</a>
     **/
    public NotificationTypeV2 getNotificationType() {
        return notificationType != null ? NotificationTypeV2.fromValue(notificationType) : null;
    }

    /**
     * @see #getNotificationType()
     */
    public String getRawNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeV2 notificationType) {
        this.notificationType = notificationType != null ? notificationType.getValue() : null;
    }

    public void setRawNotificationType(String rawNotificationType) {
        this.notificationType = rawNotificationType;
    }

    public ResponseBodyV2DecodedPayload subtype(Subtype subtype) {
        this.subtype = subtype != null ? subtype.getValue() : null;
        return this;
    }

    /**
     * Additional information that identifies the notification event. The subtype field is present only for specific version 2 notifications.
     *
     * @return subtype
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/subtype">subtype</a>
     **/
    public Subtype getSubtype() {
        return subtype != null ? Subtype.fromValue(subtype) : null;
    }

    /**
     * @see #getSubtype()
     */
    public String getRawSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype != null ? subtype.getValue() : null;
    }

    public void setRawSubtype(String rawSubtype) {
        this.subtype = rawSubtype;
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
     * The data, summary, and externalPurchaseToken fields are mutually exclusive. The payload contains only one of these fields.
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
     * The data, summary, and externalPurchaseToken fields are mutually exclusive. The payload contains only one of these fields.
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

    public ResponseBodyV2DecodedPayload externalPurchaseToken(ExternalPurchaseToken externalPurchaseToken) {
        this.externalPurchaseToken = externalPurchaseToken;
        return this;
    }

    /**
     * This field appears when the notificationType is EXTERNAL_PURCHASE_TOKEN.
     * The data, summary, and externalPurchaseToken fields are mutually exclusive. The payload contains only one of these fields.
     *
     * @return externalPurchaseToken
     * @see <a href="https://developer.apple.com/documentation/appstoreservernotifications/externalpurchasetoken">externalPurchaseToken</a>
     **/
    public ExternalPurchaseToken getExternalPurchaseToken() {
        return externalPurchaseToken;
    }

    public void setExternalPurchaseToken(ExternalPurchaseToken externalPurchaseToken) {
        this.externalPurchaseToken = externalPurchaseToken;
    }

    public ResponseBodyV2DecodedPayload unknownFields(Map<String, Object> unknownFields) {
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
        ResponseBodyV2DecodedPayload responseBodyV2DecodedPayload = (ResponseBodyV2DecodedPayload) o;
        return Objects.equals(this.notificationType, responseBodyV2DecodedPayload.notificationType) &&
                Objects.equals(this.subtype, responseBodyV2DecodedPayload.subtype) &&
                Objects.equals(this.notificationUUID, responseBodyV2DecodedPayload.notificationUUID) &&
                Objects.equals(this.data, responseBodyV2DecodedPayload.data) &&
                Objects.equals(this.version, responseBodyV2DecodedPayload.version) &&
                Objects.equals(this.signedDate, responseBodyV2DecodedPayload.signedDate) &&
                Objects.equals(this.summary, responseBodyV2DecodedPayload.summary) &&
                Objects.equals(this.externalPurchaseToken, responseBodyV2DecodedPayload.externalPurchaseToken) &&
                Objects.equals(this.unknownFields, responseBodyV2DecodedPayload.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationType, subtype, notificationUUID, data, version, signedDate, summary, externalPurchaseToken, unknownFields);
    }

    @Override
    public String toString() {
        return "ResponseBodyV2DecodedPayload{" +
                "notificationType='" + notificationType + '\'' +
                ", subtype='" + subtype + '\'' +
                ", notificationUUID='" + notificationUUID + '\'' +
                ", data=" + data +
                ", version='" + version + '\'' +
                ", signedDate=" + signedDate +
                ", summary=" + summary +
                ", externalPurchaseToken=" + externalPurchaseToken +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

