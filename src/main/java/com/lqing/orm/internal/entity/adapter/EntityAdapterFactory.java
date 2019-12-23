package com.lqing.orm.internal.entity.adapter;

import com.lqing.orm.utils.LoggerUtils;
import org.slf4j.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     实体类适配器工厂
 * </p>
 */
public class EntityAdapterFactory {
    private static Logger LOG = LoggerUtils.getLogger(EntityAdapterFactory.class);
    private static Map<String, IEntityAdapter> MAP = new HashMap<>();
    private static String PACKAGE_NAME = EntityAdapterFactory.class.getPackage().getName() + '.';

    public static IEntityAdapter adapter(String name) {
        synchronized (EntityAdapterFactory.class) {
            String class_name = name.startsWith(PACKAGE_NAME) ?
                    name : PACKAGE_NAME + name;
            IEntityAdapter adapter = MAP.get(class_name);
            if (adapter == null){
                try {
                    Class<?> clazz = Class.forName(class_name);
                    adapter = (IEntityAdapter) clazz.newInstance();
                    MAP.put(class_name, adapter);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    LOG.error("ConverterFactory 数据转换器加载失败！ -> [" + name + "] " +
                            e.getMessage());
                }
            }
            return adapter;
        }
    }
}
