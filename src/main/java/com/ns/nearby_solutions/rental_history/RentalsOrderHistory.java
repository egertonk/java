//package com.ns.nearby_solutions.rental_history;
//
//import com.fasterxml.jackson.annotation.JsonSetter;
//import jakarta.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
//@Entity
//@Table(name = "tools_rental_order_history")
//public class RentalsOrderHistory {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
////    @Column(name = "customerid", nullable = false)
////    private Integer customerId;
//
//    @Column(name = "payment_status", nullable = false)
//    private String paymentStatus;
//
//    @Column(name = "transaction_id", nullable = false, unique = true)
//    private String transactionId;
//
//    @Column(name = "amount_paid", nullable = false, precision = 38, scale = 2)
//    private BigDecimal amountPaid;
//
//    @Column(name = "tool_name", nullable = false)
//    private String toolName;
//
//    @Column(name = "tool_brand", nullable = false)
//    private String toolBrand;
//
//    @Column(name = "tool_category", nullable = false)
//    private String toolCategory;
//
//    @Column(name = "tool_price_per_day", nullable = false, precision = 38, scale = 2)
//    private BigDecimal toolPricePerDay;
//
//    @Column(name = "tool_rental_days", nullable = false)
//    private Integer toolRentalDays;
//
//    @Column(name = "pickup_datetime", nullable = false)
//    private LocalDateTime pickupDateTime;
//
//    @Column(name = "pickup_address_name", nullable = false)
//    private String pickupAddressName;
//
//    @Column(name = "pickup_address_street", nullable = false)
//    private String pickupAddressStreet;
//
//    @Column(name = "pickup_address_city", nullable = false)
//    private String pickupAddressCity;
//
//    @Column(name = "pickup_address_state", nullable = false)
//    private String pickupAddressState;
//
//    @Column(name = "pickup_address_country", nullable = false)
//    private String pickupAddressCountry;
//
//    @Column(name = "dropoff_datetime", nullable = false)
//    private LocalDateTime dropoffDateTime;
//
//    @Column(name = "dropoff_address_name", nullable = false)
//    private String dropoffAddressName;
//
//    @Column(name = "dropoff_address_street", nullable = false)
//    private String dropoffAddressStreet;
//
//    @Column(name = "dropoff_address_city", nullable = false)
//    private String dropoffAddressCity;
//
//    @Column(name = "dropoff_address_state", nullable = false)
//    private String dropoffAddressState;
//
//    @Column(name = "dropoff_address_country", nullable = false)
//    private String dropoffAddressCountry;
//
//    @Column(name = "provider_name", nullable = false)
//    private String providerName;
//
//    @Column(name = "provider_email", nullable = false)
//    private String providerEmail;
//
//    @Column(name = "provider_phone", nullable = false)
//    private String providerPhone;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "order_status", nullable = false)
//    private String orderStatus;
//
//    @Column(name = "image")
//    private String image;
//
//    @Column(name = "description", nullable = false)
//    private String description;
//
//    @Column(name = "fromdate", nullable = false)
//    private LocalDate fromDate;
//
//    @Column(name = "fromtime", nullable = false)
//    private LocalTime fromTime;
//
//    @Column(name = "untildate", nullable = false)
//    private LocalDate untilDate;
//
//    @Column(name = "untiltime", nullable = false)
//    private LocalTime untilTime;
//
//    @Column(name = "toolzipcode", nullable = false, length = 10)
//    private String toolZipcode;
//
//    @Column(name = "discountprice", nullable = false, precision = 38, scale = 2)
//    private BigDecimal discountPrice;
//
//    @Column(name = "discountpercent", nullable = false, precision = 5, scale = 2)
//    private BigDecimal discountPercent;
//
//    @Column(name = "tool_id", nullable = false)
//    private Long toolId;
//
//    @Column(name = "owner_fullname", nullable = false)
//    private String ownerFullName;
//
//    @Column(name = "renter_fullname", nullable = false)
//    private String renterFullName;
//
//    @Column(name = "owner_email", nullable = false)
//    private String ownerEmail;
//
//    @Column(name = "renter_email", nullable = false)
//    private String renterEmail;
//
//    @Column(name = "owner_phone_number", nullable = false)
//    private String ownerPhoneNumber;
//
//    @Column(name = "renter_phone_number", nullable = false)
//    private String renterPhoneNumber;
//
//    @Column(name = "renter_address_name", nullable = false)
//    private String renterAddressName;
//
//    @Column(name = "renter_address_street")
//    private String renterAddressStreet;
//
//    @Column(name = "renter_address_city", nullable = false)
//    private String renterAddressCity;
//
//    @Column(name = "renter_zip_code", nullable = false)
//    private String renterZipCode;
//
//    @Column(name = "renter_address_state", nullable = false)
//    private String renterAddressState;
//
//    @Column(name = "renter_address_country", nullable = false)
//    private String renterAddressCountry;
//
//    // Getters and setters
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
////    public Integer getCustomerId() {
////        return customerId;
////    }
////
////    public void setCustomerId(Integer customerId) {
////        this.customerId = customerId;
////    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    public String getTransactionId() {
//        return transactionId;
//    }
//
//    public void setTransactionId(String transactionId) {
//        this.transactionId = transactionId;
//    }
//
//    public BigDecimal getAmountPaid() {
//        return amountPaid;
//    }
//
//    public void setAmountPaid(BigDecimal amountPaid) {
//        this.amountPaid = amountPaid;
//    }
//
//    public String getToolName() {
//        return toolName;
//    }
//
//    public void setToolName(String toolName) {
//        this.toolName = toolName;
//    }
//
//    public String getToolBrand() {
//        return toolBrand;
//    }
//
//    public void setToolBrand(String toolBrand) {
//        this.toolBrand = toolBrand;
//    }
//
//    public String getToolCategory() {
//        return toolCategory;
//    }
//
//    public void setToolCategory(String toolCategory) {
//        this.toolCategory = toolCategory;
//    }
//
//    public BigDecimal getToolPricePerDay() {
//        return toolPricePerDay;
//    }
//
//    public void setToolPricePerDay(BigDecimal toolPricePerDay) {
//        this.toolPricePerDay = toolPricePerDay;
//    }
//
//    public Integer getToolRentalDays() {
//        return toolRentalDays;
//    }
//
//    public void setToolRentalDays(Integer toolRentalDays) {
//        this.toolRentalDays = toolRentalDays;
//    }
//
//    public LocalDateTime getPickupDateTime() {
//        return pickupDateTime;
//    }
//
//    public void setPickupDateTime(LocalDateTime pickupDateTime) {
//        this.pickupDateTime = pickupDateTime;
//    }
//
//    public String getPickupAddressName() {
//        return pickupAddressName;
//    }
//
//    public void setPickupAddressName(String pickupAddressName) {
//        this.pickupAddressName = pickupAddressName;
//    }
//
//    public String getPickupAddressStreet() {
//        return pickupAddressStreet;
//    }
//
//    public void setPickupAddressStreet(String pickupAddressStreet) {
//        this.pickupAddressStreet = pickupAddressStreet;
//    }
//
//    public String getPickupAddressCity() {
//        return pickupAddressCity;
//    }
//
//    public void setPickupAddressCity(String pickupAddressCity) {
//        this.pickupAddressCity = pickupAddressCity;
//    }
//
//    public String getPickupAddressState() {
//        return pickupAddressState;
//    }
//
//    public void setPickupAddressState(String pickupAddressState) {
//        this.pickupAddressState = pickupAddressState;
//    }
//
//    public String getPickupAddressCountry() {
//        return pickupAddressCountry;
//    }
//
//    public void setPickupAddressCountry(String pickupAddressCountry) {
//        this.pickupAddressCountry = pickupAddressCountry;
//    }
//
//    public LocalDateTime getDropoffDateTime() {
//        return dropoffDateTime;
//    }
//
//    public void setDropoffDateTime(LocalDateTime dropoffDateTime) {
//        this.dropoffDateTime = dropoffDateTime;
//    }
//
//    public String getDropoffAddressName() {
//        return dropoffAddressName;
//    }
//
//    public void setDropoffAddressName(String dropoffAddressName) {
//        this.dropoffAddressName = dropoffAddressName;
//    }
//
//    public String getDropoffAddressStreet() {
//        return dropoffAddressStreet;
//    }
//
//    public void setDropoffAddressStreet(String dropoffAddressStreet) {
//        this.dropoffAddressStreet = dropoffAddressStreet;
//    }
//
//    public String getDropoffAddressCity() {
//        return dropoffAddressCity;
//    }
//
//    public void setDropoffAddressCity(String dropoffAddressCity) {
//        this.dropoffAddressCity = dropoffAddressCity;
//    }
//
//    public String getDropoffAddressState() {
//        return dropoffAddressState;
//    }
//
//    public void setDropoffAddressState(String dropoffAddressState) {
//        this.dropoffAddressState = dropoffAddressState;
//    }
//
//    public String getDropoffAddressCountry() {
//        return dropoffAddressCountry;
//    }
//
//    public void setDropoffAddressCountry(String dropoffAddressCountry) {
//        this.dropoffAddressCountry = dropoffAddressCountry;
//    }
//
//    public String getProviderName() {
//        return providerName;
//    }
//
//    public void setProviderName(String providerName) {
//        this.providerName = providerName;
//    }
//
//    public String getProviderEmail() {
//        return providerEmail;
//    }
//
//    public void setProviderEmail(String providerEmail) {
//        this.providerEmail = providerEmail;
//    }
//
//    public String getProviderPhone() {
//        return providerPhone;
//    }
//
//    public void setProviderPhone(String providerPhone) {
//        this.providerPhone = providerPhone;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getOrderStatus() {
//        return orderStatus;
//    }
//
//    public void setOrderStatus(String orderStatus) {
//        this.orderStatus = orderStatus;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDate getFromDate() {
//        return fromDate;
//    }
//
//    public void setFromDate(LocalDate fromDate) {
//        this.fromDate = fromDate;
//    }
//
//    public LocalTime getFromTime() {
//        return fromTime;
//    }
//
//    public void setFromTime(LocalTime fromTime) {
//        this.fromTime = fromTime;
//    }
//
//    public LocalDate getUntilDate() {
//        return untilDate;
//    }
//
//    public void setUntilDate(LocalDate untilDate) {
//        this.untilDate = untilDate;
//    }
//
//    public LocalTime getUntilTime() {
//        return untilTime;
//    }
//
//    public void setUntilTime(LocalTime untilTime) {
//        this.untilTime = untilTime;
//    }
//
//    public String getToolZipcode() {
//        return toolZipcode;
//    }
//
//    public void setToolZipcode(String toolZipcode) {
//        this.toolZipcode = toolZipcode;
//    }
//
//    public BigDecimal getDiscountPrice() {
//        return discountPrice;
//    }
//
//    public void setDiscountPrice(BigDecimal discountPrice) {
//        this.discountPrice = discountPrice;
//    }
//
//    public BigDecimal getDiscountPercent() {
//        return discountPercent;
//    }
//
//    public void setDiscountPercent(BigDecimal discountPercent) {
//        this.discountPercent = discountPercent;
//    }
//
//    public Long getToolId() {
//        return toolId;
//    }
//
//    public void setToolId(Long toolId) {
//        this.toolId = toolId;
//    }
//
//    public String getOwnerFullName() {
//        return ownerFullName;
//    }
//
//    public void setOwnerFullName(String ownerFullName) {
//        this.ownerFullName = ownerFullName;
//    }
//
//    public String getRenterFullName() {
//        return renterFullName;
//    }
//
//    public void setRenterFullName(String renterFullName) {
//        this.renterFullName = renterFullName;
//    }
//
//    public String getOwnerEmail() {
//        return ownerEmail;
//    }
//
//    public void setOwnerEmail(String ownerEmail) {
//        this.ownerEmail = ownerEmail;
//    }
//
//    public String getRenterEmail() {
//        return renterEmail;
//    }
//
//    public void setRenterEmail(String renterEmail) {
//        this.renterEmail = renterEmail;
//    }
//
//    public String getOwnerPhoneNumber() {
//        return ownerPhoneNumber;
//    }
//
//    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
//        this.ownerPhoneNumber = ownerPhoneNumber;
//    }
//
//    public String getRenterPhoneNumber() {
//        return renterPhoneNumber;
//    }
//
//    public void setRenterPhoneNumber(String renterPhoneNumber) {
//        this.renterPhoneNumber = renterPhoneNumber;
//    }
//
//    public String getRenterAddressName() {
//        return renterAddressName;
//    }
//
//    public void setRenterAddressName(String renterAddressName) {
//        this.renterAddressName = renterAddressName;
//    }
//
//    public String getRenterAddressStreet() {
//        return renterAddressStreet;
//    }
//
//    public void setRenterAddressStreet(String renterAddressStreet) {
//        this.renterAddressStreet = renterAddressStreet;
//    }
//
//    public String getRenterAddressCity() {
//        return renterAddressCity;
//    }
//
//    public void setRenterAddressCity(String renterAddressCity) {
//        this.renterAddressCity = renterAddressCity;
//    }
//
//    public String getRenterZipCode() {
//        return renterZipCode;
//    }
//
//    public void setRenterZipCode(String renterZipCode) {
//        this.renterZipCode = renterZipCode;
//    }
//
//    public String getRenterAddressState() {
//        return renterAddressState;
//    }
//
//    public void setRenterAddressState(String renterAddressState) {
//        this.renterAddressState = renterAddressState;
//    }
//
//    public String getRenterAddressCountry() {
//        return renterAddressCountry;
//    }
//
//    public void setRenterAddressCountry(String renterAddressCountry) {
//        this.renterAddressCountry = renterAddressCountry;
//    }
//}
