package com.ns.nearby_solutions.skill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ns.nearby_solutions.solutionist.Solutionist;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(name = "proficiency_level", length = 255)
    private String proficiencyLevel;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "skills_user_id_fkey"))
    @JsonIgnore // This will exclude the solutionist field from JSON responses
    private Solutionist solutionist;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Solutionist getSolutionist() {
        return solutionist;
    }

    public void setSolutionist(Solutionist solutionist) {
        this.solutionist = solutionist;
    }
}
