package com.erichgamma.api.user;

import com.erichgamma.api.enums.Messenger;
import com.erichgamma.api.user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    String addUsers();
    String login(User user);
    String updatePassword(User user);
    List<?> findUsersByName(String name);
    Map<String, ?> findUsersByNameFromMap(String name);
    List<?> findUsersByJob(String job);
    Map<String, ?> findUsersByJobFromMap(String job);
    Map<String, ?> getUserMap();
    List<?> findUsers() throws SQLException;
    Messenger createTable() throws SQLException;
    Messenger delTable() throws SQLException;

}