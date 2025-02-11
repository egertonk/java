package com.ns.nearby_solutions.tool_rental;

import com.ns.nearby_solutions.customer.CustomerToolDetailsDTO;
import com.ns.nearby_solutions.user.User;
import com.ns.nearby_solutions.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/tools")
public class ToolRentalListingController {

    private final ToolRentalListingService service;
    private final UserService userService;

    @Autowired
    public ToolRentalListingController(ToolRentalListingService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public List<ToolRentalListing> getAllTools() {
        return service.getAllTools();
    }

    @GetMapping("/{id}/{userId}")
    public ResponseEntity<CustomerToolDetailsDTO> getToolById(@PathVariable Long id, @PathVariable("userId") Long userId) {
        Optional<ToolRentalListing> tool = service.getToolById(id);
        User customer = userService.getUserById(userId);
        log.info("Getting tool by id: {}", id, " user id {} ", userId);

        CustomerToolDetailsDTO dto = new CustomerToolDetailsDTO();
        dto.setCustomerInformation(customer);
        dto.setToolRentalDetails(tool);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/available")
    public List<ToolRentalListing> getAvailableTools() {
        log.info("Getting all available tools: {}");
        return service.getAvailableTools();
    }

    @PostMapping
    public ResponseEntity<ToolRentalListing> addTool(@RequestBody ToolRentalListing tool) {
        log.info("adding a new tool : {}", tool.getToolBrand());
        ToolRentalListing savedTool = service.addTool(tool);
        return ResponseEntity.ok(savedTool);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToolRentalListing> updateTool(@PathVariable Long id, @RequestBody ToolRentalListing updatedTool) {
        try {
            ToolRentalListing tool = service.updateTool(id, updatedTool);
            log.info("Updating tool by id successful: {}", id);
            return ResponseEntity.ok(tool);
        } catch (RuntimeException e) {
            log.info("Updating tool by id failed: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        service.deleteTool(id);
        log.info("Deleting tool by id: {}", id);
        return ResponseEntity.noContent().build();
    }
}