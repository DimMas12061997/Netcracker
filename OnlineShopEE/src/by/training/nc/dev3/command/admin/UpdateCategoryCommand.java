package by.training.nc.dev3.command.admin;


import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateCategoryCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
//        try {
            HttpSession session = request.getSession();
            String categoryId = request.getParameter(Parameters.CATEGORY_NAME);
        System.out.println("11 = " + categoryId);
            int id = Integer.parseInt(categoryId);
            System.out.println(id);
//            CategoryDAO categoryDAO =  new CategoryDAO();
//            categoryDAO.removeCategoryByID(id);
//            session.setAttribute(Parameters.CATEGORY_LIST, categoryDAO.findAll());
//            GoodsDAO goodsDAO = new GoodsDAO();
//            List<Goods> goods = goodsDAO.findAll();
//            session.setAttribute(Parameters.GOODS_LIST, goods);
            page = ConfigurationManager.getProperty("path.page.showManagement");
//        } catch (SQLException e) {
//            System.out.println("SQLException");
//        }
        return page;
    }
}