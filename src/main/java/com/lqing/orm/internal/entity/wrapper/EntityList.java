package com.lqing.orm.internal.entity.wrapper;

import com.lqing.orm.internal.entity.IEntity;

import java.util.ArrayList;

/**
 * <p>
 *     实体类扩展线性表<br>
 *     可以根据 {@link IEntity#values()} ->
 *     {@link com.lqing.orm.internal.entity.EntityValue#pk_value}<br>
 *     对线性表进行查找 (也就是根据主键就可以查询到 {@link IEntity}).
 * </p>
 * @param <T>
 */
public class EntityList<T extends IEntity> extends ArrayList<T> {
    private IEntityEquatable equatable = new IEntityEquatable() {
        @Override
        public boolean eq(IEntity a, IEntity b) {
            return a.values().pk_value.equals(
                    b.values().pk_value);
        }

        @Override
        public boolean eqv(IEntity a, Object v) {
            return a.values().pk_value.equals(v);
        }
    };

    public EntityList() { }

    public EntityList(int row) {
        super(row);
    }

    public IEntityEquatable setEquatable(IEntityEquatable equatable){
        IEntityEquatable old = this.equatable;
        this.equatable = equatable;
        return old;
    }

    public IEntity find(Object id){
        for (IEntity entity : this){
            if(equatable.eqv(entity, id)){
                return entity;
            }
        }
        return null;
    }
}
