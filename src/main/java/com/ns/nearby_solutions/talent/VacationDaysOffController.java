package com.ns.nearby_solutions.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacation-days-off")
public class VacationDaysOffController {

    @Autowired
    private VacationDaysOffService vacationDaysOffService;

    @GetMapping
    public List<VacationDaysOff> getAllVacations() {
        return vacationDaysOffService.getAllVacations();
    }

    @PostMapping
    public VacationDaysOff saveVacation(@RequestBody VacationDaysOff vacation) {
        return vacationDaysOffService.saveVacation(vacation);
    }
}