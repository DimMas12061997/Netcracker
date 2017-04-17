package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.GoodsOrderDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

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
            List<Goods> goods = new GoodsOrderDAO().getAllById(order.getOrderId());
            session.setAttribute(Parameters.ORDER_LIST, goods);
            session.setAttribute(Parameters.ORDER_COST, order.getOrderCost());
            page = ConfigurationManager.getProperty("path.page.showOrder");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
