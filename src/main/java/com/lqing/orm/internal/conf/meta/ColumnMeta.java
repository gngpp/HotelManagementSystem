package com.lqing.orm.internal.conf.meta;

/**
 * <p>
 *     数据库字段信息:<br>
 *     <ul>
 *         <li>{@link #TBL_NAME} 字段所属于的表名</li>
 *         <li>{@link #COLUMN_NAME} 字段名</li>
 *         <li>{@link #TYPE_NAME} 字段类型名 (SQL 数据类型 小写)</li>
 *         <li>{@link #COLUMN_SIZE} 字段大小</li>
 *         <li>{@link #COLUMN_DEF} 字段默认值</li>
 *         <li>{@link #IS_NULLABLE} 字段是否为空</li>
 *         <li>{@link #IS_AUTOINCREMENT} 字段是否自增</li>
 *         <li>{@link #IS_PRIMARY_KEY} 字段是否为主键</li>
 *         <li>{@link #IS_FOREIGN_KEY} 字段是否为外键</li>
 *         <li>{@link #FK_REF_TABLE_NAME} 外键关联的表名</li>
 *         <li>{@link #FK_REF_COLUMN_NAME} 外键关联的字段名</li>
 *     </ul>
 * </p>
 */
public final class ColumnMeta {
    public String TBL_NAME;
    public String COLUMN_NAME;
    public String TYPE_NAME;
    public int COLUMN_SIZE;
    public String COLUMN_DEF;
    public boolean IS_NULLABLE;
    public boolean IS_AUTOINCREMENT;
    public boolean IS_PRIMARY_KEY;
    public boolean IS_FOREIGN_KEY;
    public String FK_REF_TABLE_NAME;
    public String FK_REF_COLUMN_NAME;

    @Override
    public String toString() {
        return "ColumnEntity{" +
                "TBL_NAME='" + TBL_NAME + '\'' +
                ", COLUMN_NAME='" + COLUMN_NAME + '\'' +
                ", TYPE_NAME='" + TYPE_NAME + '\'' +
                ", COLUMN_SIZE=" + COLUMN_SIZE +
                ", COLUMN_DEF='" + COLUMN_DEF + '\'' +
                ", IS_NULLABLE=" + IS_NULLABLE +
                ", IS_AUTOINCREMENT=" + IS_AUTOINCREMENT +
                ", IS_PRIMARY_KEY=" + IS_PRIMARY_KEY +
                ", IS_FOREIGN_KEY=" + IS_FOREIGN_KEY +
                ", FK_REF_TABLE_NAME='" + FK_REF_TABLE_NAME + '\'' +
                ", FK_REF_COLUMN_NAME='" + FK_REF_COLUMN_NAME + '\'' +
                '}';
    }
}
