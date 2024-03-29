package egerton.backend.portfolio.service;

import egerton.backend.portfolio.model.budget.list_of_tables;
import egerton.backend.portfolio.repository.budget.List_Of_Tables_Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class List_Of_Tables_Service {
	private static final Logger LOGGER = LoggerFactory.getLogger(List_Of_Tables_Service.class);

	@Autowired
	private final List_Of_Tables_Repository list_Of_Tables_Repository;


	@Autowired
	public List_Of_Tables_Service(List_Of_Tables_Repository list_Of_Tables_Repository) {
		this.list_Of_Tables_Repository = list_Of_Tables_Repository;
	}
	
	@Transactional
	public void saveTable(String table) {
		LOGGER.info("***** List_Of_Tables_Service ***** " + table);
		list_of_tables tableData = new list_of_tables(0, table);
		list_Of_Tables_Repository.save(tableData);
	}

	@Transactional
	public void deleteTableById(long id) {
		list_Of_Tables_Repository.deleteById(id);
	}
}
