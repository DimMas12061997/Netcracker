package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class EditMainDataCommand implements ActionCommand {
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
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("user");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(name);
            edit(user.getUserId());
            session.setAttribute("user", login);
            request.setAttribute("first_name", firstName);
            request.setAttribute("last_name", lastName);
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            request.setAttribute("date", user.getCreatedDate());
            page = ConfigurationManager.getProperty("path.page.adminEditPage");
        } catch (SQLException e) {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.errorfillprofile"));
            page = ConfigurationManager.getProperty("path.page.adminEditPage");
        }
        return page;
    }

    private void edit(int user_id) throws SQLException {
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setUserId(user_id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        dao.updateUser(user);
    }
}


