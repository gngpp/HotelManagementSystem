package com.lqing.orm.internal.conf.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *     用于配置数据库字段与实体类成员之间的映射关系.<br>
 *     以及对字段信息与成员信息之间的获取.
 * </p>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationField {
    /**
     * <p>
     *     字段名称
     * </p>
     * @return 返回字段名称
     */
    public String col_name();

    /**
     * <p>
     *     字段数据库类型
     * </p>
     * @return 返回数据库字段类型
     */
    public String sql_type();

    /**
     * <p>
     *     字段大小
     * </p>
     * @return 返回字段长度
     */
    public int size();

    /**
     * <p>
     *     实体类成员变量名称
     * </p>
     * @return 返回实体类成员变量名称
     */
    public String field_name();

    /**
     * <p>
     *     实体类成员变量数据类型
     * </p>
     * @return 返回实体类成员变量数据类型
     */
    public String java_type();

    /**
     * <p>
     *     字段默认值，默认值为空
     * </p>
     * @return 返回字段默认值
     */
    public String col_def() default "";

    /**
     * <p>
     *     字段是否能为空，默认值为false
     * </p>
     * @return 字段可以为空返回 true <br>
     *     字段不能为空返回 false
     */
    public boolean is_nullable() default false;

    /**
     * <p>
     *     字段是否为自增长，默认为false
     * </p>
     * @return 字段可以自增长返回 true <br>
     * 字段不能自增长返回 false
     */
    public boolean is_autoincrement() default false;

    /**
     * <p>
     *     字段是否为主键，默认值为false
     * </p>
     * @return 主键返回 true <br>
     *     非主键返回 false
     */
    public boolean is_primary_key() default false;

    /**
     * <p>
     *     字段是否为外键，默认值为false
     * </p>
     * @return 外键返回 true <br>
     *     非外键返回 false
     */
    public boolean is_foreign_key() default false;

    /**
     * <p>
     *     当字段为外键时候会附带此属性，获取外键关联的表名<br>
     *         默认值为空
     * </p>
     * @return 返回关联表名，如果不是外键则返回空
     */
    public String fk_ref_tbl_name() default "";

    /**
     * <p>
     *     当字段为外键时候会附带此属性，获取外键关联的表的字段名<br>
     *         默认值为空
     * </p>
     * @return 返回关联字段名，如果不是外键则返回空
     */
    public String fk_ref_col_name() default "";
}
