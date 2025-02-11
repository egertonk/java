package com.ns.nearby_solutions.job_posting;

import com.ns.nearby_solutions.enums.JobOrderStatus;
import com.ns.nearby_solutions.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/job-postings")
public class UserJobPostingController {

    private final UserJobPostingService userJobPostingService;

    public UserJobPostingController(UserJobPostingService userJobPostingService) {
        this.userJobPostingService = userJobPostingService;
    }

    // Get all job postings
    @GetMapping
    public ResponseEntity<Page<UserJobPosting>> getAllJobPostings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching valid job postings - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);

        // Fetch all job postings and filter the required ones
        Page<UserJobPosting> jobPostings = userJobPostingService.getAllJobPostings(pageable);

//        // Apply filtering
//        List<UserJobPosting> filteredJobs = jobPostings.stream()
//                .filter(job -> Boolean.TRUE.equals(job.getPaymentStatus()))  // paymentStatus must be true
//                .filter(job -> Boolean.TRUE.equals(job.getJobAcceptedByPoster()))  // jobAcceptedByPoster must be true
//                .filter(job -> "Listed".equalsIgnoreCase(job.getJobStatus()))  // jobStatus must NOT be "Under Review"
//                .collect(Collectors.toList());
//
//        // Convert List to Page for response
//        Page<UserJobPosting> filteredJobPostings = new PageImpl<>(filteredJobs, pageable, filteredJobs.size());

        return ResponseEntity.ok(jobPostings);
    }

    @GetMapping("/valid-listed-jobs")
    public ResponseEntity<Page<UserJobPosting>> getValidJobPostings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching valid listed job postings from database - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);

        // Fetch jobs directly from the database with filtering
        Page<UserJobPosting> jobPostings = userJobPostingService.getValidJobPostings(pageable);

        return ResponseEntity.ok(jobPostings);
    }

    // Get job posting by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserJobPosting> getJobPostingById(@PathVariable Long id) {
        Optional<UserJobPosting> jobPosting = userJobPostingService.getJobPostingById(id);
       return jobPosting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new job posting
    @PostMapping
    public ResponseEntity<UserJobPosting> createJobPosting(@RequestBody UserJobPosting jobPosting) {
        UserJobPosting createdJobPosting = userJobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.ok(createdJobPosting);
    }

    // Update an existing job posting
    @PutMapping("/{id}")
    public ResponseEntity<UserJobPosting> updateJobPosting(@PathVariable Long id, @RequestBody UserJobPosting jobPosting) {
        Optional<UserJobPosting> updatedJobPosting = userJobPostingService.updateJobPosting(id, jobPosting);
        return updatedJobPosting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a job posting
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        boolean deleted = userJobPostingService.deleteJobPosting(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
