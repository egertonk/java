package com.ns.nearby_solutions.solutionist_work_Settings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ns.nearby_solutions.solutionist.Solutionist;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "solutionist_work_settings", schema = "public")
public class SolutionistWorkSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solutionist_work_settings_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_solutionist_work_settings"))
    @JsonIgnore // This will exclude the user field from JSON responses
    private Solutionist solutionist;

    @Column(name = "businessstarttime", nullable = false)
    private Time businessStartTime;

    @Column(name = "businessendtime", nullable = false)
    private Time businessEndTime;

    @Column(name = "oneblockedstatus", nullable = false)
    private Boolean oneBlockedStatus;

    @Column(name = "jobasapstatus", nullable = false)
    private Boolean jobASAPStatus;

    @Column(name = "onlinestatus", nullable = false)
    private Boolean onlineStatus;

    @Column(name = "availabledays", nullable = false, columnDefinition = "json")
    private String availableDays; // Store JSON data as a String, or use a JSON library to map to a List

    @Column(name = "vacationstatus", nullable = false)
    private Boolean vacationStatus;

    @Column(name = "vacationstartdate")
    private Date vacationStartDate;

    @Column(name = "vacationenddate")
    private Date vacationEndDate;

    @Column(name = "twentyfourhoursstatus", nullable = false)
    private Boolean twentyFourHoursStatus;

    @Column(name = "twelvehoursstatus", nullable = false)
    private Boolean twelveHoursStatus;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Solutionist getUser() {
        return solutionist;
    }

    public Time getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Time businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public Time getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(Time businessEndTime) {
        this.businessEndTime = businessEndTime;
    }

    public Boolean getOneBlockedStatus() {
        return oneBlockedStatus;
    }

    public void setOneBlockedStatus(Boolean oneBlockedStatus) {
        this.oneBlockedStatus = oneBlockedStatus;
    }

    public Boolean getJobASAPStatus() {
        return jobASAPStatus;
    }

    public void setJobASAPStatus(Boolean jobASAPStatus) {
        this.jobASAPStatus = jobASAPStatus;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean bandStatus) {
        this.onlineStatus = bandStatus;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    public Boolean getVacationStatus() {
        return vacationStatus;
    }

    public void setVacationStatus(Boolean vacationStatus) {
        this.vacationStatus = vacationStatus;
    }

    public Date getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(Date vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public Date getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(Date vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public Boolean getTwentyFourHoursStatus() {
        return twentyFourHoursStatus;
    }

    public void setTwentyFourHoursStatus(Boolean twentyFourHoursStatus) {
        this.twentyFourHoursStatus = twentyFourHoursStatus;
    }

    public Boolean getTwelveHoursStatus() {
        return twelveHoursStatus;
    }

    public void setTwelveHoursStatus(Boolean twelveHoursStatus) {
        this.twelveHoursStatus = twelveHoursStatus;
    }
}

