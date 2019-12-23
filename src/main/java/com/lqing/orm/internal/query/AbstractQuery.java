package com.lqing.orm.internal.query;

import com.lqing.orm.internal.conf.ConfigureFactory;
import com.lqing.orm.internal.conf.IConfigureProvide;
import com.lqing.orm.internal.conf.adapter.EntityInfo;
import com.lqing.orm.internal.query.converter.IResultSetConverter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     INSERT [LOW_PRIORITY | DELAYED] [IGNORE]
 *     [INTO] tbl_name
 *     SET col_name=expression, col_name=expression, ...
 *
 *     DELETE [LOW_PRIORITY] [QUICK] [IGNORE]
 *     tbl_name[.*] [, tbl_name[.*]] ...
 *     FROM table_references
 *     [WHERE where_condition]
 *
 *     UPDATE [LOW_PRIORITY] [IGNORE] table_reference
 *     SET assignment_list
 *     [WHERE where_condition]
 *     [ORDER BY ...]
 *     [LIMIT row_count]
 *
 *     SELECT
 *     [ALL | DISTINCT | DISTINCTROW ]
 *       [HIGH_PRIORITY]
 *       [STRAIGHT_JOIN]
 *       [SQL_SMALL_RESULT] [SQL_BIG_RESULT] [SQL_BUFFER_RESULT]
 *       SQL_NO_CACHE [SQL_CALC_FOUND_ROWS]
 *     select_expr [, select_expr ...]
 *     [FROM table_references
 *       [PARTITION partition_list]
 *     [WHERE where_condition]
 *     [GROUP BY {col_name | expr | position}, ... [WITH ROLLUP]]
 *     [HAVING where_condition]
 *     [WINDOW window_name AS (window_spec)
 *         [, window_name AS (window_spec)] ...]
 *     [ORDER BY {col_name | expr | position}
 *       [ASC | DESC], ... [WITH ROLLUP]]
 *     [LIMIT {[offset,] row_count | row_count OFFSET offset}]
 *     [INTO OUTFILE 'file_name'
 *         [CHARACTER SET charset_name]
 *         export_options
 *       | INTO DUMPFILE 'file_name'
 *       | INTO var_name [, var_name]]
 *     [FOR {UPDATE | SHARE} [OF tbl_name [, tbl_name] ...] [NOWAIT | SKIP LOCKED]
 *       | LOCK IN SHARE MODE]]
 * </pre>
 */
public abstract class AbstractQuery {
    private static IConfigureProvide CFG = ConfigureFactory
            .cfg("servlet.server.core.dao.internal.conf.AnnotationConfigureProvider");
    private static final String OPERATE_EQUALS = " = ";
    private static final String OPERATE_NOT_EQUALS = " != ";
    private static final String OPERATE_LESS_THAN = " < ";
    private static final String OPERATE_LESS_THAN_AND_EQUALS = " <= ";
    private static final String OPERATE_GREATER_THAN = " > ";
    private static final String OPERATE_GREATER_THAN_AND_EQUALS = " >= ";
    private static final String OPERATE_AND = " and ";
    private static final String OPERATE_OR = " or ";
    private StringBuilder sql = new StringBuilder();
    private List<Object> values = new ArrayList<>();

    public abstract boolean exec() throws SQLException;

    public abstract boolean exec_and_close() throws SQLException;

    public abstract Object query_unique() throws Exception;

    public abstract Object query_unique(IResultSetConverter converter) throws Exception;

    public abstract <T> void query_list(List<T> list) throws Exception;

    public abstract <T> void  query_list(IResultSetConverter converter, List<T> list) throws Exception;

    public abstract void close() throws SQLException;

    public EntityInfo entityInfo(Class<?> clazz){
        return CFG.entityInfo(clazz);
    }

