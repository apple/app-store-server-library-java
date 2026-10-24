// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.TestingUtility;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class AdvancedCommerceModelsTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testAdvancedCommercePeriod() {
        Assertions.assertEquals("P1W", AdvancedCommercePeriod.P1W.getValue());
        Assertions.assertEquals("P1M", AdvancedCommercePeriod.P1M.getValue());
        Assertions.assertEquals("P2M", AdvancedCommercePeriod.P2M.getValue());
        Assertions.assertEquals("P3M", AdvancedCommercePeriod.P3M.getValue());
        Assertions.assertEquals("P6M", AdvancedCommercePeriod.P6M.getValue());
        Assertions.assertEquals("P1Y", AdvancedCommercePeriod.P1Y.getValue());

        Assertions.assertEquals(AdvancedCommercePeriod.P1W, AdvancedCommercePeriod.fromValue("P1W"));
        Assertions.assertEquals(AdvancedCommercePeriod.P1M, AdvancedCommercePeriod.fromValue("P1M"));
        Assertions.assertEquals(AdvancedCommercePeriod.P1Y, AdvancedCommercePeriod.fromValue("P1Y"));
        Assertions.assertNull(AdvancedCommercePeriod.fromValue("INVALID"));

        Assertions.assertEquals("P1W", AdvancedCommercePeriod.P1W.toString());
    }

    @Test
    public void testAdvancedCommerceReason() {
        Assertions.assertEquals("UPGRADE", AdvancedCommerceReason.UPGRADE.getValue());
        Assertions.assertEquals("DOWNGRADE", AdvancedCommerceReason.DOWNGRADE.getValue());
        Assertions.assertEquals("APPLY_OFFER", AdvancedCommerceReason.APPLY_OFFER.getValue());

        Assertions.assertEquals(AdvancedCommerceReason.UPGRADE, AdvancedCommerceReason.fromValue("UPGRADE"));
        Assertions.assertEquals(AdvancedCommerceReason.DOWNGRADE, AdvancedCommerceReason.fromValue("DOWNGRADE"));
        Assertions.assertEquals(AdvancedCommerceReason.APPLY_OFFER, AdvancedCommerceReason.fromValue("APPLY_OFFER"));
        Assertions.assertNull(AdvancedCommerceReason.fromValue("INVALID"));

        Assertions.assertEquals("UPGRADE", AdvancedCommerceReason.UPGRADE.toString());
    }

    @Test
    public void testAdvancedCommerceRefundReason() {
        Assertions.assertEquals("UNINTENDED_PURCHASE", AdvancedCommerceRefundReason.UNINTENDED_PURCHASE.getValue());
        Assertions.assertEquals("FULFILLMENT_ISSUE", AdvancedCommerceRefundReason.FULFILLMENT_ISSUE.getValue());
        Assertions.assertEquals("UNSATISFIED_WITH_PURCHASE", AdvancedCommerceRefundReason.UNSATISFIED_WITH_PURCHASE.getValue());
        Assertions.assertEquals("LEGAL", AdvancedCommerceRefundReason.LEGAL.getValue());
        Assertions.assertEquals("OTHER", AdvancedCommerceRefundReason.OTHER.getValue());
        Assertions.assertEquals("MODIFY_ITEMS_REFUND", AdvancedCommerceRefundReason.MODIFY_ITEMS_REFUND.getValue());
        Assertions.assertEquals("SIMULATE_REFUND_DECLINE", AdvancedCommerceRefundReason.SIMULATE_REFUND_DECLINE.getValue());

        Assertions.assertEquals(AdvancedCommerceRefundReason.LEGAL,
            AdvancedCommerceRefundReason.fromValue("LEGAL"));
        Assertions.assertEquals(AdvancedCommerceRefundReason.OTHER,
            AdvancedCommerceRefundReason.fromValue("OTHER"));
        Assertions.assertNull(AdvancedCommerceRefundReason.fromValue("INVALID"));

        Assertions.assertEquals("LEGAL", AdvancedCommerceRefundReason.LEGAL.toString());
    }

    @Test
    public void testAdvancedCommerceRefundType() {
        Assertions.assertEquals("FULL", AdvancedCommerceRefundType.FULL.getValue());
        Assertions.assertEquals("PRORATED", AdvancedCommerceRefundType.PRORATED.getValue());
        Assertions.assertEquals("CUSTOM", AdvancedCommerceRefundType.CUSTOM.getValue());

        Assertions.assertEquals(AdvancedCommerceRefundType.FULL, AdvancedCommerceRefundType.fromValue("FULL"));
        Assertions.assertEquals(AdvancedCommerceRefundType.PRORATED, AdvancedCommerceRefundType.fromValue("PRORATED"));
        Assertions.assertEquals(AdvancedCommerceRefundType.CUSTOM, AdvancedCommerceRefundType.fromValue("CUSTOM"));
        Assertions.assertNull(AdvancedCommerceRefundType.fromValue("INVALID"));

        Assertions.assertEquals("FULL", AdvancedCommerceRefundType.FULL.toString());
    }

    @Test
    public void testAdvancedCommerceOfferPeriod() {
        Assertions.assertEquals("P3D", AdvancedCommerceOfferPeriod.P3D.getValue());
        Assertions.assertEquals("P1W", AdvancedCommerceOfferPeriod.P1W.getValue());
        Assertions.assertEquals("P2W", AdvancedCommerceOfferPeriod.P2W.getValue());
        Assertions.assertEquals("P1M", AdvancedCommerceOfferPeriod.P1M.getValue());
        Assertions.assertEquals("P2M", AdvancedCommerceOfferPeriod.P2M.getValue());
        Assertions.assertEquals("P3M", AdvancedCommerceOfferPeriod.P3M.getValue());

        Assertions.assertEquals(AdvancedCommerceOfferPeriod.P1W, AdvancedCommerceOfferPeriod.fromValue("P1W"));
        Assertions.assertEquals(AdvancedCommerceOfferPeriod.P1M, AdvancedCommerceOfferPeriod.fromValue("P1M"));
        Assertions.assertEquals(AdvancedCommerceOfferPeriod.P3D, AdvancedCommerceOfferPeriod.fromValue("P3D"));
        Assertions.assertNull(AdvancedCommerceOfferPeriod.fromValue("INVALID"));

        Assertions.assertEquals("P1W", AdvancedCommerceOfferPeriod.P1W.toString());
    }

    @Test
    public void testAdvancedCommerceOfferReason() {
        Assertions.assertEquals("ACQUISITION", AdvancedCommerceOfferReason.ACQUISITION.getValue());
        Assertions.assertEquals("WIN_BACK", AdvancedCommerceOfferReason.WIN_BACK.getValue());
        Assertions.assertEquals("RETENTION", AdvancedCommerceOfferReason.RETENTION.getValue());

        Assertions.assertEquals(AdvancedCommerceOfferReason.ACQUISITION,
            AdvancedCommerceOfferReason.fromValue("ACQUISITION"));
        Assertions.assertEquals(AdvancedCommerceOfferReason.WIN_BACK,
            AdvancedCommerceOfferReason.fromValue("WIN_BACK"));
        Assertions.assertEquals(AdvancedCommerceOfferReason.RETENTION,
            AdvancedCommerceOfferReason.fromValue("RETENTION"));
        Assertions.assertNull(AdvancedCommerceOfferReason.fromValue("INVALID"));

        Assertions.assertEquals("WIN_BACK", AdvancedCommerceOfferReason.WIN_BACK.toString());
    }

    @Test
    public void testAdvancedCommerceEffective() {
        Assertions.assertEquals("IMMEDIATELY", AdvancedCommerceEffective.IMMEDIATELY.getValue());
        Assertions.assertEquals("NEXT_BILL_CYCLE", AdvancedCommerceEffective.NEXT_BILL_CYCLE.getValue());

        Assertions.assertEquals(AdvancedCommerceEffective.IMMEDIATELY,
            AdvancedCommerceEffective.fromValue("IMMEDIATELY"));
        Assertions.assertEquals(AdvancedCommerceEffective.NEXT_BILL_CYCLE,
            AdvancedCommerceEffective.fromValue("NEXT_BILL_CYCLE"));
        Assertions.assertNull(AdvancedCommerceEffective.fromValue("INVALID"));

        Assertions.assertEquals("IMMEDIATELY", AdvancedCommerceEffective.IMMEDIATELY.toString());
    }

    @Test
    public void testValidationUtilsDescription() {
        String validDescription = "Valid description";
        Assertions.assertEquals(validDescription, HelperValidationUtils.validateDescription(validDescription));

        String maxLengthDescription = "A".repeat(45);
        Assertions.assertEquals(maxLengthDescription,
            HelperValidationUtils.validateDescription(maxLengthDescription));

        String tooLongDescription = "A".repeat(46);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateDescription(tooLongDescription));

        Assertions.assertThrows(NullPointerException.class,
            () -> HelperValidationUtils.validateDescription(null));
    }

    @Test
    public void testValidationUtilsDisplayName() {
        String validDisplayName = "Valid Name";
        Assertions.assertEquals(validDisplayName, HelperValidationUtils.validateDisplayName(validDisplayName));

        String maxLengthDisplayName = "A".repeat(30);
        Assertions.assertEquals(maxLengthDisplayName,
            HelperValidationUtils.validateDisplayName(maxLengthDisplayName));

        String tooLongDisplayName = "A".repeat(31);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateDisplayName(tooLongDisplayName));

        Assertions.assertThrows(NullPointerException.class,
            () -> HelperValidationUtils.validateDisplayName(null));
    }

    @Test
    public void testValidationUtilsSku() {
        String validSku = "valid.sku.123";
        Assertions.assertEquals(validSku, HelperValidationUtils.validateSku(validSku));

        String maxLengthSku = "A".repeat(128);
        Assertions.assertEquals(maxLengthSku, HelperValidationUtils.validateSku(maxLengthSku));

        String tooLongSku = "A".repeat(129);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateSku(tooLongSku));

        Assertions.assertNull(HelperValidationUtils.validateSku(null));
    }

    @Test
    public void testValidationUtilsPeriodCount() {
        Assertions.assertEquals(1, HelperValidationUtils.validatePeriodCount(1));
        Assertions.assertEquals(6, HelperValidationUtils.validatePeriodCount(6));
        Assertions.assertEquals(12, HelperValidationUtils.validatePeriodCount(12));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validatePeriodCount(0));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validatePeriodCount(13));
        Assertions.assertThrows(NullPointerException.class,
            () -> HelperValidationUtils.validatePeriodCount(null));
    }

    @Test
    public void testValidationUtilsItems() {
        List<AdvancedCommerceOneTimeChargeItem> validList = Arrays.asList(
            new AdvancedCommerceOneTimeChargeItem("desc", "name", "sku1", 1000L)
        );
        Assertions.assertEquals(validList, HelperValidationUtils.validateItems(validList));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateItems(null));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateItems(new ArrayList<>()));

        List<AdvancedCommerceOneTimeChargeItem> listWithNull = new ArrayList<>();
        listWithNull.add(null);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateItems(listWithNull));
    }

    @Test
    public void testAdvancedCommerceDescriptors() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceDescriptors.json");

        AdvancedCommerceDescriptors descriptors = objectMapper.readValue(json, AdvancedCommerceDescriptors.class);
        Assertions.assertEquals("description", descriptors.getDescription());
        Assertions.assertEquals("display name", descriptors.getDisplayName());
    }

    @Test
    public void testAdvancedCommerceOneTimeChargeItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceOneTimeChargeItem.json");

        AdvancedCommerceOneTimeChargeItem item = objectMapper.readValue(json, AdvancedCommerceOneTimeChargeItem.class);
        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("display name", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals(15000L, item.getPrice());
    }

    @Test
    public void testAdvancedCommerceSubscriptionCreateItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionCreateItem.json");

        AdvancedCommerceSubscriptionCreateItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionCreateItem.class);
        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("display name", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals(20000L, item.getPrice());
    }

    @Test
    public void testAdvancedCommerceRequestRefundItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceRequestRefundItem.json");

        AdvancedCommerceRequestRefundItem item = objectMapper.readValue(json, AdvancedCommerceRequestRefundItem.class);
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals(AdvancedCommerceRefundReason.LEGAL, item.getRefundReason());
        Assertions.assertEquals(AdvancedCommerceRefundType.FULL, item.getRefundType());
        Assertions.assertEquals(true, item.getRevoke());
        Assertions.assertEquals(5000L, item.getRefundAmount());
    }

    @Test
    public void testAdvancedCommerceRequestRefundItemRefundAmountIs64Bit() throws Exception {
        long refundAmount = Integer.MAX_VALUE + 1000L;
        AdvancedCommerceRequestRefundItem item = new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.CUSTOM, false)
                .refundAmount(refundAmount);

        String json = createRequestObjectMapper().writeValueAsString(item);
        Assertions.assertEquals(refundAmount, objectMapper.readTree(json).get("refundAmount").longValue());
        Assertions.assertEquals(refundAmount, objectMapper.readValue(json, AdvancedCommerceRequestRefundItem.class).getRefundAmount());
    }

    @Test
    public void testAdvancedCommerceOffer() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceOffer.json");

        AdvancedCommerceOffer offer = objectMapper.readValue(json, AdvancedCommerceOffer.class);
        Assertions.assertEquals(AdvancedCommerceOfferPeriod.P1W, offer.getPeriod());
        Assertions.assertEquals(3, offer.getPeriodCount());
        Assertions.assertEquals(5000L, offer.getPrice());
        Assertions.assertEquals(AdvancedCommerceOfferReason.WIN_BACK, offer.getReason());
    }


    @Test
    public void testAdvancedCommerceOneTimeChargeCreateRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceOneTimeChargeCreateRequest.json");

        AdvancedCommerceOneTimeChargeCreateRequest request =
            objectMapper.readValue(json, AdvancedCommerceOneTimeChargeCreateRequest.class);

        Assertions.assertEquals("USD", request.getCurrency());
        Assertions.assertNotNull(request.getItem());
        Assertions.assertEquals("taxCode", request.getTaxCode());
        Assertions.assertNotNull(request.getRequestInfo());
        Assertions.assertEquals("USA", request.getStorefront());
    }

    @Test
    public void testAdvancedCommerceSubscriptionCreateRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionCreateRequest.json");

        AdvancedCommerceSubscriptionCreateRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionCreateRequest.class);

        Assertions.assertEquals("USD", request.getCurrency());
        Assertions.assertNotNull(request.getDescriptors());
        Assertions.assertNotNull(request.getItems());
        Assertions.assertEquals(2, request.getItems().size());
        Assertions.assertEquals(AdvancedCommercePeriod.P1M, request.getPeriod());
        Assertions.assertEquals("taxCode", request.getTaxCode());
        Assertions.assertEquals("USA", request.getStorefront());
        Assertions.assertEquals("transactionId", request.getPreviousTransactionId());
    }

    @Test
    public void testAdvancedCommerceRequestRefundRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceRequestRefundRequest.json");

        AdvancedCommerceRequestRefundRequest request =
            objectMapper.readValue(json, AdvancedCommerceRequestRefundRequest.class);

        Assertions.assertNotNull(request.getItems());
        Assertions.assertEquals(2, request.getItems().size());
        Assertions.assertTrue(request.getRefundRiskingPreference());
        Assertions.assertNotNull(request.getRequestInfo());
        Assertions.assertEquals("USD", request.getCurrency());
        Assertions.assertEquals("USA", request.getStorefront());
    }

    @Test
    public void testAdvancedCommerceSubscriptionCancelRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionCancelRequest.json");

        AdvancedCommerceSubscriptionCancelRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionCancelRequest.class);

        Assertions.assertNotNull(request.getRequestInfo());
        Assertions.assertEquals("USA", request.getStorefront());
    }

    @Test
    public void testAdvancedCommerceSubscriptionRevokeRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionRevokeRequest.json");

        AdvancedCommerceSubscriptionRevokeRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionRevokeRequest.class);

        Assertions.assertNotNull(request.getRequestInfo());
        Assertions.assertTrue(request.getRefundRiskingPreference());
        Assertions.assertEquals(AdvancedCommerceRefundReason.LEGAL, request.getRefundReason());
        Assertions.assertEquals(AdvancedCommerceRefundType.FULL, request.getRefundType());
        Assertions.assertEquals("FULL", request.getRawRefundType());
        Assertions.assertEquals("USA", request.getStorefront());
    }

    @Test
    public void testAdvancedCommerceSubscriptionPriceChangeRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionPriceChangeRequest.json");

        AdvancedCommerceSubscriptionPriceChangeRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionPriceChangeRequest.class);

        Assertions.assertNotNull(request.getItems());
        Assertions.assertNotNull(request.getRequestInfo());
        Assertions.assertEquals("USD", request.getCurrency());
    }


    @Test
    public void testAdvancedCommerceRequestRefundResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceRequestRefundResponse.json");

        AdvancedCommerceRequestRefundResponse response = objectMapper.readValue(json, AdvancedCommerceRequestRefundResponse.class);

        Assertions.assertNull(response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info_value", response.getSignedTransactionInfo());
    }

    @Test
    public void testAdvancedCommerceSubscriptionCancelResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionCancelResponse.json");

        AdvancedCommerceSubscriptionCancelResponse response = objectMapper.readValue(json, AdvancedCommerceSubscriptionCancelResponse.class);

        Assertions.assertEquals("signed_renewal_info", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info", response.getSignedTransactionInfo());
    }

    @Test
    public void testAdvancedCommerceSubscriptionRevokeResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionRevokeResponse.json");

        AdvancedCommerceSubscriptionRevokeResponse response = objectMapper.readValue(json, AdvancedCommerceSubscriptionRevokeResponse.class);

        Assertions.assertEquals("signed_renewal_info", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info", response.getSignedTransactionInfo());
    }

    @Test
    public void testAdvancedCommerceSubscriptionPriceChangeResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionPriceChangeResponse.json");

        AdvancedCommerceSubscriptionPriceChangeResponse response =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionPriceChangeResponse.class);

        Assertions.assertEquals("signed_renewal_info", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info", response.getSignedTransactionInfo());
    }

    @Test
    public void testAdvancedCommerceSubscriptionChangeMetadataResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionChangeMetadataResponse.json");

        AdvancedCommerceSubscriptionChangeMetadataResponse response =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionChangeMetadataResponse.class);

        Assertions.assertEquals("signed_renewal_info", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info", response.getSignedTransactionInfo());
    }

    @Test
    public void testAbstractAdvancedCommerceResponseWithUnknownFields() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceResponseWithUnknownFields.json");

        AdvancedCommerceSubscriptionCancelResponse response =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionCancelResponse.class);

        Assertions.assertEquals("signed_renewal_info_value", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info_value", response.getSignedTransactionInfo());
        Assertions.assertNotNull(response.getUnknownFields());
        Assertions.assertEquals(1, response.getUnknownFields().size());
        Assertions.assertEquals("unknown_value", response.getUnknownFields().get("unknownField"));
    }


    @Test
    public void testAdvancedCommerceSubscriptionMigrateRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionMigrateRequest.json");

        AdvancedCommerceSubscriptionMigrateRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionMigrateRequest.class);

        Assertions.assertNotNull(request.getDescriptors());
        Assertions.assertNotNull(request.getItems());
        Assertions.assertEquals("taxCode", request.getTaxCode());
        Assertions.assertEquals("targetProductId", request.getTargetProductId());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyInAppRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyInAppRequest.json");

        AdvancedCommerceSubscriptionModifyInAppRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyInAppRequest.class);

        Assertions.assertEquals("USD", request.getCurrency());
        Assertions.assertNotNull(request.getDescriptors());
        Assertions.assertEquals("taxCode", request.getTaxCode());
        Assertions.assertEquals("transactionId", request.getTransactionId());
        Assertions.assertTrue(request.getRetainBillingCycle());
    }

    @Test
    public void testAdvancedCommerceSubscriptionReactivateInAppRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionReactivateInAppRequest.json");

        AdvancedCommerceSubscriptionReactivateInAppRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionReactivateInAppRequest.class);

        Assertions.assertNotNull(request.getItems());
        Assertions.assertEquals("transactionId", request.getTransactionId());
    }

    @Test
    public void testAdvancedCommerceSubscriptionChangeMetadataRequest() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionChangeMetadataRequest.json");

        AdvancedCommerceSubscriptionChangeMetadataRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionChangeMetadataRequest.class);

        Assertions.assertNotNull(request.getItems());
        Assertions.assertNotNull(request.getRequestInfo());
    }


    @Test
    public void testAdvancedCommerceSubscriptionMigrateDescriptors() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionMigrateDescriptors.json");

        AdvancedCommerceSubscriptionMigrateDescriptors descriptors =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionMigrateDescriptors.class);

        Assertions.assertEquals("description", descriptors.getDescription());
        Assertions.assertEquals("displayName", descriptors.getDisplayName());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyDescriptors() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyDescriptors.json");

        AdvancedCommerceSubscriptionModifyDescriptors descriptors =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyDescriptors.class);

        Assertions.assertEquals("description", descriptors.getDescription());
        Assertions.assertEquals("displayName", descriptors.getDisplayName());
        Assertions.assertEquals(AdvancedCommerceEffective.IMMEDIATELY, descriptors.getEffective());
    }

    @Test
    public void testAdvancedCommerceSubscriptionChangeMetadataDescriptors() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionChangeMetadataDescriptors.json");

        AdvancedCommerceSubscriptionChangeMetadataDescriptors descriptors =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionChangeMetadataDescriptors.class);

        Assertions.assertEquals("description", descriptors.getDescription());
        Assertions.assertEquals("displayName", descriptors.getDisplayName());
        Assertions.assertEquals(AdvancedCommerceEffective.IMMEDIATELY, descriptors.getEffective());
    }

    @Test
    public void testAdvancedCommerceSubscriptionMigrateItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionMigrateItem.json");

        AdvancedCommerceSubscriptionMigrateItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionMigrateItem.class);

        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("displayName", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
    }

    @Test
    public void testAdvancedCommerceSubscriptionMigrateRenewalItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionMigrateRenewalItem.json");

        AdvancedCommerceSubscriptionMigrateRenewalItem item =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionMigrateRenewalItem.class);

        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("displayName", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyAddItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyAddItem.json");

        AdvancedCommerceSubscriptionModifyAddItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyAddItem.class);

        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("displayName", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals(12000L, item.getPrice());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyChangeItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyChangeItem.json");

        AdvancedCommerceSubscriptionModifyChangeItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyChangeItem.class);

        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("displayName", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals("currentSKU", item.getCurrentSku());
        Assertions.assertEquals(13000L, item.getPrice());
        Assertions.assertEquals(AdvancedCommerceEffective.IMMEDIATELY, item.getEffective());
        Assertions.assertEquals(AdvancedCommerceReason.UPGRADE, item.getReason());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyRemoveItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyRemoveItem.json");

        AdvancedCommerceSubscriptionModifyRemoveItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyRemoveItem.class);

        Assertions.assertEquals("sku", item.getSku());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyPeriodChange() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyPeriodChange.json");

        AdvancedCommerceSubscriptionModifyPeriodChange periodChange =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyPeriodChange.class);

        Assertions.assertEquals(AdvancedCommercePeriod.P3M, periodChange.getPeriod());
        Assertions.assertEquals(AdvancedCommerceEffective.IMMEDIATELY, periodChange.getEffective());
    }

    @Test
    public void testAdvancedCommerceSubscriptionPriceChangeItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionPriceChangeItem.json");

        AdvancedCommerceSubscriptionPriceChangeItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionPriceChangeItem.class);

        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals(16000L, item.getPrice());
        Assertions.assertEquals("dependentSKU", item.getDependentSKUs().get(0));
    }

    @Test
    public void testAdvancedCommerceSubscriptionPriceChangeItemDependentSKUValidation() {
        String validSku = "A".repeat(128);
        String tooLongSku = "A".repeat(129);

        AdvancedCommerceSubscriptionPriceChangeItem item = new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L);
        item.addDependentSKU(validSku);
        Assertions.assertEquals(validSku, item.getDependentSKUs().get(0));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L).addDependentSKU(tooLongSku));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L).dependentSKUs(List.of(tooLongSku)));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AdvancedCommerceSubscriptionPriceChangeItem i = new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L);
            i.setDependentSKUs(List.of(tooLongSku));
        });

        AdvancedCommerceSubscriptionPriceChangeItem nullListItem = new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L);
        nullListItem.setDependentSKUs(null);
        Assertions.assertNull(nullListItem.getDependentSKUs());
    }

    @Test
    public void testAdvancedCommerceSubscriptionReactivateItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionReactivateItem.json");

        AdvancedCommerceSubscriptionReactivateItem item = objectMapper.readValue(json, AdvancedCommerceSubscriptionReactivateItem.class);

        Assertions.assertEquals("sku", item.getSku());
    }

    @Test
    public void testAdvancedCommerceSubscriptionChangeMetadataItem() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionChangeMetadataItem.json");

        AdvancedCommerceSubscriptionChangeMetadataItem item =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionChangeMetadataItem.class);

        Assertions.assertEquals("description", item.getDescription());
        Assertions.assertEquals("displayName", item.getDisplayName());
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals("currentSKU", item.getCurrentSku());
        Assertions.assertEquals(AdvancedCommerceEffective.NEXT_BILL_CYCLE, item.getEffective());
    }


    @Test
    public void testAdvancedCommerceRequestInfo() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceRequestInfo.json");

        AdvancedCommerceRequestInfo requestInfo = objectMapper.readValue(json, AdvancedCommerceRequestInfo.class);

        Assertions.assertEquals(UUID.fromString("550e8400-e29b-41d4-a716-446655440010"), requestInfo.getRequestReferenceId());
        Assertions.assertEquals(UUID.fromString("660e8400-e29b-41d4-a716-446655440011"), requestInfo.getAppAccountToken());
        Assertions.assertEquals("consistency_token_value", requestInfo.getConsistencyToken());
    }


    @Test
    public void testAdvancedCommercePriceIncreaseInfoStatus() {
        Assertions.assertEquals("SCHEDULED", AdvancedCommercePriceIncreaseInfoStatus.SCHEDULED.getValue());
        Assertions.assertEquals("PENDING", AdvancedCommercePriceIncreaseInfoStatus.PENDING.getValue());
        Assertions.assertEquals("ACCEPTED", AdvancedCommercePriceIncreaseInfoStatus.ACCEPTED.getValue());

        Assertions.assertEquals(AdvancedCommercePriceIncreaseInfoStatus.SCHEDULED,
            AdvancedCommercePriceIncreaseInfoStatus.fromValue("SCHEDULED"));
        Assertions.assertEquals(AdvancedCommercePriceIncreaseInfoStatus.PENDING,
            AdvancedCommercePriceIncreaseInfoStatus.fromValue("PENDING"));
        Assertions.assertEquals(AdvancedCommercePriceIncreaseInfoStatus.ACCEPTED,
            AdvancedCommercePriceIncreaseInfoStatus.fromValue("ACCEPTED"));
        Assertions.assertNull(AdvancedCommercePriceIncreaseInfoStatus.fromValue("INVALID"));

        Assertions.assertEquals("SCHEDULED", AdvancedCommercePriceIncreaseInfoStatus.SCHEDULED.toString());
    }


    @Test
    public void testBillingPlanType() {
        Assertions.assertEquals("BILLED_UPFRONT", BillingPlanType.BILLED_UPFRONT.getValue());
        Assertions.assertEquals("MONTHLY", BillingPlanType.MONTHLY.getValue());

        Assertions.assertEquals(BillingPlanType.BILLED_UPFRONT,
            BillingPlanType.fromValue("BILLED_UPFRONT"));
        Assertions.assertEquals(BillingPlanType.MONTHLY,
            BillingPlanType.fromValue("MONTHLY"));
        Assertions.assertNull(BillingPlanType.fromValue("INVALID"));

        Assertions.assertEquals("MONTHLY", BillingPlanType.MONTHLY.toString());
    }


    @Test
    public void testRenewalBillingPlanType() {
        Assertions.assertEquals("BILLED_UPFRONT", RenewalBillingPlanType.BILLED_UPFRONT.getValue());
        Assertions.assertEquals("MONTHLY", RenewalBillingPlanType.MONTHLY.getValue());

        Assertions.assertEquals(RenewalBillingPlanType.BILLED_UPFRONT,
            RenewalBillingPlanType.fromValue("BILLED_UPFRONT"));
        Assertions.assertEquals(RenewalBillingPlanType.MONTHLY,
            RenewalBillingPlanType.fromValue("MONTHLY"));
        Assertions.assertNull(RenewalBillingPlanType.fromValue("INVALID"));

        Assertions.assertEquals("BILLED_UPFRONT", RenewalBillingPlanType.BILLED_UPFRONT.toString());
    }


    @Test
    public void testTransactionCommitmentInfoBillingPeriodNumberValidation() {
        TransactionCommitmentInfo info = new TransactionCommitmentInfo();

        info.setBillingPeriodNumber(1);
        Assertions.assertEquals(1, info.getBillingPeriodNumber());

        info.setBillingPeriodNumber(12);
        Assertions.assertEquals(12, info.getBillingPeriodNumber());

        info.setBillingPeriodNumber(null);
        Assertions.assertNull(info.getBillingPeriodNumber());

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new TransactionCommitmentInfo().billingPeriodNumber(0));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new TransactionCommitmentInfo().billingPeriodNumber(13));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new TransactionCommitmentInfo().setBillingPeriodNumber(-1));
    }

    @Test
    public void testAdvancedCommerceSubscriptionMigrateResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionMigrateResponse.json");

        AdvancedCommerceSubscriptionMigrateResponse response =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionMigrateResponse.class);

        Assertions.assertEquals("signed_renewal_info_value", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info_value", response.getSignedTransactionInfo());
    }

    @Test
    public void testOneTimeChargeCreateRequestDeserializationSetsOperationAndVersion() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceOneTimeChargeCreateRequest.json");

        AdvancedCommerceOneTimeChargeCreateRequest request =
            objectMapper.readValue(json, AdvancedCommerceOneTimeChargeCreateRequest.class);

        JsonNode node = objectMapper.valueToTree(request);
        Assertions.assertEquals("CREATE_ONE_TIME_CHARGE", node.get("operation").asText());
        Assertions.assertEquals("1", node.get("version").asText());
    }

    @Test
    public void testSubscriptionCreateRequestDeserializationSetsOperationAndVersion() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionCreateRequest.json");

        AdvancedCommerceSubscriptionCreateRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionCreateRequest.class);

        JsonNode node = objectMapper.valueToTree(request);
        Assertions.assertEquals("CREATE_SUBSCRIPTION", node.get("operation").asText());
        Assertions.assertEquals("1", node.get("version").asText());
    }

    @Test
    public void testSubscriptionModifyInAppRequestDeserializationSetsOperationAndVersion() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionModifyInAppRequest.json");

        AdvancedCommerceSubscriptionModifyInAppRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionModifyInAppRequest.class);

        JsonNode node = objectMapper.valueToTree(request);
        Assertions.assertEquals("MODIFY_SUBSCRIPTION", node.get("operation").asText());
        Assertions.assertEquals("1", node.get("version").asText());
    }

    @Test
    public void testSubscriptionReactivateInAppRequestDeserializationSetsOperationAndVersion() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionReactivateInAppRequest.json");

        AdvancedCommerceSubscriptionReactivateInAppRequest request =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionReactivateInAppRequest.class);

        JsonNode node = objectMapper.valueToTree(request);
        Assertions.assertEquals("REACTIVATE_SUBSCRIPTION", node.get("operation").asText());
        Assertions.assertEquals("1", node.get("version").asText());
    }

    private static final UUID REQUEST_REFERENCE_ID = UUID.fromString("7c80bb86-f892-4b21-a919-1357811d6c4f");

    private static ObjectMapper createRequestObjectMapper() {
        ObjectMapper requestObjectMapper = new ObjectMapper();
        requestObjectMapper.setVisibility(requestObjectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        return requestObjectMapper;
    }

    private static AdvancedCommerceRequestInfo createRequestInfo() {
        return new AdvancedCommerceRequestInfo(REQUEST_REFERENCE_ID);
    }

    @Test
    public void testAdvancedCommerceDescriptorsPublicConstructor() throws Exception {
        Assertions.assertTrue(Modifier.isPublic(AdvancedCommerceDescriptors.class.getConstructor(String.class, String.class).getModifiers()));

        AdvancedCommerceDescriptors descriptors = new AdvancedCommerceDescriptors("description", "display name");
        Assertions.assertEquals("description", descriptors.getDescription());
        Assertions.assertEquals("display name", descriptors.getDisplayName());
        Assertions.assertEquals(AdvancedCommerceDescriptors.class, descriptors.getClass());

        AdvancedCommerceSubscriptionCreateRequest request = new AdvancedCommerceSubscriptionCreateRequest(
                createRequestInfo(),
                "USD",
                descriptors,
                List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L)),
                AdvancedCommercePeriod.P1M,
                "taxCode");
        Assertions.assertEquals(descriptors, request.getDescriptors());
    }

    @Test
    public void testAdvancedCommerceRequestSerializationOmitsUnsetOptionalFields() throws Exception {
        ObjectMapper requestObjectMapper = createRequestObjectMapper();

        AdvancedCommerceSubscriptionCancelRequest cancelRequest = new AdvancedCommerceSubscriptionCancelRequest(createRequestInfo());
        Assertions.assertEquals(objectMapper.readTree("{\"requestInfo\":{\"requestReferenceId\":\"7c80bb86-f892-4b21-a919-1357811d6c4f\"}}"),
                objectMapper.readTree(requestObjectMapper.writeValueAsString(cancelRequest)));

        AdvancedCommerceSubscriptionModifyInAppRequest modifyRequest = new AdvancedCommerceSubscriptionModifyInAppRequest(createRequestInfo(), true, "123")
                .addRemoveItem(new AdvancedCommerceSubscriptionModifyRemoveItem("sku"))
                .descriptors(new AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective.IMMEDIATELY));
        Assertions.assertEquals(objectMapper.readTree("{\"requestInfo\":{\"requestReferenceId\":\"7c80bb86-f892-4b21-a919-1357811d6c4f\"},\"operation\":\"MODIFY_SUBSCRIPTION\",\"version\":\"1\",\"descriptors\":{\"effective\":\"IMMEDIATELY\"},\"removeItems\":[{\"SKU\":\"sku\"}],\"retainBillingCycle\":true,\"transactionId\":\"123\"}"),
                objectMapper.readTree(requestObjectMapper.writeValueAsString(modifyRequest)));

        AdvancedCommerceRequestRefundRequest refundRequest = new AdvancedCommerceRequestRefundRequest(
                createRequestInfo(),
                List.of(new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, false)),
                true);
        Assertions.assertEquals(objectMapper.readTree("{\"requestInfo\":{\"requestReferenceId\":\"7c80bb86-f892-4b21-a919-1357811d6c4f\"},\"items\":[{\"SKU\":\"sku\",\"refundReason\":\"LEGAL\",\"refundType\":\"FULL\",\"revoke\":false}],\"refundRiskingPreference\":true}"),
                objectMapper.readTree(requestObjectMapper.writeValueAsString(refundRequest)));

        List<Object> requests = List.of(
                new AdvancedCommerceOneTimeChargeCreateRequest(createRequestInfo(), "USD", new AdvancedCommerceOneTimeChargeItem("description", "display name", "sku", 1000L), "taxCode"),
                new AdvancedCommerceSubscriptionCreateRequest(createRequestInfo(), "USD", new AdvancedCommerceDescriptors("description", "display name"), List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L)),
                        AdvancedCommercePeriod.P1M, "taxCode"),
                new AdvancedCommerceSubscriptionModifyInAppRequest(createRequestInfo(), false, "123")
                        .addAddItem(new AdvancedCommerceSubscriptionModifyAddItem("sku", "description", "display name", 1000L))
                        .addChangeItem(new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name", "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE))
                        .periodChange(new AdvancedCommerceSubscriptionModifyPeriodChange(AdvancedCommerceEffective.NEXT_BILL_CYCLE, AdvancedCommercePeriod.P1Y)),
                new AdvancedCommerceSubscriptionReactivateInAppRequest(createRequestInfo(), "123")
                        .addItem(new AdvancedCommerceSubscriptionReactivateItem("sku")),
                new AdvancedCommerceSubscriptionMigrateRequest(createRequestInfo(), new AdvancedCommerceSubscriptionMigrateDescriptors("description", "display name"), List.of(new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "display name")),
                        "targetProductId", "taxCode"),
                new AdvancedCommerceSubscriptionRevokeRequest(createRequestInfo(), AdvancedCommerceRefundReason.LEGAL, true, AdvancedCommerceRefundType.PRORATED),
                new AdvancedCommerceSubscriptionPriceChangeRequest(createRequestInfo(), List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L))),
                new AdvancedCommerceSubscriptionChangeMetadataRequest(createRequestInfo())
                        .descriptors(new AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective.IMMEDIATELY))
                        .addItem(new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", AdvancedCommerceEffective.IMMEDIATELY)),
                new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L)
                        .offer(new AdvancedCommerceOffer(AdvancedCommerceOfferPeriod.P1M, 1, 500L, AdvancedCommerceOfferReason.ACQUISITION))
        );
        for (Object request : requests) {
            String json = requestObjectMapper.writeValueAsString(request);
            Assertions.assertFalse(json.contains("null"), json);
        }
    }

    @Test
    public void testAdvancedCommerceItemEqualsAndHashCode() {
        Assertions.assertEquals(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L), new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L));
        Assertions.assertEquals(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L).hashCode(), new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L).hashCode());
        Assertions.assertNotEquals(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L), new AdvancedCommerceSubscriptionPriceChangeItem("sku2", 1000L));
        Assertions.assertNotEquals(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L), new AdvancedCommerceSubscriptionPriceChangeItem("sku", 2000L));

        Assertions.assertEquals(new AdvancedCommerceSubscriptionModifyRemoveItem("sku"), new AdvancedCommerceSubscriptionModifyRemoveItem("sku"));
        Assertions.assertEquals(new AdvancedCommerceSubscriptionModifyRemoveItem("sku").hashCode(), new AdvancedCommerceSubscriptionModifyRemoveItem("sku").hashCode());
        Assertions.assertNotEquals(new AdvancedCommerceSubscriptionModifyRemoveItem("sku"), new AdvancedCommerceSubscriptionModifyRemoveItem("sku2"));

        Assertions.assertEquals(new AdvancedCommerceSubscriptionReactivateItem("sku"), new AdvancedCommerceSubscriptionReactivateItem("sku"));
        Assertions.assertEquals(new AdvancedCommerceSubscriptionReactivateItem("sku").hashCode(), new AdvancedCommerceSubscriptionReactivateItem("sku").hashCode());
        Assertions.assertNotEquals(new AdvancedCommerceSubscriptionReactivateItem("sku"), new AdvancedCommerceSubscriptionReactivateItem("sku2"));
        Assertions.assertNotEquals(new AdvancedCommerceSubscriptionReactivateItem("sku"), new AdvancedCommerceSubscriptionModifyRemoveItem("sku"));

        Assertions.assertEquals(
                new AdvancedCommerceSubscriptionPriceChangeRequest(createRequestInfo(), List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L))),
                new AdvancedCommerceSubscriptionPriceChangeRequest(createRequestInfo(), List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L))));
        Assertions.assertEquals(
                new AdvancedCommerceSubscriptionReactivateInAppRequest(createRequestInfo(), "123").addItem(new AdvancedCommerceSubscriptionReactivateItem("sku")),
                new AdvancedCommerceSubscriptionReactivateInAppRequest(createRequestInfo(), "123").addItem(new AdvancedCommerceSubscriptionReactivateItem("sku")));
    }

    @Test
    public void testAdvancedCommerceDescriptorsEqualsAndHashCode() {
        AdvancedCommerceSubscriptionChangeMetadataDescriptors changeMetadataDescriptors =
                new AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective.IMMEDIATELY).description("description");
        AdvancedCommerceSubscriptionChangeMetadataDescriptors otherChangeMetadataDescriptors =
                new AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective.IMMEDIATELY).description("description");
        Assertions.assertEquals(changeMetadataDescriptors, otherChangeMetadataDescriptors);
        Assertions.assertEquals(changeMetadataDescriptors.hashCode(), otherChangeMetadataDescriptors.hashCode());
        Set<AdvancedCommerceSubscriptionChangeMetadataDescriptors> changeMetadataDescriptorsSet = new HashSet<>();
        changeMetadataDescriptorsSet.add(changeMetadataDescriptors);
        Assertions.assertTrue(changeMetadataDescriptorsSet.contains(otherChangeMetadataDescriptors));

        AdvancedCommerceSubscriptionModifyDescriptors modifyDescriptors =
                new AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective.NEXT_BILL_CYCLE).displayName("display name");
        AdvancedCommerceSubscriptionModifyDescriptors otherModifyDescriptors =
                new AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective.NEXT_BILL_CYCLE).displayName("display name");
        Assertions.assertEquals(modifyDescriptors, otherModifyDescriptors);
        Assertions.assertEquals(modifyDescriptors.hashCode(), otherModifyDescriptors.hashCode());

        AdvancedCommerceSubscriptionModifyInAppRequest modifyRequest = new AdvancedCommerceSubscriptionModifyInAppRequest(createRequestInfo(), true, "123").descriptors(modifyDescriptors);
        AdvancedCommerceSubscriptionModifyInAppRequest otherModifyRequest = new AdvancedCommerceSubscriptionModifyInAppRequest(createRequestInfo(), true, "123").descriptors(otherModifyDescriptors);
        Assertions.assertEquals(modifyRequest, otherModifyRequest);
        Assertions.assertEquals(modifyRequest.hashCode(), otherModifyRequest.hashCode());
    }

    @Test
    public void testAdvancedCommerceItemSkuRequired() {
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyRemoveItem(null));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionReactivateItem(null));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionPriceChangeItem(null, 1000L));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceOneTimeChargeItem("description", "display name", null, 1000L));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionCreateItem(null, "description", "display name", 1000L));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceRequestRefundItem(null, AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, true));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyRemoveItem("sku").sku(null));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyRemoveItem("sku").setSku(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AdvancedCommerceSubscriptionModifyRemoveItem("A".repeat(129)));

        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name", null, AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyChangeItem(null, "description", "display name", "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name", "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE).currentSku(null));

        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionChangeMetadataItem(null, AdvancedCommerceEffective.IMMEDIATELY));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", AdvancedCommerceEffective.IMMEDIATELY).setCurrentSku(null));
        AdvancedCommerceSubscriptionChangeMetadataItem changeMetadataItem = new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", AdvancedCommerceEffective.IMMEDIATELY).sku("sku");
        changeMetadataItem.setSku(null);
        Assertions.assertNull(changeMetadataItem.getSku());
        changeMetadataItem.setSku("a".repeat(128));
        Assertions.assertEquals("a".repeat(128), changeMetadataItem.getSku());
        Assertions.assertThrows(IllegalArgumentException.class, () -> changeMetadataItem.setSku("a".repeat(129)));
        Assertions.assertEquals("a".repeat(128), changeMetadataItem.getSku());
    }

    @Test
    public void testAdvancedCommerceItemFluentSettersReturnConcreteType() {
        AdvancedCommerceSubscriptionModifyAddItem addItem = new AdvancedCommerceSubscriptionModifyAddItem("sku", "description", "display name", 1000L)
                .sku("sku2")
                .description("description2")
                .displayName("display name2")
                .proratedPrice(500L);
        Assertions.assertEquals("sku2", addItem.getSku());
        Assertions.assertEquals("description2", addItem.getDescription());
        Assertions.assertEquals("display name2", addItem.getDisplayName());
        Assertions.assertEquals(500L, addItem.getProratedPrice());

        AdvancedCommerceSubscriptionCreateItem createItem = new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L)
                .sku("sku2")
                .offer(null);
        Assertions.assertEquals("sku2", createItem.getSku());
        AdvancedCommerceOneTimeChargeItem oneTimeChargeItem = new AdvancedCommerceOneTimeChargeItem("description", "display name", "sku", 1000L).description("description2").price(2000L);
        Assertions.assertEquals("description2", oneTimeChargeItem.getDescription());
        AdvancedCommerceSubscriptionModifyChangeItem changeItem = new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name", "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE)
                .displayName("display name2")
                .reason(AdvancedCommerceReason.DOWNGRADE);
        Assertions.assertEquals(AdvancedCommerceReason.DOWNGRADE, changeItem.getReason());
        AdvancedCommerceSubscriptionMigrateItem migrateItem = new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "display name").sku("sku2");
        Assertions.assertEquals("sku2", migrateItem.getSku());
        AdvancedCommerceSubscriptionMigrateRenewalItem migrateRenewalItem = new AdvancedCommerceSubscriptionMigrateRenewalItem("sku", "description", "display name").displayName("display name2");
        Assertions.assertEquals("display name2", migrateRenewalItem.getDisplayName());
        AdvancedCommerceSubscriptionModifyRemoveItem removeItem = new AdvancedCommerceSubscriptionModifyRemoveItem("sku").sku("sku2");
        Assertions.assertEquals("sku2", removeItem.getSku());
        AdvancedCommerceSubscriptionReactivateItem reactivateItem = new AdvancedCommerceSubscriptionReactivateItem("sku").sku("sku2");
        Assertions.assertEquals("sku2", reactivateItem.getSku());
        AdvancedCommerceSubscriptionPriceChangeItem priceChangeItem = new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L).sku("sku2").price(2000L);
        Assertions.assertEquals(2000L, priceChangeItem.getPrice());
        AdvancedCommerceRequestRefundItem refundItem = new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.CUSTOM, true).sku("sku2").refundAmount(100L);
        Assertions.assertEquals("sku2", refundItem.getSku());
        AdvancedCommerceSubscriptionMigrateDescriptors migrateDescriptors = new AdvancedCommerceSubscriptionMigrateDescriptors("description", "display name")
                .description("description2")
                .displayName("display name2")
                .unknownFields(Map.of("key", "value"));
        Assertions.assertEquals("description2", migrateDescriptors.getDescription());
        Assertions.assertEquals("display name2", migrateDescriptors.getDisplayName());
        Assertions.assertEquals(Map.of("key", "value"), migrateDescriptors.getUnknownFields());
        AdvancedCommerceSubscriptionCancelResponse cancelResponse = new AdvancedCommerceSubscriptionCancelResponse("renewal", "transaction")
                .unknownFields(Map.of("key", "value"));
        Assertions.assertEquals(Map.of("key", "value"), cancelResponse.getUnknownFields());
        AdvancedCommerceRequestRefundResponse refundResponse = new AdvancedCommerceRequestRefundResponse("transaction").unknownFields(null);
        Assertions.assertNull(refundResponse.getUnknownFields());
        AdvancedCommerceSubscriptionChangeMetadataResponse changeMetadataResponse = new AdvancedCommerceSubscriptionChangeMetadataResponse("renewal", "transaction").unknownFields(null);
        Assertions.assertNull(changeMetadataResponse.getUnknownFields());
        AdvancedCommerceSubscriptionMigrateResponse migrateResponse = new AdvancedCommerceSubscriptionMigrateResponse("renewal", "transaction").unknownFields(null);
        Assertions.assertNull(migrateResponse.getUnknownFields());
        AdvancedCommerceSubscriptionPriceChangeResponse priceChangeResponse = new AdvancedCommerceSubscriptionPriceChangeResponse("renewal", "transaction").unknownFields(null);
        Assertions.assertNull(priceChangeResponse.getUnknownFields());
        AdvancedCommerceSubscriptionRevokeResponse revokeResponse = new AdvancedCommerceSubscriptionRevokeResponse("renewal", "transaction").unknownFields(null);
        Assertions.assertNull(revokeResponse.getUnknownFields());
    }

    @Test
    public void testAdvancedCommerceRequestInfoConsistencyToken() {
        AdvancedCommerceRequestInfo requestInfo = createRequestInfo().consistencyToken("token");
        Assertions.assertEquals("token", requestInfo.getConsistencyToken());
        Assertions.assertTrue(requestInfo.toString().startsWith("AdvancedCommerceRequestInfo{"), requestInfo.toString());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyChangeItemCurrentSku() {
        AdvancedCommerceSubscriptionModifyChangeItem item = new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name", "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.UPGRADE);
        Assertions.assertEquals("currentSku", item.getCurrentSku());
        Assertions.assertEquals("sku", item.getSku());
        Assertions.assertEquals("currentSku2", item.currentSku("currentSku2").getCurrentSku());
        item.setCurrentSku("currentSku3");
        Assertions.assertEquals("currentSku3", item.getCurrentSku());
        Assertions.assertThrows(NullPointerException.class, () -> item.setCurrentSku(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> item.setCurrentSku("A".repeat(129)));
    }

    @Test
    public void testAdvancedCommerceRequestRefundItemRawRefundReason() {
        AdvancedCommerceRequestRefundItem item = new AdvancedCommerceRequestRefundItem("sku", "NEW_REASON", "NEW_TYPE", true);
        Assertions.assertNull(item.getRefundReason());
        Assertions.assertEquals("NEW_REASON", item.getRawRefundReason());
        Assertions.assertNull(item.getRefundType());
        Assertions.assertEquals("NEW_TYPE", item.getRawRefundType());

        item.setRefundReason(AdvancedCommerceRefundReason.OTHER);
        Assertions.assertEquals(AdvancedCommerceRefundReason.OTHER, item.getRefundReason());
        Assertions.assertEquals("OTHER", item.getRawRefundReason());
    }

    @Test
    public void testAdvancedCommerceSubscriptionModifyPeriodChangeRawValues() throws Exception {
        AdvancedCommerceSubscriptionModifyPeriodChange periodChange = new AdvancedCommerceSubscriptionModifyPeriodChange("FUTURE_EFFECTIVE", "P5Y");
        Assertions.assertNull(periodChange.getEffective());
        Assertions.assertEquals("FUTURE_EFFECTIVE", periodChange.getRawEffective());
        Assertions.assertNull(periodChange.getPeriod());
        Assertions.assertEquals("P5Y", periodChange.getRawPeriod());
        Assertions.assertEquals(objectMapper.readTree("{\"effective\":\"FUTURE_EFFECTIVE\",\"period\":\"P5Y\"}"),
                objectMapper.readTree(createRequestObjectMapper().writeValueAsString(periodChange)));

        AdvancedCommerceSubscriptionModifyPeriodChange knownPeriodChange = new AdvancedCommerceSubscriptionModifyPeriodChange("IMMEDIATELY", "P1M");
        Assertions.assertEquals(AdvancedCommerceEffective.IMMEDIATELY, knownPeriodChange.getEffective());
        Assertions.assertEquals(AdvancedCommercePeriod.P1M, knownPeriodChange.getPeriod());
        Assertions.assertEquals(new AdvancedCommerceSubscriptionModifyPeriodChange(AdvancedCommerceEffective.IMMEDIATELY, AdvancedCommercePeriod.P1M), knownPeriodChange);

        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyPeriodChange((String) null, "P1M"));
        Assertions.assertThrows(NullPointerException.class, () -> new AdvancedCommerceSubscriptionModifyPeriodChange("IMMEDIATELY", (String) null));

        knownPeriodChange.setRawPeriod("P2M");
        Assertions.assertEquals(AdvancedCommercePeriod.P2M, knownPeriodChange.getPeriod());
        knownPeriodChange.setRawEffective("NEXT_BILL_CYCLE");
        Assertions.assertEquals(AdvancedCommerceEffective.NEXT_BILL_CYCLE, knownPeriodChange.getEffective());
    }

    @Test
    public void testAdvancedCommerceRawEnumAccessors() {
        AdvancedCommerceSubscriptionModifyDescriptors modifyDescriptors = new AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective.IMMEDIATELY);
        Assertions.assertEquals("IMMEDIATELY", modifyDescriptors.getRawEffective());
        modifyDescriptors.setRawEffective("LATER");
        Assertions.assertNull(modifyDescriptors.getEffective());
        Assertions.assertEquals("LATER", modifyDescriptors.getRawEffective());

        AdvancedCommerceSubscriptionChangeMetadataDescriptors changeMetadataDescriptors = new AdvancedCommerceSubscriptionChangeMetadataDescriptors(AdvancedCommerceEffective.NEXT_BILL_CYCLE);
        Assertions.assertEquals("NEXT_BILL_CYCLE", changeMetadataDescriptors.getRawEffective());
        changeMetadataDescriptors.setRawEffective("LATER");
        Assertions.assertNull(changeMetadataDescriptors.getEffective());

        AdvancedCommerceSubscriptionChangeMetadataItem changeMetadataItem = new AdvancedCommerceSubscriptionChangeMetadataItem("currentSku", AdvancedCommerceEffective.IMMEDIATELY);
        Assertions.assertEquals("IMMEDIATELY", changeMetadataItem.getRawEffective());
        changeMetadataItem.setRawEffective("LATER");
        Assertions.assertNull(changeMetadataItem.getEffective());

        AdvancedCommerceSubscriptionModifyChangeItem changeItem = new AdvancedCommerceSubscriptionModifyChangeItem("sku", "description", "display name", "currentSku", AdvancedCommerceEffective.IMMEDIATELY, 1000L, AdvancedCommerceReason.APPLY_OFFER);
        Assertions.assertEquals("IMMEDIATELY", changeItem.getRawEffective());
        Assertions.assertEquals("APPLY_OFFER", changeItem.getRawReason());
        changeItem.setRawReason("NEW_REASON");
        Assertions.assertNull(changeItem.getReason());
        Assertions.assertEquals("NEW_REASON", changeItem.getRawReason());

        AdvancedCommerceSubscriptionCreateRequest createRequest = new AdvancedCommerceSubscriptionCreateRequest(createRequestInfo(), "USD", new AdvancedCommerceDescriptors("description", "display name"), List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L)),
                AdvancedCommercePeriod.P1M, "taxCode");
        Assertions.assertEquals("P1M", createRequest.getRawPeriod());
        createRequest.setRawPeriod("P5Y");
        Assertions.assertNull(createRequest.getPeriod());
        Assertions.assertEquals("P5Y", createRequest.getRawPeriod());

        AdvancedCommerceSubscriptionRevokeRequest revokeRequest = new AdvancedCommerceSubscriptionRevokeRequest(createRequestInfo(), AdvancedCommerceRefundReason.LEGAL, true, AdvancedCommerceRefundType.FULL);
        Assertions.assertEquals(AdvancedCommerceRefundReason.LEGAL, revokeRequest.getRefundReason());
        Assertions.assertEquals("LEGAL", revokeRequest.getRawRefundReason());
        Assertions.assertEquals(AdvancedCommerceRefundType.FULL, revokeRequest.getRefundType());
        Assertions.assertEquals("FULL", revokeRequest.getRawRefundType());
        revokeRequest.setRawRefundReason("NEW_REASON");
        Assertions.assertNull(revokeRequest.getRefundReason());
        Assertions.assertEquals("NEW_REASON", revokeRequest.getRawRefundReason());
        Assertions.assertEquals(AdvancedCommerceRefundType.PRORATED, revokeRequest.refundType(AdvancedCommerceRefundType.PRORATED).getRefundType());
        Assertions.assertEquals("PRORATED", revokeRequest.getRawRefundType());
        revokeRequest.setRefundType(AdvancedCommerceRefundType.FULL);
        Assertions.assertEquals(AdvancedCommerceRefundType.FULL, revokeRequest.getRefundType());
        revokeRequest.setRawRefundType("NEW_TYPE");
        Assertions.assertNull(revokeRequest.getRefundType());
        Assertions.assertEquals("NEW_TYPE", revokeRequest.getRawRefundType());
        Assertions.assertThrows(NullPointerException.class, () -> revokeRequest.setRefundType(null));
        Assertions.assertThrows(NullPointerException.class, () -> revokeRequest.setRawRefundType(null));
        Assertions.assertThrows(NullPointerException.class, () -> revokeRequest.setRawRefundReason(null));
    }

    @Test
    public void testAdvancedCommerceRequestItemListValidation() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceRequestRefundRequest(createRequestInfo(), new ArrayList<>(), true));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceRequestRefundRequest(createRequestInfo(), Arrays.asList((AdvancedCommerceRequestRefundItem) null), true));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceRequestRefundRequest(createRequestInfo(), List.of(new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, true)), true).items(new ArrayList<>()));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceSubscriptionPriceChangeRequest(createRequestInfo(), new ArrayList<>()));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new AdvancedCommerceSubscriptionPriceChangeRequest(createRequestInfo(), List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L))).setItems(new ArrayList<>()));

        AdvancedCommerceSubscriptionModifyInAppRequest modifyRequest = new AdvancedCommerceSubscriptionModifyInAppRequest(createRequestInfo(), true, "123");
        Assertions.assertThrows(IllegalArgumentException.class, () -> modifyRequest.removeItems(new ArrayList<>()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> modifyRequest.setRemoveItems(Arrays.asList((AdvancedCommerceSubscriptionModifyRemoveItem) null)));
        modifyRequest.setRemoveItems(null);
        Assertions.assertNull(modifyRequest.getRemoveItems());

        AdvancedCommerceSubscriptionChangeMetadataRequest changeMetadataRequest = new AdvancedCommerceSubscriptionChangeMetadataRequest(createRequestInfo());
        Assertions.assertThrows(IllegalArgumentException.class, () -> changeMetadataRequest.items(new ArrayList<>()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> changeMetadataRequest.setItems(Arrays.asList((AdvancedCommerceSubscriptionChangeMetadataItem) null)));
        changeMetadataRequest.setItems(null);
        Assertions.assertNull(changeMetadataRequest.getItems());

        List<AdvancedCommerceSubscriptionPriceChangeItem> priceChangeItems = List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L));
        Assertions.assertEquals(priceChangeItems, HelperValidationUtils.validateItems(priceChangeItems));
    }

    @Test
    public void testAdvancedCommerceSubscriptionReactivateInAppRequestItemsValidation() {
        AdvancedCommerceSubscriptionReactivateInAppRequest request = new AdvancedCommerceSubscriptionReactivateInAppRequest(createRequestInfo(), "transactionId");
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.items(new ArrayList<>()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.setItems(new ArrayList<>()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.items(Arrays.asList((AdvancedCommerceSubscriptionReactivateItem) null)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> request.setItems(Arrays.asList((AdvancedCommerceSubscriptionReactivateItem) null)));

        Assertions.assertNull(request.getItems());
        Assertions.assertFalse(createRequestObjectMapper().valueToTree(request).has("items"));
        request.setItems(null);
        Assertions.assertNull(request.getItems());

        List<AdvancedCommerceSubscriptionReactivateItem> items = List.of(new AdvancedCommerceSubscriptionReactivateItem("sku"));
        Assertions.assertEquals(items, request.items(items).getItems());
        request.setItems(items);
        Assertions.assertEquals(items, request.getItems());
        Assertions.assertEquals("sku", createRequestObjectMapper().valueToTree(request).get("items").get(0).get("SKU").asText());
    }

    @Test
    public void testAdvancedCommerceRequestAddItemAppendsToList() {
        AdvancedCommerceSubscriptionPriceChangeRequest priceChangeRequest = new AdvancedCommerceSubscriptionPriceChangeRequest(createRequestInfo(), List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L)))
                .addItem(new AdvancedCommerceSubscriptionPriceChangeItem("sku2", 2000L));

        Assertions.assertEquals(List.of(new AdvancedCommerceSubscriptionPriceChangeItem("sku", 1000L), new AdvancedCommerceSubscriptionPriceChangeItem("sku2", 2000L)), priceChangeRequest.getItems());

        AdvancedCommerceSubscriptionCreateRequest createRequest = new AdvancedCommerceSubscriptionCreateRequest(createRequestInfo(), "USD", new AdvancedCommerceDescriptors("description", "display name"), new ArrayList<>(List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L))),
                AdvancedCommercePeriod.P1M, "taxCode")
                .addItem(new AdvancedCommerceSubscriptionCreateItem("sku2", "description", "display name", 1000L));
        Assertions.assertEquals(2, createRequest.getItems().size());

        AdvancedCommerceSubscriptionMigrateRequest migrateRequest = new AdvancedCommerceSubscriptionMigrateRequest(createRequestInfo(), new AdvancedCommerceSubscriptionMigrateDescriptors("description", "display name"), new ArrayList<>(List.of(new AdvancedCommerceSubscriptionMigrateItem("sku", "description", "display name"))),
                "targetProductId", "taxCode")
                .addItem(new AdvancedCommerceSubscriptionMigrateItem("sku2", "description", "display name"));
        Assertions.assertEquals(2, migrateRequest.getItems().size());

        List<AdvancedCommerceRequestRefundItem> refundItems = new ArrayList<>();
        refundItems.add(new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, true));
        AdvancedCommerceRequestRefundRequest refundRequestWithItems = new AdvancedCommerceRequestRefundRequest(createRequestInfo(), refundItems, true)
                .addItem(new AdvancedCommerceRequestRefundItem("sku2", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, true));
        Assertions.assertEquals(2, refundRequestWithItems.getItems().size());
    }

    @Test
    public void testAdvancedCommerceRequestRefundRequestCurrencyOptional() {
        AdvancedCommerceRequestRefundRequest request = new AdvancedCommerceRequestRefundRequest(
                createRequestInfo(),
                List.of(new AdvancedCommerceRequestRefundItem("sku", AdvancedCommerceRefundReason.LEGAL, AdvancedCommerceRefundType.FULL, true)),
                true)
                .currency("USD");
        Assertions.assertEquals("USD", request.getCurrency());
        Assertions.assertNull(request.currency(null).getCurrency());
        request.setCurrency("EUR");
        request.setCurrency(null);
        Assertions.assertNull(request.getCurrency());
    }

    @Test
    public void testValidationUtilsCountsCodePoints() {
        String emoji = "\uD83D\uDC4D";
        Assertions.assertEquals(emoji.repeat(45), HelperValidationUtils.validateDescription(emoji.repeat(45)));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateDescription(emoji.repeat(46)));
        Assertions.assertEquals(emoji.repeat(30), HelperValidationUtils.validateDisplayName(emoji.repeat(30)));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateDisplayName(emoji.repeat(31)));
        Assertions.assertEquals(emoji.repeat(128), HelperValidationUtils.validateSku(emoji.repeat(128)));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateSku(emoji.repeat(129)));
        String combiningCharacter = "e\u0301";
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> HelperValidationUtils.validateDisplayName(combiningCharacter.repeat(16)));
    }

    @Test
    public void testAdvancedCommerceInAppRequestOperationAndVersion() {
        AdvancedCommerceOneTimeChargeCreateRequest oneTimeChargeCreateRequest = new AdvancedCommerceOneTimeChargeCreateRequest(createRequestInfo(), "USD", new AdvancedCommerceOneTimeChargeItem("description", "display name", "sku", 1000L), "taxCode");
        Assertions.assertEquals("CREATE_ONE_TIME_CHARGE", oneTimeChargeCreateRequest.getOperation());
        Assertions.assertEquals("1", oneTimeChargeCreateRequest.getVersion());
        Assertions.assertTrue(oneTimeChargeCreateRequest.toString().contains("operation='CREATE_ONE_TIME_CHARGE', version='1'"), oneTimeChargeCreateRequest.toString());

        AdvancedCommerceSubscriptionReactivateInAppRequest reactivateRequest = new AdvancedCommerceSubscriptionReactivateInAppRequest(createRequestInfo(), "123");
        Assertions.assertEquals("REACTIVATE_SUBSCRIPTION", reactivateRequest.getOperation());
        Assertions.assertEquals("1", reactivateRequest.getVersion());
        Assertions.assertTrue(reactivateRequest.toString().contains("operation='REACTIVATE_SUBSCRIPTION', version='1'"), reactivateRequest.toString());

        AdvancedCommerceSubscriptionModifyInAppRequest modifyRequest = new AdvancedCommerceSubscriptionModifyInAppRequest(createRequestInfo(), true, "123");
        Assertions.assertEquals("MODIFY_SUBSCRIPTION", modifyRequest.getOperation());
        Assertions.assertTrue(modifyRequest.toString().contains("operation='MODIFY_SUBSCRIPTION', version='1'"), modifyRequest.toString());

        AdvancedCommerceSubscriptionCreateRequest createRequest = new AdvancedCommerceSubscriptionCreateRequest(createRequestInfo(), "USD", new AdvancedCommerceDescriptors("description", "display name"), List.of(new AdvancedCommerceSubscriptionCreateItem("sku", "description", "display name", 1000L)),
                AdvancedCommercePeriod.P1M, "taxCode");
        Assertions.assertEquals("CREATE_SUBSCRIPTION", createRequest.getOperation());
        Assertions.assertTrue(createRequest.toString().contains("operation='CREATE_SUBSCRIPTION', version='1'"), createRequest.toString());
    }

    @Test
    public void testAdvancedCommerceToString() {
        Assertions.assertEquals("AdvancedCommerceSubscriptionPriceChangeResponse{signedRenewalInfo='r', signedTransactionInfo='t', unknownFields={key=value}}",
                new AdvancedCommerceSubscriptionPriceChangeResponse("r", "t").unknownFields(Map.of("key", "value")).toString());
        Assertions.assertEquals("AdvancedCommerceSubscriptionCancelResponse{signedRenewalInfo='r', signedTransactionInfo='t', unknownFields=null}",
                new AdvancedCommerceSubscriptionCancelResponse("r", "t").toString());
        Assertions.assertEquals("AdvancedCommerceSubscriptionModifyAddItem{sku='sku', description='description', displayName='display name', offer=null, price=1000, proratedPrice=null}",
                new AdvancedCommerceSubscriptionModifyAddItem("sku", "description", "display name", 1000L).toString());
        Assertions.assertEquals("AdvancedCommerceSubscriptionModifyDescriptors{description='null', displayName='null', effective='IMMEDIATELY'}",
                new AdvancedCommerceSubscriptionModifyDescriptors(AdvancedCommerceEffective.IMMEDIATELY).toString());
        Assertions.assertEquals("AdvancedCommerceSubscriptionMigrateDescriptors{description='description', displayName='display name', unknownFields=null}",
                new AdvancedCommerceSubscriptionMigrateDescriptors("description", "display name").toString());
        Assertions.assertEquals("AdvancedCommerceSubscriptionChangeMetadataRequest{requestInfo=AdvancedCommerceRequestInfo{appAccountToken=null, consistencyToken='null', requestReferenceId=7c80bb86-f892-4b21-a919-1357811d6c4f}, descriptors=null, items=null, storefront='null', taxCode='null'}",
                new AdvancedCommerceSubscriptionChangeMetadataRequest(createRequestInfo()).toString());
    }
}
