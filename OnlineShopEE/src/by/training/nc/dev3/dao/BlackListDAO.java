package by.training.nc.dev3.dao;


import by.training.nc.dev3.beans.BlackList;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlackListDAO implements AbstractDAO<BlackList> {
    @Override
    public List<BlackList> findAll() throws SQLException {
        return null;
    }

    @Override
    public void createEntity(BlackList entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_USER_BLACK_LIST);
        statement.setInt(1, entity.getUserId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public BlackList getEntityById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_BLACKLIST_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        BlackList blackList = new BlackList();
        while(result.next()){
            blackList.setIdBlackList(result.getInt(ColumnNames.BLACKLIST_ID));
            blackList.setUserId(result.getInt(ColumnNames.USER_ID));
            blackList.setCreatedDate(result.getString(ColumnNames.DATE));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return blackList;
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_USER_IN_BLACK_LIST);
        ResultSet result = statement.executeQuery();
        List<User> list = new ArrayList<>();
        while (result.next()) {
            User user = new User();
            user.setFirstName(result.getString(ColumnNames.USER_FIRST_NAME));
            user.setLastName(result.getString(ColumnNames.USER_LAST_NAME));
            user.setLogin(result.getString(ColumnNames.USER_LOGIN));
            list.add(user);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }
}
