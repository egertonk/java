package com.ns.nearby_solutions.rental;

import com.ns.nearby_solutions.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    // Add a new tool
    public Tool addTool(Tool tool) {
        return toolRepository.save(tool);
    }

    // Get all tools
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    // Get tool by ID
    public Tool getToolById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tool not found with id: " + id));

    }

    // Update tool details
    public Tool updateTool(Long id, Tool updatedTool) {
        Tool tool = getToolById(id);
        tool.setToolName(updatedTool.getToolName());
        tool.setDescription(updatedTool.getDescription());
        tool.setPricePerDay(updatedTool.getPricePerDay());
        tool.setAvailableFrom(updatedTool.getAvailableFrom());
        tool.setAvailableTo(updatedTool.getAvailableTo());
        tool.setImageUrl(updatedTool.getImageUrl());
        return toolRepository.save(tool);
    }

    // Delete tool
    public void deleteTool(Long id) {
        Tool tool = getToolById(id);
        toolRepository.delete(tool);
    }

    // Check tool availability
    public boolean isToolAvailable(Long toolId, LocalDate fromDate, LocalDate toDate) {
        Tool tool = getToolById(toolId);
        return !fromDate.isBefore(tool.getAvailableFrom()) && !toDate.isAfter(tool.getAvailableTo());
    }
}
