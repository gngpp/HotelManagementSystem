package com.lqing.orm.internal.connection;

import com.lqing.orm.utils.LoggerUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <p>
 *     C3P0数据连接池
 * </p>
 */
public class C3p0ConnectionProvider implements IConnectionProvide {
    private static Logger LOG = LoggerUtils.getLogger(C3p0ConnectionProvider.class);
    private static ComboPooledDataSource dataSource ;

    static{
        dataSource = new ComboPooledDataSource();
    }
    @Override
    public Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (Exception e){
            LOG.error("[getConnection] " + e.getMessage());
            return null;
        }
    }
    @Override
    @Deprecated
    public void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (Exception e){
            LOG.error("[closeConnection] " + e.getMessage());
        }
    }
}
