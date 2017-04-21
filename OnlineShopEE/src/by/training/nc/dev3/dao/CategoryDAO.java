package by.training.nc.dev3.dao;

import by.training.nc.dev3.beans.Category;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAO implements AbstractDAO<Category> {
    @Override
    public List<Category> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_CATEGORIES);
        ResultSet result = statement.executeQuery();
        List<Category> list = new ArrayList<>();
        while(result.next()){
            Category category = new Category();
            category.setIdCategory(result.getInt(ColumnNames.CATEGORY_ID));
            category.setCategoryName(result.getString(ColumnNames.CATEGORY_NAME));
            list.add(category);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public void createEntity(Category entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_CATEGORY);
        statement.setString(1, entity.getCategoryName());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Category getEntityById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_GATEGORY_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        Category category = new Category();
        while(result.next()){
            category.setIdCategory(result.getInt(ColumnNames.CATEGORY_ID));
            category.setCategoryName(result.getString(ColumnNames.CATEGORY_NAME));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return category;
    }

    public Category getEntityByName(String name) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_GATEGORY_BY_NAME);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        Category category = new Category();
        while(result.next()){
            category.setIdCategory(result.getInt(ColumnNames.CATEGORY_ID));
            category.setCategoryName(result.getString(ColumnNames.CATEGORY_NAME));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return category;
    }

    public void removeCategoryByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.REMOVE_CATEGORY);
        statement.setInt(1, id);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }
}
