package com.ns.nearby_solutions.skill;

import com.ns.nearby_solutions.UserWithSolution;
import com.ns.nearby_solutions.exception.ResourceNotFoundException;
import com.ns.nearby_solutions.search.SolutionistDTO;
import com.ns.nearby_solutions.solutionist.SolutionistService;
import com.ns.nearby_solutions.talent.TalentRepository;
import com.ns.nearby_solutions.talent.TalentService;
//import com.ns.nearby_solutions.talent_jobs.JobTitle;
import com.ns.nearby_solutions.talent_jobs.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TalentService talentService;

    @Autowired
    private SolutionistService solutionistService;

    @Autowired
    private TalentRepository talentRepository;

    @Autowired
    private JobTitleRepository jobTitleRepository;

    // Create a new skill
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // Get all skills
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get skill by ID
    public Skill getSkillById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with id: " + id));
    }

    // Update skill
    public Skill updateSkill(Long id, Skill updatedSkill) {
        Skill skill = getSkillById(id);
        skill.setName(updatedSkill.getName());
        skill.setDescription(updatedSkill.getDescription());
        skill.setProficiencyLevel(updatedSkill.getProficiencyLevel());
        return skillRepository.save(skill);
    }

    // Delete skill
    public void deleteSkill(Long id) {
        Skill skill = getSkillById(id);
        skillRepository.delete(skill);
    }

    public List<Skill> getAllUserSkillsById(Long id) {
        return (List<Skill>) skillRepository.findById(id).orElse(null);
    }

    // Method to find solutionists by skill name (case-insensitive)
    public List<SolutionistDTO> findSolutionistBySkillName(String name) {
        List<Object[]> result = skillRepository.findSolutionistsBySkillName(name);

        // Convert result into SolutionistDTO list
        return result.stream().map(row -> {
            Long userId = ((Number) row[0]).longValue();
            Long skillId = ((Number) row[1]).longValue();

            // Return a SolutionistDTO
            return new SolutionistDTO(userId, skillId);
        }).collect(Collectors.toList());
    }

    // Method to find solutionists by skill name and then fetch data IDs
    public List<Optional<UserWithSolution>> findSolutionistByJobTitle(String jobTitle) {
        String searchTermWithWildcards = "%" + jobTitle + "%";

        // Step 1: Extract solutionists by job title
        List<Object[]> result = jobTitleRepository.findSolutionistsByJobTitle(searchTermWithWildcards);

        // Step 2: Extract User IDs from the JobTitles result
        List<Long> userIds = result.stream()
                .map(item -> (Long) item[0])  // Extract user ID (first element of Object[])
                .collect(Collectors.toList());

        // Step 3: Fetch the solutionists associated with these user IDs
        List<Optional<UserWithSolution>> solutionistsUser = new ArrayList<>();

        userIds.forEach(accountId -> {
            Optional<UserWithSolution> solutionistsData = solutionistService.getUserWithAddressesById(accountId);
            solutionistsUser.add(solutionistsData); // Add the fetched Optional UserWithSolution to the list
        });

        return solutionistsUser;
    }
}
