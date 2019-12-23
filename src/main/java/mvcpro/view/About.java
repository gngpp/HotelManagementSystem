package mvcpro.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mvcpro.controlled.AboutController;

import java.awt.*;

public class About extends Application {

    private double lastx_distance;
    private double lasty_distance;
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/ui_about_layout.fxml"));
        Pane root=loader.load();
        AboutController aboutController=loader.getController();
        aboutController.setStage(primaryStage);
        //
        //设置背景颜色
        //
        Background bg=new Background(new BackgroundFill(Color.valueOf("#282828BF"),new CornerRadii(7),new Insets(0)));
        root.setBackground(bg);
        Scene scene=new Scene(root);

        //
        //加载CSS文件
        //

        scene.setFill(Paint.valueOf("#00000000"));
        primaryStage.getIcons().add(new Image(getClass().getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();

        scene.setOnMousePressed(event -> {
            lastx_distance=event.getScreenX()-primaryStage.getX();
            lasty_distance=event.getScreenY()-primaryStage.getY();

        });

        scene.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX()-lastx_distance);
            primaryStage.setY(event.getScreenY()-lasty_distance);

        });

    }
}
