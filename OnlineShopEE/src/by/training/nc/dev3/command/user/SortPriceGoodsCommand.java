package by.training.nc.dev3.command.user;

import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.GoodsDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class SortPriceGoodsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            session.setAttribute("id", request.getParameter("id"));
            String idString = String.valueOf(session.getAttribute("id"));
            int id = Integer.parseInt(idString);
            GoodsDAO goodsDAO = new GoodsDAO();
            List<Goods> list = null;
            if (id != 0)
                list = goodsDAO.getGoodsByCategoryIdSortByPrice(id);
            else
                list = goodsDAO.findAllSortByPrice();
            session.setAttribute(Parameters.GOODS_LIST, list);
            page = ConfigurationManager.getProperty("path.page.catalog");
        } catch (SQLException e) {
            System.out.println("error");
        }
        return page;
    }
}
