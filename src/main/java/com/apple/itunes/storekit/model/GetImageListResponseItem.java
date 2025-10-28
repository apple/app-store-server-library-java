// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * An image identifier and state information for an image.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/getimagelistresponseitem">GetImageListResponseItem</a>
 */
public class GetImageListResponseItem {
    private static final String SERIALIZED_NAME_IMAGE_IDENTIFIER = "imageIdentifier";
    private static final String SERIALIZED_NAME_IMAGE_STATE = "imageState";
    @JsonProperty(SERIALIZED_NAME_IMAGE_IDENTIFIER)
    private UUID imageIdentifier;
    @JsonProperty(SERIALIZED_NAME_IMAGE_STATE)
    private String imageState;
    @JsonAnySetter
    private Map<String, Object> unknownFields;

    public GetImageListResponseItem() {
    }

    public GetImageListResponseItem imageIdentifier(UUID imageIdentifier) {
        this.imageIdentifier = imageIdentifier;
        return this;
    }

    /**
     * The identifier of the image.
     *
     * @return imageIdentifier
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imageidentifier">imageIdentifier</a>
     **/
    public UUID getImageIdentifier() {
        return imageIdentifier;
    }

    public void setImageIdentifier(UUID imageIdentifier) {
        this.imageIdentifier = imageIdentifier;
    }

    public GetImageListResponseItem imageState(ImageState imageState) {
        this.imageState = imageState != null ? imageState.getValue() : null;
        return this;
    }

    /**
     * The current state of the image.
     *
     * @return imageState
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/imagestate">imageState</a>
     **/
    public ImageState getImageState() {
        return imageState != null ? ImageState.fromValue(imageState) : null;
    }

    /**
     * @see #getImageState()
     */
    public String getRawImageState() {
        return imageState;
    }

    public void setImageState(ImageState imageState) {
        this.imageState = imageState != null ? imageState.getValue() : null;
    }

    public void setRawImageState(String rawImageState) {
        this.imageState = rawImageState;
    }


    public GetImageListResponseItem unknownFields(Map<String, Object> unknownFields) {
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
        GetImageListResponseItem getImageListResponseItem = (GetImageListResponseItem) o;
        return Objects.equals(this.imageIdentifier, getImageListResponseItem.imageIdentifier) &&
                Objects.equals(this.imageState, getImageListResponseItem.imageState) &&
                Objects.equals(this.unknownFields, getImageListResponseItem.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageIdentifier, imageState, unknownFields);
    }

    @Override
    public String toString() {
        return "GetImageListResponseItem{" +
                "imageIdentifier=" + imageIdentifier +
                ", imageState='" + imageState + '\'' +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

