package mvcpro.view;



import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvcpro.model.utils.BRSql;

public final class FileChooserDefined extends Application {

    private final Desktop desktop = Desktop.getDesktop();

    @Override
    public void start( Stage stage) {

        stage.setTitle("数据库备份与恢复");
        stage.initModality(Modality.APPLICATION_MODAL);
        final FileChooser fileChooser = new FileChooser();
        final DirectoryChooser directoryChooser=new DirectoryChooser();
        final Button openButton_backup = new Button("备份");
        final Button openButton_restore = new Button("恢复");

        openButton_backup.setOnAction(event-> {

            File fileDirectory = directoryChooser.showDialog(stage);
            BRSql brSql = new BRSql();

            if(System.getProperties().get("os.name").equals("Windows 10")){

                try {
                    File file = new File(fileDirectory, new SimpleDateFormat("YYYY-MM-dd-hh:mm:ss").format(new Date()) + "-backup.sql");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    brSql.exportDbSql("localhost","3306","root","itcast",fileDirectory.getAbsolutePath(),file.getName(),"FXdb");
                    new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","备份成功！").show();
                } catch (Exception e) {
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

            if (System.getProperties().get("os.name").equals("Windows 10")){
                try {
                    brSql.restoreDbBySql("localhost","3306","root","itcast",file.getAbsolutePath(),"FXdb");
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


        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton_backup, 0, 1);
        GridPane.setConstraints(openButton_restore, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton_backup, openButton_restore);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(0, 50, 12, 50));

        stage.setScene(new Scene(rootGroup,200,50));
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
