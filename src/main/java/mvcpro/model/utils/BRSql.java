package mvcpro.model.utils;

import com.lqing.orm.internal.connection.C3p0ConnectionProvider;
import com.lqing.orm.utils.LoggerUtils;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
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
        Process p=Runtime.getRuntime().exec(MYSQL_DUMP);
        LOG.info("返回路径：{}",p.getInputStream());
        // Process p = Runtime.getRuntime().exec(MYSQL_DUMP);
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
                    LOG.info("执行成功");
                    return false;
                } else{
                    LOG.info("未有执行的SQL语句");
                    return true;
                }
            } else {
                LOG.info("没有需要执行的SQL语句");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        exportDbSql("localhost","3306","root","itcast","C:\\Users\\Windows\\Desktop","my.sql","FXdb");
    }

    /**
     * 导出sql文件
     * 采用Apache的command-exec来执行命令
     * @param host ip地址
     * @param port 端口
     * @param userName 账号
     * @param password 密码
     * @param savePath sql文件保存路径
     * @param fileName 文件名
     * @param databaseName 要备份的数据库名
     * @return
     */

    public static void exportDbSql(String host,String port, String userName, String password, String savePath, String fileName, String databaseName) throws Exception {

        LOG.debug("mysqlDumpApi.exportDbSql,param:host={},port={},userName={},password={},savePath={},fileName={},databaseName={}",
                host,port, userName, password, savePath, fileName, databaseName);

        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if(!savePath.endsWith(File.separator)){
            savePath = savePath + File.separator;
        }

        FileOutputStream fos = null;
        ByteArrayOutputStream errorStream = null;
        try {
            // 拼接命令
            CommandLine command = new CommandLine("mysqldump");
            command.addArgument("-h"+host);
            command.addArgument("-P"+port);
            command.addArgument("-u"+userName);
            command.addArgument("-p"+password);
            command.addArgument(databaseName);

            LOG.debug("mysqlDumpApi.exportDbSql,command:{}",command.toString());

            DefaultExecutor executor=new DefaultExecutor();
            //导出到文件
            fos=new FileOutputStream(savePath+fileName);
            //命令执行的错误信息
            errorStream = new ByteArrayOutputStream();
            //fos为标准输出流，errorStream为错误输出流，这里一定要传这两个参数，否则最终生成的文件中会包含警告信息，导致恢复时无法恢复
            executor.setStreamHandler(new PumpStreamHandler(fos, errorStream));

            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            executor.execute(command,resultHandler);

            //等待子线程完成
            resultHandler.waitFor();
            //获取执行的返回值
            int exitValue=resultHandler.getExitValue();
            String errorStreamStr=errorStream.toString();
            /*
                判断命令执行是否成功。
                exitValue==0表示成功，如果错误信息中存在ERROR也认为失败
             */
            if (exitValue!=0 || errorStreamStr.contains("ERROR")) {
                LOG.error("mysqlDumpApi.exportDbSql executor fail.errorMsg:{}",errorStreamStr);
                throw new Exception("mysqlDumpApi.exportDbSql executor fail errorMsg:"+errorStreamStr);
            }

        }catch (Exception e) {
            LOG.error("mysqlDumpApi.exportDbSql fail.",e);
            throw new Exception("mysqlDumpApi.exportDbSql fail",e);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (IOException e) {
                LOG.error("mysqlDumpApi.exportDbSql fail.",e);
                throw new Exception("mysqlDumpApi.exportDbSql fail",e);
            }
        }
    }


    /**
     * 恢复数据
     * @param host
     * @param port
     * @param userName
     * @param password
     * @param sqlPath
     * @param databaseName
     * @return
     */
    public static void restoreDbBySql(String host,String port,String userName,String password,String sqlPath,String databaseName) throws Exception {

        LOG.debug("mysqlDumpApi.restoreDbBySql,param:host={},port={},userName={},password={},sqlPath={},databaseName={}",
                host,port, userName, password, sqlPath, databaseName);


        ByteArrayOutputStream outputStream = null;
        ByteArrayOutputStream errorStream = null;
        InputStream inputStream = null;

        try {

            CommandLine command = new CommandLine("mysql");
            command.addArgument("-h"+host);
            command.addArgument("-P"+port);
            command.addArgument("-u"+userName);
            command.addArgument("-p"+password);
            command.addArgument(databaseName);

            LOG.debug("mysqlDumpApi.restoreDbBySql,command:{}",command.toString());

            DefaultExecutor executor=new DefaultExecutor();
            outputStream = new ByteArrayOutputStream();
            errorStream = new ByteArrayOutputStream();
            //sql文件路径
            inputStream = new FileInputStream(sqlPath);

            PumpStreamHandler psHandler=new PumpStreamHandler(outputStream,errorStream,inputStream);
            executor.setStreamHandler(psHandler);

            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            executor.execute(command,resultHandler);

            resultHandler.waitFor();
            int exitValue = resultHandler.getExitValue();
            String errorStreamStr=errorStream.toString();
            /*
                判断命令执行是否成功。
                exitValue==0表示成功，如果错误信息中存在ERROR也认为失败
             */
            if (exitValue!=0 || errorStreamStr.contains("ERROR")) {
                LOG.error("mysqlDumpApi.restoreDbBySql executor fail.errorMsg:{}",errorStreamStr);
                throw new Exception("mysqlDumpApi.restoreDbBySql executor fail errorMsg:"+errorStreamStr);
            }
        } catch (Exception e) {
            LOG.error("mysqlDumpApi.restoreDbBySql fail.",e);
            throw new Exception("mysqlDumpApi.restoreDbBySql fail",e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (errorStream != null) {
                    errorStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOG.error("mysqlDumpApi.restoreDbBySql fail.",e);
                throw new Exception("mysqlDumpApi.restoreDbBySql fail",e);
            }
        }
    }


}

