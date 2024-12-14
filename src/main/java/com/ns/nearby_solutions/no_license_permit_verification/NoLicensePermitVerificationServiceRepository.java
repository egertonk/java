package com.ns.nearby_solutions.no_license_permit_verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoLicensePermitVerificationServiceRepository extends JpaRepository<NoLicensePermitVerificationService, Integer> {
    // Method to search by name
    List<NoLicensePermitVerificationService> findByNameContainingIgnoreCase(String name);
}
