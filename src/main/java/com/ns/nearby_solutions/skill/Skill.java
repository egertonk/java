package com.ns.nearby_solutions.skill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skills_id_seq")
    @SequenceGenerator(name = "skills_id_seq", sequenceName = "skills_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "proficiency_level", length = 255)
    private String proficiencyLevel;

    @JsonIgnore // This will exclude the solutionist field from JSON responses
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "fix_price", nullable = false)
    private Double fixPrice;
}
