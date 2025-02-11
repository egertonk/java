package com.ns.nearby_solutions.job_posting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface UserJobPostingRepository extends JpaRepository<UserJobPosting, Long> {

    @Query("SELECT j FROM UserJobPosting j " +
            "WHERE (:jobCountry IS NULL OR j.jobCountry = :jobCountry) " +
            "AND (:createdAt IS NULL OR j.createdAt >= :createdAt) " +
            "AND (:jobStatus IS NULL OR j.jobStatus = :jobStatus) " +
            "AND (:experienceLevel IS NULL OR j.experienceLevel = :experienceLevel) " +
            "AND (:urgencyLevel IS NULL OR j.urgencyLevel = :urgencyLevel) " +
            "AND (:jobCityLocation IS NULL OR j.jobCityLocation LIKE %:jobCityLocation%) " +
            "AND (:jobZip IS NULL OR j.jobZip = :jobZip) " +
            "AND (:jobDescription IS NULL OR j.jobDescription LIKE %:jobDescription%) " +
            "AND (:jobTask IS NULL OR j.jobTask LIKE %:jobTask%) " +
            "AND (:jobName IS NULL OR j.jobName LIKE %:jobName%) " +
            "AND (:id IS NULL OR j.id = :id)")
    List<UserJobPosting> searchJobPostings(
            @Param("jobCountry") String jobCountry,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("jobStatus") String jobStatus,
            @Param("experienceLevel") String experienceLevel,
            @Param("urgencyLevel") String urgencyLevel,
            @Param("jobCityLocation") String jobCityLocation,
            @Param("jobZip") String jobZip,
            @Param("jobDescription") String jobDescription,
            @Param("jobTask") String jobTask,
            @Param("jobName") String jobName,
            @Param("id") Long id
    );

    // ✅ Query to filter jobs with required conditions and support pagination
    @Query("SELECT j FROM UserJobPosting j " +
            "WHERE j.paymentStatus = true " +
            "AND j.jobAcceptedByPoster = true " +
            "AND j.jobStatus = 'Listed'")
    Page<UserJobPosting> findValidJobPostings(Pageable pageable);
}
