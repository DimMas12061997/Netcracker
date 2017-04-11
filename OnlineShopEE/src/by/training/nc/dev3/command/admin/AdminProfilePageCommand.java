package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.beans.UserProfile;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.dao.UserProfileDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AdminProfilePageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            page = ConfigurationManager.getProperty("path.page.adminProfile");
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("user");
            UserProfileDAO user = new UserProfileDAO();
            UserProfile profile = null;
            profile = user.getEntityById(new UserDAO().getUserIdByName(name));
            if (profile != null) {
                request.setAttribute("email", profile.getEmail());
                request.setAttribute("address", profile.getAddress());
                request.setAttribute("budget", profile.getBudget());
                request.setAttribute("creditCard", profile.getCreditCard());
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}

