package com.ns.nearby_solutions.tool_rental;
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

    public ToolRentalListingController(ToolRentalListingService service) {
        this.service = service;
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

    @GetMapping("/{id}")
    public ResponseEntity<ToolRentalListing> getToolById(@PathVariable Long id) {
        Optional<ToolRentalListing> tool = service.getToolById(id);
        return tool.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
}
