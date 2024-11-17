package com.ns.nearby_solutions.skill;

import com.ns.nearby_solutions.search.SolutionistDTO;
import com.ns.nearby_solutions.solutionist.Solutionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findBySolutionistId(Long id);

    // Custom query to find solutionists by skill name (case-insensitive search)
    @Query(value = "SELECT u.id AS user_id, "
            + "s.id AS skill_id, "
            + "s.name AS skill_name "
            + "FROM users u "
            + "LEFT JOIN skills s ON u.id = s.user_id "
            + "WHERE s.name ILIKE '%' || :skillName || '%' "
            + "OR s.name ILIKE '%' || :skillName || '%' "
            + "OR s.name ILIKE '%' || :skillName || '%'", nativeQuery = true)
    List<Object[]> findSolutionistsBySkillName(String skillName);


}
