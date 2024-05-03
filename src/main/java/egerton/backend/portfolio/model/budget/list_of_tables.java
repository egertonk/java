// package egerton.backend.portfolio.model.budget;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// @Entity
// @Table(name = "list_of_tables")
// public class list_of_tables {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;

//     @Column(name = "table_name")
//     private String tableName;

//     public list_of_tables(long id, String tableName) {
//         this.id = id;
//         this.tableName = tableName;
//     }

//     public list_of_tables() {
//         // TODO Auto-generated constructor stub
//     }

//     public long getId() {
//         return id;
//     }

//     public void setId(long id) {
//         this.id = id;
//     }
//     public String getTableName() {
//         return tableName;
//     }

//     public void setTableName(String tableName) {
//         this.tableName = tableName;
//     }

//     @Override
//     public String toString() {
//         return "list_of_tables{" +
//                 "id=" + id +
//                 ", tableName='" + tableName + '\'' +
//                 '}';
//     }
// }
