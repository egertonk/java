package com.ns.nearby_solutions.solutionist;

import com.ns.nearby_solutions.AllUsersWithSolution;
import com.ns.nearby_solutions.UserWithSolution;
import com.ns.nearby_solutions.address.AddressRepository;
import com.ns.nearby_solutions.social_media.SocialMediaRepository;
import com.ns.nearby_solutions.skill.SkillRepository;
import com.ns.nearby_solutions.talent.Talent;
import com.ns.nearby_solutions.talent.TalentRepository;
import com.ns.nearby_solutions.talent_jobs.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolutionistService {

    private SolutionistRepository solutionistRepository;
    private AddressRepository addressRepository;
    private SkillRepository skillRepository;
    private TalentRepository talentRepository;
    private SocialMediaRepository socialMediaRepository;
    private JobTitleRepository jobTitleRepository;

    @Autowired
    public SolutionistService(SolutionistRepository solutionistRepository, AddressRepository addressRepository, SkillRepository skillRepository, TalentRepository talentRepository, SocialMediaRepository socialMediaRepository, JobTitleRepository jobTitleRepository) {
        this.solutionistRepository = solutionistRepository;
        this.addressRepository = addressRepository;
        this.skillRepository = skillRepository;
        this.talentRepository = talentRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.jobTitleRepository = jobTitleRepository;
    }

    // Get all users with their addresses
//    public List<AllUsersWithSolution> getAllUsersWithAddresses() {
//        return userRepository.findAll().stream()
//                .map(user -> new AllUsersWithSolution(talentRepository.findAll()))
//                .collect(Collectors.toList());
//    }

    // Get all users with their addresses
    public List<AllUsersWithSolution> getAllUsersWithAddresses() {
        return solutionistRepository.findAll().stream()
                .map(user -> {
                    Talent talent = talentRepository.findBySolutionistId(user.getId());
                    return new AllUsersWithSolution(talent);
                })
                .collect(Collectors.toList());
    }

    // Find user by ID with addresses
    public Optional<UserWithSolution> getUserWithAddressesById(Long id) {
        System.out.println("1111111111            = " + id);

        return solutionistRepository.findById(id)
                .map(user -> new UserWithSolution(talentRepository.findBySolutionistId(id)));
//        return userRepository.findById(id)
//                .map(user -> new UserWithSolution(user, addressRepository.findByUserId(id), skillRepository.findByUserId(id), talentRepository.findByUserId(id)));

    }

//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    // Create a new user
    public Solutionist createUser(Solutionist solutionist) {
        return solutionistRepository.save(solutionist);
    }

    // Get all users
    public List<Solutionist> getAllUsers() {
        return solutionistRepository.findAll();
    }

    // Find user by ID
    public Optional<Solutionist> getUserById(Long id) {
        return solutionistRepository.findById(id);
    }

    // Find user by username
    public Optional<Solutionist> getUserByUsername(String username) {
        return solutionistRepository.findByUsername(username);
    }

    // Update an existing user
    @Transactional
    public Solutionist updateUser(Long id, Solutionist solutionistDetails) {
        return solutionistRepository.findById(id)
                .map(user -> {
                    user.setName(solutionistDetails.getName());
                    user.setEmail(solutionistDetails.getEmail());
                    user.setPassword(solutionistDetails.getPassword());
                    user.setRole(solutionistDetails.getRole());
                    user.setUsername(solutionistDetails.getUsername());
                    user.setPasswordHash(solutionistDetails.getPasswordHash());
                    user.setFullName(solutionistDetails.getFullName());
                    user.setPhoneNumber(solutionistDetails.getPhoneNumber());
                    user.setProfilePicture(solutionistDetails.getProfilePicture());
                    user.setDateOfBirth(solutionistDetails.getDateOfBirth());
                    user.setLocation(solutionistDetails.getLocation());
                    user.setCommunicationPreferences(solutionistDetails.getCommunicationPreferences());
                    user.setTermsAccepted(solutionistDetails.getTermsAccepted());
                    user.setPrivacyPolicyAccepted(solutionistDetails.getPrivacyPolicyAccepted());
                    user.setFirstName(solutionistDetails.getFirstName());
                    user.setMiddleName(solutionistDetails.getMiddleName());
                    user.setLastName(solutionistDetails.getLastName());
                    user.setUpdatedAt(solutionistDetails.getUpdatedAt());
                    return solutionistRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public SolutionistService saveUser(SolutionistService solutionistService) {
        return null;
    }

    public void deleteUser(Long id) {
    }
}

