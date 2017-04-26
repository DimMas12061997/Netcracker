package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.beans.BlackList;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.*;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class AddBlackListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String userLogin = request.getParameter(Parameters.USER);
            String orderId = request.getParameter("orderId");
            int idOrder = Integer.parseInt(orderId);
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(userLogin);
            BlackListDAO blackListDAO = new BlackListDAO();
            BlackList blackList = new BlackList();
            blackList.setUserId(user.getUserId());
            blackListDAO.createEntity(blackList);
            OrderDAO orderDAO = new OrderDAO();
            Order order1 = orderDAO.getEntityById(idOrder);
            GoodsOrderDAO goodsOrderDAO = new GoodsOrderDAO();
            List<Goods> goodsList = goodsOrderDAO.getAllById(order1.getOrderId());
            GoodsDAO goodsDAO = new GoodsDAO();
            for(Goods goods : goodsList) {
                goods.setNumber(goods.getNumber() + goods.getShopId());
                goodsDAO.updateNumberGoods(goods);
            }
            orderDAO.removeOrderById(user.getUserId());
            List<Order> orderList = new OrderDAO().getOrdersById(0);
            session.setAttribute(Parameters.ORDER_LIST_PURCHASE, orderList);
            session.setAttribute(Parameters.BLACKLIST, blackListDAO.getAllUsers());
            page = ConfigurationManager.getProperty("path.page.blackList");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
