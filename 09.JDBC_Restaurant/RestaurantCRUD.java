import java.sql.*;

public class RestaurantCRUD {

    Connection con = DBConnection.getConnection();

    // 🔹 INSERT 10 RECORDS
    public void insertData() {
        try {
            Statement stmt = con.createStatement();

            // Restaurants
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (1,'Cafe Java','Pune')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (2,'Food Hub','Mumbai')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (3,'Spice Villa','Delhi')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (4,'Tasty Town','Pune')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (5,'Urban Bites','Delhi')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (6,'Green Leaf','Mumbai')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (7,'Royal Dine','Pune')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (8,'Quick Eats','Delhi')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (9,'Street Food','Mumbai')");
            stmt.executeUpdate("INSERT INTO Restaurant VALUES (10,'Fine Dine','Pune')");

            // MenuItems
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (1,'Pizza',90,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (2,'Burger',80,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (3,'Pasta',120,2)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (4,'Sandwich',70,3)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (5,'Paneer',150,4)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (6,'Noodles',100,5)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (7,'Paratha',60,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (8,'PavBhaji',90,2)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (9,'Fries',50,1)");
            stmt.executeUpdate("INSERT INTO MenuItem VALUES (10,'Soup',110,3)");

            System.out.println("Inserted records successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 SELECT price <=100
    public void selectCheapItems() {
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM MenuItem WHERE Price <= 100");

            print(rs);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 SELECT Cafe Java items
    public void selectCafeJavaItems() {
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT m.* FROM MenuItem m JOIN Restaurant r " +
                "ON m.ResId = r.Id WHERE r.Name='Cafe Java'");

            print(rs);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 UPDATE
    public void updateItems() {
        try {
            Statement stmt = con.createStatement();

            stmt.executeUpdate(
                "UPDATE MenuItem SET Price = 200 WHERE Price <= 100");

            System.out.println("Updated successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 DELETE
    public void deleteItems() {
        try {
            Statement stmt = con.createStatement();

            stmt.executeUpdate(
                "DELETE FROM MenuItem WHERE Name LIKE 'P%'");

            System.out.println("Deleted successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 🔹 PRINT TABLE
    public void print(ResultSet rs) throws Exception {

        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();

        // header
        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        // rows
        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}