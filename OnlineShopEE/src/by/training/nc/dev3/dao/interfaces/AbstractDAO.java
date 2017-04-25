package by.training.nc.dev3.dao.interfaces;

import by.training.nc.dev3.beans.Entity;

import java.sql.SQLException;
import java.util.List;


public interface AbstractDAO<T extends Entity> {
    List<T> findAll() throws SQLException;

    public void createEntity(T entity) throws SQLException;

    public T getEntityById(int id) throws SQLException;
}
