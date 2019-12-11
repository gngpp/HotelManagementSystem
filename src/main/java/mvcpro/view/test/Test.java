package mvcpro.view.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String filePath=Test.class.getResource("./")+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+".sql";
        System.out.println(filePath);
        System.out.println(new File(filePath).getAbsolutePath());
    }
}
