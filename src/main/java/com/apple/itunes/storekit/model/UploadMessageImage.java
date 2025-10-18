// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The definition of an image with its alternative text.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/uploadmessageimage">UploadMessageImage</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadMessageImage {
    private static final String SERIALIZED_NAME_IMAGE_IDENTIFIER = "imageIdentifier";
    private static final String SERIALIZED_NAME_ALT_TEXT = "altText";
    @JsonProperty(value = SERIALIZED_NAME_IMAGE_IDENTIFIER, required = true)
    private UUID imageIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_ALT_TEXT, required = true)
    private String altText;

    private static final int MAXIMUM_ALT_TEXT_LENGTH = 150;

    private UploadMessageImage() {
    }

    public UploadMessageImage(UUID imageIdentifier,
                              String altText) {
        this.imageIdentifier = Objects.requireNonNull(imageIdentifier);
        this.altText = validateAltText(altText);
    }

    public UploadMessageImage imageIdentifier(UUID imageIdentifier) {
        this.imageIdentifier = Objects.requireNonNull(imageIdentifier);
        return this;
    }

    /**
     * The unique identifier of an image.
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


    public UploadMessageImage altText(String altText) {
        this.altText = validateAltText(altText);
        return this;
    }

    /**
     * The alternative text you provide for the corresponding image.
     *
     * @return altText
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/alttext">altText</a>
     **/
    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = validateAltText(altText);
    }

    private String validateAltText(String altText) {
        Objects.requireNonNull(altText);
        if (altText.length() > MAXIMUM_ALT_TEXT_LENGTH) {
            throw new IllegalArgumentException("altText length longer than maximum allowed");
        }
        return altText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UploadMessageImage uploadMessageImage = (UploadMessageImage) o;
        return Objects.equals(this.imageIdentifier, uploadMessageImage.imageIdentifier) &&
                Objects.equals(this.altText, uploadMessageImage.altText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageIdentifier, altText);
    }

    @Override
    public String toString() {
        return "UploadMessageImage{" +
                "imageIdentifier=" + imageIdentifier +
                ", altText='" + altText + '\'' +
                '}';
    }
}

