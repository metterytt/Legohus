package presentationLayer;

import functionLayer.LegoHusException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCalculation extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        request.getSession().removeAttribute("house");
        return "customer";
    }

}
