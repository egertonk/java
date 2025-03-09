package com.ns.nearby_solutions.tool_rental.history;

import com.ns.nearby_solutions.enums.OrderStatus;
import com.ns.nearby_solutions.enums.PaymentStatus;
import com.ns.nearby_solutions.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Entity
@Table(name = "tool_order_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToolOrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tool_order_history_id") // Matches the DB schema
    private Long id;

    @Column(name = "renter_id", nullable = false)
    private Integer renterId;

    @Column(name = "poster_id", nullable = false)
    private Long posterId;

    @Column(name = "tool_id", nullable = false)
    private Long toolId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "rent_start_date", nullable = false)
    private LocalDateTime rentStartDate;

    @Column(name = "rent_end_date", nullable = false)
    private LocalDateTime rentEndDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "price_per_day", nullable = false)
    private Double pricePerDay;

    @Column(name = "discount_price", nullable = false)
    private Double discountPrice ;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "tax", nullable = false)
    private Double tax;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_status", nullable = false)
    private ShippingStatus shippingStatus;

    @Column(name = "shipping_cost")
    private Double shippingCost = 0.0;

    @Column(name = "discount_percent")
    private Integer discountPercent = 0;

    @Column(name = "final_price")
    private Double finalPrice;

//    @Column(name = "estimated_delivery")
//    private String estimatedDelivery;

    @Column(name = "is_shipping_valid")
    private Boolean isShippingValid;

    @Column(name = "tool_zipcode")
    private String toolZipcode;

    // Tool Details
    @Column(name = "tool_name", nullable = false)
    private String toolName;

    @Column(name = "rental_days", nullable = false)
    private Integer rentalDays;

    @Column(name = "tool_category")
    private String toolCategory;

    @Column(name = "tool_brand")
    private String toolBrand;

    @Column(name = "tool_address")
    private String toolAddress;

    @Column(name = "tool_city")
    private String toolCity;

    @Column(name = "tool_state")
    private String toolState;

    @Column(name = "tool_country")
    private String toolCountry;

    @Column(name = "description")
    private String description;

    @Column(name = "power_source")
    private String powerSource;

    // Storing image URLs as an array
//    @ElementCollection
//    @CollectionTable(name = "tool_order_images", joinColumns = @JoinColumn(name = "tool_order_history_id"))

    @Column(name = "image_urls", columnDefinition = "Array[]")
    private String imageUrls;

    @PrePersist
    @PreUpdate
    private void logChanges() {
        log.info("Tool Order History Updated: {}", this);
    }
}
