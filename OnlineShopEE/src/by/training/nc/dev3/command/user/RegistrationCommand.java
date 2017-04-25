package by.training.nc.dev3.command.user;

import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.beans.User;
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

public class RegistrationCommand implements ActionCommand {
    private static String firstName;
    private static String lastName;
    private static String login;
    private static String password;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        firstName = request.getParameter(Parameters.FIRST_NAME);
        lastName = request.getParameter(Parameters.LAST_NAME);
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        HttpSession session = request.getSession(true);
        try {
            registrate();
            request.setAttribute("user", login);
            Order order = new OrderDAO().getOrderByIdUser(new UserDAO().getUserIdByName(login));
            session.setAttribute("goodsOrder", new GoodsOrderDAO().countNumber(order.getOrderId()));
            session.setAttribute("userType", ClientType.CUSTOMER);
            session.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.user");
        } catch (SQLException e) {
            try {
                LocaleManager.setBundle((Locale) session.getAttribute("locale"));
                session.setAttribute("errorLoginPassMessage", new String((LocaleManager.getProperty("message.regerror").getBytes("ISO-8859-1")), "Cp1251"));
            } catch (UnsupportedEncodingException e1) {
                System.out.println("Encoding exception");
            }
            request.getSession().setAttribute("userType", ClientType.GUEST);
            page = ConfigurationManager.getProperty("path.page.registration");
        }
        return page;
    }

    private void registrate() throws SQLException {
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setRoleId(dao.getRoleIdByName());
        user.setShopId(dao.getShopIdByName(new OnlineShop().getName()));
        dao.createEntity(user);
    }
}
