package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

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
                Order order1 = orderDAO.getOrderByIdUser(idUser);
                order1.setStatus(true);
                orderDAO.updateOrderStatus(order1);
                userProfile.setBudget(userProfile.getBudget() - cost);
                userProfileDAO.updateUserProfile(userProfile);
                User user = userDAO.getUserByLogin(userLogin);
                ShopDAO shopDAO = new ShopDAO();
                OnlineShop shop = shopDAO.getEntityById(user.getShopId());
                shop.setProfit(shop.getProfit() + cost);
                shopDAO.updateShop(shop);
                Order order = orderDAO.getOrderByIdUser(new UserDAO().getUserIdByName(userLogin));
                List<Goods> goods = null;
                if (order.getStatus() == false) {
                    goods = new GoodsOrderDAO().getAllById(order.getOrderId());
                    session.setAttribute(Parameters.ORDER_COST, order.getOrderCost());
                    session.setAttribute(Parameters.ORDER_LIST, goods);
                } else {
                    session.setAttribute(Parameters.GOODS_ORDER, 0);
                    session.setAttribute(Parameters.ORDER_COST, 0);
                    session.setAttribute(Parameters.ORDER_LIST, null);
                }
            } else{
                LocaleManager.setBundle((Locale) session.getAttribute("locale"));
                session.setAttribute("errorPayment", new String((LocaleManager.getProperty("message.buyerror").getBytes("ISO-8859-1")), "Cp1251"));
            }
            page = ConfigurationManager.getProperty("path.page.showOrder");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Encoding exception");
        }
        return page;
    }
}
