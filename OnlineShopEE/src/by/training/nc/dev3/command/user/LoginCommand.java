package by.training.nc.dev3.command.user;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.filter.ClientType;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String pass = request.getParameter(Parameters.PASSWORD);
        try {
            if (new UserDAO().isAuthorized(login, pass)) {
                String role = new UserDAO().checkRole(login, pass);
                if (role.equals("admin")) {
                    request.setAttribute("user", login);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userType", ClientType.ADMINISTRATOR);
                    page = ConfigurationManager.getProperty("path.page.main");
                } else if (role.equals("customer")) {
                    request.setAttribute("user", login);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userType", ClientType.CUSTOMER);
                    page = ConfigurationManager.getProperty("path.page.user");
                }
            } else {
                request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
                request.getSession().setAttribute("userType", ClientType.GUEST);
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } catch (SQLException e) {
            System.out.println("err");
        }
        return page;
    }
}
