package com.ns.nearby_solutions.country;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "country_features")
public class CountryFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name", nullable = false, length = 100)
    private String countryName;

    @Column(name = "feature_flag", nullable = false)
    private Boolean featureFlag = false;

    @Column(name = "start_on", nullable = false)
    private LocalDate startOn = LocalDate.now();

    @Column(name = "turn_off")
    private LocalDate turnOff;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Boolean getFeatureFlag() {
        return featureFlag;
    }

    public void setFeatureFlag(Boolean featureFlag) {
        this.featureFlag = featureFlag;
    }

    public LocalDate getStartOn() {
        return startOn;
    }

    public void setStartOn(LocalDate startOn) {
        this.startOn = startOn;
    }

    public LocalDate getTurnOff() {
        return turnOff;
    }

    public void setTurnOff(LocalDate turnOff) {
        this.turnOff = turnOff;
    }
}
