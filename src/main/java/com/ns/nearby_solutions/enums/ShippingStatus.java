package com.ns.nearby_solutions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ShippingStatus {
    Pending, Processing, Shipped, Delivered, Returned, Pickup, Not_Required;

    @JsonCreator
    public static ShippingStatus fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Shipping status cannot be null");
        }
        String formattedValue = value.trim().toUpperCase().replace(" ", "_");
        for (ShippingStatus status : values()) {
            if (status.name().equals(formattedValue)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid shipping status: " + value);
    }
}