package com.lqing.orm.internal.conf;

import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.utils.LoggerUtils;
import com.lqing.orm.utils.PkgScanner;
import org.slf4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *     配置提供者工厂，配置可以由以下几种方式提供: <br>
 *         <ul>
 *             <li>通过注解</li>
 *             <li>xml文件配置</li>
 *             <li>从数据库元数据获取</li>
 *         </ul>
 * </p>
 */
public final class ConfigureFactory {
    private static Logger LOG = LoggerUtils.getLogger(ConfigureFactory.class);
    private static IConfigureProvide CFG;

    /**
     * 获取映射配置
     * @param name 配置提供者类名
     * @return 返回配置接口
     */
    public static IConfigureProvide cfg(String name){
        synchronized (ConfigureFactory.class){
            if(CFG == null){
                try {
                    Class<?> clazz = Class.forName(name);
                    Method initMethod = clazz.getDeclaredMethod("initConfigure");
                    CFG = (IConfigureProvide) clazz.newInstance();
                    initMethod.invoke(CFG);
                } catch (InstantiationException | ClassNotFoundException | IllegalAccessException |
                        NoSuchMethodException | InvocationTargetException e) {
                    LOG.error("ConfigureFactory 加载配置加载失败！ -> [" + name + "] " +
                            e.getMessage());
                }
            }
            return CFG;
        }
    }
}
