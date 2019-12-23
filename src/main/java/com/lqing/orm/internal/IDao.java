package com.lqing.orm.internal;

import com.lqing.orm.internal.entity.IEntity;
import com.lqing.orm.internal.entity.wrapper.EntityList;

import java.sql.SQLException;

public interface IDao<T extends IEntity> {
    boolean save(T entity)
        throws SQLException;

    boolean delete(T entity)
        throws SQLException;

    boolean update(T entity)
        throws SQLException;

    T load(Object id)
            throws Exception;

    T load(T entity)
        throws Exception;

    EntityList<T> list()
        throws Exception;
}
