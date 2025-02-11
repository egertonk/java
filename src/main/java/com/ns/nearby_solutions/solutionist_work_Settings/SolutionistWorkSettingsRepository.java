package com.ns.nearby_solutions.solutionist_work_Settings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionistWorkSettingsRepository extends JpaRepository<SolutionistWorkSettings, Long> {
    Object findByUserId(Long userId);
}
