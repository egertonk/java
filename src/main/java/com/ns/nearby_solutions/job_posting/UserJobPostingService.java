package com.ns.nearby_solutions.job_posting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.Optional;

@Slf4j
@Service
public class UserJobPostingService {

    private final UserJobPostingRepository userJobPostingRepository;

    public UserJobPostingService(UserJobPostingRepository userJobPostingRepository) {
        this.userJobPostingRepository = userJobPostingRepository;
    }

    public Page<UserJobPosting> getAllJobPostings(Pageable pageable) {
        log.info("Fetching job postings with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return userJobPostingRepository.findAll(pageable);
    }

    public Page<UserJobPosting> getValidJobPostings(Pageable pageable) {
        log.info("Fetching job postings with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return userJobPostingRepository.findValidJobPostings(pageable);
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
