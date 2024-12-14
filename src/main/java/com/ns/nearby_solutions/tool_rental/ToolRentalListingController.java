package com.ns.nearby_solutions.tool_rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tool-rental-listing")
public class ToolRentalListingController {

    private final ToolRentalListingService toolRentalListingService;

    @Autowired
    public ToolRentalListingController(ToolRentalListingService toolRentalListingService) {
        this.toolRentalListingService = toolRentalListingService;
    }

    // 1. Get All Tools
    @GetMapping
    public ResponseEntity<List<ToolRentalListing>> getAllTools() {
        List<ToolRentalListing> tools = toolRentalListingService.getAllTools();
        System.out.println("url---------" + tools);
        return ResponseEntity.ok(tools);
    }

    // 2. Get Tool By ID
    @GetMapping("/{id}")
    public ResponseEntity<ToolRentalListing> getToolById(@PathVariable Long id) {
        ToolRentalListing tool = toolRentalListingService.getToolById(id);
        return ResponseEntity.ok(tool);
    }

    // 3. Create Tool
    @PostMapping
    public ResponseEntity<ToolRentalListing> createTool(@RequestBody ToolRentalListing tool) {
        ToolRentalListing savedTool = toolRentalListingService.createTool(tool);
        return ResponseEntity.ok(savedTool);
    }

    // 4. Update Tool
    @PutMapping("/{id}")
    public ResponseEntity<ToolRentalListing> updateTool(
            @PathVariable Long id,
            @RequestBody ToolRentalListing updatedTool
    ) {
        ToolRentalListing tool = toolRentalListingService.updateTool(id, updatedTool);
        return ResponseEntity.ok(tool);
    }

    // 5. Delete Tool
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable Long id) {
        toolRentalListingService.deleteTool(id);
        return ResponseEntity.noContent().build();
    }

    // 6. Search Tools
    @GetMapping("/search")
    public ResponseEntity<List<ToolRentalListing>> searchTools(
            @RequestParam(required = false) String toolCity,
            @RequestParam(required = false) String toolName,
            @RequestParam(required = false) String toolBrand
    ) {
        List<ToolRentalListing> tools = toolRentalListingService.searchTools(toolCity, toolName, toolBrand);
        return ResponseEntity.ok(tools);
    }
}
