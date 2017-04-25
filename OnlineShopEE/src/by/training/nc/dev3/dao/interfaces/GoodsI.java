package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsI {
    List<Goods> findAllSortByPrice() throws SQLException;
    void createEntity(Goods entity) throws SQLException;
    void updateGoods(Goods goods) throws SQLException;
    Goods getGoodsByName(String name) throws SQLException;
    void updateNumberGoods(Goods goods) throws SQLException;
    List<Goods> getGoodsByCategoryIdSortByPrice(int id) throws SQLException;
    List<Goods> getGoodsByCategoryId(int id) throws SQLException;
    List<Goods> getAllGoodsByCategoryId(int id) throws SQLException;
    void removeGoodsByID(int id) throws SQLException;
}
