package com.ns.nearby_solutions.tool_rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToolRentalListingRepository extends JpaRepository<ToolRentalListing, Long> {

    // Custom query method to search by toolCity, toolName, or toolBrand
    List<ToolRentalListing> findByToolCityOrToolNameOrToolBrand(String toolCity, String toolName, String toolBrand);

    Optional<ToolRentalListing> findByToolId(Long toolId);
}

