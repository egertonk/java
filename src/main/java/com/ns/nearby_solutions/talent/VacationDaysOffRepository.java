package com.ns.nearby_solutions.talent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationDaysOffRepository extends JpaRepository<VacationDaysOff, Long> {
}
