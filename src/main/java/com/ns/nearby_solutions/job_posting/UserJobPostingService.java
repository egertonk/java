package com.ns.nearby_solutions.job_posting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserJobPostingService {

    private final UserJobPostingRepository userJobPostingRepository;

    public UserJobPostingService(UserJobPostingRepository userJobPostingRepository) {
        this.userJobPostingRepository = userJobPostingRepository;
    }

    // ✅ Fetch all job postings with pagination
    public Page<UserJobPosting> getAllJobPostings(Pageable pageable) {
        log.info("Fetching job postings with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return userJobPostingRepository.findAll(pageable);
    }

    // ✅ Fetch valid job postings with pagination
    public Page<UserJobPosting> getValidListedJobPostings(Pageable pageable) {
        log.info("Fetching valid listed jobs - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return userJobPostingRepository.findValidJobPostings(pageable);
    }

    // ✅ Fetch job postings with filters and pagination
    public Page<UserJobPosting> searchJobPostings(
            String jobCountry, LocalDateTime createdAt, String jobStatus,
            String experienceLevel, String urgencyLevel, String jobCityLocation,
            String jobZip, String jobDescription, String jobTask, String jobName, Long id, Pageable pageable) {
        log.info("Searching job postings - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return userJobPostingRepository.searchJobPostings(
                jobCountry, createdAt, jobStatus, experienceLevel, urgencyLevel, jobCityLocation,
                jobZip, jobDescription, jobTask, jobName, id, pageable
        );
    }

    public Optional<UserJobPosting> getJobPostingById(Long id) {
        return userJobPostingRepository.findById(id);
    }

    public UserJobPosting createJobPosting(UserJobPosting jobPosting) {
        return userJobPostingRepository.save(jobPosting);
    }

    public Optional<UserJobPosting> updateJobPosting(Long id, UserJobPosting jobPosting) {
        return userJobPostingRepository.findById(id)
                .map(existing -> {
                    jobPosting.setId(id);
                    return userJobPostingRepository.save(jobPosting);
                });
    }

    public boolean deleteJobPosting(Long id) {
        if (userJobPostingRepository.existsById(id)) {
            userJobPostingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
