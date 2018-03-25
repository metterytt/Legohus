package presentationLayer;

import functionLayer.LegoHusException;
import functionLayer.LogicFacade;
import functionLayer.Order;
import functionLayer.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrdersUser extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        User user = (User) request.getSession().getAttribute("user");
        int userID = user.getID();
        List<Order> userOrders = new ArrayList<>();
        try {
            userOrders = LogicFacade.getUserOrders(userID);
        } catch (LegoHusException e) {
            request.setAttribute("error", e.getMessage());
            return "customer";
        }
        request.setAttribute("userorders", userOrders);
        return "showuserorders";
    }

}
