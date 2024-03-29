package egerton.backend.portfolio.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egerton.backend.portfolio.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
