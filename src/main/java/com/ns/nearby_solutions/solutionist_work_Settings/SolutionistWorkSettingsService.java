package com.ns.nearby_solutions.solutionist_work_Settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class SolutionistWorkSettingsService {

    @Autowired
    private SolutionistWorkSettingsRepository solutionistWorkSettingsRepository;

    public List<SolutionistWorkSettings> getAllSolutionistWorkSettingsRepository() {
        return solutionistWorkSettingsRepository.findAll();
    }

    public SolutionistWorkSettings saveSolutionistWorkSettings(SolutionistWorkSettings solutionistWorkSettings) {
        return solutionistWorkSettingsRepository.save(solutionistWorkSettings);
    }

    public Object getSolutionistWorkSettings(Long userId) {
        return solutionistWorkSettingsRepository.findByUserId(userId);
    }

//    public SolutionistWorkSettings getAllSolutionistWorkSettingsById(Long id) {
//        return solutionistWorkSettingsRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Solutionist Work Settings not found with id: " + id));
//    }

}