package mvcpro.view.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {
        File file=new File(new File("").getCanonicalPath()+"/src/main/resources/backup/schema/");
        File newFile=new File(file,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"my.sql");
        if (!file.exists()){
            file.mkdir();
        }
        if (!newFile.exists()){
            newFile.createNewFile();
        }

        System.out.println(newFile);
    }
}
