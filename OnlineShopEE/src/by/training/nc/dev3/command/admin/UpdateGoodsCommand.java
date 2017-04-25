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

public class UpdateGoodsCommand implements ActionCommand {
    private static int goods_id;
    private static String goods_name;
    private static int number;
    private static double price;
    private static String goods_producer;
    private static String goods_description;
    private static String category_name;

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String goodsId = request.getParameter(Parameters.ID_GOODS);
            goods_id = Integer.parseInt(goodsId);
            goods_name = request.getParameter(Parameters.NAME_GOODS);
            String goodsNumber = request.getParameter(Parameters.GOODS_NUMBER);
            number = Integer.parseInt(goodsNumber);
            String goodsPrice = request.getParameter(Parameters.GOODS_PRICE);
            price = Double.parseDouble(goodsPrice);
            goods_producer = request.getParameter(Parameters.GOODS_PRODUCER);
            goods_description = request.getParameter(Parameters.GOODS_DESCRIPTION);
            category_name = request.getParameter(Parameters.CATEGORY_NAME);
            GoodsDAO goodsDAO = new GoodsDAO();
            updateGoods(goodsDAO);
            List<Goods> goods = goodsDAO.findAll();
            session.setAttribute(Parameters.GOODS_LIST, goods);
            page = ConfigurationManager.getProperty("path.page.showManagement");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }

    public void updateGoods(GoodsDAO goodsDAO) throws SQLException {
        Goods goods = new Goods();
        Category category = new CategoryDAO().getEntityByName(category_name);
        goods.setIdGoods(goods_id);
        goods.setName(goods_name);
        goods.setNumber(number);
        goods.setUnitPrice(price);
        goods.setProducer(goods_producer);
        goods.setDescription(goods_description);
        goods.setShopId(1);
        goods.setCategoryId(category.getIdCategory());
        goodsDAO.updateGoods(goods);
    }
}
