// package egerton.backend.portfolio.controller;

// import java.util.List;

// import egerton.backend.portfolio.model.budget.list_of_tables;
// import egerton.backend.portfolio.repository.budget.List_Of_Tables_Repository;
// import egerton.backend.portfolio.service.List_Of_Tables_Service;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;


// @CrossOrigin(origins = "http://localhost:3000/")
// @RestController
// @RequestMapping("manager/")
// public class ManagerController {

//     private static final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);

//     @Autowired
//     private List_Of_Tables_Repository list_Of_Tables_Repository;
//     @Autowired
//     private List_Of_Tables_Service list_Of_Tables_Service;

//     @GetMapping("active-list")
//     public List<list_of_tables> getTableList() {
//         LOGGER.info("***** getTableList *****");
//         return this.list_Of_Tables_Repository.findAll();
//     }

//     @PostMapping(value = "/add-table", consumes = "application/json", produces = "application/json")
//     public void addMoreTable(@RequestBody list_of_tables list_of_tables) {
//         LOGGER.info("***** add-table *****");
//         list_Of_Tables_Service.saveTable(list_of_tables.getTableName());
//     }

//     @DeleteMapping("/delete-table/{tableNameId}")
//     public void deleteTable(@PathVariable String tableNameId) {
//         LOGGER.info("***** /delete-table/{tableNameId} *****");
//         list_Of_Tables_Service.deleteTableById(Integer.parseInt(tableNameId));
//     }
// }
