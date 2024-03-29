package egerton.backend.portfolio.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import egerton.backend.portfolio.model.budget.*;
import egerton.backend.portfolio.repository.budget.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egerton.backend.portfolio.service.BudgetService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("finance/")
public class FinanceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceController.class);
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private Jan_Budget_1_2_Repository jan_budget_1_2_Repository;
	@Autowired
	private Jan_Budget_3_4_Repository jan_budget_3_4_Repository;
	@Autowired
	private Feb_Budget_1_2_Repository feb_budget_1_2_Repository;
	@Autowired
	private Feb_Budget_3_4_Repository feb_budget_3_4_Repository;
	@Autowired
	private Mar_Budget_1_2_Repository mar_budget_1_2_Repository;
	@Autowired
	private Mar_Budget_3_4_Repository mar_budget_3_4_Repository;
	@Autowired
	private Apr_Budget_1_2_Repository apr_budget_1_2_Repository;
	@Autowired
	private Apr_Budget_3_4_Repository apr_budget_3_4_Repository;
	@Autowired
	private May_Budget_1_2_Repository may_budget_1_2_Repository;
	@Autowired
	private May_Budget_3_4_Repository may_budget_3_4_Repository;
	@Autowired
	private Jun_Budget_1_2_Repository jun_budget_1_2_Repository;
	@Autowired
	private Jun_Budget_3_4_Repository jun_budget_3_4_Repository;
	@Autowired
	private Jul_Budget_1_2_Repository jul_budget_1_2_Repository;
	@Autowired
	private Jul_Budget_3_4_Repository jul_budget_3_4_Repository;
	@Autowired
	private List_Of_Tables_Repository List_Of_Tables_Repository;

	@PostMapping(value = "/add-budget-item", consumes = "application/json", produces = "application/json")
	public void saveBudget(@RequestBody Finance finance) {
		try {
			// Get the method
			Method method = budgetService.getClass().getMethod(finance.getTableName(), Finance.class);
			// Invoke the method
			method.invoke(budgetService, finance);
			LOGGER.info("***** add-budget-item ***** calling... " + finance.getTableName());
		} catch (Exception e) {
			// Get the cause of the exception
			Throwable cause = e.getCause();

			// Print the stack trace of the exception
			cause.printStackTrace();
		}
	}

	@DeleteMapping("/delete-budget-item/{tableNameId}")
	public void deleteBudget(@PathVariable String tableNameId) {
		String deleteId = "id";
		int intIndex = tableNameId.indexOf(deleteId);

		LOGGER.info("***** /delete-budget-item/{id}/{tableName} *****");
		budgetService.deleteBudgetIteamById(Integer.parseInt(tableNameId.substring(intIndex + 3)),
				tableNameId.substring(0, intIndex - 1));
	}

	@PutMapping("/update-budget-item")
	public void updateBudget(@RequestBody Finance finance){
		try {
			// Get the method
			Method method = budgetService.getClass().getMethod(finance.getTableName(), Finance.class);
			// Invoke the method
			method.invoke(budgetService, finance);
			LOGGER.info("***** update-budget-item ***** calling... " + finance.getTableName());
		} catch (Exception e) {
			// Get the cause of the exception
			Throwable cause = e.getCause();

			// Print the stack trace of the exception
			cause.printStackTrace();
		}
	}

	@GetMapping("budget")
	public List<List<? extends Object>> getBudgetDetails() {
		List<list_of_tables> tables = this.List_Of_Tables_Repository.findAll();
		List<List<? extends Object>> selected_tables = new ArrayList();

		for(list_of_tables list_of_tables : tables){
			if(list_of_tables.getTableName().equalsIgnoreCase("jan_budget_1_2")){
				List<Jan_Budget_1_2> jan_budget_1_2 = this.jan_budget_1_2_Repository.findAll();
				selected_tables.add(jan_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("jan_budget_3_4")){
				List<Jan_Budget_3_4> jan_budget_3_4 = this.jan_budget_3_4_Repository.findAll();
				System.out.println(this.jan_budget_1_2_Repository.findAll());
				selected_tables.add(jan_budget_3_4);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("feb_budget_1_2")){
				List<Feb_Budget_1_2> feb_budget_1_2 = this.feb_budget_1_2_Repository.findAll();
				selected_tables.add(feb_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("feb_budget_3_4")){
				List<Feb_Budget_3_4> feb_budget_3_4 = this.feb_budget_3_4_Repository.findAll();
				selected_tables.add(feb_budget_3_4);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("mar_budget_1_2")){
				List<Mar_Budget_1_2> mar_budget_1_2 = this.mar_budget_1_2_Repository.findAll();
				selected_tables.add(mar_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("mar_budget_3_4")){
				List<Mar_Budget_3_4> mar_budget_3_4 = this.mar_budget_3_4_Repository.findAll();
				selected_tables.add(mar_budget_3_4);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("apr_budget_1_2")){
				List<Apr_Budget_1_2> apr_budget_1_2 = this.apr_budget_1_2_Repository.findAll();
				selected_tables.add(apr_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("apr_budget_3_4")){
				List<Apr_Budget_3_4> apr_budget_3_4 = this.apr_budget_3_4_Repository.findAll();
				selected_tables.add(apr_budget_3_4);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("may_budget_1_2")){
				List<May_Budget_1_2> may_budget_1_2 = this.may_budget_1_2_Repository.findAll();
				selected_tables.add(may_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("may_budget_3_4")){
				List<May_Budget_3_4> may_budget_3_4 = this.may_budget_3_4_Repository.findAll();
				selected_tables.add(may_budget_3_4);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("jun_budget_1_2")){
				List<Jun_Budget_1_2> jun_budget_1_2 = this.jun_budget_1_2_Repository.findAll();
				selected_tables.add(jun_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("jun_budget_3_4")){
				List<Jun_Budget_3_4> jun_budget_3_4 = this.jun_budget_3_4_Repository.findAll();
				selected_tables.add(jun_budget_3_4);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("jul_budget_1_2")){
				List<Jul_Budget_1_2> jul_budget_1_2 = this.jul_budget_1_2_Repository.findAll();
				selected_tables.add(jul_budget_1_2);
			}
			if(list_of_tables.getTableName().equalsIgnoreCase("jun_budget_3_4")){
				List<Jul_Budget_3_4> jul_budget_3_4 = this.jul_budget_3_4_Repository.findAll();
				selected_tables.add(jul_budget_3_4);
			}
		}
		LOGGER.info("***** getBudgetDetails ***** tables "+ selected_tables);
		return selected_tables;
	}
}
