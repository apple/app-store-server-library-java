// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A response that contains status information for all images.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/getimagelistresponse">GetImageListResponse</a>
 */
public class GetImageListResponse {
    private static final String SERIALIZED_NAME_IMAGE_IDENTIFIERS = "imageIdentifiers";
    @JsonProperty(SERIALIZED_NAME_IMAGE_IDENTIFIERS)
    private List<GetImageListResponseItem> imageIdentifiers;
    @JsonAnySetter
    private Map<String, Object> unknownFields;


    public GetImageListResponse() {
    }

    public GetImageListResponse imageIdentifiers(List<GetImageListResponseItem> imageIdentifiers) {
        this.imageIdentifiers = imageIdentifiers;
        return this;
    }

    /**
     * An array of all image identifiers and their image state.
     *
     * @return imageIdentifiers
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/getimagelistresponseitem">GetImageListResponseItem</a>
     **/
    public List<GetImageListResponseItem> getImageIdentifiers() {
        return imageIdentifiers;
    }

    public void setImageIdentifiers(List<GetImageListResponseItem> imageIdentifiers) {
        this.imageIdentifiers = imageIdentifiers;
    }

    public GetImageListResponse unknownFields(Map<String, Object> unknownFields) {
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
        GetImageListResponse getImageListResponse = (GetImageListResponse) o;
        return Objects.equals(this.imageIdentifiers, getImageListResponse.imageIdentifiers) &&
                Objects.equals(this.unknownFields, getImageListResponse.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageIdentifiers, unknownFields);
    }

    @Override
    public String toString() {
        return "GetImageListResponse{" +
                "imageIdentifiers=" + imageIdentifiers +
                ", unknownFields=" + unknownFields +
                '}';
    }
}

