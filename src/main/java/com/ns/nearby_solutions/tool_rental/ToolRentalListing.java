package com.ns.nearby_solutions.tool_rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tool_rental_listings")
public class ToolRentalListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_id", nullable = false)
    private Long toolId;

    @Column(name = "tool_name", nullable = false, length = 100)
    private String toolName;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "tool_category", length = 50)
    private String toolCategory;

    @Column(name = "tool_brand", length = 50)
    private String toolBrand;

    @Column(name = "tool_address", length = 150)
    private String toolAddress;

    @Column(name = "tool_city", length = 50)
    private String toolCity;

    @Column(name = "tool_state", length = 50)
    private String toolState;

    @Column(name = "tool_country", length = 50)
    private String toolCountry;

    @Column(name = "tool_zipcode", length = 10)
    private String toolZipcode;

    @Column(name = "price_per_day", nullable = false)
    private Double pricePerDay;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    @Column(name = "next_available_date", length = 20)
    private String nextAvailableDate;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "number_of_reviews")
    private Integer numberOfReviews;

    @Column(name = "power_source", length = 50)
    private String powerSource;

    @Column(name = "renter_id")
    private Long renterId;

    @Column(name = "is_shipping_valid")
    private Boolean isShippingValid;

    @Column(name = "shipping_cost")
    private Double shippingCost;

    @Column(name = "estimated_delivery", length = 50)
    private String estimatedDelivery;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "return_date", length = 20)
    private String returnDate;

    @Column(name = "usage_instructions", length = 1000)
    private String usageInstructions;

    @Column(name = "safety_information", length = 1000)
    private String safetyInformation;

    @Column(name = "image_url")
    private String imageUrl; // Storing as JSON (can use `@Convert` for JSON parsing)

    @Column(name = "poster_id", nullable = false)
    private Long posterId;
}