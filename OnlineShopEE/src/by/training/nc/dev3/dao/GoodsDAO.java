package by.training.nc.dev3.dao;

import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GoodsDAO implements AbstractDAO<Goods> {
    @Override
    public List<Goods> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_GOODS);
        ResultSet result = statement.executeQuery();
        List<Goods> list = new ArrayList<>();
        while(result.next()){
            Goods goods = new Goods();
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.CATEGORY_NAME));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
            list.add(goods);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }
    public List<Goods> findAllSortByPrice() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_GOODS_SORT_BY_PRICE);
        ResultSet result = statement.executeQuery();
        List<Goods> list = new ArrayList<>();
        while(result.next()){
            Goods goods = new Goods();
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.CATEGORY_NAME));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
            list.add(goods);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }
    @Override
    public void createEntity(Goods entity) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_GOODS);
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getNumber());
        statement.setDouble(3, entity.getUnitPrice());
        statement.setString(4, entity.getProducer());
        statement.setString(5, entity.getDescription());
        statement.setInt(6, entity.getShopId());
        statement.setInt(7, entity.getCategoryId());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Goods getEntityById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_GOODS_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        Goods goods = new Goods();
        while(result.next()){
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.DATE));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return goods;
    }

    public Goods getGoodsByName(String name) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_GOODS_BY_NAME);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        Goods goods = new Goods();
        while(result.next()){
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.DATE));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return goods;
    }

    public void updateNumberGoods(Goods goods) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_NUMBER_GOODS);
        statement.setInt(1, goods.getNumber());
        statement.setString(2, goods.getName());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public List<Goods> getGoodsByCategoryIdSortByPrice(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_GOODS_BY_CATEGORY_ID_SORT_BY_PRICE);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        List<Goods> list = new ArrayList<>();
        while(result.next()){
            Goods goods = new Goods();
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.DATE));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
            list.add(goods);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }


    public List<Goods> getGoodsByCategoryId(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_GOODS_BY_CATEGORY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        List<Goods> list = new ArrayList<>();
        while(result.next()){
            Goods goods = new Goods();
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.DATE));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
            list.add(goods);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    public List<Goods> getAllGoodsByCategoryId(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_GOODS_BY_CATEGORY_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        List<Goods> list = new ArrayList<>();
        while(result.next()){
            Goods goods = new Goods();
            goods.setIdGoods(result.getInt(ColumnNames.GOODS_ID));
            goods.setName(result.getString(ColumnNames.GOODS_NAME));
            goods.setNumber(result.getInt(ColumnNames.GOODS_NUMBER));
            goods.setUnitPrice(result.getDouble(ColumnNames.GOODS_PRICE));
            goods.setProducer(result.getString(ColumnNames.GOODS_PRODUCER));
            goods.setDescription(result.getString(ColumnNames.GOODS_DESCRIPTION));
            goods.setCreatedDate(result.getString(ColumnNames.CATEGORY_NAME));
            goods.setShopId(result.getInt(ColumnNames.SHOP_ID));
            goods.setCategoryId(result.getInt(ColumnNames.GOODS_CATEGORY_ID));
            list.add(goods);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    public void removeGoodsByID(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.REMOVE_GOODS);
        statement.setInt(1, id);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }
}
