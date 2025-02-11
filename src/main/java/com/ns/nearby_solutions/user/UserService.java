package com.ns.nearby_solutions.user;

import com.ns.nearby_solutions.talent.Talent;
import com.ns.nearby_solutions.talent.TalentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TalentRepository talentRepository;

    @Autowired
    public UserService(UserRepository userRepository, TalentRepository talentRepository) {
        this.userRepository = userRepository;
        this.talentRepository = talentRepository;
    }

    // ✅ Get paginated users
    public Page<User> getAllUsers(Pageable pageable) {
        log.info("Fetching users with pagination - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return userRepository.findAll(pageable);
    }

    // ✅ Save new user
    public User saveUser(User user) {
        log.info("Saving new user: {}", user.getName());
        return userRepository.save(user);
    }

    // ✅ Get user by ID with exception handling
    public User getUserById(Long id) {
        log.info("Fetching user with id: {}", id);
        return userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // ✅ Get talents for a specific user
    public List<Talent> getUserTalents(Long id) {
        log.info("Fetching talents for user ID: {}", id);
        return talentRepository.findByUserId(id);
    }

    // ✅ Fetch all users with their talents (Optimized)
    public Map<User, List<Talent>> getAllUsersWithTalents() {
        log.info("Fetching all users with their talents");
        List<User> users = userRepository.findAll();

        // ✅ Optimized: Batch fetch all talents instead of querying per user
        List<Talent> allTalents = talentRepository.findAll();
        Map<Long, List<Talent>> talentsMap = allTalents.stream()
                .collect(Collectors.groupingBy(talent -> talent.getUser().getId()));

        return users.stream()
                .collect(Collectors.toMap(user -> user, user -> talentsMap.getOrDefault(user.getId(), List.of())));
    }
}
