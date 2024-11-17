package com.ns.nearby_solutions;

import com.ns.nearby_solutions.talent.Talent;

public class AllUsersWithSolution {
    private Talent talent; // Changed from List<Talent> to a single Talent object

    public AllUsersWithSolution(Talent talent) {
        this.talent = talent;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }
}
