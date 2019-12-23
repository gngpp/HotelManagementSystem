package com.lqing.orm.internal.conf;

import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.conf.adapter.IMetaAdapter;
import com.lqing.orm.internal.conf.adapter.MetaAdapter;
import com.lqing.orm.internal.conf.anno.AnnotationField;
import com.lqing.orm.internal.conf.anno.AnnotationTable;
import com.lqing.orm.internal.conf.meta.ColumnMeta;
import com.lqing.orm.internal.conf.meta.FieldMeta;
import com.lqing.orm.utils.*;
import org.slf4j.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <p> 配置提供者，根据注解来配置。</p>
 * <ul>
 *     <li>在实体类上进行数据表与实体类信息配置.<br>
 *         example : @AnnotationTable(table = "tbl_name", clazz = Entity.class)
 *     </li>
 *     <li>在实体类上对字段进行配置(主键自增长)<br>
 *         example : <pre>@AnnotationField(col_name = "id", sql_type = "integer",
 *                   size = 11, field_name = "id", java_type = "Integer",
 *                   is_autoincrement = true, is_primary_key = true)</pre>
 *     </li>
 *     <li>在实体类上对字段进行配置(外键配置)<br>
 *         example : <pre> @AnnotationField(col_name = "class_id", sql_type = "integer",
 *                   size = 11, field_name = "class_id", java_type = "Integer",
 *                   is_foreign_key = true,fk_ref_tbl_name = "tbl_class",
 *                   fk_ref_col_name = "id")</pre>
 *     </li>
 * </ul>
 * 所有注解配置成员:
 * <ul>
 *     <li>table            - 数据表名</li>
 *     <li>clazz            - 实体类型名称</li>
 *     <li>col_name         - 字段名</li>
 *     <li>sql_type         - 字段类型</li>
 *     <li>size             - 字段大小</li>
 *     <li>col_def          - 默认中</li>
 *     <li>is_nullable      - 是否能为空</li>
 *     <li>is_autoincrement - 是否自增字段</li>
 *     <li>is_primary_key   - 是否为主键</li>
 *     <li>is_foreign_key   - 是否为外键</li>
 *     <li>fk_ref_tbl_name  - 外键关联表名</li>
 *     <li>fk_ref_col_name  - 外键关联字段</li>
 *     <li>field_name       - 实体类成员名</li>
 *     <li>java_type        - 实体类成员类型</li>
 * </ul>
 */
public class AnnotationConfigureProvider implements IConfigureProvide {
    private static final String EMPTY_STRING = "";
    private static Logger LOG = LoggerUtils.getLogger(AnnotationConfigureProvider.class);
    private static Map<String, Class> CFG_MAPPING_TABLE_AND_ENTITY = new Hashtable<>();
    private static Map<String, List<ColumnMeta>> CFG_MAPPING_TABLE_AND_COLUMNS = new Hashtable<>();
    private static Map<String, List<FieldMeta>> CFG_MAPPING_ENTITY_AND_FIELDS = new Hashtable<>();
    private static Map<String, ColumnMeta> CFG_MAPPING_TABLE_AND_PRIMARY_KEY = new Hashtable<>();
    private static Map<String, List<ColumnMeta>> CFG_MAPPING_TABLE_FOREIGN_KEY = new Hashtable<>();
    private static Map<Class, EntityInfo> CFG_MAPPING_ENTITY_INFO = new Hashtable<>();
    private static IMetaAdapter META_ADAPTER = new MetaAdapter();

    public static void main(String[] args) {
        new AnnotationConfigureProvider().initConfigure();
    }

    @Override
    public boolean initConfigure() {
        return loadConfigure(new ArrayList<>());
    }

