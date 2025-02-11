package com.ns.nearby_solutions.tool_rental;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ToolRentalListingService {

    private final ToolRentalListingRepository repository;

    @Autowired
    public ToolRentalListingService(ToolRentalListingRepository repository) {
        this.repository = repository;
    }

    public List<ToolRentalListing> getAllTools() {
        log.info("Getting all tools");
        return repository.findAll();
    }

    public Optional<ToolRentalListing> getToolById(Long id) {
        log.info("Finding tool by id: {}", id);
        return repository.findById(id);
    }

    public List<ToolRentalListing> getAvailableTools() {
        log.info("Finding all tools that are available");
        return repository.findByIsAvailable(true);
    }

    public ToolRentalListing addTool(ToolRentalListing tool) {
        log.info("Saving tool: {}", tool.getToolName());
        return repository.save(tool);
    }

    public ToolRentalListing updateTool(Long id, ToolRentalListing updatedTool) {
        log.info("Updating tool: {}", id);
        return repository.findById(id).map(tool -> {
            tool.setToolName(updatedTool.getToolName());
            tool.setDescription(updatedTool.getDescription());
            tool.setToolCategory(updatedTool.getToolCategory());
            tool.setToolBrand(updatedTool.getToolBrand());
            tool.setToolAddress(updatedTool.getToolAddress());
            tool.setToolCity(updatedTool.getToolCity());
            tool.setToolState(updatedTool.getToolState());
            tool.setToolCountry(updatedTool.getToolCountry());
            tool.setPricePerDay(updatedTool.getPricePerDay());
            tool.setIsAvailable(updatedTool.getIsAvailable());
            tool.setNextAvailableDate(updatedTool.getNextAvailableDate());
            tool.setRating(updatedTool.getRating());
            tool.setNumberOfReviews(updatedTool.getNumberOfReviews());
            tool.setPowerSource(updatedTool.getPowerSource());
            tool.setRenterId(updatedTool.getRenterId());
            tool.setIsShippingValid(updatedTool.getIsShippingValid());
            tool.setShippingCost(updatedTool.getShippingCost());
            tool.setEstimatedDelivery(updatedTool.getEstimatedDelivery());
            tool.setDiscountPercent(updatedTool.getDiscountPercent());
            tool.setReturnDate(updatedTool.getReturnDate());
            tool.setUsageInstructions(updatedTool.getUsageInstructions());
            tool.setSafetyInformation(updatedTool.getSafetyInformation());
            tool.setImageUrl(updatedTool.getImageUrl());
            tool.setPosterId(updatedTool.getPosterId());
            return repository.save(tool);
        }).orElseThrow(() -> new RuntimeException("Tool not found with id " + id));
    }

    public void deleteTool(Long id) {
        repository.deleteById(id);
    }
}