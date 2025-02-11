package com.ns.nearby_solutions.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobOrderStatus {
    LISTED("Listed"),
    SOLUTIONIST_ASSIGNED("Solutionist Assigned"),
    COMPLETED("Completed"),
    UNDER_REVIEW("Under Review"); // Properly mapped name

    private final String displayName;

    JobOrderStatus(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    @Override
    public String toString() {
        return displayName; // Ensures correct string representation in JSON and DB
    }

    @JsonCreator
    public static JobOrderStatus fromString(String value) {
        for (JobOrderStatus status : JobOrderStatus.values()) {
            if (status.displayName.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid JobOrderStatus: " + value);
    }
}
