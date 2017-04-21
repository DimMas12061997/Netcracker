package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.beans.Category;
import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.dao.CategoryDAO;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class AddCategoryCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            HttpSession session = request.getSession();
            String category_name = request.getParameter(Parameters.CATEGORY_NAME);
            CategoryDAO categoryDAO =  new CategoryDAO();
            Category category = new Category();
            category.setCategoryName(category_name);
            categoryDAO.createEntity(category);
            session.setAttribute(Parameters.CATEGORY_LIST, categoryDAO.findAll());
            page = ConfigurationManager.getProperty("path.page.showManagement");
        } catch (SQLException e) {
            System.out.println("SQLException");
        }
        return page;
    }
}