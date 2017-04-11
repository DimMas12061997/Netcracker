package by.training.nc.dev3.dao;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class UserDAO implements AbstractDAO<User> {

    @Override
    public List<User> findAll() throws SQLException {

        return null;
    }

    public boolean isAuthorized(String login, String password) throws SQLException {
        boolean isLogIn = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_LOG_AND_PASS);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            isLogIn = true;
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isLogIn;
    }

    public User getUserByLogin(String login) throws SQLException{
        User user = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_BY_LOGIN);
        statement.setString(1, login);
        ResultSet result = statement.executeQuery();
        while(result.next()){
            user = new User();
            user.setUserId(result.getInt(ColumnNames.USER_ID));
            user.setFirstName(result.getString(ColumnNames.USER_FIRST_NAME));
            user.setLastName(result.getString(ColumnNames.USER_LAST_NAME));
            user.setLogin(result.getString(ColumnNames.USER_LOGIN));
            user.setPassword(result.getString(ColumnNames.USER_PASSWORD));
            user.setShopId(result.getInt(ColumnNames.SHOP_ID));
            user.setRoleId(result.getInt(ColumnNames.ROLE_ID));
            user.setCreatedDate(result.getString(ColumnNames.DATE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return user;
    }

    public String checkRole(String login, String password) throws SQLException {
        String role = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ROLE_NAME);
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            role = result.getString("role_name");
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return role;
    }

    public int getRoleIdByName() {
        int role_id = 0;
        try {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ID_ROLE);
            statement.setString(1, "customer");
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                role_id = result.getInt("role_id");
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role_id;
    }

    public int getUserIdByName(String name) {
        int user_id = 0;
        try {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USER_ID);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user_id = result.getInt("user_id");
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user_id;
    }

    public int getShopIdByName(String name) {
        int id_shop = 0;
        try {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ID_SHOP);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                id_shop = result.getInt("id_shop");
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id_shop;
    }

    public void updateUser(User user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_USER);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getLogin());
        statement.setString(4, user.getPassword());
        statement.setInt(5, user.getUserId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }


    @Override
    public void createEntity(User user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_CUTOMER);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getLogin());
        statement.setString(4, user.getPassword());
        statement.setInt(5, user.getRoleId());
        statement.setInt(6, user.getShopId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public User getEntityById(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
