package com.ns.nearby_solutions.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users",
        indexes = {
                @Index(name = "idx_user_email", columnList = "email"),
                @Index(name = "idx_user_username", columnList = "username"),
                @Index(name = "idx_user_role", columnList = "role")
        })
public class User implements Serializable {  // ✅ Implements Serializable for pagination support

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "\"password_hash\"", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "\"phone_number\"", length = 20)
    private String phoneNumber;

    @Column(name = "\"profile_picture\"", length = 255)
    private String profilePicture;

    @Column(name = "\"date_of_birth\"")
    private LocalDate dateOfBirth;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "\"created_at\"", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "\"updated_at\"")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "\"terms_accepted\"", nullable = false)
    private Boolean termsAccepted;

    @Column(name = "\"privacy_policy_accepted\"", nullable = false)
    private Boolean privacyPolicyAccepted;

    @Column(name = "\"middle_name\"", length = 50)
    private String middleName;

    @Column(name = "\"last_name\"", nullable = false, length = 50)
    private String lastName;

    @Column(name = "\"first_name\"", nullable = false, length = 50)
    private String firstName;

    @Column(name = "\"full_name\"", length = 255)
    private String fullName;

    @Column(name = "\"is_verified\"", nullable = false)
    private Boolean isVerified = false;

    @Column(name = "\"verification_token\"", length = 255)
    private String verificationToken;

    @Column(name = "\"reset_password_token\"", length = 255)
    private String resetPasswordToken;

    @Column(name = "\"reset_password_expiration\"")
    private LocalDateTime resetPasswordExpiration;

    @Column(name = "\"last_login\"")
    private LocalDateTime lastLogin;

    @Column(name = "\"login_attempts\"", nullable = false)
    private Integer loginAttempts = 0;

    @Column(name = "\"is_locked\"", nullable = false)
    private Boolean isLocked = false;

    @Column(name = "\"notification_preferences\"", columnDefinition = "JSONB")
    private String notificationPreferences;

    @Column(name = "\"preferred_theme\"", length = 20)
    private String preferredTheme;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "nationality", length = 100)
    private String nationality;

    @Column(name = "permissions", columnDefinition = "JSONB")
    private String permissions;

    @Column(name = "\"role_level\"", nullable = false)
    private Integer roleLevel = 1;

    @Column(name = "\"last_login_ip\"", length = 45)
    private String lastLoginIp;

    @Column(name = "\"device_info\"", columnDefinition = "JSONB")
    private String deviceInfo;

    @Column(name = "\"subscription_type\"", length = 50)
    private String subscriptionType;

    @Column(name = "\"subscription_status\"", length = 20)
    private String subscriptionStatus;

    @Column(name = "\"subscription_start_date\"")
    private LocalDateTime subscriptionStartDate;

    @Column(name = "\"subscription_end_date\"")
    private LocalDateTime subscriptionEndDate;

    @Column(name = "\"referral_code\"", length = 50)
    private String referralCode;

    @Column(name = "\"referred_by\"", length = 50)
    private String referredBy;

    @Column(name = "\"is_deleted\"", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "\"deleted_at\"")
    private LocalDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
