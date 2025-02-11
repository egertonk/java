package com.ns.nearby_solutions.solutionist;

import com.ns.nearby_solutions.skill.Skill;
import com.ns.nearby_solutions.skill.SkillService;
import com.ns.nearby_solutions.social_media.SocialMedia;
import com.ns.nearby_solutions.social_media.SocialMediaService;
import com.ns.nearby_solutions.solutionist_work_Settings.SolutionistWorkSettings;
import com.ns.nearby_solutions.solutionist_work_Settings.SolutionistWorkSettingsService;
import com.ns.nearby_solutions.user.User;
import com.ns.nearby_solutions.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/solutionist")
public class SolutionistController {

    private final UserService userService;
    private final SkillService skillService;
    private final SocialMediaService socialMediaService;
    private final SolutionistWorkSettingsService solutionistWorkSettingsService;

    public SolutionistController(UserService userService, SkillService skillService, SocialMediaService socialMediaService, SolutionistWorkSettingsService solutionistWorkSettingsService) {
        this.userService = userService;
        this.skillService = skillService;
        this.socialMediaService = socialMediaService;
        this.solutionistWorkSettingsService = solutionistWorkSettingsService;
    }

    @GetMapping("/{solutionistId}/{skillId}")
    public SolutionistDetailsDTO getSolutionistDetails(
            @PathVariable("solutionistId") Long solutionistId,
            @PathVariable("skillId") Long skillId) {
        long id = skillId;

        log.info("Fetching solutionist details for solutionistId: {} and skillId: {}", solutionistId, skillId);
        User solutionist = userService.getUserById(solutionistId);
        List<Skill> solutionistSkill = skillService.getSkillsById(id);
        Object solutionistSocialMedia = socialMediaService.getSocialMediaByUserId(solutionist.getId());
        Object solutionistWorkSettings = solutionistWorkSettingsService.getSolutionistWorkSettings(solutionist.getId());

        SolutionistDetailsDTO dto = new SolutionistDetailsDTO();
        dto.setSolutionistInformation(solutionist);
        dto.setSolutionistSkills(solutionistSkill);
        dto.setSolutionistSocialMedias((List<SocialMedia>) solutionistSocialMedia);
        dto.setSolutionistWorkSettings((SolutionistWorkSettings) solutionistWorkSettings);

        return dto;
    }
}
