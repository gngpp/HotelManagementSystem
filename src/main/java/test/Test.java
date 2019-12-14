package test;

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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File(new File("").getCanonicalPath() + "/src/main/resources/backup/schema/");
        File newFile = new File(file, new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss").format(new Date()) + "-backup");
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println(System.getProperties().get("os.name"));
        System.out.println(newFile);


        //备份
        String mysql="/usr/local/mysql/bin/mysql -h localhost --user=root --password=itcast --result-file=/Users/black-mac/IdeaProjects/HotelManagementSystem-fx/src/main/resources/backup/schema/2019-12-14-09:03:54-backup--default-character-set=utf8.sql FXdb";
        System.out.println(mysql);
//        String mysqldump = "/usr/local/mysql/bin/mysqldump --opt -h localhost --user=root --password=itcast --result-file=" + newFile.toString() + "--default-character-set=utf8.sql FXdb";
//        System.out.println(mysqldump);
//        Process p = Runtime.getRuntime().exec(mysqldump);
//        if (p.waitFor() == 0) {// 0 表示线程正常终止。
//            System.out.println("导出成功");
//        } else {
//            System.out.println("导出失败,失败码:" + p.waitFor());
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Process ps = Runtime.getRuntime().exec(mysql);
        if (ps.waitFor() == 0) {// 0 表示线程正常终止。
            System.out.println("恢复成功");
        } else {
            System.out.println("恢复失败,失败码:" + ps.waitFor());
        }




    }

}

class Demo extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button=new Button("button");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser=new FileChooser();
                File file=fileChooser.showOpenDialog(new Stage());
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Pane pane=new AnchorPane();

        pane.getChildren().add(button);
        primaryStage.setScene(new Scene(pane,300,300));
        primaryStage.show();
    }
}


