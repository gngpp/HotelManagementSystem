package mvcpro.view;



import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import mvcpro.model.utils.BRSql;

public final class FileChooserDefined extends Application {

    private final Desktop desktop = Desktop.getDesktop();
    private TextField txf_root =new TextField();
    private PasswordField psf_password=new PasswordField();

    @Override
    public void start( Stage stage) {

        stage.setTitle("数据库备份与恢复");
        stage.initModality(Modality.APPLICATION_MODAL);
        final FileChooser fileChooser = new FileChooser();
        final DirectoryChooser directoryChooser=new DirectoryChooser();
        final Button openButton_backup = new Button("备份");
        final Button openButton_restore = new Button("恢复");
        txf_root.setPromptText("User");
        txf_root.setPrefWidth(50);
        psf_password.setPromptText("Password");
        psf_password.setPrefWidth(100);

        openButton_backup.setOnAction(event-> {

            File fileDirectory = directoryChooser.showDialog(stage);
            BRSql brSql = new BRSql();

            if(System.getProperties().get("os.name").equals("Windows 10")||
                    System.getProperties().get("os.name").equals("Windows 7")){

                try {
                    /*
                    windows平台不能使用-命名。。。
                     */
                    File file = new File(fileDirectory, new SimpleDateFormat("YYYY_MM_dd___hh_mm_ss").format(new Date()) + "_ToBackup.sql");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    brSql.exportDbSql("localhost","3306",txf_root.getText(),psf_password.getText(),fileDirectory.getAbsolutePath(),file.getName(),"FXdb");
                    new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","备份成功！").show();
                } catch (Exception e) {
                    new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","备份失败！").show();
                    e.printStackTrace();
                }
            }

            if(System.getProperties().get("os.name").equals("Mac OS X")){
                if (fileDirectory!=null&& brSql.backup(fileDirectory)) {
                    new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","备份成功！").show();
                }
            }

        });


        openButton_restore.setOnAction((event -> {

            File file = fileChooser.showOpenDialog(new Stage());
            BRSql brSql = new BRSql();

            if (System.getProperties().get("os.name").equals("Windows 10")||
                    System.getProperties().get("os.name").equals("Windows 7")){
                try {
                    brSql.restoreDbBySql("localhost","3306",txf_root.getText(),psf_password.getText(),file.getAbsolutePath(),"FXdb");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(System.getProperties().get("os.name").equals("Mac OS X")){
                if(file !=null && !file.isDirectory() && file.exists()&& brSql.recover(file)){
                    new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","恢复成功！").show();
                }
            }

        }));


        final FlowPane flowPane = new FlowPane();

        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));//设置
        flow.setVgap(4);//设置节点间垂直间隔
        flow.setHgap(4);//设置节点间水平间隔
        flow.setPrefWrapLength(100); // 设置FlowPane的宽度

        GridPane.setConstraints(openButton_backup, 0, 1);
        GridPane.setConstraints(openButton_restore, 1, 1);
        flowPane.setHgap(6);
        flowPane.setVgap(6);
        flowPane.getChildren().addAll(openButton_backup, openButton_restore);
        flowPane.getChildren().add(txf_root);
        flowPane.getChildren().add(psf_password);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(flowPane);
        rootGroup.setPadding(new Insets(0, 50, 12, 50));

        ScaleTransition st=new ScaleTransition(Duration.millis(700),rootGroup);
        st.setFromX(0.1);
        st.setToX(1);
        st.setFromY(0.1);
        st.setToY(1);
        st.play();

        if(!System.getProperties().get("os.name").equals("Windows 10")||
                !System.getProperties().get("os.name").equals("Windows 7")){
            txf_root.setVisible(true);
            psf_password.setVisible(true);
            stage.setScene(new Scene(rootGroup,360,30));

        }else {
            txf_root.setVisible(false);
            psf_password.setVisible(false);
            stage.setScene(new Scene(rootGroup,200,30));
        }

        stage.show();
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("SQL", "*.sql")
        );
    }


    private void openFile(File file) {
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(FileChooserDefined.
                        class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        });
    }

}
