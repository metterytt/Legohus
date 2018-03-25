package presentationLayer;

import functionLayer.House;
import functionLayer.LegoHusException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowStykliste extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        House house = new House(height, length, width);
        request.setAttribute("house", house);
        request.setAttribute("orderID", orderID);
        return "visstykliste";
    }

}
