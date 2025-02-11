//package com.ns.nearby_solutions.orders;
//
//import com.ns.nearby_solutions.user.User;
//import com.ns.nearby_solutions.solutionist.Solutionist;
//import com.ns.nearby_solutions.talent.Talent;
//import jakarta.persistence.*;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer orderId;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false) // Updated column reference
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "contractor_id", referencedColumnName = "id", nullable = false) // Updated column reference
//    private Solutionist contractor;
//
//    @ManyToOne
//    @JoinColumn(name = "talent_id", referencedColumnName = "id") // Updated column reference (if Talent has an 'id' column)
//    private Talent talent;
//
//    @Column(name = "order_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime orderDate = LocalDateTime.now();
//
//    @Column(name = "order_status", length = 20)
//    private String orderStatus;
//
//    @Column(name = "start_time", length = 10)
//    private String startTime;
//
//    @Column(name = "start_date")
//    private LocalDate startDate;
//
//    @Column(name = "end_date")
//    private LocalDate endDate;
//
//    @Column(name = "service_description", columnDefinition = "TEXT")
//    private String serviceDescription;
//
//    @Column(name = "work_location", length = 100)
//    private String workLocation;
//
//    @Column(name = "total_amount", precision = 10, scale = 2)
//    private BigDecimal totalAmount;
//
//    @Column(name = "payment_status", length = 20)
//    private String paymentStatus;
//
//    @Column(name = "payment_method", length = 20)
//    private String paymentMethod;
//
//    @Column(name = "currency", length = 10, nullable = false)
//    private String currency = "USD";
//
//    @Column(name = "invoice_id", length = 50)
//    private String invoiceId;
//
//    @Column(name = "priority", length = 10)
//    private String priority;
//
//    @Column(name = "notes", columnDefinition = "TEXT")
//    private String notes;
//
//    @Column(name = "created_by", length = 50)
//    private String createdBy;
//
//    @Column(name = "last_modified_by", length = 50)
//    private String lastModifiedBy;
//
//    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime updatedAt = LocalDateTime.now();
//
//    // Getters and Setters
//
//    public Integer getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        this.orderId = orderId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Solutionist getContractor() {
//        return contractor;
//    }
//
//    public void setContractor(Solutionist contractor) {
//        this.contractor = contractor;
//    }
//
//    public Talent getTalent() {
//        return talent;
//    }
//
//    public void setTalent(Talent talent) {
//        this.talent = talent;
//    }
//
//    public LocalDateTime getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(LocalDateTime orderDate) {
//        this.orderDate = orderDate;
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
//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//    }
//
//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getServiceDescription() {
//        return serviceDescription;
//    }
//
//    public void setServiceDescription(String serviceDescription) {
//        this.serviceDescription = serviceDescription;
//    }
//
//    public String getWorkLocation() {
//        return workLocation;
//    }
//
//    public void setWorkLocation(String workLocation) {
//        this.workLocation = workLocation;
//    }
//
//    public BigDecimal getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(BigDecimal totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public String getInvoiceId() {
//        return invoiceId;
//    }
//
//    public void setInvoiceId(String invoiceId) {
//        this.invoiceId = invoiceId;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    public void setLastModifiedBy(String lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
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
//}
