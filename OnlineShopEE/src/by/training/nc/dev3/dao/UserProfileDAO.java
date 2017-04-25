package by.training.nc.dev3.dao;

import by.training.nc.dev3.beans.UserProfile;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;
import by.training.nc.dev3.dao.interfaces.AbstractDAO;
import by.training.nc.dev3.dao.interfaces.UserProfileI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserProfileDAO implements AbstractDAO<UserProfile>, UserProfileI {

    @Override
    public List<UserProfile> findAll() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createEntity(UserProfile user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_USER_PROFILE);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getAddress());
        statement.setDouble(3, user.getBudget());
        statement.setString(4, user.getCreditCard());
        statement.setInt(5, user.getUserId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public UserProfile getEntityById(int id) throws SQLException {
        UserProfile user = null;
        try {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_USERPROFILE_BY_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new UserProfile();
                user.setId(result.getInt(ColumnNames.ID_PROFILE));
                user.setEmail(result.getString(ColumnNames.EMAIL));
                user.setAddress(result.getString(ColumnNames.ADDRESS));
                user.setBudget(result.getDouble(ColumnNames.BUDGET));
                user.setCreditCard(result.getString(ColumnNames.CREDIT_CARD_NUMBER));
                user.setUserId(result.getInt(ColumnNames.ID_USER));
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUserProfile(UserProfile user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_USER_PROFILE);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getAddress());
        statement.setDouble(3, user.getBudget());
        statement.setString(4, user.getCreditCard());
        statement.setInt(5, user.getUserId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }
}

