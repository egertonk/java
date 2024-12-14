package com.ns.nearby_solutions.tool_rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToolRentalListingService {

    private final ToolRentalListingRepository toolRentalListingRepository;

    @Autowired
    public ToolRentalListingService(ToolRentalListingRepository toolRentalListingRepository) {
        this.toolRentalListingRepository = toolRentalListingRepository;
    }

    public List<ToolRentalListing> getAllTools() {
        return toolRentalListingRepository.findAll();
    }

    public ToolRentalListing getToolById(Long id) {
        return toolRentalListingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tool not found with ID: " + id));
    }

    public ToolRentalListing createTool(ToolRentalListing tool) {
        return toolRentalListingRepository.save(tool);
    }

    public ToolRentalListing updateTool(Long id, ToolRentalListing updatedTool) {
        ToolRentalListing existingTool = getToolById(id);
        updatedTool.setToolId(existingTool.getToolId()); // Preserve the ID
        return toolRentalListingRepository.save(updatedTool);
    }

    public void deleteTool(Long id) {
        toolRentalListingRepository.deleteById(id);
    }

    public List<ToolRentalListing> searchTools(String toolCity, String toolName, String toolBrand) {
        return toolRentalListingRepository.findByToolCityOrToolNameOrToolBrand(toolCity, toolName, toolBrand);
    }
}
