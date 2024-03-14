package com.erichgamma.api.user;

<<<<<<< HEAD:user/UserService.java
import enums.Messenger;
=======

import com.erichgamma.api.enums.Messenger;
import com.erichgamma.api.user.User;
>>>>>>> develop-1.1:com/erichgamma/api/user/UserService.java

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
<<<<<<< HEAD:user/UserService.java
    String test();
=======
>>>>>>> develop-1.1:com/erichgamma/api/user/UserService.java

    List<?> findUsers() throws SQLException;

    Messenger createTable() throws SQLException;

<<<<<<< HEAD:user/UserService.java
    String delTable() throws SQLException;
=======
    Messenger delTable() throws SQLException;
>>>>>>> develop-1.1:com/erichgamma/api/user/UserService.java
}