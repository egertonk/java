package com.ns.nearby_solutions.job_posting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {
    private final JobPostingService jobPostingService;

    @GetMapping
    public List<JobPosting> getAllJobPostings() {
        System.out.println("Job posting = "+jobPostingService.getAllJobPostings());
        return jobPostingService.getAllJobPostings();
    }

    @Autowired
    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    // Endpoint to search job postings by job name
    @GetMapping("/search")
    public List<JobPosting> searchJobPostings(@RequestParam("name") String jobName) {
        return jobPostingService.searchJobPostingsByJobName(jobName);
    }

    // Endpoint to create a new job posting
    @PostMapping
    public JobPosting createJobPosting(@RequestBody JobPosting jobPosting) {
        return jobPostingService.createJobPosting(jobPosting);
    }

    // Endpoint to get a job posting by id
    @GetMapping("/{id}")
    public JobPosting getJobPosting(@PathVariable Long id) {
        return jobPostingService.getJobPostingById(id);
    }

    // Endpoint to update a job posting
    @PutMapping("/{id}")
    public JobPosting updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        return jobPostingService.updateJobPosting(id, jobPostingDetails);
    }

    // Endpoint to delete a job posting
    @DeleteMapping("/{id}")
    public void deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
    }
}
