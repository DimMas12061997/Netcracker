package by.training.nc.dev3.dao.interfaces;


import by.training.nc.dev3.beans.UserProfile;

import java.sql.SQLException;

public interface UserProfileI {
    void updateUserProfile(UserProfile user) throws SQLException;
}
