package com.lqing.orm.internal.conf.adapter;

import com.lqing.orm.internal.conf.meta.ColumnMeta;
import java.util.List;

/**
 * <p>
 *     配置映射数据适配器<br>
 *     负责将映射数据做二次打包.
 * </p>
 */
public interface IMetaAdapter {
    /**
     * 对字段配置映射信息进行转换
     *
     * @param colMeta 字段映射配置信息
     * @return 返回转换后的数据
     */
    public EntityInfo transform(List<ColumnMeta> colMeta);
}
