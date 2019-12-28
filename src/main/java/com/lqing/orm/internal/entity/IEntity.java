package com.lqing.orm.internal.entity;

import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.entity.adapter.IEntityAdapter;


/**
 * <p>
 *     实体类接口<br>
 *         包含以下几个部分: <br>
 *     <ul>
 *         <li>{@link #adapter()} - 数据适配器</li>
 *         <li>{@link #info()} ()} - 实体类信息 {@link EntityInfo}</li>
 *         <li>{@link #values()} ()} - 实体类值信息 {@link EntityValue}</li>
 *     </ul>
 * </p>
 */
public interface IEntity {
    /**
     * <p>
     *     生成一个实例，不克隆自身数据.
     * </p>
     * @return 返回 {@link IEntity}
     */
    public IEntity newInstance();

    /**
     * <p>
     *     返回 {@link IEntity} 对应的数据转换适配器
     *     {@link IEntityAdapter}
     * </p>
     * @return 返回适配器
     */
    public IEntityAdapter adapter();

    /**
     * <p>
     *     设置当前 {@link IEntity} 对应的数据转换适配器
     *     当设置完适配器后必须还原适配器，否则该对象将无法继续使用
     *     内部SQL生成依赖于默认适配器
     * </p>
     * @param adapter 需要设置的适配器 {@link IEntityAdapter}
     * @return 返回之前是用的适配器
     */
    public IEntityAdapter adapter(IEntityAdapter adapter);

    /**
     * <p>
     *      获取当前实体类的信息
     * </p>
     * @return 成功返回 true <br>
     *     失败返回 null
     */
    public EntityInfo info();

    /**
     * <p>
     *     获取当前类的值，依赖于 {@link #adapter()} 适配器
     *     通过适配器将当前实体类转换为 {@link EntityValue}
     * </p>
     * @return 成功返回 {@link EntityValue} <br>
     *     失败返回 null
     */
    public EntityValue values();
}
