package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.beans.UserProfile;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.ShopDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.dao.UserProfileDAO;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class BuyOrderCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String orderCost = request.getParameter(Parameters.ORDER_COST);
            double cost = Double.parseDouble(orderCost);
            UserDAO userDAO = new UserDAO();
            OrderDAO orderDAO = new OrderDAO();
            String userLogin = (String) session.getAttribute("user");
            int idUser = userDAO.getUserIdByName(userLogin);
            UserProfileDAO userProfileDAO = new UserProfileDAO();
            UserProfile userProfile = userProfileDAO.getEntityById(idUser);
            if (userProfile.getBudget() >= cost) {
                orderDAO.removeOrderById(idUser);
                userProfile.setBudget(userProfile.getBudget() - cost);
                User user = userDAO.getUserByLogin(userLogin);
                ShopDAO shopDAO = new ShopDAO();
                OnlineShop shop = shopDAO.getEntityById(user.getShopId());
                shop.setProfit(shop.getProfit() + cost);
                shopDAO.updateShop(shop);
            } else
                request.setAttribute("errorPayment", MessageManager.getProperty("message.buyerror"));
            page = ConfigurationManager.getProperty("path.page.showOrder");
        } catch (SQLException e) {
            System.out.println("error");
        }
        return page;
    }
}
