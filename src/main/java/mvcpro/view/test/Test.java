package mvcpro.view.test;

import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {
        File file=new File(new File("").getCanonicalPath()+"/src/main/resources/backup/schema/");
        File newFile=new File(file,new SimpleDateFormat("YYYY-MM-dd-mm:hh:ss").format(new Date())+"-backup");
        if (!file.exists()){
            file.mkdir();
        }

        try {
            String mysql = "/usr/local/mysql/bin/mysqldump --opt -h localhost --user=root --password=itcast --result-file="+newFile.toString()+"--default-character-set=utf8.sql FXdb";
            Process p = Runtime.getRuntime().exec(mysql);
            if (p.waitFor() == 0) {// 0 表示线程正常终止。
                System.out.println("导出成功");
            }else {
                System.out.println("导出失败,失败码:"+p.waitFor());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}