// package egerton.backend.portfolio.implementation;
// import jakarta.persistence.*;

// @MappedSuperclass
// @Inheritance(strategy= InheritanceType.SINGLE_TABLE)
// public class Budget_Table_Impl {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;

//     @Column(name = "item_name")
//     private String itemName;

//     @Column(name = "item_amount")
//     private double itemAmount;

//     @Column(name = "table_name")
//     private String tableName;

//     public Budget_Table_Impl() {
//         // TODO Auto-generated constructor stub
//     }

//     public Budget_Table_Impl(long id, String itemName, double itemAmount, String tableName) {
//         this.id = id;
//         this.itemName = itemName;
//         this.itemAmount = itemAmount;
//         this.tableName = tableName;
//     }

//     public long getId() {
//         return id;
//     }

//     public void setId(long id) {
//         this.id = id;
//     }

//     public String getItemName() {
//         return itemName;
//     }

//     public void setItemName(String itemName) {
//         this.itemName = itemName;
//     }

//     public double getItemAmount() {
//         return itemAmount;
//     }

//     public void setItemAmount(double itemAmount) {
//         this.itemAmount = itemAmount;
//     }

//     public String getTableName() {
//         return tableName;
//     }

//     public void setTableName(String tableName) {
//         this.tableName = tableName;
//     }

//     @Override
//     public String toString() {
//         return this.getClass() + " [id=" + id + ", itemName=" + itemName + ", itemAmount=" + itemAmount + ", tableName="
//                 + tableName + "]";
//     }

// }