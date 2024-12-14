package com.ns.nearby_solutions.no_license_permit_verification;
import jakarta.persistence.*;

@Entity
@Table(name = "no_license_permit_verification_service")
public class NoLicensePermitVerificationService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String category;

    @Column(length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "license_permit_verification", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean licensePermitVerification;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getLicensePermitVerification() {
        return licensePermitVerification;
    }

    public void setLicensePermitVerification(Boolean licensePermitVerification) {
        this.licensePermitVerification = licensePermitVerification;
    }
}
