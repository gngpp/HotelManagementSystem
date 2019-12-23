package com.lqing.orm.internal.entity.adapter;

import com.lqing.orm.internal.conf.ConfigureFactory;
import com.lqing.orm.internal.conf.IConfigureProvide;
import com.lqing.orm.internal.conf.meta.ColumnMeta;
import com.lqing.orm.internal.conf.meta.FieldMeta;
import com.lqing.orm.internal.entity.EntityValue;
import com.lqing.orm.internal.entity.IEntity;
import java.util.List;

/**
 * <p>
 *     默认实体类适配器.
 * </p>
 * <pre>
 *     {@link #transform(IEntity)} 将实体类转换为 {@link EntityValue}
 * </pre>
 */
public class DefaultEntityAdapter implements IEntityAdapter {
    private static IConfigureProvide CFG = ConfigureFactory
            .cfg("servlet.server.core.dao.internal.conf.AnnotationConfigureProvider");;

    @Override
    public Object transform(IEntity entity)
            throws Exception {
        List<FieldMeta> fields = CFG.fields(entity.getClass());
        List<ColumnMeta> columns = CFG.columns(entity.getClass());
        EntityValue value = new EntityValue();
        if(fields != null && columns != null){
            int i = 0;
            value.values = new Object[columns.size() - 1];
            for (int j = 0; j < columns.size(); j++) {
                if(!columns.get(j).IS_PRIMARY_KEY){
                    value.values[i++] = fields.get(j).GET_METHOD.invoke(entity);
                }else {
                    value.pk_value = fields.get(j).GET_METHOD.invoke(entity);
                }
            }
            return value;
        }
        throw new Exception("[transform] 获取 fields 失败!");
    }

    @Override
    public Object reduction(Object o, Object instance)
            throws Exception {
        return null;
    }
}
