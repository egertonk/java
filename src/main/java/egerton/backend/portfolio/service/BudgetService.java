// package egerton.backend.portfolio.service;

// import egerton.backend.portfolio.model.budget.*;
// import egerton.backend.portfolio.repository.budget.*;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// @ComponentScan
// @Service
// public class BudgetService {
//     private static final Logger LOGGER = LoggerFactory.getLogger(BudgetService.class);

//     @Autowired
//     private final Jan_Budget_1_2_Repository jan_budget_1_2_Repository;
//     @Autowired
//     private final Jan_Budget_3_4_Repository jan_budget_3_4_Repository;

//     @Autowired
//     private final Feb_Budget_1_2_Repository feb_budget_1_2_Repository;
//     @Autowired
//     private final Feb_Budget_3_4_Repository feb_budget_3_4_Repository;

//     @Autowired
//     private final Mar_Budget_1_2_Repository mar_budget_1_2_Repository;
//     @Autowired
//     private final Mar_Budget_3_4_Repository mar_budget_3_4_Repository;

//     @Autowired
//     private final Apr_Budget_1_2_Repository apr_budget_1_2_Repository;
//     @Autowired
//     private final Apr_Budget_3_4_Repository apr_budget_3_4_Repository;

//     @Autowired
//     private final May_Budget_1_2_Repository may_budget_1_2_Repository;
//     @Autowired
//     private final May_Budget_3_4_Repository may_budget_3_4_Repository;

//     @Autowired
//     private final Jun_Budget_1_2_Repository jun_budget_1_2_Repository;
//     @Autowired
//     private final Jun_Budget_3_4_Repository jun_budget_3_4_Repository;

//     @Autowired
//     private final Jul_Budget_1_2_Repository jul_budget_1_2_Repository;
//     @Autowired
//     private final Jul_Budget_3_4_Repository jul_budget_3_4_Repository;

//     @Autowired
//     private final Aug_Budget_1_2_Repository aug_budget_1_2_Repository;
//     @Autowired
//     private final Aug_Budget_3_4_Repository aug_budget_3_4_Repository;

//     @Autowired
//     private final Sep_Budget_1_2_Repository sep_budget_1_2_Repository;
//     @Autowired
//     private final Sep_Budget_3_4_Repository sep_budget_3_4_Repository;

//     @Autowired
//     private final Oct_Budget_1_2_Repository oct_budget_1_2_Repository;
//     @Autowired
//     private final Oct_Budget_3_4_Repository oct_budget_3_4_Repository;

//     @Autowired
//     private final Nov_Budget_1_2_Repository nov_budget_1_2_Repository;
//     @Autowired
//     private final Nov_Budget_3_4_Repository nov_budget_3_4_Repository;

