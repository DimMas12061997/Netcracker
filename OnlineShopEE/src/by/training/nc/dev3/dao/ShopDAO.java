package by.training.nc.dev3.dao;


import by.training.nc.dev3.beans.OnlineShop;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ShopDAO implements AbstractDAO<OnlineShop>{
    @Override
    public List<OnlineShop> findAll() throws SQLException {
        return null;
    }

    @Override
    public void createEntity(OnlineShop entity) throws SQLException {

    }

    @Override
    public OnlineShop getEntityById(int id) throws SQLException {
        OnlineShop shop = null;
        try {
            Connection connection = ConnectionPool.INSTANCE.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_SHOP_BY_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                shop = new OnlineShop();
                shop.setId_shop(result.getInt(ColumnNames.ID_SHOP));
                shop.setName(result.getString(ColumnNames.NAME_SHOP));
                shop.setProfit(result.getDouble(ColumnNames.PROFIT_SHOP));
                shop.setDescription(result.getString(ColumnNames.DESCRIPTION_SHOP));
            }
            ConnectionPool.INSTANCE.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }

    public void updateShop(OnlineShop shop) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_SHOP);
        statement.setDouble(1, shop.getProfit());
        statement.setInt(2, shop.getId_shop());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

}
