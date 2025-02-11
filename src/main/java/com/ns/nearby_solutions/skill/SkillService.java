package com.ns.nearby_solutions.skill;

//import com.ns.nearby_solutions.UserWithSolution;
//import com.ns.nearby_solutions.exception.ResourceNotFoundException;
//import com.ns.nearby_solutions.search.SolutionistDTO;
//import com.ns.nearby_solutions.solutionist.SolutionistService;
//import com.ns.nearby_solutions.talent.TalentRepository;
//import com.ns.nearby_solutions.talent.TalentService;
//import com.ns.nearby_solutions.talent_jobs.JobTitle;
//import com.ns.nearby_solutions.talent_jobs.JobTitleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getSkillsByUserId(Long userId) {
        return skillRepository.findByUserId(userId);
    }

//    @Autowired
//    private TalentService talentService;

//    @Autowired
//    private SolutionistService solutionistService;

//    @Autowired
//    private TalentRepository talentRepository;

//    @Autowired
//    private JobTitleRepository jobTitleRepository;


    // Get all skills
    public List<Skill> getAllSkills() {
        log.info("Fetching all skills: {}");
        return skillRepository.findAll();
    }

    // Get skill by ID
//    public Skill getSkillById(Long id) {
//        return skillRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
//    }

    // Update skill
//    public Skill updateSkill(Long id, Skill updatedSkill) {
//        Skill skill = getSkillById(id);
//        skill.setName(updatedSkill.getName());
//        skill.setDescription(updatedSkill.getDescription());
//        skill.setProficiencyLevel(updatedSkill.getProficiencyLevel());
//        return skillRepository.save(skill);
//    }

    // Delete skill
//    public void deleteSkill(Long id) {
//        Skill skill = getSkillById(id);
//        skillRepository.delete(skill);
//    }

    // Get all user skills by user ID
    public List<Skill> getAllUserSkillsById(Long id) {
        log.info("Get user skill by id: {}", id);
        Optional<Skill> skillOptional = skillRepository.findById(id);
        if (skillOptional.isPresent()) {
            List<Skill> skills = new ArrayList<>();
            skills.add(skillOptional.get());
            return skills;
        }
        return new ArrayList<>();
    }

    public Skill saveSkill(Skill skill) {
        log.info("Saving user skills: {}");
        return skillRepository.save(skill);
    }

    public List<Skill> getSkillsById(long id) {
        log.info("Fetching skills by id: {}", id);
        return skillRepository.findById(id).stream().collect(Collectors.toList());
    }

    // Find solutionists by skill name
//    public List<SolutionistDTO> findSolutionistBySkillName(String name) {
//        List<Object[]> result = skillRepository.findSolutionistsBySkillName(name);
//
//        return result.stream().map(row -> {
//            if (row[0] instanceof Number && row[1] instanceof Number) {
//                Long userId = ((Number) row[0]).longValue();
//                Long skillId = ((Number) row[1]).longValue();
//                return new SolutionistDTO(userId, skillId);
//            }
//            throw new IllegalArgumentException("Unexpected data format in result set.");
//        }).collect(Collectors.toList());
//    }

    // Find solutionists by job title
//    public List<UserWithSolution> findSolutionistByJobTitle(String jobTitle) {
//        String searchTermWithWildcards = "%" + jobTitle + "%";
//
//        List<Object[]> result = jobTitleRepository.findSolutionistsByJobTitle(searchTermWithWildcards);
//        List<Long> userIds = result.stream()
//                .map(item -> (Long) item[0])
//                .collect(Collectors.toList());
//
//        return userIds.stream()
//                .map(solutionistService::getUserWithAddressesById)
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .collect(Collectors.toList());
//    }
}
