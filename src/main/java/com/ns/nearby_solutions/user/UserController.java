package com.ns.nearby_solutions.user;

import com.ns.nearby_solutions.address.Address;
import com.ns.nearby_solutions.address.AddressService;
import com.ns.nearby_solutions.customer.CustomerDetailsDTO;
import com.ns.nearby_solutions.skill.Skill;
import com.ns.nearby_solutions.skill.SkillService;
import com.ns.nearby_solutions.social_media.SocialMedia;
import com.ns.nearby_solutions.social_media.SocialMediaService;
import com.ns.nearby_solutions.solutionist.SolutionistDTO;
import com.ns.nearby_solutions.talent.Talent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final SkillService skillService;
    private final SocialMediaService socialMediaService;
    private final AddressService addressService;

    @Autowired
    public UserController(UserService userService, SkillService skillService, SocialMediaService socialMediaService, AddressService addressService) {
        this.userService = userService;
        this.skillService = skillService;
        this.socialMediaService = socialMediaService;
        this.addressService = addressService;
    }

    // ✅ GET Users with Pagination
    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching users - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Creating new user: {}", user.getName());
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // ✅ Fetch Single User by ID with Address and Social Media
    @GetMapping("/{userId}")
    public ResponseEntity<CustomerDetailsDTO> getUserById(@PathVariable("userId") Long userId) {
        log.info("Fetching user by ID: {}", userId);

        User customer = userService.getUserById(userId);
        List<Address> customerAddress = addressService.getAddressByUserId(customer.getId());
        List<SocialMedia> customerSocialMedia = (List<SocialMedia>) socialMediaService.getSocialMediaByUserId(customer.getId());

        CustomerDetailsDTO dto = new CustomerDetailsDTO();
        dto.setCustomerInformation(customer);
        dto.setCustomerSocialMedias(customerSocialMedia);
        dto.setCustomerAddress(customerAddress);

        return ResponseEntity.ok(dto);
    }

    // ✅ GET All Users with Talents & Skills (with Pagination)
    @GetMapping("/with-skills")
    public ResponseEntity<Page<SolutionistDTO>> getAllUsersWithTalents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        log.info("Fetching users with skills - Page: {}, Size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userService.getAllUsers(pageable);

        // ✅ Filter out users with no talents before mapping
        List<SolutionistDTO> filteredUsers = users.getContent().stream()
                .filter(user -> {
                    List<Skill> userSkills = skillService.getSkillsByUserId(user.getId());
                    return userSkills != null && !userSkills.isEmpty(); // Keep only users with talents
                })
                .map(user -> new SolutionistDTO(
                        user,
                        userService.getUserTalents(user.getId()),
                        skillService.getSkillsByUserId(user.getId()),
                        (List<SocialMedia>) socialMediaService.getSocialMediaByUserId(user.getId())
                ))
                .collect(Collectors.toList());

        // Convert List to Page using Pageable settings
        Page<SolutionistDTO> resultPage = new PageImpl<>(filteredUsers, pageable, filteredUsers.size());

        return ResponseEntity.ok(resultPage);
    }

    // ✅ GET User Talents by User ID
    @GetMapping("/{userId}/talents")
    public ResponseEntity<List<Talent>> getUserTalents(@PathVariable Long userId) {
        log.info("Fetching talents for user with id: {}", userId);
        List<Talent> talents = userService.getUserTalents(userId);
        return ResponseEntity.ok(talents);
    }
}
