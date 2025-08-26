// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.apple.itunes.storekit.util.TestingUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        Assertions.assertEquals(validDescription, AdvancedCommerceValidationUtils.validateDescription(validDescription));

        String maxLengthDescription = "A".repeat(45);
        Assertions.assertEquals(maxLengthDescription,
            AdvancedCommerceValidationUtils.validateDescription(maxLengthDescription));

        String tooLongDescription = "A".repeat(46);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validateDescription(tooLongDescription));

        Assertions.assertThrows(NullPointerException.class,
            () -> AdvancedCommerceValidationUtils.validateDescription(null));
    }

    @Test
    public void testValidationUtilsDisplayName() {
        String validDisplayName = "Valid Name";
        Assertions.assertEquals(validDisplayName, AdvancedCommerceValidationUtils.validateDisplayName(validDisplayName));

        String maxLengthDisplayName = "A".repeat(30);
        Assertions.assertEquals(maxLengthDisplayName,
            AdvancedCommerceValidationUtils.validateDisplayName(maxLengthDisplayName));

        String tooLongDisplayName = "A".repeat(31);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validateDisplayName(tooLongDisplayName));

        Assertions.assertThrows(NullPointerException.class,
            () -> AdvancedCommerceValidationUtils.validateDisplayName(null));
    }

    @Test
    public void testValidationUtilsSku() {
        String validSku = "valid.sku.123";
        Assertions.assertEquals(validSku, AdvancedCommerceValidationUtils.validateSku(validSku));

        String maxLengthSku = "A".repeat(128);
        Assertions.assertEquals(maxLengthSku, AdvancedCommerceValidationUtils.validateSku(maxLengthSku));

        String tooLongSku = "A".repeat(129);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validateSku(tooLongSku));

        Assertions.assertNull(AdvancedCommerceValidationUtils.validateSku(null));
    }

    @Test
    public void testValidationUtilsPeriodCount() {
        Assertions.assertEquals(1, AdvancedCommerceValidationUtils.validatePeriodCount(1));
        Assertions.assertEquals(6, AdvancedCommerceValidationUtils.validatePeriodCount(6));
        Assertions.assertEquals(12, AdvancedCommerceValidationUtils.validatePeriodCount(12));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validatePeriodCount(0));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validatePeriodCount(13));
        Assertions.assertThrows(NullPointerException.class,
            () -> AdvancedCommerceValidationUtils.validatePeriodCount(null));
    }

    @Test
    public void testValidationUtilsItems() {
        List<AdvancedCommerceOneTimeChargeItem> validList = Arrays.asList(
            new AdvancedCommerceOneTimeChargeItem("desc", "name", "sku1", 1000L)
        );
        Assertions.assertEquals(validList, AdvancedCommerceValidationUtils.validateItems(validList));

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validateItems(null));
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validateItems(new ArrayList<>()));

        List<AdvancedCommerceOneTimeChargeItem> listWithNull = new ArrayList<>();
        listWithNull.add(null);
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> AdvancedCommerceValidationUtils.validateItems(listWithNull));
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
        Assertions.assertEquals(5000, item.getRefundAmount());
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
        Assertions.assertEquals("FULL", request.getRefundType());
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
        Assertions.assertEquals("currentSKU", item.getCurrentSKU());
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
        Assertions.assertEquals("consistency_token_value", requestInfo.consistencyToken());
    }


    @Test
    public void testAdvancedCommerceSubscriptionMigrateResponse() throws Exception {
        String json = TestingUtility.readFile("models/advancedCommerceSubscriptionMigrateResponse.json");

        AdvancedCommerceSubscriptionMigrateResponse response =
            objectMapper.readValue(json, AdvancedCommerceSubscriptionMigrateResponse.class);

        Assertions.assertEquals("signed_renewal_info_value", response.getSignedRenewalInfo());
        Assertions.assertEquals("signed_transaction_info_value", response.getSignedTransactionInfo());
    }
}
