// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * The text and its bullet-point image to include in a retention message’s bulleted list.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/bulletpoint">BulletPoint</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulletPoint {
    private static final String SERIALIZED_NAME_TEXT = "text";
    private static final String SERIALIZED_NAME_IMAGE_IDENTIFIER = "imageIdentifier";
    private static final String SERIALIZED_NAME_ALT_TEXT = "altText";
    @JsonProperty(value = SERIALIZED_NAME_TEXT, required = true)
    private String text;
    @JsonProperty(value = SERIALIZED_NAME_IMAGE_IDENTIFIER, required = true)
    private UUID imageIdentifier;
    @JsonProperty(value = SERIALIZED_NAME_ALT_TEXT, required = true)
    private String altText;

    private static final int MAXIMUM_TEXT_LENGTH = 66;
    private static final int MAXIMUM_ALT_TEXT_LENGTH = 150;

    private BulletPoint() {
    }

    public BulletPoint(String text,
                       UUID imageIdentifier,
                       String altText) {
        this.text = validateText(text);
        this.imageIdentifier = Objects.requireNonNull(imageIdentifier);
        this.altText = validateAltText(altText);
    }

    public BulletPoint text(String text) {
        this.text = validateText(text);
        return this;
    }

    /**
     * The text of the individual bullet point.
     *
     * @return text
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/bulletpointtext">bulletPointText</a>
     **/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = validateText(text);
    }

    public BulletPoint imageIdentifier(UUID imageIdentifier) {
        this.imageIdentifier = Objects.requireNonNull(imageIdentifier);
        return this;
    }

    /**
     * The identifier of the image to use as the bullet point.
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

    public BulletPoint altText(String altText) {
        this.altText = validateAltText(altText);
        return this;
    }

    /**
     * The alternative text you provide for the corresponding image of the bullet point.
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

    private String validateText(String text) {
        Objects.requireNonNull(text);
        if (text.length() > MAXIMUM_TEXT_LENGTH) {
            throw new IllegalArgumentException("text length longer than maximum allowed");
        }
        return text;
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
        BulletPoint bulletPoint = (BulletPoint) o;
        return Objects.equals(this.text, bulletPoint.text) &&
                Objects.equals(this.imageIdentifier, bulletPoint.imageIdentifier) &&
                Objects.equals(this.altText, bulletPoint.altText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, imageIdentifier, altText);
    }

    @Override
    public String toString() {
        return "BulletPoint{" +
                "text='" + text + '\'' +
                ", imageIdentifier=" + imageIdentifier +
                ", altText='" + altText + '\'' +
                '}';
    }
}