package com.ns.nearby_solutions.talent_jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-title")
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping
    public List<JobTitle> getAllJobTitles() {
        return jobTitleService.getAllJobTitles();
    }

    @PostMapping
    public JobTitle saveJobTitle(@RequestBody JobTitle jobTitle) {
        return jobTitleService.saveJobTitle(jobTitle);
    }
}