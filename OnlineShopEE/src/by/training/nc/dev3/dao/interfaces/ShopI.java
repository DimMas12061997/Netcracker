package by.training.nc.dev3.dao.interfaces;

import by.training.nc.dev3.beans.OnlineShop;

import java.sql.SQLException;

public interface ShopI {
    void updateShop(OnlineShop shop) throws SQLException;
}
