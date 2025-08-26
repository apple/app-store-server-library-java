// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import java.util.List;
import java.util.Objects;

public final class AdvancedCommerceValidationUtils {
    
    public static final int MAXIMUM_DESCRIPTION_LENGTH = 45;
    public static final int MAXIMUM_DISPLAY_NAME_LENGTH = 30;
    private static final int MAXIMUM_SKU_LENGTH = 128;
    private static final int MIN_PERIOD = 1;
    private static final int MAX_PERIOD = 12;

    /**
     * Validates description is not null and does not exceed maximum length.
     *
     * @param description the description to validate
     * @return the validated description
     * @throws IllegalArgumentException if description exceeds maximum length
     */
    public static String validateDescription(String description) {
        return validateStringWithMaxLength(description, MAXIMUM_DESCRIPTION_LENGTH, "description");
    }

    /**
     * Validates display name is not null and does not exceed maximum length.
     *
     * @param displayName the display name to validate
     * @return the validated display name
     * @throws IllegalArgumentException if display name exceeds maximum length
     */
    public static String validateDisplayName(String displayName) {
        return validateStringWithMaxLength(displayName, MAXIMUM_DISPLAY_NAME_LENGTH, "displayName");
    }

    /**
     * Validates SKU does not exceed maximum length.
     * 
     * @param sku
     * @return the validated SKU
     * @throws IllegalArgumentException if SKU exceeds maximum length
     */
    public static String validateSku(String sku) {
        if (sku != null && sku.length() > MAXIMUM_SKU_LENGTH) {
            throw new IllegalArgumentException("SKU length cannot exceed " + MAXIMUM_SKU_LENGTH + " characters");
        }
        return sku;
    }

    /**
     * Validates periodCount is not null and between `MIN_PERIOD` and `MAX_PERIOD` inclusive.
     * 
     * @param periodCount
     * @throws IllegalArgumentException if periodCount is null or out of range 
     */
    public static Integer validatePeriodCount(Integer periodCount) {
        Objects.requireNonNull(periodCount, "periodCount cannot be null");
        if (periodCount < MIN_PERIOD || periodCount > MAX_PERIOD) {
            throw new IllegalArgumentException("Period count must be between " + MIN_PERIOD + " and " + MAX_PERIOD);
        }
        return periodCount;
    }

    /**
     * Validates a list of items is not null, not empty, and contains no null elements.
     * 
     * @param list the list of items to validate
     * @param <T> the type of items in the list, must extend AbstractAdvancedCommerceItem
     * @return the validated list of items
     * @throws IllegalArgumentException if the list is null, empty, or contains null elements
     */
    public static <T extends AbstractAdvancedCommerceItem> List<T> validateItems(List<T> list) {
        if (list == null) {
           throw new IllegalArgumentException("Items list cannot be null");
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException("Items list cannot be empty");
        }

        for (T item : list) {
            if (item == null) {
                throw new IllegalArgumentException("Item in the list cannot be null");
            }
        }

        return list;
    }

    private static String validateStringWithMaxLength(String value, int maxLength, String fieldName) { 
        Objects.requireNonNull(value, fieldName + " cannot be null"); 
        if (value.length() > maxLength) { 
            throw new IllegalArgumentException(fieldName + " length cannot exceed " + maxLength + " characters"); 
        } 
        return value;
    }
}