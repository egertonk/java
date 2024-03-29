package egerton.backend.portfolio.model.budget;

import egerton.backend.portfolio.implementation.Budget_Table_Impl;
import jakarta.persistence.*;

@Entity
@Table(name = "jun_budget_1_2")
public class Jun_Budget_1_2 extends Budget_Table_Impl {
    public Jun_Budget_1_2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Jun_Budget_1_2(long id, String itemName, double itemAmount, String tableName) {
        super(id, itemName, itemAmount, tableName);
    }
}