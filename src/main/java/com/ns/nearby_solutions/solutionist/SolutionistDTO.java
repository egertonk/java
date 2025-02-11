package com.ns.nearby_solutions.solutionist;

import com.ns.nearby_solutions.skill.Skill;
import com.ns.nearby_solutions.social_media.SocialMedia;
import com.ns.nearby_solutions.talent.Talent;
import com.ns.nearby_solutions.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SolutionistDTO {
    private User solutionistInformation;
    private List<Talent> solutionistTalents;
    private List<Skill> solutionistSkills;
    private List<SocialMedia> solutionistSocialMedias;
}
