package com.ns.nearby_solutions.no_license_permit_verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/no-verification-services")
public class NoLicensePermitVerificationServiceController {

    @Autowired
    private NoLicensePermitVerificationServiceService service;

    // Create
    @PostMapping
    public ResponseEntity<NoLicensePermitVerificationService> create(@RequestBody NoLicensePermitVerificationService newService) {
        return ResponseEntity.ok(service.save(newService));
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<NoLicensePermitVerificationService>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<NoLicensePermitVerificationService> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<NoLicensePermitVerificationService> update(
            @PathVariable Integer id,
            @RequestBody NoLicensePermitVerificationService updatedService
    ) {
        if (service.findById(id).isPresent()) {
            updatedService.setId(id);
            return ResponseEntity.ok(service.save(updatedService));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Search by Name
    @GetMapping("/search")
    public ResponseEntity<List<NoLicensePermitVerificationService>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }
}
