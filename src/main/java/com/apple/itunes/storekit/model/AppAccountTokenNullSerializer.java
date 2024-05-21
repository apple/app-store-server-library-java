package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.UUID;

public class AppAccountTokenNullSerializer extends JsonSerializer<UUID> {
    @Override
    public void serialize(UUID uuid, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString("");
    }
}
