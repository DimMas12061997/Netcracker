package by.training.nc.dev3.dao;


import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.GoodsOrder;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsOrderDAO implements AbstractDAO<GoodsOrder> {
    @Override
    public List<GoodsOrder> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_GOODS_ORDER);
        ResultSet result = statement.executeQuery();
        List<GoodsOrder> list = new ArrayList<>();
        while (result.next()) {
            GoodsOrder goodsOrder = new GoodsOrder();
            goodsOrder.setIdOrder(result.getInt(ColumnNames.ID_ORDER));
            goodsOrder.setIdGoods(result.getInt(ColumnNames.ID_GOODS));
            goodsOrder.setNumber(result.getInt(ColumnNames.NUMBER));
            list.add(goodsOrder);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    public void removeEntity(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.REMOVE_ORDER_BY_ID);
        statement.setInt(1, id);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public void createEntity(GoodsOrder entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_GOODS_ORDER);
        statement.setInt(1, entity.getIdOrder());
        statement.setInt(2, entity.getIdGoods());
        statement.setInt(3, entity.getNumber());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public GoodsOrder getEntityById(int id) throws SQLException {
        return null;
    }

    public void updateNumber(GoodsOrder goodsOrder) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_NUMBER_GOODS_ORDER);
        statement.setInt(1, goodsOrder.getNumber());
        statement.setInt(2, goodsOrder.getIdOrder());
        statement.setInt(3, goodsOrder.getIdGoods());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public int countNumber(int orderId) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_COUNT_NUMBER);
        statement.setInt(1, orderId);
        ResultSet result = statement.executeQuery();
        int count = 0;
        while (result.next()) {
            count = result.getInt(ColumnNames.SUM_NUMBER);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return count;
    }

    public List<Goods> getAllById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_GOODS_ORDER_BY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        List<Goods> list = new ArrayList<>();
        while (result.next()) {
            Goods goods = new Goods();
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setShopId(result.getInt(ColumnNames.NUMBER));
            list.add(goods);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }
}
