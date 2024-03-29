package egerton.backend.portfolio.repository.budget;

import egerton.backend.portfolio.model.budget.list_of_tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface List_Of_Tables_Repository extends JpaRepository<list_of_tables, Long>{

    static void saveTable(String tableName) {
    }
}
