package egerton.backend.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import egerton.backend.portfolio.model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long>{

	@Override
    List<Projects> findAll();

}
