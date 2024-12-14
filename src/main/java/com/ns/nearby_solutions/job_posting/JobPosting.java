package com.ns.nearby_solutions.job_posting;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "jobpostings")
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jobname", nullable = false)
    private String jobName;

    @Column(name = "jobtask", nullable = false)
    private String jobTask;

    @Column(name = "jobdescription")
    private String jobDescription;

    @Column(name = "jobprice", nullable = false)
    private BigDecimal jobPrice;

    @Column(name = "jobzip", nullable = false)
    private String jobZip;

    @Column(name = "jobcitylocation", nullable = false)
    private String jobCityLocation;

    @Column(name = "jobaddress")
    private String jobAddress;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;

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

    @Column(name = "customername", nullable = false)
    private String customerName;

    @Column(name = "preferredcommunicationmethod")
    private String preferredCommunicationMethod;

    @Column(name = "jobstatus", nullable = false)
    private boolean jobStatus;

    @Column(name = "jobacceptedbysolutionist ", nullable = false)
    private boolean jobAcceptedBySolutionist ;

    @Column(name = "jobacceptedbycustomer", nullable = false)
    private boolean jobAcceptedByCustomer ;

    @Column(name = "jobstate", nullable = false)
    private String jobState;

    @Column(name = "jobcountry", nullable = false)
    private String jobCountry;

    @Column(name = "experiencelevel")
    private String experienceLevel;

    @Column(name = "providergenderpreference")
    private String providerGenderPreference;

    @Column(name = "paymentmethodonfile")
    private String paymentMethodOnFile;

    @Column(name = "paymentstatus", nullable = false)
    private boolean paymentStatus;

    @Column(name = "cancellationpolicy")
    private String cancellationPolicy;

    @Column(name = "specialinstructions")
    private String specialInstructions;

    @Column(name = "accessibilityinformation")
    private String accessibilityInformation;

    @Column(name = "customerid", nullable = false)
    private Integer customerId;

    // Getters and setters

    public boolean isJobAcceptedBySolutionist() {
        return jobAcceptedBySolutionist;
    }

    public void setJobAcceptedBySolutionist(boolean jobAcceptedBySolutionist) {
        this.jobAcceptedBySolutionist = jobAcceptedBySolutionist;
    }

    public boolean isJobAcceptedByCustomer() {
        return jobAcceptedByCustomer;
    }

    public void setJobAcceptedByCustomer(boolean jobAcceptedByCustomer) {
        this.jobAcceptedByCustomer = jobAcceptedByCustomer;
    }

    public boolean isJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(boolean jobStatus) {
        this.jobStatus = jobStatus;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobTask() {
        return jobTask;
    }

    public void setJobTask(String jobTask) {
        this.jobTask = jobTask;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public BigDecimal getJobPrice() {
        return jobPrice;
    }

    public void setJobPrice(BigDecimal jobPrice) {
        this.jobPrice = jobPrice;
    }

    public String getJobZip() {
        return jobZip;
    }

    public void setJobZip(String jobZip) {
        this.jobZip = jobZip;
    }

    public String getJobCityLocation() {
        return jobCityLocation;
    }

    public void setJobCityLocation(String jobCityLocation) {
        this.jobCityLocation = jobCityLocation;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(String expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public String getMaterialsProvided() {
        return materialsProvided;
    }

    public void setMaterialsProvided(String materialsProvided) {
        this.materialsProvided = materialsProvided;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPreferredCommunicationMethod() {
        return preferredCommunicationMethod;
    }

    public void setPreferredCommunicationMethod(String preferredCommunicationMethod) {
        this.preferredCommunicationMethod = preferredCommunicationMethod;
    }

    public Boolean getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Boolean jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getProviderGenderPreference() {
        return providerGenderPreference;
    }

    public void setProviderGenderPreference(String providerGenderPreference) {
        this.providerGenderPreference = providerGenderPreference;
    }

    public String getPaymentMethodOnFile() {
        return paymentMethodOnFile;
    }

    public void setPaymentMethodOnFile(String paymentMethodOnFile) {
        this.paymentMethodOnFile = paymentMethodOnFile;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCancellationPolicy() {
        return cancellationPolicy;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getAccessibilityInformation() {
        return accessibilityInformation;
    }

    public void setAccessibilityInformation(String accessibilityInformation) {
        this.accessibilityInformation = accessibilityInformation;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public void setJobCountry(String jobCountry) {
        this.jobCountry = jobCountry;
    }
}
