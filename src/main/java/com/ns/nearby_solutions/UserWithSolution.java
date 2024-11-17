package com.ns.nearby_solutions;

import com.ns.nearby_solutions.talent.Talent;

public class UserWithSolution {
    private Talent talent;

    public UserWithSolution(Talent talent) {
        this.talent = talent;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }
}
