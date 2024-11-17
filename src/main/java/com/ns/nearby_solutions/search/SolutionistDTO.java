package com.ns.nearby_solutions.search;

public class SolutionistDTO {
    private Long userId;
    private Long skillId;

    // Constructor
    public SolutionistDTO(Long userId, Long skillId) {
        this.userId = userId;
        this.skillId = skillId;
    }

    // Getters and setters for all fields
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }
}
