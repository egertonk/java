package com.ns.nearby_solutions.tool_rental;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class ToolRentalListingService {

    private final ToolRentalListingRepository repository;

    public ToolRentalListingService(ToolRentalListingRepository repository) {
        this.repository = repository;
    }

    public Page<ToolRentalListing> getAllTools(Pageable pageable) {
        log.info("Getting all tools with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return repository.findAll(pageable);
    }

    public Optional<ToolRentalListing> getToolById(Long id) {
        log.info("Finding tool by id: {}", id);
        return repository.findById(id);
    }

    // ✅ Fix: Fetch available tools with pagination
    public Page<ToolRentalListing> getAvailableTools(Pageable pageable) {
        log.info("Fetching all available tools with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return repository.findByIsAvailable(true, pageable);
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
        log.info("Deleting tool by id: {}", id);
        repository.deleteById(id);
    }
}
