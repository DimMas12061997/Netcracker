package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.User;

import java.sql.SQLException;

public interface UserI {
    boolean isAuthorized(String login, String password) throws SQLException;
    User getUserByLogin(String login) throws SQLException;
    String checkRole(String login, String password) throws SQLException;
    int getRoleIdByName();
    int getUserIdByName(String name);
    int getShopIdByName(String name);
    void updateUser(User user) throws SQLException;
}
