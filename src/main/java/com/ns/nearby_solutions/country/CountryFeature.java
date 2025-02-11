package com.ns.nearby_solutions.country;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class CountryFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_id_seq")
    @SequenceGenerator(name = "countries_id_seq", sequenceName = "countries_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "iso_code")
    private String isoCode;

    @Column(name = "iso_alpha2_code")
    private String isoAlpha2Code;

    @Column(name = "continent")
    private String continent;

    @Column(name = "region")
    private String region;

    @Column(name = "capital")
    private String capital;

    @Column(name = "currency")
    private String currency;

    @Column(name = "currency_symbol")
    private String currencySymbol;

    @Column(name = "phone_code")
    private String phoneCode;

    @Column(name = "official_language")
    private String officialLanguage;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "internet_tld")
    private String internetTld;

    @Column(name = "flag_url")
    private String flagUrl;

    @Column(name = "driving_side")
    private String drivingSide;

    @Column(name = "independence_date")
    private LocalDate independenceDate;

    @Column(name = "feature_flag", nullable = false)
    private Boolean featureFlag = false;

    @Column(name = "start_on", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate startOn;

    @Column(name = "turn_off")
    private LocalDate turnOff;
}
