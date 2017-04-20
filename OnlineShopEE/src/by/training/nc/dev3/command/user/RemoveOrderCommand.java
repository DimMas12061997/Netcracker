package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.GoodsOrder;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.GoodsDAO;
import by.training.nc.dev3.dao.GoodsOrderDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class RemoveOrderCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            session.setAttribute("idOrder", request.getParameter("idOrder"));
            String idString = String.valueOf(session.getAttribute("idOrder"));
            int id = Integer.parseInt(idString);
            session.setAttribute("cost", request.getParameter("cost"));
            String cost = String.valueOf(session.getAttribute("cost"));
            double price = Double.parseDouble(cost);
            session.setAttribute("number", request.getParameter("number"));
            String number = String.valueOf(session.getAttribute("number"));
            int num = Integer.parseInt(number);
            GoodsOrderDAO goodsOrderDAO = new GoodsOrderDAO();
            goodsOrderDAO.removeEntity(id);
            OrderDAO orderDAO = new OrderDAO();
            String userLogin = (String) session.getAttribute("user");
            Order order = orderDAO.getOrderByIdUser(new UserDAO().getUserIdByName(userLogin));
            order.setOrderCost(order.getOrderCost() - price);
            orderDAO.updateOrder(order);
            GoodsDAO goodsDAO = new GoodsDAO();
            Goods goods = goodsDAO.getEntityById(id);
            goods.setNumber(goods.getNumber() + num);
            goodsDAO.updateNumberGoods(goods);
            List<Goods> products = new GoodsOrderDAO().getAllById(order.getOrderId());
            session.setAttribute(Parameters.ORDER_LIST, products);
            session.setAttribute(Parameters.ORDER_COST, order.getOrderCost());
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setIdOrder(order.getOrderId());
            session.setAttribute("goodsOrder", new GoodsOrderDAO().countNumber(goodsOrder.getIdOrder()));
            page = ConfigurationManager.getProperty("path.page.showOrder");
        } catch (SQLException e) {
            System.out.println("error");
        }
        return page;
    }
}
