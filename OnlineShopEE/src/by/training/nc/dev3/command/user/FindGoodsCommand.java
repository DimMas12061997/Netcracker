package by.training.nc.dev3.command.user;


import by.training.nc.dev3.beans.Category;
import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.CategoryDAO;
import by.training.nc.dev3.dao.GoodsDAO;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

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
            session.setAttribute(Parameters.CATEGORY_NAME, category.getCategoryName());
            session.setAttribute(Parameters.GOODS_DESCRIPTION, goods);
            if (goods.getIdGoods() == 0) {
                LocaleManager.setBundle((Locale) session.getAttribute("locale"));
                session.setAttribute("notFound", new String((LocaleManager.getProperty("message.notFound").getBytes("ISO-8859-1")), "Cp1251"));
            } else if (session != null)
                session.removeAttribute("notFound");
            page = ConfigurationManager.getProperty("path.page.goodsDescription");
        } catch (SQLException e) {
            System.out.println("SQLException");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding exception");
        }
        return page;
    }
}
