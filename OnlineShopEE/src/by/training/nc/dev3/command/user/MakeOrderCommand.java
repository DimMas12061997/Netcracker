package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.BlackList;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.GoodsOrder;
import by.training.nc.dev3.beans.Order;
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

public class MakeOrderCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        int id = Integer.parseInt(request.getParameter(Parameters.ID_GOODS));
        int number = Integer.parseInt(request.getParameter(Parameters.NUMBER));
        String name = request.getParameter(Parameters.GOODS_NAME);
        double price = Double.parseDouble(request.getParameter(Parameters.UNIT_PRICE));
        HttpSession session = request.getSession(true);
        String userLogin = (String) session.getAttribute("user");
        BlackListDAO blackListDAO = new BlackListDAO();
        BlackList blackList = new BlackList();
        try {
            GoodsDAO goodsDAO = new GoodsDAO();
            int idUser = new UserDAO().getUserIdByName(userLogin);
            blackList = blackListDAO.getEntityById(idUser);
            if (blackList.getUserId() == 0) {
                Goods goods = goodsDAO.getGoodsByName(name);
                goods.setNumber(goods.getNumber() - number);
                goodsDAO.updateNumberGoods(goods);
                createOrder(price, number, userLogin, id, session);
                goods = goodsDAO.getEntityById(id);
                session.setAttribute(Parameters.GOODS_DESCRIPTION, goods);
            } else{
                LocaleManager.setBundle((Locale) session.getAttribute("locale"));
                session.setAttribute("userBlackList", new String((LocaleManager.getProperty("message.userBlackList").getBytes("ISO-8859-1")), "Cp1251"));
            }
        } catch (SQLException e) {
            System.out.println("SQL exception");
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Encoding exception");
        }
        page = ConfigurationManager.getProperty("path.page.goodsDescription");
        return page;
    }


    public void createOrder(double price, int number, String userLogin, int id, HttpSession session) {
        Order order = new Order();
        order.setOrderCost(number * price);
        double totalPrice = number * price;
        order.setIdUser(new UserDAO().getUserIdByName(userLogin));
        OrderDAO orderDAO = new OrderDAO();
        try {
            if (orderDAO.isCreated(order.getIdUser())) {
                order = orderDAO.getOrderByIdUser(order.getIdUser());
                order.setOrderCost(order.getOrderCost() + totalPrice);
                orderDAO.updateOrder(order);
            } else
                orderDAO.createEntity(order);
            order = orderDAO.getOrderByIdUser(order.getIdUser());
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setIdOrder(order.getOrderId());
            goodsOrder.setIdGoods(id);
            goodsOrder.setNumber(number);
            GoodsOrderDAO goodsOrderDAO = new GoodsOrderDAO();
            List<GoodsOrder> list = goodsOrderDAO.findAll();
            int flag = 0;
            for (GoodsOrder goods : list) {
                if (goods.getIdGoods() == goodsOrder.getIdGoods() && goods.getIdOrder() == goodsOrder.getIdOrder()) {
                    goodsOrder.setNumber(goodsOrder.getNumber() + goods.getNumber());
                    flag++;
                }
            }
            if (flag == 0)
                goodsOrderDAO.createEntity(goodsOrder);
            else
                goodsOrderDAO.updateNumber(goodsOrder);
            session.setAttribute("goodsOrder", new GoodsOrderDAO().countNumber(goodsOrder.getIdOrder()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
