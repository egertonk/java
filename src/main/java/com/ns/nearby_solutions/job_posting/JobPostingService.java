package com.ns.nearby_solutions.job_posting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;

    @Autowired
    public JobPostingService(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    // Search job postings by job name
    public List<JobPosting> searchJobPostingsByJobName(String jobName) {
        return jobPostingRepository.findByJobNameContainingIgnoreCase(jobName);
    }

    // Additional CRUD methods (if needed)
    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id).orElse(null);
    }

    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }

    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        jobPostingDetails.setId(id);
        return jobPostingRepository.save(jobPostingDetails);
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }
}
