package com.ns.nearby_solutions.solutionist;

import com.ns.nearby_solutions.AllUsersWithSolution;
import com.ns.nearby_solutions.UserWithSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class SolutionistController {

    @Autowired
    private SolutionistService solutionistService;

    @GetMapping
    public ResponseEntity<?> getAllUsersWithAddresses() {
        // Retrieve the user with addresses
        List<AllUsersWithSolution> allUsersWithSolution = solutionistService.getAllUsersWithAddresses();

        // Check if no records are found
        if (allUsersWithSolution.isEmpty()) {
            // Return "No Record Found" if the list is empty
            return ResponseEntity.ok("No Record Found");
        }

        // Return the found users with addresses
        return ResponseEntity.ok(allUsersWithSolution);
    }


    @GetMapping("/{accountId}")
    public ResponseEntity<?> getUserByIdWithAddresses(@PathVariable Long accountId) {
        System.out.println(accountId);

        // Retrieve the user with addresses
        Optional<UserWithSolution> userWithAddress = solutionistService.getUserWithAddressesById(accountId);

        // Check if the user exists
        if (!userWithAddress.isPresent()) {
            // Return false if no record is found
            return ResponseEntity.ok("No Record Found");
        }

        // Return the found user with addresses
        return ResponseEntity.ok(userWithAddress.get());
    }


    @PostMapping
    public Solutionist createUser(@RequestBody Solutionist solutionist) {
        return solutionistService.createUser(solutionist);
    }

    @DeleteMapping("/{accountId}")
    public void deleteUser(@PathVariable Long id) {
        solutionistService.deleteUser(id);
    }
}
