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

public class UpdateOrderCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String idString = request.getParameter("idOrder");
            int id = Integer.parseInt(idString);
            String cost = request.getParameter("unitPrice");
            double price = Double.parseDouble(cost);
            String number = request.getParameter("number");
            int num = Integer.parseInt(number);
            String numberGoods = request.getParameter("numberGoods");
            int numGoods = Integer.parseInt(numberGoods);
            GoodsDAO goodsDAO = new GoodsDAO();
            Goods goods = goodsDAO.getEntityById(id);
            int numb = num - numGoods;
            goods.setNumber(goods.getNumber() - numb);
            goodsDAO.updateNumberGoods(goods);
            double cost1 = num * price;
            double cost2 = numGoods * price;
            double general_cost = cost1 - cost2;
            OrderDAO orderDAO = new OrderDAO();
            String userLogin = (String) session.getAttribute("user");
            Order order = orderDAO.getOrderByIdUser(new UserDAO().getUserIdByName(userLogin));
            order.setOrderCost(order.getOrderCost() + general_cost);
            orderDAO.updateOrder(order);
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setIdOrder(order.getOrderId());
            goodsOrder.setIdGoods(id);
            goodsOrder.setNumber(num);
            GoodsOrderDAO goodsOrderDAO = new GoodsOrderDAO();
            goodsOrderDAO.updateNumber(goodsOrder);
            List<Goods> products = new GoodsOrderDAO().getAllById(order.getOrderId());
            session.setAttribute(Parameters.ORDER_LIST, products);
            session.setAttribute(Parameters.ORDER_COST, order.getOrderCost());
            session.setAttribute("goodsOrder", new GoodsOrderDAO().countNumber(goodsOrder.getIdOrder()));
            page = ConfigurationManager.getProperty("path.page.showOrder");
        } catch (SQLException e) {
            System.out.println("error");
        }
        return page;
    }
}

