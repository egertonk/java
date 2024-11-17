package com.ns.nearby_solutions.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryFeatureRepository extends JpaRepository<CountryFeature, Long> {
}
