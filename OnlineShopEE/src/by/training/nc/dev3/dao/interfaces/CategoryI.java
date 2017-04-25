package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.Category;

import java.sql.SQLException;

public interface CategoryI {
    Category getEntityByName(String name) throws SQLException;
    void updateCategory(Category category) throws SQLException;
    void removeCategoryByID(int id) throws SQLException;
}
