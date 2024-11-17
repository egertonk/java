package com.ns.nearby_solutions.talent_jobs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.ns.nearby_solutions.solutionist.Solutionist;

@Entity
@Table(name = "job_title")
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer discount;

    @Column(name = "fix_price")
    private Double fixPrice;

    @Column(name = "is_fix_price")
    private Boolean isFixPrice;

    @Column(name = "rate_per_hour")
    private Double ratePerHour;

    @Column(name = "selected_status")
    private Boolean selectedStatus;

    @Column(length = 255)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "job_title_user_id_fkey"))
    @JsonIgnore // This will exclude the user field from JSON responses
    private Solutionist solutionist;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Double getFixPrice() {
        return fixPrice;
    }

    public void setFixPrice(Double fixPrice) {
        this.fixPrice = fixPrice;
    }

    public Boolean getIsFixPrice() {
        return isFixPrice;
    }

    public void setIsFixPrice(Boolean isFixPrice) {
        this.isFixPrice = isFixPrice;
    }

    public Double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(Double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public Boolean getSelectedStatus() {
        return selectedStatus;
    }

    public void setSelectedStatus(Boolean selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Solutionist getUser() {
        return solutionist;
    }

}
