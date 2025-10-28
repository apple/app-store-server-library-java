// Copyright (c) 2025 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

public class UUIDLowercaseSerializer extends JsonSerializer<UUID> {
    @Override
    public void serialize(UUID uuid, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (uuid != null) {
            jsonGenerator.writeString(uuid.toString().toLowerCase(Locale.ROOT));
        } else {
            jsonGenerator.writeNull();
        }
    }
}
