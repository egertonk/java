package com.ns.nearby_solutions.solutionist_work_Settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solutionist-work-settings")
public class SolutionistWorkSettingsController {
    @Autowired
    private SolutionistWorkSettingsRepository solutionistWorkSettingsRepository;
    @Autowired
    private SolutionistWorkSettingsService solutionistWorkSettingsService;

    // Route to add a new skill
    @PostMapping
    public SolutionistWorkSettings addSolutionistWorkSettings(@RequestBody SolutionistWorkSettings solutionistWorkSettings) {
        return solutionistWorkSettingsRepository.save(solutionistWorkSettings);
    }

    // Route to update an existing skill
    @PutMapping("/{id}")
    public SolutionistWorkSettings updateSolutionistWorkSettings(@PathVariable Long id, @RequestBody SolutionistWorkSettings solutionistWorkSettings) {
        solutionistWorkSettings.setId(id); // Sets the ID for updating
        return solutionistWorkSettingsRepository.save(solutionistWorkSettings);
    }

    // Route to get all skills
    @GetMapping
    public List<SolutionistWorkSettings> getAllSolutionistWorkSettings() {
        return solutionistWorkSettingsRepository.findAll();
    }

}