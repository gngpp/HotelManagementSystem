package com.lqing.orm.internal.entity;

import com.lqing.orm.internal.conf.ConfigureFactory;
import com.lqing.orm.internal.conf.IConfigureProvide;
import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.entity.adapter.EntityAdapterFactory;
import com.lqing.orm.internal.entity.adapter.IEntityAdapter;

/**
 * <p>
 *     默认的实体类基类.
 * </p>
 */
public abstract class DefaultEntity implements IEntity {
    private static IConfigureProvide CFG = ConfigureFactory
            .cfg("servlet.server.core.dao.internal.conf.AnnotationConfigureProvider");;
    private static IEntityAdapter DEFAULT_ADAPTER = EntityAdapterFactory.adapter("DefaultEntityAdapter");
    private IEntityAdapter adapter = DEFAULT_ADAPTER;

    public IEntityAdapter adapter() {
        return adapter;
    }

    @Override
    public IEntityAdapter adapter(IEntityAdapter adapter) {
        IEntityAdapter old = this.adapter;
        this.adapter = adapter;
        return old;
    }

    @Override
    public EntityInfo info() {
        return CFG.entityInfo(this.getClass());
    }

    @Override
    public EntityValue values() {
        try {
            return (EntityValue) DEFAULT_ADAPTER.transform(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IEntity newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
