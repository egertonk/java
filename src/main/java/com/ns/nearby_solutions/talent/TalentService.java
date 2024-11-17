package com.ns.nearby_solutions.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService {

    @Autowired
    private TalentRepository talentRepository;

    public List<Talent> getAllTalents() {
        return talentRepository.findAll();
    }

    public Talent getTalentById(Long id) {
        return talentRepository.findById(id).orElse(null);
    }

    public Talent saveTalent(Talent talent) {
        return talentRepository.save(talent);
    }

    public void deleteTalent(Long id) {
        talentRepository.deleteById(id);
    }
}