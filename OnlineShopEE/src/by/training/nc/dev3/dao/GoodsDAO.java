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
        throw new UnsupportedOperationException();
    }

    @Override
    public void createEntity(Goods entity) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Goods getEntityById(int id) throws SQLException {
        throw new UnsupportedOperationException();
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
}
