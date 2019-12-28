package com.lqing.orm.internal.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <p>
 *     数据库连接池提供者
 * </p>
 */
public interface IConnectionProvide {
    /**
     * <p>
     *     获取数据库链接
     * </p>
     * @return <p>成功返回 - 数据库链接 [{@link Connection}]</p>
     *         <p>失败返回 - [null]</p>
     */
    public Connection getConnection();

    /**
     * <p>
     *     关闭数据库链接，以及释放资源
     * </p>
     * @param conn 数据库链接
     * @param ps PreparedStatement
     * @param rs ResultSet
     */
    public void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs);
}
