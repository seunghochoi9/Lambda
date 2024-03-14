package com.erichgamma.api.common;

import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save(T t) throws SQLException;
<<<<<<< HEAD:common/AbstractService.java
    public abstract List<T> findAll() throws SQLException;
=======
    public abstract List<T> findAll();
>>>>>>> develop-1.1:com/erichgamma/api/common/AbstractService.java
    public abstract Optional<T> findById(Long id);
    public abstract String count();
    public abstract Optional<T> getOne(String id);
    public abstract String delete(T t);
    public abstract Boolean existsById(Long id);

}
