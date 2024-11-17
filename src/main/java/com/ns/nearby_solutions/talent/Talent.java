package com.ns.nearby_solutions.talent;

import com.ns.nearby_solutions.address.Address;
import com.ns.nearby_solutions.orders.Order;
import com.ns.nearby_solutions.social_media.SocialMedia;
import com.ns.nearby_solutions.skill.Skill;
import com.ns.nearby_solutions.solutionist_work_Settings.SolutionistWorkSettings;
import com.ns.nearby_solutions.talent_jobs.JobTitle;
import com.ns.nearby_solutions.solutionist.Solutionist;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "talent")
public class Talent {

    @Id
    @Column(name = "talentid")
    private Long talentId;

    @Column(name = "image_source", length = 255)
    private String imageSource;

    @Column(name = "talent_introduction", length = 255)
    private String talentIntroduction;

    @Column(name = "vacation_status")
    private Boolean vacationStatus;

    @Column(name = "verify_status")
    private Boolean verifyStatus;

    @ManyToOne
    @JoinColumn(name = "vacation_days_off_id", referencedColumnName = "id", unique = true, foreignKey = @ForeignKey(name = "uka16gmutl1io2tt13cdfsq3qtn"))
    private VacationDaysOff vacationDaysOff;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_talent_user"))
    private Solutionist solutionist;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private List<Address> addresses;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private List<SocialMedia> socialMedia;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private List<JobTitle> jobTitle;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private List<SolutionistWorkSettings> solutionistWorkSettings;
    @OneToMany
    @JoinColumn(name = "customerid", referencedColumnName = "user_id", insertable = false, updatable = false)
    private List<Order> solutionistOrders;

    // Getters and Setters

    public Long getTalentId() {
        return talentId;
    }

    public void setTalentId(Long talentId) {
        this.talentId = talentId;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getTalentIntroduction() {
        return talentIntroduction;
    }

    public void setTalentIntroduction(String talentIntroduction) {
        this.talentIntroduction = talentIntroduction;
    }

    public Boolean getVacationStatus() {
        return vacationStatus;
    }

    public void setVacationStatus(Boolean vacationStatus) {
        this.vacationStatus = vacationStatus;
    }

    public Boolean getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Boolean verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public VacationDaysOff getVacationDaysOff() {
        return vacationDaysOff;
    }

    public void setVacationDaysOff(VacationDaysOff vacationDaysOff) {
        this.vacationDaysOff = vacationDaysOff;
    }

    public Solutionist getSolutionist() {
        return solutionist;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<SocialMedia> getSocialMedia() {
        return socialMedia;
    }

    public List<JobTitle> getJobTitle() {
        return jobTitle;
    }

    public List<SolutionistWorkSettings> getSolutionistWorkSettings() {
        return solutionistWorkSettings;
    }

    public List<Order> getSolutionistOrders() {
        return solutionistOrders;
    }

    // Exclude the setter for user to prevent modification
}
