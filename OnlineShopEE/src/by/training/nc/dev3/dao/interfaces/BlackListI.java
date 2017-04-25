package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.User;

import java.sql.SQLException;
import java.util.List;

public interface BlackListI {
    void removeByUserId(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}
