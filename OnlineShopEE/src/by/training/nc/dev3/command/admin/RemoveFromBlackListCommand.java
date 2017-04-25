package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.BlackListDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RemoveFromBlackListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String userId = request.getParameter(Parameters.USER_ID);
            int id = Integer.parseInt(userId);
            BlackListDAO blackListDAO =  new BlackListDAO();
            blackListDAO.removeByUserId(id);
            session.setAttribute(Parameters.BLACKLIST, blackListDAO.getAllUsers());
            page = ConfigurationManager.getProperty("path.page.blackList");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
