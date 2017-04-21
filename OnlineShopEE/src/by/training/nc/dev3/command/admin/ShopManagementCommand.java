package by.training.nc.dev3.command.admin;


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

public class ShopManagementCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String categoryId = request.getParameter(Parameters.CATEGORY_ID);
            List<Goods> goods = null;
            GoodsDAO goodsDAO = new GoodsDAO();
            if (categoryId == null)
               goods = goodsDAO.findAll();
            else {
                int id = Integer.parseInt(categoryId);
                goods = goodsDAO.getAllGoodsByCategoryId(id);
            }
            List<Category> categoryList = new CategoryDAO().findAll();
            session.setAttribute(Parameters.CATEGORY_LIST, categoryList);
            session.setAttribute(Parameters.GOODS_LIST, goods);
            page = ConfigurationManager.getProperty("path.page.showManagement");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}

