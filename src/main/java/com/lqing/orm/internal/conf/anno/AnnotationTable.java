package com.lqing.orm.internal.conf.anno;

import java.lang.annotation.*;

/**
 * <p>
 *     用于配置表名与实体类型的映射关系.
 * </p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(AnnotationTableContainer.class)
public @interface AnnotationTable {
    /**
     * <p>
     *     表名
     * </p>
     * @return 数据表名称
     */
     String table();

    /**
     * <p>
     *     实体类类型 {@link Class}
     * </p>
     * @return 返回实体类型
     */
     Class clazz();
}
