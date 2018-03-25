package presentationLayer;

import functionLayer.House;
import functionLayer.LegoHusException;
import functionLayer.LogicFacade;
import functionLayer.Order;
import functionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        House house = (House) request.getSession().getAttribute("house");
        User user = (User) request.getSession().getAttribute("user");
        Order order = new Order(user.getID(), house.getHeight(), house.getLength(), house.getWidth());
        try {
            LogicFacade.placeOrder(order);
        } catch (LegoHusException e) {
            request.setAttribute("error", e.getMessage());
            return "customer";
        }
        int ordreID = order.getOrderID();
        request.setAttribute("message", "Ordre med ID " + ordreID + " er nu oprettet i systemet.");
        request.getSession().removeAttribute("house");
        return "customer";
    }

}
