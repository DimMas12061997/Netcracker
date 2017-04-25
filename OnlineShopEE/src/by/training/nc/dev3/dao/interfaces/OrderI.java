package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderI {
    List<Order> getOrdersById(int id) throws SQLException;
    Order getOrderByIdUser(int userId) throws SQLException;
    void updateOrder(Order order) throws SQLException;
    void updateOrderStatus(Order order) throws SQLException;
    void removeOrderById(int id) throws SQLException;
    Boolean isCreated(int userId) throws SQLException;
}
