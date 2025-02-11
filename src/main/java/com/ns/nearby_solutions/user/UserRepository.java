package com.ns.nearby_solutions.user;

import com.ns.nearby_solutions.talent.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndIsDeletedFalse(Long id);

    // ✅ Pagination support for fetching users
    Page<User> findAll(Pageable pageable);

    // ✅ Fetch user talents
    @Query("SELECT t FROM Talent t WHERE t.user.id = :userId")
    List<Talent> findUserTalents(Long userId);
}