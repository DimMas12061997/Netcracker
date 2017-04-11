package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AdminEditPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        UserDAO userDao = new UserDAO();
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("user");
        try {
            User user = userDao.getUserByLogin(name);
            page = ConfigurationManager.getProperty("path.page.adminEditPage");
            request.setAttribute("first_name", user.getFirstName());
            request.setAttribute("last_name", user.getLastName());
            request.setAttribute("login", user.getLogin());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("date", user.getCreatedDate());
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
