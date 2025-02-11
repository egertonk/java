package com.ns.nearby_solutions.country;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/country-features")
public class CountryFeatureController {

    private final CountryFeatureService countryFeatureService;

    @Autowired
    public CountryFeatureController(CountryFeatureService countryFeatureService) {
        this.countryFeatureService = countryFeatureService;
    }

    @GetMapping
    public List<CountryFeature> getAllCountryFeatures() {
        log.info("Fetching all country features: {}");
        return countryFeatureService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Optional<CountryFeature> getCountryFeatureById(@PathVariable Long id) {
        log.info("Fetching country feature by id: {}", id);
        return countryFeatureService.getCountryById(id);
    }

    @PostMapping
    public CountryFeature addCountryFeature(@RequestBody CountryFeature countryFeature) {
        log.info("Adding country feature: {}", countryFeature);
        return countryFeatureService.addCountryFeature(countryFeature);
    }

    @PutMapping("/{id}")
    public CountryFeature updateCountryFeature(@PathVariable Long id, @RequestBody CountryFeature countryFeature) {
        log.info("Updating country feature with id: {} and details: {}", id, countryFeature);
        return countryFeatureService.updateCountryFeature(id, countryFeature);
    }

    @DeleteMapping("/{id}")
    public void deleteCountryFeature(@PathVariable Long id) {
        log.info("Deleting country feature with id: {}", id);
        countryFeatureService.deleteCountryFeature(id);
    }
}
