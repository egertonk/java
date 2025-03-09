package com.ns.nearby_solutions.tool_rental;
import com.ns.nearby_solutions.customer.CustomerToolDetailsDTO;
import com.ns.nearby_solutions.user.User;
import com.ns.nearby_solutions.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/tools")
public class ToolRentalListingController {

    private final ToolRentalListingService service;
    private final UserService userService;

    public ToolRentalListingController(ToolRentalListingService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    // ✅ Fix: Ensure correct pagination
    @GetMapping("/available")
    public ResponseEntity<Page<ToolRentalListing>> getAvailableTools(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Getting all available tools: - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<ToolRentalListing> toolRentalListing = service.getAvailableTools(pageable);
        return ResponseEntity.ok(toolRentalListing);
    }

    @GetMapping("/{id}/{userId}")
    public ResponseEntity<CustomerToolDetailsDTO> getToolById(@PathVariable Long id, @PathVariable Long userId) {
        Optional<ToolRentalListing> tool = service.getToolById(id);
        User customer = userService.getUserById(userId);

        log.info("Getting a specific tool information id: {}", id, " | userId: ", userId);

        CustomerToolDetailsDTO dto = new CustomerToolDetailsDTO();
        dto.setCustomerInformation(customer);
        dto.setToolRentalDetails(tool);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ToolRentalListing> addTool(@RequestBody ToolRentalListing tool) {
        log.info("Adding a new tool: {}", tool.getToolBrand());
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

    // ✅ Search tools by multiple fields (Only available tools)
    @GetMapping("/search")
    public ResponseEntity<Page<ToolRentalListing>> searchTools(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Searching tools with keyword '{}', Page: {}, Size: {}", keyword, page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<ToolRentalListing> searchResults = service.searchTools(keyword, pageable);
        return ResponseEntity.ok(searchResults);
    }
}
