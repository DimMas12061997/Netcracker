package by.training.nc.dev3.command.user;

import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.GoodsOrderDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.filter.ClientType;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(Parameters.LOGIN);
        String pass = request.getParameter(Parameters.PASSWORD);
        HttpSession session = request.getSession(true);
        UserDAO userDAO = new UserDAO();
        try {
            if (userDAO.isAuthorized(login, pass)) {
                String role = userDAO.checkRole(login, pass);
                Order order = new OrderDAO().getOrderByIdUser(userDAO.getUserIdByName(login));
                session.setAttribute("goodsOrder", new GoodsOrderDAO().countNumber(order.getOrderId()));
                if (role.equals("admin")) {
                    request.setAttribute("user", login);
                    session.setAttribute("userType", ClientType.ADMINISTRATOR);
                    session.setAttribute("user", login);
                    page = ConfigurationManager.getProperty("path.page.main");
                } else if (role.equals("customer")) {
                    request.setAttribute("user", login);
                    session.setAttribute("userType", ClientType.CUSTOMER);
                    session.setAttribute("user", login);
                    page = ConfigurationManager.getProperty("path.page.user");
                }
                if (order.getOrderId() != 0)
                    if (order.getStatus())
                        session.setAttribute("goodsOrder", 0);
//                GoodsOrder goodsOrder = new GoodsOrder();
//                goodsOrder.setIdOrder(order.getOrderId());
//                session.setAttribute("goodsOrder", new GoodsOrderDAO().countNumber(goodsOrder.getIdOrder()));
            } else {
                request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } catch (SQLException e) {
            System.out.println("err");
        }
        return page;
    }
}
