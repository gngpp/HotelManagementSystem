package com.lqing.orm.internal;

import com.lqing.orm.internal.query.AbstractQuery;
import com.lqing.orm.internal.query.converter.IResultSetConverter;

import java.sql.SQLException;

/**
 * <p>
 *     基于 {@link AbstractQuery} 的Dao层，该层抽象 {@link AbstractQuery}
 *     通过封装基本的SQL语句向上层 {@link AbstractDao} 提供更高一级的服务
 * </p>
 * @see AbstractQuery
 * @see AbstractDao
 *
 * @author ex
 */
public interface IQueryDao {
    /**
     * <p>
     *     向数据库插入一条数据.
     * </p>
     * @param tbl_name 表名
     * @param columns 字段数组
     * @param values 字段值数组
     * @return <p>成功返回 - [true]</p>
     *         <p>失败返回 - [false]</p>
     *
     * @throws SQLException
     * <p>
     *     当数据插入失败时会产生此异常，因为此函数会直接执行SQL语句.
     * </p>
     */
    public boolean save(String tbl_name, String[] columns, Object[] values)
            throws SQLException;

    /**
     * <p>
     *     根据给定的主键名和值,向数据库删除一条数据.
     * </p>
     * @param tbl_name 表名
     * @param name 主键字段名
     * @param id 主键值
     * @return <p>成功返回 - [true]</p>
     *         <p>失败返回 - [false]</p>
     * @throws SQLException
     * <p>
     *     当数据删除时会产生此异常，因为此函数会直接执行SQL语句.
     * </p>
     */
    public boolean delete(String tbl_name, String name, Object id)
            throws SQLException;

    /**
     * <p>
     *     根据给定的主键名和值，向数据库更新一条数据.
     * </p>
     * @param tbl_name 表名
     * @param columns 字段数组
     * @param newValues 更新后的字段值
     * @param name 主键字段名
     * @param id 主键值
     * @return <p>成功返回 - [true]</p>
     *         <p>失败返回 - [false]</p>
     * @throws SQLException
     * <p>
     *     当数据更新时会产生此异常，因为此函数会直接执行SQL语句.
     * </p>
     */
    public boolean update(String tbl_name, String[] columns, Object[] newValues,
                          String name, Object id)
            throws SQLException;

    /**
     * <p>
     *     根据给定的主键名和值，向数据库查询一条数据.
     * </p>
     * @param tbl_name 表名
     * @param name 主键字段名
     * @param id 主键值
     * @return <p>返回 {@link AbstractQuery} 对象</p>
     * <p>
     *     你必须执行{@link AbstractQuery#query_unique(IResultSetConverter)} (IResultSetConverter)}
     *     来获得查询后的结果集 {@link java.sql.ResultSet}<br>
     *     并且处理完结果集后，手动释放资源 {@link AbstractQuery#close()}.
     * </p>
     * @throws SQLException
     * <p>
     *     该接口不会立马执行SQL语句，但会执行{@link java.sql.Connection#prepareStatement(String)}<br>
     *     来构造SQL语句,固有可能因为产生异常.
     * </p>
     */
    public AbstractQuery load(String tbl_name, String name, Object id)
            throws SQLException;

    /**
     * <p>
     *     根据给定的表名，查询该表所有数据.
     * </p>
     * @param tbl_name 表名
     * @return <p>返回 {@link AbstractQuery} 对象</p>
     * @throws SQLException
     * <p>
     *     该接口不会立马执行SQL语句，但会执行{@link java.sql.Connection#prepareStatement(String)}<br>
     *     来构造SQL语句,固有可能因为产生异常.
     * </p>
     */
    public AbstractQuery list(String tbl_name)
            throws SQLException;
}
