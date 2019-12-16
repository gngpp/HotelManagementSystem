package mvcpro.view;



import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
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
    public void start(final Stage stage) {
        stage.setTitle("File Chooser");
        stage.initModality(Modality.APPLICATION_MODAL);
        final FileChooser fileChooser = new FileChooser();
        final DirectoryChooser directoryChooser=new DirectoryChooser();
        final Button openButton_backup = new Button("备份");
        final Button openButton_restore = new Button("恢复");

        openButton_backup.setOnAction(
                (final ActionEvent e) -> {
                    //configureFileChooser(fileChooser);
                    File fileDirectory = directoryChooser.showDialog(stage);
                    BRSql brSql=new BRSql();
                    try {
                        if (brSql.backup(fileDirectory)) {
                            new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","备份成功！").show();
                        }else {
                            new AlertDefined(Alert.AlertType.ERROR,"提示","备份失败！").show();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                });

        openButton_restore.setOnAction(
                (final ActionEvent e) -> {

                    File file=fileChooser.showOpenDialog(new Stage());
                    BRSql brSql=new BRSql();
                        if(file!=null&& brSql.runSqlByReadFileContent(file.getPath()))
                            new AlertDefined(Alert.AlertType.CONFIRMATION,"提示","恢复成功！").show();
                        else
                            new AlertDefined(Alert.AlertType.ERROR,"提示","恢复失败！").show();



                });

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton_backup, 0, 1);
        GridPane.setConstraints(openButton_restore, 1, 1);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton_backup, openButton_restore);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
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

    public static void main(String[] args) {
        Application.launch(args);
    }
}
