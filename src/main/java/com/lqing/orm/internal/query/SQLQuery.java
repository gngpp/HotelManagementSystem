package com.lqing.orm.internal.query;

import com.lqing.orm.internal.query.converter.ConverterFactory;
import com.lqing.orm.internal.query.converter.IResultSetConverter;
import com.lqing.orm.utils.LoggerUtils;
import org.slf4j.Logger;

import java.sql.*;
import java.util.List;

public class SQLQuery extends AbstractQuery{
    private static Logger LOG = LoggerUtils.getLogger(SQLQuery.class);
    private static IResultSetConverter ENTITY_CONVERTER = ConverterFactory
            .converter("com.lqing.orm.internal.query.converter.EntityConverter");
    private Connection conn ;
    private ResultSet rs;
    private PreparedStatement ps;

    public SQLQuery(Connection conn){
        this.conn = conn;
    }

    public SQLQuery(Connection conn, StringBuilder sb){
        this.conn = conn;
        sql(sb);
    }

    @Override
    public boolean exec() throws SQLException {
        LOG.info(sql().toString());
        return setParameters().executeUpdate() >= 0;
    }

    @Override
    public boolean exec_and_close() throws SQLException {
        LOG.info(sql().toString());
        boolean success =  setParameters().executeUpdate() >= 0;
        close();
        return success;
    }

    @Override
    public Object query_unique() throws Exception {
        return query_unique(ENTITY_CONVERTER);
    }

    @Override
    public Object query_unique(IResultSetConverter converter)
            throws Exception {
        LOG.info(sql().toString());
        rs = setParameters().executeQuery();
        if(rs.next()){
            if(converter == null){
                return rs;
            }else {
                return converter.convert(rs);
            }
        }else {
            return null;
        }
    }

    @Override
    public <T> void query_list(List<T> list) throws Exception {
        query_list(ENTITY_CONVERTER,list);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> void query_list(IResultSetConverter converter, List<T> list)
            throws Exception {
        LOG.info(sql().toString());
        rs = setParameters().executeQuery();
        while (rs.next()){
            list.add(converter == null? (T) rs : (T) converter.convert(rs));
        }
    }

    public void reset(){
        sql(new StringBuilder());
        values().clear();
    }

    @Override
    public void close() throws SQLException {
        if(conn != null)
            conn.close();
        if(ps != null)
            ps.close();
        if(rs != null)
            rs.close();
    }

    private PreparedStatement setParameters() throws SQLException {
        ps = conn.prepareStatement(sql().toString());
        sql(new StringBuilder());
        for (int i = 1; i <= values().size(); i++) {
            Object v = values().get(i - 1);
            if(v == null){
                ps.setNull(i, Types.NULL);
            }else{
                ps.setObject(i, v);
            }
        }
        values().clear();
        return ps;
    }

}
