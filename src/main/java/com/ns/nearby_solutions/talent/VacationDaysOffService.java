package com.ns.nearby_solutions.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationDaysOffService {

    @Autowired
    private VacationDaysOffRepository vacationDaysOffRepository;

    public List<VacationDaysOff> getAllVacations() {
        return vacationDaysOffRepository.findAll();
    }

    public VacationDaysOff saveVacation(VacationDaysOff vacation) {
        return vacationDaysOffRepository.save(vacation);
    }
}