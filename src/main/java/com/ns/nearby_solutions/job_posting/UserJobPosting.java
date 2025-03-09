package com.ns.nearby_solutions.job_posting;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_job_postings")
public class UserJobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobpostings_id_seq")
    @SequenceGenerator(name = "jobpostings_id_seq", sequenceName = "jobpostings_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "jobname", nullable = false)
    private String jobName;

    @Column(name = "solutionist_id", nullable = false)
    private Long solutionistId;

    @Column(name = "jobtask", nullable = false)
    private String jobTask;

    @Column(name = "jobdescription", columnDefinition = "TEXT")
    private String jobDescription;

    @Column(name = "jobprice", nullable = false)
    private BigDecimal jobPrice;

    @Column(name = "jobzip", nullable = false)
    private String jobZip;

    @Column(name = "jobcitylocation", nullable = false)
    private String jobCityLocation;

    @Column(name = "jobaddress", nullable = false)
    private String jobAddress;

    @Column(name = "jobdate")
    private LocalDate jobDate;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "urgencylevel")
    private String urgencyLevel;

    @Column(name = "expectedduration")
    private String expectedDuration;

    @Column(name = "materialsprovided")
    private String materialsProvided;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phonenumber", nullable = false)
    private String phoneNumber;

    @Column(name = "customername")
    private String customerName;

    @Column(name = "preferredcommunicationmethod", length = 255)
    private String preferredCommunicationMethod;

    @Column(name = "experiencelevel")
    private String experienceLevel;

    @Column(name = "providergenderpreference")
    private String providerGenderPreference;

    @Column(name = "paymentmethodonfile")
    private String paymentMethodOnFile;

    @Column(name = "paymentstatus")
    private Boolean paymentStatus;

    @Column(name = "cancellationpolicy")
    private String cancellationPolicy;

    @Column(name = "specialinstructions", columnDefinition = "TEXT")
    private String specialInstructions;

    @Column(name = "accessibilityinformation", columnDefinition = "TEXT")
    private String accessibilityInformation;

    @Column(name = "poster_id", nullable = false)
    private Integer posterId;

    @Column(name = "jobcountry")
    private String jobCountry;

    @Column(name = "jobstate")
    private String jobState;

    @Column(name = "jobacceptedbysolutionist")
    private Boolean jobAcceptedBySolutionist;

    @Column(name = "jobacceptedbyposter")
    private Boolean jobAcceptedByPoster;

    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "jobstatus", nullable = false)
    private String jobStatus;

    @Column(name = "jobcategory")
    private String jobCategory;

    @Column(name = "jobcategoryservices")
    private String jobCategoryServices;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "images")
    private String images;
}
