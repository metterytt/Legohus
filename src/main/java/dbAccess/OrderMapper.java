package dbAccess;

import functionLayer.LegoHusException;
import functionLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    private static DBConnector dbc = new DBConnector();

    public static void placeOrder(Order order) throws LegoHusException {
        try {
            dbc.setDataSource(new DataSourceLego().getDataSource());
            dbc.open();
            Connection con = dbc.getConnector();
            String sql = "INSERT INTO orders (user_id, height, length, width) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUserID());
            ps.setInt(2, order.getHeight());
            ps.setInt(3, order.getLength());
            ps.setInt(4, order.getWidth());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrderID(id);
        } catch (SQLException e) {
            throw new LegoHusException("Error placing order.");
        }
    }

    public static List<Order> getUserOrders(int userID) throws LegoHusException {
        ArrayList<Order> userOrders = new ArrayList<>();
        try {
            dbc.setDataSource(new DataSourceLego().getDataSource());
            dbc.open();
            Connection con = dbc.getConnector();
            String sql = "SELECT * FROM orders where user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderID = rs.getInt("order_id");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int sent = rs.getInt("sent");
                Order order = new Order(userID, height, length, width);
                order.setOrderID(orderID);
                if (sent == 1) {
                    order.setSent(true);
                }
                userOrders.add(order);
            }
            ps.close();
        } catch (SQLException e) {
            throw new LegoHusException("Error getting orders.");
        }
        return userOrders;
    }

    public static List<Order> getAllOrders() throws LegoHusException {
        ArrayList<Order> allOrders = new ArrayList<>();
        try {
            dbc.setDataSource(new DataSourceLego().getDataSource());
            dbc.open();
            String sql = "SELECT * FROM orders";
            ResultSet rs = dbc.query(sql);
            while (rs.next()) {
                int orderID = rs.getInt("order_id");
                int userID = rs.getInt("user_id");
                int height = rs.getInt("height");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int sent = rs.getInt("sent");
                Order order = new Order(userID, height, length, width);
                order.setOrderID(orderID);
                if (sent == 1) {
                    order.setSent(true);
                }
                allOrders.add(order);
            }
        } catch (SQLException e) {
            throw new LegoHusException("Error getting orders.");
        }
        return allOrders;
    }

    public static void setSent(int orderID) throws LegoHusException {
        try {
            dbc.setDataSource(new DataSourceLego().getDataSource());
            dbc.open();
            Connection con = dbc.getConnector();
            String sql = "UPDATE `legohus`.`orders` SET `sent`='1' WHERE `order_id`=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new LegoHusException("Error setting sent status.");
        }
    }
}
