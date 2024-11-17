package com.ns.nearby_solutions.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryFeatureService {

    private final CountryFeatureRepository countryFeatureRepository;

    @Autowired
    public CountryFeatureService(CountryFeatureRepository countryFeatureRepository) {
        this.countryFeatureRepository = countryFeatureRepository;
    }

    public List<CountryFeature> getAllCountries() {
        return countryFeatureRepository.findAll();
    }

    public Optional<CountryFeature> getCountryById(Long id) {
        return countryFeatureRepository.findById(id);
    }

    public CountryFeature addCountryFeature(CountryFeature countryFeature) {
        return countryFeatureRepository.save(countryFeature);
    }

    public CountryFeature updateCountryFeature(Long id, CountryFeature updatedCountryFeature) {
        return countryFeatureRepository.findById(id)
                .map(countryFeature -> {
                    countryFeature.setCountryName(updatedCountryFeature.getCountryName());
                    countryFeature.setFeatureFlag(updatedCountryFeature.getFeatureFlag());
                    countryFeature.setStartOn(updatedCountryFeature.getStartOn());
                    countryFeature.setTurnOff(updatedCountryFeature.getTurnOff());
                    return countryFeatureRepository.save(countryFeature);
                })
                .orElseThrow(() -> new RuntimeException("CountryFeature not found with id " + id));
    }

    public void deleteCountryFeature(Long id) {
        countryFeatureRepository.deleteById(id);
    }
}
