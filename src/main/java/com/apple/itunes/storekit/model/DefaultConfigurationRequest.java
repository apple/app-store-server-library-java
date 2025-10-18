// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The request body that contains the default configuration information.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/defaultconfigurationrequest">DefaultConfigurationRequest</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultConfigurationRequest {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    @JsonProperty(SERIALIZED_NAME_MESSAGE_IDENTIFIER)
    private UUID messageIdentifier;

    public DefaultConfigurationRequest() {
    }

    public DefaultConfigurationRequest messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = messageIdentifier;
        return this;
    }

    /**
     * The message identifier of the message to configure as a default message.
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultConfigurationRequest defaultConfigurationRequest = (DefaultConfigurationRequest) o;
        return Objects.equals(this.messageIdentifier, defaultConfigurationRequest.messageIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier);
    }

    @Override
    public String toString() {
        return "DefaultConfigurationRequest{" +
                "messageIdentifier=" + messageIdentifier +
                '}';
    }
}

