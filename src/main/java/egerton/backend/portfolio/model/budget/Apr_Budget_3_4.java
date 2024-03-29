package egerton.backend.portfolio.model.budget;

import egerton.backend.portfolio.implementation.Budget_Table_Impl;
import jakarta.persistence.*;

@Entity
@Table(name = "apr_budget_3_4")
public class Apr_Budget_3_4 extends Budget_Table_Impl {
    public Apr_Budget_3_4() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Apr_Budget_3_4(long id, String itemName, double itemAmount, String tableName) {
        super(id, itemName, itemAmount, tableName);
    }
}
