package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.UserProfile;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.dao.UserProfileDAO;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class FillProfileCommand implements ActionCommand {
    private static String email;
    private static String address;
    private static double budget;
    private static String creditCard;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        email = request.getParameter(Parameters.EMAIL);
        address = request.getParameter(Parameters.ADDRESS);
        budget = Double.parseDouble(request.getParameter(Parameters.BUDGET));
        creditCard = request.getParameter(Parameters.CREDIT_CARD);
        try {
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("user");
            UserProfileDAO user = new UserProfileDAO();
            UserProfile profile = user.getEntityById(new UserDAO().getUserIdByName(name));
            if (profile == null)
                registrate(name);
            else {
                edit(profile.getUserId());
            }
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("budget", budget);
            request.setAttribute("creditCard", creditCard);
            page = ConfigurationManager.getProperty("path.page.adminProfile");
        } catch (SQLException e) {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.errorfillprofile"));
            page = ConfigurationManager.getProperty("path.page.adminProfile");
        }
        return page;
    }

    private void registrate(String name) throws SQLException {
        UserProfileDAO dao = new UserProfileDAO();
        UserProfile user = new UserProfile();
        user.setEmail(email);
        user.setAddress(address);
        user.setBudget(budget);
        user.setCreditCard(creditCard);
        user.setUserId(new UserDAO().getUserIdByName(name));
        dao.createEntity(user);
    }

    private void edit(int id_user) throws SQLException {
        UserProfileDAO dao = new UserProfileDAO();
        UserProfile user = new UserProfile();
        user.setEmail(email);
        user.setAddress(address);
        user.setBudget(budget);
        user.setCreditCard(creditCard);
        user.setUserId(id_user);
        dao.updateUserProfile(user);
    }
}

