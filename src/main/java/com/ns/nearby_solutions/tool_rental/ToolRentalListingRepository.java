package com.ns.nearby_solutions.tool_rental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRentalListingRepository extends JpaRepository<ToolRentalListing, Long> {

    // ✅ Fix: Ensure the query returns `Page<ToolRentalListing>` instead of `List<ToolRentalListing>`
    Page<ToolRentalListing> findByIsAvailable(Boolean isAvailable, Pageable pageable);
}

