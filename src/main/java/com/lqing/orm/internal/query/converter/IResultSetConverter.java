package com.lqing.orm.internal.query.converter;

import java.sql.ResultSet;

/**
 * <p>
 *     {@link java.sql.ResultSet} 数据转换器.
 * </p>
 */
public interface IResultSetConverter {
    /**
     * <p>
     *     {@link ResultSet } 转换器
     * </p>
     * @param rs 需要转换的 {@link ResultSet }
     * @return 返回转换后的对象
     * @throws Exception 如果转换失败
     */
    public Object convert(ResultSet rs) throws Exception;
}
