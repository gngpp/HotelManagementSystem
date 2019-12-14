package test;

import com.lqing.orm.internal.connection.C3p0ConnectionProvider;
import com.lqing.orm.internal.connection.IConnectionProvide;
import com.sun.javaws.IconUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvcpro.view.FileChooserDefined;
import sun.misc.Launcher;

import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test {

    private  IConnectionProvide connProvider = new C3p0ConnectionProvider();

    public static void main(String[] args) throws Exception {


//        File file = new File(new File("").getCanonicalPath() + "/src/main/resources/backup/schema/");
//        File newFile = new File(file, new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss").format(new Date()) + "-backup");
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        System.out.println(System.getProperties().get("os.name"));
//
//        //备份
//        String mysqldump = "/usr/local/mysql/bin/mysqldump --opt -h localhost --user=root --password=itcast --result-file=" + newFile.toString() + "--default-character-set=utf8.sql FXdb";
//        System.out.println(mysqldump);
//        Process p = Runtime.getRuntime().exec(mysqldump);
//        if (p.waitFor() == 0) {// 0 表示线程正常终止。
//            System.out.println("导出成功");
//        } else {
//            System.out.println("导出失败,失败码:" + p.waitFor());
//        }
        Test test=new Test();
      //  System.out.println(test.readFileByLines("/Volumes/Backup/javaFX期末项目用件/HotelManagementSystem-fx/src/main/resources/backup/schema/2019-12-14-10:23:17-backup--default-character-set=utf8.sql"));

        test.runSqlByReadFileContent("/Volumes/Backup/javaFX期末项目用件/HotelManagementSystem-fx/src/main/resources/backup/schema/2019-12-14-10:34:11-backup--default-character-set=utf8.sql");
    }



    /**
     * @方法描述：批量执行SQL语句
     * url加上，多条sql语句执行，allowMultiQueries=true
     * @param sql 包含待执行的SQL语句的ArrayList集合
     * @return int 影响的函数
     */
    public int batchDate(ArrayList<String> sql){
        try {
            Statement st = connProvider.getConnection().createStatement();
            for(String subsql :sql){
                st.addBatch(subsql);
            }
            st.executeBatch();
            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    private ArrayList<String> readFileByLines(String filePath) throws Exception {
        ArrayList<String> listStr=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filePath), "UTF-8"));
            String tempString = null;
            int flag=0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                // System.out.println("line " + line + ": " + tempString);
                if(tempString.trim().equals(""))
                    continue;
                if(tempString.substring(tempString.length()-1).equals(";")){
                    if(flag==1){
                        sb.append(tempString);
                        listStr.add(sb.toString());
                        sb.delete(0,sb.length());
                        flag=0;
                    }
                    else
                        listStr.add(tempString);
                }else{
                    flag=1;
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
     * @param sqlPath SQL文件的路径：如：D:/TestProject/web/sql/脚本.Sql
     */
    public void runSqlByReadFileContent(String sqlPath) {
        try {
            ArrayList<String> sqlStr = readFileByLines(sqlPath);
            System.out.println(sqlStr);
            if (sqlStr.size() > 0) {
                int num = batchDate(sqlStr);
                if (num > 0)
                    System.out.println("执行成功");
                else
                    System.out.println("未有执行的SQL语句");
            } else {
                System.out.println("没有需要执行的SQL语句");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



