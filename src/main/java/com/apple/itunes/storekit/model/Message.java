// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * A message identifier you provide in a real-time response to your Get Retention Message endpoint.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/message">message</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER)
    private UUID messageIdentifier;


    public Message() {
    }

    public Message messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
        return this;
    }

    /**
     * The identifier of the message to display to the customer.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message that = (Message) o;
        return Objects.equals(messageIdentifier, that.messageIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageIdentifier=" + messageIdentifier +
                '}';
    }
}