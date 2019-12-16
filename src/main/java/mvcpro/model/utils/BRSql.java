package mvcpro.model.utils;

import com.lqing.orm.internal.connection.C3p0ConnectionProvider;
import com.lqing.orm.utils.LoggerUtils;
import org.slf4j.Logger;

import java.io.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BRSql {
    public static final String MYSQL_DUMP = "mysqldump --defaults-extra-file=/etc/my.cnf Fxdb";

    private static Logger LOG = LoggerUtils.getLogger(BRSql.class);

    C3p0ConnectionProvider c3p0ConnectionProvider = new C3p0ConnectionProvider();

    public Boolean backup(File fileDirectory) {
        if(fileDirectory.isDirectory() && fileDirectory.exists()){
            try {
                // 使用策略生成备份文件名
                File file = generateBackUpFileName(fileDirectory);
                if(file.exists() || file.isDirectory()){
                    LOG.error("备份文件路径无效：{}", file.toString());
                    return false;
                }

                // 执行备份命令
                InputStream inputStream = executeBackUpCmd();
                if(inputStream == null){
                    LOG.error("执行备份命令失败!");
                    return false;
                }

                // 写出备份文件
                if(writeBackUpFile(inputStream,new FileOutputStream(file))){
                    LOG.info("数据库备份成功 > {}",file.getAbsolutePath());
                    return true;
                }else{
                    LOG.error("写出备份文件失败");
                    return false;
                }
            } catch (Exception e) {
                LOG.error("备份数据库失败 : {}", e.getMessage());
            }
        }
        return false;
    }

    private File generateBackUpFileName(File fileDirectory){
        return new File(fileDirectory, new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss").format(new Date()) + "-backup.sql");
    }

    private InputStream executeBackUpCmd() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(MYSQL_DUMP);
        if (p.waitFor() == 0) {
            return p.getInputStream();
        }
        return null;
    }

    private boolean writeBackUpFile(InputStream inputStream,OutputStream outputStream)
            throws IOException {
        int needLength = inputStream.available();
        if(needLength > 0){
            byte[] bytes = new byte[needLength];
            if(inputStream.read(bytes) == needLength){
                BufferedOutputStream bos = new BufferedOutputStream(outputStream);
                bos.write(bytes);
                bos.flush();
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public boolean recover(File sqlFilePath){
        if(sqlFilePath.exists() && sqlFilePath.canRead() && sqlFilePath.length() > 0){
            String absolutePath = sqlFilePath.getAbsolutePath();
            try {
                Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","/usr/local/mysql/bin/mysql --defaults-extra-file=/etc/my.cnf Fxdb < " + absolutePath});
                if(p.waitFor() == 0){
                    LOG.info("数据库恢复成功，数据来源 < {}",absolutePath);
                    return true;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @param sql 包含待执行的SQL语句的ArrayList集合
     * @return int 影响的函数
     * @方法描述：批量执行SQL语句
     */
    public int batchDate(ArrayList<String> sql) {
        try {
            Statement st = c3p0ConnectionProvider.getConnection().createStatement();
            for (String subsql : sql) {
                st.addBatch(subsql);
            }
            st.executeBatch();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 以行为单位读取文件，并将文件的每一行格式化到ArrayList中，常用于读面向行的格式化文件
     */
    private static ArrayList<String> readFileByLines(String filePath) throws Exception {
        ArrayList<String> listStr = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), "UTF-8"));
            String tempString = null;
            int flag = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
                if (tempString.trim().equals(""))
                    continue;
                if (tempString.substring(tempString.length() - 1).equals(";")) {
                    if (flag == 1) {
                        sb.append(tempString);
                        listStr.add(sb.toString());
                        sb.delete(0, sb.length());
                        flag = 0;
                    } else
                        listStr.add(tempString);
                } else {
                    flag = 1;
                    sb.append(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return listStr;
    }

    /**
     * 读取文件内容到SQL中执行
     *
     * @param sqlPath SQL文件的路径：如：D:/TestProject/web/sql/脚本.Sql
     */
    public Boolean runSqlByReadFileContent(String sqlPath) {
        try {
            ArrayList<String> sqlStr = readFileByLines(sqlPath);
            if (sqlStr.size() > 0) {
                int num = batchDate(sqlStr);
                if (num > 0){
                    System.out.println("执行成功");
                    return false;
                } else{
                    System.out.println("未有执行的SQL语句");
                    return true;
                }
            } else {
                System.out.println("没有需要执行的SQL语句");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
