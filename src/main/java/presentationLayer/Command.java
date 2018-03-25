package presentationLayer;

import functionLayer.LegoHusException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("inputhouse", new InputHouse());
        commands.put("showordersuser", new ShowOrdersUser());
        commands.put("logout", new Logout());
        commands.put("showstykliste", new ShowStykliste());
        commands.put("newcalculation", new NewCalculation());
        commands.put("backtoadmin", new BackToAdmin());
        commands.put("setsent", new SetSent());
        commands.put("showordersemp", new ShowOrdersEmp());
        commands.put("placeorder", new PlaceOrder());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHusException;

}
