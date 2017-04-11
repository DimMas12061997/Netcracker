package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowCustomersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            UserDAO userDAO = new UserDAO();
            List<User> list = userDAO.findAll();
            session.setAttribute(Parameters.USER_LIST, list);
            page = ConfigurationManager.getProperty("path.page.showCustomers");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}


