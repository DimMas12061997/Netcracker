package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.Goods;
import by.training.nc.dev3.beans.GoodsOrder;

import java.sql.SQLException;
import java.util.List;

public interface GoodsOrderI {
    void removeEntity(int id) throws SQLException;
    void updateNumber(GoodsOrder goodsOrder) throws SQLException;
    int countNumber(int orderId) throws SQLException;
    List<Goods> getAllById(int id) throws SQLException;
}
