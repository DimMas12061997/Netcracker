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

public class AddGoodsCommand implements ActionCommand {
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
            goods_name = request.getParameter(Parameters.NAME_GOODS);
            String goods_number = request.getParameter(Parameters.GOODS_NUMBER);
            number = Integer.parseInt(goods_number);
            String goods_price = request.getParameter(Parameters.GOODS_PRICE);
            price = Double.parseDouble(goods_price);
            goods_producer = request.getParameter(Parameters.GOODS_PRODUCER);
            goods_description = request.getParameter(Parameters.GOODS_DESCRIPTION);
            category_name = request.getParameter(Parameters.CATEGORY_NAME);
            GoodsDAO goodsDAO = new GoodsDAO();
            createGoods(goodsDAO);
            session.setAttribute(Parameters.GOODS_LIST, goodsDAO.findAll());
            page = ConfigurationManager.getProperty("path.page.showManagement");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }

    public void createGoods(GoodsDAO goodsDAO) throws SQLException {
        Goods goods = new Goods();
        Category category = new CategoryDAO().getEntityByName(category_name);
        goods.setName(goods_name);
        goods.setNumber(number);
        goods.setUnitPrice(price);
        goods.setProducer(goods_producer);
        goods.setDescription(goods_description);
        goods.setShopId(1);
        goods.setCategoryId(category.getIdCategory());
        System.out.println(goods);
        goodsDAO.createEntity(goods);
    }
}
