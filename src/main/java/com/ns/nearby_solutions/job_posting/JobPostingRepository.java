package com.ns.nearby_solutions.job_posting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    // Custom query to search job postings by job name
    @Query(value = "SELECT * "
            + "FROM jobpostings j "
            + "WHERE j.jobname ILIKE '%' || :jobName || '%' "
            + "OR j.jobname ILIKE '%' || :jobName || '%' "
            + "OR j.jobname ILIKE '%' || :jobName || '%'", nativeQuery = true)
    List<JobPosting> findByJobNameContainingIgnoreCase(String jobName);
}