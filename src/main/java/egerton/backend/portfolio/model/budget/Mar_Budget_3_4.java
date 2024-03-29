package egerton.backend.portfolio.model.budget;

import egerton.backend.portfolio.implementation.Budget_Table_Impl;
import jakarta.persistence.*;

@Entity
@Table(name = "mar_budget_3_4")
public class Mar_Budget_3_4 extends Budget_Table_Impl {
    public Mar_Budget_3_4() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Mar_Budget_3_4(long id, String itemName, double itemAmount, String tableName) {
        super(id, itemName, itemAmount, tableName);
    }
}
