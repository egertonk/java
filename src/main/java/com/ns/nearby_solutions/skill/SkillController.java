package com.ns.nearby_solutions.skill;

import com.ns.nearby_solutions.UserWithSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    // Route to add a new skill
//    @PostMapping
//    public Skill addSkill(@RequestBody Skill skill) {
//        return skillService.saveSkill(skill);
//    }

    // Route to get all skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    // Get skills by user ID
    @GetMapping("/{id}")
    public List<Skill> getAllSkills(@PathVariable Long id) {
        return skillService.getAllUserSkillsById(id);
    }

    @GetMapping("/search")
    public List<Optional<UserWithSolution>> findSolutionistsBySkillName(@RequestParam("name") String skillName) {
        System.out.println("Fetching talents for skill name: " + skillName);
        List<Optional<UserWithSolution>> talents = skillService.findSolutionistByJobTitle(skillName);
        return talents;
    }
}