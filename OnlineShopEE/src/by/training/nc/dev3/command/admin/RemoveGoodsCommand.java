package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.GoodsDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class RemoveGoodsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String categoryId = request.getParameter(Parameters.ID_GOODS);
            int id = Integer.parseInt(categoryId);
            GoodsDAO goodsDAO =  new GoodsDAO();
            goodsDAO.removeGoodsByID(id);
            session.setAttribute(Parameters.GOODS_LIST, goodsDAO.findAll());
            page = ConfigurationManager.getProperty("path.page.showManagement");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
