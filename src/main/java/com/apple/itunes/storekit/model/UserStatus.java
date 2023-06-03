// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The status of a customer’s account within your app.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/userstatus">userStatus</a>
 */
@JsonAdapter(UserStatus.Adapter.class)
public enum UserStatus {

    UNDECLARED(0),
    ACTIVE(1),
    SUSPENDED(2),
    TERMINATED(3),
    LIMITED_ACCESS(4);

    private final Integer value;

    UserStatus(Integer value) {
        this.value = value;
    }

    public static UserStatus fromValue(Integer value) {
        for (UserStatus b : UserStatus.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Adapter extends TypeAdapter<UserStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final UserStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public UserStatus read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return UserStatus.fromValue(value);
        }
    }
}

