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

public class ShowDescriptionCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            session.setAttribute("idGoods", request.getParameter("idGoods"));
            String idString = String.valueOf(session.getAttribute("idGoods"));
            int id = Integer.parseInt(idString);
            GoodsDAO goodsDAO = new GoodsDAO();
            Goods goods = goodsDAO.getEntityById(id);
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = categoryDAO.getEntityById(goods.getCategoryId());
            session.setAttribute(Parameters.GOODS_DESCRIPTION, goods);
            session.setAttribute(Parameters.CATEGORY_NAME, category.getCategoryName());
            page = ConfigurationManager.getProperty("path.page.goodsDescription");
        } catch (SQLException e) {
            System.out.println("error");
        }
        return page;
    }
}