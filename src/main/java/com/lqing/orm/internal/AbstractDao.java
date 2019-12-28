package com.lqing.orm.internal;

import com.lqing.orm.internal.connection.C3p0ConnectionProvider;
import com.lqing.orm.internal.connection.IConnectionProvide;
import com.lqing.orm.internal.query.AbstractQuery;
import com.lqing.orm.internal.query.SQLQuery;
import com.lqing.orm.utils.LoggerUtils;
import org.slf4j.Logger;

import java.sql.SQLException;


public abstract class AbstractDao implements IQueryDao {
    private static Logger LOG = LoggerUtils.getLogger(AbstractDao.class);
    private static IConnectionProvide connProvider = new C3p0ConnectionProvider();

    @Override
    public boolean save(String tbl_name, String[] columns, Object[] values)
            throws SQLException {
        AbstractQuery query = new SQLQuery(connProvider.getConnection())
                .insert(tbl_name, columns, values);
        return query.exec_and_close();
    }

    @Override
    public boolean delete(String tbl_name, String name, Object id)
            throws SQLException {
        AbstractQuery query = new SQLQuery(connProvider.getConnection())
                .delete(tbl_name).where().eq(name, id);
        return query.exec_and_close();
    }

    @Override
    public boolean update(String tbl_name, String[] columns, Object[] newValues,
                          String name, Object id)
            throws SQLException {
        AbstractQuery query = new SQLQuery(connProvider.getConnection())
                .update(tbl_name)
                .set_values(columns, newValues)
                .where()
                .eq(name, id);
        return query.exec_and_close();
    }

    @Override
    public AbstractQuery load(String tbl_name, String name, Object id)
            throws SQLException {
        return new SQLQuery(connProvider.getConnection())
                .select().col_all(tbl_name).from(tbl_name)
                .where()
                .eq(name, id);
    }

    @Override
    public AbstractQuery list(String tbl_name) throws SQLException {
        return new SQLQuery(connProvider.getConnection())
                .select().col_all(tbl_name).from(tbl_name);
    }

    public AbstractQuery createQuery(){
        return new SQLQuery(connProvider.getConnection());
    }

    public AbstractQuery createQuery(StringBuilder sb){
        return new SQLQuery(connProvider.getConnection(),sb);
    }
}