    public AbstractQuery insert(String tbl, String[] columns, Object[] objects){
        sql().append("insert into ").append(tbl).append(" (");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            if(i == columns.length - 1){
                sql().append(columns[i])
                        .append(") values(");
                sb.append("?)");
            }else{
                sql().append(columns[i]).append(" , ");
                sb.append("?, ");
            }
            values.add(objects[i]);
        }
        sql().append(sb);
        return this;
    }

    public AbstractQuery update(String tbl){
        sql().append("update ").append(tbl).append(" set ");
        return this;
    }

    public AbstractQuery delete(String tbl){
        sql().append("delete from ")
                .append(tbl)
                .append(' ');
        return this;
    }

    public AbstractQuery select(){
        sql().append("select ");
        return this;
    }

    public AbstractQuery col(String...cols){
        return fill_array_str(cols);
    }

    public AbstractQuery col_as(String[]cols, String[] as){
        for (int i = 0; i < cols.length; i++) {
            sql().append(cols[i]);
            if(i < as.length){
                sql().append(" as ").append(as[i]);
            }
            if(i != cols.length - 1){
                sql().append(',');
            }
        }
        return this;
    }

    public AbstractQuery col_all(String tbl){
        sql().append(tbl).append(".* ");
        return this;
    }

    public AbstractQuery col_count_all_as(String as){
        sql().append("count(*) as ").append(as).append(" ");
        return this;
    }

    public AbstractQuery from(String...tbl){
        sql().append("from ");
        return fill_array_str(tbl);
    }

    public AbstractQuery setParameters(Object value){
        values().add(value);
        return this;
    }

    public AbstractQuery set(String name, Object value){
        sql().append(name).append(" = ? , ");
        values().add(value);
        return this;
    }

    public AbstractQuery set_end(String name, Object value){
        sql().append(name).append(" = ? ");
        values().add(value);
        return this;
    }

    public AbstractQuery set_values(String[] columns, Object[] values){
        for (int i = 0; i < columns.length; i++) {
            if(i != columns.length - 1){
                set(columns[i],values[i]);
            }else {
                set_end(columns[i],values[i]);
            }
        }
        return this;
    }

    public AbstractQuery where(){
        sql().append(" where ");
        return this;
    }

    public AbstractQuery in(){
        sql().append(" in ");
        return this;
    }

    public AbstractQuery not_in(){
        sql().append(" not in ");
        return this;
    }

    public AbstractQuery eq(String name, Object value){
        exp(name,OPERATE_EQUALS, value);
        return this;
    }

    public AbstractQuery const_eq(String name, String value){
        const_exp(name,OPERATE_EQUALS, value);
        return this;
    }

    public AbstractQuery neq(String name, Object value){
        exp(name,OPERATE_NOT_EQUALS, value);;
        return this;
    }

    public AbstractQuery const_neq(String name, String value){
        const_exp(name,OPERATE_NOT_EQUALS, value);;
        return this;
    }

    public AbstractQuery lt(String name, Object value) {
        exp(name,OPERATE_LESS_THAN, value);;
        return this;
    }

    public AbstractQuery const_lt(String name, String value) {
        const_exp(name,OPERATE_LESS_THAN, value);;
        return this;
    }

    public AbstractQuery gt(String name, Object value) {
        exp(name,OPERATE_GREATER_THAN, value);;
        return this;
    }

    public AbstractQuery const_gt(String name, String value) {
        const_exp(name,OPERATE_GREATER_THAN, value);;
        return this;
    }

    public AbstractQuery le(String name, Object value) {
        exp(name,OPERATE_LESS_THAN_AND_EQUALS, value);;
        return this;
    }

    public AbstractQuery const_le(String name, String value) {
        const_exp(name,OPERATE_LESS_THAN_AND_EQUALS, value);;
        return this;
    }

    public AbstractQuery ge(String name, Object value) {
        exp(name,OPERATE_GREATER_THAN_AND_EQUALS, value);;
        return this;
    }

    public AbstractQuery const_ge(String tbl, String name, String value) {
        const_exp(name,OPERATE_GREATER_THAN_AND_EQUALS, value);;
        return this;
    }

    public AbstractQuery and() {
        sql().append(OPERATE_AND);
        return this;
    }

    public AbstractQuery or(String tbl, String name, Object value) {
        sql().append(OPERATE_OR);
        return this;
    }

    public AbstractQuery like() {
        sql().append(" like ");
        return this;
    }

    public AbstractQuery group_by(){
        sql().append(" group by ");
        return this;
    }

    public AbstractQuery ASC(){
        sql().append(" asc ");
        return this;
    }

    public AbstractQuery DESC(){
        sql().append(" desc ");
        return this;
    }

    public AbstractQuery having(){
        sql().append(" having ");
        return this;
    }

    public AbstractQuery order_by(){
        sql().append(" order by ");
        return this;
    }

    public AbstractQuery limit(int row_count){
        sql().append(" limit ")
        .append("? ");
        values().add(row_count);
        return this;
    }

    public AbstractQuery limit(int offset , int row_count){
        sql().append(" limit ")
                .append("?,?");
        values().add(offset);
        values().add(row_count);
        return this;
    }

    public StringBuilder sql() {
        return sql;
    }

    public void sql(StringBuilder sql){
        this.sql = sql;
    }

    public List<Object> values(){
        return values;
    }

    private void exp(String var, String op, Object v){
        sql.append(var).append(op).append(" ? ");
        values().add(v);
    }

    private void const_exp(String var, String op , String v){
        sql.append(var).append(op).append(v).append(' ');
    }

    private AbstractQuery fill_array_str(String[] ls) {
        for (int i = 0; i < ls.length; i++) {
            sql().append(ls[i]);
            if(i != ls.length - 1){
                sql().append(',');
            }
        }
        return this;
    }
}
