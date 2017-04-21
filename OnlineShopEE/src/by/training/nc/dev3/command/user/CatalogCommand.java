package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.Category;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.CategoryDAO;
import by.training.nc.dev3.dao.GoodsDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CatalogCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> list = categoryDAO.findAll();
            List<Goods> goodsList = new GoodsDAO().findAll();
            session.setAttribute(Parameters.GOODS_LIST, goodsList);
            session.setAttribute(Parameters.CATEGORY_LIST, list);
            session.setAttribute(Parameters.CATEGORY_ID, 0);
            page = ConfigurationManager.getProperty("path.page.catalog");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
