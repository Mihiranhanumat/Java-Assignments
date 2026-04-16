import java.sql.*;

public class RestaurantDAO {

    Connection con = DBConnection.getConnection();

    // INSERT Restaurant
    public void insertRestaurant(int id, String name, String address) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Restaurant VALUES (?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, address);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // INSERT MenuItem
    public void insertMenuItem(int id, String name, int price, int resId) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO MenuItem VALUES (?, ?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.setInt(4, resId);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // SELECT MenuItem
    public ResultSet getMenuItems() {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery("SELECT * FROM MenuItem");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // UPDATE
    public void updatePrice(int id, int price) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE MenuItem SET Price=? WHERE Id=?");

            ps.setInt(1, price);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE
    public void deleteItem(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM MenuItem WHERE Id=?");

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}