//     @Autowired
//     private final Dec_Budget_1_2_Repository dec_budget_1_2_Repository;
//     @Autowired
//     private final Dec_Budget_3_4_Repository dec_budget_3_4_Repository;
//     @Autowired
//     public BudgetService(Jan_Budget_1_2_Repository jan_budget_1_2_Repository, Jan_Budget_3_4_Repository jan_budget_3_4_Repository,
//                          Feb_Budget_1_2_Repository feb_budget_1_2_Repository, Feb_Budget_3_4_Repository feb_budget_3_4_Repository,
//                          Mar_Budget_1_2_Repository mar_budget_1_2_Repository, Mar_Budget_3_4_Repository mar_budget_3_4_Repository,
//                          Apr_Budget_1_2_Repository apr_budget_1_2_Repository, Apr_Budget_3_4_Repository apr_budget_3_4_Repository,
//                          May_Budget_1_2_Repository may_budget_1_2_Repository, May_Budget_3_4_Repository may_budget_3_4_Repository,
//                          Jun_Budget_1_2_Repository jun_budget_1_2_Repository, Jun_Budget_3_4_Repository jun_budget_3_4_Repository,
//                          Jul_Budget_1_2_Repository jul_budget_1_2_Repository, Jul_Budget_3_4_Repository jul_budget_3_4_Repository,
//                          Aug_Budget_1_2_Repository aug_budget_1_2_Repository, Aug_Budget_3_4_Repository aug_budget_3_4_Repository,
//                          Sep_Budget_1_2_Repository sep_budget_1_2_Repository, Sep_Budget_3_4_Repository sep_budget_3_4_Repository,
//                          Oct_Budget_1_2_Repository oct_budget_1_2_Repository, Oct_Budget_3_4_Repository oct_budget_3_4_Repository,
//                          Nov_Budget_1_2_Repository nov_budget_1_2_Repository, Nov_Budget_3_4_Repository nov_budget_3_4_Repository,
//                          Dec_Budget_1_2_Repository dec_budget_1_2_Repository, Dec_Budget_3_4_Repository dec_budget_3_4_Repository) {
//         this.jan_budget_1_2_Repository = jan_budget_1_2_Repository;
//         this.jan_budget_3_4_Repository = jan_budget_3_4_Repository;
//         this.feb_budget_1_2_Repository = feb_budget_1_2_Repository;
//         this.feb_budget_3_4_Repository = feb_budget_3_4_Repository;
//         this.mar_budget_1_2_Repository = mar_budget_1_2_Repository;
//         this.mar_budget_3_4_Repository = mar_budget_3_4_Repository;
//         this.apr_budget_1_2_Repository = apr_budget_1_2_Repository;
//         this.apr_budget_3_4_Repository = apr_budget_3_4_Repository;
//         this.may_budget_1_2_Repository = may_budget_1_2_Repository;
//         this.may_budget_3_4_Repository = may_budget_3_4_Repository;
//         this.jun_budget_1_2_Repository = jun_budget_1_2_Repository;
//         this.jun_budget_3_4_Repository = jun_budget_3_4_Repository;
//         this.jul_budget_1_2_Repository = jul_budget_1_2_Repository;
//         this.jul_budget_3_4_Repository = jul_budget_3_4_Repository;
//         this.aug_budget_1_2_Repository = aug_budget_1_2_Repository;
//         this.aug_budget_3_4_Repository = aug_budget_3_4_Repository;
//         this.sep_budget_1_2_Repository = sep_budget_1_2_Repository;
//         this.sep_budget_3_4_Repository = sep_budget_3_4_Repository;
//         this.oct_budget_1_2_Repository = oct_budget_1_2_Repository;
//         this.oct_budget_3_4_Repository = oct_budget_3_4_Repository;
//         this.nov_budget_1_2_Repository = nov_budget_1_2_Repository;
//         this.nov_budget_3_4_Repository = nov_budget_3_4_Repository;
//         this.dec_budget_1_2_Repository = dec_budget_1_2_Repository;
//         this.dec_budget_3_4_Repository = dec_budget_3_4_Repository;

