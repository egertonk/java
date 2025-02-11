package com.ns.nearby_solutions.talent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
    // Query by the Solutionist entity's ID through the solutionist field
    Talent findByUser_Id(Long userId);
    List<Talent> findByUserId(Long userId);
    List<Talent> findTalentsByUserId(Long userId);
}