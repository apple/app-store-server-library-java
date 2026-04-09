// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The response body that contains the default configuration information.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/defaultconfigurationresponse">DefaultConfigurationResponse</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultConfigurationResponse {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";
    @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER, required = true)
    private UUID messageIdentifier;

    private DefaultConfigurationResponse() {
    }

    public DefaultConfigurationResponse(UUID messageIdentifier) {
        this.messageIdentifier = Objects.requireNonNull(messageIdentifier);
    }

    public DefaultConfigurationResponse messageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = Objects.requireNonNull(messageIdentifier);
        return this;
    }

    /**
     * The message identifier of the retention message you configured as a default.
     *
     * @return messageIdentifier
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/messageidentifier">messageIdentifier</a>
     **/
    public UUID getMessageIdentifier() {
        return messageIdentifier;
    }

    public void setMessageIdentifier(UUID messageIdentifier) {
        this.messageIdentifier = Objects.requireNonNull(messageIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DefaultConfigurationResponse defaultConfigurationResponse = (DefaultConfigurationResponse) o;
        return Objects.equals(this.messageIdentifier, defaultConfigurationResponse.messageIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier);
    }

    @Override
    public String toString() {
        return "DefaultConfigurationResponse{" +
                "messageIdentifier=" + messageIdentifier +
                '}';
    }
}

