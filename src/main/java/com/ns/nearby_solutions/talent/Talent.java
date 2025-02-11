package com.ns.nearby_solutions.talent;

//import com.ns.nearby_solutions.address.Address;
//import com.ns.nearby_solutions.skill.Skill;
//import com.ns.nearby_solutions.social_media.SocialMedia;
//import com.ns.nearby_solutions.solutionist_work_Settings.SolutionistWorkSettings;
//import com.ns.nearby_solutions.talent_jobs.JobTitle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ns.nearby_solutions.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "talent")
public class Talent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(
            name = "vacation_days_off_id",
            referencedColumnName = "id",
            unique = true,
            foreignKey = @ForeignKey(name = "fk_talent_vacation_days_off")
    )
    private VacationDaysOff vacationDaysOff;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_talent_user")
    )
    private User user;

//    @OneToMany
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
//    private List<Skill> skills;
//
//    @OneToMany
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
//    private List<Address> addresses;
//
//    @OneToMany
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
//    private List<SocialMedia> socialMedia;
//
//    @OneToMany
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
//    private List<JobTitle> jobTitles;
//
//    @OneToMany
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
//    private List<SolutionistWorkSettings> solutionistWorkSettings;
//
//    @OneToMany
//    @JoinColumn(name = "customerid", referencedColumnName = "user_id", insertable = false, updatable = false)
//    private List<Order> solutionistOrders;

}
