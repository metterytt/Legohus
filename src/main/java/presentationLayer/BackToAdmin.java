package presentationLayer;

import functionLayer.LegoHusException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackToAdmin extends Command {

    public BackToAdmin() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        return "employee";
    }

}
