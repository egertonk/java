package egerton.backend.portfolio.model.budget;

import egerton.backend.portfolio.implementation.Budget_Table_Impl;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "oct_budget_1_2")
public class Oct_Budget_1_2 extends Budget_Table_Impl {
    public Oct_Budget_1_2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Oct_Budget_1_2(long id, String itemName, double itemAmount, String tableName) {
        super(id, itemName, itemAmount, tableName);
    }
}
