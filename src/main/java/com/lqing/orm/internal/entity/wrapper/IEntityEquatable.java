package com.lqing.orm.internal.entity.wrapper;


import com.lqing.orm.internal.entity.IEntity;

/**
 * <p>
 *     实体类比较接口，用于在遍历 {@link EntityList} 的时候比较<br>
 *         <ul>
 *             <li>{@link #eq(IEntity, IEntity)} 两个实体类进行比较.<br></li>
 *             <li>{@link #eqv(IEntity, Object)} 实体类与数据进行比较.<br></li>
 *         </ul>
 * </p>
 */
public interface IEntityEquatable {
    /**
     * <p>
     *     两个实体类数据进行比较.
     * </p>
     * @param a 需要比较的实体类
     * @param b 需要比较的实体类
     * @return 相同返回 [true] 否则 返回 [false]
     */
    public boolean eq(IEntity a, IEntity b);

    /**
     * <p>
     *     实体类与某个对象进行比较，一般是和主键相比较.
     * </p>
     * @param a 需要比较的实体类
     * @param v 需要比较的数据
     * @return 相同返回 [true] 否则 返回 [false]
     */
    public boolean eqv(IEntity a, Object v);
}
