package com.lqing.orm.internal.query.converter;

import com.lqing.orm.internal.conf.ConfigureFactory;
import com.lqing.orm.internal.conf.IConfigureProvide;
import com.lqing.orm.utils.*;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import static com.lqing.orm.utils.StringUtil.toFirstCharUpperCase;


/**
 * <p>
 *      {@link java.sql.ResultSet} 数据转换器.<br>
 *      默认的数据转换器，用于将 {@link java.sql.ResultSet} 转换为
 *      {@link com.lqing.orm.internal.entity.IEntity}.
 * </p>
 */
public class EntityConverter implements IResultSetConverter {
    private static IConfigureProvide CFG = ConfigureFactory
            .cfg("servlet.server.core.dao.internal.conf.AnnotationConfigureProvider");;
    @Override
    public Object convert(ResultSet rs) throws Exception {
        ResultSetMetaData meta = rs.getMetaData();
        if(meta.getColumnCount() > 0){
            Class<?> clazz = CFG.entity(meta.getTableName(1));
            if(clazz != null){
                Object instance = clazz.newInstance();
                Method[] methods = instance.getClass().getMethods();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    ReflectUtil.invokeSetMethod(methods,
                            toFirstCharUpperCase(meta.getColumnName(i)),
                            instance, rs.getObject(i));
                }
                return instance;
            }
        }
        return null;
    }
}
