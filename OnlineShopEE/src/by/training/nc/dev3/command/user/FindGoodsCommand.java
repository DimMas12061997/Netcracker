package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.Category;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.CategoryDAO;
import by.training.nc.dev3.dao.GoodsDAO;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class FindGoodsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String name = request.getParameter("find");
            GoodsDAO goodsDAO = new GoodsDAO();
            Goods goods = goodsDAO.getGoodsByName(name);
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = categoryDAO.getEntityById(goods.getCategoryId());
            List<Category> list = categoryDAO.findAll();
            session.setAttribute(Parameters.CATEGORY_LIST, list);
            System.out.println(goods);
            session.setAttribute(Parameters.CATEGORY_NAME, category.getCategoryName());
            session.setAttribute(Parameters.GOODS_DESCRIPTION, goods);
            if (goods.getIdGoods() == 0)
                request.setAttribute("notFound", MessageManager.getProperty("message.notFound"));
            page = ConfigurationManager.getProperty("path.page.goodsDescription");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}
