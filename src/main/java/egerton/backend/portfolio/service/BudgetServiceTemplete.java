package egerton.backend.portfolio.service;

import egerton.backend.portfolio.repository.budget.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
@Service
public class BudgetServiceTemplete {
    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetServiceTemplete.class);

    @Autowired
    private final Jan_Budget_1_2_Repository jan_budget_1_2_Repository;
    @Autowired
    private final Jan_Budget_3_4_Repository jan_budget_3_4_Repository;

    @Autowired
    private final Feb_Budget_1_2_Repository feb_budget_1_2_Repository;
    @Autowired
    private final Feb_Budget_3_4_Repository feb_budget_3_4_Repository;

    @Autowired
    private final Mar_Budget_1_2_Repository mar_budget_1_2_Repository;
    @Autowired
    private final Mar_Budget_3_4_Repository mar_budget_3_4_Repository;

    @Autowired
    private final Apr_Budget_1_2_Repository apr_budget_1_2_Repository;
    @Autowired
    private final Apr_Budget_3_4_Repository apr_budget_3_4_Repository;

    @Autowired
    private final May_Budget_1_2_Repository may_budget_1_2_Repository;
    @Autowired
    private final May_Budget_3_4_Repository may_budget_3_4_Repository;

    @Autowired
    private final Jun_Budget_1_2_Repository jun_budget_1_2_Repository;
    @Autowired
    private final Jun_Budget_3_4_Repository jun_budget_3_4_Repository;

    @Autowired
    private final Jul_Budget_1_2_Repository jul_budget_1_2_Repository;
    @Autowired
    private final Jul_Budget_3_4_Repository jul_budget_3_4_Repository;

    @Autowired
    private final Aug_Budget_1_2_Repository aug_budget_1_2_Repository;
    @Autowired
    private final Aug_Budget_3_4_Repository aug_budget_3_4_Repository;

    @Autowired
    private final Sep_Budget_1_2_Repository sep_budget_1_2_Repository;
    @Autowired
    private final Sep_Budget_3_4_Repository sep_budget_3_4_Repository;

    @Autowired
    private final Oct_Budget_1_2_Repository oct_budget_1_2_Repository;
    @Autowired
    private final Oct_Budget_3_4_Repository oct_budget_3_4_Repository;

    @Autowired
    private final Nov_Budget_1_2_Repository nov_budget_1_2_Repository;
    @Autowired
    private final Nov_Budget_3_4_Repository nov_budget_3_4_Repository;

    @Autowired
    private final Dec_Budget_1_2_Repository dec_budget_1_2_Repository;
    @Autowired
    private final Dec_Budget_3_4_Repository dec_budget_3_4_Repository;
    @Autowired
    public BudgetServiceTemplete(Jan_Budget_1_2_Repository jan_budget_1_2_Repository, Jan_Budget_3_4_Repository jan_budget_3_4_Repository,
                                 Feb_Budget_1_2_Repository feb_budget_1_2_Repository, Feb_Budget_3_4_Repository feb_budget_3_4_Repository,
                                 Mar_Budget_1_2_Repository mar_budget_1_2_Repository, Mar_Budget_3_4_Repository mar_budget_3_4_Repository,
                                 Apr_Budget_1_2_Repository apr_budget_1_2_Repository, Apr_Budget_3_4_Repository apr_budget_3_4_Repository,
                                 May_Budget_1_2_Repository may_budget_1_2_Repository, May_Budget_3_4_Repository may_budget_3_4_Repository,
                                 Jun_Budget_1_2_Repository jun_budget_1_2_Repository, Jun_Budget_3_4_Repository jun_budget_3_4_Repository,
                                 Jul_Budget_1_2_Repository jul_budget_1_2_Repository, Jul_Budget_3_4_Repository jul_budget_3_4_Repository,
                                 Aug_Budget_1_2_Repository aug_budget_1_2_Repository, Aug_Budget_3_4_Repository aug_budget_3_4_Repository,
                                 Sep_Budget_1_2_Repository sep_budget_1_2_Repository, Sep_Budget_3_4_Repository sep_budget_3_4_Repository,
                                 Oct_Budget_1_2_Repository oct_budget_1_2_Repository, Oct_Budget_3_4_Repository oct_budget_3_4_Repository,
                                 Nov_Budget_1_2_Repository nov_budget_1_2_Repository, Nov_Budget_3_4_Repository nov_budget_3_4_Repository,
                                 Dec_Budget_1_2_Repository dec_budget_1_2_Repository, Dec_Budget_3_4_Repository dec_budget_3_4_Repository) {
        this.jan_budget_1_2_Repository = jan_budget_1_2_Repository;
        this.jan_budget_3_4_Repository = jan_budget_3_4_Repository;
        this.feb_budget_1_2_Repository = feb_budget_1_2_Repository;
        this.feb_budget_3_4_Repository = feb_budget_3_4_Repository;
        this.mar_budget_1_2_Repository = mar_budget_1_2_Repository;
        this.mar_budget_3_4_Repository = mar_budget_3_4_Repository;
        this.apr_budget_1_2_Repository = apr_budget_1_2_Repository;
        this.apr_budget_3_4_Repository = apr_budget_3_4_Repository;
        this.may_budget_1_2_Repository = may_budget_1_2_Repository;
        this.may_budget_3_4_Repository = may_budget_3_4_Repository;
        this.jun_budget_1_2_Repository = jun_budget_1_2_Repository;
        this.jun_budget_3_4_Repository = jun_budget_3_4_Repository;
        this.jul_budget_1_2_Repository = jul_budget_1_2_Repository;
        this.jul_budget_3_4_Repository = jul_budget_3_4_Repository;
        this.aug_budget_1_2_Repository = aug_budget_1_2_Repository;
        this.aug_budget_3_4_Repository = aug_budget_3_4_Repository;
        this.sep_budget_1_2_Repository = sep_budget_1_2_Repository;
        this.sep_budget_3_4_Repository = sep_budget_3_4_Repository;
        this.oct_budget_1_2_Repository = oct_budget_1_2_Repository;
        this.oct_budget_3_4_Repository = oct_budget_3_4_Repository;
        this.nov_budget_1_2_Repository = nov_budget_1_2_Repository;
        this.nov_budget_3_4_Repository = nov_budget_3_4_Repository;
        this.dec_budget_1_2_Repository = dec_budget_1_2_Repository;
        this.dec_budget_3_4_Repository = dec_budget_3_4_Repository;

        LOGGER.info("***** saveJan_budget_1_2 ***** this.jul_budget_3_4_Repository " + this.jul_budget_3_4_Repository);
    }
    public BudgetServiceTemplete() {
        LOGGER.info("***** here ");
        jan_budget_1_2_Repository = null;
        jan_budget_3_4_Repository = null;
        feb_budget_1_2_Repository = null;
        feb_budget_3_4_Repository = null;
        mar_budget_1_2_Repository = null;
        mar_budget_3_4_Repository = null;
        apr_budget_1_2_Repository = null;
        apr_budget_3_4_Repository = null;
        may_budget_1_2_Repository = null;
        may_budget_3_4_Repository = null;
        jun_budget_1_2_Repository = null;
        jun_budget_3_4_Repository = null;
        jul_budget_1_2_Repository = null;
        jul_budget_3_4_Repository = null;
        aug_budget_1_2_Repository = null;
        aug_budget_3_4_Repository = null;
        sep_budget_1_2_Repository = null;
        sep_budget_3_4_Repository = null;
        oct_budget_1_2_Repository = null;
        oct_budget_3_4_Repository = null;
        nov_budget_1_2_Repository = null;
        nov_budget_3_4_Repository = null;
        dec_budget_1_2_Repository = null;
        dec_budget_3_4_Repository = null;
    }

    public Feb_Budget_1_2_Repository getFeb_budget_1_2_Repository() {
        return feb_budget_1_2_Repository;
    }

    public Feb_Budget_3_4_Repository getFeb_budget_3_4_Repository() {
        return feb_budget_3_4_Repository;
    }
}
