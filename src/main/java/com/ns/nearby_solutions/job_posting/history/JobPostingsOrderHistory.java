package com.ns.nearby_solutions.job_posting.history;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "job_postings_order_history")
public class JobPostingsOrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "job_id", nullable = false)
    private Long jobId;

    @Column(name = "solutionist_id", nullable = false)
    private Long solutionistId;

    @Column(name = "poster_id", nullable = false)
    private Long posterId;

    @Column(name = "jobname", nullable = false, length = 255)
    private String jobName;

    @Column(name = "jobtask", nullable = false, columnDefinition = "TEXT")
    private String jobTask;

    @Column(name = "jobdescription", columnDefinition = "TEXT")
    private String jobDescription;

    @Column(name = "jobprice", nullable = false, precision = 10, scale = 2)
    private BigDecimal jobPrice;

    @Column(name = "jobzip", length = 20)
    private String jobZip;

    @Column(name = "jobcitylocation", length = 255)
    private String jobCityLocation;

    @Column(name = "jobaddress", columnDefinition = "TEXT")
    private String jobAddress;

    @Column(name = "jobdate")
    private LocalDate jobDate;

    @Column(name = "jobtime")
    private LocalTime jobTime;

    @Column(name = "urgencylevel", length = 255)
    private String urgencyLevel;

    @Column(name = "expectedduration", length = 255)
    private String expectedDuration;

    @Column(name = "materialsprovided", length = 255)
    private String materialsProvided;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "phonenumber", nullable = false, length = 255)
    private String phoneNumber;

    @Column(name = "customername", length = 255)
    private String customerName;

    @Column(name = "preferredcommunicationmethod", length = 255)
    private String preferredCommunicationMethod;

    @Column(name = "experiencelevel", length = 255)
    private String experienceLevel;

    @Column(name = "providergenderpreference", length = 255)
    private String providerGenderPreference;

    @Column(name = "paymentmethodprofile", length = 255)
    private String paymentMethodProfile;

    @Column(name = "paymentstatus")
    private Boolean paymentStatus;

    @Column(name = "cancellationpolicy", length = 255)
    private String cancellationPolicy;

    @Column(name = "specialinstructions", columnDefinition = "TEXT")
    private String specialInstructions;

    @Column(name = "accessibilityinformation", columnDefinition = "TEXT")
    private String accessibilityInformation;

    @Column(name = "jobcountry", length = 255)
    private String jobCountry;

    @Column(name = "jobstate", length = 255)
    private String jobState;

    @Column(name = "jobacceptedbysolutionist")
    private Boolean jobAcceptedBySolutionist;

    @Column(name = "jobacceptedbyposter")
    private Boolean jobAcceptedByPoster;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "jobstatus", nullable = false, length = 255)
    private String jobStatus;

    @Column(name = "jobcategory", length = 255)
    private String jobCategory;

    @Column(name = "jobcategoryservices", length = 255)
    private String jobCategoryServices;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    //    @Column(name = "images", columnDefinition = "JSONB")
//    private List<String> images;
    @Column(name = "images")
    private String images;

//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
