package by.training.nc.dev3.command.user;

import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.GoodsOrderDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.filter.ClientType;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Locale;

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
                session.setAttribute(Parameters.GOODS_ORDER, new GoodsOrderDAO().countNumber(order.getOrderId()));
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
                        session.setAttribute(Parameters.GOODS_ORDER, 0);
            } else {
                LocaleManager.setBundle((Locale) session.getAttribute("locale"));
                session.setAttribute("errorLoginPassMessage", new String((LocaleManager.getProperty("message.loginerror").getBytes("ISO-8859-1")), "Cp1251"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Encoding exception");
        }
        return page;
    }
}
