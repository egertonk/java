package com.ns.nearby_solutions.job_posting.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingsOrderHistoryRepository extends JpaRepository<JobPostingsOrderHistory, Long> {
    Page<JobPostingsOrderHistory> findByJobId(Long jobId, Pageable pageable);

    Page<JobPostingsOrderHistory> findBySolutionistId(Integer solutionistId, Pageable pageable);

    Page<JobPostingsOrderHistory> findAllByPosterId(Long posterId, Pageable pageable);
}
