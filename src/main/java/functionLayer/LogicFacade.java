package functionLayer;

import dbAccess.OrderMapper;
import dbAccess.UserMapper;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws LegoHusException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password1) throws LegoHusException {
        User user = new User(email, password1, "customer");
        UserMapper.createUser(user);
        return user;
    }
    
    public static void placeOrder(Order order) throws LegoHusException{
        OrderMapper.placeOrder(order);
    }

    public static List<Order> getUserOrders(int userID) throws LegoHusException {
        return OrderMapper.getUserOrders(userID);
    }

    public static List<Order> getAllOrders() throws LegoHusException {
        return OrderMapper.getAllOrders();
    }

    public static void setSent(int orderID) throws LegoHusException {
        OrderMapper.setSent(orderID);
    }

}
