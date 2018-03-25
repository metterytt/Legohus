package dbAccess;

import functionLayer.LegoHusException;
import functionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMapper {

    private static DBConnector dbc = new DBConnector();

    public static void createUser(User user) throws LegoHusException {
        try {
            dbc.setDataSource(new DataSourceLego().getDataSource());
            dbc.open();
            Connection con = dbc.getConnector();
            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setID(id);
        } catch (SQLException e) {
            throw new LegoHusException("Fejl ved oprettelse af bruger. Brugeren "
                    + "er allerede registreret, eller indtastningerne er fejlagtige. Prøv igen.");
        }
    }

    public static User login(String email, String password) throws LegoHusException {
        try {
            dbc.setDataSource(new DataSourceLego().getDataSource());
            dbc.open();
            Connection con = dbc.getConnector();
            String sql = "SELECT id, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setID(id);
                return user;
            } else {
                throw new LegoHusException("Could not validate user");
            }
        } catch (SQLException e) {
            throw new LegoHusException(e.getMessage());
        }
    }
}
