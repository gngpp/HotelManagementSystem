package mvcpro.model.utils;

import com.lqing.orm.internal.connection.C3p0ConnectionProvider;

import java.io.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BRSql {
    C3p0ConnectionProvider c3p0ConnectionProvider=new C3p0ConnectionProvider();

    public Boolean backup(File fileDirectory) throws IOException, InterruptedException {
//        File file = new File(new File("").getCanonicalPath() + "/src/main/resources/backup/schema/");
        File newFile = new File(fileDirectory, new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss").format(new Date()) + "-backup");

        if (System.getProperties().get("os.name").equals("Mac OS X")){
            System.out.println(System.getProperties().get("os.name"));
            //备份                                                                                                               //文件绝对路径
            String mysqldump = "/usr/local/mysql/bin/mysqldump --opt -h localhost --user=root --password=itcast --result-file=" + newFile.toString() + "--default-character-set=utf8.sql FXdb";
            System.out.println(mysqldump);
            Process p = Runtime.getRuntime().exec(mysqldump);

            // 0 表示线程正常终止。
            if (p.waitFor() == 0) {
                System.out.println("导出成功");
                return true;
            } else {
                System.out.println("导出失败,失败码:" + p.waitFor());
                return false;
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
