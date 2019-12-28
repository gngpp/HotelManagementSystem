package com.lqing.orm.internal.query.converter;

import net.sf.json.JSONObject;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * <p>
 *     {@link java.sql.ResultSet} 数据为 {@link JSONObject}
 * </p>
 */
public class JSONConverter implements IResultSetConverter {
    @Override
    public Object convert(ResultSet rs) throws Exception {
        JSONObject jsonObject = new JSONObject();
        ResultSetMetaData metaData = rs.getMetaData();
        for(int i = 1 ; i<= metaData.getColumnCount();i++){
            Object value = rs.getObject(i);
            if("Date".equals(value.getClass().getSimpleName())){
                value = value.toString();
            }
            jsonObject.put(metaData.getColumnName(i), value);
        }
        return jsonObject;
    }
}
