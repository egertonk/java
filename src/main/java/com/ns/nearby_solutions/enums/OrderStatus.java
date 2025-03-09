package com.ns.nearby_solutions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {
    Pending, Completed, Cancelled, Processing;

    @JsonCreator
    public static OrderStatus fromString(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Order status cannot be null or empty");
        }
        for (OrderStatus status : values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid order status: " + value);
    }

    @JsonValue
    public String toJson() {
        return this.name();
    }
}
