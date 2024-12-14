package com.ns.nearby_solutions.tool_rental;

import com.ns.nearby_solutions.customer.Customer;
import com.ns.nearby_solutions.rental.Tool;

import java.util.Optional;

public class ToolCustomerFullDTO {
    private Long toolId;
    private Integer customerId;
    private Optional<ToolRentalListing> toolRentalListing;
    private Optional<Customer> customer;

    public ToolCustomerFullDTO(Long toolId, Integer customerId, Optional<ToolRentalListing> toolRentalListing, Optional<Customer> customer) {
        this.toolId = toolId;
        this.customerId = customerId;
        this.toolRentalListing = toolRentalListing;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Optional<ToolRentalListing> getToolRentalListing() {
        return toolRentalListing;
    }

    public void setToolRentalListing(Optional<ToolRentalListing> toolRentalListing) {
        this.toolRentalListing = toolRentalListing;
    }

    public Optional<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Optional<Customer> customer) {
        this.customer = customer;
    }
}
