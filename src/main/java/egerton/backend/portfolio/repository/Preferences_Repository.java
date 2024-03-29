package egerton.backend.portfolio.repository;

import egerton.backend.portfolio.model.user.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Preferences_Repository extends JpaRepository<Preferences, Long>{

}
