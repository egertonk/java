package com.ns.nearby_solutions.tool_rental;

import com.ns.nearby_solutions.customer.Customer;
import com.ns.nearby_solutions.customer.CustomerRepository;
import com.ns.nearby_solutions.rental.Tool;
import com.ns.nearby_solutions.rental.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/tool-customer")
public class ToolCustomerController {

    @Autowired
    private ToolRentalListingRepository toolRentalListingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public ToolCustomerFullDTO getToolAndCustomerData(
            @RequestParam("toolId") Long toolId,
            @RequestParam("customerId") Integer customerId
    ) {
        Optional<Customer> customer  =  customerRepository.findById(customerId);
        System.out.println("customer---------" + customer);
        Optional<ToolRentalListing> toolRentalListing  = toolRentalListingRepository.findByToolId(toolId);
        System.out.println("---------" + toolRentalListing);
        // Return the combined DTO
        return new ToolCustomerFullDTO(toolId, customerId, toolRentalListing, customer);
    }
}
