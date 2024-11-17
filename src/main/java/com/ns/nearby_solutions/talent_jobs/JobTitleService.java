package com.ns.nearby_solutions.talent_jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    public List<JobTitle> getAllJobTitles() {
        return jobTitleRepository.findAll();
    }

    public JobTitle saveJobTitle(JobTitle jobTitle) {
        return jobTitleRepository.save(jobTitle);
    }
}