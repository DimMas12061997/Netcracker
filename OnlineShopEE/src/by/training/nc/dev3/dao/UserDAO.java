package by.training.nc.dev3.dao;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.connectionpool.ConnectionPool;
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
        PreparedStatement statement = connection.prepareStatement("SELECT login, password FROM user WHERE login = ? AND password = ?");
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            isLogIn = true;
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isLogIn;
    }

    public String checkRole(String login, String password) throws SQLException {
        String role = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT role_name FROM user u INNER JOIN online_shop.role r ON u.role_id = r.role_id WHERE login = ? AND password = ?");
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
