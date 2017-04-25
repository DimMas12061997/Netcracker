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

public class UpdateCategoryCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String categoryId = request.getParameter(Parameters.CATEGORY_ID);
            String categoryName = request.getParameter(Parameters.CATEGORY_NAME);
            int id = Integer.parseInt(categoryId);
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = new Category();
            category.setIdCategory(id);
            category.setCategoryName(categoryName);
            categoryDAO.updateCategory(category);
            session.setAttribute(Parameters.CATEGORY_LIST, categoryDAO.findAll());
            GoodsDAO goodsDAO = new GoodsDAO();
            List<Goods> goods = goodsDAO.findAll();
            session.setAttribute(Parameters.GOODS_LIST, goods);
            page = ConfigurationManager.getProperty("path.page.showManagement");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}