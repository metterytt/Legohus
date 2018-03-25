package presentationLayer;

import functionLayer.LegoHusException;
import functionLayer.LogicFacade;
import functionLayer.Order;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetSent extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        try {
            LogicFacade.setSent(orderID);
        } catch (LegoHusException e) {
            request.setAttribute("error", e);
            return "employee";
        }
        List<Order> allOrders = new ArrayList<>();
        try {
            allOrders = LogicFacade.getAllOrders();
        } catch (LegoHusException e) {
            request.setAttribute("error", e.getMessage());
            return "employee";
        }
        List<Order> ordersSent = new ArrayList<>();
        for (Order o : allOrders) {
            if (o.isSent()) {
                ordersSent.add(o);
            }
        }
        List<Order> ordersNotSent = new ArrayList<>();
        for (Order o : allOrders) {
            if (!o.isSent()) {
                ordersNotSent.add(o);
            }
        }
        request.setAttribute("orderssent", ordersSent);
        request.setAttribute("ordersnotsent", ordersNotSent);
        return "showallorders";
    }

}
