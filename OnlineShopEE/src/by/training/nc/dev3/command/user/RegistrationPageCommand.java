package by.training.nc.dev3.command.user;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegistrationPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if(session != null)
            session.setAttribute("regError", "");
        String page = ConfigurationManager. getProperty("path.page.registration");
        return page;
    }
}
