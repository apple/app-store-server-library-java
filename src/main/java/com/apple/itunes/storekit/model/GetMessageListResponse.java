// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains status information for all messages.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/getmessagelistresponse">GetMessageListResponse</a>
 */
public class GetMessageListResponse {
    private static final String SERIALIZED_NAME_MESSAGE_IDENTIFIERS = "messageIdentifiers";
    @JsonProperty(SERIALIZED_NAME_MESSAGE_IDENTIFIERS)
    private List<GetMessageListResponseItem> messageIdentifiers;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public GetMessageListResponse() {
    }

    public GetMessageListResponse messageIdentifiers(List<GetMessageListResponseItem> messageIdentifiers) {
        this.messageIdentifiers = messageIdentifiers;
        return this;
    }

    /**
     * An array of all message identifiers and their message state.
     *
     * @return messageIdentifiers
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/getmessagelistresponseitem">messageIdentifiers</a>
     **/
    public List<GetMessageListResponseItem> getMessageIdentifiers() {
        return messageIdentifiers;
    }

    public void setMessageIdentifiers(List<GetMessageListResponseItem> messageIdentifiers) {
        this.messageIdentifiers = messageIdentifiers;
    }

    public GetMessageListResponse unknownFields(Map<String, Object> unknownFields) {
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
        GetMessageListResponse getMessageListResponse = (GetMessageListResponse) o;
        return Objects.equals(this.messageIdentifiers, getMessageListResponse.messageIdentifiers) &&
                Objects.equals(this.unknownFields, getMessageListResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageIdentifiers, unknownFields);
    }

    @Override
    public String toString() {
        return "GetMessageListResponse{" +
                "messageIdentifiers=" + messageIdentifiers +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

