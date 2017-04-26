package by.training.nc.dev3.dao;


import by.training.nc.dev3.beans.Order;
import by.training.nc.dev3.connectionpool.ConnectionPool;
import by.training.nc.dev3.constants.ColumnNames;
import by.training.nc.dev3.constants.SqlRequests;
import by.training.nc.dev3.dao.interfaces.AbstractDAO;
import by.training.nc.dev3.dao.interfaces.OrderI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements AbstractDAO<Order>, OrderI {

    public List<Order> getOrdersById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_ORDERS);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        List<Order> list = new ArrayList<>();
        while(result.next()){
            Order order = new Order();
            order.setOrderId(result.getInt(ColumnNames.ORDER_ID));
            order.setOrderCost(result.getDouble(ColumnNames.ORDER_COST));
            order.setCreatedDate(result.getString(ColumnNames.USER_LOGIN));
            list.add(order);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    public List<Order> getOrderCostsById() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_ORDERS_COSTS);
        ResultSet result = statement.executeQuery();
        List<Order> list = new ArrayList<>();
        while(result.next()){
            Order order = new Order();
            order.setOrderId(result.getInt(ColumnNames.ORDER_ID));
            order.setOrderCost(result.getDouble(ColumnNames.ORDER_COST));
            order.setCreatedDate(result.getString(ColumnNames.USER_LOGIN));
            list.add(order);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return list;
    }

    @Override
    public List<Order> findAll() throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createEntity(Order order) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.ADD_ORDER);
        statement.setDouble(1, order.getOrderCost());
        statement.setInt(2, order.getIdUser());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public Order getOrderByIdUser(int userId) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ORDER_BY_USER_ID);
        statement.setInt(1, userId);
        ResultSet result = statement.executeQuery();
        Order order = new Order();
        while(result.next()){
            order.setOrderId(result.getInt(ColumnNames.ORDER_ID));
            order.setOrderCost(result.getDouble(ColumnNames.ORDER_COST));
            order.setCreatedDate(result.getString(ColumnNames.DATE));
            order.setStatus(result.getBoolean(ColumnNames.ORDER_STATUS));
            order.setIdUser(result.getInt(ColumnNames.USER_ID_ORDER));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return order;
    }

    public void updateOrder(Order order) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_ORDER);
        statement.setDouble(1, order.getOrderCost());
        statement.setInt(2, order.getIdUser());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public void updateOrderStatus(Order order) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.UPDATE_ORDER_STATUS);
        statement.setBoolean(1, order.getStatus());
        statement.setInt(2, order.getIdUser());
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    @Override
    public Order getEntityById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ORDER_BY_ORDER_ID);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        Order order = new Order();
        while(result.next()){
            order.setOrderId(result.getInt(ColumnNames.ORDER_ID));
            order.setOrderCost(result.getDouble(ColumnNames.ORDER_COST));
            order.setCreatedDate(result.getString(ColumnNames.DATE));
            order.setStatus(result.getBoolean(ColumnNames.ORDER_STATUS));
            order.setIdUser(result.getInt(ColumnNames.USER_ID_ORDER));
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return order;
    }

    public void removeOrderById(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.REMOVE_ORDER);
        statement.setInt(1, id);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.releaseConnection(connection);
    }

    public Boolean isCreated(int userId) throws SQLException {
        boolean isLogIn = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ORDER_ID);
        statement.setInt(1, userId);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            isLogIn = true;
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);
        return isLogIn;
    }
}
