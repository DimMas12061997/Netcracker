package by.training.nc.dev3.command.user;

import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.filter.ClientType;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RegistrationCommand implements ActionCommand {
    private static String firstName;
    private static String lastName;
    private static String login;
    private static String password;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        firstName = request.getParameter(Parameters.FIRST_NAME);
        lastName = request.getParameter(Parameters.LAST_NAME);
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        try {
            registrate();
            request.setAttribute("user", login);
            HttpSession session = request.getSession(true);
            session.setAttribute("userType", ClientType.CUSTOMER);
            page = ConfigurationManager.getProperty("path.page.user");
        } catch (SQLException e) {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.regerror"));
            request.getSession().setAttribute("userType", ClientType.GUEST);
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        return page;
    }

    private void registrate() throws SQLException {
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleId(dao.getRoleIdByName());
        user.setShopId(dao.getShopIdByName(OnlineShop.getName()));
        dao.createEntity(user);
    }
}
