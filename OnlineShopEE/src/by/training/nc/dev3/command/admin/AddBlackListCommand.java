package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.beans.BlackList;
import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.BlackListDAO;
import by.training.nc.dev3.dao.OrderDAO;
import by.training.nc.dev3.dao.UserDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AddBlackListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String userLogin = request.getParameter(Parameters.USER);
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUserByLogin(userLogin);
            BlackListDAO blackListDAO = new BlackListDAO();
            BlackList blackList = new BlackList();
            blackList.setUserId(user.getUserId());
            blackListDAO.createEntity(blackList);
            OrderDAO orderDAO = new OrderDAO();
            Order order1 = orderDAO.getOrderByIdUser(user.getUserId());
            order1.setStatus(true);
            orderDAO.updateOrderStatus(order1);
            session.setAttribute(Parameters.BLACKLIST, blackListDAO.getAllUsers());
            page = ConfigurationManager.getProperty("path.page.blackList");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
