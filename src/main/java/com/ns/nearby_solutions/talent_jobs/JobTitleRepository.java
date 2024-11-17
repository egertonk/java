package com.ns.nearby_solutions.talent_jobs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
    @Query(value = "SELECT u.id AS user_id, "
            + "j.id AS job_title_id, "
            + "j.title "
            + "FROM users u "
            + "LEFT JOIN job_title j ON u.id = j.user_id "
            + "WHERE j.title ILIKE :jobTitle || '%' "
            + "OR j.title ILIKE '%' || :jobTitle || '%' "
            + "OR j.title ILIKE '%' || :jobTitle", nativeQuery = true)
    List<Object[]> findSolutionistsByJobTitle(String jobTitle);
}