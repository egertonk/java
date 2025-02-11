package com.ns.nearby_solutions.solutionist_work_Settings;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "solutionist_work_settings")
public class SolutionistWorkSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solutionist_work_settings_id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Column(name = "businessstarttime", nullable = false)
    private LocalTime businessStartTime;

    @Column(name = "businessendtime", nullable = false)
    private LocalTime businessEndTime;

    @Column(name = "oneblockedstatus", nullable = false)
    private Boolean oneBlockedStatus;

    @Column(name = "jobasapstatus", nullable = false)
    private Boolean jobAsapStatus;

    @Column(name = "onlinestatus", nullable = false)
    private Boolean onlineStatus;

    @Column(name = "availabledays", nullable = false, columnDefinition = "json")
    private String availableDays; // JSON stored as String

    @Column(name = "vacationstatus", nullable = false)
    private Boolean vacationStatus;

    @Column(name = "vacationstartdate")
    private LocalDate vacationStartDate;

    @Column(name = "vacationenddate")
    private LocalDate vacationEndDate;

    @Column(name = "twentyfourhoursstatus", nullable = false)
    private Boolean twentyFourHoursStatus;

    @Column(name = "twelvehoursstatus", nullable = false)
    private Boolean twelveHoursStatus;

    @Column(name = "timezone", length = 50)
    private String timezone;

    @Column(name = "last_updated_by")
    private Long lastUpdatedBy;

    @Column(name = "work_location", length = 255)
    private String workLocation;

    @Column(name = "special_instructions")
    private String specialInstructions;

    @Column(name = "created_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "long_term_subscription_allow", nullable = false, columnDefinition = "boolean default false")
    private Boolean longTermSubscriptionAllow;
}