    @Override
    public boolean loadConfigure(List<AnnotationTable> annotationTables) {
        LOG.info("[initConfigure] 正在加载注解配置...");
        for (AnnotationTable table : annotationTables) {
            /*
             * 初始化表与实体类映射配置
             */
            Class entityClazz = table.clazz();
            Method[] methods = entityClazz.getMethods();
            String tbl_name = table.table();
            LOG.info("[initConfigure] find [" +
                    tbl_name + " <-> " + entityClazz.getName() + "]");
            /*
             * 初始化字段映射
             */
            List<ColumnMeta> columnMetas = new ArrayList<>();
            List<FieldMeta> fieldMetas = new ArrayList<>();
            /*
             * 外键与主键映射
             */
            ColumnMeta pk = new ColumnMeta();
            List<ColumnMeta> foreignCols = new ArrayList<>();
            /*
             * 导入配置
             */
            CFG_MAPPING_TABLE_AND_ENTITY.put(tbl_name, entityClazz);
            CFG_MAPPING_TABLE_AND_COLUMNS.put(tbl_name, columnMetas);
            CFG_MAPPING_ENTITY_AND_FIELDS.put(tbl_name, fieldMetas);
            CFG_MAPPING_TABLE_AND_PRIMARY_KEY.put(tbl_name, pk);
            CFG_MAPPING_TABLE_FOREIGN_KEY.put(tbl_name, foreignCols);
            /*
             * 加载字段注解
             */
            for (Field field : entityClazz.getDeclaredFields()) {
                ColumnMeta col = new ColumnMeta();
                FieldMeta fil = new FieldMeta();
                // 成员注解
                AnnotationField annotationField = null;
                if (field.isAnnotationPresent(AnnotationField.class)) {
                    annotationField = field.getAnnotation(AnnotationField.class);
                } else {
                    continue;
                }
                // 数据库字段
                col.TBL_NAME = tbl_name;
                col.COLUMN_NAME = annotationField.col_name();
                col.TYPE_NAME = annotationField.sql_type();
                col.COLUMN_SIZE = annotationField.size();
                col.COLUMN_DEF = EMPTY_STRING
                        .equals(annotationField.col_def()) ?
                        null :
                        annotationField.col_def();
                col.IS_AUTOINCREMENT = annotationField.is_autoincrement();
                col.IS_NULLABLE = annotationField.is_nullable();
                col.IS_PRIMARY_KEY = annotationField.is_primary_key();
                col.IS_FOREIGN_KEY = annotationField.is_foreign_key();
                col.FK_REF_TABLE_NAME = EMPTY_STRING
                        .equals(annotationField.fk_ref_tbl_name()) ?
                        null :
                        annotationField.fk_ref_tbl_name();
                col.FK_REF_COLUMN_NAME = EMPTY_STRING
                        .equals(annotationField.fk_ref_col_name()) ?
                        null :
                        annotationField.fk_ref_col_name();

                // 实体类成员
                fil.FIELD_NAME = annotationField.field_name();
                fil.TYPE_NAME = annotationField.java_type();

                // 检查外键是否合法
                if (col.IS_PRIMARY_KEY && col.IS_FOREIGN_KEY) {
                    LOG.error("[initConfigure] 字段映射配置错误，同一字段不能同时为主键和外键! filed -> [" +
                            fil.FIELD_NAME + "]");
                    break;
                }
                if (col.IS_FOREIGN_KEY &&
                        (col.FK_REF_TABLE_NAME == null || col.FK_REF_COLUMN_NAME == null)) {
                    LOG.error("[initConfigure] 字段映射配置错误，外键字段必须设置关联的表名和关联的字段名! " +
                            "see \"fk_ref_tbl_name\" - \"fk_ref_col_name\"  | filed -> [" +
                            fil.FIELD_NAME + "]");
                    break;
                }
                // 初始化字段方法
                if ("boolean".equals(fil.TYPE_NAME.toLowerCase())) {
                    fil.GET_METHOD = ReflectUtil.getClassMethod(methods,
                            ConstantStringPool.GET_BOOLEAN_METHOD_KEY_PREFIX +
                                    StringUtil.toFirstCharUpperCase(fil.FIELD_NAME));
                } else {
                    fil.GET_METHOD = ReflectUtil.findGetMethod(methods,
                            StringUtil.toFirstCharUpperCase(fil.FIELD_NAME));
                }
                fil.SET_METHOD = ReflectUtil.findSetMethod(methods,
                        StringUtil.toFirstCharUpperCase(fil.FIELD_NAME));
                if (fil.GET_METHOD == null ||
                        fil.SET_METHOD == null) {
                    LOG.error("[initConfigure] 字段映射配置错误，找不到字段的 \"setter / getter\" 方法" +
                            "filed -> [" + fil.FIELD_NAME + "]");
                }
                // 保存数据
                if (col.IS_PRIMARY_KEY) {
                    pk = col;
                } else if (col.IS_FOREIGN_KEY) {
                    foreignCols.add(col);
                }
                columnMetas.add(col);
                fieldMetas.add(fil);

                // LOG
                LOG.info("[initConfigure] column -> " + col.toString());
                LOG.info("[initConfigure] field  -> " + fil.toString());
            }
            // 实体类信息转换
            EntityInfo info = META_ADAPTER.transform(columnMetas);
            LOG.info("[initConfigure] info   -> " + info.toString());
            CFG_MAPPING_ENTITY_INFO.put(entityClazz, info);
        }
        return true;
    }

    @Override
    public EntityInfo entityInfo(Class<?> clazz) {
        return CFG_MAPPING_ENTITY_INFO.get(clazz);
    }

    @Override
    public Class entity(String tbl_name) {
        return CFG_MAPPING_TABLE_AND_ENTITY.get(tbl_name);
    }

    @Override
    public String table(Class<?> clazz) {
        for (Map.Entry<String, Class> entry : mappingSet()) {
            if (clazz.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<String, Class>> mappingSet() {
        return CFG_MAPPING_TABLE_AND_ENTITY.entrySet();
    }

    @Override
    public List<ColumnMeta> columns(String tbl_name) {
        return CFG_MAPPING_TABLE_AND_COLUMNS.get(tbl_name);
    }

    @Override
    public List<ColumnMeta> columns(Class<?> clazz) {
        return CFG_MAPPING_TABLE_AND_COLUMNS.get(table(clazz));
    }

    @Override
    public List<FieldMeta> fields(String tbl_name) {
        return CFG_MAPPING_ENTITY_AND_FIELDS.get(tbl_name);
    }

    @Override
    public List<FieldMeta> fields(Class<?> clazz) {
        return CFG_MAPPING_ENTITY_AND_FIELDS.get(table(clazz));
    }

    @Override
    public boolean isPrimaryKey(ColumnMeta col) {
        return col.IS_PRIMARY_KEY;
    }

    @Override
    public boolean isForeignKwy(ColumnMeta col) {
        return col.IS_FOREIGN_KEY;
    }

    @Override
    public ColumnMeta tablePrimaryKey(String tbl_name) {
        return CFG_MAPPING_TABLE_AND_PRIMARY_KEY.get(tbl_name);
    }

    @Override
    public List<ColumnMeta> tableForeignKeys(String tbl_name) {
        return CFG_MAPPING_TABLE_FOREIGN_KEY.get(tbl_name);
    }

    @Override
    public String foreignKeyRefTable(ColumnMeta col) {
        return col.FK_REF_TABLE_NAME;
    }
}
