package com.ns.nearby_solutions.tool_rental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ToolRentalListingRepository extends JpaRepository<ToolRentalListing, Long> {

    Page<ToolRentalListing> findByIsAvailable(Boolean isAvailable, Pageable pageable);

    // ✅ Search tools by multiple fields (Only available tools)
    @Query("""
        SELECT t FROM ToolRentalListing t
        WHERE t.isAvailable = true
        AND (LOWER(t.toolName) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.toolCategory) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.toolBrand) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.toolCity) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.toolState) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.toolCountry) LIKE LOWER(CONCAT('%', :keyword, '%'))
        OR LOWER(t.toolZipcode) LIKE LOWER(CONCAT('%', :keyword, '%')))
    """)
    Page<ToolRentalListing> searchByKeyword(String keyword, Pageable pageable);

    Page<ToolRentalListing> findByIsAvailableTrue(Pageable pageable);
}

