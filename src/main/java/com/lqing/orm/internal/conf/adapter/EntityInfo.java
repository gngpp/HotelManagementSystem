package com.lqing.orm.internal.conf.adapter;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     实体类信息，对从配置提取出来的映射信息进一步包装<br>
 *     {@link IMetaAdapter#transform(List)} 负责对映射信息进行包装.<br>
 *     <ul>
 *         <li>{@link #pk} 主键字段名</li>
 *         <li>{@link #tbl_name} 映射表名</li>
 *         <li>{@link #columns} 字段名数组，但不包括主键</li>
 *     </ul>
 * </p>
 */
public final class EntityInfo {
    public String pk;
    public String tbl_name;
    public String[] columns;

    @Override
    public String toString() {
        return "EntityInfo{" +
                "pk='" + pk + '\'' +
                ", tbl_name='" + tbl_name + '\'' +
                ", columns=" + Arrays.toString(columns) +
                '}';
    }
}
