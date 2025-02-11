//package com.ns.nearby_solutions.solutionist;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "users")
//public class Solutionist {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, length = 255)
//    private String name;
//
//    @Column(nullable = false, unique = true, length = 255)
//    private String email;
//
//    @Column(nullable = false, length = 255)
//    private String password;
//
//    @Column(length = 50)
//    private String role;
//
//    @Column(nullable = false, unique = true, length = 50)
//    private String username;
//
//    @Column(nullable = false)
//    private String passwordHash;
//
//    @Column(length = 255)
//    private String fullName;
//
//    @Column(length = 20)
//    private String phoneNumber;
//
//    @Column
//    private String profilePicture;
//
//    @Column
//    private LocalDate dateOfBirth;
//
//    @Column(length = 100)
//    private String location;
//
//    @Column(columnDefinition = "jsonb")
//    private String communicationPreferences;
//
//    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime updatedAt = LocalDateTime.now();
//
//    @Column(nullable = false)
//    private Boolean termsAccepted;
//
//    @Column(nullable = false)
//    private Boolean privacyPolicyAccepted;
//
//    @Column(nullable = false, length = 50)
//    private String firstName;
//
//    @Column(length = 50)
//    private String middleName;
//
//    @Column(nullable = false, length = 50)
//    private String lastName;
//
//    // Getters and Setters
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPasswordHash() {
//        return passwordHash;
//    }
//
//    public void setPasswordHash(String passwordHash) {
//        this.passwordHash = passwordHash;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(String profilePicture) {
//        this.profilePicture = profilePicture;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getCommunicationPreferences() {
//        return communicationPreferences;
//    }
//
//    public void setCommunicationPreferences(String communicationPreferences) {
//        this.communicationPreferences = communicationPreferences;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public Boolean getTermsAccepted() {
//        return termsAccepted;
//    }
//
//    public void setTermsAccepted(Boolean termsAccepted) {
//        this.termsAccepted = termsAccepted;
//    }
//
//    public Boolean getPrivacyPolicyAccepted() {
//        return privacyPolicyAccepted;
//    }
//
//    public void setPrivacyPolicyAccepted(Boolean privacyPolicyAccepted) {
//        this.privacyPolicyAccepted = privacyPolicyAccepted;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//}
