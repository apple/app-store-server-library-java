// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * The response body that contains the default configuration information.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/defaultconfigurationresponse">DefaultConfigurationResponse</a>
 **/
public class DefaultConfigurationResponse {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIER = "messageIdentifier";

    @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER, required = true)
    private UUID messageIdentifier;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    protected DefaultConfigurationResponse() {
    }

    @JsonCreator
    public DefaultConfigurationResponse(
            @JsonProperty(value = SERIALIZED_NAME_MESSAGE_IDENTIFIER, required = true) UUID messageIdentifier
    ) {
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

    public DefaultConfigurationResponse unknownFields(Map<String, Object> unknownFields) {
        this.unknownFields = unknownFields;
        return this;
    }

    /**
     * Fields that are not recognized for this object
     *
     * @return A map of JSON keys to objects
     **/
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
        DefaultConfigurationResponse defaultConfigurationResponse = (DefaultConfigurationResponse) o;
        return Objects.equals(this.messageIdentifier, defaultConfigurationResponse.messageIdentifier) &&
                Objects.equals(this.unknownFields, defaultConfigurationResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifier, unknownFields);
    }

    @Override
    public String toString() {
        return "DefaultConfigurationResponse{" +
                "messageIdentifier=" + messageIdentifier +
                ", unknownFields=" + unknownFields +
                '}';
    }
}
