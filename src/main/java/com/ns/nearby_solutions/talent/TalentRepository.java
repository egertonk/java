package com.ns.nearby_solutions.talent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
    // Query by the Solutionist entity's ID through the solutionist field
    Talent findBySolutionist_Id(Long userId);
    Talent findBySolutionistId(Long id);
}