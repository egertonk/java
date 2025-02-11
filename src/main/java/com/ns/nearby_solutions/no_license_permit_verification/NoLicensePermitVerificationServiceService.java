package com.ns.nearby_solutions.no_license_permit_verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoLicensePermitVerificationServiceService {

    @Autowired
    private NoLicensePermitVerificationServiceRepository repository;

    // Create
    public NoLicensePermitVerificationService save(NoLicensePermitVerificationService service) {
        return repository.save(service);
    }

    // Read
    public List<NoLicensePermitVerificationService> findAll() {
        return repository.findAll();
    }

    public Optional<NoLicensePermitVerificationService> findById(Integer id) {
        return repository.findById(id);
    }

    // Update
    public NoLicensePermitVerificationService update(NoLicensePermitVerificationService service) {
        return repository.save(service);
    }

    // Delete
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    // Search by Name
    public List<NoLicensePermitVerificationService> searchByName(String name) {
        return repository.findByCategoryContainingIgnoreCase(name);
    }
}
