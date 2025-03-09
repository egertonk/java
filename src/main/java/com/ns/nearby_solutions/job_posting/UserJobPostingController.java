package com.ns.nearby_solutions.job_posting;
import com.ns.nearby_solutions.job_posting.history.JobPostingsOrderHistory;
import com.ns.nearby_solutions.tool_rental.history.ToolOrderHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/job-postings")
public class UserJobPostingController {

    private final UserJobPostingService userJobPostingService;

    public UserJobPostingController(UserJobPostingService userJobPostingService) {
        this.userJobPostingService = userJobPostingService;
    }

    // ✅ Get all job postings with pagination
    @GetMapping
    public ResponseEntity<Page<UserJobPosting>> getAllJobPostings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching job postings - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userJobPostingService.getAllJobPostings(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserJobPosting> getAllJobPostingsByPosterId(@PathVariable Long id) {
        log.info("Received request for order ID={}", id);
        return userJobPostingService.getJobPostingById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    log.warn("Order not found with id={}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    // ✅ Get valid job postings with pagination
    @GetMapping("/valid-listed-jobs")
    public ResponseEntity<Page<UserJobPosting>> getValidJobPostings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching valid job postings from database - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userJobPostingService.getValidListedJobPostings(pageable));
    }

    @GetMapping("/history/{solutionistId}/{jobStatus}")
    public ResponseEntity<Page<UserJobPosting>> getValidJobPostingsHistory(
            @PathVariable Long solutionistId,
            @PathVariable(required = false) String jobStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching valid job postings history - Page: {}, Size: {}, solutionistId: {}, jobStatus: '{}'",
                page, size, solutionistId, jobStatus);

        Pageable pageable = PageRequest.of(page, size);

        if (jobStatus.equalsIgnoreCase("All")) {
            return ResponseEntity.ok(userJobPostingService.getValidListedJobPostingsHistory(solutionistId, pageable));
        }
        else {
            String status = jobStatus;
            if (jobStatus.equalsIgnoreCase("UnderReview")) status = "Under Review";
            else if (jobStatus.equalsIgnoreCase("SolutionistAssigned") ) status = "Solutionist Assigned";
            return ResponseEntity.ok(userJobPostingService.getValidListedJobPostingsHistoryWithFilter(status, solutionistId, pageable));
        }
    }


    // ✅ Search job postings with filters and pagination
    @GetMapping("/search")
    public ResponseEntity<Page<UserJobPosting>> searchJobPostings(
            @RequestParam(required = false) String jobCountry,
            @RequestParam(required = false) LocalDateTime createdAt,
            @RequestParam(required = false) String jobStatus,
            @RequestParam(required = false) String experienceLevel,
            @RequestParam(required = false) String urgencyLevel,
            @RequestParam(required = false) String jobCityLocation,
            @RequestParam(required = false) String jobZip,
            @RequestParam(required = false) String jobDescription,
            @RequestParam(required = false) String jobTask,
            @RequestParam(required = false) String jobName,
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Searching job postings - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userJobPostingService.searchJobPostings(
                jobCountry, createdAt, jobStatus, experienceLevel, urgencyLevel,
                jobCityLocation, jobZip, jobDescription, jobTask, jobName, id, pageable
        ));
    }
}
