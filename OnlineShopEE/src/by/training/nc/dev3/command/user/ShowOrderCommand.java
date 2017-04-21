package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.BlackList;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.BlackListDAO;
import by.training.nc.dev3.dao.GoodsOrderDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class ShowOrderCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String login = String.valueOf(session.getAttribute("user"));
            Order order = new OrderDAO().getOrderByIdUser(new UserDAO().getUserIdByName(login));

            BlackListDAO blackListDAO = new BlackListDAO();
            int idUser = new UserDAO().getUserIdByName(login);
            BlackList blackList = blackListDAO.getEntityById(idUser);
            if (blackList.getUserId() != 0)
                request.setAttribute("userBlackList", MessageManager.getProperty("message.userBlackList"));
            if (order.getOrderId() != 0) {
                List<Goods> goods = null;
                if (order.getStatus() == false) {
                    goods = new GoodsOrderDAO().getAllById(order.getOrderId());
                    session.setAttribute(Parameters.ORDER_LIST, goods);
                    session.setAttribute(Parameters.ORDER_COST, order.getOrderCost());
                }
                else {
                    session.setAttribute(Parameters.ORDER_COST, 0);
                    session.setAttribute("goodsOrder", 0);
                }
            }
            page = ConfigurationManager.getProperty("path.page.showOrder");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
