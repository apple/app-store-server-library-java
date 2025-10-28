// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body for uploading a message, which includes the message text and an optional image reference.
 *
 * @see <a href="https://developer.apple.com/documentation/retentionmessaging/uploadmessagerequestbody">UploadMessageRequestBody</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadMessageRequestBody {
    private static final String SERIALIZED_NAME_HEADER = "header";
    private static final String SERIALIZED_NAME_BODY = "body";
    private static final String SERIALIZED_NAME_IMAGE = "image";
    @JsonProperty(value = SERIALIZED_NAME_HEADER, required = true)
    private String header;
    @JsonProperty(value = SERIALIZED_NAME_BODY, required = true)
    private String body;
    @JsonProperty(value = SERIALIZED_NAME_IMAGE)
    private UploadMessageImage image;

    private static final int MAXIMUM_HEADER_LENGTH = 66;
    private static final int MAXIMUM_BODY_LENGTH = 144;

    private UploadMessageRequestBody() {
    }

    public UploadMessageRequestBody(String header,
                                    String body,
                                    UploadMessageImage image) {
        this.header = validateHeader(header);
        this.body = validateBody(body);
        this.image = image;
    }

    public UploadMessageRequestBody header(String header) {
        this.header = validateHeader(header);
        return this;
    }

    /**
     * The header text of the retention message that the system displays to customers.
     *
     * @return header
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/header">header</a>
     **/
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = validateHeader(header);
    }

    private String validateHeader(String header) {
        Objects.requireNonNull(header);
        if (header.length() > MAXIMUM_HEADER_LENGTH) {
            throw new IllegalArgumentException("header length longer than maximum allowed");
        }
        return header;
    }

    public UploadMessageRequestBody body(String body) {
        this.body = validateBody(body);
        return this;
    }

    /**
     * The body text of the retention message that the system displays to customers.
     *
     * @return body
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/body">body</a>
     **/
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = validateBody(body);
    }

    private String validateBody(String body) {
        Objects.requireNonNull(body);
        if (body.length() > MAXIMUM_BODY_LENGTH) {
            throw new IllegalArgumentException("body length longer than maximum allowed");
        }
        return body;
    }

    public UploadMessageRequestBody image(UploadMessageImage image) {
        this.image = image;
        return this;
    }

    /**
     * The optional image identifier and its alternative text to appear as part of a text-based message with an image.
     *
     * @return image
     * @see <a href="https://developer.apple.com/documentation/retentionmessaging/uploadmessageimage">UploadMessageImage</a>
     **/
    public UploadMessageImage getImage() {
        return image;
    }

    public void setImage(UploadMessageImage image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UploadMessageRequestBody uploadMessageRequestBody = (UploadMessageRequestBody) o;
        return Objects.equals(this.header, uploadMessageRequestBody.header) &&
                Objects.equals(this.body, uploadMessageRequestBody.body) &&
                Objects.equals(this.image, uploadMessageRequestBody.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, body, image);
    }

    @Override
    public String toString() {
        return "UploadMessageRequestBody{" +
                "header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", image=" + image +
                '}';
    }
}

