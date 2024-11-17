package com.ns.nearby_solutions.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return countryFeatureService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Optional<CountryFeature> getCountryFeatureById(@PathVariable Long id) {
        return countryFeatureService.getCountryById(id);
    }

    @PostMapping
    public CountryFeature addCountryFeature(@RequestBody CountryFeature countryFeature) {
        return countryFeatureService.addCountryFeature(countryFeature);
    }

    @PutMapping("/{id}")
    public CountryFeature updateCountryFeature(@PathVariable Long id, @RequestBody CountryFeature countryFeature) {
        return countryFeatureService.updateCountryFeature(id, countryFeature);
    }

    @DeleteMapping("/{id}")
    public void deleteCountryFeature(@PathVariable Long id) {
        countryFeatureService.deleteCountryFeature(id);
    }
}
