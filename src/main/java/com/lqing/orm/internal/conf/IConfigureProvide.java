package com.lqing.orm.internal.conf;

import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.conf.meta.ColumnMeta;
import com.lqing.orm.internal.conf.meta.FieldMeta;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *     配置提供者接口
 * </p>
 */
public interface IConfigureProvide {
    /**
     * <p>
     *     初始化配置
     * </p>
     * @return 成功返回 [true] <br>
     *         失败返回 [false]
     */
    public boolean initConfigure();

    /**
     * <p>
     *     初始化配置
     * </p>
     * @return 成功返回 [true] <br>
     *         失败返回 [false]
     */
    public boolean loadConfigure(List<AnnotationTable> annotationTables);

    /**
     * <p>
     *     根据实体类型获取实体信息
     * </p>
     * @param clazz 实体类型
     * @return 若表存在则返回实体信息 {@link EntityInfo} <br>
     *     不存在则返回 null
     */
    public EntityInfo entityInfo(Class<?> clazz);

    /**
     * <p>
     *     根据表名获取实体类型
     * </p>
     * @param tbl_name 表名
     * @return 若表存在则返回实体类型 {@link Class} <br>
     *     不存在则返回 null
     */
    public Class entity(String tbl_name);

    /**
     * <p>
     *     根据实体类型获取表名
     * </p>
     * @param clazz 实体类型
     * @return 若表存在则返回表名 {@link String} <br>
     *     不存在则返回 null
     */
    public String table(Class<?> clazz);

    /**
     * <p>
     *     返回所有表与实体类映射集合.
     * </p>
     * @return 返回映射集合 {@link Map.Entry}
     */
    public Set<Map.Entry<String,Class>> mappingSet();

    /**
     * <p>
     *     根据表名，获得表对应的字段列表 {@link ColumnMeta}
     * </p>
     * @param tbl_name 表名称
     * @return
     * <p>
     *     返回字段列表 {@link List}
     *     <br>当找不到对应的表时候返回null
     * </p>
     */
    public List<ColumnMeta> columns(String tbl_name);

    /**
     * <p>
     *     根据实体类型，获得表对应的字段列表 {@link ColumnMeta}
     * </p>
     * @param clazz 实体类类型
     * @return
     * <p>
     *     返回字段列表 {@link List}
     *     <br>当找不到对应的表时候返回null
     * </p>
     */
    public List<ColumnMeta> columns(Class<?> clazz);

    /**
     * <p>
     *     根据表名，获取实体类成员列表
     * </p>
     * @param tbl_name 表名
     * @return
     * <p>
     *     返回字段列表 {@link List}
     *     <br>当找不到对应的表时候返回null
     * </p>
     */
    public List<FieldMeta> fields(String tbl_name);

    /**
     * <p>
     *     根据实体类型，获取实体类成员列表
     * </p>
     * @param clazz 实体类型
     * @return
     * <p>
     *     返回字段列表 {@link List}
     *     <br>当找不到对应的表时候返回null
     * </p>
     */
    public List<FieldMeta> fields(Class<?> clazz);

    /**
     * <p>
     *     判断字段是否为主键
     * </p>
     * @param col 需要判断的字段 {@link ColumnMeta}
     * @return
     * <p>
     *     主键返回 [true] <br>
     *     非主键返回 [false]
     * </p>
     */
    public boolean isPrimaryKey(ColumnMeta col);

    /**
     * <p>
     *     判断字段是否为外键
     * </p>
     * @param col 需要判断的字段 {@link ColumnMeta}
     * @return
     * <p>
     *     外键返回 [true] <br>
     *     非外键返回 [false]
     * </p>
     */
    public boolean isForeignKwy(ColumnMeta col);

    /**
     * <p>
     *     根据表名获取表的主键
     * </p>
     * @param tbl_name 表名称
     * @return
     * <p>
     *     当表不存在，或者表无主键返回 [null] <br>
     *     否则返回 {@link ColumnMeta}
     * </p>
     */
    public ColumnMeta tablePrimaryKey(String tbl_name);

    /**
     * <p>
     *     获取表所有的外键列表
     * </p>
     * @param tbl_name 表名称
     * @return
     * <p>
     *     返回外键字段列表 {@link List}
     *     <br>当找不到对应的表时候返回null
     * </p>
     */
    public List<ColumnMeta> tableForeignKeys(String tbl_name);

    /**
     * <p>
     *     根据外键字段获取该外键关联的表名称
     * </p>
     * @param col 外键字段
     * @return 返回外键关联的表名称
     */
    public String foreignKeyRefTable(ColumnMeta col);
}
