package com.ns.nearby_solutions.tool_rental;

import com.ns.nearby_solutions.customer.Customer;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tool_rental_listing")
public class ToolRentalListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_id")
    private Long toolId;

    @Column(name = "poster_id")
    private Long posterId;

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

//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "customerid", nullable = true, foreignKey = @ForeignKey(name = "fk_customer"))
//    private Customer customer;

    @Column(name = "image_urls")
    private List<String> imageUrls;

    @Column(name = "is_shipping_valid", nullable = false)
    private Boolean isShippingValid;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "return_date", length = 20)
    private String returnDate;

    @Column(name = "usage_instructions", length = 1000)
    private String usageInstructions;

    @Column(name = "safety_information", length = 1000)
    private String safetyInformation;

    // Getters and setters


    public Long getPosterId() {
        return posterId;
    }

    public void setPosterId(Long posterId) {
        this.posterId = posterId;
    }

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToolCategory() {
        return toolCategory;
    }

    public void setToolCategory(String toolCategory) {
        this.toolCategory = toolCategory;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public String getToolAddress() {
        return toolAddress;
    }

    public void setToolAddress(String toolAddress) {
        this.toolAddress = toolAddress;
    }

    public String getToolCity() {
        return toolCity;
    }

    public void setToolCity(String toolCity) {
        this.toolCity = toolCity;
    }

    public String getToolState() {
        return toolState;
    }

    public void setToolState(String toolState) {
        this.toolState = toolState;
    }

    public String getToolCountry() {
        return toolCountry;
    }

    public void setToolCountry(String toolCountry) {
        this.toolCountry = toolCountry;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getNextAvailableDate() {
        return nextAvailableDate;
    }

    public void setNextAvailableDate(String nextAvailableDate) {
        this.nextAvailableDate = nextAvailableDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }


    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Boolean getShippingValid() {
        return isShippingValid;
    }

    public void setShippingValid(Boolean shippingValid) {
        isShippingValid = shippingValid;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    public String getSafetyInformation() {
        return safetyInformation;
    }

    public void setSafetyInformation(String safetyInformation) {
        this.safetyInformation = safetyInformation;
    }
}
