package com.ns.nearby_solutions.no_license_permit_verification;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "no_license_permit_verification_service")
@Getter
@Setter
public class NoLicensePermitVerificationService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category", length = 255)
    private String category;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "license_permit_verification", nullable = true)
    private Boolean licensePermitVerification;
}
