package egerton.backend.portfolio.config;

import egerton.backend.portfolio.model.budget.Finance;
import egerton.backend.portfolio.repository.budget.*;
import egerton.backend.portfolio.service.BudgetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class DynamicClassCaller {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicClassCaller.class);
    @Autowired
    private ClassResolver classResolver = new ClassResolver();

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
    private Aug_Budget_1_2_Repository aug_budget_1_2_Repository;
    @Autowired
    private Aug_Budget_3_4_Repository aug_budget_3_4_Repository;

    @Autowired
    private Sep_Budget_1_2_Repository sep_budget_1_2_Repository;
    @Autowired
    private Sep_Budget_3_4_Repository sep_budget_3_4_Repository;

    @Autowired
    private Oct_Budget_1_2_Repository oct_budget_1_2_Repository;
    @Autowired
    private Oct_Budget_3_4_Repository oct_budget_3_4_Repository;

    @Autowired
    private Nov_Budget_1_2_Repository nov_budget_1_2_Repository;
    @Autowired
    private Nov_Budget_3_4_Repository nov_budget_3_4_Repository;

    @Autowired
    private Dec_Budget_1_2_Repository dec_budget_1_2_Repository;
    @Autowired
    private Dec_Budget_3_4_Repository dec_budget_3_4_Repository;
    @Autowired
    private BudgetService finance;
    public Object callMethod(String className, String methodName, Finance financeData) throws Exception {
        LOGGER.info("***** update-budget-item *****-----------4---------- methodName " + methodName);
        Class<?> clazz = classResolver.resolveClass(className);
        Method method = clazz.getMethod(methodName, String.class);

        // Create a new object
        finance = new BudgetService(jan_budget_1_2_Repository, jan_budget_3_4_Repository, feb_budget_1_2_Repository, feb_budget_3_4_Repository,
                mar_budget_1_2_Repository, mar_budget_3_4_Repository,
                apr_budget_1_2_Repository, apr_budget_3_4_Repository,
                may_budget_1_2_Repository, may_budget_3_4_Repository,
                jun_budget_1_2_Repository, jun_budget_3_4_Repository,
                jul_budget_1_2_Repository, jul_budget_3_4_Repository,
                aug_budget_1_2_Repository, aug_budget_3_4_Repository,
                sep_budget_1_2_Repository, sep_budget_3_4_Repository,
                oct_budget_1_2_Repository, oct_budget_3_4_Repository,
                nov_budget_1_2_Repository, nov_budget_3_4_Repository,
                dec_budget_1_2_Repository, dec_budget_3_4_Repository);

        LOGGER.info("***** update-budget-item *****-----------4---------- feb_budget_1_2_Repository " + feb_budget_1_2_Repository);
        return method.invoke(finance, "financeData");
    }
}