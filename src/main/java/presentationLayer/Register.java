package presentationLayer;

import functionLayer.LegoHusException;
import functionLayer.LogicFacade;
import functionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (email.equals("") || password1.equals("")) {
            throw new LegoHusException("Felterne må ikke være tomme.");
        }
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "";
        } else {
            throw new LegoHusException("De to password matcher ikke.");
        }
    }
}
