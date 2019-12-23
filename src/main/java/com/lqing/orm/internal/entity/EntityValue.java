package com.lqing.orm.internal.entity;

import java.util.Arrays;

/**
 * <p>
 *     实体类数据，提取 {@link IEntity} 的数据进行包装<br>
 *     {@link com.lqing.orm.internal.entity.adapter.DefaultEntityAdapter}
 *     负责对实体类数据进行包装.<br>
 *     <ul>
 *         <li>{@link #pk_value} 主键数据</li>
 *         <li>{@link #values} 字段数据，但不包括主键</li>
 *     </ul>
 * </p>
 */
public final class EntityValue {
    public Object pk_value;
    public Object[] values;

    @Override
    public String toString() {
        return "EntityValue{" +
                "pk_value=" + pk_value +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
