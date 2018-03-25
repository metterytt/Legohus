package presentationLayer;

import functionLayer.House;
import functionLayer.LegoHusException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InputHouse extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        HttpSession session = request.getSession();
        int height;
        int length;
        int width;
        try {
            height = Integer.parseInt(request.getParameter("height"));
            length = Integer.parseInt(request.getParameter("length"));
            width = Integer.parseInt(request.getParameter("width"));
            if (height < 4 || height > 10 || length < 8 || length > 40 || width < 5 || width > 30) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Venligst indtast gyldige mål i heltal, som anført i rubrikkerne.");
            return "customer";
        }
        House house = new House(height, length, width);
        session.setAttribute("house", house);
        return "stykliste";
    }

}
