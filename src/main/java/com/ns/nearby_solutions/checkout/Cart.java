package com.ns.nearby_solutions.checkout;

import com.ns.nearby_solutions.rental.Tool;
import com.ns.nearby_solutions.skill.Skill;
import com.ns.nearby_solutions.solutionist.Solutionist;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Solutionist customer;

    @OneToMany
    private List<Tool> tools;

    @OneToMany
    private List<Skill> services;


    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(Tool[] tools) {
        this.tools = List.of(tools);
    }

    public List<Skill> getServices() {
        return services;
    }

    public void setServices(Skill[] services) {
        this.services = List.of(services);
    }
}