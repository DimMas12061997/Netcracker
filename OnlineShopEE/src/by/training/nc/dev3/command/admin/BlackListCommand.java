package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.BlackListDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class BlackListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            List<Order> orderList = new OrderDAO().getOrdersById(0);
            session.setAttribute(Parameters.ORDER_LIST, orderList);
            session.setAttribute(Parameters.BLACKLIST, new BlackListDAO().getAllUsers());
            page = ConfigurationManager.getProperty("path.page.blackList");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