//         LOGGER.info("***** saveJan_budget_1_2 ***** this.jul_budget_3_4_Repository " + this.jul_budget_3_4_Repository);
//     }
//     public BudgetService() {
//         LOGGER.info("***** here ");
//         jan_budget_1_2_Repository = null;
//         jan_budget_3_4_Repository = null;
//         feb_budget_1_2_Repository = null;
//         feb_budget_3_4_Repository = null;
//         mar_budget_1_2_Repository = null;
//         mar_budget_3_4_Repository = null;
//         apr_budget_1_2_Repository = null;
//         apr_budget_3_4_Repository = null;
//         may_budget_1_2_Repository = null;
//         may_budget_3_4_Repository = null;
//         jun_budget_1_2_Repository = null;
//         jun_budget_3_4_Repository = null;
//         jul_budget_1_2_Repository = null;
//         jul_budget_3_4_Repository = null;
//         aug_budget_1_2_Repository = null;
//         aug_budget_3_4_Repository = null;
//         sep_budget_1_2_Repository = null;
//         sep_budget_3_4_Repository = null;
//         oct_budget_1_2_Repository = null;
//         oct_budget_3_4_Repository = null;
//         nov_budget_1_2_Repository = null;
//         nov_budget_3_4_Repository = null;
//         dec_budget_1_2_Repository = null;
//         dec_budget_3_4_Repository = null;
//     }
//     public String mmm(String dd) {
//         LOGGER.info("***** here " + dd);
//         return dd;
//     }
//     @Transactional
//     public void jan_budget_1_2(Finance finance) {
//         Jan_Budget_1_2 budgetData = new Jan_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         jan_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void jan_budget_3_4(Finance finance) {
//         Jan_Budget_3_4 budgetData = new Jan_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         jan_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void feb_budget_1_2(Finance finance) {
//         Feb_Budget_1_2 budgetData = new Feb_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         feb_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void jeb_budget_3_4(Finance finance) {
//         Feb_Budget_3_4 budgetData = new Feb_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         feb_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void mar_budget_1_2(Finance finance) {
//         Mar_Budget_1_2 budgetData = new Mar_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         mar_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void mar_budget_3_4(Finance finance) {
//         Mar_Budget_3_4 budgetData = new Mar_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         mar_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void apr_budget_1_2(Finance finance) {
//         Apr_Budget_1_2 budgetData = new Apr_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         apr_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void apr_budget_3_4(Finance finance) {
//         Apr_Budget_3_4 budgetData = new Apr_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         apr_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void may_budget_1_2(Finance finance) {
//         May_Budget_1_2 budgetData = new May_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         may_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void may_budget_3_4(Finance finance) {
//         May_Budget_3_4 budgetData = new May_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         may_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void jun_budget_1_2(Finance finance) {
//         Jun_Budget_1_2 budgetData = new Jun_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         jun_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void jun_budget_3_4(Finance finance) {
//         Jun_Budget_3_4 budgetData = new Jun_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         jun_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void jul_budget_1_2(Finance finance) {
//         Jul_Budget_1_2 budgetData = new Jul_Budget_1_2(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         jul_budget_1_2_Repository.save(budgetData);
//     }

//     @Transactional
//     public void jul_budget_3_4(Finance finance) {
//         Jul_Budget_3_4 budgetData = new Jul_Budget_3_4(finance.getId(), finance.getItemName(), finance.getItemAmount(), finance.getTableName());
//         jul_budget_3_4_Repository.save(budgetData);
//     }

//     @Transactional
//     public void deleteBudgetIteamById(long id, String tableName) {
//         switch (tableName.toLowerCase()) {
//             case "jan_budget_1_2":
//                 jan_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "jan_budget_3_4":
//                 jan_budget_3_4_Repository.deleteById(id);
//                 break;
//             case "feb_budget_1_2":
//                 feb_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "feb_budget_3_4":
//                 feb_budget_3_4_Repository.deleteById(id);
//                 break;
//             case "mar_budget_1_2":
//                 mar_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "mar_budget_3_4":
//                 mar_budget_3_4_Repository.deleteById(id);
//                 break;
//             case "apr_budget_1_2":
//                 apr_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "apr_budget_3_4":
//                 apr_budget_3_4_Repository.deleteById(id);
//                 break;
//             case "may_budget_1_2":
//                 may_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "may_budget_3_4":
//                 may_budget_3_4_Repository.deleteById(id);
//                 break;
//             case "jun_budget_1_2":
//                 jun_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "jun_budget_3_4":
//                 jun_budget_3_4_Repository.deleteById(id);
//                 break;
//             case "jul_budget_1_2":
//                 jul_budget_1_2_Repository.deleteById(id);
//                 break;
//             case "jul_budget_3_4":
//                 jul_budget_3_4_Repository.deleteById(id);
//                 break;
//             default:
//                 throw new IllegalArgumentException("Invalid table name: " + tableName);
//         }
//     }
// }
