package com.lqing.orm.internal.query.converter;

import com.lqing.orm.utils.LoggerUtils;
import org.slf4j.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     {@link java.sql.ResultSet} 数据转换器工厂.<br>
 *     用于对数据库查询结果集进行数据转换.
 * </p>
 */
public class ConverterFactory {
    private static Logger LOG = LoggerUtils.getLogger(ConverterFactory.class);
    private static Map<String,IResultSetConverter> MAP = new HashMap<>();
    private static String PACKAGE_NAME = ConverterFactory.class.getPackage().getName() + '.';

    public static IResultSetConverter converter(String name){
        synchronized (ConverterFactory.class){
            String class_name = name.startsWith(PACKAGE_NAME) ?
                    name : PACKAGE_NAME + name;
            IResultSetConverter converter = MAP.get(class_name);
            if (converter == null)
                try {
                    Class<?> clazz = Class.forName(class_name);
                    converter = (IResultSetConverter) clazz.newInstance();
                    MAP.put(class_name, converter);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    LOG.error("ConverterFactory 数据转换器加载失败！ -> [" + name + "] " +
                            e.getMessage());
            }
            return converter;
        }
    }
}
