// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * A message identifier and status information for a message.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/getmessagelistresponseitem">GetMessageListResponseItem</a>
 */
public class GetMessageListResponseItem {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    private static final String SERIALIZED_NAME_MESSAGE_STATE = "messageState";
    @JsonProperty(SERIALIZED_NAME_MESSAGE_IDENTIFIER)
    private UUID messageIdentifier;
    @JsonProperty(SERIALIZED_NAME_MESSAGE_STATE)
    private String messageState;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public GetMessageListResponseItem() {
    }

    public GetMessageListResponseItem messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
        return this;
    }

    /**
     * The identifier of the message.
     *
     * @return messageIdentifier
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messageidentifier">messageIdentifier</a>
     **/
    public UUID getMessageIdentifier() {
        return messageIdentifier;
    }

    public void setMessageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
    }

    public GetMessageListResponseItem messageState(MessageState messageState) {
        this.messageState = messageState != null ? messageState.getValue() : null;
        return this;
    }

    /**
     * The current state of the message.
     *
     * @return messageState
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messageState">messageState</a>
     **/
    public MessageState getMessageState() {
        return messageState != null ? MessageState.fromValue(messageState) : null;
    }

    /**
     * @see #getMessageState()
     */
    public String getRawMessageState() {
        return messageState;
    }

    public void setMessageState(MessageState messageState) {
        this.messageState = messageState != null ? messageState.getValue() : null;
    }

    public void setRawMessageState(String rawMessageState) {
        this.messageState = rawMessageState;
    }


    public GetMessageListResponseItem unknownFields(Map<String, Object> unknownFields) {
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
        GetMessageListResponseItem sendAttemptItem = (GetMessageListResponseItem) o;
        return Objects.equals(this.messageIdentifier, sendAttemptItem.messageIdentifier) &&
                Objects.equals(this.messageState, sendAttemptItem.messageState) &&
                Objects.equals(this.unknownFields, sendAttemptItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier, messageState, unknownFields);
    }

    @Override
    public String toString() {
        return "GetMessageListResponseItem{" +
                "messageIdentifier=" + messageIdentifier +
                ", messageState='" + messageState + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

