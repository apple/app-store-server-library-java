// Copyright (c) 2023 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The age of the customer’s account.
 *
 * @see <a href="https://developer.apple.com/documentation/appstoreserverapi/accounttenure">accountTenure</a>
 */
@JsonAdapter(AccountTenure.Adapter.class)
public enum AccountTenure {

    UNDECLARED(0),
    ZERO_TO_THREE_DAYS(1),
    THREE_DAYS_TO_TEN_DAYS(2),
    TEN_DAYS_TO_THIRTY_DAYS(3),
    THIRTY_DAYS_TO_NINETY_DAYS(4),
    NINETY_DAYS_TO_ONE_HUNDRED_EIGHTY_DAYS(5),
    ONE_HUNDRED_EIGHTY_DAYS_TO_THREE_HUNDRED_SIXTY_FIVE_DAYS(6),
    GREATER_THAN_THREE_HUNDRED_SIXTY_FIVE_DAYS(7);

    private final Integer value;

    AccountTenure(Integer value) {
        this.value = value;
    }

    public static AccountTenure fromValue(Integer value) {
        for (AccountTenure b : AccountTenure.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public Integer getValue() {
        return value;
    }

    public static class Adapter extends TypeAdapter<AccountTenure> {
        @Override
        public void write(final JsonWriter jsonWriter, final AccountTenure enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public AccountTenure read(final JsonReader jsonReader) throws IOException {
            Integer value = jsonReader.nextInt();
            return AccountTenure.fromValue(value);
        }
    }
}

