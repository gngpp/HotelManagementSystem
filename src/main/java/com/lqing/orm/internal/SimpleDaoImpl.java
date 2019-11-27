package com.lqing.orm.internal;

import com.lqing.orm.internal.conf.ConfigureFactory;
import com.lqing.orm.internal.conf.IConfigureProvide;
import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.entity.EntityValue;
import com.lqing.orm.internal.entity.IEntity;
import com.lqing.orm.internal.entity.wrapper.EntityList;
import com.lqing.orm.internal.query.AbstractQuery;
import com.lqing.orm.internal.query.converter.ConverterFactory;
import com.lqing.orm.internal.query.converter.IResultSetConverter;
import com.lqing.orm.utils.ReflectUtil;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SimpleDaoImpl<T extends IEntity> extends AbstractDao implements IDao<T> {
    private static IConfigureProvide CFG = ConfigureFactory
            .cfg("com.lqing.orm.internal.conf.AnnotationConfigureProvider");
    private IResultSetConverter converter = ConverterFactory
            .converter("com.lqing.orm.internal.query.converter.EntityConverter");
    private EntityInfo info;

    public SimpleDaoImpl() {
        final Class<?> paramClass = ReflectUtil.genericParamClass(this.getClass());
        if(paramClass != null){
            info = CFG.entityInfo(paramClass);
            if(info == null){
                final AnnotationTable[] tables = paramClass.getAnnotationsByType(AnnotationTable.class);
                if(tables != null){
                    CFG.loadConfigure(Arrays.asList(tables));
                }
                info = CFG.entityInfo(paramClass);
            }
        }
    }

    @Override
    public boolean save(IEntity entity) throws SQLException {
        EntityValue value = entity.values();
        return super.save(info.tbl_name,
                info.columns,
                value.values);
    }

    @Override
    public boolean delete(T entity) throws SQLException {
        EntityValue value = entity.values();
        return super.delete(info.tbl_name,
                info.pk,
                value.pk_value);
    }

    @Override
    public boolean update(T entity) throws SQLException {
        EntityValue value = entity.values();
        return super.update(info.tbl_name,
                info.columns,
                value.values,
                info.pk,
                value.pk_value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T load(Object id) throws Exception {
        AbstractQuery query = super.load(info.tbl_name,
                info.pk,
                id);
        return (T)query.query_unique(converter);
    }

    @Override
    public T load(T entity) throws Exception {
        return load(entity.values().pk_value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public EntityList<T> list() throws Exception {
        AbstractQuery query = super.list(info.tbl_name);
        ResultSet rs = (ResultSet) query.query_unique(null);
        assert rs != null;
        EntityList<T> iEntityList = new EntityList<>(rs.getRow());
        do {
            iEntityList.add((T) converter.convert(rs));
        }while(rs.next());
        query.close();
        return iEntityList;
    }

    public void list(StringBuilder hql,
                     IResultSetConverter converter,
                     List<?> list)
            throws Exception {
        AbstractQuery query = createQuery(hql);
        query.query_list(converter, list);
        query.close();
    }

    public List<JSONObject> list(StringBuilder hql)
            throws Exception {
        List<JSONObject> list = new ArrayList<>();
        IResultSetConverter converter = ConverterFactory
                .converter("JSONConverter");
        list(hql,converter,list);
        return list;
    }

    public EntityInfo info() {
        return this.info;
    }
}
