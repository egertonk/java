package com.ns.nearby_solutions.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talent")
public class TalentController {

    @Autowired
    private TalentService talentService;

    @GetMapping
    public List<Talent> getAllTalents() {
        return talentService.getAllTalents();
    }

    // Retrieve Talent by ID along with Job Titles, Social Media, and Vacation Days Off details
    @GetMapping("/{id}")
    public Talent getTalentByIdWithDetails(@PathVariable Long id) {
        return talentService.getTalentById(id);
    }

//    @GetMapping("/{id}")
//    public Talent getTalentById(@PathVariable Long id) {
//        return talentService.getTalentById(id);
//    }

    @PostMapping
    public Talent saveTalent(@RequestBody Talent talent) {
        return talentService.saveTalent(talent);
    }

    @DeleteMapping("/{id}")
    public void deleteTalent(@PathVariable Long id) {
        talentService.deleteTalent(id);
    }
}
