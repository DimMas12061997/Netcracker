package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.ShopDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowPurchaseHistoryCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            List<Order> orderList = new OrderDAO().getOrderCostsById();
            UserDAO userDAO = new UserDAO();
            String userLogin = (String) session.getAttribute("user");
            ShopDAO shopDAO = new ShopDAO();
            User user = userDAO.getUserByLogin(userLogin);
            OnlineShop shop = shopDAO.getEntityById(user.getShopId());
            session.setAttribute("shopProfit", shop.getProfit());
            session.setAttribute(Parameters.ORDER_LIST_PURCHASE, orderList);
            page = ConfigurationManager.getProperty("path.page.purchaseHistory");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}

