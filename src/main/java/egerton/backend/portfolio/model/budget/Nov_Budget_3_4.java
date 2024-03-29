package egerton.backend.portfolio.model.budget;

import egerton.backend.portfolio.implementation.Budget_Table_Impl;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "nov_budget_3_4")
public class Nov_Budget_3_4 extends Budget_Table_Impl {
    public Nov_Budget_3_4() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Nov_Budget_3_4(long id, String itemName, double itemAmount, String tableName) {
        super(id, itemName, itemAmount, tableName);
    }
}
