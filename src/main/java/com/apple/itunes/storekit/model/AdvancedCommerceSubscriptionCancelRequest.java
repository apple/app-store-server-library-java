// Copyright (c) 2026 Apple Inc. Licensed under MIT License.

package com.apple.itunes.storekit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The request body for turning off automatic renewal of a subscription.
 *
 * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/subscriptioncancelrequest">SubscriptionCancelRequest</a>
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedCommerceSubscriptionCancelRequest extends AdvancedCommerceRequest<AdvancedCommerceSubscriptionCancelRequest> {
    private static final String SERIALIZED_NAME_STOREFRONT = "storefront";

    @JsonProperty(SERIALIZED_NAME_STOREFRONT)
    private String storefront;

    protected AdvancedCommerceSubscriptionCancelRequest() {
        super();
    }

    public AdvancedCommerceSubscriptionCancelRequest(AdvancedCommerceRequestInfo requestInfo) {
        super(requestInfo);
    }

    @Override
    protected AdvancedCommerceSubscriptionCancelRequest self() {
        return this;
    }

    /**
     * The metadata to include in server requests.
     *
     * @return requestInfo
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/requestinfo">RequestInfo</a>
     **/
    @Override
    public AdvancedCommerceRequestInfo getRequestInfo() {
        return super.getRequestInfo();
    }

    public AdvancedCommerceSubscriptionCancelRequest storefront(String storefront) {
        this.storefront = storefront;
        return this;
    }

    /**
     * A three-letter code that represents the country or region associated with the App Store storefront.
     *
     * @return storefront
     * @see <a href="https://developer.apple.com/documentation/advancedcommerceapi/storefront">storefront</a>
     **/
    public String getStorefront() {
        return storefront;
    }

    public void setStorefront(String storefront) {
        this.storefront = storefront;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AdvancedCommerceSubscriptionCancelRequest advancedCommerceSubscriptionCancelRequest = (AdvancedCommerceSubscriptionCancelRequest) o;
        return Objects.equals(this.storefront, advancedCommerceSubscriptionCancelRequest.storefront);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storefront);
    }

    @Override
    public String toString() {
        return "AdvancedCommerceSubscriptionCancelRequest{" +
                "requestInfo=" + getRequestInfo() +
                ", storefront='" + storefront + '\'' +
                '}';
    }
}
